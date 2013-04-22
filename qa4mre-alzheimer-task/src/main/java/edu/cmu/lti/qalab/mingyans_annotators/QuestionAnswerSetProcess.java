package edu.cmu.lti.qalab.mingyans_annotators;

import java.util.ArrayList;
import java.util.Properties;

import org.apache.uima.UimaContext;
import org.apache.uima.analysis_component.JCasAnnotator_ImplBase;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.cas.FSList;
import org.apache.uima.resource.ResourceInitializationException;

import edu.cmu.lti.qalab.types.Answer;
import edu.cmu.lti.qalab.types.Question;
import edu.cmu.lti.qalab.types.QuestionAnswerSet;
import edu.cmu.lti.qalab.types.Token;
import edu.cmu.lti.qalab.utils.Utils;
import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.ling.CoreAnnotations.TokensAnnotation;
import edu.stanford.nlp.pipeline.Annotation;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;

/**
 * This annotator is used to proceed tokenlization of Question and Answers
 * question.
 * 
 * The way of tokenlization is StanfordNLP
 * 
 * @author mingyans
 * 
 */
public class QuestionAnswerSetProcess extends JCasAnnotator_ImplBase {

	private StanfordCoreNLP stanfordAnnotator;

	@Override
	public void initialize(UimaContext aContext)
			throws ResourceInitializationException {
		// TODO Auto-generated method stub
		super.initialize(aContext);
		Properties props = new Properties();
		props.put("annotators", "tokenize, ssplit");
		stanfordAnnotator = new StanfordCoreNLP(props);
	}

	@Override
	public void process(JCas jCas) throws AnalysisEngineProcessException {

		System.out
				.println("\n-------------------------------\nQuestionAnswerSetProcess\n------------------------------------------\n");

		ArrayList<QuestionAnswerSet> qaSet = Utils.getQuestionAnswerSet(jCas);
		for (QuestionAnswerSet qa : qaSet) {
			Question ques = qa.getQuestion();
			String quesText = ques.getText();
			ques.setTokenList(setTokenList(jCas, quesText));
			ques.addToIndexes();
			FSList ansList = qa.getAnswerList();

			int i = 0;
			while (true) {
				Answer ans = null;
				try {
					ans = (Answer) ansList.getNthElement(i);
				} catch (Exception e) {
					break;
				}
				ans.setTokenList(setTokenList(jCas, ans.getText()));
				ans.addToIndexes();
				i++;
			}
		}
	}

	public FSList setTokenList(JCas jCas, String test) {
		Annotation annotator = new Annotation(test);

		try {
			// System.out.println("Entering stanford annotation");
			stanfordAnnotator.annotate(annotator);
			// System.out.println("Out of stanford annotation");
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

		int number_token = 0;

		ArrayList<Token> tokenList = new ArrayList<Token>();

		for (CoreLabel token : annotator.get(TokensAnnotation.class)) { // order
																		// considered
			int begin = token.beginPosition();

			int end = token.endPosition();
			// System.out.println(begin + "\t" + end);
			String orgText = token.originalText();
			// System.out.println(orgText);

			Token annToken = new Token(jCas);
			annToken.setBegin(begin);
			annToken.setEnd(end);
			annToken.setText(orgText);
			annToken.addToIndexes();
			tokenList.add(annToken);
			number_token++;
		}
		System.out.printf("There are %d tokens for the source\n", number_token);
		return Utils.createTokenList(jCas, tokenList);
	}

}
