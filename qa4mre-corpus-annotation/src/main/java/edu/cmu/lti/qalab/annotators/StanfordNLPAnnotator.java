package edu.cmu.lti.qalab.annotators;

import java.util.List;
import java.util.Properties;

import org.apache.uima.UimaContext;
import org.apache.uima.analysis_component.JCasAnnotator_ImplBase;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.cas.FSIterator;
import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.cas.FSList;
import org.apache.uima.resource.ResourceInitializationException;

import edu.cmu.lti.qalab.types.Dependency;
import edu.cmu.lti.qalab.types.SourceDocument;
import edu.stanford.nlp.ling.CoreAnnotations.NamedEntityTagAnnotation;
import edu.stanford.nlp.ling.CoreAnnotations.PartOfSpeechAnnotation;
import edu.stanford.nlp.ling.CoreAnnotations.SentencesAnnotation;
import edu.stanford.nlp.ling.CoreAnnotations.TokensAnnotation;
import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.pipeline.Annotation;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import edu.stanford.nlp.trees.semgraph.SemanticGraph;
import edu.stanford.nlp.trees.semgraph.SemanticGraphCoreAnnotations.CollapsedCCProcessedDependenciesAnnotation;
import edu.stanford.nlp.util.CoreMap;

public class StanfordNLPAnnotator extends JCasAnnotator_ImplBase {

	private StanfordCoreNLP stanfordAnnotator;

	@Override
	public void initialize(UimaContext context)
			throws ResourceInitializationException {
		super.initialize(context);
		Properties props = new Properties();
		props.put("annotators", "tokenize, ssplit, pos, lemma, ner, parse");
		stanfordAnnotator = new StanfordCoreNLP(props);
	}

	@Override
	public void process(JCas jCas) throws AnalysisEngineProcessException {

		FSIterator fsIt = jCas.getAnnotationIndex(SourceDocument.type)
				.iterator();
		SourceDocument srcDoc = null;
		if (fsIt.hasNext()) {
			srcDoc = (SourceDocument) fsIt.next();
		}

		String id = srcDoc.getId();
		String docText = srcDoc.getText();

		Annotation document = new Annotation(docText);
		stanfordAnnotator.annotate(document);
		List<CoreMap> sentences = document.get(SentencesAnnotation.class);
		//SourceDocument sourcecDocument=(SourceDocument) jCas.getAnnotationIndex(SourceDocument.type);
		
		for (CoreMap sentence : sentences) {
			//FSList tokenList=
			for (CoreLabel token : sentence.get(TokensAnnotation.class)) {
				String orgText=token.originalText();
				// this is the POS tag of the token
				String pos = token.get(PartOfSpeechAnnotation.class);				
				// this is the NER label of the token
				String ne = token.get(NamedEntityTagAnnotation.class);
				
			}

			// this is the parse tree of the current sentence
			// Tree tree = sentence.get(TreeAnnotation.class);

			// this is the Stanford dependency graph of the current sentence
			SemanticGraph dependencies = sentence
					.get(CollapsedCCProcessedDependenciesAnnotation.class);
			Dependency dependency=new Dependency(jCas);
			//System.out.println("Dependencies: "+dependencies);
		}

	}
	/*
	public FSList addToFSList(){
		int i = 0;
		FSList fsList = geneTagList.getGeneList();
		while (true) {

			GeneTag geneTag = null;
			try {
				geneTag = (GeneTag) fsList.getNthElement(i);
			} catch (Exception e) {
				break;
			}

			// int start=geneTag.getStart();
			// int end=geneTag.getEnd();
			String geneName = geneTag.getGeneName();

			i++;
		}

	}*/

}
