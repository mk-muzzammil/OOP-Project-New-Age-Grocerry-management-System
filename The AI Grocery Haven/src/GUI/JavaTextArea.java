package GUI;

import javax.swing.*;
import java.util.ArrayList;

public class JavaTextArea {
    public static void main(String[] args) {
        JTextArea textArea = new JTextArea();
        ArrayList<String> arrayList = new ArrayList<>();

        arrayList.add("Element 1");
        arrayList.add("Element 2");
        // Add more elements as needed

        for (String element : arrayList) {
            textArea.append(element + "\n");
        }

        textArea.setEditable(false);

        JFrame frame = new JFrame();
        frame.getContentPane().add(new JScrollPane(textArea));
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}