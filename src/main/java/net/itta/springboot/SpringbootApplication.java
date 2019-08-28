package net.itta.springboot;

import java.util.Date;
import java.util.List;
import net.itta.springboot.entities.Personne;
import net.itta.springboot.entities.PersonnesRepository;
import net.itta.springboot.entities.PersonnesService;
import net.itta.springboot.entities.Voiture;
import net.itta.springboot.entities.VoitureRepository;
import net.itta.springboot.entities.VoitureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringbootApplication implements CommandLineRunner{

    @Autowired
    private PersonnesRepository personnesRepository;
    
    @Autowired
    private VoitureRepository voitureRepository;
    
    @Autowired
    private PersonnesService personneservice;
    
    @Autowired
    private VoitureService voitureService;
      
    public static void main(String[] args) {
        SpringApplication.run(SpringbootApplication.class, args);
        
    }

    @Override
    public void run(String... args) throws Exception {
         Personne p = new Personne(10, "albert", "duschmoll", new Date());
        Personne p1 = new Personne(20, "al", "einstein", new Date());
        Personne p2 = new Personne(30, "albert", "jean", new Date());
        Personne p3 = new Personne(40, "albert", "dupont", new Date());
        Personne p4 = new Personne(50, "al", "einstein", new Date());
        Personne p5 = new Personne(60, "albert", "jean", new Date());
        personnesRepository.save(p); personnesRepository.save(p1);
        personnesRepository.save(p2); personnesRepository.save(p3);
        personnesRepository.save(p4);        //personnesRepository.save(p5);
        Voiture v1 = new Voiture(1, "porsche", p);
        Voiture v2 = new Voiture(2, "bmw", p1);
        voitureService.save(v1);
        voitureService.save(v2);

        //personneservice.getByNom("al").forEach( System.out::println );
         personneservice.LitPersonneDistinctParNomIgnoreCase("ALBERT").forEach( System.out::println );
        //  personneservice.LitPersonneParNomAndPrenom("albert","jean").forEach( System.out::println );
        //  personneservice.LitPersonneParNomIgnoreCaseOrderParPrenomDesc("ALBERT").forEach( System.out::println );
        //   personneservice.getPersonnesByPage(1,4, Sort.Direction.DESC, "prenom").forEach( System.out::println );
        //personneservice.getPersonnesTrie(Sort.Direction.DESC, "prenom").forEach(System.out::println);
        p1=personneservice.getById_eager2(10);
        List<Voiture> lv= p1.getVoitures();
        System.out.println("******************************************************");
        lv.forEach(  System.out::println  );
        personneservice.saveBad(p5);
    }
    
    
}
