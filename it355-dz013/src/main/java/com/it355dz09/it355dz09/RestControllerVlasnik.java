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
@RequestMapping(value = "/vlasnici", produces = MediaType.APPLICATION_JSON_VALUE)
public class RestControllerVlasnik {

private VlasnikRepository vlasnikRepository;

@Autowired
public RestControllerVlasnik (VlasnikRepository repository){
this.vlasnikRepository = repository;
}

@GetMapping
public ResponseEntity<List<Vlasnik>> getAll(){

    List<Vlasnik> vlasnici = vlasnikRepository.findAll();
    if (vlasnici.size() == 0){
return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    return new ResponseEntity<>(vlasnici, HttpStatus.OK);
}

@GetMapping(value = "{id}")
    public ResponseEntity<Vlasnik> getVlasnik(@PathVariable ("id") int id){
    Optional<Vlasnik> vlasnik = vlasnikRepository.findById(id);
    if (!vlasnik.isPresent()){
        return new ResponseEntity<Vlasnik>(HttpStatus.NOT_FOUND);
    }
    return new ResponseEntity<Vlasnik>(vlasnik.get(), HttpStatus.OK);
}

@PostMapping
    public ResponseEntity<Void> addVlasnik(@RequestBody Vlasnik vlasnik){
    vlasnikRepository.saveAndFlush(vlasnik);
    HttpHeaders headers = new HttpHeaders();
    return new ResponseEntity<>(headers, HttpStatus.CREATED);
}

@PostMapping(value = "{id}")
    public ResponseEntity<Vlasnik> updateVlasnik(@PathVariable ("id") int id, @RequestBody Vlasnik vlasnik){
    vlasnik.setId(id);
    vlasnikRepository.saveAndFlush(vlasnik);
    return  new ResponseEntity<>(vlasnik, HttpStatus.OK);
}

@DeleteMapping(value = "{id}")
    public ResponseEntity<Vlasnik> deleteVlasnik(@PathVariable ("id") int id){
    Optional<Vlasnik> vlasnik = vlasnikRepository.findById(id);
    if (!vlasnik.isPresent()){
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    vlasnikRepository.delete(vlasnik.get());
    return new ResponseEntity<>(HttpStatus.OK);
}

}
