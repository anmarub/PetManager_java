/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package petmanager;

import Class.clsDog;

/**
 *
 * @author andres.rubiano
 */
public class Poliformismo3 {
    public static void main(String[] arg){
        // Instanciar clases hijas
      clsDog dog = new clsDog(1,"criollo",false,"001", "Firulais", 2013, "Cafe", "Sano",1);   
      
      dog.WalkAround();
      dog.WalkAround(false);
      dog.WalkAround(15);
    }
}
