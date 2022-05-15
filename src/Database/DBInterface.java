package Database;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.input.KeyEvent;

public interface DBInterface {
    @FXML
    public void processkeyevent(KeyEvent event);
    @FXML
    public  void cut(ActionEvent event);
    @FXML
    public void P(ActionEvent event);
    @FXML
    public void copy(ActionEvent event);
    
}
