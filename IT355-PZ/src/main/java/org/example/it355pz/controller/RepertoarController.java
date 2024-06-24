package org.example.it355pz.controller;


import org.example.it355pz.crud.RepertoarUpdate;
import org.example.it355pz.entity.Repertoar;
import org.example.it355pz.service.RepertoarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class RepertoarController {

    @Autowired
    private RepertoarService repertoarService;

    @PostMapping("/repertoari")
    public Repertoar registerRepertoar(@RequestBody Repertoar repertoar) {
        return  repertoarService.registerRepertoar(repertoar);
    }

    @GetMapping("/getRepertoare")
    public List<Repertoar> getRepertoare() {
        List<Repertoar> repertoari = repertoarService.getRepertoare();
        return repertoari;
    }

    @DeleteMapping(path = "/deleteRepertoar/{idRepertoar}")
    public String deleteRepertoar(@PathVariable(value = "idRepertoar")Long idRepertoar){
        boolean deleteRepertoar = repertoarService.deleteRepertoar(idRepertoar);
        return  "Uspesno obrisano!";
    }

    @PutMapping(path = "/updateRepertoar")
    public String updateRepertoar(@RequestBody RepertoarUpdate repertoarUpdate){
        String idid = repertoarService.updateRepertoar(repertoarUpdate);
        return idid;
    }
}
