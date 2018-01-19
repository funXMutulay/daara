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

public class EtablissementClasseController implements Initializable {
	private Connection connection;
    private Statement statement;
    private ResultSet resultSet;
    private boolean isEtablissementClasseAddNewButtonClick;
    private boolean isEtablissementClasseEditButtonClick;
    private MenuBarControl menuBarControl = new MenuBarControl();
    private String temp ;



    @FXML
    TableView<EtablissementClasseTableau> etablissementClasseTableView;
    @FXML
    TableColumn<EtablissementClasseTableau,String> etablissementClasseColumnNom;
    @FXML
    TableColumn<EtablissementClasseTableau,String> etablissementClasseColumnPrenom;
    @FXML
    TableColumn<EtablissementClasseTableau,String> etablissementClasseColumnEmail;
    @FXML
    TableColumn<EtablissementClasseTableau,String> etablissementClasseColumnAddresse;
    @FXML
    TableColumn<EtablissementClasseTableau,String> etablissementClasseColumnNumTel;

    @FXML
    private TextField etablissementClasseTFNom;
    @FXML
    private TextField etablissementClasseTFPrenom;
    @FXML
    private TextField etablissementClasseTFAdresse;
    @FXML
    private TextField etablissementClasseTFEmail;
    @FXML
    private TextField etablissementClasseTFNumTel;
    
    @FXML
    private TextField ProfesseurTFRechercher;


    @FXML
    private Button etablissementClasseClearButtonClick;
    @FXML
    private Button etablissementClasseSaveButtonClick;
	private Statement database;


    private ObservableList getDataFromProfesseurAndAddToObservableList(String query){
        ObservableList<EtablissementClasseTableau> etablissementClasseTableauData = FXCollections.observableArrayList();
        
        return etablissementClasseTableauData;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    	etablissementClasseColumnNom.setCellValueFactory(new PropertyValueFactory<EtablissementClasseTableau,String>("EtablissementClasseTableauNom"));
    	etablissementClasseColumnPrenom.setCellValueFactory(new PropertyValueFactory<EtablissementClasseTableau,String>("EtablissementClasseTableauPrenom"));
    	etablissementClasseColumnEmail.setCellValueFactory(new PropertyValueFactory<EtablissementClasseTableau,String>("EtablissementClasseTableauEmail"));
    	etablissementClasseColumnAddresse.setCellValueFactory(new PropertyValueFactory<EtablissementClasseTableau,String>("EtablissementClasseTableauAddresse"));
    	etablissementClasseColumnNumTel.setCellValueFactory(new PropertyValueFactory<EtablissementClasseTableau,String>("EtablissementClasseTableauNumTel"));
    	
    	etablissementClasseTableView.setItems(getDataFromProfesseurAndAddToObservableList("SELECT * FROM etablissement;"));

    }

    @FXML
    private void setAjouterProfesseurClick(Event event){
        etablissementClasseSetAllEnable();
        isEtablissementClasseAddNewButtonClick = true;
    }

    private void etablissementClasseSetAllEnable(){
        etablissementClasseTFNom.setDisable(false);
        etablissementClasseTFPrenom.setDisable(false);
        etablissementClasseTFAdresse.setDisable(false);
        etablissementClasseTFEmail.setDisable(false);
        etablissementClasseTFNumTel.setDisable(false);
       
        etablissementClasseClearButtonClick.setDisable(false);
        etablissementClasseSaveButtonClick.setDisable(false);
    }

    private void etablissementClasseSetAllDisable(){
        etablissementClasseTFNom.setDisable(true);
        etablissementClasseTFPrenom.setDisable(true);
        etablissementClasseTFAdresse.setDisable(true);
        etablissementClasseTFEmail.setDisable(true);
        etablissementClasseTFNumTel.setDisable(true);

        etablissementClasseClearButtonClick.setDisable(true);
        etablissementClasseSaveButtonClick.setDisable(true);
    }

    private void etablissementClasseSetAllClear(){
        etablissementClasseTFNom.clear();
        etablissementClasseTFPrenom.clear();
        etablissementClasseTFAdresse.clear();
        etablissementClasseTFEmail.clear();
        etablissementClasseTFNumTel.clear();
        
    }

    @FXML
    private void setEditerProfesseurClick(Event event){
        EtablissementClasseTableau getSelectedRow = etablissementClasseTableView.getSelectionModel().getSelectedItem();


        String sqlQuery = "select * FROM Professeur where ProfesseurId = '"+getSelectedRow.getEtablissementClasseTableauEmail()+"';";

        try {
            
            while(resultSet.next()) {
                etablissementClasseTFNom.setText(resultSet.getString("dbProfesseurNom"));
                etablissementClasseTFPrenom.setText(resultSet.getString("dbProfesseurPrenom"));
                etablissementClasseTFAdresse.setText(resultSet.getString("dbProfesseurAddresse"));
                etablissementClasseTFEmail.setText(resultSet.getString("dbProfesseurEmail"));
                etablissementClasseTFNumTel.setText(resultSet.getString("dbProfesseurNumTel"));

            }

            temp =etablissementClasseTFAdresse.getText();
            isEtablissementClasseEditButtonClick = true;
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @FXML
    private void setSauverProfesseurButtonClick(Event event){

        try{
            
            if(isEtablissementClasseAddNewButtonClick){
                int rowsAffected = statement.executeUpdate("insert into `professeur` (`dbProfesseurNom`,`dbProfesseurPrenom`,`dbProfesseurAddresse`,`dbProfesseurEmail`,,`dbProfesseurNumTel`) values ('"+
                        etablissementClasseTFNom.getText()+"','"+etablissementClasseTFPrenom.getText()+"','"+etablissementClasseTFAdresse.getText()+"','"+etablissementClasseTFEmail.getText()
                        +"','"+etablissementClasseTFNumTel.getText()+"'");
            }
            else if (isEtablissementClasseEditButtonClick){
                int rowsAffected = statement.executeUpdate("update teacher set "+
                        "dbProfesseurNom = '"+etablissementClasseTFNom.getText()+"',"+
                        "dbProfesseurPreom = '"+etablissementClasseTFPrenom.getText()+"',"+
                        "dbProfesseurAddresse = '"+etablissementClasseTFAdresse.getText()+"',"+
                        "dbProfesseurEmail = '"+etablissementClasseTFEmail.getText()+"',"+
                        "dbProfesseurNumTel = '"+etablissementClasseTFNumTel.getText()+"',"+
                        
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
        etablissementClasseSetAllClear();
        etablissementClasseSetAllDisable();
        etablissementClasseTableView.setItems(getDataFromProfesseurAndAddToObservableList("SELECT * FROM professeur;"));
        isEtablissementClasseAddNewButtonClick=false;
        isEtablissementClasseEditButtonClick = false;

    }

    @FXML
    private void setEtablissementClasseClearButtonClick(Event event){
        etablissementClasseSetAllClear();
        etablissementClasseSetAllDisable();
        isEtablissementClasseAddNewButtonClick = false;
        isEtablissementClasseEditButtonClick = false;
    }

    @FXML
    private void setEffacerProfesseurButtonClick(Event event){
        EtablissementClasseTableau getSelectedRow = etablissementClasseTableView.getSelectionModel().getSelectedItem();
        String sqlQuery = "delete from teacher where dbTeacherID = '"+getSelectedRow.getEtablissementClasseTableauEmail()+"';";
        try {
            connection = database.getConnection();
            statement = connection.createStatement();
            int rowsAffected = statement.executeUpdate(sqlQuery);
            etablissementClasseTableView.setItems(getDataFromProfesseurAndAddToObservableList("SELECT * FROM professeur;"));

        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void setRechargerProfesseurButtonClick(Event event){
       etablissementClasseTableView.setItems(getDataFromProfesseurAndAddToObservableList("SELECT * FROM professeur;"));//sql Query
        ProfesseurTFRechercher.clear();
    }

    @FXML
    private void setRechercherProfesseurButtonClick(Event event){
        String sqlQuery = "select * FROM professeur where dbProfesseurID = '"+ProfesseurTFRechercher.getText()+"';";
        etablissementClasseTableView.setItems(getDataFromProfesseurAndAddToObservableList(sqlQuery));
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
