package views.professur;

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


public class ProfesseurClasseController implements Initializable{
	private Connection connection;
    private Statement statement;
    private ResultSet resultSet;
    private boolean isProfesseurClasseAddNewButtonClick;
    private boolean isProfesseurClasseEditButtonClick;
    private MenuBarControl menuBarControl = new MenuBarControl();
    private String temp ;



    @FXML
    TableView<ProfesseurClasseTableau> professeurClasseTableView;
    @FXML
    TableColumn<ProfesseurClasseTableau,String> professeurClasseColumnNom;
    @FXML
    TableColumn<ProfesseurClasseTableau,String> professeurClasseColumnPrenom;
    @FXML
    TableColumn<ProfesseurClasseTableau,String> professeurClasseColumnEmail;
    @FXML
    TableColumn<ProfesseurClasseTableau,String> professeurClasseColumnAddresse;
    @FXML
    TableColumn<ProfesseurClasseTableau,String> professeurClasseColumnNumTel;

    @FXML
    private TextField professeurClasseTFFnom;
    @FXML
    private TextField professeurClasseTFFprenom;
    @FXML
    private TextField professeurClasseTFAdresse;
    @FXML
    private TextField professeurClasseTFEmail;
    @FXML
    private TextField professeurClasseTFNumTel;
    
    @FXML
    private TextField classeTFRechercher;


    @FXML
    private Button professeurEditerClasseButtonClick;
    @FXML
    private Button professeurSauverClasseButtonClick;
	private Statement database;


    private ObservableList getDataFromProfesseurAndAddToObservableList(String query){
        ObservableList<ProfesseurClasseTableau> professeurClasseTableauData = FXCollections.observableArrayList();
        
        return professeurClasseTableauData;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    	professeurClasseColumnNom.setCellValueFactory(new PropertyValueFactory<ProfesseurClasseTableau,String>("ProfesseurClasseTableauNom"));
    	professeurClasseColumnPrenom.setCellValueFactory(new PropertyValueFactory<ProfesseurClasseTableau,String>("ProfesseurClasseTableauPrenom"));
    	professeurClasseColumnEmail.setCellValueFactory(new PropertyValueFactory<ProfesseurClasseTableau,String>("ProfesseurClasseTableauEmail"));
    	professeurClasseColumnAddresse.setCellValueFactory(new PropertyValueFactory<ProfesseurClasseTableau,String>("ProfesseurClasseTableauAddresse"));
    	professeurClasseColumnNumTel.setCellValueFactory(new PropertyValueFactory<ProfesseurClasseTableau,String>("ProfesseurClasseTableauNumTel"));
    	
    	professeurClasseTableView.setItems(getDataFromProfesseurAndAddToObservableList("SELECT * FROM etablissement;"));

    }

    @FXML
    private void setAjouterProfesseurClick(Event event){
        professeurClasseSetAllEnable();
        isProfesseurClasseAddNewButtonClick = true;
    }

    private void professeurClasseSetAllEnable(){
        professeurClasseTFFnom.setDisable(false);
        professeurClasseTFFprenom.setDisable(false);
        professeurClasseTFAdresse.setDisable(false);
        professeurClasseTFEmail.setDisable(false);
        professeurClasseTFNumTel.setDisable(false);
       
        professeurEditerClasseButtonClick.setDisable(false);
        professeurSauverClasseButtonClick.setDisable(false);
    }

    private void professeurClasseSetAllDisable(){
        professeurClasseTFFnom.setDisable(true);
        professeurClasseTFFprenom.setDisable(true);
        professeurClasseTFAdresse.setDisable(true);
        professeurClasseTFEmail.setDisable(true);
        professeurClasseTFNumTel.setDisable(true);

        professeurEditerClasseButtonClick.setDisable(true);
        professeurSauverClasseButtonClick.setDisable(true);
    }

    private void professeurClasseSetAllClear(){
        professeurClasseTFFnom.clear();
        professeurClasseTFFprenom.clear();
        professeurClasseTFAdresse.clear();
        professeurClasseTFEmail.clear();
        professeurClasseTFNumTel.clear();
        
    }

    @FXML
    private void setEditerProfesseurClick(Event event){
        ProfesseurClasseTableau getSelectedRow = professeurClasseTableView.getSelectionModel().getSelectedItem();


        String sqlQuery = "select * FROM Professeur where ProfesseurId = '"+getSelectedRow.getProfesseurClasseTableauEmail()+"';";

        try {
            
            while(resultSet.next()) {
                professeurClasseTFFnom.setText(resultSet.getString("dbProfesseurNom"));
                professeurClasseTFFprenom.setText(resultSet.getString("dbProfesseurPrenom"));
                professeurClasseTFAdresse.setText(resultSet.getString("dbProfesseurAddresse"));
                professeurClasseTFEmail.setText(resultSet.getString("dbProfesseurEmail"));
                professeurClasseTFNumTel.setText(resultSet.getString("dbProfesseurNumTel"));

            }

            temp =professeurClasseTFAdresse.getText();
            isProfesseurClasseEditButtonClick = true;
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @FXML
    private void setSauverProfesseurButtonClick(Event event){

        try{
            
            if(isProfesseurClasseAddNewButtonClick){
                int rowsAffected = statement.executeUpdate("insert into `professeur` (`dbProfesseurNom`,`dbProfesseurPrenom`,`dbProfesseurAddresse`,`dbProfesseurEmail`,,`dbProfesseurNumTel`) values ('"+
                        professeurClasseTFFnom.getText()+"','"+professeurClasseTFFprenom.getText()+"','"+professeurClasseTFAdresse.getText()+"','"+professeurClasseTFEmail.getText()
                        +"','"+professeurClasseTFNumTel.getText()+"'");
            }
            else if (isProfesseurClasseEditButtonClick){
                int rowsAffected = statement.executeUpdate("update teacher set "+
                        "dbProfesseurNom = '"+professeurClasseTFFnom.getText()+"',"+
                        "dbProfesseurPreom = '"+professeurClasseTFFprenom.getText()+"',"+
                        "dbProfesseurAddresse = '"+professeurClasseTFAdresse.getText()+"',"+
                        "dbProfesseurEmail = '"+professeurClasseTFEmail.getText()+"',"+
                        "dbProfesseurNumTel = '"+professeurClasseTFNumTel.getText()+"',"+
                        
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
        professeurClasseSetAllClear();
        professeurClasseSetAllDisable();
        professeurClasseTableView.setItems(getDataFromProfesseurAndAddToObservableList("SELECT * FROM professeur;"));
        isProfesseurClasseAddNewButtonClick=false;
        isProfesseurClasseEditButtonClick = false;

    }

    @FXML
    private void setProfesseurClasseClearButtonClick(Event event){
        professeurClasseSetAllClear();
        professeurClasseSetAllDisable();
        isProfesseurClasseAddNewButtonClick = false;
        isProfesseurClasseEditButtonClick = false;
    }

    @FXML
    private void setEffacerProfesseurButtonClick(Event event){
        ProfesseurClasseTableau getSelectedRow = professeurClasseTableView.getSelectionModel().getSelectedItem();
        String sqlQuery = "delete from teacher where dbTeacherID = '"+getSelectedRow.getProfesseurClasseTableauEmail()+"';";
        try {
            connection = database.getConnection();
            statement = connection.createStatement();
            int rowsAffected = statement.executeUpdate(sqlQuery);
            professeurClasseTableView.setItems(getDataFromProfesseurAndAddToObservableList("SELECT * FROM professeur;"));

        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void setRechargerProfesseurButtonClick(Event event){
       professeurClasseTableView.setItems(getDataFromProfesseurAndAddToObservableList("SELECT * FROM professeur;"));//sql Query
        classeTFRechercher.clear();
    }

    @FXML
    private void setRechercherProfesseurButtonClick(Event event){
        String sqlQuery = "select * FROM professeur where dbProfesseurID = '"+classeTFRechercher.getText()+"';";
        professeurClasseTableView.setItems(getDataFromProfesseurAndAddToObservableList(sqlQuery));
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
