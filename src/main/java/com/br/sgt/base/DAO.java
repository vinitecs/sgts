package com.br.sgt.base;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import com.br.sgt.model.Tarefa;




	public abstract class DAO {

		
		protected  MapSqlParameterSource parameters;
		
		@Autowired
		protected NamedParameterJdbcTemplate namedJdbcTemplate; 

		@Autowired
		public  JdbcTemplate jdbcTemplate;
		
		
		
		
		abstract public Object insert(Tarefa tar); 
		
		abstract public Object update(Integer tarId);
		
		abstract public Object delete(Integer tarId);
		
		abstract public ArrayList<Tarefa> getAll();
		
		abstract public Object findById(Integer tarId);
		
		abstract public List<?> getByFilter(String situacao); 
		
		abstract public Object remove(Integer tarId);  
		
		abstract protected void fillParameters(Tarefa tar);
	}

