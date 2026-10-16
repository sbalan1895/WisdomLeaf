package gettingStrated;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class Playwight_Learning {

	public static void main(String[] args) {

		Playwright playwright = Playwright.create();
		BrowserType browser = playwright.chromium();

		Browser launch = browser.launch();
		Page page = launch.newPage();

		page.navigate("https://playwright.dev/");
		String title = page.title();

		System.out.println("Page title is " + title);
		
		page.close();
		launch.close();
		playwright.close();

	}

}
