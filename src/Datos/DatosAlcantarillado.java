/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import java.sql.Date;

/**
 *
 * @author maxni
 */
public class DatosAlcantarillado {
    private int id;
    private String num_autorizacion;
    private String proyecto;
    private String nombre;
    private String expediente;
    private String reciboCaja;
    private String codigoCat;
    private String direccion;
    private String urbanizacion;
    private String dni;
    private Date fecha;
    private String manzana;
    private String lote;
    private String estado;
    private String vecesInstalacion;
    private String tiempoVigencia;

    public String getTiempoVigencia() {
        return tiempoVigencia;
    }

    public void setTiempoVigencia(String tiempoVigencia) {
        this.tiempoVigencia = tiempoVigencia;
    }

    public String getVecesInstalacion() {
        return vecesInstalacion;
    }

    public void setVecesInstalacion(String vecesInstalacion) {
        this.vecesInstalacion = vecesInstalacion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getNum_autorizacion() {
        return num_autorizacion;
    }

    public void setNum_autorizacion(String num_autorizacion) {
        this.num_autorizacion = num_autorizacion;
    }
    
    public String getProyecto() {
        return proyecto;
    }

    public void setProyecto(String proyecto) {
        this.proyecto = proyecto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getExpediente() {
        return expediente;
    }

    public void setExpediente(String expediente) {
        this.expediente = expediente;
    }

    public String getReciboCaja() {
        return reciboCaja;
    }

    public void setReciboCaja(String reciboCaja) {
        this.reciboCaja = reciboCaja;
    }

    public String getCodigoCat() {
        return codigoCat;
    }

    public void setCodigoCat(String codigoCat) {
        this.codigoCat = codigoCat;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getUrbanizacion() {
        return urbanizacion;
    }

    public void setUrbanizacion(String urbanizacion) {
        this.urbanizacion = urbanizacion;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getManzana() {
        return manzana;
    }

    public void setManzana(String manzana) {
        this.manzana = manzana;
    }

    public String getLote() {
        return lote;
    }

    public void setLote(String lote) {
        this.lote = lote;
    }
    
    

  

   
    
    
}
