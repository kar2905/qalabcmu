package edu.cmu.lti.qalab.mingyans_annotators;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.uima.analysis_component.JCasAnnotator_ImplBase;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.cas.FSIterator;
import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.cas.FSList;
import org.apache.uima.jcas.tcas.Annotation;

import edu.cmu.lti.qalab.types.Question;
import edu.cmu.lti.qalab.types.QuestionAnswerSet;
import edu.cmu.lti.qalab.types.Sentence;
import edu.cmu.lti.qalab.types.TestDocument;
import edu.cmu.lti.qalab.types.Token;
import edu.cmu.lti.qalab.utils.Utils;

/**
 * This annotator is used for proceed the Document into token list
 * 
 * The way of tokenlization is StanfordNLP
 * 
 * @author mingyans
 * 
 */
public class WindowScoreCal extends JCasAnnotator_ImplBase {
	
	protected ArrayList<String> candidatewindow = new ArrayList<String>();
	
	@Override
	public void process(JCas jCas) throws AnalysisEngineProcessException {

		System.out
				.println("\n------------------------------------------\nWindowScoreCal\n------------------------------------------\n");

		TestDocument testDoc = Utils.getTestDocumentFromCAS(jCas);
		ArrayList<QuestionAnswerSet> qaSet = Utils.getQuestionAnswerSet(jCas);

		for (QuestionAnswerSet qa : qaSet) {

			ArrayList<Token> quesTokens = Utils.getTokenlistFromQuestion(qa
					.getQuestion());

			
			ArrayList<Sentence> windows=getSenList(testDoc);
			int size = windows.size();

			ArrayList<double[]> TF = new ArrayList<double[]>();
			HashMap<String, Integer> IDFtable = new HashMap<String, Integer>();
			HashMap<Sentence, Double> scores = new HashMap<Sentence, Double>();

			for (Sentence sen : windows) {
				ArrayList<Token> wintokenList=getTokList(sen);
				String windowstr="";
				for(Token t:wintokenList){
					windowstr+=t.getText()+" ";
				}
				String[] wintokens = windowstr.split(" ");
						
				double[] tf = new double[quesTokens.size()];
				int i = 0;
				for (Token token : quesTokens) {
					// System.out.println("$$$$$$$$" + token.getText());
					int freq = 0;
					String t = token.getText();
					if (windowstr.contains(t)) {
						if (IDFtable.containsKey(t)) {
							int freq_window = IDFtable.get(t);
							IDFtable.put(t, freq_window + 1);
						} else
							IDFtable.put(t, 1);
					}
					for (String s : wintokens) {
						// System.out.println("!!!!!!!" + s);
						if (s.contains(t) || s.equals(t) || t.contains(s)) {
							freq++;
						}
					}
					tf[i] = (double) freq / wintokens.length;
					i++;
				}
				TF.add(tf);
			}
			int index = 0;
			for (Sentence sen : windows) {
				double score = 0.0;
				double[] tf = TF.get(index);
				int i = 0;
				for (Token token : quesTokens) {
					if (IDFtable.containsKey(token.getText())) {
						score += (double) tf[i]
								* (size / IDFtable.get(token.getText()));
						i++;
					}
				}
				index++;
				scores.put(sen, score);
			}

			List<Map.Entry<Sentence, Double>> srtList = new ArrayList<Map.Entry<Sentence, Double>>(
					scores.entrySet());
			Collections.sort(srtList,
					new Comparator<Map.Entry<Sentence, Double>>() {
						public int compare(Map.Entry<Sentence, Double> o1,
								Map.Entry<Sentence, Double> o2) {
							if (o2.getValue() != null
									&& o1.getValue() != null
									&& o2.getValue().compareTo(o1.getValue()) > 0) {
								return 1;
							} else {
								return -1;
							}

						}
					});

			int i = 0;
			String window="";
			while (i < srtList.size() && i < 5) {
				window += srtList.get(i).toString();
				i++;
			}
			System.out.println("!!!!!!" + window);
			candidatewindow.add(window);
		}
	}
	
	public ArrayList<Sentence> getSenList(TestDocument testDoc) {
		
		FSList senList = testDoc.getSentenceList();
		ArrayList<Sentence> sList = new ArrayList<Sentence>();
		int i = 0;
		while (true) {

			Sentence sen = null;
			try {
				sen = (Sentence) senList.getNthElement(i);
			} catch (Exception e) {
				break;
			}
			sList.add(sen);
			i++;
		}
		return sList;
	}
	
	public ArrayList<Token> getTokList(Sentence sen) {
		
		FSList tList = sen.getTokenList();
		ArrayList<Token> stList = new ArrayList<Token>();
		int i = 0;
		while (true) {

			Token st = null;
			try {
				st = (Token) tList.getNthElement(i);
			} catch (Exception e) {
				break;
			}
			stList.add(st);
			i++;
		}
		return stList;
	}
}
