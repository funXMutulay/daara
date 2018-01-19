package views.principal;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import menuBar.MenuBarControl;

public class EtablissementProfesseurController implements Initializable {
	private Connection connection;
    private Statement statement;
    private ResultSet resultSet;
    private boolean isEtablissementProfesseurAddNewButtonClick;
    private boolean isEtablissementProfesseurEditButtonClick;
    private MenuBarControl menuBarControl = new MenuBarControl();
    private String temp ;



    @FXML
    TableView<EtablissementProfesseurTableau> etablissementProfesseurTableView;
    @FXML
    TableColumn<EtablissementProfesseurTableau,String> etablissementProfesseurColumnNom;
    @FXML
    TableColumn<EtablissementProfesseurTableau,String> etablissementProfesseurColumnPrenom;
    @FXML
    TableColumn<EtablissementProfesseurTableau,String> etablissementProfesseurColumnEmail;
    @FXML
    TableColumn<EtablissementProfesseurTableau,String> etablissementProfesseurColumnAddresse;
    @FXML
    TableColumn<EtablissementProfesseurTableau,String> etablissementProfesseurColumnNumTel;

    @FXML
    private TextField etablissementProfesseurTFFnom;
    @FXML
    private TextField etablissementProfesseurTFFprenom;
    @FXML
    private TextField etablissementProfesseurTFAdresse;
    @FXML
    private TextField etablissementProfesseurTFEmail;
    @FXML
    private TextField etablissementProfesseurTFNumTel;
    
    @FXML
    private TextField ProfesseurTFRechercher;


    @FXML
    private Button etablissementProfesseurClearButtonClick;
    @FXML
    private Button etablissementProfesseurSaveButtonClick;
	private Statement database;


    private ObservableList getDataFromProfesseurAndAddToObservableList(String query){
        ObservableList<EtablissementProfesseurTableau> etablissementProfesseurTableauData = FXCollections.observableArrayList();
        
        return etablissementProfesseurTableauData;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    	etablissementProfesseurColumnNom.setCellValueFactory(new PropertyValueFactory<EtablissementProfesseurTableau,String>("EtablissementProfesseurTableauNom"));
    	etablissementProfesseurColumnPrenom.setCellValueFactory(new PropertyValueFactory<EtablissementProfesseurTableau,String>("EtablissementProfesseurTableauPrenom"));
    	etablissementProfesseurColumnEmail.setCellValueFactory(new PropertyValueFactory<EtablissementProfesseurTableau,String>("EtablissementProfesseurTableauEmail"));
    	etablissementProfesseurColumnAddresse.setCellValueFactory(new PropertyValueFactory<EtablissementProfesseurTableau,String>("EtablissementProfesseurTableauAddresse"));
    	etablissementProfesseurColumnNumTel.setCellValueFactory(new PropertyValueFactory<EtablissementProfesseurTableau,String>("EtablissementProfesseurTableauNumTel"));
    	
    	etablissementProfesseurTableView.setItems(getDataFromProfesseurAndAddToObservableList("SELECT * FROM etablissement;"));

    }

    @FXML
    private void setAjouterProfesseurClick(Event event){
        etablissementProfesseurSetAllEnable();
        isEtablissementProfesseurAddNewButtonClick = true;
    }

    private void etablissementProfesseurSetAllEnable(){
        etablissementProfesseurTFFnom.setDisable(false);
        etablissementProfesseurTFFprenom.setDisable(false);
        etablissementProfesseurTFAdresse.setDisable(false);
        etablissementProfesseurTFEmail.setDisable(false);
        etablissementProfesseurTFNumTel.setDisable(false);
       
        etablissementProfesseurClearButtonClick.setDisable(false);
        etablissementProfesseurSaveButtonClick.setDisable(false);
    }

    private void etablissementProfesseurSetAllDisable(){
        etablissementProfesseurTFFnom.setDisable(true);
        etablissementProfesseurTFFprenom.setDisable(true);
        etablissementProfesseurTFAdresse.setDisable(true);
        etablissementProfesseurTFEmail.setDisable(true);
        etablissementProfesseurTFNumTel.setDisable(true);

        etablissementProfesseurClearButtonClick.setDisable(true);
        etablissementProfesseurSaveButtonClick.setDisable(true);
    }

    private void etablissementProfesseurSetAllClear(){
        etablissementProfesseurTFFnom.clear();
        etablissementProfesseurTFFprenom.clear();
        etablissementProfesseurTFAdresse.clear();
        etablissementProfesseurTFEmail.clear();
        etablissementProfesseurTFNumTel.clear();
        
    }

    @FXML
    private void setEditerProfesseurClick(Event event){
        EtablissementProfesseurTableau getSelectedRow = etablissementProfesseurTableView.getSelectionModel().getSelectedItem();


        String sqlQuery = "select * FROM Professeur where ProfesseurId = '"+getSelectedRow.getEtablissementProfesseurTableauEmail()+"';";

        try {
            
            while(resultSet.next()) {
                etablissementProfesseurTFFnom.setText(resultSet.getString("dbProfesseurNom"));
                etablissementProfesseurTFFprenom.setText(resultSet.getString("dbProfesseurPrenom"));
                etablissementProfesseurTFAdresse.setText(resultSet.getString("dbProfesseurAddresse"));
                etablissementProfesseurTFEmail.setText(resultSet.getString("dbProfesseurEmail"));
                etablissementProfesseurTFNumTel.setText(resultSet.getString("dbProfesseurNumTel"));

            }

            temp =etablissementProfesseurTFAdresse.getText();
            isEtablissementProfesseurEditButtonClick = true;
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @FXML
    private void setSauverProfesseurButtonClick(Event event){

        try{
            
            if(isEtablissementProfesseurAddNewButtonClick){
                int rowsAffected = statement.executeUpdate("insert into `professeur` (`dbProfesseurNom`,`dbProfesseurPrenom`,`dbProfesseurAddresse`,`dbProfesseurEmail`,,`dbProfesseurNumTel`) values ('"+
                        etablissementProfesseurTFFnom.getText()+"','"+etablissementProfesseurTFFprenom.getText()+"','"+etablissementProfesseurTFAdresse.getText()+"','"+etablissementProfesseurTFEmail.getText()
                        +"','"+etablissementProfesseurTFNumTel.getText()+"'");
            }
            else if (isEtablissementProfesseurEditButtonClick){
                int rowsAffected = statement.executeUpdate("update teacher set "+
                        "dbProfesseurNom = '"+etablissementProfesseurTFFnom.getText()+"',"+
                        "dbProfesseurPreom = '"+etablissementProfesseurTFFprenom.getText()+"',"+
                        "dbProfesseurAddresse = '"+etablissementProfesseurTFAdresse.getText()+"',"+
                        "dbProfesseurEmail = '"+etablissementProfesseurTFEmail.getText()+"',"+
                        "dbProfesseurNumTel = '"+etablissementProfesseurTFNumTel.getText()+"',"+
                        
                        "' where dbTeacherID = '"+
                        temp+"';");
            }


            connection.close();
            statement.close();
            resultSet.close();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        etablissementProfesseurSetAllClear();
        etablissementProfesseurSetAllDisable();
        etablissementProfesseurTableView.setItems(getDataFromProfesseurAndAddToObservableList("SELECT * FROM professeur;"));
        isEtablissementProfesseurAddNewButtonClick=false;
        isEtablissementProfesseurEditButtonClick = false;

    }

    @FXML
    private void setEtablissementProfesseurClearButtonClick(Event event){
        etablissementProfesseurSetAllClear();
        etablissementProfesseurSetAllDisable();
        isEtablissementProfesseurAddNewButtonClick = false;
        isEtablissementProfesseurEditButtonClick = false;
    }

    @FXML
    private void setEffacerProfesseurButtonClick(Event event){
        EtablissementProfesseurTableau getSelectedRow = etablissementProfesseurTableView.getSelectionModel().getSelectedItem();
        String sqlQuery = "delete from teacher where dbTeacherID = '"+getSelectedRow.getEtablissementProfesseurTableauEmail()+"';";
        try {
            connection = database.getConnection();
            statement = connection.createStatement();
            int rowsAffected = statement.executeUpdate(sqlQuery);
            etablissementProfesseurTableView.setItems(getDataFromProfesseurAndAddToObservableList("SELECT * FROM professeur;"));

        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void setRechargerProfesseurButtonClick(Event event){
       etablissementProfesseurTableView.setItems(getDataFromProfesseurAndAddToObservableList("SELECT * FROM professeur;"));//sql Query
        ProfesseurTFRechercher.clear();
    }

    @FXML
    private void setRechercherProfesseurButtonClick(Event event){
        String sqlQuery = "select * FROM professeur where dbProfesseurID = '"+ProfesseurTFRechercher.getText()+"';";
        etablissementProfesseurTableView.setItems(getDataFromProfesseurAndAddToObservableList(sqlQuery));
        ProfesseurTFRechercher.clear();
    }

    @FXML
    private void setCourseAboutButtonClick(Event event) throws IOException {
        menuBarControl.about();
    }

    @FXML
    private void setCourseCloseButtonClick(Event event){
        menuBarControl.close();
    }


}
