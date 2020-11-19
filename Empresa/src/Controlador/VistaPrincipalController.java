/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import com.sun.org.apache.bcel.internal.generic.AALOAD;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author braya
 */
public class VistaPrincipalController implements Initializable {

    @FXML
    private Button nuevaSucursalBtn;
    @FXML
    private ComboBox<String> listaSucursales;

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
    private TextField preciokerosenFild = new TextField();

    @FXML
    private ComboBox<String> tiposDeCombustibleBox;
    @FXML
    private Button generarInformeBtn;
    @FXML
    private ComboBox<String> listaSucursalesInforme;

    public VistaPrincipalController() {
        this.listaSucursalesInforme = new ComboBox<>();
        this.generarInformeBtn = new Button();
        this.tiposDeCombustibleBox = new ComboBox<>();
        this.actualizarDatosBtn = new Button();
        this.precioDieselFild = new TextField();
        this.precio97Fild = new TextField();
        this.precio95Fild = new TextField();
        this.precio93Fild = new TextField();
        this.listaSucursales = new ComboBox<>();
        this.nuevaSucursalBtn = new Button();
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.tiposDeCombustibleBox.getItems().addAll(
                "93", "95", "97", "Diesel", "Kerosene"
        );
        this.listaSucursales.getItems().addAll(
                "00-Todas", "01-Talca", "02-Linares"
        );
        this.listaSucursalesInforme.getItems().addAll(
                "00-Todas", "01-Talca", "02-Linares"
        );

    }

    @FXML
    private void nuevaSucursal(ActionEvent event) {
        System.out.println("Abrir ventana, Nueva sucursal");
    }

    @FXML
    private void actualizarDatosDePreciosPorSocursal(ActionEvent event) {

        String precio93 = this.precio93Fild.getText();
        String precio95 = this.precio95Fild.getText();
        String precio97 = this.precio97Fild.getText();
        String precioDiesel = this.precioDieselFild.getText();
        String preciokerosen = this.preciokerosenFild.getText();
        String sucursal = this.listaSucursales.getSelectionModel().getSelectedItem();

        if (precio93 != null && precio95 != null && precio97 != null & precioDiesel != null && preciokerosen != null && sucursal != null) {
            if (precio93.length() > 0 && precio95.length() > 0 && precio97.length() > 0
                    && precioDiesel.length() > 0 && preciokerosen.length() > 0 && sucursal.length() > 0) {
                enviarPrecios(precio93, precio95, precio97, precioDiesel, preciokerosen, sucursal);
                limpiarFieldPrecios();
            }
        }

    }

    @FXML
    private void generarInforme(ActionEvent event) {
        String sucursal = this.listaSucursalesInforme.getSelectionModel().getSelectedItem();
        String tipoDeCombustible = this.tiposDeCombustibleBox.getSelectionModel().getSelectedItem();

        if (sucursal != null && tipoDeCombustible != null && sucursal.length() > 0 && tipoDeCombustible.length() > 0) {
            System.out.println("La socursal es: " + sucursal);
            System.out.println("Tipo de combustible: " + tipoDeCombustible);
        }

    }

    /**
     * Envia los nuevos precios a la sucursal especificada
     *
     * @param precio93
     * @param precio95
     * @param precio97
     * @param precioDiesel
     * @param preciokerosen
     */
    private void enviarPrecios(String precio93, String precio95, String precio97, String precioDiesel, String preciokerosen, String sucursal) {
        System.out.println("Sucursal " + sucursal);
        System.out.println("precio  de 93 : " + precio93);
        System.out.println("precio  de 95 : " + precio95);
        System.out.println("precio  de 97 : " + precio97);
        System.out.println("precio  de Diesel : " + precioDiesel);
        System.out.println("precio  de kerosen : " + preciokerosen);
    }

    /**
     * Limpia los campos donde se indica el precio de la vencina.
     */
    private void limpiarFieldPrecios() {
        this.precio93Fild.setText(null);
        this.precio95Fild.setText(null);
        this.precio97Fild.setText(null);
        this.precioDieselFild.setText(null);
        this.preciokerosenFild.setText(null);
    }

}
