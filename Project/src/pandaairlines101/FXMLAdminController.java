/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pandaairlines101;

import com.jfoenix.controls.JFXButton;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import pandaairlines.avion.Avion;
import pandaairlines.db_cnx.dbcnx;
import pandaairlines.humanoid.Admin;
import pandaairlines.humanoid.Personnel;
import pandaairlines.vol.Vol;

/**
 * FXML Controller class
 *
 * @author ky94
 */
public class FXMLAdminController implements Initializable {

    @FXML
    private JFXButton addEmpBtn;
    @FXML
    private JFXButton refreshBtn;
    @FXML
    private JFXButton addVolBtn;
    @FXML
    private JFXButton addAvionBtn;
    @FXML
    private ImageView userIcon;
    @FXML
    private Label usernameLabel;
    @FXML
    private VBox userLanding;
    @FXML
    private AnchorPane userBanner;
    @FXML
    private TabPane contentTabPane;
    @FXML
    private Tab volTab;
    @FXML
    private ScrollPane volScrollPane;
    @FXML
    private TableView<Vol> volScrollTabView;
    @FXML
    private Tab empTab;
    @FXML
    private ScrollPane empScrollPane;
    @FXML
    private AnchorPane empAnchorPane;
    @FXML
    private TableView<Personnel> empTabView;
    @FXML
    private Tab avionTab;
    @FXML
    private ScrollPane avionScrollPane;
    @FXML
    private AnchorPane avionAnchorPane;
    @FXML
    private TableView<Avion> avionTabView;
    @FXML
    private AnchorPane deleteAnchorPane;
    @FXML
    private JFXButton deleteBtn;
    @FXML
    private AnchorPane volPane;
    @FXML
    private AnchorPane avionPane;
    @FXML
    private AnchorPane empPane;
    @FXML
    private AnchorPane volScrollAnchorPane;
    @FXML
    private TableColumn<Personnel, String> empIdentifiantCol;
    @FXML
    private TableColumn<Personnel, String> empNomCol;
    @FXML
    private TableColumn<Personnel, String> empPrenomCol;
    @FXML
    private TableColumn<Personnel, String> empTypeCol;
    @FXML
    private TableColumn<Personnel, Integer> empNbHCol;
    @FXML
    private TableColumn<Personnel, Integer> empSalaireCol;
    @FXML
    private TableColumn<Vol, Integer> volIdCol;
    @FXML
    private TableColumn<Vol, Integer> volAvionCol;
    @FXML
    private TableColumn<Vol, String> volDepCol;
    @FXML
    private TableColumn<Vol, String> volhDepCol;
    @FXML
    private TableColumn<Vol, String> volArrCol;
    @FXML
    private TableColumn<Vol, String> volhArrCol;
    @FXML
    private TableColumn<Vol, String> volTypeCol;
    @FXML
    private TableColumn<Avion, String> avidCol;
    @FXML
    private TableColumn<Avion, String> avnomCol;
    @FXML
    private TableColumn<Avion, String> avMarqueCol;
    @FXML
    private TableColumn<Avion, String> avTypeCol;
    @FXML
    private TableColumn<Avion, String> avNbCol;
    @FXML
    private TableColumn<Avion, String> avChargeCol;
    @FXML
    private JFXButton annulerVolBtn;
    @FXML
    private JFXButton avionAnnulerbtn;
    @FXML
    private JFXButton avionconfirmbtn;
    @FXML
    private JFXButton empannulerbtn;
    @FXML
    private JFXButton empconfirmbtn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        //        loadcontent();
        usernameLabel.setText(dbcnx.username);
    }

    @FXML
    private void addEmp(ActionEvent event) {
        userLanding.setOpacity(0.5);
        userLanding.setDisable(true);
        avionPane.setDisable(true);
        volPane.setDisable(true);
        empPane.visibleProperty().set(true);
        volPane.setDisable(false);
    }

    @FXML
    private void refresh(ActionEvent event) {
        //add flights
        loadcontent();

    }

    @FXML
    private void addVol(ActionEvent event) {
        userLanding.setOpacity(0.5);
        userLanding.setDisable(true);
        avionPane.setDisable(true);
        empPane.setDisable(true);
        volPane.visibleProperty().set(true);
        volPane.setDisable(false);
    }

    @FXML
    private void addAvion(ActionEvent event) {
        userLanding.setOpacity(0.5);
        userLanding.setDisable(true);
        empPane.setDisable(true);
        volPane.setDisable(true);
        avionPane.visibleProperty().set(true);
        avionPane.setDisable(false);
    }

    @FXML
    private void annuler(ActionEvent event) {
        userLanding.setOpacity(1);
        userLanding.setDisable(false);
        avionPane.visibleProperty().set(false);
        volPane.visibleProperty().set(false);
        empPane.visibleProperty().set(false);
    }

    @FXML
    private void confirmer(ActionEvent event) {
        userLanding.setOpacity(1);
        userLanding.setDisable(false);
        avionPane.visibleProperty().set(false);
        volPane.visibleProperty().set(false);
        empPane.visibleProperty().set(false);
    }

    private void loadcontent() {
        ArrayList<Vol> a = Admin.loadFlight("1", true);
        volAvionCol.setCellValueFactory(new PropertyValueFactory<Vol, Integer>("simmatriculeAv"));
        volIdCol.setCellValueFactory(new PropertyValueFactory<Vol, Integer>("svolId"));
        volDepCol.setCellValueFactory(new PropertyValueFactory<Vol, String>("svDepart"));
        volhDepCol.setCellValueFactory(new PropertyValueFactory<Vol, String>("sheureDepart"));
        volArrCol.setCellValueFactory(new PropertyValueFactory<Vol, String>("svArrive"));
        volhArrCol.setCellValueFactory(new PropertyValueFactory<Vol, String>("sheureArrive"));
        volTypeCol.setCellValueFactory(new PropertyValueFactory<Vol, String>("stype"));
        ObservableList<Vol> volItems = FXCollections.observableArrayList(a);
        System.out.println(volItems);
//        volScrollTabView.getColumns().addAll(volIdCol,volAvionCol, volDepCol, volhDepCol, volArrCol, volhArrCol, volTypeCol);
        volScrollTabView.getItems().addAll(volItems);

        ArrayList<Personnel> e = Admin.loadPersonnel("1", true);

        empIdentifiantCol.setCellValueFactory(new PropertyValueFactory<Personnel, String>("slogin"));
        empNomCol.setCellValueFactory(new PropertyValueFactory<Personnel, String>("snom"));
        empPrenomCol.setCellValueFactory(new PropertyValueFactory<Personnel, String>("sprenom"));
        empTypeCol.setCellValueFactory(new PropertyValueFactory<Personnel, String>("sfonction"));
        empNbHCol.setCellValueFactory(new PropertyValueFactory<Personnel, Integer>("snbHeure"));
        empSalaireCol.setCellValueFactory(new PropertyValueFactory<Personnel, Integer>("ssalaire"));
        ObservableList<Personnel> empitems = FXCollections.observableArrayList(e);
        System.out.println(empitems);
//        volScrollTabView.getColumns().addAll(volIdCol,volAvionCol, volDepCol, volhDepCol, volArrCol, volhArrCol, volTypeCol);
        empTabView.getItems().addAll(empitems);

        ArrayList<Avion> p = Admin.loadAv("1", true);

        avidCol.setCellValueFactory(new PropertyValueFactory<Avion, String>("simmatricule"));
        avnomCol.setCellValueFactory(new PropertyValueFactory<Avion, String>("snom"));
        avMarqueCol.setCellValueFactory(new PropertyValueFactory<Avion, String>("smarque"));
        avTypeCol.setCellValueFactory(new PropertyValueFactory<Avion, String>("scompagne"));
        avNbCol.setCellValueFactory(new PropertyValueFactory<Avion, String>("snbrPersonnel"));
        avChargeCol.setCellValueFactory(new PropertyValueFactory<Avion, String>("smaintenance"));
        ObservableList<Avion> avitems = FXCollections.observableArrayList(p);
        System.out.println(avitems.toString());
        avionTabView.getItems().addAll(avitems);
    }

    @FXML
    private void delete(ActionEvent event) {
        switch (contentTabPane.getSelectionModel().getSelectedIndex()) {
            case 1:
                ObservableList<Vol> selectedItems,
                 allItems;
                allItems = volScrollTabView.getItems();
                selectedItems = volScrollTabView.getSelectionModel().getSelectedItems();
                for (Vol s : selectedItems) {
                    allItems.remove(s);
                }
                break;
            case 2:
                ObservableList<Vol> selectedItems2,
                 allItems2;
                allItems2 = volScrollTabView.getItems();
                selectedItems2 = volScrollTabView.getSelectionModel().getSelectedItems();
                for (Vol s : selectedItems2) {
                    allItems2.remove(s);
                }
                break;
            case 3:
                ObservableList<Vol> selectedItems3,
                 allItems3;
                allItems3 = volScrollTabView.getItems();
                selectedItems3 = volScrollTabView.getSelectionModel().getSelectedItems();
                for (Vol s : selectedItems3) {
                    allItems3.remove(s);
                }
                break;

        }
    }
}
