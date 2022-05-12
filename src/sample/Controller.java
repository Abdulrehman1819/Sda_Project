package sample;

import buisness_layer.buisnessinter;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;
import javax.swing.*;
import java.awt.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
 public abstract   class Controller implements uiinterface {

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
  public abstract  void P(ActionEvent event);

    @FXML
   public abstract void copy(ActionEvent event);

    @FXML
   public abstract void cut(ActionEvent event);

    @FXML
    public abstract void processkeyevent(KeyEvent event);
}
