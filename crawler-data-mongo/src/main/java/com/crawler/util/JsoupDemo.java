package com.crawler.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.crawler.entity.Post;

public class JsoupDemo {

	private static String menuPattern = "https://dantri.com.vn/([a-z]|-)*.htm";
	private static String pagePattern = "https://dantri.com.vn/.*/trang-([0-9]*).htm";

	// get subUrls of a url
	public static Set<String> getSubUrls(String url, String resultPattern) {
		Set<String> resultLinks = new HashSet<>();
		try {
			Document doc = Jsoup.connect(url).get();
			Elements links = doc.select("a[href]");

			for (Element link : links) {
				String subUrl = link.attr("abs:href").trim();

				Pattern r = Pattern.compile(resultPattern);
				Matcher m = r.matcher(subUrl);
				while (m.find()) {
					if (!(subUrl.contains("rss.htm") || subUrl.contains("video-page.htm"))) {
						resultLinks.add(subUrl);
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return resultLinks;
	}

	// get postUrls of a subUrl
	public static Set<String> getPostUrls(String url, String menuName) {
		String menuNamePattern = "https://dantri.com.vn/" + menuName + "/([a-z]|[0-9]|-)*.htm";
		String nextPageUrl = "";
		Set<String> resultLinks = new HashSet<>();
		Pattern pMenuName = Pattern.compile(menuNamePattern);
		Pattern pPage = Pattern.compile(pagePattern);
		try {
			while (url != null) {
				Set<String> newLinks = new HashSet<>();

				// get nextPageUrl
				Matcher mCurrentPage = pPage.matcher(url);
				while (mCurrentPage.find()) {
					Integer nextPage = Integer.parseInt(mCurrentPage.group(1)) + 1;
					nextPageUrl = url.replace(mCurrentPage.group(1), nextPage.toString());
				}

				// get all url by Jsoup
				Document doc = Jsoup.connect(url).get();
				Elements links = doc.select("a[href]");

				for (Element link : links) {
					String subUrl = link.attr("abs:href").trim();
					Matcher mMenuName = pMenuName.matcher(subUrl);
					Matcher mPage = pPage.matcher(subUrl);
					while (mMenuName.find() && !mPage.find()) {
						newLinks.add(subUrl);
					}
				}

				if (checkUrlActive(newLinks, resultLinks)) {
					resultLinks.addAll(newLinks);
					url = nextPageUrl;
				} else {
					url = null;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return resultLinks;
	}

	public static boolean checkUrlActive(Set<String> newLinks, Set<String> parentLinks) {
		if (parentLinks.containsAll(newLinks)) {
			return false;
		}
		return true;
	}

	// get postContent of a postUrl
	public static List<Post> getPostContent(String postUrl) {
		Post post = new Post();
		
//		try {
//			Document doc = Jsoup.connect(postUrl).get();
//			Elements links = doc.select("a[href]");
//
//			for (Element link : links) {
//				String subUrl = link.attr("abs:href").trim();
//
//				Pattern r = Pattern.compile(resultPattern);
//				Matcher m = r.matcher(subUrl);
//				while (m.find()) {
//					if (!(subUrl.contains("rss.htm") || subUrl.contains("video-page.htm"))) {
//						resultLinks.add(subUrl);
//					}
//				}
//			}
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		
		return null;
	}

	public static void main(String[] args) {
		Set<String> postUrls = getPostUrls("https://dantri.com.vn/su-kien/trang-1.htm", "su-kien");

		for (String string : postUrls) {
			System.out.println(string);
		}
	}

}
