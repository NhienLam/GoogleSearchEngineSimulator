package searchengine;
/*
import java.util.Scanner;
/**
 * Builds a micro version  Google Search Engine Simulator
 * @author Nhien (Ricky) Lam 
 *
 */

import java.util.Scanner;

public class SearchEngine {

	private WebCrawler wCrawler;

	/**
	 * Starts the ToDoList tasks
	 */
	public void runSearchEngine()
	{
		// get input from user
		Scanner in = new Scanner(System.in);

		// get a keyword from user
		System.out.println("Please enter a keyword you want to search?");
		String keyword = in.nextLine();

		wCrawler = new WebCrawler(keyword);
		
		System.out.println("Which task do you want to perform: ");
		System.out.println("Please enter a country: ");
		String country = in.nextLine();
	}
}
