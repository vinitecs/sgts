package com.br.sgt.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;


import com.br.sgt.base.DAO;
import com.br.sgt.base.Model;
import com.br.sgt.model.Tarefa;

@Repository
public class TarefaDAO extends DAO {


	public static RowMapper<Tarefa> listTarefas= new RowMapper<Tarefa>() {
	public Tarefa mapRow(ResultSet rs, int rowNum) throws SQLException {
		Tarefa tar = new Tarefa();
		tar.setTarefaId(rs.getInt("TAREFA_ID"));
		tar.setDescricao(rs.getString("TAREFA_DESCRICAO"));
		tar.setPrioridade(rs.getString("TAREFA_PRIORIDADE"));
		tar.setSituacao(rs.getString("TAREFA_SITUACAO"));
		return tar;
	}
	};

	@Override
	public Object insert(Tarefa tar) {
		String sql = " INSERT INTO TAREFA ( "										   
								           + " 	TAREFA_DESCRICAO "
								           + " 	,TAREFA_PRIORIDADE "
								           + " 	,TAREFA_SITUACAO "
								           + " 	) "
								           + " VALUES ( "								        
								           + " 	 :TAREFA_DESCRICAO "
								           + " 	,:TAREFA_PRIORIDADE "
								           + " 	,:TAREFA_SITUACAO  "
								           + "  ) ";
		
		fillParameters(tar);		
		
		KeyHolder keyHolder = new GeneratedKeyHolder();
		
		namedJdbcTemplate.update(sql, parameters, keyHolder, new String[]{"tarefa_id"});
		
		tar.setTarefaId(keyHolder.getKey().intValue());
		
		return tar;
	}

	@Override
	public Object update(Integer tarId) {
		String sql = " UPDATE TAREFA "
		           + " SET tarefa_situacao = 'CONCLUIDO' "
		           + " WHERE TAREFA_ID = :TAREFA_ID";
		
		parameters = new MapSqlParameterSource();	
		parameters.addValue("TAREFA_ID", tarId);	
		
	 return namedJdbcTemplate.update(sql, parameters);
	}

	@Override
	public ArrayList<Tarefa> getAll() {
		String sql = " SELECT * "
		           + " FROM TAREFA ";
		
		return (ArrayList<Tarefa>) jdbcTemplate.query(sql,listTarefas);
	}

	@Override
	public Object findById(Integer tarId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Tarefa> getByFilter(String situacao) {
		
	
		String sql = " SELECT * "
		           + " FROM TAREFA "
		           + " WHERE TAREFA_SITUACAO = :SITUACAO ";
		
		parameters = new MapSqlParameterSource();	
		parameters.addValue("SITUACAO", situacao);	
		
		System.out.println(sql);
		return (ArrayList<Tarefa>) namedJdbcTemplate.query(sql, parameters,listTarefas);
	}

	@Override
	public Object remove(Integer tarId) {
		
		String sql = " DELETE "
		           + " FROM TAREFA TAR "
		           + " WHERE TAR.TAREFA_ID = :TAREFA_ID ";
		
		parameters = new MapSqlParameterSource();	
		parameters.addValue("TAREFA_ID", tarId);	
		
		return namedJdbcTemplate.update(sql, parameters);
	}

	@Override
	protected void fillParameters(Tarefa tar) {
		parameters = new  MapSqlParameterSource();	
		parameters.addValue("TAREFA_ID",  null);
		parameters.addValue("TAREFA_DESCRICAO", tar.getDescricao());
		parameters.addValue("TAREFA_PRIORIDADE", tar.getPrioridade());
		parameters.addValue("TAREFA_SITUACAO", tar.getSituacao());		
	}

	@Override
	public Object delete(Integer tarefaId) {
		
		return null;
	}

}
