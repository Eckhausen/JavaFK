package textproc;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class BookReaderApplication {
    public static void main(String[] args) throws FileNotFoundException {
        Set<String> stopWords = new HashSet<String>();
        
       //Holgersson text
		Scanner s = new Scanner(new File("lab3\\nilsholg.txt"), "UTF-8");
		
		//Stopp orden
		Scanner scan = new Scanner(new File("lab3\\undantagsord.txt"), "UTF-8");
		
		//Lägger till undantagsorden i ett HashSet.
		while(scan.hasNext()){
			stopWords.add(scan.next().toLowerCase());
		}
		
		s.findWithinHorizon("\uFEFF", 1);
		s.useDelimiter("(\\s|,|\\.|:|;|!|\\?|'|\\\")+"); // se handledning
		
		GeneralWordCounter counter = new GeneralWordCounter(stopWords);
		
		while (s.hasNext()) {
			String word = s.next().toLowerCase();
			counter.process(word);
			
		}

		s.close();

		//BookReaderController reader = 
		new BookReaderController(counter);


    }
}
