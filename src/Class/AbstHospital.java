/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Class;

/**
 *
 * @author andres.rubiano
 */
//Palabra definir una clase abstract 
public abstract class AbstHospital {
   
    private String data;
    
    public abstract String getPatientType();
    public abstract String Surgery();
    
    public String getHospitalInformation(){
        return "La informacion es: " + this.getData();
    }
    
        /**
     * @return the data
     */
    public String getData() {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(String data) {
        this.data = data;
    }
}
