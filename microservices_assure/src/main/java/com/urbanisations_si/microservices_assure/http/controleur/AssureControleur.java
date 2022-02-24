package com.urbanisations_si.microservices_assure.http.controleur;

import java.net.URI;
import java.util.List;
import java.util.stream.StreamSupport;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.urbanisations_si.microservices_assure.configuration.ApplicationPropertiesConfiguration;
import com.urbanisations_si.microservices_assure.dao.AssureRepository;
import com.urbanisations_si.microservices_assure.modele.Assure;
 
@RestController  
@RequestMapping(path="/previt") 
public class AssureControleur {
	
	 @Autowired  
	 private AssureRepository assureRepository;
	 
	 @Autowired    
     ApplicationPropertiesConfiguration appProperties;
	 
	 @PostMapping(path="/ajouterAssure")
	 public ResponseEntity<Void> creerAssure(@Valid @RequestBody Assure assure) {
	        Assure assureAjoute = assureRepository.save(assure);

	             if (assureAjoute == null)
	                        return ResponseEntity.noContent().build();

	                URI uri = ServletUriComponentsBuilder
	                        .fromCurrentRequest()
	                        .path("/{id}")
	                        .buildAndExpand(assureAjoute.getId())
	                        .toUri();

	                return ResponseEntity.created(uri).build(); 
	    }


	    /*@GetMapping(path="/listerLesAssures")  
	    public @ResponseBody Iterable<Assure> getAllAssures() {
	        return assureRepository.findAll();
	    }*/
	 
	 @GetMapping(path="/listerLesAssures")
     public List<Assure> getAllAssures() {

        Iterable<Assure> assuresIterable = assureRepository.findAll();
        List assuresList = StreamSupport 
                .stream(assuresIterable.spliterator(), false) 
                .collect(Collectors.toList()); 
        List<Assure> listeLimitee = assuresList.subList(0, appProperties.getLimiteNombreAssure());
        return listeLimitee;
     }
	    
	   @DeleteMapping (path="/Assure/{id}")     
       public void supprimerAssurer(@PathVariable Integer id) {
		   assureRepository.deleteById(id);        
       }
	   
	   @PutMapping (path="/modifierAssure")    
       public void modifierAssure(@RequestBody Assure assure) {
		   assureRepository.save(assure);
	   }

}
