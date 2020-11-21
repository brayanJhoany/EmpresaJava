/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.EstacionDeServicio;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author braya
 */
public class NuevaEstacionDeServicioController implements Initializable {
    @FXML
    private TextField idEstacionField;
    @FXML
    private TextArea direccionEstacionField;
    @FXML
    private TextField ipEstacionField;
    @FXML
    private Button cancelarNuevaEstacionBtn;
    @FXML
    private Button aceptarNuevaEstacionBtn;

    public NuevaEstacionDeServicioController() {
        this.idEstacionField= new TextField();
        this.direccionEstacionField = new TextArea();
        this.ipEstacionField = new TextField();
        this.cancelarNuevaEstacionBtn = new Button();
        this.aceptarNuevaEstacionBtn = new Button();
    }
    
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void cerrarVentanaNuevaEstacion(ActionEvent event) {
        Stage stage = (Stage) this.cancelarNuevaEstacionBtn.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void registrarNuevaEstacion(ActionEvent event) {
        if(this.idEstacionField.getText() != null && this.ipEstacionField.getText() != null && 
                this.direccionEstacionField.getText() != null){
            /*
                System.out.println("id : " + this.idEstacionField.getText());
                System.out.println("direccion : " + this.direccionEstacionField.getText());
                System.out.println("ip : " + this.ipEstacionField.getText());
            */
            EstacionDeServicio estacion = new EstacionDeServicio(Integer.parseInt(this.idEstacionField.getText()), this.direccionEstacionField.getText(), this.ipEstacionField.getText(), 5000);
            VistaPrincipalController.listaSucursalesStatic.add(estacion);
            //cerramos la ventana
            Stage stage = (Stage) this.cancelarNuevaEstacionBtn.getScene().getWindow();
            stage.close();
        }
    }
    
}
