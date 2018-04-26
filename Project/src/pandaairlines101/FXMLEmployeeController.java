/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pandaairlines101;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * FXML Controller class
 *
 * @author ky94
 */
public class FXMLEmployeeController implements Initializable {

    @FXML
    private Label volarraddress;
    @FXML
    private Label voldepaddress;
    @FXML
    private Label voldep;
    @FXML
    private Label volarr;
    @FXML
    private Label usernamelabel;
    @FXML
    private ImageView nexticon;
    @FXML
    private ImageView previcon;
    @FXML
    private ImageView beautifyicon;
    @FXML
    private ImageView vdep;
    @FXML
    private ImageView varr;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        nexticon.setImage(new Image("file:///C:/Users/ky94/OneDrive/Documents/TIC-S2/POO%20&%20JAVA/MiniProjet/PandasAirlines/Project/img/next_on.png"));
        nexticon.setCache(false);
        previcon.setImage(new Image("file:///C:/Users/ky94/OneDrive/Documents/TIC-S2/POO%20&%20JAVA/MiniProjet/PandasAirlines/Project/img/prev_on.png"));
        previcon.setCache(false);
        beautifyicon.setImage(new Image("file:///C:/Users/ky94/OneDrive/Documents/TIC-S2/POO%20&%20JAVA/MiniProjet/PandasAirlines/Project/img/nextflight.png"));
        beautifyicon.setCache(false);
        vdep.setImage(new Image("file:///C:/Users/ky94/OneDrive/Documents/TIC-S2/POO%20&%20JAVA/MiniProjet/PandasAirlines/Project/img/airplaneoff.png"));
        vdep.setCache(false);
        varr.setImage(new Image("file:///C:/Users/ky94/OneDrive/Documents/TIC-S2/POO%20&%20JAVA/MiniProjet/PandasAirlines/Project/img/airplaneon.png"));
        varr.setCache(false);
        
    }    
    
}
