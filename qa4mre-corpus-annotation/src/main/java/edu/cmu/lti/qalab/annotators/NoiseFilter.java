package edu.cmu.lti.qalab.annotators;

import java.util.HashSet;

import org.apache.uima.analysis_component.JCasAnnotator_ImplBase;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.jcas.JCas;

import edu.cmu.lti.qalab.types.FilteredDocument;
import edu.cmu.lti.qalab.types.SourceDocument;
import edu.stanford.nlp.util.StringUtils;

public class NoiseFilter extends JCasAnnotator_ImplBase {

	double NOISE_THRESHOLD=0.2;
	@Override
	public void process(JCas jCas) throws AnalysisEngineProcessException {

		SourceDocument srcDoc = (SourceDocument) jCas
				.getAnnotationIndex(SourceDocument.type);
		String id = srcDoc.getId();
		String docText = srcDoc.getText();

		try {
			String lines[] = docText.split("[\\n]");
			String filteredText = "";
			for (int i = 0; i < lines.length; i++) {

				double noiseScore = this.getSentQuality(lines[i]);
				if(noiseScore>NOISE_THRESHOLD){
					continue;
				}
				filteredText+=lines[i];
			}

			System.out.println("Difference between size of (SourceDocument - FilteredDocument): "+(docText.length()-filteredText.length()));
			
			FilteredDocument annotation = new FilteredDocument(jCas);
			annotation.setId(id);
			annotation.setText(filteredText);
			annotation.addToIndexes();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public double getSentQuality(String sent) throws Exception {
		String words[] = sent.split("[\\W]");
		HashSet<String> lowQualityWord = new HashSet<String>();
		lowQualityWord.add("Abstract");
		lowQualityWord.add("References");
		lowQualityWord.add("Medline");

		int numericWords = 0;
		int abbrWords = 0;
		int lowQualityWords = 0;
		int totalWords = 0;
		for (int i = 0; i < words.length; i++) {
			if (StringUtils.isNumeric(words[i])) {
				numericWords++;
			}
			if (StringUtils.isAcronym(words[i])) {
				abbrWords++;
			}
			if (lowQualityWord.contains(words[i])) {
				lowQualityWords++;
			}

			totalWords++;
		}

		double score = (numericWords + abbrWords + lowQualityWords)
				/ (double) totalWords;

		return score;

	}

}
