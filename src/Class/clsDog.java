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
public class clsDog extends clsPet {

    private int dogId;
    private String Breed;
    private boolean pedigree;

    public clsDog(int dogId, String Breed, boolean pedigree, String code, String name, int born_year, String color, String health_status, int petId) {
        super(code, name, born_year, color, health_status, petId);
        this.dogId = dogId;
        this.Breed = Breed;
        this.pedigree = pedigree;
    }

    
    
// Polimorfismo de sobrecarga, el el cual podemos definir el mismo metodo, pero con diferentes parametros de clase.
    public void WalkAround(){
        System.out.println("El perro " + super.getName() +" esta paseando "); // palabra reservada super para obtener el valor desde la clase que se esta heredando
    }
    
    public void WalkAround(int km){
        System.out.println("El Perro " + super.getName() + " Esta caminando " + km + " Km ");
    }
    
    public void WalkAround(boolean dogCorrea){
        String Correa = dogCorrea ? " con correa " : " sin Correa "; // If resumido usado en Java
        System.out.println("El Perro" + super.getName() + " esta caminando " + Correa);
    }
    
    //con la palabra "Override" Cambiamo el metodo original de la clase padre, por el metodo definido en la clase hija.
    @Override
    public void Sound(){
        System.out.println("El Perro " + super.getName() + " hace Guagua!!!");
    }
    
    
    /**
     * @return the Breed
     */
    public String getBreed() {
        return Breed;
    }

    @Override
    public String getAnimalType(){
        return "Perro";
    }

    /**
     * @param Breed the Breed to set
     */
    public void setBreed(String Breed) {
        this.Breed = Breed;
    }
    
    /**
    * @return the pedigree
    */
    public boolean isPedigree() {
        return pedigree;
    }

    /**
    * @param pedigree the pedigree to set
    */
    public void setPedigree(boolean pedigree) {
        this.pedigree = pedigree;
    }

    /**
     * @return the dogId
     */
    public int getDogId() {
        return dogId;
    }

    /**
     * @param dogId the dogId to set
     */
    public void setDogId(int dogId) {
        this.dogId = dogId;
    }
    
    
}
