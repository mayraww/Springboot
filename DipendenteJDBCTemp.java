package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class DipendenteJDBCTemp {
    
	
	private JdbcTemplate jdbcTemplateObject;
	 
    @Autowired
    public void setJdbcTemplateObject(JdbcTemplate jdbcTemplateObject) {
        this.jdbcTemplateObject = jdbcTemplateObject;
    }
 
    public int insertDipendente(String cognome, String mansione, double stipendio) {
        String query = "INSERT INTO Dipendente (cognome, mansione, stipendio) VALUES (?, ?, ?)";
        return jdbcTemplateObject.update(query, cognome, mansione, stipendio);
    }
 
    /* public int deleteDipendente(int id) {
    	String query = "DELETE FROM Dipendente WHERE id = ?";
    	return jdbcTemplateObject.update(query, id);
		}*/
    public int deleteDipendente(String  cognome) {
    	String query = "DELETE FROM Dipendente WHERE cognome = ?";
    	return jdbcTemplateObject.update(query, cognome);
}
    
    public int updateCognome(String NuovoCognome, String cognome) {
        String query = "UPDATE Dipendente SET cognome = ? WHERE cognome = ?";
        return jdbcTemplateObject.update(query, NuovoCognome, cognome);
    }
 
    public int updateMansione(String NuovaMansione, String cognome) {
        String query = "UPDATE Dipendente SET mansione = ? WHERE cognome = ?";
        return jdbcTemplateObject.update(query, NuovaMansione, cognome);
    }
 
    public int updateStipendio(double NuovoStipendio, String cognome) {
        String query = "UPDATE Dipendente SET stipendio = ? WHERE cognome = ?";
        return jdbcTemplateObject.update(query, NuovoStipendio, cognome);
    }
 

  
 
    // Metodo per eseguire query DDL
    public void executeDDLQuery(String query) {
        jdbcTemplateObject.execute(query);
    }
}