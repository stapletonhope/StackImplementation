package application;

import util.*;
import java.util.Scanner;

public class WebArrayStack {
	ArrayStack<WebSite> webStack;

	public WebArrayStack() {
		int num;
		webStack = new ArrayStack<WebSite>();
		inputSites();
		displayTop();
		displayAll();
		search();
	}

	public void inputSites() {
		Scanner scan = new Scanner(System.in);
		String webName, webAdd;
		WebSite aWebSite;

		System.out.println("Enter details for 5 websites which will be stored in a stack\n");
		for (int num = 1; num <= 5; num++) {
			System.out.print("Enter the website name: ");
			webName = scan.nextLine();

			System.out.print("Enter the website address: \n");
			webAdd = scan.nextLine();

			aWebSite = new WebSite(webName, webAdd);
			webStack.push(aWebSite);
		}
	}

	public void displayTop() {
		WebSite aWebsite;
		System.out.println("\nDisplaying the top element... ");
		aWebsite = (WebSite) webStack.peek();
		System.out.println(aWebsite.getSiteName());
	}

	public void displayAll() {
		WebSite aWebsite;
		ArrayStack<WebSite> stack2 = new ArrayStack<WebSite>();

		while (!webStack.isEmpty()) {
				System.out.println("\nDisplaying the top element... ");
				aWebsite = (WebSite) webStack.peek();
				System.out.println(aWebsite.getSiteName());
				System.out.println("\nDeleting the top element... ");
				webStack.pop();
				stack2.push(aWebsite);
		}
		
			webStack = stack2;
			stack2 = new ArrayStack<>();
		
	}

	public void search() {
		ArrayStack<WebSite> stack3 = new ArrayStack<WebSite>();
		Scanner scan = new Scanner(System.in);
		WebSite aNewWebsite, currentWebsite;
		String name, address;
		boolean found = false;


		System.out.print("Enter the website name: ");
		name = scan.nextLine();

		System.out.print("Enter the website address: \n");
		address = scan.nextLine();

		aNewWebsite = new WebSite(name, address);

		 while (!webStack.isEmpty()) {
	            currentWebsite = webStack.pop();
	            stack3.push(currentWebsite); // Move element to temporary stack

	            if (currentWebsite.equals(aNewWebsite)) {
	                found = true;
	                System.out.println("\nWebsite found! Address: " + currentWebsite.getWebAddress());
	                break; // Exit loop once the website is found
	            }
	        }

	        // Restore the original stack after the search
	        while (!stack3.isEmpty()) {
	            webStack.push(stack3.pop());
	        }

	        // If website wasn't found, notify the user
	        if (!found) {
	            System.out.println("\nWebsite was not found in the stack.");
	        }
	}

	public static void main(String[] args) {
		new WebArrayStack();
	}
}
