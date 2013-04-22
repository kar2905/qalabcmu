package edu.cmu.lti.qalab.mingyans_annotators;

import java.util.ArrayList;

import org.apache.uima.analysis_component.JCasAnnotator_ImplBase;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.jcas.JCas;

import edu.cmu.lti.qalab.types.Answer;
import edu.cmu.lti.qalab.types.QuestionAnswerSet;
import edu.cmu.lti.qalab.types.Token;
import edu.cmu.lti.qalab.utils.Utils;

/**
 * This annotator is used for calculating the probability of each answer in the
 * question.
 * 
 * The way for calculation is TF*IDF
 * 
 * @author mingyans
 * 
 */
public class AnswerProbCalculation extends JCasAnnotator_ImplBase {
	@Override
	public void process(JCas jCas) throws AnalysisEngineProcessException {

		System.out
				.println("\n--------------------------------------\nAnswer Probability Calculation\n------------------------------------------\n");

		ArrayList<QuestionAnswerSet> qaSet = Utils.getQuestionAnswerSet(jCas);
		int index=0;
		for (QuestionAnswerSet qa : qaSet) {
			String window = new WindowScoreCal().candidatewindow.get(index);
			String[] windows = window.split(" ");
			int size = windows.length;
			ArrayList<Answer> ansList = Utils.getAnswerListFromQASet(qa);
			int[] total = new int[ansList.size()];
			int i = 0;
			int max = 0;

			for (Answer an : ansList) {
				ArrayList<Token> ansToken = Utils.getTokenlistFromAnwser(an);
				int freq = 0;
				for (Token token : ansToken) {
					for (String w : windows) {
						if (w.contains(token.getText())) {
							freq++;
						}
					}
				}
				total[i] += freq;
				if (max < freq)
					max = freq;
				i++;
			}
			int tot = 0;
			for (int k = 0; k < ansList.size(); k++) {
				tot += total[k];
			}
			int k = 0;
			for (Answer an : ansList) {
				if (max == total[k]) {
					an.setIsSelected(true);
					max = -1;
				} else if (max == 0) {
					an.setIsSelected(true);
					max = -1;
				}
				double prob = 0.0;
				if (tot == 0)
					an.setProb(prob);
				else
					prob = (double) total[k] / tot;
				
				System.out.println(k+1 + " " + prob);
				an.addToIndexes();
				k++;
			}
			System.out.println("-------");
		}
	}
}
