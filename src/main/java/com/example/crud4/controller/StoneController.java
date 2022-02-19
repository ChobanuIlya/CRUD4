package com.example.crud4.controller;

import com.example.crud4.entity.Stone;
import com.example.crud4.service.StoneService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
public class StoneController {

    private final StoneService stoneService;

    public StoneController(StoneService stoneService) {
        this.stoneService = stoneService;
    }

    @PostMapping("/stones")
    @ResponseStatus(HttpStatus.CREATED)
    public Stone saveStone(@RequestBody Stone stone){
        return stoneService.saveStone(stone);
    }

    @GetMapping("/stones/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Stone getStoneById(@PathVariable Long id) {
        return stoneService.getStoneById(id);
    }

    @GetMapping("/stones")
    @ResponseStatus(HttpStatus.OK)
    public List<Stone> getAllStones(){
        return stoneService.getAllStones();
    }

    @PutMapping("/stones/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Stone updateStone(@PathVariable Long id, @RequestBody Stone stone){
        return stoneService.updateStoneById(id, stone);
    }

    @DeleteMapping("/stones/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteStoneById(@PathVariable Long id){
        stoneService.deleteStoneById(id);
    }

    @DeleteMapping("/stones")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAllStones(){
        stoneService.deleteAllStones();
    }
}
