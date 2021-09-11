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
 */
public class Interface {
    public static void main(String[] arg){
        
        clsDog dog = new clsDog(1,"criollo",false,"001", "Firulais", 2013, "Cafe", "Sano",1);
        clsCat cat = new clsCat("angora","002", "Minino", 2018, "Blanco y negro", "Enfermo",2);
        
        System.out.println(dog.getAnimalType());
        System.out.println("" + dog.getNumberOfBones());
        
        System.out.println(cat.getAnimalType());
        System.out.println("" + cat.getNumberOfBones());
    }
    
}
