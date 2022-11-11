package textproc;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.util.Map;
import javax.swing.*;



public class BookReaderController {
    public BookReaderController(GeneralWordCounter counter){
        SwingUtilities.invokeLater(() -> createWindow(counter, "BookReader", 100, 300));
    }

    private void createWindow(GeneralWordCounter counter, String title, int width, int height) {
        //Skapa fram och container.
        JFrame frame = new JFrame(title);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container pane = frame.getContentPane();
        
        //##################################################################
        //Skapa listmodel-obj & listvyn.
        SortedListModel<Map.Entry<String, Integer>> listModel = new SortedListModel<>(counter.getWordList());
        JList<Map.Entry<String, Integer>> listView = new JList<>(listModel);
        listView.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        //##################################################################
        JScrollPane scrollPane = new JScrollPane(listView);
        scrollPane.setPreferredSize(new Dimension (500,500));
        pane.add(scrollPane, null);

        //Skapar knapparna
        JPanel southPanel = new JPanel();
        JButton alphabetic = new JButton("Alphabetic");
        JButton frequency = new JButton("Frequency");
        JTextField searchField = new JTextField("Enter word", 10);
        JButton find = new JButton("Find!");
        
        southPanel.add(alphabetic);
        southPanel.add(frequency);
        southPanel.add(searchField);
        southPanel.add(find);
        pane.add(southPanel, BorderLayout.SOUTH);        
        
        alphabetic.addActionListener(event -> {
            System.out.println("Alphabetic pressed.");
            listModel.sort((e1, e2) -> 
                (e1.getKey()).compareTo(e2.getKey())
            );
        });

        frequency.addActionListener(event -> {
            System.out.println("Frequency pressed.");
            listModel.sort((e1, e2) -> 
                (e2.getValue()).compareTo(e1.getValue())
            );
        });

        frame.getRootPane().setDefaultButton(find); //Valfri 3
        find.addActionListener(event -> {
            System.out.println("Find pressed.");
            String searchTerm = searchField.getText().trim().toLowerCase(); //Valfri 1 
            int index = -1;
            Boolean found = false;
            for (int i = 0; i < listModel.getSize(); i++){
                if(listModel.getElementAt(i).getKey().equals(searchTerm)){ 
                    index = i;
                    searchField.setText("");
                    found = true;
                }
            }
            if(!found) JOptionPane.showMessageDialog(null, "Search term not found!"); //Valfri 2
            listView.ensureIndexIsVisible(index);
            listView.setSelectedIndex(index);
        });
       
        //##################################################################
        frame.pack();
        frame.setVisible(true);
    } 
}
//###########################(╯°□°）╯︵ ┻━┻#################################
//**Swing (liksom många motsvarigheter, som Android och JavaFX) bygger på en princip 
//som kallas för Hollywoodprincipen: ”Don’t call us – we’ll call you!”
//Kan du se i ditt program vad som menas med detta?
//---

//**Varför passar lambdauttryck särskilt bra ihop med denna princip?
//Förkorta uttryck och slipp skriva hela metoder för en knapp som används en gång. 

//**När kontrolldelen av ditt program ändrar ordningen i ordlistan uppdateras använ-
//dargränssnittet automatiskt. Kan du förstå något om hur det hänger ihop?
//fireContentsChanged ändrar automatiskt?

//#########################################################################