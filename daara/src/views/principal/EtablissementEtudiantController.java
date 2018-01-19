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
import views.principal.EtablissementEtudiantTableau;
/**
 * @author MKebe 
 * @version 1 
 * @year 2017
 */
public class EtablissementEtudiantController  implements Initializable {
	

	 
	    private Connection connection;
	    private Statement statement;
	    private ResultSet resultSet;
	    private boolean isEtablissementEtudiantAddNewButtonClick;
	    private boolean isetablissementEtudiantEditButtonClick;
	    private MenuBarControl menuBarControl = new MenuBarControl();
	    private String temp ;



	    @FXML
	    TableView<EtablissementEtudiantTableau> etablissementEtudiantTableView;
	    @FXML
	    TableColumn<EtablissementEtudiantTableau,String> etablissementEtudiantColumnNom;
	    @FXML
	    TableColumn<EtablissementEtudiantTableau,String> etablissementEtudiantColumnPrenom;
	    @FXML
	    TableColumn<EtablissementEtudiantTableau,String> etablissementEtudiantColumnEmail;
	    @FXML
	    TableColumn<EtablissementEtudiantTableau,String> etablissementEtudiantColumnAddresse;
	    @FXML
	    TableColumn<EtablissementEtudiantTableau,String> etablissementEtudiantColumnClasse;
	    @FXML
	    TableColumn<EtablissementEtudiantTableau,String> etablissementEtudiantColumnTuteur;


	    @FXML
	    private TextField etablissementEtudiantTFnom;
	    @FXML
	    private TextField etablissementEtudiantTFprenom;
	    @FXML
	    private TextField etablissementEtudiantTFEmail;
	    @FXML
	    private TextField etablissementEtudiantTFAdresse;
	    @FXML
	    private TextField etablissementEtudiantTFClasse;
	    @FXML
	    private TextField etudiantTFRechercher ;

	    @FXML
	    private Button etablissementEditerEtudiantButtonClick;
	    @FXML
	    private Button etablissementSauverEtudiantButtonClick;
		private Statement database;


	    private ObservableList getDataFromTeacherAndAddToObservableList(String query){
	        ObservableList<EtablissementEtudiantTableau> etablissementEtudiantTableauData = FXCollections.observableArrayList();
	        
	        return etablissementEtudiantTableauData;
	    }

	    @Override
	    public void initialize(URL location, ResourceBundle resources) {

	    	etablissementEtudiantColumnNom.setCellValueFactory(new PropertyValueFactory<EtablissementEtudiantTableau,String>("EtablissementEtudiantTableauNom"));
	    	etablissementEtudiantColumnPrenom.setCellValueFactory(new PropertyValueFactory<EtablissementEtudiantTableau,String>("EtablissementEtudiantTableauPrenom"));
	    	etablissementEtudiantColumnEmail.setCellValueFactory(new PropertyValueFactory<EtablissementEtudiantTableau,String>("EtablissementEtudiantTableauEmail"));
	    	etablissementEtudiantColumnAddresse.setCellValueFactory(new PropertyValueFactory<EtablissementEtudiantTableau,String>("EtablissementEtudiantTableauAddresse"));
	    	etablissementEtudiantColumnClasse.setCellValueFactory(new PropertyValueFactory<EtablissementEtudiantTableau,String>("EtablissementEtudiantTableauClasse"));
	    	etablissementEtudiantColumnTuteur.setCellValueFactory(new PropertyValueFactory<EtablissementEtudiantTableau,String>("EtablissementEtudiantTableauTuteur"));

	    	etablissementEtudiantTableView.setItems(getDataFromTeacherAndAddToObservableList("SELECT * FROM etablissement;"));

	    }

	    @FXML
	    private void setAjouterEtudiantClick(Event event){
	    	etablissementEtudiantSetAllEnable();
	        isEtablissementEtudiantAddNewButtonClick = true;
	    }

	    private void etablissementEtudiantSetAllEnable(){
	        etablissementEtudiantTFnom.setDisable(false);
	        etablissementEtudiantTFprenom.setDisable(false);
	        etablissementEtudiantTFEmail.setDisable(false);
	        etablissementEtudiantTFAdresse.setDisable(false);
	        etablissementEtudiantTFClasse.setDisable(false);
	        

	        etablissementEditerEtudiantButtonClick.setDisable(false);
	        etablissementSauverEtudiantButtonClick.setDisable(false);
	    }

	    private void etablissementEtudiantSetAllDisable(){
	        etablissementEtudiantTFnom.setDisable(true);
	        etablissementEtudiantTFprenom.setDisable(true);
	        etablissementEtudiantTFEmail.setDisable(true);
	        etablissementEtudiantTFAdresse.setDisable(true);
	        etablissementEtudiantTFClasse.setDisable(true);

	        etablissementEditerEtudiantButtonClick.setDisable(true);
	        etablissementSauverEtudiantButtonClick.setDisable(true);
	    }

	    private void etablissementEtudiantSetAllClear(){
	        etablissementEtudiantTFnom.clear();
	        etablissementEtudiantTFprenom.clear();
	        etablissementEtudiantTFEmail.clear();
	        etablissementEtudiantTFClasse.clear();
	        etablissementEtudiantTFAdresse.clear();
	     

	    }

	    @FXML
	    private void setEditerEtudiantClick(Event event){
	        EtablissementEtudiantTableau getSelectedRow = etablissementEtudiantTableView.getSelectionModel().getSelectedItem();


	        String sqlQuery = "select * FROM etudiant where etudiantId = '"+getSelectedRow.getEtablissementEtudiantTableauEmail()+"';";

	        try {
	            
	            while(resultSet.next()) {
	                etablissementEtudiantTFnom.setText(resultSet.getString("dbTeacherFname"));
	                etablissementEtudiantTFprenom.setText(resultSet.getString("dbTeacherLname"));
	                etablissementEtudiantTFEmail.setText(resultSet.getString("dbTeacherID"));
	                etablissementEtudiantTFAdresse.setText(resultSet.getString("dbTeacherEmail"));
	                etablissementEtudiantTFClasse.setText(resultSet.getString("dbTeacherDepartment"));

	            }

	            temp =etablissementEtudiantTFEmail.getText();
	            isetablissementEtudiantEditButtonClick = true;
	        }
	        catch (SQLException e) {
	            e.printStackTrace();
	        }

	    }

	    @FXML
	    private void setSauverEtudiantButtonClick(Event event){

	        try{
	            
	            if(isEtablissementEtudiantAddNewButtonClick){
	                int rowsAffected = statement.executeUpdate("insert into `teacher` (`dbTeacherFname`,`dbTeacherLname`,`dbTeacherID`,`dbTeacherEmail`,`dbTeacherDepartment`,`dbTeacherCourse`) values ('"+
	                        etablissementEtudiantTFnom.getText()+"','"+etablissementEtudiantTFprenom.getText()+"','"+etablissementEtudiantTFEmail.getText()+"','"+etablissementEtudiantTFAdresse.getText()
	                        +"','"+etablissementEtudiantTFClasse.getText()+"') ;");
	            }
	            else if (isetablissementEtudiantEditButtonClick){
	                int rowsAffected = statement.executeUpdate("update teacher set "+
	                        "dbTeacherFname = '"+etablissementEtudiantTFnom.getText()+"',"+
	                        "dbTeacherLname = '"+etablissementEtudiantTFprenom.getText()+"',"+
	                        "dbTeacherID = '"+etablissementEtudiantTFEmail.getText()+"',"+
	                        "dbTeacherEmail = '"+etablissementEtudiantTFAdresse.getText()+"',"+
	                        "dbTeacherDepartment = '"+etablissementEtudiantTFClasse.getText()+"',"+

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
	        etablissementEtudiantSetAllClear();
	        etablissementEtudiantSetAllDisable();
	        etablissementEtudiantTableView.setItems(getDataFromTeacherAndAddToObservableList("SELECT * FROM teacher;"));
	        isEtablissementEtudiantAddNewButtonClick=false;
	        isetablissementEtudiantEditButtonClick = false;

	    }

	    @FXML
	    private void setetablissementEditerEtudiantButtonClick(Event event){
	        etablissementEtudiantSetAllClear();
	        etablissementEtudiantSetAllDisable();
	        isEtablissementEtudiantAddNewButtonClick = false;
	        isetablissementEtudiantEditButtonClick = false;
	    }

	    @FXML
	    private void setEffacerEtudiantButtonClick(Event event){
	        EtablissementEtudiantTableau getSelectedRow = etablissementEtudiantTableView.getSelectionModel().getSelectedItem();
	        String sqlQuery = "delete from teacher where dbTeacherID = '"+getSelectedRow.getEtablissementEtudiantTableauEmail()+"';";
	        try {
	            connection = database.getConnection();
	            statement = connection.createStatement();
	            int rowsAffected = statement.executeUpdate(sqlQuery);
	            etablissementEtudiantTableView.setItems(getDataFromTeacherAndAddToObservableList("SELECT * FROM teacher;"));

	        }
	        catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	    @FXML
	    private void setRehargerEtudiantButtonClick(Event event){
	       etablissementEtudiantTableView.setItems(getDataFromTeacherAndAddToObservableList("SELECT * FROM teacher;"));//sql Query
	        etudiantTFRechercher.clear();
	    }

	    @FXML
	    private void setRechercherEtudiantButtonClick(Event event){
	        String sqlQuery = "select * FROM teacher where dbTeacherID = '"+etudiantTFRechercher.getText()+"';";
	        etablissementEtudiantTableView.setItems(getDataFromTeacherAndAddToObservableList(sqlQuery));
	        etudiantTFRechercher.clear();
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

