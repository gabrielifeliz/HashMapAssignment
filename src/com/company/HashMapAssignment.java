package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Collections;

public class HashMapAssignment {

    public static void main(String[] args) {

        Scanner keyboard = new Scanner(System.in);

        // Create HashMap to add a list of numbers and their spelled out names
        HashMap<Integer, String> myMap = new HashMap<>();
        // Add initial list of numbers and their spelled out names
        myMap.put(10, "ten");
        myMap.put(20, "twenty");
        myMap.put(30, "thirty");

        // Declare int variable to store user input for the keys in HashMap
        // Declare and initialize loop count
        int number, loopCount = 0;
        // Declare and initialize String variable to yes to enter the while loop
        String value = "yes";

        while (value.equalsIgnoreCase("yes")) {

            // Display "Enter a number: " without a newline character before it if it's the first time shown
            // Otherwise, don't include the newline character
            System.out.print((loopCount == 0) ? "Enter a number: " : "\nEnter a number: ");
            // Receive integer from the user
            number = keyboard.nextInt();

            if (myMap.containsKey(number)) {
                // If the entered integer is a current key in the HashMap, display its value
                System.out.println("You entered " + myMap.get(number));
                // Ask the user whether he/she wants to continue entering numbers and get its answer
                System.out.print("Would you like to continue entering numbers (\"yes\" or \"no\")? ");
                keyboard.nextLine(); // Clean up extra newline character
                value = keyboard.nextLine();
            } else {
                keyboard.nextLine(); // Clean up extra newline character
                // If the entered integer is not a current key in the HashMap,
                // let the user designate a value for it
                System.out.print("Enter value for " + number + ": ");
                value = keyboard.nextLine();
                // Add the key and value from user input
                myMap.put(number, value);
                // Ask the user whether he/she wants to continue entering numbers and get its answer
                System.out.print("Would you like to continue entering numbers (\"yes\" or \"no\")? ");
                value = keyboard.nextLine();
            }

            // Increase loop count to one
            loopCount++;
        }

        try {
            // Create PrintWriter object to write to a file
            PrintWriter writeOnFile = new PrintWriter("input.txt");
            // Write content in myMap to the input.txt file using an enhanced for loop
            for (Integer key : myMap.keySet()) {
                writeOnFile.println(((key.compareTo(9) < 1) ? ("0" + key) : (key)) + " " + myMap.get(key));
            }
            // Close PrintWriter object to stop writing to input.txt
            writeOnFile.close();

            // Create File object that contains what is on input.txt
            File file = new File("input.txt");
            Scanner scannerInput = new Scanner(file);//note that Scanner can read from a file!
            // Create ArrayList for displaying purposes
            ArrayList<String> numbersList = new ArrayList<>();
            System.out.println();
            // Add content to numbersList while there is content to read
            while (scannerInput.hasNextLine())
                numbersList.add(scannerInput.nextLine());

            // Sort numbersList
            Collections.sort(numbersList);

            // Display content in numbersList
            for (String list : numbersList)
                System.out.println(list);

        } catch (FileNotFoundException e) {
            // If the file does not exist, display a message to let the user know about it
           System.out.println("File not found...");
        }
    }
}
