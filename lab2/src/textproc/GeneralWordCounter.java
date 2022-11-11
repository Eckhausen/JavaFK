package textproc;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class GeneralWordCounter implements TextProcessor{
    private Set<String> stopWords;
    private Map<String, Integer> words = new TreeMap<>();

    //Skapar ett set med stoppord.
    public GeneralWordCounter(Set<String> input) throws FileNotFoundException{
        stopWords = input;
    }

    public void process(String w) {
        if(!stopWords.contains(w)){ //Finns den inte med i stopwords...
            if(!words.containsKey(w)){ //Finns den inte med i mapen...
                words.put(w, 1);
            } else {
                words.put(w, words.get(w) + 1);
            }
        }
    }

    public void report() {
        Set<Map.Entry<String, Integer>> wordSet = words.entrySet();
        List<Map.Entry<String, Integer>> wordList = new ArrayList<>(wordSet);

        //Sortera listan.
        wordList.sort((first, second) -> {
            if(first.getValue() == second.getValue()){
                return second.getKey().compareTo(first.getKey());
            } else {
                return second.getValue() - first.getValue();   
            } 
        });

        for(int i = 0; i < 5; i++){
            System.out.println(wordList.get(i));
        }
       
        // for(String key : words.keySet()){
        //     if(words.get(key) > 200){
        //         System.out.println(key + ": " + words.get(key));
        //     }
        // }        
    }

    public List<Map.Entry<String, Integer>> getWordList(){
        Set<Map.Entry<String, Integer>> wordSet = words.entrySet();
        List<Map.Entry<String, Integer>> wordList = new ArrayList<>(wordSet);

        return wordList;
    }
    
    
}
