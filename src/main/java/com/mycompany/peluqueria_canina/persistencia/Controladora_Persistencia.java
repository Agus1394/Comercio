package com.mycompany.peluqueria_canina.persistencia;

import com.mycompany.peluqueria_canina.logica.Duenio;
import com.mycompany.peluqueria_canina.logica.Mascota;
import com.mycompany.peluqueria_canina.persistencia.exceptions.NonexistentEntityException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Controladora_Persistencia {
    
    DuenioJpaController duenioJpa = new DuenioJpaController();
    MascotaJpaController mascotaJpa = new MascotaJpaController();

    public void guardar(Duenio duenio, Mascota mascota) {
       
        //Creo en la BDD un Dueño y una Mascota
        duenioJpa.create(duenio);
        mascotaJpa.create(mascota);
        
    }

    public List<Mascota> traerMascota() {
        return mascotaJpa.findMascotaEntities();
    }

    public void borrarMascota(int numCliente) {
        try {
            mascotaJpa.destroy(numCliente);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(Controladora_Persistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Mascota traerMascota(int numCliente) {
       return mascotaJpa.findMascota(numCliente);
    }

    public void modificarMascota(Mascota mascota) {
        try {
            mascotaJpa.edit(mascota);
        } catch (Exception ex) {
            Logger.getLogger(Controladora_Persistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Duenio traerDuenio(int id_duenio) {
       return duenioJpa.findDuenio(id_duenio);
    }

    public void modificarDuenio(Duenio duenio) {
        try {
            duenioJpa.edit(duenio);
        } catch (Exception ex) {
            Logger.getLogger(Controladora_Persistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
