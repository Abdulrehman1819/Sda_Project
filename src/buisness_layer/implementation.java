package buisness_layer;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyListener;
import java.io.BufferedWriter;
import java.io.FileWriter;

public class implementation implements buisnessinter {

    static String newline = "\n";
    JFrame f;
    static int newlineLength = newline.length();
    JPanel saveFileOptionWindow;
    JLabel fileLabel, dirLabel;
    JTextField fileName, dirName;
    private final Clipboard clipboard = Clipboard.getSystemClipboard();
    @FXML
    private TextArea textArea;
    @FXML
    public void processkeyevent(KeyEvent event) {
        String type = event.getEventType().getName();
        KeyCode keyCode = event.getCode();
        // System.out.println("Type: " + type + " Code: " + keyCode);
        //textArea.setText("text");
        if (keyCode.equals(KeyCode.Y)) {
            textArea.setOnKeyPressed(this::anothery);
            //        int caret = textArea.getCaretPosition();
            //      int lineStart = caret;
            //    int lineEnd = caret;
            //  while (lineStart > 0 && !textArea.getText(lineStart, lineEnd).startsWith(newline))
            //    lineStart--;
            //textArea.selectRange(lineStart,lineEnd);

        }
       /* if(keyCode.equals(keyCode.H)){
            int c=textArea.getCaretPosition();

            textArea.selectPositionCaret(c);
c=c+100;
            textArea.positionCaret(textArea.getText().indexOf(c));
        }*/
        else if (keyCode.equals(keyCode.P)) {
            textArea.setOnKeyPressed(this::paste);
            textArea.setOnKeyPressed(this::processkeyevent);
        }
        //copyToClipboard(textArea.getSelectedText().trim());
        else if (keyCode.equals(keyCode.I)) {
            textArea.setEditable(true);
            textArea.setText("You Have Entered Edit Mode");

            textArea.setOnKeyPressed(this::processkeyevent);
        }
        if (keyCode.equals(keyCode.ESCAPE)) {
            textArea.setEditable(false);
            if (keyCode.equals(KeyCode.Y)) {
                textArea.setOnKeyPressed(this::anothery);
                //        int caret = textArea.getCaretPosition();
                //      int lineStart = caret;
                //    int lineEnd = caret;
                //  while (lineStart > 0 && !textArea.getText(lineStart, lineEnd).startsWith(newline))
                //    lineStart--;
                //textArea.selectRange(lineStart,lineEnd);

            } else if (keyCode.equals(KeyCode.D)) {
                textArea.setOnKeyPressed(this::anotherd);
           /*     int caret = textArea.getCaretPosition();
                int lineStart = caret;
                int lineEnd = caret;
                while (lineStart > 0 && !textArea.getText(lineStart, lineEnd).startsWith(newline))
                    lineStart--;
                textArea.selectRange(lineStart,lineEnd);
                textArea.deleteText(textArea.getSelection());*/
                textArea.setOnKeyPressed(this::processkeyevent);
            }
else if(keyCode.equals(KeyCode.QUOTE)){
                System.out.println("Y");
                        
savecurrentbuffer();
            }
        }
        else if(keyCode.equals(KeyCode.QUOTE)){
            savecurrentbuffer();
        }
        if (keyCode.equals(KeyCode.D)) {
            textArea.setOnKeyPressed(this::anotherd);
            /*int caret = textArea.getCaretPosition();
            int lineStart = caret;
            int lineEnd = caret;
            while (lineStart > 0 && !textArea.getText(lineStart, lineEnd).startsWith(newline))
                lineStart--;
            textArea.selectRange(lineStart,lineEnd);
            textArea.deleteText(textArea.getSelection());
            textArea.setOnKeyPressed(this::processkeyevent);*/
        } else if (keyCode.equals(keyCode.SEMICOLON)) {
            saveTheFile();
        }

    }


    @FXML
    public void P(ActionEvent event) {
        textArea.paste();
    }

    @FXML
    public void copy(ActionEvent event) {
        textArea.copy();
    }

    @FXML
    public void cut(ActionEvent event) {
        textArea.cut();
    }
public void paste(javafx.scene.input.KeyEvent event){
        textArea.paste();
}
public void anotherd(javafx.scene.input.KeyEvent event){
    KeyCode keyCode=event.getCode();
        if(keyCode.equals(keyCode.D)){
            int caret = textArea.getCaretPosition();
            int lineStart = caret;
            int lineEnd = caret;
            while (lineStart > 0 && !textArea.getText(lineStart, lineEnd).startsWith(newline))
                lineStart--;
            textArea.selectRange(lineStart,lineEnd);
            textArea.deleteText(textArea.getSelection());
            textArea.setOnKeyPressed(this::processkeyevent);
        }
}
    public void anothery(javafx.scene.input.KeyEvent event)
{
    KeyCode keyCode = event.getCode();
    if (keyCode.equals(KeyCode.Y)  ) {
        int caret = textArea.getCaretPosition();
        int lineStart = caret;
        int lineEnd = caret;
        while (lineStart > 0 && !textArea.getText(lineStart, lineEnd).startsWith(newline))
            lineStart--;
        textArea.selectRange(lineStart,lineEnd);

    }
    copyToClipboard(textArea.getSelectedText().trim());

}

    public void copyToClipboard(String s) {
        if (s.length() > 0) {
            final ClipboardContent content = new ClipboardContent();
            content.putString(s);
            clipboard.setContent(content);
        }
        textArea.setOnKeyPressed(this::processkeyevent);
    }
public void savecurrentbuffer(){
 //   saveFileOptionWindow = new JPanel(new GridLayout(1,1));
    fileLabel = new JLabel();
    dirLabel = new JLabel();
    fileName = new JTextField();
    dirName = new JTextField();

   // saveFileOptionWindow.add(fileLabel);
    //saveFileOptionWindow.add(fileName);
    //saveFileOptionWindow.add(dirLabel);
    //saveFileOptionWindow.add(dirName);

    //JOptionPane.showMessageDialog(f,saveFileOptionWindow); //show the saving dialogue box
    String fileContent = textArea.getText();
    //String filePath = dirName.getText();
String filePath="C:/Users/Abdulrehman/Desktop/aa.txt";
    try {
        BufferedWriter writeContent = new BufferedWriter(new FileWriter(filePath));
        writeContent.write(fileContent);
        writeContent.close();
        JOptionPane.showMessageDialog(f,"File Successfully saved!");
    }catch (Exception ex){
        ex.printStackTrace();
    }
}
    public void saveTheFile(){
        saveFileOptionWindow = new JPanel(new GridLayout(2,1));
        fileLabel = new JLabel("Filename      :- ");
        dirLabel = new JLabel("Save File To :- ");
        fileName = new JTextField();
        dirName = new JTextField();

        saveFileOptionWindow.add(fileLabel);
        saveFileOptionWindow.add(fileName);
        saveFileOptionWindow.add(dirLabel);
        saveFileOptionWindow.add(dirName);

        JOptionPane.showMessageDialog(f,saveFileOptionWindow); //show the saving dialogue box
        String fileContent = textArea.getText();
        String filePath = dirName.getText();

        try {
            BufferedWriter writeContent = new BufferedWriter(new FileWriter(filePath));
            writeContent.write(fileContent);
            writeContent.close();
            JOptionPane.showMessageDialog(f,"File Successfully saved!");
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
}

