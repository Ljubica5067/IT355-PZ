package org.example.it355pz.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Recenzija {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idRecenzija;

    private String textRecenzije;

    private Double markRecenzije;

    public Recenzija() {
    }

    public Recenzija(String textRecenzije, Double markRecenzije) {
        this.textRecenzije = textRecenzije;
        this.markRecenzije = markRecenzije;
    }

    public Recenzija(Long idRecenzija, String textRecenzije, Double markRecenzije) {
        this.idRecenzija = idRecenzija;
        this.textRecenzije = textRecenzije;
        this.markRecenzije = markRecenzije;
    }

    public Long getIdRecenzija() {
        return idRecenzija;
    }

    public void setIdRecenzija(Long idRecenzija) {
        this.idRecenzija = idRecenzija;
    }

    public String getTextRecenzije() {
        return textRecenzije;
    }

    public void setTextRecenzije(String textRecenzije) {
        this.textRecenzije = textRecenzije;
    }

    public Double getMarkRecenzije() {
        return markRecenzije;
    }

    public void setMarkRecenzije(Double markRecenzije) {
        this.markRecenzije = markRecenzije;
    }
}
