/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author braya
 */
public class VistaPrincipalController implements Initializable {

    @FXML
    private Button nuevaSucursalBtn;
    @FXML
    private ComboBox<?> listaSucursales;
    @FXML
    private TextField precio93Fild;
    @FXML
    private TextField precio95Fild;
    @FXML
    private TextField precio97Fild;
    @FXML
    private TextField precioDieselFild;
    @FXML
    private Button actualizarDatosBtn;
    @FXML
    private TextField preciokerosenFild;
    @FXML
    private ComboBox<?> listaSucursalesInformeBox;
    @FXML
    private ComboBox<?> tiposDeCombustibleBox;
    @FXML
    private Button generarInformeBtn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void nuevaSucursal(ActionEvent event) {
        System.out.println("Hola mundo");
    }

    @FXML
    private void mostrarListaSucursales(ActionEvent event) {
    }

    @FXML
    private void actualizarDatosDePreciosPorSocursal(ActionEvent event) {
    }

    @FXML
    private void mostrarTiposDeCombustible(ActionEvent event) {
    }

    @FXML
    private void generarInforme(ActionEvent event) {
    }
    
}
