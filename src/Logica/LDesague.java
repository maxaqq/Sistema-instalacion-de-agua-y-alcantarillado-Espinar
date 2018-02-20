/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Datos.DatosDesague;
import Interfaces.formulario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author maxni
 */
public class LDesague {
    private Conectar mysql = new Conectar();
    private Connection conectado = mysql.conexion();
    private String SQL = "";
    public Integer totalRegistros;
    
    public boolean guardar(DatosDesague dts){
        SQL = "insert into desague (id,num_autorizacion,proyecto,nombre,expediente,"
                + "reciboCaja,codigoCat,direccion,urbanizacion,dni,fecha,manzana,"
                + "lote,estado,tiempoVigencia)"
                + " VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        
        try {
            PreparedStatement pst = conectado.prepareStatement(SQL);
            
            pst.setInt(1, dts.getId());
            pst.setString(2, dts.getNum_autorizacion());
            pst.setString(3, dts.getProyecto());
            pst.setString(4, dts.getNombre());
            pst.setString(5, dts.getExpediente());
            pst.setString(6, dts.getReciboCaja());
            pst.setString(7, dts.getCodigoCat());
            pst.setString(8, dts.getDireccion());
            pst.setString(9, dts.getUrbanizacion());
            pst.setString(10, dts.getDni());
            pst.setDate(11, dts.getFecha());
            pst.setString(12, dts.getManzana());
            pst.setString(13, dts.getLote());
            pst.setString(14, dts.getEstado());
            pst.setString(15, dts.getTiempoVigencia());
            
            
            int n = pst.executeUpdate();
            if (n != 0) {
                System.out.println("Se guardo exitosamente los datos");
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            System.out.println("Nose pudo guardar los datos--- Lpersonas");
            e.printStackTrace();
            return false;
        }
    }
    
    public DefaultTableModel mostrarDesague(String buscar){
        DefaultTableModel modelo;
        String []titulo = {"Id","N°-Autorizacion", "Proyecto","Nombre","Expediente","Recibo en Caja","Codigo CAT","Dirección","Urbanización","DNI","Fecha","Manzana","Lote","Estado"};
        String []registro = new String[14];
        totalRegistros = 0;
        
        modelo = new DefaultTableModel(null, titulo);
        SQL = "select * from desague where dni LIKE'%"+buscar+"%' order by id";
        
        try {
            Statement st = conectado.createStatement();
            ResultSet rs = st.executeQuery(SQL);
            
            while (rs.next()) {
                registro[0] = rs.getString("id");
                registro[1] = rs.getString("num_autorizacion");
                registro[2] = rs.getString("proyecto");
                registro[3] = rs.getString("nombre");
                registro[4] = rs.getString("expediente");
                registro[5] = rs.getString("reciboCaja");
                registro[6] = rs.getString("codigoCat");
                registro[7] = rs.getString("direccion");
                registro[8] = rs.getString("urbanizacion");
                registro[9] = rs.getString("dni");
                registro[10] = rs.getDate("fecha") +"";
                registro[11] = rs.getString("manzana");
                registro[12] = rs.getString("lote");
                registro[13] = rs.getString("estado");
                totalRegistros++;
                modelo.addRow(registro);
            }
            return modelo;
        } catch (SQLException e) {
            System.out.println("Error en logica.Lpersonas.mostrarPersonas()");
            e.printStackTrace();
            return null;
        }
    }
    
    public boolean editar (DatosDesague dts){
       SQL = "update desague SET id=?, proyecto=?,nombre=?,"
               + "expediente=?,reciboCaja=?,codigoCat=?,direccion=?,"
               + "urbanizacion=?,dni=?,fecha=?,manzana=?,lote=?,estado=?, tiempoVigencia=?"
               + " where num_autorizacion=?"; 
        try {
            PreparedStatement pst = conectado.prepareStatement(SQL);
            
            pst.setInt(1, dts.getId());
            pst.setString(2, dts.getProyecto());
            pst.setString(3, dts.getNombre());
            pst.setString(4, dts.getExpediente());
            pst.setString(5, dts.getReciboCaja());
            pst.setString(6, dts.getCodigoCat());
            pst.setString(7, dts.getDireccion());
            pst.setString(8, dts.getUrbanizacion());
            pst.setString(9, dts.getDni());
            pst.setDate(10, dts.getFecha());
            pst.setString(11, dts.getManzana());
            pst.setString(12, dts.getLote());
            pst.setString(13, dts.getEstado());
            pst.setString(14, dts.getTiempoVigencia());
            pst.setString(15, dts.getNum_autorizacion());
            
            
            int n = pst.executeUpdate();
            if (n != 0) {
                System.out.println("Se edito exitosamente los datos");
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            System.out.println("No se pudo Editar los datos");
            e.printStackTrace();
            return false;
        }
    
    }
    
    public String numeroAutorizacion(){
        SQL = "select id from desague";
        
        try {
            Statement st = conectado.createStatement();
            ResultSet rs = st.executeQuery(SQL);
            int id,mayor=0;
            int longitud=0,C = 0,D=0;
            String num1 = "00000";
            String num2 ="";
            String A = "";
            while (rs.next()) {
                id = rs.getInt("id");
                
                if ( id > mayor) {
                    mayor = id;
                }
            }
            int numero = mayor+1;
            num2 = numero+"";
            int tamaño1 = num1.length();
            int tamaño2 = num2.length();
            String num3 = num1.substring(0, tamaño1-tamaño2);
            String num4 = num3+num2;
            
            return num4;
        } catch (SQLException e) {
            System.out.println("Error en logica.Lpersonas.numeroAutorizacion()");
            e.printStackTrace();
            return null;
        }
        
    }
    
    public boolean eliminar (DatosDesague dts){
        SQL = "delete from desague where num_autorizacion=?";
        
        try {
            PreparedStatement pst = conectado.prepareStatement(SQL);
            pst.setString(1, dts.getNum_autorizacion());
            int n = pst.executeUpdate();
            
            if (n!=0) {
                return true;
            }
            else{
                return false;
            }
        } catch (SQLException e) {
            System.out.println("Error logica.Lpersonas.eliminar() "+e);
            return false;
        }
    }
    
    public int ultimoId(){
        SQL = "select id from desague";
        
        try {
            Statement st = conectado.createStatement();
            ResultSet rs = st.executeQuery(SQL);
            int mayor = 0;
            while (rs.next()) {                
                int id = rs.getInt("id");
                
                if (id > mayor) {
                    mayor = id;
                }
            }
            int id2 = mayor+1;
            
            return id2;
        } catch (SQLException e) {
            System.out.println("Error en logica.Lpersonas.ultimoId()");
            e.printStackTrace();
            return 1;
        }
    }
}
