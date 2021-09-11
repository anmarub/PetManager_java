/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package petmanager;

import Class.*;


/**
 *
 * @author andres.rubiano
 * Poliformismo Puro 
 */
public class Polimorfismo {
    public static void main(String[] args) {
        // Instanciar clases hijas
        clsDog dog = new clsDog(1,"criollo",false,"001", "Firulais", 2013, "Cafe", "Sano",1);
        clsCat cat = new clsCat("angora","002", "Minino", 2018, "Blanco y negro", "Enfermo",1);
        
        // Instancia de la veterinay
        clsDoctor doctor = new clsDoctor("Isabella Rubiano Sierra", "1022363223");
        clsVeterinary veterinary = new clsVeterinary("Wuawi", "3002491338", "Cr70B 7 31", doctor);
        
        String careDog = veterinary.PetCare(dog);
        System.out.println("El estado de salud de " + dog.getName() + " es " + careDog);
        
        String careCat = veterinary.PetCare(cat);
        System.out.println("El estado de salud de " + cat.getName() + " es " + careCat);
    }
}
