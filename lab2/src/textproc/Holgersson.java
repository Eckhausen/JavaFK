package textproc;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Holgersson {

	public static final String[] REGIONS = { "blekinge", "bohuslän", "dalarna", "dalsland", "gotland", "gästrikland",
			"halland", "hälsingland", "härjedalen", "jämtland", "lappland", "medelpad", "närke", "skåne", "småland",
			"södermanland", "uppland", "värmland", "västerbotten", "västergötland", "västmanland", "ångermanland",
			"öland", "östergötland" };

		public static void main(String[] args) throws FileNotFoundException {
		
		long t0 = System.nanoTime();	
		Set <String> stopWords = new HashSet<String>();
		ArrayList<TextProcessor> list = new ArrayList<>();
		
		list.add(new SingleWordCounter("nils"));
		list.add(new SingleWordCounter("norge"));
		list.add(new MultiWordCounter(REGIONS));
		list.add(new GeneralWordCounter(stopWords));
		// TextProcessor p = new SingleWordCounter("nils");
		// TextProcessor norge = new SingleWordCounter("norge");
		// TextProcessor r = new GeneralWordCounter(stopWords);
		// TextProcessor regions = new MultiWordCounter(REGIONS);
		
		// list.add(p);
		// list.add(norge);
		// list.add(r);
		// list.add(regions);
		
		//Holgersson text
		Scanner s = new Scanner(new File("C:\\Users\\Anton Eckhausen\\Desktop\\Java\\experimental_vscode_workspace_v1\\experimental_vscode_workspace_v1\\lab2\\nilsholg.txt"), "UTF-8");
		
		//Stopp orden
		Scanner scan = new Scanner(new File("C:\\Users\\Anton Eckhausen\\Desktop\\Java\\experimental_vscode_workspace_v1\\experimental_vscode_workspace_v1\\lab2\\undantagsord.txt"), "UTF-8");
		
		//Lägger till undantagsorden i ett HashSet.
		while(scan.hasNext()){
			stopWords.add(scan.next().toLowerCase());
		}
		
		s.findWithinHorizon("\uFEFF", 1);
		s.useDelimiter("(\\s|,|\\.|:|;|!|\\?|'|\\\")+"); // se handledning

		while (s.hasNext()) {
			String word = s.next().toLowerCase();

			for(TextProcessor tp : list){
				tp.process(word);
			}
		}

		s.close();

		for(TextProcessor tp : list){
			tp.report();
		}
		long t1 = System.nanoTime();
		System.out.println("Tid: " + (t1-t0)/1000000.0 + " ms.");	

	}
}