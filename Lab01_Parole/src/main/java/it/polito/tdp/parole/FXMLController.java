package it.polito.tdp.parole;

import it.polito.tdp.parole.model.Parole;

import java.net.URL;
import java.util.ResourceBundle;

import javax.management.modelmbean.ModelMBean;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {
	
	Parole elenco ;
	
   @FXML
    private TextArea txtTempoOperazione;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtParola;

    @FXML
    private Button btnInserisci;

    @FXML
    private TextArea txtResult;
    
    @FXML
    private Button btnCancella ;

    @FXML
    private Button btnReset;
    
    @FXML
    void doCancella(ActionEvent event) {
    	String parola = txtParola.getText() ;
    	txtParola.clear();
    	double t1 = System.nanoTime() ;
    	elenco.cancellaParola(parola);
    	double t2 =System.nanoTime() ;
    	String result = "" ;
    	for(String s : elenco.getElenco()) {
    		result += s+"\n" ;
    	}
    	txtResult.setText(result);
    	txtTempoOperazione.setText("REMOVE: "+(t2-t1)/1e9+"seconds");
    	
    }

    @FXML
    void doInsert(ActionEvent event) {
    	String parola = txtParola.getText() ;
    	txtParola.clear();
    	double t1 = System.nanoTime() ;
    	elenco.addParola(parola);
    	double t2 =System.nanoTime() ;
    	String result = "" ;
    	for(String s : elenco.getElenco()) {
    		result += s+"\n" ;
    	}
    	txtResult.setText(result);
    	txtTempoOperazione.setText("INSERT: "+(t2-t1)/1e9+"seconds");
    }

    @FXML
    void doReset(ActionEvent event) {
    	elenco.reset();
    	txtResult.clear();
    }
    
    public void setParole(Parole elenco) {
    	this.elenco = elenco ;
    }

    @FXML
    void initialize() {
        assert txtParola != null : "fx:id=\"txtParola\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnInserisci != null : "fx:id=\"btnInserisci\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnCancella != null : "fx:id=\"btnCancella\" was not injected: check your FXML file 'Scene.fxml'.";
		assert txtTempoOperazione != null : "fx:id=\"txtTempoOperazione\" was not injected: check your FXML file 'Scene.fxml'.";
        elenco = new Parole() ;
    }
}
