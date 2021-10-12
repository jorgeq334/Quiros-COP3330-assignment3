package Ex45;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Jorge Quiros
 */
public class WordFinder {
    public static void main(String[] args) throws IOException {

        Scanner name = new Scanner(System.in);

        System.out.print("\nEnter the output file name : ");

        String outputfile = name.next();

        ReadFile rf = new ReadFile();

        rf.readFile();

        ArrayList<String> list = rf.getdata();

        WriteFile wr = new WriteFile(outputfile, list);

        wr.writeFile();

    }

}

class ReadFile{

    private ArrayList<String> list;
    private Scanner sc;

    public ReadFile() throws FileNotFoundException {

        list = new ArrayList<String>();

        File file = new File("src/main/java/Ex45/exercise45_input.txt");
        sc = new Scanner(file);

    }

    public void readFile() {

        try
        {
            int i=0;

            while( sc.hasNext() )
            {

                String filedata = sc.nextLine();

                list.add(filedata);

            }
        }
        finally
        {
            sc.close();
        }

    }

    public ArrayList<String> getdata() {

        return list;

    }

}

class WriteFile{

    private FileWriter writer;
    private int count_Modification;
    private ArrayList<String> list;

    public WriteFile(String name, ArrayList<String> list) throws IOException {
        writer = new FileWriter("C:\\Users\\Ankit\\Desktop\\"+name);
        this.list = list;
    }

    public void writeFile() throws IOException {

        for(int i=0;i<list.size();i++) {

            String temp = list.get(i);

            String str = "utilize";

            int index = 0;

            while (true)
            {
                index = temp.indexOf(str, index);
                if (index != -1)
                {
                    count_Modification ++;
                    index += str.length();
                }
                else {
                    break;
                }
            }

            temp = temp.replaceAll("utilize", "use");

            writer.write(temp+"\n");
        }
        writer.close();

    }

    public int getModification() {

        return count_Modification;

    }


}
