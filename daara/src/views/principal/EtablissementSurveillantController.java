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

public class EtablissementSurveillantController implements Initializable {

	
	 private Connection connection;
	    private Statement statement;
	    private ResultSet resultSet;
	    private boolean isEtablissementSurveillantAddNewButtonClick;
	    private boolean isEtablissementSurveillantEditButtonClick;
	    private MenuBarControl menuBarControl = new MenuBarControl();
	    private String temp ;



	    @FXML
	    TableView<EtablissementSurveillantTableau> etablissementSurveillantTableView;
	    @FXML
	    TableColumn<EtablissementSurveillantTableau,String> etablissementSurveillantColumnNom;
	    @FXML
	    TableColumn<EtablissementSurveillantTableau,String> etablissementSurveillantColumnPrenom;
	    @FXML
	    TableColumn<EtablissementSurveillantTableau,String> etablissementSurveillantColumnEmail;
	    @FXML
	    TableColumn<EtablissementSurveillantTableau,String> etablissementSurveillantColumnAddresse;
	    @FXML
	    TableColumn<EtablissementSurveillantTableau,String> etablissementSurveillantColumnNumTel;
	    


	    @FXML
	    private TextField etablissementSurveillantTFNom;
	    @FXML
	    private TextField etablissementSurveillantTFPrenom;
	    @FXML
	    private TextField etablissementSurveillantTFEmail;
	    @FXML
	    private TextField etablissementSurveillantTFAddresse;	    
	    @FXML
	    private TextField etablissementSurveillantTFNumTel;
	   
	    @FXML
	    private TextField surveillantTFRechercher;


	    @FXML
	    private Button etablissementEditerSurveillantButtonClick;
	    @FXML
	    private Button etablissementSauverSurveillantButtonClick;
		private Statement database;


	    private ObservableList getDataFromTeacherAndAddToObservableList(String query){
	        ObservableList<EtablissementSurveillantTableau> etablissementSurveillantTableauData = FXCollections.observableArrayList();
	        
	        return etablissementSurveillantTableauData;
	    }

	    @Override
	    public void initialize(URL location, ResourceBundle resources) {

	    	etablissementSurveillantColumnNom.setCellValueFactory(new PropertyValueFactory<EtablissementSurveillantTableau,String>("EtablissementSurveillantTableauNom"));
	    	etablissementSurveillantColumnPrenom.setCellValueFactory(new PropertyValueFactory<EtablissementSurveillantTableau,String>("EtablissementSurveillantTableauPrenom"));
	    	etablissementSurveillantColumnEmail.setCellValueFactory(new PropertyValueFactory<EtablissementSurveillantTableau,String>("EtablissementSurveillantTableauEmail"));
	    	etablissementSurveillantColumnAddresse.setCellValueFactory(new PropertyValueFactory<EtablissementSurveillantTableau,String>("EtablissementSurveillantTableauAddresse"));
	    	etablissementSurveillantColumnNumTel.setCellValueFactory(new PropertyValueFactory<EtablissementSurveillantTableau,String>("EtablissementSurveillantTableauNumTel"));
	    	

	    	etablissementSurveillantTableView.setItems(getDataFromTeacherAndAddToObservableList("SELECT * FROM etablissement;"));

	    }

	    @FXML
	    private void setAjouterSurveillantClick(Event event){
	        etablissementSurveillantSetAllEnable();
	        isEtablissementSurveillantAddNewButtonClick = true;
	    }

	    private void etablissementSurveillantSetAllEnable(){
	        etablissementSurveillantTFNom.setDisable(false);
	        etablissementSurveillantTFPrenom.setDisable(false);
	        etablissementSurveillantTFAddresse.setDisable(false);
	        etablissementSurveillantTFEmail.setDisable(false);
	        etablissementSurveillantTFNumTel.setDisable(false);
	        

	        etablissementEditerSurveillantButtonClick.setDisable(false);
	        etablissementSauverSurveillantButtonClick.setDisable(false);
	    }

	    private void etablissementSurveillantSetAllDisable(){
	        etablissementSurveillantTFNom.setDisable(true);
	        etablissementSurveillantTFPrenom.setDisable(true);
	        etablissementSurveillantTFAddresse.setDisable(true);
	        etablissementSurveillantTFEmail.setDisable(true);
	        etablissementSurveillantTFNumTel.setDisable(true);
	        

	        etablissementEditerSurveillantButtonClick.setDisable(true);
	        etablissementSauverSurveillantButtonClick.setDisable(true);
	    }

	    private void etablissementSurveillantSetAllClear(){
	        etablissementSurveillantTFNom.clear();
	        etablissementSurveillantTFPrenom.clear();
	        etablissementSurveillantTFAddresse.clear();
	        etablissementSurveillantTFNumTel.clear();
	        etablissementSurveillantTFEmail.clear();
	        

	    }

	    @FXML
	    private void setEditerSurveillantClick(Event event){
	        EtablissementSurveillantTableau getSelectedRow = etablissementSurveillantTableView.getSelectionModel().getSelectedItem();


	        String sqlQuery = "select * FROM Surveillant where SurveillantId = '"+getSelectedRow.getEtablissementSurveillantTableauEmail()+"';";

	        try {
	            
	            while(resultSet.next()) {
	                etablissementSurveillantTFNom.setText(resultSet.getString("dbSurveillantNom"));
	                etablissementSurveillantTFPrenom.setText(resultSet.getString("dbSurveillantPrenom"));
	                etablissementSurveillantTFAddresse.setText(resultSet.getString("dbSurveillantAddresse"));
	                etablissementSurveillantTFEmail.setText(resultSet.getString("dbSurveillantEmail"));
	                etablissementSurveillantTFNumTel.setText(resultSet.getString("dbSurveillantNumTel"));
	        

	            }

	            temp =etablissementSurveillantTFAddresse.getText();
	            isEtablissementSurveillantEditButtonClick = true;
	        }
	        catch (SQLException e) {
	            e.printStackTrace();
	        }

	    }

	    @FXML
	    private void setSauverSurveillantButtonClick(Event event){

	        try{
	            
	            if(isEtablissementSurveillantAddNewButtonClick){
	                int rowsAffected = statement.executeUpdate("insert into `teacher` (`dbSurveillantNom`,`dbSurveillantPrenom`,`dbSurveillantAddresse`,`dbSurveillantEmail`,`dbSurveillantNumTel`) values ('"+
	                        etablissementSurveillantTFNom.getText()+"','"+etablissementSurveillantTFPrenom.getText()+"','"+etablissementSurveillantTFAddresse.getText()+"','"+etablissementSurveillantTFEmail.getText()
	                        +"','"+etablissementSurveillantTFNumTel.getText()+"') ;");
	            }
	            else if (isEtablissementSurveillantEditButtonClick){
	                int rowsAffected = statement.executeUpdate("update teacher set "+
	                        "dbTeacherFname = '"+etablissementSurveillantTFNom.getText()+"',"+
	                        "dbTeacherLname = '"+etablissementSurveillantTFPrenom.getText()+"',"+
	                        "dbTeacherID = '"+etablissementSurveillantTFAddresse.getText()+"',"+
	                        "dbTeacherEmail = '"+etablissementSurveillantTFEmail.getText()+"',"+
	                        "dbTeacherDepartment = '"+etablissementSurveillantTFNumTel.getText()+"',"+
	                        

	                        "' where dbSurveillantID = '"+
	                        temp+"';");
	            }


	            connection.close();
	            statement.close();
	            resultSet.close();
	        }
	        catch (SQLException e){
	            e.printStackTrace();
	        }
	        etablissementSurveillantSetAllClear();
	        etablissementSurveillantSetAllDisable();
	        etablissementSurveillantTableView.setItems(getDataFromTeacherAndAddToObservableList("SELECT * FROM surveillant;"));
	        isEtablissementSurveillantAddNewButtonClick=false;
	        isEtablissementSurveillantEditButtonClick = false;

	    }

	    @FXML
	    private void setEtablissementSurveillantClearButtonClick(Event event){
	        etablissementSurveillantSetAllClear();
	        etablissementSurveillantSetAllDisable();
	        isEtablissementSurveillantAddNewButtonClick = false;
	        isEtablissementSurveillantEditButtonClick = false;
	    }

	    @FXML
	    private void setEffacerSurveillantButtonClick(Event event){
	        EtablissementSurveillantTableau getSelectedRow = etablissementSurveillantTableView.getSelectionModel().getSelectedItem();
	        String sqlQuery = "delete from teacher where dbTeacherID = '"+getSelectedRow.getEtablissementSurveillantTableauEmail()+"';";
	        try {
	            connection = database.getConnection();
	            statement = connection.createStatement();
	            int rowsAffected = statement.executeUpdate(sqlQuery);
	            etablissementSurveillantTableView.setItems(getDataFromTeacherAndAddToObservableList("SELECT * FROM surveillant;"));

	        }
	        catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	    @FXML
	    private void setRehargerSurveillantButtonClick(Event event){
	       etablissementSurveillantTableView.setItems(getDataFromTeacherAndAddToObservableList("SELECT * FROM surveillant;"));//sql Query
	        surveillantTFRechercher.clear();
	    }

	    @FXML
	    private void setRechercherSurveillantButtonClick(Event event){
	        String sqlQuery = "select * FROM surveillant where dbSurveillantID = '"+surveillantTFRechercher.getText()+"';";
	        etablissementSurveillantTableView.setItems(getDataFromTeacherAndAddToObservableList(sqlQuery));
	        surveillantTFRechercher.clear();
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
