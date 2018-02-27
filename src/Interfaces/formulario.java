
package Interfaces;


import Datos.DatosAlcantarillado;
import Datos.DatosDesague;
//import Logica.AutoSuggestor;


import java.sql.Date;

import java.util.Calendar;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableModel;
import Logica.LDesague;

import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;
import javax.swing.table.TableColumnModel;
import Logica.Conectar;
import Logica.LAlcantarillado;
import com.mxrck.autocompleter.TextAutoCompleter;
import javax.swing.DefaultComboBoxModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



/**
 *
 * @author maxni
 */
public class formulario extends javax.swing.JFrame {

    LDesague logica = new LDesague();
    
    LAlcantarillado logica2 = new LAlcantarillado();
    DatosAlcantarillado dts2 = new DatosAlcantarillado();
    DatosDesague dts = new DatosDesague();
    Conectar conectando = new Conectar();
   
    
    
    public formulario() {
        initComponents();
        this.setLocationRelativeTo(null);
        itemsUrbanizacion();
        mostrarDesague("");
        jComboFiltrarTipo.setSelectedIndex(1);
        AutoCompleteDecorator.decorate(jComboUrbanizacion);
        rellenarCodigoCat();
        System.out.println("Usted ingresó al sistema exitosamente! :)");
        jButtonEditar.setEnabled(false);
        jButtonEliminar.setEnabled(false);
        jButtonImprimir.setEnabled(false);
        jButtonAgregar.setEnabled(true);
       // jTextFieldAutocomplete.
        jLabelNumAutorizacion.setText(logica.numeroAutorizacion());
        ocultarColumna();
        jLabelID.setText(logica.ultimoId()+"");
        tamañoColumnas();
    }
    
    public void ocultarColumna(){
        jTableDatos.getColumnModel().getColumn(0).setMaxWidth(0);
        jTableDatos.getColumnModel().getColumn(0).setMinWidth(0);
        jTableDatos.getColumnModel().getColumn(0).setPreferredWidth(0);
    }
    public void tamañoColumnas(){
        TableColumnModel columnModel = jTableDatos.getColumnModel();
            columnModel.getColumn(1).setPreferredWidth(15);
            columnModel.getColumn(2).setPreferredWidth(250);
    }
    
    public void rellenarCodigoCat(){
        String SQL = "select codigoCat from alcantarillado";
                Connection conectado = conectando.conexion();
        DefaultComboBoxModel combo = new DefaultComboBoxModel();
        TextAutoCompleter complete = new TextAutoCompleter(jTextCodigoCat);
        try {
            Statement st = conectado.createStatement();
            ResultSet rs = st.executeQuery(SQL);
            
            while (rs.next()) {                
              complete.addItem(rs.getString("codigoCat"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void itemsUrbanizacion(){
        jComboUrbanizacion.addItem("Urbanizaciones");
        jComboUrbanizacion.addItem("ANTAPAMPA II");
        jComboUrbanizacion.addItem("APV. SIMON BOLIVAR");
        jComboUrbanizacion.addItem("APV. HEROES DE CENEPA");
        jComboUrbanizacion.addItem("APV. LOS GIRASOLES");
        jComboUrbanizacion.addItem("APV. MARISCAL ANDRES AVELINO CACERES");
        jComboUrbanizacion.addItem("APV. RESID. ALTO PICHIGUANOS");
        jComboUrbanizacion.addItem("APV. SOCIEDAD DE TIRO N° 21 YAURI-ESPINAR");
        jComboUrbanizacion.addItem("APV. SOL NACIENTE HUARCA");
        jComboUrbanizacion.addItem("APV. TECHO DE COBRE");
        jComboUrbanizacion.addItem("APV. TRES DE MAYO");
        jComboUrbanizacion.addItem("AREA PARTICULAR");
        jComboUrbanizacion.addItem("ASOC. DE VIV. ACCOYANI HUARCA");
        jComboUrbanizacion.addItem("ASOC. DE MADEREROS NUEVA ESPERANZA");
        jComboUrbanizacion.addItem("ASOC. DE VIV. JUAN DE VELAZCO ALVARADO");
        jComboUrbanizacion.addItem("ASOC. DE VIV. LA UNIÓN");
        jComboUrbanizacion.addItem("ASOC. DE VIV. LICENCIADOS");
        jComboUrbanizacion.addItem("ASOC. DE VIV. MAGISTERIAL");
        jComboUrbanizacion.addItem("ASOC. DE VIV. PARQUESITO INDUSTRIAL");
        jComboUrbanizacion.addItem("ASOC. DE VIV. RESID. PICHIGUANOS");
        jComboUrbanizacion.addItem("ASOC. DE VIV. SAN MARTIN");
        jComboUrbanizacion.addItem("ASOC. DE VIV. SANTA FE DE ESPINAR");
        jComboUrbanizacion.addItem("ASOC. DE VIV. SECTOR AGRARIO");
        jComboUrbanizacion.addItem("ASOC DE VIVIENDA LOS LIDERES");
        jComboUrbanizacion.addItem("ASOC. DE VIV. CONSTRUCCION CIVIL");
        jComboUrbanizacion.addItem("ASOC. DE VIVIENDA LOS LIDERES");
        jComboUrbanizacion.addItem("ASOC. DE VIVIENDA TINTAYA MARQUIRI");
        jComboUrbanizacion.addItem("ASOC. PP.JJ. BELEN");
        jComboUrbanizacion.addItem("ASOC PRO-VIV. TUPAC AMARU");
        jComboUrbanizacion.addItem("ASOC. PRO-VIVIENDA CESAR VALLEJO");
        jComboUrbanizacion.addItem("ASOC. SANTA INES(LITIGIO)");
        jComboUrbanizacion.addItem("ASOCIACION DE VIV. VELLECITO");
        jComboUrbanizacion.addItem("ASOCIACION PARQUE AUTOMOTOR");
        jComboUrbanizacion.addItem("BARRIO OBRERO");
        jComboUrbanizacion.addItem("BARRIO PROGRESO");
        jComboUrbanizacion.addItem("BARRIO SUERO CANTO");
        jComboUrbanizacion.addItem("BARRIO UNIDAD VECINAL");
        jComboUrbanizacion.addItem("C.P.HUARCACANTO");
        jComboUrbanizacion.addItem("C.P.VICTOR RAUL");
        jComboUrbanizacion.addItem("CCACCAHUASI (JKM-AGUILAR)");
        jComboUrbanizacion.addItem("COM. HUARCA TEMP.");
        jComboUrbanizacion.addItem("HABILITACION URB. DANIEL PONCE OLARTE");
        jComboUrbanizacion.addItem("PP.JJ.BOLOGNESI");
        jComboUrbanizacion.addItem("PP.JJ.PACHACUTEC");
        jComboUrbanizacion.addItem("PP.JJ.ANTAPAMPA");
        jComboUrbanizacion.addItem("PP.JJ.ATALAYA HUARCA");
        jComboUrbanizacion.addItem("PP.JJ. LA AMISTAD HUISA CCOLLANA");
        jComboUrbanizacion.addItem("PP.JJ.MIRAFLORES");
        jComboUrbanizacion.addItem("PP.JJ.PACIFICO");
        jComboUrbanizacion.addItem("PP.JJ.SANTA ROSA");
        jComboUrbanizacion.addItem("PP.JJ.SECTOR TAJO");
        jComboUrbanizacion.addItem("PP.JJ.VILLA TAJO");
        jComboUrbanizacion.addItem("PP.JJ.VILLA VERSALLES");
        jComboUrbanizacion.addItem("SECTOR INDUSTRIAL");
        jComboUrbanizacion.addItem("SECTOR CERCANO");
        jComboUrbanizacion.addItem("SECTOR LA LIBERTAD");
        jComboUrbanizacion.addItem("SECTOR SAN FRANCISCO");
        jComboUrbanizacion.addItem("SECTOR VISTA ALEGRE");
        jComboUrbanizacion.addItem("URB. CORONEL LADISLADO ESPINAR");
        jComboUrbanizacion.addItem("URB. LA VICTORIA");
        jComboUrbanizacion.addItem("URB. MOLLOPUCJIO");
        jComboUrbanizacion.addItem("URB. RES. SAN SEBASTIAN - ESPINAR");
        jComboUrbanizacion.addItem("URB. SAN COSME");
        jComboUrbanizacion.addItem("URB. SANTA ROSA III ETAPA");
        jComboUrbanizacion.addItem("URB. VILLA ALTO HUARCA ZONA SUR");
        jComboUrbanizacion.addItem("URB. VILLA ALTO HUARCA ZONA NORTE");
        jComboUrbanizacion.addItem("URBANIZACION EL PORVENIR");
        jComboUrbanizacion.addItem("URBANIZACION PARAISO");
        jComboUrbanizacion.addItem("URBANIZACION SAN LUCAS");
        jComboUrbanizacion.addItem("VIRGEN DEL CARMEN");
        jComboUrbanizacion.addItem("ZONA DE EXPANCION URBANA");
        
        
    }
    
    public  Date parseFecha(String fecha){
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        Date fechaDate = null;
        try {
            fechaDate = (Date)formato.parse(fecha);
        } catch (ParseException e) {
            System.out.println(e);
        }
        return fechaDate;
    }
    
    public void agregarDatosDesague(){
        try {
            
            dts.setId(logica.ultimoId());
            dts.setNum_autorizacion(logica.numeroAutorizacion());
            dts.setProyecto(jComboProyecto.getSelectedItem().toString());
            dts.setNombre(jTextNombre.getText().toUpperCase());
            dts.setExpediente(jTextExpediente.getText().toUpperCase());
            dts.setReciboCaja(jTextReciboCaja.getText());
            dts.setCodigoCat(jTextCodigoCat.getText());
            dts.setDireccion(jTextDireccion.getText().toUpperCase());
            dts.setUrbanizacion(jComboUrbanizacion.getSelectedItem().toString().toUpperCase());
            dts.setDni(jTextDNI.getText());

            Calendar cal;
            int day,month,year;
            cal = jDateFecha.getCalendar();
            day = cal.get(Calendar.DAY_OF_MONTH);
            month = cal.get(Calendar.MONTH);
            year = cal.get(Calendar.YEAR)-1900;

            dts.setFecha(new Date(year,month,day));
            dts.setManzana(jTextManzana.getText().toUpperCase());
            dts.setLote(jTextLote.getText().toUpperCase());
            dts.setEstado(jComboEstado.getSelectedItem().toString());
            dts.setTiempoVigencia(tiempoVigencia().toUpperCase());
            
            if (logica.guardar(dts)) {
                JOptionPane.showMessageDialog(null, "Se guardo exitosamente");
                mostrarDesague("");
                jComboFiltrarTipo.setSelectedIndex(1);
                jButtonAgregar.setEnabled(false);
            } else {
                JOptionPane.showMessageDialog(null, "Nose pudo guardar los datos");
            }
        } catch (NumberFormatException e) {
            System.out.println(" ERROR en el Interfaces.formulario.agregarDatos()");
            e.printStackTrace();
        }
        
    }
    
    public void agregarDatosAlcantarillado(){
        int rpt;
            
        
        try {
            
            switch(logica2.cantidadInstalaciones(jTextCodigoCat.getText())){
                case "PRIMERA": rpt = JOptionPane.showConfirmDialog(null, "Esta persona ya esta registrado por PRIMERA VEZ \n"
                        + " ¿ Desea continuar con la operación por SEGUNDA VEZ ?","CONFIRMACIÓN",JOptionPane.YES_NO_OPTION);
                    if (rpt == JOptionPane.YES_OPTION) {
                        
                        dts2.setId(logica2.ultimoId());
                        dts2.setNum_autorizacion(logica2.numeroAutorizacion());
                        dts2.setProyecto(jComboProyecto.getSelectedItem().toString());
                        dts2.setNombre(jTextNombre.getText().toUpperCase());
                        dts2.setExpediente(jTextExpediente.getText().toUpperCase());
                        dts2.setReciboCaja(jTextReciboCaja.getText());
                        dts2.setCodigoCat(jTextCodigoCat.getText());
                        dts2.setDireccion(jTextDireccion.getText().toUpperCase());
                        dts2.setUrbanizacion(jComboUrbanizacion.getSelectedItem().toString().toUpperCase());
                        dts2.setDni(jTextDNI.getText());

                        Calendar cal;
                        int day,month,year;

                        cal = jDateFecha.getCalendar();
                        day = cal.get(Calendar.DAY_OF_MONTH);
                        month = cal.get(Calendar.MONTH);
                        year = cal.get(Calendar.YEAR)-1900;

                        dts2.setFecha((java.sql.Date) new Date(year,month,day));
                        dts2.setManzana(jTextManzana.getText());
                        dts2.setLote(jTextLote.getText());
                        dts2.setEstado(jComboEstado.getSelectedItem().toString());
                        dts2.setVecesInstalacion("SEGUNDA");
                        dts2.setTiempoVigencia(tiempoVigencia().toUpperCase());
                        
                        jLabelNumAutorizacion.setText(logica2.numeroAutorizacion());
                        ocultarColumna();
                        jLabelID.setText(logica2.ultimoId()+"");

                        if (logica2.guardar(dts2)) {
                            JOptionPane.showMessageDialog(null, "Se guardo exitosamente");
                            mostrarAlcantarillado("");
                            jButtonAgregar.setEnabled(false);
                            jComboFiltrarTipo.setSelectedIndex(2);
                        } else {
                            JOptionPane.showMessageDialog(null, "Nose pudo guardar los datos");
                        }
                        
                    } else {
                        System.out.println("Operación cancelada");
                    } break;
                    
                case "SEGUNDA": rpt = JOptionPane.showConfirmDialog(null, "Esta persona ya esta registrado por SEGUNDA VEZ \n"
                        + " ¿ Desea continuar con la operación por TERCERA VEZ ?","CONFIRMACIÓN",JOptionPane.YES_NO_OPTION);
                    if (rpt == JOptionPane.YES_OPTION) {
                        
                        dts2.setId(logica2.ultimoId());
                        dts2.setNum_autorizacion(logica2.numeroAutorizacion());
                        dts2.setProyecto(jComboProyecto.getSelectedItem().toString());
                        dts2.setNombre(jTextNombre.getText().toUpperCase());
                        dts2.setExpediente(jTextExpediente.getText().toUpperCase());
                        dts2.setReciboCaja(jTextReciboCaja.getText());
                        dts2.setCodigoCat(jTextCodigoCat.getText());
                        dts2.setDireccion(jTextDireccion.getText().toUpperCase());
                        dts2.setUrbanizacion(jComboUrbanizacion.getSelectedItem().toString().toUpperCase());
                        dts2.setDni(jTextDNI.getText());

                        Calendar cal;
                        int day,month,year;

                        cal = jDateFecha.getCalendar();
                        day = cal.get(Calendar.DAY_OF_MONTH);
                        month = cal.get(Calendar.MONTH);
                        year = cal.get(Calendar.YEAR)-1900;

                        dts2.setFecha((java.sql.Date) new Date(year,month,day));
                        dts2.setManzana(jTextManzana.getText());
                        dts2.setLote(jTextLote.getText());
                        dts2.setEstado(jComboEstado.getSelectedItem().toString());
                        dts2.setVecesInstalacion("TERCERA");
                        dts2.setTiempoVigencia(tiempoVigencia().toUpperCase());

                        jLabelNumAutorizacion.setText(logica2.numeroAutorizacion());
                        ocultarColumna();
                        jLabelID.setText(logica2.ultimoId()+"");

                        if (logica2.guardar(dts2)) {
                            JOptionPane.showMessageDialog(null, "Se guardo exitosamente");
                            mostrarAlcantarillado("");
                            jComboFiltrarTipo.setSelectedIndex(2);
                            jButtonAgregar.setEnabled(false);
                        } else {
                            JOptionPane.showMessageDialog(null, "Nose pudo guardar los datos");
                        }
                        
                    } else {
                        System.out.println("Operación cancelada");
                    } break;
                    
                case "TERCERA": rpt = JOptionPane.showConfirmDialog(null, "Esta persona ya esta registrado por TERCERA VEZ \n"
                        + " ¿ Desea continuar con la operación por CUARTA VEZ ?","CONFIRMACIÓN",JOptionPane.YES_NO_OPTION);
                    if (rpt == JOptionPane.YES_OPTION) {
                        
                        dts2.setId(logica2.ultimoId());
                        dts2.setNum_autorizacion(logica2.numeroAutorizacion());
                        dts2.setProyecto(jComboProyecto.getSelectedItem().toString());
                        dts2.setNombre(jTextNombre.getText().toUpperCase());
                        dts2.setExpediente(jTextExpediente.getText().toUpperCase());
                        dts2.setReciboCaja(jTextReciboCaja.getText());
                        dts2.setCodigoCat(jTextCodigoCat.getText());
                        dts2.setDireccion(jTextDireccion.getText().toUpperCase());
                        dts2.setUrbanizacion(jComboUrbanizacion.getSelectedItem().toString().toUpperCase());
                        dts2.setDni(jTextDNI.getText());
                     
                        Calendar cal;
                        int day,month,year;

                        cal = jDateFecha.getCalendar();
                        day = cal.get(Calendar.DAY_OF_MONTH);
                        month = cal.get(Calendar.MONTH);
                        year = cal.get(Calendar.YEAR)-1900;

                        dts2.setFecha((java.sql.Date) new Date(year,month,day));
                        dts2.setManzana(jTextManzana.getText());
                        dts2.setLote(jTextLote.getText());
                        dts2.setEstado(jComboEstado.getSelectedItem().toString());
                        dts2.setVecesInstalacion("CUARTA");
                        dts2.setTiempoVigencia(tiempoVigencia().toUpperCase());

                        jLabelNumAutorizacion.setText(logica2.numeroAutorizacion());
                        ocultarColumna();
                        jLabelID.setText(logica2.ultimoId()+"");

                        if (logica2.guardar(dts2)) {
                            JOptionPane.showMessageDialog(null, "Se guardo exitosamente");
                            mostrarAlcantarillado("");
                            jComboFiltrarTipo.setSelectedIndex(2);
                            jButtonAgregar.setEnabled(false);
                        } else {
                            JOptionPane.showMessageDialog(null, "Nose pudo guardar los datos");
                        }
                        
                    } else {
                        System.out.println("Operación cancelada");
                    } break;
                    
                case "NINGUNA":
                    
                        dts2.setId(logica2.ultimoId());
                        dts2.setNum_autorizacion(logica2.numeroAutorizacion());
                        dts2.setProyecto(jComboProyecto.getSelectedItem().toString());
                        dts2.setNombre(jTextNombre.getText().toUpperCase());
                        dts2.setExpediente(jTextExpediente.getText().toUpperCase());
                        dts2.setReciboCaja(jTextReciboCaja.getText());
                        dts2.setCodigoCat(jTextCodigoCat.getText());
                        dts2.setDireccion(jTextDireccion.getText().toUpperCase());
                        dts2.setUrbanizacion(jComboUrbanizacion.getSelectedItem().toString().toUpperCase());
                        dts2.setDni(jTextDNI.getText());

                        Calendar cal;
                        int day,month,year;

                        cal = jDateFecha.getCalendar();
                        day = cal.get(Calendar.DAY_OF_MONTH);
                        month = cal.get(Calendar.MONTH);
                        year = cal.get(Calendar.YEAR)-1900;

                        dts2.setFecha((java.sql.Date) new Date(year,month,day));
                        dts2.setManzana(jTextManzana.getText());
                        dts2.setLote(jTextLote.getText());
                        dts2.setEstado(jComboEstado.getSelectedItem().toString());
                        dts2.setVecesInstalacion("PRIMERA");
                        dts2.setTiempoVigencia(tiempoVigencia().toUpperCase());

                        jLabelNumAutorizacion.setText(logica2.numeroAutorizacion());
                        ocultarColumna();
                        jLabelID.setText(logica2.ultimoId()+"");

                        if (logica2.guardar(dts2)) {
                            JOptionPane.showMessageDialog(null, "Se guardo exitosamente");
                            mostrarAlcantarillado("");
                            jComboFiltrarTipo.setSelectedIndex(2);
                            jButtonAgregar.setEnabled(false);
                        } else {
                            JOptionPane.showMessageDialog(null, "Nose pudo guardar los datos");
                        } break;
                    default: System.out.println("No se encontro  un String para el Switch para agregar "
                            + "datos de la clase LAlcantarillado y el Metodo => cantidadInstalaciones");
                 
            }
            
            
        } catch (NumberFormatException e) {
            System.out.println(" ERROR en el Interfaces.formulario.agregarDatos()");
            e.printStackTrace();
        }
    }
    
    public void editarDesague(){
        
            dts.setId(Integer.parseInt(jLabelID.getText()));
            dts.setNum_autorizacion(jLabelNumAutorizacion.getText());
            dts.setProyecto(jComboProyecto.getSelectedItem().toString());
            dts.setNombre(jTextNombre.getText().toUpperCase());
            dts.setExpediente(jTextExpediente.getText().toUpperCase());
            dts.setReciboCaja(jTextReciboCaja.getText());
            dts.setCodigoCat(jTextCodigoCat.getText());
            dts.setDireccion(jTextDireccion.getText().toUpperCase());
            dts.setUrbanizacion(jComboUrbanizacion.getSelectedItem().toString());
            dts.setDni(jTextDNI.getText());

            Calendar cal;
            int day,month,year;
            cal = jDateFecha.getCalendar();
            day = cal.get(Calendar.DAY_OF_MONTH);
            month = cal.get(Calendar.MONTH);
            year = cal.get(Calendar.YEAR)-1900;

            dts.setFecha(new Date(year,month,day));
            dts.setManzana(jTextManzana.getText().toUpperCase());
            dts.setLote(jTextLote.getText().toUpperCase());
            dts.setEstado(jComboEstado.getSelectedItem().toString());
            dts.setTiempoVigencia(tiempoVigencia().toUpperCase());
            
       
            if (logica.editar(dts)) {
                JOptionPane.showMessageDialog(null, "Se edito exitosamente los cambios del Sr(a) "
                        +jTextNombre.getText());
                mostrarDesague("");
                ocultarColumna();
                jComboFiltrarTipo.setSelectedIndex(1);
                limpiar();
                jButtonEditar.setEnabled(false);
                jButtonEliminar.setEnabled(false);
                jButtonImprimir.setEnabled(false);
                jButtonAgregar.setEnabled(true);

            }else{
                System.out.println("No se puede editar"); 
                JOptionPane.showMessageDialog(null, "No se puede Editar a la opción Alcantarillado");
            }
    }
    
    public void editarAlcantarillado(){
        
            dts2.setId(Integer.parseInt(jLabelID.getText()));
            dts2.setNum_autorizacion(jLabelNumAutorizacion.getText());
            dts2.setProyecto(jComboProyecto.getSelectedItem().toString());
            dts2.setNombre(jTextNombre.getText().toUpperCase());
            dts2.setExpediente(jTextExpediente.getText().toUpperCase());
            dts2.setReciboCaja(jTextReciboCaja.getText());
            dts2.setCodigoCat(jTextCodigoCat.getText());
            dts2.setDireccion(jTextDireccion.getText().toUpperCase());
            dts2.setUrbanizacion(jComboUrbanizacion.getSelectedItem().toString());
            dts2.setDni(jTextDNI.getText());

                Calendar cal;
                int day,month,year;
                cal = jDateFecha.getCalendar();
                day = cal.get(Calendar.DAY_OF_MONTH);
                month = cal.get(Calendar.MONTH);
                year = cal.get(Calendar.YEAR)-1900;

            dts2.setFecha(new Date(year,month,day));
            dts2.setManzana(jTextManzana.getText().toUpperCase());
            dts2.setLote(jTextLote.getText().toUpperCase());
            dts2.setEstado(jComboEstado.getSelectedItem().toString());
            dts2.setVecesInstalacion(logica2.cantidadInstalaciones(jTextCodigoCat.getText()));
            dts2.setTiempoVigencia(tiempoVigencia().toUpperCase());
            
       
            if (logica2.editar(dts2)) {
            JOptionPane.showMessageDialog(null, "Se edito exitosamente los cambios del Sr(a) "
                    +jTextNombre.getText());
                mostrarAlcantarillado("");
                ocultarColumna();
                jComboFiltrarTipo.setSelectedIndex(2);
                limpiar();
                jButtonEditar.setEnabled(false);
                jButtonEliminar.setEnabled(false);
                jButtonImprimir.setEnabled(false);
                jButtonAgregar.setEnabled(true);

            }else{
                System.out.println("No se pudo editar");   
            }
    }
    public void mostrarDesague(String buscar){
        try {
            DefaultTableModel modelo;
            
            modelo = logica.mostrarDesague(buscar);
            
            jLabelNumAutorizacion.setText(logica.numeroAutorizacion());
            
            jTableDatos.setModel(modelo);
            jLabelTotalRegistrados.setText("Total Autorizaciones:"+ Integer.toString(logica.totalRegistros));
        }catch (NumberFormatException e) {
            System.out.println(e);
        }
    }
    
    public void mostrarAlcantarillado(String buscar){
        try {
            DefaultTableModel modelo;
            
            modelo = logica2.mostrarAlcantarillado(buscar);
            
            jLabelNumAutorizacion.setText(logica2.numeroAutorizacion());
            jLabelID.setText(logica2.ultimoId()+"");
            
            jTableDatos.setModel(modelo);
            jLabelTotalRegistrados.setText("Total Autorizaciones:"+ Integer.toString(logica2.totalRegistros));
        }catch (NumberFormatException e) {
            System.out.println(e);
        }
    }
    
    public void mostrarCodigoCatAlcantarillado(String buscar){
        try {
            DefaultTableModel modelo;
            
            modelo = logica2.buscarCodigoCat(buscar);
            
            jLabelNumAutorizacion.setText(logica2.numeroAutorizacion());
            jLabelID.setText(logica2.ultimoId()+"");
            
            jTableDatos.setModel(modelo);
            jLabelTotalRegistrados.setText("Total Autorizaciones:"+ Integer.toString(logica2.totalRegistros));
        }catch (NumberFormatException e) {
            System.out.println(e);
        }
    }
    
   
    public void limpiar(){
        
        if (jTableDatos.getValueAt(0, 0).toString().equals("INSTALACION DE DESAGUE")) {
            jLabelNumAutorizacion.setText(logica.numeroAutorizacion());
            jLabelID.setText(logica.ultimoId()+"");
            jTextNombre.setText("");
            jTextExpediente.setText("");
            jTextReciboCaja.setText("");
            jTextCodigoCat.setText("");
            jTextDireccion.setText("");
            jComboUrbanizacion.setSelectedIndex(0);
            jComboProyecto.setSelectedIndex(0);
            jTextDNI.setText("");
            jDateFecha.setDate(null);
            jTextManzana.setText("");
            jTextLote.setText("");
            jComboEstado.setSelectedIndex(0);
            jComboFiltrarTipo.setSelectedIndex(1);
            jLabelVecesInstalacion.setText("");
        } else {
            jLabelNumAutorizacion.setText(logica2.numeroAutorizacion());
            jLabelID.setText(logica2.ultimoId()+"");
            jTextNombre.setText("");
            jTextExpediente.setText("");
            jTextReciboCaja.setText("");
            jTextCodigoCat.setText("");
            jTextDireccion.setText("");
            jComboUrbanizacion.setSelectedIndex(0);
            jComboProyecto.setSelectedIndex(0);
            jTextDNI.setText("");
            jDateFecha.setDate(null);
            jTextManzana.setText("");
            jTextLote.setText("");
            jComboEstado.setSelectedIndex(0);
            jComboFiltrarTipo.setSelectedIndex(2);
            jLabelVecesInstalacion.setText("");
        }
        
        
    }
    
    public String tiempoVigencia(){
        Calendar calendario;
        
        int año = 0;
        String month = "";
        int mes =0;
        String mensaje = "";

        calendario = jDateFecha.getCalendar();
        mes = calendario.get(Calendar.MONTH);
        año = calendario.get(Calendar.YEAR);
        
        switch(mes+1){
                case 1: month = "junio";
                         mensaje = "Autorización Vigente hasta "+month+" del "+ año; break;
                case 2: month = "julio";
                         mensaje = "Autorización Vigente hasta "+month+" del "+ año; break;
                case 3: month = "agosto";
                         mensaje = "Autorización Vigente hasta "+month+" del "+ año; break;
                case 4: month = "setiembre";
                         mensaje = "Autorización Vigente hasta "+month+" del "+ año; break;
                case 5: month = "octubre";
                         mensaje = "Autorización Vigente hasta "+month+" del "+ año; break;
                case 06: month = "noviembre";
                         mensaje = "Autorización Vigente hasta "+month+" del "+ año; break;
                case 07: month = "diciembre";
                         mensaje = "Autorización Vigente hasta "+month+" del "+ año; break;
                case 8: month = "enero";
                            año++;
                         mensaje = "Autorización Vigente hasta "+month+" del "+ año; break;
                case 9: month = "febrero";
                        año++;
                         mensaje = "Autorización Vigente hasta "+month+" del "+ año; break;
                case 10: month = "marzo";
                        año++;
                         mensaje = "Autorización Vigente hasta "+month+" del "+ año; break;
                case 11: month = "abril";
                        año++;
                         mensaje = "Autorización Vigente hasta "+month+" del "+ año; break;
                case 12: month = "mayo";
                        año++;
                         mensaje = "Autorización Vigente hasta "+month+" del "+ año; break;
             }
        
        return mensaje;
    }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jTextNombre = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextExpediente = new javax.swing.JTextField();
        jTextReciboCaja = new javax.swing.JTextField();
        jTextDireccion = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jComboUrbanizacion = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jDateFecha = new com.toedter.calendar.JDateChooser();
        jTextDNI = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jTextLote = new javax.swing.JTextField();
        jTextManzana = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jButtonAgregar = new javax.swing.JButton();
        jButtonNuevo = new javax.swing.JButton();
        jComboProyecto = new javax.swing.JComboBox<>();
        jLabelNumAutorizacion = new javax.swing.JLabel();
        jComboEstado = new javax.swing.JComboBox<>();
        jLabelID = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jTextCodigoCat = new javax.swing.JTextField();
        jButtonEditar = new javax.swing.JButton();
        jButtonEliminar = new javax.swing.JButton();
        jButtonImprimir = new javax.swing.JButton();
        jTextBuscar = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableDatos = new rojerusan.RSTableMetro();
        jComboFiltrarTipo = new javax.swing.JComboBox<>();
        jLabelTotalRegistrados = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabelVecesInstalacion = new javax.swing.JLabel();
        jComboBuscar = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                formMouseDragged(evt);
            }
        });
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                formMousePressed(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextNombre.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextNombreKeyPressed(evt);
            }
        });
        jPanel2.add(jTextNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, 310, 30));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Urbanizacion");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 440, 180, 20));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Formulario de Registro");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 270, 50));

        jTextExpediente.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextExpediente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextExpedienteKeyPressed(evt);
            }
        });
        jPanel2.add(jTextExpediente, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, 310, 30));

        jTextReciboCaja.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextReciboCaja.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextReciboCajaKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextReciboCajaKeyTyped(evt);
            }
        });
        jPanel2.add(jTextReciboCaja, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 280, 310, 30));

        jTextDireccion.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextDireccion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextDireccionKeyPressed(evt);
            }
        });
        jPanel2.add(jTextDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 400, 310, 30));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel3.setText("N° DE AUTORIZACION");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 180, 30));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Proyecto");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 180, 20));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Nombre");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 180, 20));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Expediente");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, 180, 20));

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Recibo en caja");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 260, 180, 20));

        jComboUrbanizacion.setEditable(true);
        jPanel2.add(jComboUrbanizacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 460, 310, 30));

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("código en CAT");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 320, 180, 20));

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setText("Direccion");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 380, 180, 20));
        jPanel2.add(jDateFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 510, 150, -1));

        jTextDNI.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextDNIKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextDNIKeyTyped(evt);
            }
        });
        jPanel2.add(jTextDNI, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 510, 110, -1));

        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("LT:");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 550, 30, 20));

        jLabel11.setText("Fecha:");
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 510, 40, 20));

        jTextLote.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextLoteKeyPressed(evt);
            }
        });
        jPanel2.add(jTextLote, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 550, 70, 20));

        jTextManzana.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextManzanaKeyPressed(evt);
            }
        });
        jPanel2.add(jTextManzana, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 550, 60, 20));

        jLabel12.setText("DNI:");
        jPanel2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 510, 30, 20));

        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("MZ:");
        jPanel2.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 550, 30, 20));

        jButtonAgregar.setText("AGREGAR");
        jButtonAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAgregarActionPerformed(evt);
            }
        });
        jPanel2.add(jButtonAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 590, 140, 40));

        jButtonNuevo.setText("NUEVO");
        jButtonNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNuevoActionPerformed(evt);
            }
        });
        jPanel2.add(jButtonNuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 590, 140, 40));

        jComboProyecto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-- SELECCIONE --", "INSTALACIÓN DE DESAGUE", "INSTALACIÓN DE AGUA Y ALCANTARILLADO" }));
        jComboProyecto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jComboProyectoMouseClicked(evt);
            }
        });
        jPanel2.add(jComboProyecto, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 310, 30));

        jLabelNumAutorizacion.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        jLabelNumAutorizacion.setText("0001");
        jPanel2.add(jLabelNumAutorizacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 50, 100, 30));

        jComboEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ESTADO", "FINALIZADO", "EN PROCESO" }));
        jComboEstado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jComboEstadoMouseClicked(evt);
            }
        });
        jPanel2.add(jComboEstado, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 550, 120, 20));
        jPanel2.add(jLabelID, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 30, 30));

        jLabel15.setBackground(new java.awt.Color(0, 0, 0));
        jLabel15.setOpaque(true);
        jPanel2.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(388, 0, 2, 650));

        jTextCodigoCat.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextCodigoCatKeyPressed(evt);
            }
        });
        jPanel2.add(jTextCodigoCat, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 340, 310, 30));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 390, 650));

        jButtonEditar.setText("Editar");
        jButtonEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEditarActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 590, 140, 40));

        jButtonEliminar.setText("Eliminar");
        jButtonEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEliminarActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 590, 140, 40));

        jButtonImprimir.setText("Imprimir");
        jButtonImprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonImprimirActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonImprimir, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 590, 140, 40));

        jTextBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextBuscarKeyPressed(evt);
            }
        });
        jPanel1.add(jTextBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 40, 270, 30));

        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTableDatos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTableDatos.setAltoHead(30);
        jTableDatos.setGridColor(new java.awt.Color(255, 255, 255));
        jTableDatos.setGrosorBordeFilas(0);
        jTableDatos.setGrosorBordeHead(-1);
        jTableDatos.setRowMargin(0);
        jTableDatos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableDatosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableDatos);

        jPanel3.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1770, 430));

        jScrollPane2.setViewportView(jPanel3);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 90, 830, 450));

        jComboFiltrarTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-- SELECIONE --", "INSTALACIÓN DE DESAGUE", "INSTALACIÓN DE ALCANTARILLADO" }));
        jPanel1.add(jComboFiltrarTipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 40, 220, 30));

        jLabelTotalRegistrados.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanel1.add(jLabelTotalRegistrados, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 550, 360, 20));

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton1.setText("Filtrar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 40, 90, 30));

        jLabel16.setFont(new java.awt.Font("Trebuchet MS", 0, 24)); // NOI18N
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("_");
        jLabel16.setToolTipText("");
        jLabel16.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jLabel16.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel16MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(1170, -10, 40, 30));

        jLabel17.setFont(new java.awt.Font("Trebuchet MS", 0, 24)); // NOI18N
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setText("x");
        jLabel17.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel17MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(1210, 0, 40, -1));

        jLabelVecesInstalacion.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelVecesInstalacion.setText("Veces de Instalacion");
        jPanel1.add(jLabelVecesInstalacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 550, 450, 20));

        jComboBuscar.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jComboBuscar.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Buscar por DNI", "Buscar por Código CAT." }));
        jPanel1.add(jComboBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 40, 180, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1250, 650));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNuevoActionPerformed
        // TODO add your handling code here:
        limpiar();
        jButtonEditar.setEnabled(false);
        jButtonEliminar.setEnabled(false);
        jButtonImprimir.setEnabled(false);
        jButtonAgregar.setEnabled(true);
        
       
        jTextNombre.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jTextExpediente.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jTextReciboCaja.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jTextCodigoCat.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jTextDireccion.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        //jComboUrbanizacion.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jComboProyecto.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jTextDNI.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jTextManzana.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jTextLote.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jComboEstado.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        
        jLabelID.setText(logica.ultimoId()+"");
        
        
    }//GEN-LAST:event_jButtonNuevoActionPerformed

    private void jButtonAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAgregarActionPerformed
        int numero = 0;
        
        if (jComboProyecto.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(null, "Selecione un proyecto");
            jComboProyecto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(217,70,70)));
            numero++;
        }
        if (jTextNombre.getText().length() == 0) {
            JOptionPane.showMessageDialog(null, "ingrese un texto al campo Nombre");
            jTextNombre.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(217,70,70)));
            jTextNombre.requestFocus();
            numero++;
        }
        if (jTextExpediente.getText().length() == 0) {
            JOptionPane.showMessageDialog(null, "ingrese un texto al campo Expediente");
            jTextExpediente.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(217,70,70)));
            jTextExpediente.requestFocus();
            numero++;
        }
        if (jTextReciboCaja.getText().length() == 0) {
            JOptionPane.showMessageDialog(null, "ingrese un texto al campo Recibo de caja");
            jTextReciboCaja.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(217,70,70)));
            jTextReciboCaja.requestFocus();
            numero++;
        }
        if (jTextCodigoCat.getText().length() == 0) {
            JOptionPane.showMessageDialog(null, "ingrese un texto al campo Codigo CAT");
            jTextCodigoCat.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(217,70,70)));
            jTextCodigoCat.requestFocus();
            numero++;
        }
        if (jTextDireccion.getText().length() == 0) {
            JOptionPane.showMessageDialog(null, "ingrese un texto al campo Direccion");
            jTextDireccion.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(217,70,70)));
            jTextDireccion.requestFocus();
            numero++;
        }
        if (jComboUrbanizacion.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(null, "ingrese un texto al campo Urbanizacion");
            //jComboUrbanizacion.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(217,70,70)));
            numero++;
        }
        
        if (jTextDNI.getText().length() == 0) {
            JOptionPane.showMessageDialog(null, "ingrese un texto al campo DNI");
            jTextDNI.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(217,70,70)));
            jTextDNI.requestFocus();
            numero++;
        }
        if (jDateFecha.getDate() == null) {
            JOptionPane.showMessageDialog(null, "ingrese un texto al campo fecha");
            //jDateFecha.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(217,70,70)));
            jDateFecha.requestFocus();
            numero++;
        }
        if (jTextManzana.getText().length() == 0) {
            JOptionPane.showMessageDialog(null, "ingrese un texto al campo Manzana");
            jTextManzana.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(217,70,70)));
            jTextManzana.requestFocus();
            numero++;
        }
        if (jTextLote.getText().length() == 0) {
            JOptionPane.showMessageDialog(null, "ingrese un texto al campo Lote");
            jTextLote.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(217,70,70)));
            jTextLote.requestFocus();
            numero++;
        }
        if (jComboEstado.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(null, "ingrese un texto al campo Estado");
            jComboEstado.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(217,70,70)));
            numero++;
        }
        
        if (numero == 0) {
            
            if (jComboProyecto.getSelectedItem().toString().equals("INSTALACIÓN DE DESAGUE")) {
                agregarDatosDesague();
                ocultarColumna();
                tamañoColumnas();
            } else {
                agregarDatosAlcantarillado();
                ocultarColumna();
                tamañoColumnas();
            }
            
            
            numero = 0;
        }
        
        
    }//GEN-LAST:event_jButtonAgregarActionPerformed

    private void jTextBuscarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextBuscarKeyPressed
        
       
        
        if (jComboFiltrarTipo.getSelectedItem().toString().equals("INSTALACIÓN DE DESAGUE")) {
            mostrarDesague(jTextBuscar.getText());
            ocultarColumna();
            tamañoColumnas();
        } else {
            
             if (jComboBuscar.getSelectedItem().toString().equals("Buscar por DNI")) {
                    mostrarAlcantarillado(jTextBuscar.getText());
                    ocultarColumna();
                    tamañoColumnas();
            } else {
                    mostrarCodigoCatAlcantarillado(jTextBuscar.getText());
                    ocultarColumna();
                    tamañoColumnas();
            }
        }
    }//GEN-LAST:event_jTextBuscarKeyPressed

    private void jTableDatosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableDatosMouseClicked
       int fila = jTableDatos.rowAtPoint(evt.getPoint());
       
        if (jTableDatos.getValueAt(0, 2).toString().equals("INSTALACIÓN DE DESAGUE")) {
            jLabelID.setText(jTableDatos.getValueAt(fila, 0).toString());
            jLabelNumAutorizacion.setText(jTableDatos.getValueAt(fila, 1).toString());
            jComboProyecto.setSelectedItem(jTableDatos.getValueAt(fila, 2).toString());

            jTextNombre.setText(jTableDatos.getValueAt(fila, 3).toString());
            jTextExpediente.setText(jTableDatos.getValueAt(fila, 4).toString());
            jTextReciboCaja.setText(jTableDatos.getValueAt(fila, 5).toString());
            jTextCodigoCat.setText(jTableDatos.getValueAt(fila, 6).toString());
            jTextDireccion.setText(jTableDatos.getValueAt(fila, 7).toString());
            jComboUrbanizacion.setSelectedItem(jTableDatos.getValueAt(fila, 8).toString());
            jTextDNI.setText(jTableDatos.getValueAt(fila, 9).toString());

            //Date fecha = parseFecha(jTableDatos.getValueAt(fila, 10).toString());
            jDateFecha.setDate(Date.valueOf(jTableDatos.getValueAt(fila, 10).toString()));
            jTextManzana.setText(jTableDatos.getValueAt(fila, 11).toString());
            jTextLote.setText(jTableDatos.getValueAt(fila, 12).toString());
            jComboEstado.setSelectedItem(jTableDatos.getValueAt(fila, 13).toString());
            

             String estado=jTableDatos.getValueAt(fila, 13).toString();

             if (estado.equals("Finalizado")) {
                 jButtonEditar.setEnabled(true);
                 jButtonEliminar.setEnabled(false);
                 jButtonImprimir.setEnabled(true);
                 jButtonAgregar.setEnabled(false);
             } else {
                 jButtonEditar.setEnabled(true);
                 jButtonEliminar.setEnabled(true);
                 jButtonImprimir.setEnabled(true);
                 jButtonAgregar.setEnabled(false);
             }
        } else {
            jLabelID.setText(jTableDatos.getValueAt(fila, 0).toString());
            jLabelNumAutorizacion.setText(jTableDatos.getValueAt(fila, 1).toString());
            jComboProyecto.setSelectedItem(jTableDatos.getValueAt(fila, 2).toString());

            jTextNombre.setText(jTableDatos.getValueAt(fila, 3).toString());
            jTextExpediente.setText(jTableDatos.getValueAt(fila, 4).toString());
            jTextReciboCaja.setText(jTableDatos.getValueAt(fila, 5).toString());
            jTextCodigoCat.setText(jTableDatos.getValueAt(fila, 6).toString());
            jTextDireccion.setText(jTableDatos.getValueAt(fila, 7).toString());
            jComboUrbanizacion.setSelectedItem(jTableDatos.getValueAt(fila, 8).toString());
            jTextDNI.setText(jTableDatos.getValueAt(fila, 9).toString());

            jDateFecha.setDate(Date.valueOf(jTableDatos.getValueAt(fila, 10).toString()));
            jTextManzana.setText(jTableDatos.getValueAt(fila, 11).toString());
            jTextLote.setText(jTableDatos.getValueAt(fila, 12).toString());
            jComboEstado.setSelectedItem(jTableDatos.getValueAt(fila, 13).toString());
            jLabelVecesInstalacion.setText(jTableDatos.getValueAt(fila, 14).toString()+" INSTALACIÓN DE AGUA Y ALCANTARILLADO");

             String estado=jTableDatos.getValueAt(fila, 13).toString();

             if (estado.equals("Finalizado")) {
                 jButtonEditar.setEnabled(true);
                 jButtonEliminar.setEnabled(false);
                 jButtonImprimir.setEnabled(true);
                 jButtonAgregar.setEnabled(false);
             } else {
                 jButtonEditar.setEnabled(true);
                 jButtonEliminar.setEnabled(true);
                 jButtonImprimir.setEnabled(true);
                 jButtonAgregar.setEnabled(false);
             }
        }
       
       
    }//GEN-LAST:event_jTableDatosMouseClicked

    private void jButtonImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonImprimirActionPerformed
        if (jComboProyecto.getSelectedItem().toString().equals("INSTALACIÓN DE DESAGUE")) {

                Connection conectado = conectando.conexion();
                try {
                    JasperReport jr = (JasperReport) JRLoader.loadObject(formulario.class.getResource("/Reporte/ReporteDesague.jasper"));
                       
                    //JasperReport jr = JasperCompileManager.compileReport(new File("").getAbsolutePath()
                        //        +"/Rerporte/ReporteAlcantarillado.jrxml");
                    Map parametros = new HashMap<>();
                    parametros.put("id", jLabelID.getText());
                    JasperPrint jp = JasperFillManager.fillReport(jr, parametros,conectado);
                    JasperViewer jv = new JasperViewer(jp,false);
                    jv.show();
                } catch (JRException ex) {
                    ex.printStackTrace();
                }
            }else if(jComboProyecto.getSelectedItem().toString().equals("INSTALACIÓN DE AGUA Y ALCANTARILLADO")){
                Connection conectado = conectando.conexion();
                try {
                    JasperReport jr = (JasperReport) JRLoader.loadObject(formulario.class.getResource("/Reporte/ReporteAlcantarillado.jasper"));
                       
                    //JasperReport jr = JasperCompileManager.compileReport(new File("").getAbsolutePath()
                        //        +"/Rerporte/ReporteAlcantarillado.jrxml");
                    Map parametros = new HashMap<>();
                    parametros.put("id", jLabelID.getText());
                    JasperPrint jp = JasperFillManager.fillReport(jr, parametros,conectado);
                    JasperViewer jv = new JasperViewer(jp,false);
                    jv.show();
                } catch (JRException ex) {
                    ex.printStackTrace();
                }            
            }
    }//GEN-LAST:event_jButtonImprimirActionPerformed

    private void jButtonEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEditarActionPerformed
        int numero = 0;
        
        if (jComboProyecto.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(null, "ingrese un texto al campo tipo");
            jComboProyecto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(217,70,70)));
            numero++;
        }
        
        if (jTextNombre.getText().length() == 0) {
            JOptionPane.showMessageDialog(null, "ingrese un texto al campo Nombre");
            jTextNombre.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(217,70,70)));
            jTextNombre.requestFocus();
            numero++;
        }
        if (jTextExpediente.getText().length() == 0) {
            JOptionPane.showMessageDialog(null, "ingrese un texto al campo Expediente");
            jTextExpediente.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(217,70,70)));
            jTextExpediente.requestFocus();
            numero++;
        }
        if (jTextReciboCaja.getText().length() == 0) {
            JOptionPane.showMessageDialog(null, "ingrese un texto al campo Recibo de caja");
            jTextReciboCaja.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(217,70,70)));
            jTextReciboCaja.requestFocus();
            numero++;
        }
        if (jTextCodigoCat.getText().length() == 0) {
            JOptionPane.showMessageDialog(null, "ingrese un texto al campo Codigo CAT");
            jTextCodigoCat.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(217,70,70)));
            jTextCodigoCat.requestFocus();
            numero++;
        }
        if (jTextDireccion.getText().length() == 0) {
            JOptionPane.showMessageDialog(null, "ingrese un texto al campo Direccion");
            jTextDireccion.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(217,70,70)));
            jTextDireccion.requestFocus();
            numero++;
        }
        if (jComboUrbanizacion.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(null, "ingrese un texto al campo Urbanizacion");
            jComboUrbanizacion.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(217,70,70)));
            numero++;
        }
        
        if (jTextDNI.getText().length() == 0) {
            JOptionPane.showMessageDialog(null, "ingrese un texto al campo DNI");
            jTextDNI.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(217,70,70)));
            jTextDNI.requestFocus();
            numero++;
        }
        if (jDateFecha.getDate() == null) {
            JOptionPane.showMessageDialog(null, "ingrese un texto al campo fecha");
            jDateFecha.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(217,70,70)));
            jDateFecha.requestFocus();
            numero++;
        }
        if (jTextManzana.getText().length() == 0) {
            JOptionPane.showMessageDialog(null, "ingrese un texto al campo Manzana");
            jTextManzana.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(217,70,70)));
            jTextManzana.requestFocus();
            numero++;
        }
        if (jTextLote.getText().length() == 0) {
            JOptionPane.showMessageDialog(null, "ingrese un texto al campo Lote");
            jTextLote.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(217,70,70)));
            jTextLote.requestFocus();
            numero++;
        }
        if (jComboEstado.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(null, "ingrese un texto al campo Estado");
            jComboEstado.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(217,70,70)));
            numero++;
        }
        if (numero == 0) {
            if (jComboProyecto.getSelectedItem().toString().equals("INSTALACIÓN DE DESAGUE")) {
                editarDesague();
                ocultarColumna();
                tamañoColumnas();
            } else {
                editarAlcantarillado();
                ocultarColumna();
                tamañoColumnas();
            }
           
            numero = 0;
        }
    }//GEN-LAST:event_jButtonEditarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       if (jComboFiltrarTipo.getSelectedItem().toString().equals("INSTALACIÓN DE DESAGUE")) {
            mostrarDesague("");
            jLabelNumAutorizacion.setText(logica.numeroAutorizacion());
            jLabelID.setText(logica.ultimoId()+"");
            ocultarColumna();
            tamañoColumnas();
            
        } else if(jComboFiltrarTipo.getSelectedItem().toString().equals("INSTALACIÓN DE ALCANTARILLADO")) {
            mostrarAlcantarillado("");
            jLabelNumAutorizacion.setText(logica2.numeroAutorizacion());
            jLabelID.setText(logica2.ultimoId()+"");
            ocultarColumna();
            tamañoColumnas();
            
        }else{
            JOptionPane.showMessageDialog(null, "Selecione una opción para filtrar los Datos");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButtonEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEliminarActionPerformed
        if (jComboProyecto.getSelectedItem().toString().equals("INSTALACIÓN DE DESAGUE")) {
            int rpt = JOptionPane.showConfirmDialog(null, "¿ Estás seguro de eliminar esta fila ?",
                    "CONFIRMACIÓN",JOptionPane.YES_NO_OPTION);
            
            if (rpt == JOptionPane.YES_OPTION) {
                dts.setNum_autorizacion(jLabelNumAutorizacion.getText());
                logica.eliminar(dts);
                mostrarDesague("");
                limpiar();
                tamañoColumnas();
                ocultarColumna();
                jButtonEditar.setEnabled(false);
                jButtonEliminar.setEnabled(false);
                jButtonImprimir.setEnabled(false);
                jButtonAgregar.setEnabled(true);
            }
        }else{
            int rpt = JOptionPane.showConfirmDialog(null, "¿ Estás seguro de eliminar esta fila ?",
                    "CONFIRMACIÓN",JOptionPane.YES_NO_OPTION);
            
            if (rpt == JOptionPane.YES_OPTION) {
                dts2.setNum_autorizacion(jLabelNumAutorizacion.getText());
                logica2.eliminar(dts2);
                mostrarAlcantarillado("");
                limpiar();
                ocultarColumna();
                tamañoColumnas();
                jButtonEditar.setEnabled(false);
                jButtonEliminar.setEnabled(false);
                jButtonImprimir.setEnabled(false);
                jButtonAgregar.setEnabled(true);
            }
        }
    }//GEN-LAST:event_jButtonEliminarActionPerformed

    private void jTextNombreKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextNombreKeyPressed
        // TODO add your handling code here:
        jTextNombre.setBorder(javax.swing.BorderFactory.createEtchedBorder());
    }//GEN-LAST:event_jTextNombreKeyPressed

    private void jTextExpedienteKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextExpedienteKeyPressed
        // TODO add your handling code here:
        jTextExpediente.setBorder(javax.swing.BorderFactory.createEtchedBorder());
    }//GEN-LAST:event_jTextExpedienteKeyPressed

    private void jTextReciboCajaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextReciboCajaKeyPressed
        // TODO add your handling code here:
        jTextReciboCaja.setBorder(javax.swing.BorderFactory.createEtchedBorder());
    }//GEN-LAST:event_jTextReciboCajaKeyPressed

    private void jTextDireccionKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextDireccionKeyPressed
        // TODO add your handling code here:
        jTextDireccion.setBorder(javax.swing.BorderFactory.createEtchedBorder());
    }//GEN-LAST:event_jTextDireccionKeyPressed

    private void jComboProyectoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboProyectoMouseClicked
        // TODO add your handling code here:
        jComboProyecto.setBorder(javax.swing.BorderFactory.createEtchedBorder());
    }//GEN-LAST:event_jComboProyectoMouseClicked

    private void jTextDNIKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextDNIKeyPressed
        // TODO add your handling code here:
        jTextDNI.setBorder(javax.swing.BorderFactory.createEtchedBorder());
    }//GEN-LAST:event_jTextDNIKeyPressed

    private void jTextManzanaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextManzanaKeyPressed
        // TODO add your handling code here:
        jTextManzana.setBorder(javax.swing.BorderFactory.createEtchedBorder());
    }//GEN-LAST:event_jTextManzanaKeyPressed

    private void jTextLoteKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextLoteKeyPressed
        // TODO add your handling code here:
        jTextLote.setBorder(javax.swing.BorderFactory.createEtchedBorder());
    }//GEN-LAST:event_jTextLoteKeyPressed

    private void jComboEstadoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboEstadoMouseClicked
        // TODO add your handling code here:
        jComboEstado.setBorder(javax.swing.BorderFactory.createEtchedBorder());
    }//GEN-LAST:event_jComboEstadoMouseClicked

    private void jTextReciboCajaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextReciboCajaKeyTyped
        // TODO add your handling code here:
       /*  char c = evt.getKeyChar();
        if((c<'0' || c>'9') && c== '-')evt.consume();
        if((c<'a' || c>'z') && (c<'A' || c>'Z') && (c<' ' || c>' '));
        else{JOptionPane.showMessageDialog(null, "Ingrese solo numeros");}*/
    }//GEN-LAST:event_jTextReciboCajaKeyTyped

    private void jTextDNIKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextDNIKeyTyped
        // TODO add your handling code here:
         char c = evt.getKeyChar();
        if(c<'0' || c>'9')evt.consume();
        if((c<'a' || c>'z') && (c<'A' || c>'Z') && (c<' ' || c>' '));
        else{JOptionPane.showMessageDialog(null, "Ingrese solo números");}
    }//GEN-LAST:event_jTextDNIKeyTyped

    private void jLabel17MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel17MouseClicked
        if (true) {
            int rpt = JOptionPane.showConfirmDialog(null, "¿ ESTÁS SEGURO DE SALIR ?","CONFIRMACIÓN",JOptionPane.YES_NO_OPTION);
            if (rpt == JOptionPane.YES_OPTION) {
                 System.exit(0);
            }
        }
    }//GEN-LAST:event_jLabel17MouseClicked

    private void jLabel16MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel16MouseClicked
        this.setState(formulario.ICONIFIED);
    }//GEN-LAST:event_jLabel16MouseClicked

    private void formMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseDragged
       int x = evt.getXOnScreen();
       int y = evt.getYOnScreen();
       this.setLocation(x-xMouse, y-yMouse);
    }//GEN-LAST:event_formMouseDragged

    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed
        xMouse = evt.getX();
        yMouse = evt.getY();
    }//GEN-LAST:event_formMousePressed

    private void jTextCodigoCatKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextCodigoCatKeyPressed

    
    }//GEN-LAST:event_jTextCodigoCatKeyPressed
    
    int xMouse;
    int yMouse;

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(formulario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(formulario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(formulario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(formulario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        try{
  
            JFrame.setDefaultLookAndFeelDecorated(true);
            JDialog.setDefaultLookAndFeelDecorated(true);
            //UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
            //UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
            //UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
          }
            catch ( ClassNotFoundException | IllegalAccessException | InstantiationException | UnsupportedLookAndFeelException e)
             {
              e.printStackTrace();
             }
       
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new formulario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButtonAgregar;
    private javax.swing.JButton jButtonEditar;
    private javax.swing.JButton jButtonEliminar;
    private javax.swing.JButton jButtonImprimir;
    private javax.swing.JButton jButtonNuevo;
    private javax.swing.JComboBox<String> jComboBuscar;
    private javax.swing.JComboBox<String> jComboEstado;
    private javax.swing.JComboBox<String> jComboFiltrarTipo;
    private javax.swing.JComboBox<String> jComboProyecto;
    private javax.swing.JComboBox<String> jComboUrbanizacion;
    private com.toedter.calendar.JDateChooser jDateFecha;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    public javax.swing.JLabel jLabelID;
    private javax.swing.JLabel jLabelNumAutorizacion;
    private javax.swing.JLabel jLabelTotalRegistrados;
    private javax.swing.JLabel jLabelVecesInstalacion;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private rojerusan.RSTableMetro jTableDatos;
    private javax.swing.JTextField jTextBuscar;
    public javax.swing.JTextField jTextCodigoCat;
    private javax.swing.JTextField jTextDNI;
    private javax.swing.JTextField jTextDireccion;
    private javax.swing.JTextField jTextExpediente;
    private javax.swing.JTextField jTextLote;
    private javax.swing.JTextField jTextManzana;
    private javax.swing.JTextField jTextNombre;
    private javax.swing.JTextField jTextReciboCaja;
    // End of variables declaration//GEN-END:variables
}

