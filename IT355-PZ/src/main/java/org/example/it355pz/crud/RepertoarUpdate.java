package org.example.it355pz.crud;

import javax.persistence.Id;

public class RepertoarUpdate {
    @Id
    private Long idRepertoar;

    private String film;

    private String reziser;

    private String zanr;

    private Integer trajanje;

    private Double ocena;

    private String projekcija;

    private Double cenaKarte;

    private String imgRepertoar;

    public RepertoarUpdate() {
    }

    public RepertoarUpdate(String film, String reziser, String zanr, Integer trajanje, Double ocena, String projekcija, Double cenaKarte,String imgRepertoar) {
        this.film = film;
        this.reziser = reziser;
        this.zanr = zanr;
        this.trajanje = trajanje;
        this.ocena = ocena;
        this.projekcija = projekcija;
        this.cenaKarte = cenaKarte;
        this.imgRepertoar=imgRepertoar;
    }

    public RepertoarUpdate(Long idRepertoar, String film, String reziser, String zanr, Integer trajanje, Double ocena, String projekcija, Double cenaKarte, String imgRepertoar) {
        this.idRepertoar = idRepertoar;
        this.film = film;
        this.reziser = reziser;
        this.zanr = zanr;
        this.trajanje = trajanje;
        this.ocena = ocena;
        this.projekcija = projekcija;
        this.cenaKarte = cenaKarte;
        this.imgRepertoar=imgRepertoar;
    }

    public Long getIdRepertoar() {
        return idRepertoar;
    }

    public void setIdRepertoar(Long idRepertoar) {
        this.idRepertoar = idRepertoar;
    }

    public String getFilm() {
        return film;
    }

    public void setFilm(String film) {
        this.film = film;
    }

    public String getReziser() {
        return reziser;
    }

    public void setReziser(String reziser) {
        this.reziser = reziser;
    }

    public String getZanr() {
        return zanr;
    }

    public void setZanr(String zanr) {
        this.zanr = zanr;
    }

    public Integer getTrajanje() {
        return trajanje;
    }

    public void setTrajanje(Integer trajanje) {
        this.trajanje = trajanje;
    }

    public Double getOcena() {
        return ocena;
    }

    public void setOcena(Double ocena) {
        this.ocena = ocena;
    }

    public String getProjekcija() {
        return projekcija;
    }

    public void setProjekcija(String projekcija) {
        this.projekcija = projekcija;
    }

    public Double getCenaKarte() {
        return cenaKarte;
    }

    public void setCenaKarte(Double cenaKarte) {
        this.cenaKarte = cenaKarte;
    }

    public String getImgRepertoar(){
        return imgRepertoar;
    }
    public void setImgRepertoar(String imgRepertoar){
        this.imgRepertoar=imgRepertoar;
    }
}

