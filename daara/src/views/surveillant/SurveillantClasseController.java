package views.surveillant;

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


public class SurveillantClasseController implements Initializable{
	private Connection connection;
    private Statement statement;
    private ResultSet resultSet;
    private boolean isSurveillantClasseAddNewButtonClick;
    private boolean isSurveillantClasseEditButtonClick;
    private MenuBarControl menuBarControl = new MenuBarControl();
    private String temp ;



    @FXML
    TableView<SurveillantClasseTableau> surveillantClasseTableView;
    @FXML
    TableColumn<SurveillantClasseTableau,String> surveillantClasseColumnNom;
    @FXML
    TableColumn<SurveillantClasseTableau,String> surveillantClasseColumnPrenom;
    @FXML
    TableColumn<SurveillantClasseTableau,String> surveillantClasseColumnEmail;
    @FXML
    TableColumn<SurveillantClasseTableau,String> surveillantClasseColumnAddresse;
    @FXML
    TableColumn<SurveillantClasseTableau,String> surveillantClasseColumnNumTel;

    @FXML
    private TextField surveillantClasseTFFnom;
    @FXML
    private TextField surveillantClasseTFFprenom;
    @FXML
    private TextField surveillantClasseTFAdresse;
    @FXML
    private TextField surveillantClasseTFEmail;
    @FXML
    private TextField surveillantClasseTFNumTel;
    
    @FXML
    private TextField classeTFRechercher;


    @FXML
    private Button surveillantEditerClasseButtonClick;
    @FXML
    private Button surveillantSauverClasseButtonClick;
	private Statement database;


    private ObservableList getDataFromProfesseurAndAddToObservableList(String query){
        ObservableList<SurveillantClasseTableau> surveillantClasseTableauData = FXCollections.observableArrayList();
        
        return surveillantClasseTableauData;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    	surveillantClasseColumnNom.setCellValueFactory(new PropertyValueFactory<SurveillantClasseTableau,String>("SurveillantClasseTableauNom"));
    	surveillantClasseColumnPrenom.setCellValueFactory(new PropertyValueFactory<SurveillantClasseTableau,String>("SurveillantClasseTableauPrenom"));
    	surveillantClasseColumnEmail.setCellValueFactory(new PropertyValueFactory<SurveillantClasseTableau,String>("SurveillantClasseTableauEmail"));
    	surveillantClasseColumnAddresse.setCellValueFactory(new PropertyValueFactory<SurveillantClasseTableau,String>("SurveillantClasseTableauAddresse"));
    	surveillantClasseColumnNumTel.setCellValueFactory(new PropertyValueFactory<SurveillantClasseTableau,String>("SurveillantClasseTableauNumTel"));
    	
    	surveillantClasseTableView.setItems(getDataFromProfesseurAndAddToObservableList("SELECT * FROM etablissement;"));

    }

    @FXML
    private void setAjouterProfesseurClick(Event event){
        surveillantClasseSetAllEnable();
        isSurveillantClasseAddNewButtonClick = true;
    }

    private void surveillantClasseSetAllEnable(){
        surveillantClasseTFFnom.setDisable(false);
        surveillantClasseTFFprenom.setDisable(false);
        surveillantClasseTFAdresse.setDisable(false);
        surveillantClasseTFEmail.setDisable(false);
        surveillantClasseTFNumTel.setDisable(false);
       
        surveillantEditerClasseButtonClick.setDisable(false);
        surveillantSauverClasseButtonClick.setDisable(false);
    }

    private void surveillantClasseSetAllDisable(){
        surveillantClasseTFFnom.setDisable(true);
        surveillantClasseTFFprenom.setDisable(true);
        surveillantClasseTFAdresse.setDisable(true);
        surveillantClasseTFEmail.setDisable(true);
        surveillantClasseTFNumTel.setDisable(true);

        surveillantEditerClasseButtonClick.setDisable(true);
        surveillantSauverClasseButtonClick.setDisable(true);
    }

    private void surveillantClasseSetAllClear(){
        surveillantClasseTFFnom.clear();
        surveillantClasseTFFprenom.clear();
        surveillantClasseTFAdresse.clear();
        surveillantClasseTFEmail.clear();
        surveillantClasseTFNumTel.clear();
        
    }

    @FXML
    private void setEditerProfesseurClick(Event event){
        SurveillantClasseTableau getSelectedRow = surveillantClasseTableView.getSelectionModel().getSelectedItem();


        String sqlQuery = "select * FROM Professeur where ProfesseurId = '"+getSelectedRow.getSurveillantClasseTableauEmail()+"';";

        try {
            
            while(resultSet.next()) {
                surveillantClasseTFFnom.setText(resultSet.getString("dbProfesseurNom"));
                surveillantClasseTFFprenom.setText(resultSet.getString("dbProfesseurPrenom"));
                surveillantClasseTFAdresse.setText(resultSet.getString("dbProfesseurAddresse"));
                surveillantClasseTFEmail.setText(resultSet.getString("dbProfesseurEmail"));
                surveillantClasseTFNumTel.setText(resultSet.getString("dbProfesseurNumTel"));

            }

            temp =surveillantClasseTFAdresse.getText();
            isSurveillantClasseEditButtonClick = true;
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @FXML
    private void setSauverProfesseurButtonClick(Event event){

        try{
            
            if(isSurveillantClasseAddNewButtonClick){
                int rowsAffected = statement.executeUpdate("insert into `professeur` (`dbProfesseurNom`,`dbProfesseurPrenom`,`dbProfesseurAddresse`,`dbProfesseurEmail`,,`dbProfesseurNumTel`) values ('"+
                        surveillantClasseTFFnom.getText()+"','"+surveillantClasseTFFprenom.getText()+"','"+surveillantClasseTFAdresse.getText()+"','"+surveillantClasseTFEmail.getText()
                        +"','"+surveillantClasseTFNumTel.getText()+"'");
            }
            else if (isSurveillantClasseEditButtonClick){
                int rowsAffected = statement.executeUpdate("update teacher set "+
                        "dbProfesseurNom = '"+surveillantClasseTFFnom.getText()+"',"+
                        "dbProfesseurPreom = '"+surveillantClasseTFFprenom.getText()+"',"+
                        "dbProfesseurAddresse = '"+surveillantClasseTFAdresse.getText()+"',"+
                        "dbProfesseurEmail = '"+surveillantClasseTFEmail.getText()+"',"+
                        "dbProfesseurNumTel = '"+surveillantClasseTFNumTel.getText()+"',"+
                        
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
        surveillantClasseSetAllClear();
        surveillantClasseSetAllDisable();
        surveillantClasseTableView.setItems(getDataFromProfesseurAndAddToObservableList("SELECT * FROM professeur;"));
        isSurveillantClasseAddNewButtonClick=false;
        isSurveillantClasseEditButtonClick = false;

    }

    @FXML
    private void setSurveillantClasseClearButtonClick(Event event){
        surveillantClasseSetAllClear();
        surveillantClasseSetAllDisable();
        isSurveillantClasseAddNewButtonClick = false;
        isSurveillantClasseEditButtonClick = false;
    }

    @FXML
    private void setEffacerProfesseurButtonClick(Event event){
        SurveillantClasseTableau getSelectedRow = surveillantClasseTableView.getSelectionModel().getSelectedItem();
        String sqlQuery = "delete from teacher where dbTeacherID = '"+getSelectedRow.getSurveillantClasseTableauEmail()+"';";
        try {
            connection = database.getConnection();
            statement = connection.createStatement();
            int rowsAffected = statement.executeUpdate(sqlQuery);
            surveillantClasseTableView.setItems(getDataFromProfesseurAndAddToObservableList("SELECT * FROM professeur;"));

        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void setRechargerProfesseurButtonClick(Event event){
       surveillantClasseTableView.setItems(getDataFromProfesseurAndAddToObservableList("SELECT * FROM professeur;"));//sql Query
        classeTFRechercher.clear();
    }

    @FXML
    private void setRechercherProfesseurButtonClick(Event event){
        String sqlQuery = "select * FROM professeur where dbProfesseurID = '"+classeTFRechercher.getText()+"';";
        surveillantClasseTableView.setItems(getDataFromProfesseurAndAddToObservableList(sqlQuery));
        classeTFRechercher.clear();
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
