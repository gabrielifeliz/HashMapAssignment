package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Scanner;

public class HashMapAssignment {

    public static void main(String[] args) {

        Scanner keyboard = new Scanner(System.in);

        HashMap<Integer, String> myMap = new HashMap<>();
        int number, loopCount = 0;
        String value;

        while (loopCount != 3) {

            System.out.print((loopCount == 0) ? "Enter a number: " : "\nEnter a number: ");
            number = keyboard.nextInt();


            if (myMap.containsKey(number)) {
                System.out.println("You entered " + myMap.get(number));
            } else {
                keyboard.nextLine();
                System.out.print("Enter value for " + number + ": ");
                value = keyboard.nextLine();
                myMap.put(number, value);
            }
            loopCount++;
        }

        try {
            PrintWriter writeOnFile = new PrintWriter("input.txt");
            for (Integer key : myMap.keySet()) {
                writeOnFile.println(key + " " + myMap.get(key));
            }
            writeOnFile.close();

            File file = new File("input.txt");
            Scanner scannerInput = new Scanner(file);//note that Scanner can read from a file!
            while (scannerInput.hasNextLine())
                System.out.println(scannerInput.nextLine());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
