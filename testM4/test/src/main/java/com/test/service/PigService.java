package com.test.service;

import com.test.model.PigEntity;
import com.test.repository.IPigRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PigService {
    @Autowired
    private IPigRepository pigRepository;
    public List<PigEntity> showAll(){
        return pigRepository.findAll();
    }
    public PigEntity getPigById(int id){
        return pigRepository.findById(id).get();
    }
    public void createPig(PigEntity pig){
        if (getPigById(pig.getId()) != null){
            pigRepository.save(pig);
        }
    }
    public void deletePig(PigEntity pig){
        if (getPigById(pig.getId()) != null){
            pigRepository.delete(pig);
        }
    }
}
