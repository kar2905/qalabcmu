package edu.cmu.lti.qalab.annotators;


import org.apache.uima.UimaContext;
import org.apache.uima.analysis_component.JCasAnnotator_ImplBase;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.cas.FSIterator;
import org.apache.uima.cas.FeatureStructure;
import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.cas.FSList;
import org.apache.uima.jcas.cas.NonEmptyFSList;
import org.apache.uima.jcas.tcas.Annotation;
import org.apache.uima.resource.ResourceInitializationException;

import edu.cmu.lti.qalab.types.Answer;
import edu.cmu.lti.qalab.types.Question;
import edu.cmu.lti.qalab.types.QuestionAnswerSet;
import edu.cmu.lti.qalab.types.TestDocument;

/**
 * This class annotates answers to each question in the reading document in the following way:
 * (1). With probability PROB, this class assigns answer item one as the "selected answer" to a given 
 * question. 
 * (2). With probability 1-PROB, this class assigns no answer (unanswered) to a given question.
 * 
 * This class is to test NaiveScorerCasConsumer's implementation of C@1 score. 
 * 
 * @author Yibin Lin
 *
 */
public class NaiveAnswerQuestionAnnotator extends JCasAnnotator_ImplBase {
	double PROB = 0.8;
	public void initialize(UimaContext aContext) throws ResourceInitializationException {
	    super.initialize(aContext);
	    PROB = 0.8;
	}

	
	@Override
	public void process(JCas jCas) throws AnalysisEngineProcessException {
		FSIterator<Annotation> it = jCas.getAnnotationIndex().iterator();
		
		while (it.hasNext()) {
			Annotation an = (it.next());
			//System.out.println(an);
			
			if (an instanceof TestDocument) {
				TestDocument doc = (TestDocument) an;
				FSList list = doc.getQaList();
				boolean answered = false;
				while (list instanceof NonEmptyFSList) { //every question
					FeatureStructure head = ((NonEmptyFSList) list).getHead();
					QuestionAnswerSet qas = (QuestionAnswerSet) head;
					Question q = qas.getQuestion();
					//DEBUG System.out.println("Question: " + q.getText());
					FSList aList = qas.getAnswerList();
					if (aList instanceof NonEmptyFSList) { //only the first  answer item
						FeatureStructure qaHead = ((NonEmptyFSList) aList)
								.getHead();
						Answer ans = (Answer) qaHead;
						//DEBUG System.out.println("Answer: " + ans.getId() + ", text: "
						//		+ ans.getText());
						if(Math.random() < PROB)
						{
							ans.setIsSelected(true);
						}
						aList = ((NonEmptyFSList) aList).getTail();
					}
					// do something with this element
					list = ((NonEmptyFSList) list).getTail();
				}
			}
		}
	}

	
}
