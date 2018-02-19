/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos.Scriptlet;

import Logica.Conectar;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import net.sf.jasperreports.engine.JRAbstractScriptlet;
import net.sf.jasperreports.engine.JRDefaultScriptlet;
import net.sf.jasperreports.engine.JRScriptletException;


    public class TiempoVigencia extends JRDefaultScriptlet {
    //..... aqui va todo el código de pasar un número a letras
    //este sera el metodo que llamaré desde el reporte
        Conectar mysql = new Conectar();
        Connection conectado = mysql.conexion();
        
    public String vigencia(int id) throws JRScriptletException{
         String SQL = "select fecha from alcantarillado where id = '"+id+"' "; 
         
         String formatoMes = "MM";
         String formatoAño = "yyyy";
         int vigencia = 0;
         int mes = 0;
         int año = 0;
         String month = "";
         String year = "";
         String mensaje = "";
         
         try {
            Statement st = conectado.createStatement();
            ResultSet rs = st.executeQuery(SQL);
            
             while (rs.next()) {                 
                 SimpleDateFormat dateMes = new SimpleDateFormat(formatoMes);
                 SimpleDateFormat dateAño = new SimpleDateFormat(formatoAño);

                  mes = Integer.parseInt(dateMes.format(rs.getDate("fecha")));
                  año = Integer.parseInt(dateAño.format(rs.getDate("fecha")));
                }
             switch(mes){
                case 1: month = "julio";
                         mensaje = "Vigente hasta "+month+" del "+ año; break;
                case 2: month = "agosto";
                         mensaje = "Vigente hasta "+month+" del "+ año; break;
                case 3: month = "setiembre";
                         mensaje = "Vigente hasta "+month+" del "+ año; break;
                case 4: month = "octubre";
                         mensaje = "Vigente hasta "+month+" del "+ año; break;
                case 5: month = "noviembre";
                         mensaje = "Vigente hasta "+month+" del "+ año; break;
                case 6: month = "diciembre";
                        año++;
                         mensaje = "Vigente hasta "+month+" del "+ año; break;
                case 7: month = "enero";
                        año++;
                         mensaje = "Vigente hasta "+month+" del "+ año; break;
                case 8: month = "febrero";
                        año++;
                         mensaje = "Vigente hasta "+month+" del "+ año; break;
                case 9: month = "marzo";
                        año++;
                         mensaje = "Vigente hasta "+month+" del "+ año; break;
                case 10: month = "abril";
                        año++;
                         mensaje = "Vigente hasta "+month+" del "+ año; break;
                case 11: month = "mayo";
                        año++;
                         mensaje = "Vigente hasta "+month+" del "+ año; break;
                case 12: month = "junio";
                        año++;
                         mensaje = "Vigente hasta "+month+" del "+ año; break;
             }
            
        } catch (NumberFormatException | SQLException e) {
             System.out.println("Ocurrio un Error en la clase Datos.Scriptlet.Scriptlet_Vigencia.TiempoVigencia.vigencia()");
             e.printStackTrace();
        }
        
        return mensaje;
     }
}

