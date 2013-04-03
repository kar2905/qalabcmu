package edu.cmu.lti.qalab.annotators;

import java.util.ArrayList;

import edu.cmu.lti.qalab.utils.Utils;
import edu.cmu.lti.qalab.types.Sentence;
import edu.cmu.lti.qalab.types.Answer;
import edu.cmu.lti.qalab.types.Dependency;
import edu.cmu.lti.qalab.types.Question;
import edu.cmu.lti.qalab.types.QuestionAnswerSet;
import edu.cmu.lti.qalab.types.Sentence;
import edu.cmu.lti.qalab.types.TestDocument;
import edu.cmu.lti.qalab.types.Token;
import edu.cmu.lti.qalab.utils.Utils;
public class tmp {
	void lol(){
		ArrayList<QuestionAnswerSet> qaSet;
		ArrayList<Sentence> candSentList = Utils.fromFSListToCollection(
				qaSet.get(0).getCandidateSentenceList(), Sentence.class);
		CandidateSentence candSent = candSentList.get(0);
		ArrayList<NounPhrase> candSentNouns = Utils.fromFSListToCollection(candSent
				.getSentence().getPhraseList(), NounPhrase.class);
		ArrayList<NER> candSentNers = Utils.fromFSListToCollection(candSent
				.getSentence().getNerList(), NER.class);
		
	}

}
