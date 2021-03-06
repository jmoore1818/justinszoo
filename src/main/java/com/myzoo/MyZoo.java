package com.myzoo;

import java.util.Scanner;

public class MyZoo {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		String userMenuInput = null;
		boolean menuCorrect = false;

		System.out.println("Welcome to the student information program");

		do {
			System.out.println("Press 1 to read the DB" + "\nPress 2 to add to the database");
			userMenuInput = sc.nextLine();
			switch (userMenuInput) {
			case "1":
				DAO.readFromDB();
				break;
			case "2":
				DAO.writeToDB();
				break;

			default:
				System.out.println("You've entered an invalid option");
				menuCorrect = true;
				break;
			}

		} while (menuCorrect);

		sc.close();
	}

}