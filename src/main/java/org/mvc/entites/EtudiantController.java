package org.mvc.entites;

import java.util.List;

import org.mvc.dao.EtudiantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value="/Etudiant")
public class EtudiantController {
@Autowired //cherhe moi un objet qui implement cette interface que tu es a deja crier auparavant et tu vas l'injecter 

private EtudiantRepository etudiantRepository;
// quand je vais tapé  un url qui se termine par /index il vas applé la methode index cette methode retourn le nom de la vue 

@RequestMapping(value="/index")
//@RequestParam je demande a dispatcherservelt de regarder dans l'objet request un paramette qui s'appel page 
public String Index(Model model,
		@RequestParam(name="page",defaultValue="0") int p,
		@RequestParam(name="motCle",defaultValue="") String mc) {
	 Page<Etudiant> pageEtudiant=etudiantRepository.chercherEtudiants("%"+mc+"%",new PageRequest(p, 5));
	 int pageCount=pageEtudiant.getTotalPages();
	 int[] pages=new int [pageCount];
	 for (int i=0;i<pageCount;i++)
		 pages[i]=i;
	 model.addAttribute("pages", pages);
	 model.addAttribute("pageEtudiants", pageEtudiant);
	 model.addAttribute("pageCourante",p);
	 model.addAttribute("motCle", mc);
	 return "etudiants";
 }

@RequestMapping(value="/form",method=RequestMethod.GET)
public String formEtudiant() {
	return "FormEtudiant";
}
}
