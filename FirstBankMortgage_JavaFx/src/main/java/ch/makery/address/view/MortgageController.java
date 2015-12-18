package ch.makery.address.view;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.time.ZoneId;
import java.util.Date;
import java.util.UUID;

import base.PersonDAL;
import base.RateDAL;
import ch.makery.address.MainApp;
import ch.makery.address.model.Person;
import ch.makery.address.model.Rate;
import ch.makery.address.util.DateUtil;


public class MortgageController {


	@FXML
    private TextField Income;
	@FXML
    private TextField Expenses;
	@FXML
    private TextField CreditScore;
	@FXML
    private TextField HouseCost;
	private Rate rate;
	
	
	
	public void setRate(Rate rate) {
        this.rate = rate;

        
        Income.setText(rate.getIncome());
        Expenses.setText(rate.getExpenses());
        CreditScore.setText(rate.getCreditScore());
        HouseCost.setText(rate.getHousrCost());
    }
    // Reference to the main application.
    private MainApp mainApp;

    /**
     * The constructor.
     * The constructor is called before the initialize() method.
     */
    public MortgageController() {
    }

    /**
     * Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded.
     */
    @FXML
    private void initialize() {

    }

    /**
     * Is called by the main application to give a reference back to itself.
     * 
     * @param mainApp
     */
    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }
    
   
}