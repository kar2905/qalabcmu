package edu.cmu.lti.qalab.error_analysis;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class ErrorAnalysisAnotator {
	int totalQuestion = 5;
	int numOfCorrect;
	int numOfNoAnswer;
	
	public void analysisTest () throws FileNotFoundException {
		Scanner goldStandard = getFile ("data/output_g");
		Scanner output = getFile ("data/output");
		numOfCorrect = 0;
		numOfNoAnswer = 0;
		
		for (int i=0; i<5; i++) {
			String question = output.nextLine();
			goldStandard.nextLine();
			
			// generate answer block and gold standard block for question matching
			AnsBlock ansQuestion = new AnsBlock (question, 
					output.nextLine(), new Double (output.nextLine()),
					output.nextLine(), new Double (output.nextLine()),
					output.nextLine(), new Double (output.nextLine()),
					new Double (output.nextLine()));
			
			GoldBlock goldQuestion = new GoldBlock (question, goldStandard.nextLine(),
					goldStandard.nextLine(), goldStandard.nextLine());
					
			// generate answer block and gold blocks for choice matching
			AnsBlock[] ansChoice = new AnsBlock[4];
			GoldBlock[] goldChoice = new GoldBlock[4];
			
			for (int choice =0; choice < 4; choice++) {
				AnsBlock ansC = new AnsBlock (output.nextLine(), 
						output.nextLine(), new Double (output.nextLine()),
						output.nextLine(), new Double (output.nextLine()),
						output.nextLine(), new Double (output.nextLine()),
						new Double (output.nextLine()));
				
				GoldBlock goldC = new GoldBlock (goldStandard.nextLine(), goldStandard.nextLine(),
						goldStandard.nextLine(), goldStandard.nextLine());
				ansChoice[choice] = ansC;
				goldChoice[choice] = goldC;
			} 
			
			// generate final results
			int chooseResult = new Integer( output.nextLine());
			int goldResult = new Integer( goldStandard.nextLine());
			
			// eat the speration line
			output.nextLine();
			goldStandard.nextLine();
			
			// compare goldblock and ansblock to generate Similarity report
			System.out.println("Similarity Matching Evaluation:");
			
			double questionMatchiScore = evaluateSimilarity(ansQuestion, goldQuestion);
			System.out.println("Question Similarity Matching Evaluation: " + questionMatchiScore);
			
			for (int j=0; j<4; j++) {
				AnsBlock ansBlock = ansChoice[j];
				GoldBlock goldBlock = goldChoice[j];
				System.out.println("Sentence in question: " + ansBlock.question);
				System.out.println("How good can it map this to text? : " + evaluateSimilarity(ansBlock, goldBlock));
			}
			
			// calculate accuracy
			if (chooseResult == goldResult) numOfCorrect++;
			
		}	
		
		System.out.println("Precison: " + numOfCorrect / 5);
	}
	
	private double evaluateSimilarity (AnsBlock ans, GoldBlock gold) {
		double score = 0.0;
		for (String anCandidate : ans.candidates2Score.keySet()) {
			if (gold.candidates.contains(anCandidate)) 
				score += ans.candidates2Score.get(anCandidate);
		}
		score = score/gold.candidates.size();
		return score;
	}
	
	private Scanner getFile (String path) throws FileNotFoundException {
		File output = new File (path);
		Scanner s = new Scanner(output);
		return s;
	}

	private class AnsBlock {
		String question;
		HashMap<String, Double> candidates2Score = new HashMap<String, Double>();
		double score;
		
		AnsBlock (String question, String s1, 
				double scr1, String s2, double scr2, String s3, double scr3, double scr) {
			this.question = question;
			candidates2Score.put(s1, scr1);
			candidates2Score.put(s2, scr2);
			candidates2Score.put(s3, scr3);
			this.score = scr;
		}
	}
	
	private class GoldBlock {
		String question;
		HashSet<String> candidates = new HashSet<String>();
		
		GoldBlock (String question, String s1, String s2, String s3) {
			this.question = question;
			candidates.add(s1);
			candidates.add(s2);
			candidates.add(s3);
		}
	}
}
