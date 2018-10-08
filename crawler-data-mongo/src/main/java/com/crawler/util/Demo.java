package com.crawler.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.crawler.entity.Post;

class Demo {

	// get subUrls of a url
	public static Set<String> getSubUrls(String url) {
		List<String> listLinks = new ArrayList<>();
		try {
			Document doc = Jsoup.connect(url).get();
			Elements links = doc.select("a[href]");

			for (Element link : links) {
				listLinks.add(link.attr("abs:href").trim());
				System.out.println(link.attr("abs:href").trim());
			}

		} catch (IOException e) {

		}

		return null;
	}

	// get postUrls of a subUrl
	public static List<String> getPostUrls(String subUrl) {

		return null;
	}

	// get postContent of a postUrl
	public static List<Post> getPostContent(String postUrl) {

		return null;
	}

	public static void main(String[] args) {

		String url = "https://dantri.com.vn";

		System.setProperty("webdriver.chrome.driver", "/chromedriver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(url);

		// click menu su-kien
		driver.findElement(By.xpath("//*[@id=\"aspnetForm\"]/div[4]/div[1]/div/ul/li[3]")).click();

		Post post = new Post();

		// click first post
		WebElement firstNews = driver
				.findElement(By.xpath("//*[@id=\"aspnetForm\"]/div[5]/div[1]/div[1]/div[1]/div[1]"));

		post.setUrl(firstNews.findElement(By.xpath(".//a")).getAttribute("href"));
		System.out.println(firstNews.findElement(By.xpath(".//a")).getAttribute("href"));

		post.setTitle(firstNews.findElement(By.xpath(".//a")).getAttribute("title"));
		System.out.println(firstNews.findElement(By.xpath(".//a")).getAttribute("title"));

		post.setImageUrl(firstNews.findElement(By.xpath(".//a/img")).getAttribute("src"));
		System.out.println(firstNews.findElement(By.xpath(".//a/img")).getAttribute("src"));

		post.setSortContent(firstNews.findElement(By.xpath(".//div/div")).getText());
		System.out.println(firstNews.findElement(By.xpath(".//div/div")).getText());

//		// get div content of date
//		WebElement element = driver.findElement(By.xpath("//*[@id=\"ctl00_IDContent_ctl00_divContent\"]/div[1]/span"));
//		String datePost = element.getText();
//		System.out.println(datePost);

		// driver.quit();
	}
}
