package edu.cmu.lti.qalab.casconsumers;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

import org.apache.solr.common.SolrInputDocument;
import org.apache.solr.schema.IndexSchema;
import org.apache.uima.cas.CAS;
import org.apache.uima.cas.CASException;
import org.apache.uima.collection.CasConsumer_ImplBase;
import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.cas.FSList;
import org.apache.uima.resource.ResourceProcessException;

import edu.cmu.lti.oaqa.core.provider.solr.SolrWrapper;
import edu.cmu.lti.qalab.solrutils.SolrUtils;
import edu.cmu.lti.qalab.types.Dependency;
import edu.cmu.lti.qalab.types.NER;
import edu.cmu.lti.qalab.types.NounPhrase;
import edu.cmu.lti.qalab.types.Sentence;
import edu.cmu.lti.qalab.types.TestDocument;
import edu.cmu.lti.qalab.utils.Utils;

public class QA4MRESourceDocCasIndexerConsumer extends CasConsumer_ImplBase {

	int mDocNum;
	File mOutputFile = null;
	SolrWrapper wrapper;
	String serverUrl;
	IndexSchema indexSchema;
	String coreName;
	String schemaName;

	double THRESHOLD = 4.0;

	@Override
	public void initialize() {

		serverUrl = (String) getConfigParameterValue("SOLR_SERVER_URL");
		coreName = (String) getConfigParameterValue("SOLR_CORE");
		schemaName = (String) getConfigParameterValue("SCHEMA_NAME");

		try {
			this.wrapper = new SolrWrapper(serverUrl);
		} catch (Exception e) {

			e.printStackTrace();

		}

	}

	@Override
	public void processCas(CAS aCAS) throws ResourceProcessException {
		JCas jCas;
		try {
			jCas = aCAS.getJCas();
		} catch (CASException e) {
			throw new ResourceProcessException(e);
		}

		TestDocument testDoc = Utils.getTestDocumentFromCAS(jCas);// (TestDocument)
																	// jCas.getAnnotationIndex(TestDocument.type);

		try {
			// try to get indexschema so that you can know the fields available
			indexSchema = SolrUtils.getIndexSchema(serverUrl, coreName,
					schemaName);

			String id = testDoc.getId();

			ArrayList<Sentence> sentenceList = Utils.fromFSListToCollection(testDoc.getSentenceList(), Sentence.class);
			for (int i = 0; i < sentenceList.size(); i++) {
				Sentence sent = sentenceList.get(i);
				String sentText = sent.getText();
				String sentId = id + "_" + i;
				HashMap<String, Object> indexMap = new HashMap<String, Object>();
				indexMap.put("docid", id);
				indexMap.put("id", sentId);
				indexMap.put("text", sentText);

				FSList fsNounList = sent.getPhraseList();
				ArrayList<NounPhrase> nounPhrases = Utils
						.fromFSListToCollection(fsNounList, NounPhrase.class);
				indexMap.put("nounphrases", nounPhrases);

				FSList fsNEList = sent.getNerList();
				ArrayList<NER> namedEntities = Utils.fromFSListToCollection(
						fsNEList, NER.class);
				indexMap.put("namedentities", namedEntities);

				FSList fsDependencies = sent.getDependencyList();
				ArrayList<Dependency> dependencies = Utils
						.fromFSListToCollection(fsDependencies,
								Dependency.class);
				indexMap.put("dependencies", dependencies);
				SolrInputDocument solrInpDoc = this.wrapper
						.buildSolrDocument(indexMap);
				
				String docXML = this.wrapper.convertSolrDocInXML(solrInpDoc);

				// System.out.println(docXML);

				this.wrapper.indexDocument(docXML);
				this.wrapper.indexCommit();

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * Closes the file and other resources initialized during the process
	 * 
	 */
	@Override
	public void destroy() {

	}
}
