package com.example.hotel.model;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "hotel")
public class Reserva {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idReserva")
    private Long idReserva;
    @NotBlank(message = "No se puede ingresar un nombre vacío")
    @Column(name = "nombreCliente")
    private String nombreCliente;
    @Column(name = "fechaEntrada")
    private String fechaEntrada;
    @Column(name = "horaEntrada")
    private String horaEntreada;
    @Column(name = "fechaSalida")
    private String fechaSalida;
    @Column(name = "horaSalida")
    private String horaSalida;
    @Column(name = "tipoHabitacion")
    private String tipoHabitacion;
    @Column(name = "solicitudEspecial")
    private String solicitudEspecial;
    @Column(name = "opcionPago")
    private String opcionPago;
    @Column(name = "telefono")
    private String telefono;
    @Column(name = "mail")
    private String mail;

    public long getIdReserva(){
        return idReserva;
    }

    public String getNombreCliente(){
        return nombreCliente;
    }

    public String getFechaEntrada(){
        return fechaEntrada;    
    }

    public String getHoraEntreada(){
        return horaEntreada;
    }

    public String getFechaSalida(){
        return fechaSalida;
    }

    public String getHoraSalida(){
        return horaSalida;
    }

    public String getTipoHabitacion(){
        return tipoHabitacion;
    }

    public String getSolicitudEspecial(){
        return solicitudEspecial;
    }

    public String getOpcionPago(){
        return opcionPago;
    }

    public String getTelefono(){
        return telefono;
    }

    public String getMail(){
        return mail;
    }    

//SET
    public void setIdReserva(long idReserva){
        this.idReserva = idReserva;
    }

    public void setNombreCliente(String nombreCliente){
        this.nombreCliente = nombreCliente;
    }

    public void setFechaEntrada(String fechaEntrada){
        this.fechaEntrada = fechaEntrada;
    }

    public void setHoraEntreada(String horaEntreada){
        this.horaEntreada = horaEntreada;
    }

    public void setFechaSalida(String fechaSalida){
        this.fechaSalida = fechaSalida;
    }

    public void setHoraSalida(String horaSalida){
        this.horaSalida = horaSalida;
    }

    public void setTipoHabitacion(String tipoHabitacion){
        this.tipoHabitacion = tipoHabitacion;
    }

    public void setSolicitudEspecial(String solicitudEspecial){
        this.solicitudEspecial = solicitudEspecial;
    }

    public void setOpcionPago(String opcionPago){
        this.opcionPago = opcionPago;
    }

    public void setTelefono(String telefono){
        this.telefono = telefono;    
    }

    public void setMail(String mail){
        this.mail = mail;    
    }   
}
