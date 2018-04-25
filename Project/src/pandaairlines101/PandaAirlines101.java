/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pandaairlines101;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import pandaairlines.db_cnx.dbcnx;

/**
 *
 * @author ky94
 */
public class PandaAirlines101 extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLLogin_1.fxml"));
        Scene scene = new Scene(root);
        stage.setTitle("PANDA-AIRLINES");
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void stop() {
        try {
            dbcnx.deconnecter();
        } catch (Exception e) {
            System.out.println("Bye");
        }
        // Save file
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
