package com.example.demo;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.SQLException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.jdbc.core.ResultSetExtractor;
@Component
public class JdbcTemp {
	
	
	private JdbcTemplate jdbcTemplateObject;
	
	@Autowired
	public void setJdbcTemplateObject(JdbcTemplate jdbcTemplateObject) {
		this.jdbcTemplateObject= jdbcTemplateObject;
	}
	
	
	public int insertStrumento(String nome, String marca, double prezzo, String url, int pezzi, int pezziV) {
		String query = "INSERT INTO strumenti (nome, marca, prezzo, url, pezzi, pezziV) VALUES (?, ?, ?, ?, ?, ?)";
		return jdbcTemplateObject.update(query, nome, marca, prezzo, url, pezzi, pezziV);
	}
	
	public int updatePezzi(String nome, int pezzi) {
		String query = "UPDATE strumenti SET pezzi = pezzi + (?) WHERE nome = (?)";
		return jdbcTemplateObject.update(query, pezzi, nome);
	}
	
	public int updatePrezzo(String nome, double prezzo) {
		String query = "UPDATE strumenti SET prezzo = (?) WHERE nome=(?)";
		return jdbcTemplateObject.update(query, prezzo, nome);
	}
	
/*	public ArrayList<Strumenti> getLista() {
		String query = "SELECT * FROM strumenti";
		
		return jdbcTemplateObject.update(query, new ResultSetExtractor<ArrayList<Strumenti>>() {
			@Override
			public ArrayList<Strumenti> extractData(ResultSet rs) throws SQLException, DataAccessException {
				 ArrayList<Strumenti> listaS = new ArrayList<>();

	                // Itera sui risultati della query e crea un nuovo oggetto pc per ciascun record.
	                while (rs.next()) {
	                	Strumenti s1 = new Strumenti();
	                    s1.setNome(rs.getString("nome"));
	                    s1.setMarca(rs.getString("marca"));
	                    s1.setPrezzo(rs.getDouble("prezzo"));
	                    s1.setUrl(rs.getString("url"));
	                    s1.setUrl(rs.getString("url"));
	                	
	 
	                    listaS.add(s1);
	                }

	                return listaS;
			}
		});
	}*/
	 public ArrayList<Strumenti> getLista() {
	        String query = "SELECT * FROM strumenti";

	        return jdbcTemplateObject.query(query, new ResultSetExtractor<ArrayList<Strumenti>>() {
	        	@Override
	            public ArrayList<Strumenti> extractData(ResultSet rs) throws SQLException, DataAccessException {
	                ArrayList<Strumenti> listaS = new ArrayList<>();

	               
	                while (rs.next()) {
	                	Strumenti s1 = new Strumenti();
	                    s1.setNome(rs.getString("nome"));
	                    s1.setMarca(rs.getString("marca"));
	                    s1.setPrezzo(rs.getDouble("prezzo"));
	                    s1.setUrl(rs.getString("url"));
	                	
	 
	                    listaS.add(s1);
	                }

	                return listaS;
	            }
	        });
	    }
	 
	 public int updateUrl(String nome, String url) {
		 String query = "UPDATE strumenti SET url = ? WHERE nome= ?";
		 return jdbcTemplateObject.update(query, url, nome);
	 }
	 
	 public int change(String nome, int pezzi) {
	    	String query= "UPDATE strumenti SET pezzi = pezzi - (?) WHERE nome = (?)";
	    	jdbcTemplateObject.update(query, pezzi, nome);
	    	String query1 = "UPDATE strumenti SET pezziV = pezziV+ (?) WHERE nome=(?)";
	    	return jdbcTemplateObject.update(query1, pezzi, nome);
	    }
	    
}
