package edu.cmu.lti.qalab.annotators;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Find bio synonyms, especially for genes and proteins.
 * 
 * @author Yibin Lin
 * 
 */
public class SynonymFinder {
	public static final String FILE_NAME = "lib/gene_ontology_ext.obo";
	public static final String GIGA_WORD = "lib/cmudict.0.7a.gigaword.freq";
	private static HashMap<String, LinkedList<String>> dict = new HashMap<String, LinkedList<String>>();
	private static HashMap<String, Integer> gigaMap = new HashMap<String, Integer>();
	public static final int gigaThreshold = 400; // we treat words that have
													// counts more than 5000 as
													// common words.

	static {
		startup();
	}

	/**
	 * Read the ontology file and build the dictionary
	 */
	public static void startup() {
		String thisLine;
		String currentName = "";
		boolean next = true;

		// DEBUG
		// System.out.println("entered here");

		// Loop across the arguments

		// Open the file for reading
		try {
			BufferedReader br = new BufferedReader(new FileReader(GIGA_WORD));
			while ((thisLine = br.readLine()) != null) {
				String str = thisLine.replaceAll("(\\r|\\n)", "");
				String[] wordNumber = str.split("  ");
				String word = wordNumber[0].toLowerCase();
				int cnt = Integer.parseInt(wordNumber[1]);
				gigaMap.put(word, cnt);
			}

			br = new BufferedReader(new FileReader(FILE_NAME));
			while ((thisLine = br.readLine()) != null) {
				String str = thisLine.replaceAll("(\\r|\\n)", "");
				if (str.equals("[Term]")) {
					next = true;
				}
				if (str.startsWith("name:")) {
					if (next) {
						currentName = str.replaceAll("name: ", "");
					}
				}
				if (str.startsWith("synonym:")) {
					if (str.contains("EXACT") || str.contains("NARROW")) {
						// synonym..
						Pattern pattern = Pattern
								.compile("synonym:.*\"(.*)\".*");
						Matcher matcher = pattern.matcher(str);
						// DEBUG
						// System.err.println(str);
						if (matcher.find()) {
							String syno = matcher.group(1);
							if (!currentName.equals("")) {
								// System.err.format("%s:%s.\n", currentName,
								// syno);

								add(currentName, syno);
								add(syno, currentName);
								recursiveAddSyno(currentName, syno);
							}
						}
					}
				}
			}
			br.close();

		} catch (IOException e) {
			System.err.println("Error: " + e);
		}
	}

	private static void recursiveAddSyno(String currentName, String syno) {
		if(currentName.length() == 0 || syno.length() == 0)
		{
			return;
		}
		add(currentName, syno);
		add(syno, currentName);
		String[] currSplitted = currentName.split(" ");
		String[] synoSplitted = syno.split(" ");
		String currLast = currSplitted[currSplitted.length - 1];
		String synoLast = synoSplitted[synoSplitted.length - 1];
		// DEBUG
		//System.out.format("%s, %s, %d\n", currLast,
		//		synoLast, gigaMap.get(currLast));
		if (currLast.equals(synoLast)) {
			// DEBUG
			// System.out.println("Entered here!");
			String anotherCurr = "";
			String anotherSyno = "";
			for (int i = 0; i < currSplitted.length - 1; i++) {
				if (i == currSplitted.length - 2) {
					anotherCurr += currSplitted[i];
				} else {
					anotherCurr += currSplitted[i]
							+ " ";
				}

			}
			for (int i = 0; i < synoSplitted.length - 1; i++) {
				if (i == synoSplitted.length - 2) {
					anotherSyno += synoSplitted[i];
				} else {
					anotherSyno += synoSplitted[i]
							+ " ";
				}
			}
			//DEBUG
			//System.out.println("!!!" + anotherSyno
			//		+ "," + anotherCurr);
			
			recursiveAddSyno(anotherCurr, anotherSyno);
			//add(anotherCurr, anotherSyno);
			//add(anotherSyno, anotherCurr);
		}
	}

	/**
	 * 
	 * @param target
	 * @param newSyno
	 */
	private static void add(String target, String newSyno) {
		if (!dict.containsKey(target)) {
			LinkedList<String> l = new LinkedList<String>();
			l.add(newSyno);
			dict.put(target, l);
		} else {
			LinkedList<String> l = dict.get(target);
			if (!l.contains(newSyno)) {
				l.add(newSyno);
			}
		}
	}

	public static List<String> getSynonym(String word) {
		List<String> res = new LinkedList<String>();
		if (dict.containsKey(word)) {
			res = dict.get(word);
		}
		return res;
	}

	public static void main(String[] args) {
		String[] ss = { "aromatase", "AD", "androgen", "BACE1",
				"actinomycin D", "APP23", "testosterone" };
		for (String sss : ss) {
			List<String> synos = SynonymFinder.getSynonym(sss);
			for (String s : synos) {
				System.out.format("original: %s, synonym: %s.\n", sss, s);
			}
		}
	}
}
