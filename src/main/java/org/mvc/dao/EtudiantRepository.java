package org.mvc.dao;

import java.util.Date;
import java.util.List;

import org.mvc.entites.Etudiant;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
@RepositoryRestResource
public interface EtudiantRepository
extends JpaRepository<Etudiant,Long> {
	//public List<Etudiant> findByNom(String n);
	public Page<Etudiant> findByNom(String n,Pageable pageable);
	@Query("select e from Etudiant e where e.nom like :x")
	public Page<Etudiant> chercherEtudiants(@Param("x")String mc,Pageable pageable);
	
	@Query("select e from Etudiant e where e.dateNaissance >:x and e.dateNaissance <:y")
	public List<Etudiant> chercherEtuBydate(@Param("x")Date d1,@Param("y")Date d2);
}
