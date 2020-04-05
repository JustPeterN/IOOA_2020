package Casus_1;

import java.util.ArrayList;
import java.util.HashMap;

public class TextMining {

    public static void main(String[] args) {

        ArrayList<String> result = TextFileUtilities.leesRuweTekst("src\\Casus_1\\dik_trom.txt");
        HashMap<String, Integer> word2frequency = new HashMap<>();

        for(String line : result){
            for(String word : line.split(" ")){
                word = TextFileUtilities.opschonenwoord(word);
                if(!word.equals("")){
                    if(word2frequency.containsKey(word)){
                        int count = word2frequency.get(word);
                        word2frequency.replace(word, count + 1);
                    }else{
                        word2frequency.put(word,1);

                    }
                }
            }
        }
        TextFileUtilities.hashmapToFile(word2frequency, "results.txt");
    }
}
