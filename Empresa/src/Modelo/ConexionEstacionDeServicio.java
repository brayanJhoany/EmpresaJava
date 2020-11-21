/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import com.sun.org.apache.bcel.internal.generic.AALOAD;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Brayan Escobar
 */
public class ConexionEstacionDeServicio {

    ArrayList<EstacionDeServicio> listaEstaciones;
    private final int puerto;
    //private DataInputStream entrada;
    //private DataOutputStream salida;

    public ConexionEstacionDeServicio(int puerto) {
        this.listaEstaciones = new ArrayList<>();
        this.puerto = puerto;
    }

    /**
     * Modifica los precios de una estacion de servicio
     */
    public void modifcarPreciosDeUnaEstacionDeServicio(int idEstacion, Precios precios) {
        System.out.println("El identificador de la estadocion es: " + idEstacion);
        EstacionDeServicio estacion = obtenerEstacionDeServicio(idEstacion);
        if (estacion != null) {
            try {
                Socket socket = new Socket(estacion.getIp(), estacion.getPuerto());
                DataInputStream entrada = new DataInputStream(socket.getInputStream());
                DataOutputStream salida = new DataOutputStream(socket.getOutputStream());
                salida.writeInt(1);
                salida.writeDouble(precios.getB93());
                salida.writeDouble(precios.getB95());
                salida.writeDouble(precios.getB97());
                salida.writeDouble(precios.getDisel());
                salida.writeDouble(precios.getKerosene());
                salida.close();
                salida.close();
                socket.close();
            } catch (IOException ex) {
                Logger.getLogger(ConexionEstacionDeServicio.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }

    /**
     * Añade una nueva estacion de servicio a la lista, verificando que no se
     * encuentre registrada previamente.
     *
     * @param estacion
     */
    public void añadirEstacionDeServicio(EstacionDeServicio estacion) {
        boolean agregar = true;
        for (int i = 0; i < this.listaEstaciones.size(); i++) {
            EstacionDeServicio get = this.listaEstaciones.get(i);
            if (get.getId() == estacion.getId()) {
                agregar = false;
            }
        }
        if (agregar == true) {
            this.listaEstaciones.add(estacion);
        }

    }

    /**
     * Obteine una estacion de servicio a traves de su identificador.
     *
     * @param id
     * @return
     */
    public EstacionDeServicio obtenerEstacionDeServicio(int id) {
        for (int i = 0; i < this.listaEstaciones.size(); i++) {
            EstacionDeServicio get = this.listaEstaciones.get(i);
            if (get.getId() == id) {
                return get;
            }

        }
        return null;
    }

    /**
     * Modifica el precio de todas las estaciones de servicio.
     *
     * @param precios
     */
    public void modificarPrecioDeTodasLasEstacionesDeServicio(Precios precios) {

        for (int i = 0; i < this.listaEstaciones.size(); i++) {
            EstacionDeServicio estacion = this.listaEstaciones.get(i);
            try {
                Socket socket = new Socket(estacion.getIp(), estacion.getPuerto());
                DataInputStream entrada = new DataInputStream(socket.getInputStream());
                DataOutputStream salida = new DataOutputStream(socket.getOutputStream());
                salida.writeInt(1);
                salida.writeDouble(precios.getB93());
                salida.writeDouble(precios.getB95());
                salida.writeDouble(precios.getB97());
                salida.writeDouble(precios.getDisel());
                salida.writeDouble(precios.getKerosene());
                salida.close();
                salida.close();
                socket.close();
            } catch (IOException ex) {
                Logger.getLogger(ConexionEstacionDeServicio.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

}
