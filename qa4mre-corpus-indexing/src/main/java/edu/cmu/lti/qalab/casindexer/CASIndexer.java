package edu.cmu.lti.qalab.casindexer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import org.apache.solr.schema.IndexSchema;
import org.apache.uima.UimaContext;
import org.apache.uima.analysis_component.JCasAnnotator_ImplBase;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.cas.FSList;
import org.apache.uima.jcas.cas.TOP;
import org.apache.uima.resource.ResourceInitializationException;
import org.uimafit.util.JCasUtil;

import edu.cmu.lti.oaqa.core.provider.solr.SolrWrapper;
import edu.cmu.lti.qalab.solrutils.SolrUtils;
import edu.cmu.lti.qalab.types.Sentence;
import edu.cmu.lti.qalab.types.SourceDocument;

public class CASIndexer extends JCasAnnotator_ImplBase {

	SolrWrapper wrapper;
	String serverUrl;
	IndexSchema indexSchema;
	String coreName;
	String schemaName;

	@Override
	public void initialize(UimaContext context)
			throws ResourceInitializationException {
		super.initialize(context);
		serverUrl = (String) context.getConfigParameterValue("SOLR_SERVER_URL");
		coreName = (String) context.getConfigParameterValue("SOLR_CORE");
		schemaName = (String) context.getConfigParameterValue("SCHEMA_NAME");

		try {
			this.wrapper = new SolrWrapper(serverUrl);
		} catch (Exception e) {
			throw new ResourceInitializationException(e);
		}
	}

	@Override
	public void process(JCas jCas) throws AnalysisEngineProcessException {

		SourceDocument srcDoc = (SourceDocument) jCas
				.getAnnotationIndex(SourceDocument.type);

		try {
			// try to get indexschema so that you can know the fields available
			indexSchema = SolrUtils.getIndexSchema(serverUrl, coreName, schemaName);
			HashMap<String, Object> indexMap = new HashMap<String, Object>();

			String id = srcDoc.getId();
			// indexMap

			String docText = srcDoc.getText();
			// use copyfield and dynamic field for sentences
			// copyfield sentence, dynamicfield sentence_*
			// programmatically * is replaced by actual sentence number
			// donot index sentence whose boolean filter is set true

			ArrayList<Sentence> sentenceList = this.getCollectionFromFSList(
					srcDoc.getSentenceList(), Sentence.class);
			for (int i = 0; i < sentenceList.size(); i++) {

			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public <T extends TOP> ArrayList<T> getCollectionFromFSList(FSList list,
			Class<T> classType) {

		Collection<T> myCollection = JCasUtil.select(list, classType);
		return new ArrayList<T>(myCollection);
	}

}
