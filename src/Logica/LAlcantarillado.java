/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Datos.DatosAlcantarillado;


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
public class LAlcantarillado {
    private Conectar mysql = new Conectar();
    private Connection conectado = mysql.conexion();
    private String SQL = "";
    public Integer totalRegistros;
    
    public boolean guardar(DatosAlcantarillado dts){
        SQL = "insert into alcantarillado (id,num_autorizacion,proyecto,nombre,expediente,"
                + "reciboCaja,codigoCat,direccion,urbanizacion,dni,fecha,manzana,"
                + "lote,estado, veces_de_instalacion,tiempoVigencia) "
                + "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        
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
            pst.setString(15, dts.getVecesInstalacion());
            pst.setString(16, dts.getTiempoVigencia());
            
            int n = pst.executeUpdate();
            if (n != 0) {
                System.out.println("Se guardo exitosamente los datos de instalacion de agua y alcantarillado");
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            System.out.println("Nose pudo guardar los datos--- LAlcantarillado");
            e.printStackTrace();
            return false;
        }
    }
    
    public DefaultTableModel mostrarAlcantarillado(String buscar){
        DefaultTableModel modelo;
        String []titulo = {"Id","N°-Autorizacion", "Proyecto","Nombre","Expediente","Recibo en Caja","Codigo CAT","Dirección","Urbanización","DNI","Fecha","Manzana","Lote","Estado","Veces"};
        String []registro = new String[15];
        totalRegistros = 0;
        
        modelo = new DefaultTableModel(null, titulo);
        SQL = "select * from alcantarillado where dni LIKE'%"+buscar+"%' order by id";
        
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
                registro[14] = rs.getString("veces_de_instalacion");
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
    
    public boolean editar (DatosAlcantarillado dts){
       SQL = "update alcantarillado SET id=?, proyecto=?,nombre=?,"
               + "expediente=?,reciboCaja=?,codigoCat=?,direccion=?,"
               + "urbanizacion=?,dni=?,fecha=?,manzana=?,lote=?,estado=?, "
               + "veces_de_instalacion=?, tiempoVigencia=?"
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
            pst.setString(14, dts.getVecesInstalacion());
            pst.setString(15, dts.getTiempoVigencia());
            pst.setString(16, dts.getNum_autorizacion());
            
            
            int n = pst.executeUpdate();
            if (n != 0) {
                System.out.println("Se edito exitosamente los datos");
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            System.out.println("No se puso Editar los datos");
            e.printStackTrace();
            return false;
        }
    
    }
    
    public String numeroAutorizacion(){
        SQL = "select id from alcantarillado";
        
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
    
    public DefaultTableModel mostrarTipo(String tipo){
    DefaultTableModel modelo;
    String []titulo = {"id","N°-Autorizacion","tipo", "Proyecto","Nombre","Expediente","Recibo en Caja","Codigo CAT","Dirección","Urbanización","DNI","Fecha","Manzana","Lote","Estado"};
    String []registro = new String[15];
    totalRegistros = 0;

    modelo = new DefaultTableModel(null, titulo);
    SQL = "select * from alcantarillado where tipo ='"+tipo+"' ";

    try {
        Statement st = conectado.createStatement();
        ResultSet rs = st.executeQuery(SQL);

            while (rs.next()) {
                registro[0] = rs.getInt("id")+"";
                registro[1] = rs.getString("num_autorizacion");
                registro[2] = rs.getString("tipo");
                registro[3] = rs.getString("proyecto");
                registro[4] = rs.getString("nombre");
                registro[5] = rs.getString("expediente");
                registro[6] = rs.getString("reciboCaja");
                registro[7] = rs.getString("codigoCat");
                registro[8] = rs.getString("direccion");
                registro[9] = rs.getString("urbanizacion");
                registro[10] = rs.getString("dni");
                registro[11] = rs.getDate("fecha") +"";
                registro[12] = rs.getString("manzana");
                registro[13] = rs.getString("lote");
                registro[14] = rs.getString("estado");
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
        
    public boolean eliminar (DatosAlcantarillado dts){
        SQL = "delete from alcantarillado where num_autorizacion=?";
        
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
        SQL = "select id from alcantarillado";
        
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
    
    public String cantidadInstalaciones(String codigoCat){
        SQL = "select codigoCat from alcantarillado where codigoCat = '"+codigoCat+"' ";
        int cantidad = 0;
        String codigo = "";
        String veces = "";
        try {
            Statement st = conectado.createStatement();
            ResultSet rs = st.executeQuery(SQL);
            
            while (rs.next()) {                
                codigo = rs.getString("codigoCat");
                cantidad++;
            }
            
            switch(cantidad){
                case 1: veces = "PRIMERA"; break;
                case 2: veces = "SEGUNDA"; break;
                case 3: veces = "TERCERA"; break;
                case 4: veces = "CUARTA"; break;
                case 5: veces = "QUINTA"; break;
                case 6: veces = "SEXTA"; break;
                case 7: veces = "SEPTIMA"; break;
                case 8: veces = "OCTAVA"; break;
                case 9: veces = "NOVENA"; break;
                case 10: veces = "DÉCIMA"; break;
                case 11: veces = "ONCEABA"; break;
                default: System.out.println("No se ha encontrado ninguna repetición ");
                        veces = "NINGUNA";  
            }
            
            return veces;
          
        } catch (SQLException e) {
            System.out.println(" ERROR EN CLASE Logica.LAlcantarillado.cantidadInstalaciones()");
            e.printStackTrace();
            return null;
        }
    }
    
    public DefaultTableModel buscarCodigoCat(String buscar){
        DefaultTableModel modelo;
        String []titulo = {"Id","N°-Autorizacion", "Proyecto","Nombre","Expediente","Recibo en Caja","Codigo CAT","Dirección","Urbanización","DNI","Fecha","Manzana","Lote","Estado","Veces"};
        String []registro = new String[15];
        totalRegistros = 0;
        
        modelo = new DefaultTableModel(null, titulo);
        SQL = "select * from alcantarillado where codigoCat LIKE'%"+buscar+"%' order by id";
        
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
                registro[14] = rs.getString("veces_de_instalacion");
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
}
