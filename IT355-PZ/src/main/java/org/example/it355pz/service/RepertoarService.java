package org.example.it355pz.service;

import org.example.it355pz.crud.RepertoarUpdate;
import org.example.it355pz.entity.Repertoar;
import org.example.it355pz.repository.RepertoarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RepertoarService {

    @Autowired
    private RepertoarRepository repertoarRepository;

    public Repertoar registerRepertoar(Repertoar repertoar) {
        return repertoarRepository.save(repertoar);
    }

    public List<Repertoar> getRepertoare() {
        List<Repertoar> repertoari = repertoarRepository.findAll();
        return  repertoari;
    }

    public boolean deleteRepertoar(Long idRepertoar) {
        if(repertoarRepository.existsById(idRepertoar)){
            repertoarRepository.deleteById(idRepertoar);
        }else {
            System.out.println("Nismo pronasli ni jedan repertoar sa tim id-jem!");
        }
        return true;
    }

    public String updateRepertoar(RepertoarUpdate repertoarUpdate) {
        Optional<Repertoar> optionalRepertoar = repertoarRepository.findById(repertoarUpdate.getIdRepertoar());
        if (optionalRepertoar.isPresent()) {
            Repertoar repertoar = optionalRepertoar.get();
            repertoar.setFilm(repertoarUpdate.getFilm());
            repertoar.setReziser(repertoarUpdate.getReziser());
            repertoar.setZanr(repertoarUpdate.getZanr());
            repertoar.setTrajanje(repertoarUpdate.getTrajanje());
            repertoar.setOcena(repertoarUpdate.getOcena());
            repertoar.setProjekcija(repertoarUpdate.getProjekcija());
            repertoar.setCenaKarte(repertoarUpdate.getCenaKarte());
            repertoar.setImgRepertoar(repertoarUpdate.getImgRepertoar());
            repertoarRepository.save(repertoar);
        } else {
            System.out.println("Tvoja repertoar ne postoji!");
        }
        return null;
    }
}
