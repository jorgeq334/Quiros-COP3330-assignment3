package Ex46;
import java.util.*;
import java.io.*;
/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Jorge Quiros
 */
public class WordFrequency {
    public static void main(String args[]) throws IOException {
        Scanner file=new Scanner(new File("src/main/java/Ex46/exercise46_input.txt"));
        Map<String,Integer> input=new TreeMap<String,Integer>();

        while(file.hasNext()) {
            String str=file.next();
            if(input.containsKey(str))
                input.put(str,input.get(str)+1);
            else
                input.put(str,1);
        }

        for(String key:input.keySet()) {
            System.out.printf("%-10s",key+":");
            for(int i=input.get(key);i>0;i--)
                System.out.print("*");
            System.out.println();
        }

    }
}
