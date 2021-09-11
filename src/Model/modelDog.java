/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Class.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

/**
 *
 * @author andres.rubiano
 */
public class modelDog {

    DbData baseDatos;
    
    public modelDog() {
        this.baseDatos = new DbData();
    }
 
        
    public boolean createMascota(clsDog perro){
        try(Connection conexionBD = DriverManager.getConnection(baseDatos.getUrl(), baseDatos.getUsuario(), baseDatos.getPassword())){
            String consultaPet = "INSERT INTO tb_pet(codigo, nombre, born_year, color, estado_salud) VALUES(?,?,?,?,?)";
            PreparedStatement declararPet = conexionBD.prepareStatement(consultaPet, Statement.RETURN_GENERATED_KEYS);
            declararPet.setString(1, perro.getCode());
            declararPet.setString(2, perro.getName());
            declararPet.setInt(3, perro.getborn_Year());
            declararPet.setString(4, perro.getColor());
            declararPet.setString(5, perro.getHealth_status());
            int insertarFilas = declararPet.executeUpdate();
            if(insertarFilas > 0){
                ResultSet generatedKeys = declararPet.getGeneratedKeys();
                if(generatedKeys.next()){
                    int idMascota = generatedKeys.getInt(1);
                    String consultaDog = "INSERT INTO tb_dog(raza, pedigree, id_pet) VALUES (?,?,?)";
                    PreparedStatement declararDog = conexionBD.prepareStatement(consultaDog);
                    declararDog.setString(1, perro.getBreed());
                    declararDog.setBoolean(2, perro.isPedigree());
                    declararDog.setInt(3, idMascota);
                    insertarFilas = declararDog.executeUpdate();
                    if(insertarFilas > 0){
                        return true;
                    }
                }
            }
            return true;
        }catch(SQLException error){
            System.out.println("Error en la conexion" + " " +error.getMessage());
            return false;
            }
    }
    

    public clsPet searchMascota(String codigo){
        clsDog perro = null;
        try(Connection conexionBD = DriverManager.getConnection(baseDatos.getUrl(), baseDatos.getUsuario(), baseDatos.getPassword())){
            String ConsultaBusqueda = "SELECT p.id, codigo, nombre, born_year, color, estado_salud, d.id, raza, pedigree FROM tb_pet as p INNER JOIN tb_dog as d on p.id = id_pet where p.codigo = ?";
            PreparedStatement declararPet = conexionBD.prepareStatement(ConsultaBusqueda);
            declararPet.setString(1, codigo);
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
                perro = new clsDog(dogId, dogRaza, dogPedigree, petCodigo, petNombre, petBornYear, petColor, petEstadoSalud, petId);
            }
            return perro;
        } catch(Exception error){
                return perro;
                }
    }

    public LinkedList<clsPet> ListMascota(){
        LinkedList<clsPet> listPerro = new LinkedList<>();
        try(Connection conexionBD = DriverManager.getConnection(baseDatos.getUrl(), baseDatos.getUsuario(), baseDatos.getPassword())){
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
                clsDog perro = new clsDog(dogId, dogRaza, dogPedigree, petCodigo, petNombre, petBornYear, petColor, petEstadoSalud, petId);
                listPerro.add(perro);
            }
            return listPerro;
        } catch(Exception error){
                System.out.println("Error en la conexion" + " " +error.getMessage());
                return listPerro;
                }
    }

    public LinkedList<clsReportePorEstadoSalud> ListMascotaEstadoSalud(){
        LinkedList<clsReportePorEstadoSalud> ReporteMascotas = new LinkedList<>();
        try(Connection conexionBD = DriverManager.getConnection(baseDatos.getUrl(), baseDatos.getUsuario(), baseDatos.getPassword())){
            String ConsultaBusqueda = "SELECT estado_salud, COUNT(estado_salud) from tb_pet GROUP BY estado_salud";
            PreparedStatement declararPet = conexionBD.prepareStatement(ConsultaBusqueda);
            ResultSet respuesta = declararPet.executeQuery();
            while(respuesta.next()){
                clsReportePorEstadoSalud reporte = new clsReportePorEstadoSalud();
                String nomEstado = respuesta.getString(1);
                int cantMascota = respuesta.getInt(2);
                reporte.setEstadoSalud(nomEstado);
                reporte.setCantidadMascotas(cantMascota);
                ReporteMascotas.add(reporte);
            }
            return ReporteMascotas;
        } catch(Exception error){
                System.out.println("Error en la conexion" + " " +error.getMessage());
                return ReporteMascotas;
                }
    }

    public boolean updateMascota(clsDog perro){
        try(Connection conexionBD = DriverManager.getConnection(baseDatos.getUrl(), baseDatos.getUsuario(), baseDatos.getPassword())){
            String consultaPet = "UPDATE tb_pet SET codigo = ?, nombre = ?, born_year = ?, color = ?, estado_salud = ? WHERE id = ?";
            PreparedStatement declararPet = conexionBD.prepareStatement(consultaPet);
            
            declararPet.setString(1, perro.getCode());
            declararPet.setString(2, perro.getName());
            declararPet.setInt(3, perro.getborn_Year());
            declararPet.setString(4, perro.getColor());
            declararPet.setString(5, perro.getHealth_status());
            declararPet.setInt(6, perro.getPetId());
            
            String consultaDog = "UPDATE tb_dog SET raza = ?, pedigree = ? WHERE id = ?";
            PreparedStatement declararDog = conexionBD.prepareStatement(consultaDog);
            declararDog.setString(1, perro.getBreed());
            declararDog.setBoolean(2, perro.isPedigree());
            declararDog.setInt(3, perro.getDogId());
            int ActualizarFilasPet = declararPet.executeUpdate();
            int ActualizarFilasDog = declararDog.executeUpdate();
            
            return ActualizarFilasPet > 0 && ActualizarFilasDog > 0;

        }catch(SQLException error){
            
            System.out.println("Error en la conexion" + " " + error.getMessage());
            return false;
            
            }

    }

    public boolean deleteMascota(clsDog perro){
        try{
            return true;
        }catch(Exception error){
            return false;
            }
    }
}
