/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.util.LinkedList;

import Class.*;
import Model.*;

/**
 *
 * @author andres.rubiano
 */
public class ctlPet {
    //Invocar el modelo de datos desde el controller
    private modelDog ModeloPerro;
    //private modelCat ModeloGato;

    public ctlPet(){
        //
        this.ModeloPerro = new modelDog();
        //this.ModeoGato = new modelCat();

    }

    public boolean createMascota(clsPet mascota){
        try{
        switch(mascota.getAnimalType()){
            case "Gato":
            
                break;
            case "Perro":
                this.ModeloPerro.createMascota((clsDog)mascota);
                break;
        }
            return true;
        }catch(Exception error){
            return false;
            }
    }

    public clsPet searchMascota(String codigo, String tipo){
        clsPet mascota = null;
        try{
            switch(tipo){
                case "Gato":
                
                    break;
                case "Perro":
                    mascota = this.ModeloPerro.searchMascota(codigo);
                    break;
        }
                return mascota;
        }catch(Exception error){
                return null;
                }
    }

    public boolean updateMascota(clsPet mascota){
        try{
            switch(mascota.getAnimalType()){
                case "Gato":
                
                    break;
                case "Perro":
                    this.ModeloPerro.updateMascota((clsDog)mascota);
                    break;
            }
            return true;
        }catch(Exception error){
            return false;
            }

    }

    public boolean deleteMascota(clsPet mascota){
        try{
            switch(mascota.getAnimalType()){
                case "Gato":
                
                    break;
                case "Perro":
                    this.ModeloPerro.deleteMascota((clsDog)mascota);
                    break;
            }
            return true;
        }catch(Exception error){
            return false;
            }
    }

    public LinkedList<clsPet> ListMascota(String tipo){
        LinkedList<clsPet> listMascota = null;
        try{
            switch(tipo){
                case "Gato":
                
                    break;
                case "Perro":
                    listMascota = this.ModeloPerro.ListMascota();
                    break;
        }
                return listMascota;
        }catch(Exception error){
                return null;
                }
    }

    public LinkedList<clsReportePorEstadoSalud> ListMascotaEstadoSalud(){
        LinkedList<clsReportePorEstadoSalud> listReporteMascota = this.ModeloPerro.ListMascotaEstadoSalud();
        return listReporteMascota;
    }
    
}
