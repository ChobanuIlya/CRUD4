package com.example.crud4.service;

import com.example.crud4.entity.Stone;
import com.example.crud4.repository.StoneRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class StoneService {

    private final StoneRepository stoneRepository;

    public StoneService(StoneRepository stoneRepository) {
        this.stoneRepository = stoneRepository;
    }

    public Stone saveStone(Stone stone){
        return stoneRepository.save(stone);
    }

    public Stone getStoneById(Long id){
        return stoneRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Stone not found with id" + id));
    }

    public List<Stone> getAllStones(){
        return stoneRepository.findAll();
    }

    public Stone updateStoneById(Long id, Stone stone){
        return stoneRepository.findById(id)
                .map(entity -> {
                    entity.setPower(stone.getPower());
                    entity.setColor(stone.getColor());
                    return stoneRepository.save(entity);
                }).orElseThrow(() -> new EntityNotFoundException("Stone not found with id" + id));
    }

    public void deleteStoneById(Long id){
        Stone stone = stoneRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Stone not found with id" + id));
        stoneRepository.delete(stone);
    }
    public void deleteAllStones(){
        stoneRepository.deleteAll();
    }
}
