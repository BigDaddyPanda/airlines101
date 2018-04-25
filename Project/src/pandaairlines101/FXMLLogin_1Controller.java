/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pandaairlines101;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import pandaairlines.humanoid.Personnel;

/**
 * FXML Controller class
 *
 * @author ky94
 */
public class FXMLLogin_1Controller implements Initializable {

    @FXML
    private AnchorPane ap;
    @FXML
    private ImageView logo;
    @FXML
    private JFXTextField login;
    @FXML
    private JFXPasswordField password;
    @FXML
    private JFXButton loginBtn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void Handle(MouseEvent event) {
    }

    @FXML
    private void login(ActionEvent event) {
        if (Personnel.login(login.getText(), password.getText())) {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("FXMLUser.fxml"));
            Parent page2 = null;
            try {
                page2 = fxmlLoader.load();
            } catch (IOException ex) {
                System.err.println("FXMLLoad " + ex);
            }

            Scene scene2 = new Scene(page2);
            Stage app_stage = (Stage) ap.getScene().getWindow();

            app_stage.setTitle("Welcome to PANDA-AIRLINES");
            app_stage.setScene(scene2);
            app_stage.show();
        }
        else{
            System.out.println("Bad entry");
        }
    }
}
