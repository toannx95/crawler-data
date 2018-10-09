package com.crawler.util;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.crawler.entity.Post;

class SeleniumDemo {

	public static void main(String[] args) {

		String url = "https://dantri.com.vn";

		System.setProperty("webdriver.chrome.driver", "/Git/crawler-data/chromedriver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(url);

		// click menu su-kien
		driver.findElement(By.xpath("//*[@id=\"aspnetForm\"]/div[4]/div[1]/div/ul/li[4]")).click();

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

		// driver.quit();
	}

}
