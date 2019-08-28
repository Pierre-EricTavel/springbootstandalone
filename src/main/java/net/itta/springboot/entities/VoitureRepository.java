package net.itta.springboot.entities;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface VoitureRepository extends CrudRepository<Voiture, Integer>{
}
