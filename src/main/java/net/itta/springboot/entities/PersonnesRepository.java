/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.itta.springboot.entities;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;


@Transactional
public interface PersonnesRepository extends CrudRepository<Personne, Integer>{
   
    @Query("select p from Personne p where p.nom LIKE :nom% ORDER BY p.prenom")
    List<Personne> litPersonParNom(@Param("nom") String nom);
    
    List<Personne> findPersonneByNom(String name);
    
    List<Personne> findPersonneByNomAndPrenom(String nom, String prenom);
    
    List<Personne> findPersonneByNomIgnoreCaseOrderByPrenomDesc(String nom);
     
    List<Personne> findPersonneDistinctByNomIgnoreCase(String nom);
    
    Page<Personne> findAll(Pageable pageable);
    
    List<Personne> findAll(Sort sort);

    @Query("select p from Personne p join fetch p.voitures v where p.id = :id")
    Personne findByIdEager(@Param("id") Integer id);
}
