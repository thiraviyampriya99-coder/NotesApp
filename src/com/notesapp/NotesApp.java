package com.notesapp;
import java.io.*;
import java.util.Scanner;
public class NotesApp {

	 private static final String FILE_NAME = "notes.txt";

	    public static void main(String[] args) {

	        Scanner sc = new Scanner(System.in);
	        int choice;

	        while (true) {
	            System.out.println("\n===== NOTES APP =====");
	            System.out.println("1. Write a Note");
	            System.out.println("2. Read Notes");
	            System.out.println("3. Exit");
	            System.out.print("Enter your choice: ");
	            choice = sc.nextInt();
	            sc.nextLine(); // consume newline

	            switch (choice) {
	                case 1:
	                    writeNote();
	                    break;

	                case 2:
	                    readNotes();
	                    break;

	                case 3:
	                    System.out.println("Exiting... Goodbye!");
	                    return;

	                default:
	                    System.out.println("Invalid choice! Try again.");
	            }
	        }
	    }

	   
	    private static void writeNote() {
	        Scanner sc = new Scanner(System.in);
	        System.out.print("Enter your note: ");
	        String note = sc.nextLine();

	        try (FileWriter fw = new FileWriter(FILE_NAME, true)) { // true = append
	            fw.write(note + "\n");
	            System.out.println("Note saved successfully!");
	        } catch (IOException e) {
	            System.out.println("Error writing file: " + e.getMessage());
	        }
	    }

	   
	    private static void readNotes() {
	        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {

	            System.out.println("\n------ Saved Notes ------");

	            String line;
	            while ((line = br.readLine()) != null) {
	                System.out.println("• " + line);
	            }

	        } catch (FileNotFoundException e) {
	            System.out.println("No notes found! Write something first.");
	        } catch (IOException e) {
	            System.out.println("Error reading file: " + e.getMessage());
	        }
	    }
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

