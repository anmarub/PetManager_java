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
public class AbstractClass {
    public static void main(String[] args) {
        // Instancia de la veterinay
        clsDoctor doctor = new clsDoctor("Isabella Rubiano Sierra", "1022363223");
        clsVeterinary veterinary = new clsVeterinary("Wuawi", "3002491338", "Cr70B 7 31", doctor);
        
        veterinary.setData(veterinary.getName() + " - " + veterinary.getAddress());
        
        String data = veterinary.getHospitalInformation();
        String type = veterinary.getPatientType();
        String surgery = veterinary.Surgery();
        
        System.out.println("Data: " + data);
        System.out.println("Type: " + type);
        System.out.println("Surgery: " + surgery);
        
    }
    
}
