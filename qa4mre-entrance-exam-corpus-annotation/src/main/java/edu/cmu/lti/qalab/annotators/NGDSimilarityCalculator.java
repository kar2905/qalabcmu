package edu.cmu.lti.qalab.annotators;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.regex.Pattern;

import org.apache.xerces.impl.xs.identity.Selector.Matcher;

public class NGDSimilarityCalculator {
	private static final String GOOGLE_SEARCH_SITE_PREFIX = "http://ajax.googleapis.com/ajax/services/search/web?v=1.0&";
	protected final static double logN = Math.log(1.0e12);

	public Double calculateDistance(String term1, String term2) throws IOException {
		double distance = 0.0;
		double min = numResultFromQuery(term1);
		double max = numResultFromQuery(term2);
		double both = numResultFromQuery(term1 + " " + term2);
		// if necessary, swap the min and max
		if (max < min) {
			double temp = max;
			max = min;
			min = temp;
		}

		if (min > 0.0 && both > 0.0) {
			distance = (Math.log(max) - Math.log(both) / (logN - Math.log(min)));
		} else {
			distance = 1.0;
		}
		if (distance < 0.0) {
			distance = 0.0;
		}

		return distance;
	}

	public double numResultFromQuery(String searchTerm) throws IOException {
		String query = makeGoogleQueryString(searchTerm);
		String page = readPage(query);
		return getCountFromQuery(page);
	}

	private String makeGoogleQueryString(String searchTerm) {
		String urlString = GOOGLE_SEARCH_SITE_PREFIX + "q=" + searchTerm + " ";
		return urlString;
	}

	private double getCountFromQuery(String page) throws IOException {
		double count = 0;
		String s = "\"estimatedResultCount\":\"(\\d+)\"";
		Pattern p = Pattern.compile(s);
		java.util.regex.Matcher m = p.matcher(page);
		if (m.find())
			count = Integer.parseInt(m.group(1));
		return count;
	}

	private String readPage(String ulrString) throws IOException {
		URL url = new URL(changeWhiteSpaceTo20percent(ulrString));
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		InputStream in = url.openStream();
		BufferedReader bin = new BufferedReader(new InputStreamReader(in,
				"GB2312"));
		String response = bin.readLine();
		return response;
	}

	private String changeWhiteSpaceTo20percent(String s) {
		String result = new String();
		String[] list = new String[20];
		list = s.split(" ");
		for (String w : list) {
			result = result + "%20" + w;
		}
		result = result.substring(3);
		return result;
	}
}
