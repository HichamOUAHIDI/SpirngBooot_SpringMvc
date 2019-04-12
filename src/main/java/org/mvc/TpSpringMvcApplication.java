package org.mvc;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.mvc.dao.EtudiantRepository;
import org.mvc.entites.Etudiant;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

@SpringBootApplication
public class TpSpringMvcApplication {

	public static void main(String[] args) throws ParseException {
		ApplicationContext ctx=SpringApplication.run(TpSpringMvcApplication.class, args);
	    EtudiantRepository etudiantRepository=ctx.getBean(EtudiantRepository.class);
	    DateFormat df=new SimpleDateFormat("yyyy-MM-dd");
//	    etudiantRepository.save(new Etudiant("hicham",df.parse("1993-12-12"),"hich.ouah@gmail.com","hicham.jpg"));
//	    etudiantRepository.save(new Etudiant("mohammed",df.parse("1993-12-12"),"mohammed@gmail.com","mohammed.jpg"));
//	    etudiantRepository.save(new Etudiant("khalid",df.parse("1993-12-12"),"khalid@gmail.com","hicham.jpg"));
//	    etudiantRepository.save(new Etudiant("rachid",df.parse("1993-12-12"),"rachid@gmail.com","mohammed.jpg"));
//	    etudiantRepository.save(new Etudiant("farid",df.parse("1993-12-12"),"farid@gmail.com","hicham.jpg"));
//	    etudiantRepository.save(new Etudiant("amine",df.parse("1993-12-12"),"amine@gmail.com","mohammed.jpg"));
//	    etudiantRepository.save(new Etudiant("hicham",df.parse("1993-12-12"),"walid@gmail.com","hicham.jpg"));
//	    etudiantRepository.save(new Etudiant("fouad",df.parse("1993-12-12"),"fouadgmail.com","mohammed.jpg"));
	    
	    Page<Etudiant> etds=etudiantRepository.chercherEtudiants("%r%",new PageRequest(0, 5));
	    etds.forEach(e->System.out.println(e.getNom()));
	}
}
