/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author andres.rubiano
 */
public class ConTest {
    
    public static void main(String[] args){
        String driver = "com.mysql.jdbc.Driver";
        String usuario = "wcb1_app";
        String password = "eg9FBIyR";
        String url = "jdbc:mysql://wuawi.com:3306/wcb1_admincv";
        Connection connection;
        
    try(Connection conexionBD = DriverManager.getConnection(url, usuario, password)){
            String ConsultaBusqueda = "SELECT p.id, codigo, nombre, born_year, color, estado_salud, d.id, raza, pedigree FROM tb_pet as p INNER JOIN tb_dog as d on p.id = id_pet";
            PreparedStatement declararPet = conexionBD.prepareStatement(ConsultaBusqueda);
            ResultSet respuesta = declararPet.executeQuery();
            while(respuesta.next()){
                int petId = respuesta.getInt(1);
                String petCodigo = respuesta.getString(2);
                String petNombre = respuesta.getString(3);
                int petBornYear = respuesta.getInt(4);
                String petColor = respuesta.getString(5);
                String petEstadoSalud = respuesta.getString(6);
                int dogId = respuesta.getInt(7);
                String dogRaza = respuesta.getString(8);
                Boolean dogPedigree = respuesta.getBoolean(9);
                
                System.out.println(petId +" "+ petCodigo +" "+ petNombre +" "+ petColor +" "+ petEstadoSalud +" "+ dogRaza);
        }
    }catch(Exception errors){
        System.out.println("Error en la conexion" + " " +errors.getMessage());
    }
    }
    
}
