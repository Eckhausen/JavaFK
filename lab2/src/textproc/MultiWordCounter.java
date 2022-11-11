package textproc;

import java.util.Map;
import java.util.TreeMap;

public class MultiWordCounter implements TextProcessor {
    private Map<String, Integer> wordsMap = new TreeMap<>();

    public MultiWordCounter(String[] words){
        for(String s : words){
            this.wordsMap.put(s, 0);
        }
    }
    
    public void process(String w) {
        // if(!wordsMap.containsKey(w)){
        //     wordsMap.put(w, 1);
        // } else {
        //     wordsMap.put(w, wordsMap.get(w)+ 1);
        // }
        for(String key : wordsMap.keySet()){
            if(w.equals(key)){
                wordsMap.put(key, wordsMap.get(key)+ 1);
            }
        }
    }

    
    public void report(){
        for(String key: wordsMap.keySet()){
            System.out.println(key + ": " + wordsMap.get(key));
        }
    }
}
