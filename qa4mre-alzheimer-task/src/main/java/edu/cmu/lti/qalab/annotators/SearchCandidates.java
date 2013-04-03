package edu.cmu.lti.qalab.annotators;

import java.util.ArrayList;

import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.apache.uima.UimaContext;
import org.apache.uima.analysis_component.JCasAnnotator_ImplBase;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.cas.FSList;
import org.apache.uima.resource.ResourceInitializationException;

import edu.cmu.lti.oaqa.core.provider.solr.SolrWrapper;
import edu.cmu.lti.qalab.types.Answer;
<<<<<<< HEAD
import edu.cmu.lti.qalab.types.Dependency;
=======
import edu.cmu.lti.qalab.types.CandidateSentence;
>>>>>>> d7cd2644a498a12f646d273532b70970e004b84f
import edu.cmu.lti.qalab.types.NER;
import edu.cmu.lti.qalab.types.NounPhrase;
import edu.cmu.lti.qalab.types.Question;
import edu.cmu.lti.qalab.types.QuestionAnswerSet;
import edu.cmu.lti.qalab.types.Sentence;
<<<<<<< HEAD
=======
import edu.cmu.lti.qalab.types.TestDocument;
>>>>>>> d7cd2644a498a12f646d273532b70970e004b84f
import edu.cmu.lti.qalab.utils.Utils;
import edu.smu.tspell.wordnet.NounSynset;
import edu.smu.tspell.wordnet.Synset;
import edu.smu.tspell.wordnet.SynsetType;
import edu.smu.tspell.wordnet.WordNetDatabase;

public class SearchCandidates extends JCasAnnotator_ImplBase{

	SolrWrapper solrWrapper=null;
	String serverUrl;
	//IndexSchema indexSchema;
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
			this.solrWrapper = new SolrWrapper(serverUrl+coreName);
		} catch (Exception e) {

			e.printStackTrace();

		}
		
	}
	@Override
	public void process(JCas aJCas) throws AnalysisEngineProcessException {
		// TODO Auto-generated method stub
		TestDocument testDoc=Utils.getTestDocumentFromCAS(aJCas);
		ArrayList<Sentence>sentenceList=Utils.getSentenceListFromTestDocCAS(aJCas);
		ArrayList<QuestionAnswerSet>qaSet=Utils.getQuestionAnswerSetFromTestDocCAS(aJCas);
		
		for(int i=0;i<qaSet.size();i++){
			
			Question question=qaSet.get(i).getQuestion();
			System.out.println("========================================================");
			System.out.println("Question: "+question.getText());
			ArrayList<Answer>answerList=Utils.fromFSListToCollection(qaSet.get(i).getAnswerList(), Answer.class);
			for(int j=0;j<answerList.size();j++){
				System.out.println("("+(j+1)+") "+answerList.get(j).getText());
			}
			String searchQuery=this.formSolrQuery(question);
			ArrayList<CandidateSentence>candidateSentList=new ArrayList<CandidateSentence>();
			
			try {
				SolrDocumentList results=solrWrapper.runQuery(searchQuery, 10);
				for(int j=0;j<results.size();j++){
					SolrDocument doc=results.get(j);					
					String sentId=doc.get("id").toString();
					String docId=doc.get("docid").toString();
					String sentIdx=sentId.replace(docId,"").replace("_", "").trim();
					int idx=Integer.parseInt(sentIdx);
					Sentence annSentence=sentenceList.get(idx);
					
					String sentence=doc.get("text").toString();
					double relScore=Double.parseDouble(doc.get("score").toString());
					CandidateSentence candSent=new CandidateSentence(aJCas);
					candSent.setSentence(annSentence);
					candSent.setRelevanceScore(relScore);
					candidateSentList.add(candSent);
					System.out.println(relScore+"\t"+sentence);
				}
				FSList fsCandidateSentList=Utils.fromCollectionToFSList(aJCas, candidateSentList);
				fsCandidateSentList.addToIndexes();
				qaSet.get(i).setCandidateSentenceList(fsCandidateSentList);
				qaSet.get(i).addToIndexes();
			
				
				//---yiFei ADDED
				//---get candidate sentence
				ArrayList<Sentence> candidateSentence  = new ArrayList<Sentence>();
				ArrayList<Sentence> sList = Utils.getSentenceListFromSourceDocCAS(aJCas);
				for(Sentence s:sList){
					for(SolrDocument doc:results){
						if(s.getId().equals(doc.get("id").toString())){
							candidateSentence.add(s);
						}
					}
				}
				//--------get candidate sentence end-----
				
				
			} catch (SolrServerException e) {
				e.printStackTrace();
			}
			FSList fsQASet=Utils.fromCollectionToFSList(aJCas, qaSet);
			testDoc.setQaList(fsQASet);
			
			System.out.println("=========================================================");
		}
		
	}
	
	public String formSolrQuery(Question question){
		String solrQuery="";
		
		ArrayList<NounPhrase>nounPhrases=Utils.fromFSListToCollection(question.getNounList(), NounPhrase.class);
		
		for(int i=0;i<nounPhrases.size();i++){
			solrQuery+="nounphrases:\""+nounPhrases.get(i).getText()+"\" ";			
		}
		
		ArrayList<NER>neList=Utils.fromFSListToCollection(question.getNerList(), NER.class);
		for(int i=0;i<neList.size();i++){
			solrQuery+="namedentities:\""+neList.get(i).getText()+"\" ";
		}
		solrQuery=solrQuery.trim();
		
		
		return solrQuery;
	}
	
	public Double DepSimilarity(Dependency d1,Dependency d2){
	    System.out.println("lol");
	    NounSynset nounSynset; 
	    NounSynset[] hyponyms; 

	    WordNetDatabase database = WordNetDatabase.getFileInstance(); 
	    Synset[] synsets = database.getSynsets("picture", SynsetType.NOUN); 
	    
	    
	    
	    for (int i = 0; i < synsets.length; i++) { 
	        nounSynset = (NounSynset)(synsets[i]); 
	        hyponyms = nounSynset.getHyponyms();
	        ;
	       System.out.println(nounSynset.getWordForms().length);
	       for(String s:nounSynset.getWordForms()){
	         System.out.print(s+" counts: "+nounSynset.getTagCount(s)+" ");
	       }
	       
	        System.err.println(nounSynset.getWordForms()[0] + 
	                ": " + nounSynset.getDefinition() + ") has " + hyponyms.length + " hyponyms and counts:"+nounSynset.getTagCount(nounSynset.getWordForms()[0]));
	        for(NounSynset ns:hyponyms){
	          String[] tmp = ns.getWordForms();
	          for(String s:tmp){
	            System.out.print(s+" counts:"+ns.getTagCount(s)+"| ");
	          }
	          System.out.println("");
	        }
	    }
		return 0.0;
	}

}
