package com.mycompany.peluqueria_canina.logica;

import com.mycompany.peluqueria_canina.persistencia.Controladora_Persistencia;
import java.util.List;

public class Controladora {

    Controladora_Persistencia controlPersistencia = new Controladora_Persistencia();

    public void guardar(String nombreMascota, String razaMascota, String colorMascota,
            String observacionesMasco, String alergico, String atencionEsp,
            String nombre, String telefonoDuenio) {

        //Creo un obj Dueño y le asigno valores
        Duenio duenio = new Duenio();
        duenio.setNombre(nombre);
        duenio.setCelDuenio(telefonoDuenio);
        
        //Creo un obj Mascota y le asigno valores.
        Mascota mascota = new Mascota();
        mascota.setNombreMascota(nombreMascota);
        mascota.setRaza(razaMascota);
        mascota.setColor(colorMascota);
        mascota.setAlergico(alergico);
        mascota.setAtencionEspecial(atencionEsp);
        mascota.setObservaciones(observacionesMasco);
        
        mascota.setUnDuenio(duenio);
        
        controlPersistencia.guardar(duenio, mascota);
    }

    public List<Mascota> traerMascota() {
        return controlPersistencia.traerMascota();  
    }

    public void borrarMascota(int numCliente) {
        controlPersistencia.borrarMascota(numCliente);
    }

    public Mascota traerMascota(int numCliente) {
       
        return controlPersistencia.traerMascota(numCliente);
    }

    public void modificarMascota(Mascota mascota, String nombreMascota, String razaMascota,
            String colorMascota, String observacionesMasco, String alergico,
            String atencionEsp, String nombre, String telefonoDuenio) {
        
        mascota.setNombreMascota(nombreMascota);
        mascota.setRaza(razaMascota);
        mascota.setColor(colorMascota);
        mascota.setObservaciones(observacionesMasco);
        mascota.setAlergico(alergico);
        mascota.setAtencionEspecial(atencionEsp);
        
        controlPersistencia.modificarMascota(mascota);
        
        Duenio duenio = this.buscarDuenio(mascota.getUnDuenio().getId_duenio());
        duenio.setCelDuenio(telefonoDuenio);
        duenio.setNombre(nombre);
        
        this.modificarDuenio(duenio);
    }

    private Duenio buscarDuenio(int id_duenio) {
       return controlPersistencia.traerDuenio(id_duenio);
    }

    private void modificarDuenio(Duenio duenio) {
       controlPersistencia.modificarDuenio(duenio);
    }

}
