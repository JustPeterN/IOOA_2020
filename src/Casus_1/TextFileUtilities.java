package Casus_1;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;


public class TextFileUtilities {

    public static ArrayList<String> leesRuweTekst(String locatie) {

        ArrayList<String> result = new ArrayList<>();

        try (BufferedReader bufReader = new BufferedReader(new FileReader(locatie))) {

            while (bufReader.ready()) {
                result.add(bufReader.readLine());
            }

        } catch (FileNotFoundException fnfe) {
            System.out.println("File not found");
        } catch (IOException ioe) {
            System.out.println("IOExeption");
        }
        return result;
    }

    public static String opschonenwoord(String word){

        word = word.replaceAll("\\p{Punct}","");

        return word.toLowerCase();
    }

    public static void hashmapToFile(HashMap<String, Integer> word2frequency, String locatie){

        try(PrintWriter prWriter = new PrintWriter("src\\Casus_1\\" + locatie)){
            for(String word: word2frequency.keySet()){
                prWriter.write(word + " " + word2frequency.get(word) + "\n");
            }
        }catch (IOException ioe){
            System.out.println("IOExeption");
        }

    }
}
