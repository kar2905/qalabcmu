package edu.cmu.lti.qalab.similarity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CosSimilarityCalculator {

	static double cosine_similarity(String v1, String v2) {
		String[] sentence1 = v1.toLowerCase().split(" ");
		String[] sentence2 = v2.toLowerCase().split(" ");
		
		ArrayList<String> str1Tokens = new ArrayList<String> ();
		ArrayList<String> str2Tokens = new ArrayList<String> ();
		
		for (String token : sentence1) {
			if (!isSTOPW(token)) 
				str1Tokens.add(token);
		}
		
		for (String token : sentence2) {
			if (!isSTOPW(token))
				str2Tokens.add(token);
		}
		
		
		Set<String> allTokens = new HashSet<String>();
		
		allTokens.addAll(str1Tokens);
		
		int termsInString1 = allTokens.size();
		Set<String> secondStringTokens = new HashSet<String>();
		
		secondStringTokens.addAll(str2Tokens);
		int termsInString2 = secondStringTokens.size();

		// now combine the sets
		allTokens.addAll(secondStringTokens);
		int commonTerms = (termsInString1 + termsInString2)
				- allTokens.size();

		// return CosineSimilarity
		return (float) (commonTerms)
				/ (float) (Math.pow((float) termsInString1, 0.5f) * Math.pow(
						(float) termsInString2, 0.5f));
		
	}

	static double cosine_similarity(Map<String, Double> v1,
			Map<String, Double> v2) {

		Set<String> both = new HashSet<String>();
		both.retainAll(v1.keySet());
		both.retainAll(v2.keySet());

		double sclar = 0, norm1 = 0, norm2 = 0;

		for (String k : both)
			sclar += v1.get(k) * v2.get(k);

		for (String k : v1.keySet())
			norm1 += v1.get(k) * v1.get(k);

		for (String k : v2.keySet())
			norm2 += v2.get(k) * v2.get(k);

		return sclar / Math.sqrt(norm1 * norm2);
	}
	
	
	private static boolean isSTOPW (String w) {
	
		Set <String> stopW = new HashSet<String> ();
		
		String stopWz = "a,able,about,across,after,all,almost,also,am,among,an,and,any,are,as,at,be,because,been,but,by,can,cannot,could,dear,did,do,does,either,else,ever,every,for,from,get,got,had,has,have,he,her,hers,him,his,how,however,i,if,in,into,is,it,its,just,least,let,like,likely,may,me,might,most,must,my,neither,no,nor,not,of,off,often,on,only,or,other,our,own,rather,said,say,says,she,should,since,so,some,than,that,the,their,them,then,there,these,they,this,tis,to,too,twas,us,wants,was,we,were,what,when,where,which,while,who,whom,why,will,with,would,yet,you,your";
		
		String[] stop = stopWz.split(",");
		
		for (String s : stop) {stopW.add(s);}
		
		if (stopW.contains(w)) return true;
		else return false;
	}

}
