package edu.cmu.lti.qalab.casconsumers;

import java.io.File;

import org.apache.uima.cas.CAS;
import org.apache.uima.cas.CASException;
import org.apache.uima.collection.CasConsumer_ImplBase;
import org.apache.uima.jcas.JCas;
import org.apache.uima.resource.ResourceProcessException;

public class QA4MRECasConsumer extends CasConsumer_ImplBase {

	int mDocNum;
	File mOutputFile = null;
	
	double THRESHOLD = 4.0;

	@Override
	public void initialize() {

		mDocNum = 0;
		try {
			mOutputFile = new File(
					(String) getConfigParameterValue("OUTPUT_DIR"));

			
			THRESHOLD = Double
					.parseDouble((String) getConfigParameterValue("THRESHOLD"));
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

		String text=jcas.getDocumentText();
		try {
			System.out.println(text);		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	/**
	 * Adjusts the offsets of annotation by removing whitespace
	 * @param orgSentence
	 * @param beforeIdx
	 * @return
	 */
	public int nSpaces(String orgSentence, int beforeIdx) {

		String sentence = orgSentence.substring(0, beforeIdx);
		int count = 0;
		while (sentence.indexOf(" ") > -1) {
			sentence = sentence.replaceFirst(" ", "");
			count++;
		}
		return count;

	}

	/**
	 * Closes the file and other resources initialized during the process
	 * 
	 */
	@Override
	public void destroy() {

	}
}
