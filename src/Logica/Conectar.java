/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author maxni
 */
public class Conectar {
      Connection conect = null;
    String adress = "localhost";
    String dataBaseName = "sistemamuni";
    String user = "root";
    String password = "";
    public Connection conexion()
    {
        try {
           Class.forName("com.mysql.jdbc.Driver");
           conect = DriverManager.getConnection("jdbc:mysql://"+adress+"/"+dataBaseName,user,password);
           System.out.println("Conexion Establesida");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error en establecer la conexion con la base de datos");
            e.printStackTrace();
        }
        return conect;
    }
}
