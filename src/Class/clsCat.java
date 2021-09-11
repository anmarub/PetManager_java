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
// "extends definimos a la clase padre a la que pertenece
public class clsCat extends clsPet {

    private String Breed;

    public clsCat(String Breed, String code, String name, int born_year, String color, String health_status, int petId) {
        super(code, name, born_year, color, health_status, petId);  // Clase padre ubicada clsPets
        this.Breed = Breed;
    }
   
    public void SelfClean(){
        System.out.println("El gato " + super.getName() +" se esta limpiando");
    }
    
    //con la palabra "Override" Cambiamos el metodo original de la clase padre, por el metodo definido en la clase hija (SobreEscritura).
    @Override
    public void Sound(){
        System.out.println("El Gato " + super.getName() + " hace Miau!!!");
    }
    
    @Override
    public int getNumberOfBones(){
        return 230;
    }
    
    @Override
    public String getAnimalType(){
        return "Gato"; // Este parametro debe coincidir con el parametro el controlador.
    }
    
    
     /**
    * @return the Breed
    */
    public String getBreed() {
        return Breed;
    }

    /**
     * @param Breed the Breed to set
     */
    public void setBreed(String Breed) {
        this.Breed = Breed;
    }    

}
