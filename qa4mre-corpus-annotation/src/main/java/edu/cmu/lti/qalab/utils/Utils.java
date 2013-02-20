package edu.cmu.lti.qalab.utils;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.uima.cas.FSIterator;
import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.cas.FSList;
import org.apache.uima.jcas.cas.TOP;
import org.uimafit.util.JCasUtil;

import edu.cmu.lti.qalab.types.Sentence;
import edu.cmu.lti.qalab.types.SourceDocument;

public class Utils {

	public static SourceDocument getSourceDocumentFromCAS(JCas jCas) {
		FSIterator it = jCas.getAnnotationIndex(SourceDocument.type).iterator();
		SourceDocument srcDoc = null;
		if (it.hasNext()) {
			srcDoc = (SourceDocument) it.next();
		}
		return srcDoc;
	}

	public static ArrayList<Sentence> getSentenceListFromCAS(JCas jCas) {

		SourceDocument srcDoc = Utils.getSourceDocumentFromCAS(jCas);
		FSList sentList = srcDoc.getSentenceList();
		ArrayList<Sentence> sentenceList = new ArrayList<Sentence>();
		int i = 0;
		while (true) {

			Sentence sentence = null;
			try {
				sentence = (Sentence) sentList.getNthElement(i);
			} catch (Exception e) {
				break;
			}
			sentenceList.add(sentence);
		}

		return sentenceList;
	}

	public <T extends TOP> ArrayList<T> iterateFSList(FSList list,
			Class<T> classType) {

		Collection<T> myCollection = JCasUtil.select(list, classType);
		/*
		 * for(T element:myCollection){ System.out.println(.getText()); }
		 */

		return new ArrayList<T>(myCollection);
	}

}
