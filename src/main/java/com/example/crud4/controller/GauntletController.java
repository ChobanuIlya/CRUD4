package com.example.crud4.controller;

import com.example.crud4.entity.Gauntlet;
import com.example.crud4.service.GauntletService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
public class GauntletController {

    private final GauntletService gauntletService;

    public GauntletController(GauntletService gauntletService) {
        this.gauntletService = gauntletService;
    }

    @PostMapping("/gauntlets")
    @ResponseStatus(HttpStatus.CREATED)
    public Gauntlet saveGauntlet(@RequestBody Gauntlet gauntlet){
        return gauntletService.saveGauntlet(gauntlet);
    }

    @GetMapping("/gauntlets/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Gauntlet getGauntletById(@PathVariable Long id){
        return gauntletService.getGauntletById(id);
    }

    @GetMapping("/gauntlets")
    @ResponseStatus(HttpStatus.OK)
    public List<Gauntlet> getAllGauntlets(){
        return gauntletService.getAllGauntlets();
    }

    @PutMapping("/gauntlets/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Gauntlet updateGauntlet(@PathVariable Long id, @RequestBody Gauntlet gauntlet){
        return gauntletService.updateGauntletById(id, gauntlet);
    }

    @DeleteMapping("/gauntlets/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteGauntletById(@PathVariable Long id){
        gauntletService.deleteGauntletById(id);
    }

    @DeleteMapping("/gauntlets")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAllGauntlets(){
        gauntletService.deleteAllGauntlets();
    }
}
