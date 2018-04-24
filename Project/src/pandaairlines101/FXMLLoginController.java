/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pandaairlines101;

import java.awt.TextField;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ky94
 */
public class FXMLLoginController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private TextField login;
            
    @FXML
    private PasswordField password;
    @FXML
    private AnchorPane ap;
    @FXML
    private Button btn2;

    public void Handle(MouseEvent event) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("FXMLLogin.fxml"));
        Parent page2 = null;
        try {
            page2 = fxmlLoader.load();
        } catch (IOException ex) {
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb
    ) {
        // TODO
    }

}
