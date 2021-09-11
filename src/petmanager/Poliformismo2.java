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
 * Poliformismo de sobreescritura de clases Ejemplo
 */
public class Poliformismo2 {
    public static void main(String[] arg){
        // Instanciar clases hijas
        clsDog dog = new clsDog(1,"criollo",false,"001", "Firulais", 2013, "Cafe", "Sano",1);
        clsCat cat = new clsCat("angora","002", "Minino", 2018, "Blanco y negro", "Enfermo",1);
        
        dog.Sound();
        cat.Sound();
        
    }
}
