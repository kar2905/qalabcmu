package edu.cmu.lti.qalab.casconsumers;

import java.io.File;

import org.apache.solr.schema.IndexSchema;
import org.apache.uima.cas.CAS;
import org.apache.uima.cas.CASException;
import org.apache.uima.collection.CasConsumer_ImplBase;
import org.apache.uima.jcas.JCas;
import org.apache.uima.resource.ResourceProcessException;

import edu.cmu.lti.oaqa.core.provider.solr.SolrWrapper;

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

		JCas jcas;
		try {
			jcas = aCAS.getJCas();
		} catch (CASException e) {
			throw new ResourceProcessException(e);
		}

		String text = jcas.getDocumentText();
		try {
			System.out.println(text);
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
