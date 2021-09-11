/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package petmanager;

import Class.*; // importamos la clase creada al main
import java.util.Date;
/**
 *
 * @author andres.rubiano
 */
public class PetManager {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Instancio la clase clsPet sin atributos y envio los atributos definidos en la clase
        // uno por uno
        clsDog Dog1 = new clsDog(1,"criollo",false,"001", "Firulais", 2013, "Cafe", "Sano",1);
        
        // otra manera de instanciar la clase es con el construtor con atributos, los cuales paso a la
        // Clase y creo la siguiente mascota.
        clsCat Cat1 = new clsCat("angora","002", "Minino", 2018, "Blanco y negro", "Enfermo",1);
        
        Date fecha_actual = new Date();
        int yearActual = fecha_actual.getYear();
        
        int edadDog = yearActual - Dog1.getborn_Year();
        int edadCat = yearActual - Cat1.getborn_Year();
        
        if(edadDog > edadCat){
           System.out.println("La Mascota "+ Dog1.getName()+ "es mayor que la mascota " + Cat1.getName());
        }else{
            if(edadCat > edadDog){
            System.out.println("La Mascota "+ Cat1.getName()+ "es mayor que la mascota " + Dog1.getName());
        }else{
              if(edadCat == edadDog){
                  System.out.println("La Mascota "+ Cat1.getName()+ "Tienen la misma edad que " + Dog1.getName());
                }
            }
        }
        
        Dog1.Eat();
        Dog1.WalkAround();
        
        Cat1.Eat();
        Cat1.Move();
        Cat1.Sound();
        Cat1.SelfClean();
    }
    
}
