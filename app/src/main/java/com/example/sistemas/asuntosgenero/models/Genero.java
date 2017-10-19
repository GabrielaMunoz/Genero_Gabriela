package com.example.sistemas.asuntosgenero.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Genero {
    @SerializedName("a_o")
    @Expose
    private String aO;
    @SerializedName("comuna")
    @Expose
    private String comuna;
    @SerializedName("edad")
    @Expose
    private String edad;
    @SerializedName("identidad_de_g_nero_u_orientaci_n_sexual")
    @Expose
    private String identidadDeGNeroUOrientaciNSexual;
    @SerializedName("mes")
    @Expose
    private String mes;
    @SerializedName("municipio")
    @Expose
    private String municipio;
    @SerializedName("relaci_n_con_el_presunto_agresor")
    @Expose
    private String relaciNConElPresuntoAgresor;
    @SerializedName("tipo_de_seguridad_social")
    @Expose
    private String tipoDeSeguridadSocial;
    @SerializedName("tipo_de_violencia")
    @Expose
    private String tipoDeViolencia;

    public String getAO() {
        return aO;
    }

    public void setAO(String aO) {
        this.aO = aO;
    }

    public String getComuna() {
        return comuna;
    }

    public void setComuna(String comuna) {
        this.comuna = comuna;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public String getIdentidadDeGNeroUOrientaciNSexual() {
        return identidadDeGNeroUOrientaciNSexual;
    }

    public void setIdentidadDeGNeroUOrientaciNSexual(String identidadDeGNeroUOrientaciNSexual) {
        this.identidadDeGNeroUOrientaciNSexual = identidadDeGNeroUOrientaciNSexual;
    }

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public String getRelaciNConElPresuntoAgresor() {
        return relaciNConElPresuntoAgresor;
    }

    public void setRelaciNConElPresuntoAgresor(String relaciNConElPresuntoAgresor) {
        this.relaciNConElPresuntoAgresor = relaciNConElPresuntoAgresor;
    }

    public String getTipoDeSeguridadSocial() {
        return tipoDeSeguridadSocial;
    }

    public void setTipoDeSeguridadSocial(String tipoDeSeguridadSocial) {
        this.tipoDeSeguridadSocial = tipoDeSeguridadSocial;
    }

    public String getTipoDeViolencia() {
        return tipoDeViolencia;
    }

    public void setTipoDeViolencia(String tipoDeViolencia) {
        this.tipoDeViolencia = tipoDeViolencia;
    }

}


