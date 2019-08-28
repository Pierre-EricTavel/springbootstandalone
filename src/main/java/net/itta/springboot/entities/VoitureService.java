package net.itta.springboot.entities;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Repository
public class VoitureService {
  
    @Autowired
    private  VoitureRepository repository;
    
    @Transactional
    public  Voiture save(Voiture p) {
        repository.save(p);
        return p;
    }
    
    @Transactional
    public  Voiture remove(Voiture p) {
        repository.delete(p);
        return p;
    }
    @Transactional
    public  void removeById(Integer id) {
        repository.deleteById(id);
    }
    Voiture getById(Integer i) {
       return  repository.findById(i).orElse(null);
    }
    
  
}