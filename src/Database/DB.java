package Database;

import buisness_layer.DBInterface;
import javafx.event.ActionEvent;
import buisness_layer.implementation;

import java.io.IOException;
import java.sql.*;

import javafx.scene.input.KeyEvent;

import javax.swing.*;

public class DB{
public Connection database;
String dbname="db";
String url="jdbc:mysql://localhost/" + dbname;


    public void Savetodatabase(JTextField filename,JTextField location) {
        PreparedStatement pst=null;
//getDatabase();
DBconnnection dBconnnection=new DBconnnection();
Connection connect=dBconnnection.getDatabase();

        try {

            String fn=filename.getText();
String dirname=location.getText();
Statement   stm=connect.createStatement();
pst=connect.prepareStatement("Insert into filedata values(?,?)");

            
        
//String sql="Insert into filedata values(?,?)";
pst.setString(1,fn);
pst.setString(2,dirname);
pst.executeUpdate();

//ResultSet rs=stm.executeQuery(sql);

        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    public void cut(ActionEvent actionEvent) {
    }

    public void copy(ActionEvent actionEvent) {
    }

    public void processkeyevent(KeyEvent event) {
    }
}
