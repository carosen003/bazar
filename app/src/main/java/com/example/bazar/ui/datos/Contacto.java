package com.example.bazar.ui.datos;

import java.util.Date;

public class Contacto {
    private Usuario usuarioContacto;
    private Date fechaEstablecimientoContacto;
    private Estado estado;

    public Contacto(Usuario usuarioContacto, Date fechaEstablecimientoContacto, Estado estado) {
        this.usuarioContacto = usuarioContacto;
        this.fechaEstablecimientoContacto = fechaEstablecimientoContacto;
        this.estado = estado;
    }
}