/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.ConexionEstacionDeServicio;
import Modelo.EstacionDeServicio;
import Modelo.Precios;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

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
    
    static ArrayList<EstacionDeServicio> listaSucursalesStatic = new ArrayList<>();
    ConexionEstacionDeServicio conexion;

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
        this.conexion = new ConexionEstacionDeServicio(5000);
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
                "Todas"
        );
        this.listaSucursalesInforme.getItems().addAll(
                "Todas"
        );
        
    }
    
    @FXML
    private void nuevaSucursal(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/Vista/NuevaEstacionDeServicio.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.setTitle("Nueva sucursal");
        stage.setScene(new Scene(root1));
        stage.setResizable(false);
        stage.show();
    }
    
    @FXML
    private void actualizarDatosDePreciosPorSocursal(ActionEvent event) {
        if (this.precio93Fild.getText() != null && this.precio95Fild.getText() != null && this.precio97Fild.getText() != null
                && this.precioDieselFild.getText() != null && this.preciokerosenFild.getText() != null
                && this.listaSucursales.getSelectionModel().getSelectedItem() != null && this.listaSucursales.getSelectionModel().getSelectedItem().length() > 0) {
            double precio93 = Double.parseDouble(this.precio93Fild.getText());
            double precio95 = Double.parseDouble(this.precio95Fild.getText());
            double precio97 = Double.parseDouble(this.precio97Fild.getText());
            double precioDiesel = Double.parseDouble(this.precioDieselFild.getText());
            double preciokerosen = Double.parseDouble(this.preciokerosenFild.getText());
            String sucursal = this.listaSucursales.getSelectionModel().getSelectedItem();
            enviarPrecios(precio93, precio95, precio97, precioDiesel, preciokerosen, sucursal);
            limpiarFieldPrecios();
        } else {
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
     * Envia los nuevos precios a la sucursal especificada,
     *
     * @param precio93
     * @param precio95
     * @param precio97
     * @param precioDiesel
     * @param preciokerosen
     */
    private void enviarPrecios(double precio93, double precio95, double precio97, double precioDiesel, double preciokerosen, String sucursal) {

        
        Precios precios = new Precios(precio93, precio95, precio97, precioDiesel, preciokerosen);
        if (sucursal.equalsIgnoreCase("todas") == true) {
            this.conexion.modificarPrecioDeTodasLasEstacionesDeServicio(precios);
        } else {
            
            EstacionDeServicio Estacion = obtenerEstacion(sucursal);
            this.conexion.añadirEstacionDeServicio(Estacion);
            this.conexion.modifcarPreciosDeUnaEstacionDeServicio(Estacion.getId(), precios);
            
        }
        
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
    
    @FXML
    private void listarSucursales(MouseEvent event) {
        for (int i = 0; i < listaSucursalesStatic.size(); i++) {
            EstacionDeServicio aux = listaSucursalesStatic.get(i);
            String dato = "" + aux.getId() + "-" + aux.getDireccion();
            this.listaSucursales.getItems().removeAll(dato);
            this.listaSucursalesInforme.getItems().removeAll(dato);
            this.listaSucursales.getItems().add(dato);
            this.listaSucursalesInforme.getItems().add(dato);
            this.conexion.añadirEstacionDeServicio(aux);
        }
    }
    
    public EstacionDeServicio obtenerEstacion(String id) {
        String[] parts = id.split("-");
        if (parts.length > 1) {
            int idEstacion = Integer.parseInt(parts[0]);
            for (int i = 0; i < listaSucursalesStatic.size(); i++) {
                EstacionDeServicio estacion = listaSucursalesStatic.get(i);
                if (estacion.getId() == idEstacion) {
                    return estacion;
                }
                
            }
        }
        return null;
    }
}
