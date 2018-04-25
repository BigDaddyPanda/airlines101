/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pandaairlines101;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import pandaairlines.db_cnx.dbcnx;
import pandaairlines.vol.Vol;

/**
 * FXML Controller class
 *
 * @author amin ayed
 */
public class FXMLUserController implements Initializable {

    @FXML
    private JFXListView<?> listview;
    @FXML
    private Label aeroportdeparthistoriquelabel;
    @FXML
    private Label aeroportarrivehistoriquelabel;
    @FXML
    private Label volidlabel;
    @FXML
    private Label usernamelabel;
    @FXML
    private JFXTextField filtrer;
    @FXML
    private Label aeroportarrivelabel;
    @FXML
    private Label datedepartlabel;
    @FXML
    private Label aeroportdepartlabel;
    @FXML
    private JFXButton reserverbtn;
    @FXML
    private Label prixlabel;
    @FXML
    private Label timedepartlabel;
    @FXML
    private Label timearrivelabel;
    @FXML
    private Label datearrivelabel;
    @FXML
    private Label paysdepartlabel;
    @FXML
    private Label paysarrivelabel;
    @FXML
    private ImageView nextbtn;
    @FXML
    private ImageView previousbtn;
    @FXML
    private ImageView usernameicon;
    @FXML
    private ImageView dep_icon;
    @FXML
    private ImageView arr_icon;
    @FXML
    private ImageView reservationicon;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void reserver(MouseEvent event) {
        Vol vol = (Vol) listview.getOnMouseClicked();
        Vol.ajouterClient(dbcnx.identifier, vol.getVolId());
    }

    @FXML
    private void next(MouseEvent event) {
        ArrayList<Vol> v = Vol.rechercherReserves(dbcnx.identifier);

        Vol vol = Vol.recherchevol(Integer.getInteger(volidlabel.getText()));
        int idvol = v.get(v.indexOf(vol)).getVolId();

        aeroportdeparthistoriquelabel.setText(v.get(v.indexOf(vol) + 1).getvDepart());
        aeroportarrivehistoriquelabel.setText(v.get(v.indexOf(vol) + 1).getvArrive());
        volidlabel.setText(Integer.toString(v.get(v.indexOf(vol) + 1).getVolId()));
    }


    @FXML
    private void previous(MouseEvent event) {
    }


}
