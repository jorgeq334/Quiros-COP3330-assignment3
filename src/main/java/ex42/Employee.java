package ex42;
import java.util.*;
import java.io.*;
/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Jorge Quiros
 */
public class Employee {


    public void printDetails(String filename) {
        try {
            File file = new File(filename);
            Scanner input = new Scanner(file);

            while (input.hasNext()) {
                String s = input.nextLine();
                String[] temp = s.split(",");
                System.out.printf("%-17s%-17s%-17s\n", temp[0], temp[1], temp[2]);
            }

        } catch (FileNotFoundException ex) {
            System.out.println("Error: File Not Found!!");
        }
    }


    public static void main(String[] args) {

        Employee emp = new Employee();
        System.out.printf("%-17s%-17s%-17s\n", "Last", "First", "Salary");
        System.out.println("----------------------------------------");
        emp.printDetails("src/main/java/ex42/exercise42_input.txt");
    }
}
