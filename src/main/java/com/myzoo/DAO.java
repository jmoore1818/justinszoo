package com.myzoo;

import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class DAO {

	static final String DB_URL = "jdbc:mysql://localhost:3306/?user=root&autoReconnect=true&useSSL=false";
	static final String USER = "root";
	static final String PASSWORD = "";

	static Connection CONN = null;
	static Statement STMT = null;
	static PreparedStatement PREP_STMT = null;
	static ResultSet RES_SET = null;

	static Scanner sc = new Scanner(System.in);

	public static void connToDB() {

		try {
			System.out.println("Trying to connect to the Database....");
			CONN = DriverManager.getConnection(DB_URL, USER, PASSWORD);
			System.out.println("Connected to the database.");

		} catch (SQLException e) {
			System.out.println("Connection failed");
			e.printStackTrace();
		}
	}

	public static void readFromDB() {

		connToDB();

		ArrayList<Animal> ourAnimals = new ArrayList<>();

		try {
			STMT = CONN.createStatement();
			RES_SET = STMT.executeQuery("SELECT * FROM `zoo`.Animal;");

			while (RES_SET.next()) {
				Animal AnimalInDB = new Animal();

				AnimalInDB.setAnimalID(RES_SET.getInt("animalID"));
				AnimalInDB.setAnimalSpecies(RES_SET.getString("animalSpecies"));
				AnimalInDB.setAnimalHabitat(RES_SET.getString("animalHabitat"));
				AnimalInDB.setAnimalDiet(RES_SET.getString("animalDiet"));
				AnimalInDB.setAnimalAge(RES_SET.getInt("animalAge"));

				ourAnimals.add(AnimalInDB);

			}

			for (Animal animal : ourAnimals) {
				System.out.println(animal.toString());
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	public static void writeToDB() {

		Animal animalToAdd = new Animal();

		animalToAdd = aboutTheAnimal();

		connToDB();

		try {
			PREP_STMT = CONN.prepareStatement(insertToDB);

			PREP_STMT.setString(1, animalToAdd.getAnimalSpecies());
			PREP_STMT.setString(2, animalToAdd.getAnimalHabitat());
			PREP_STMT.setString(3, animalToAdd.getAnimalDiet());
			PREP_STMT.setInt(4, animalToAdd.getAnimalAge());

			PREP_STMT.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private static String insertToDB = "INSERT INTO `zoo`.Animal"
			+ "(animalSpecies, animalHabitat, animalDiet, animalAge)" + " VALUES " + "(?, ?, ?, ?)";

	private static Animal aboutTheAnimal() {

		Animal animalToAdd = new Animal();

		System.out.println("What is the animal's species?");
		animalToAdd.setAnimalSpecies(sc.nextLine());

		System.out.println("Where does the animal live?");
		animalToAdd.setAnimalHabitat(sc.nextLine());

		System.out.println("What does the animal eat?");
		animalToAdd.setAnimalDiet(sc.nextLine());

		System.out.println("How old is the animal?");
		animalToAdd.setAnimalAge(Integer.parseInt(sc.nextLine()));

		return animalToAdd;

	}

}
