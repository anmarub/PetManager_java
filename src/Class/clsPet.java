/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Class;

import Interfaces.*;


/**
 *
 * @author andres.rubiano
 */
//1) Definicion de los atributos de la clase clsPets, 2). se encapsulan en la opcion
//refactor>Encapsulate fields, seleccionada esta opcion automaticamente genera los 
// get y set para asignar y obtener los valores de los atributos
public class clsPet implements IAnimal, IVertebrate {

    private int petId;
    private String code;
    private String name;
    private int born_year;
    private String color;
    private String health_status;
    private clsVeterinary veterinary; // es un valor opcional

    
    
    //b) un Constructor de la clase clspet en donde paso por parametros los valores de los atributos, esto se obtiene 
    // con la abreviatura de Clrt + doble espacio
    public clsPet(String code, String name, int born_year, String color, String health_status, int petId) {
        this.petId = petId;
        this.code = code; // Se utiliza la palabra reservada this. para llamar un parametro de la clase clsPet
        this.name = name;
        this.born_year = born_year;
        this.color = color;
        this.health_status = health_status;
    }
    
    public void Eat(){
        System.out.println("La mascota " + this.name + " Esta comiendo");
    }
    
    public void Move(){
        System.out.println("La mascota " + this.name + " Esta Moviendose");
    }
    
    public void Sound(){
        System.out.println("La mascota " + this.name + " Realizando un sonido");
    }

    
    // Encapsulamiento de los atributos
    
    /**
     * @return the code
     */
    public String getCode() {
        return code;
    }

    /**
     * @param code the code to set
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the year
     */
    public int getborn_Year() {
        return born_year;
    }

    /**
     * @param year the year to set
     */
    public void setborn_Year(int year) {
        this.born_year = year;
    }
    
    /**
     * @return the color
     */
    public String getColor() {
        return color;
    }

    /**
     * @param color the color to set
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * @return the health_status
     */
    public String getHealth_status() {
        return health_status;
    }

    /**
     * @param health_status the health_status to set
     */
    public void setHealth_status(String health_status) {
        this.health_status = health_status;
    }

    /**
     * @return the veterinary
     */
    public clsVeterinary getVeterinary() {
        return veterinary;
    }

    /**
     * @param veterinary the veterinary to set
     */
    public void setVeterinary(clsVeterinary veterinary) {
        this.veterinary = veterinary;
    }

    @Override
    public String getAnimalType() {
        return "domestico";
    }
    
    @Override
    public int getNumberOfBones() {
        return 0;
    }
    
        /**
     * @return the petId
     */
    public int getPetId() {
        return petId;
    }

    /**
     * @param petId the petId to set
     */
    public void setPetId(int petId) {
        this.petId = petId;
    }
}
