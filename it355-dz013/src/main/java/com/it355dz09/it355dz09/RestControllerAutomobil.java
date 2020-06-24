package com.it355dz09.it355dz09;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(value = "/automobili", produces = MediaType.APPLICATION_JSON_VALUE)
public class RestControllerAutomobil {
    private AutomobilRepository automobilRepository;
    @Autowired
    public RestControllerAutomobil(AutomobilRepository repository){this.automobilRepository = repository;}

    @GetMapping
    public ResponseEntity<List<Automobil>> getAll(){
        List<Automobil> automobili = automobilRepository.findAll();
        if (automobili.size() == 0){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(automobili, HttpStatus.OK);
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<Automobil> getAuto(@PathVariable("id") int id){
        Optional<Automobil> automobil = automobilRepository.findById(id);
        if (!automobil.isPresent()){
            return new ResponseEntity<Automobil>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Automobil>(automobil.get(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Void> addAuto(@RequestBody Automobil automobil){
        automobilRepository.saveAndFlush(automobil);
        HttpHeaders headers = new HttpHeaders();
        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }

    @PostMapping(value = "{id}")
    public ResponseEntity<Automobil> updateAuto(@PathVariable ("id") int id, @RequestBody Automobil automobil){
        automobil.setId(id);
        automobilRepository.saveAndFlush(automobil);
        return  new ResponseEntity<>(automobil, HttpStatus.OK);
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity<Automobil> deleteAuto(@PathVariable ("id") int id){
        Optional<Automobil> automobil = automobilRepository.findById(id);
        if (!automobil.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        automobilRepository.delete(automobil.get());
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
