package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MyController {

    private final DipendenteJDBCTemp dipendenteJDBCTemp;

    @Autowired
    public MyController(DipendenteJDBCTemp dipendenteJDBCTemp) {
        this.dipendenteJDBCTemp = dipendenteJDBCTemp;
    }
    @GetMapping("/")
    public String getForm() {
    	return "form";
    }
    

    @PostMapping("/inserisci-dipendente")
    public String inserisciDipendente(
            @RequestParam("cognome") String cognome,
            @RequestParam("mansione") String mansione,
            @RequestParam("stipendio") double stipendio) {
        dipendenteJDBCTemp.insertDipendente(cognome, mansione, stipendio);
        return "inserito"; //oppure redirect:/ per rimandare alla stessa pagina
    }
    
    
    @PostMapping("/cancella-dipendente")
    public String cancellaDipendente(@RequestParam("cognome") String cognome) {
    	
    	dipendenteJDBCTemp.deleteDipendente(cognome);
    	
    	return "delete";
    }
    
    @PostMapping("/modifica-cognome")
    public String modificaCognome(
    	 @RequestParam("NuovoCognome") String NuovoCognome,
    	 @RequestParam("cognome") String cognome) {
    	dipendenteJDBCTemp.updateCognome(NuovoCognome, cognome);
    	
    	return "update";
    }
    @PostMapping("/modifica-mansione")
    public String modificaMansione(
    	 @RequestParam("NuovaMansione") String NuovaMansione,
    	 @RequestParam("cognome") String cognome) {
    	dipendenteJDBCTemp.updateMansione(NuovaMansione, cognome);
    	
    	return "update";
    }
    @PostMapping("/modifica-stipendio")
    public String modificaStipendio(
    	 @RequestParam("NuovoStipendio") double NuovoStipendio,
    	 @RequestParam("cognome") String cognome) {
    	dipendenteJDBCTemp.updateStipendio(NuovoStipendio, cognome);
    	
    	return "update";
    }
}