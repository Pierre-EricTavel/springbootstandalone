/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.itta.springboot.entities;


import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import lombok.*;

@Setter
@Getter
@ToString(exclude ="voitures" )
@Entity
@Table(name = "personnes")
public class Personne implements Serializable {
    @Id
    private Integer id;
    @Column
    private String nom;
    @Column
    private String prenom;
    @Column
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date naissance;

    @OneToMany( cascade = {CascadeType.PERSIST, CascadeType.REFRESH})//mappedBy = "proprietaire",
    @JoinColumn(name = "proprietaireID")
    private List<Voiture> voitures;
    
    public Personne(Integer id, String nom, String prenom, Date naissance) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.naissance = naissance;
    }

    public Personne() {
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Personne other = (Personne) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    public void addVoiture(Voiture voiture) {
        
    }
    
    
    
}
