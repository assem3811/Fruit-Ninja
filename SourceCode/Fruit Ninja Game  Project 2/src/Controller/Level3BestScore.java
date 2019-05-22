package Controller;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Level3BestScore extends Level1BestScore {

    /* private Scanner  read ;*/
    ArrayList<Integer> arrlist = new ArrayList<Integer>();
    int i =0;


    @Override
    public void writeToFile(int bestscore) {

        try {

            FileWriter fr = new FileWriter("E:\\Fruit Ninja Game  Project 2\\src\\Controller\\High Scores\\highScoresLevel3.txt", true);
            BufferedWriter br = new BufferedWriter(fr);
            PrintWriter out = new PrintWriter(br);
            out.write(String.valueOf(bestscore));
            out.write("\n");
            br.newLine();
            out.close();
        } catch (IOException e) {
            System.out.println(e);
        }

    }

    @Override
    public ArrayList<Integer> ReadFromFile()
    {

        Scanner scanner = null;
        try {
            scanner = new Scanner(new File("E:\\Fruit Ninja Game  Project 2\\src\\Controller\\High Scores\\highScoresLevel3.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        int i = 0;
        while(scanner.hasNextInt())
        {
            arrlist .add (scanner.nextInt()) ;
            // System.out.println(arrlist.get(i));
            // i++;

        }

        return arrlist ;
    }

    @Override
    public void CompareBestScore(int bestScore)
    {
        Scanner scanner = null;
        try {
            scanner = new Scanner(new File("E:\\Fruit Ninja Game  Project 2\\src\\Controller\\High Scores\\highScoresLevel3.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        while(!scanner.hasNextInt())
        {
            writeToFile(bestScore);
            break;
        }
        if (bestScore>ReadFromFile().get(ReadFromFile().size()-1))
        {
            writeToFile(bestScore);

        }

    }
}
