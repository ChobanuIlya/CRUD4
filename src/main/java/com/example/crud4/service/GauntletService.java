package com.example.crud4.service;

import com.example.crud4.entity.Gauntlet;
import com.example.crud4.repository.GauntletRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class GauntletService {

    private final GauntletRepository gauntletRepository;

    public GauntletService(GauntletRepository gauntletRepository) {
        this.gauntletRepository = gauntletRepository;
    }

    public Gauntlet saveGauntlet(Gauntlet gauntlet){
        return gauntletRepository.save(gauntlet);
    }

    public Gauntlet getGauntletById(Long id){
        return gauntletRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Gauntlet not found with id" + id));
    }

    public List<Gauntlet> getAllGauntlets(){
        return gauntletRepository.findAll();
    }

    public Gauntlet updateGauntletById(Long id, Gauntlet gauntlet){
        return gauntletRepository.findById(id)
                .map(entity -> {
                    entity.setOwner(gauntlet.getOwner());
                    return gauntletRepository.save(entity);
                }).orElseThrow(() -> new EntityNotFoundException("Gauntlet not found with id" + id));
    }

    public void deleteGauntletById(Long id){
        Gauntlet gauntlet = gauntletRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Gauntlet not found with id" + id));
        gauntletRepository.delete(gauntlet);
    }

    public void deleteAllGauntlets(){
        gauntletRepository.deleteAll();
    }
}
