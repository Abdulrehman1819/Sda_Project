package buisness_layer;
import java.io.IOException;
import java.sql.Connection;
import Database.DB;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyListener;
import java.io.BufferedWriter;
import java.io.FileWriter;

public class implementation implements buisnessinter{
Button btn1;
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
        else if(keyCode.equals(keyCode.UP)){
            int c=textArea.getCaretPosition();
            System.out.println(c);
            textArea.positionCaret(textArea.getCaretPosition()+1);

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
            //saveTheFile();
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
    public void Savefile(ActionEvent actionEvent) throws IOException {
        System.out.println("wow");
saveTheFile();

        DB obj = new DB();
        obj.Savetodatabase(fileName,dirName);

    }
    public void saveTheFile() throws IOException {
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
        DB obj=new DB();
        obj.Savetodatabase(fileName,dirName);
    }

    private void Movetodatabase() throws IOException {
        System.out.println("Move");
        Parent root = FXMLLoader.load(getClass().getResource("database.fxml"));
        Stage window= (Stage) btn1.getScene().getWindow();
        window.setScene(new Scene(root,500,500));
window.setTitle("Database");


    }
}

