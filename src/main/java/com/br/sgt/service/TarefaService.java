package com.br.sgt.service;

import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.sgt.base.Services;
import com.br.sgt.dao.TarefaDAO;
import com.br.sgt.exception.Exception;
import com.br.sgt.model.Tarefa;
import com.google.gson.Gson;



@Service
@Path("/")
public class TarefaService extends Services {
	
	
	/*
	 * API rest utilizada  Foi JERSEY 
	 * por padrão qualquqer requisição for chamada tem que ser iniciado por http://localhost:8080/sgt
	 * 
	 * Endpoints e seus content types:
	 *  
	 *           '/insert' content-type = application/json
	 *           '/concluir_tarefa' content-type = x-www-form-url-encoded
	 *           
	 *           ENDPOINTS restantes padrão GET e DELETE Mesmo
	 * 
	 * */
	
	@Autowired
    Gson gson;
	
	@Autowired
	protected TarefaDAO dao;
	
	
	@POST
	@Path("/insert")
	@Produces({MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_JSON})
	public String  insertTarefa(Tarefa tar) {
		Exception exc = new  Exception();
		
		Tarefa taref = (Tarefa) dao.insert(tar);
		exc.setDescrption("tarefa cadastrada com sucesso id: " +taref.getTarefaId());
		exc.setStatus(200);
		
		return gson.toJson(exc);  
	}
	

	
	@GET
	@Path("/list_tarefas")
	@Produces({MediaType.APPLICATION_JSON})
	public Object listTarefa() {
		return  (ArrayList<Tarefa>) dao.getAll();
	}
	
	@GET
	@Path("/lista_tarefas_pendentes")
	@Produces({MediaType.APPLICATION_JSON})
	public String listTarefaPendente() {			
		return gson.toJson(dao.getByFilter("PENDENTE"));
	}
	
	
	@DELETE
	@Path("/delete")
	@Produces({MediaType.APPLICATION_JSON})	
	public String deleteTarefa(@QueryParam("tarefaId") Integer tarefaId) {
		
	Integer result = (Integer)	dao.remove(tarefaId) ;
		
		Exception exc = new  Exception();
		
		if(result == 0) {
			exc.setDescrption("Operação não foi Realizada ");
			exc.setStatus(405);	
			
			  throw new WebApplicationException(Response
				        .status(Status.METHOD_NOT_ALLOWED)
				        .type(MediaType.APPLICATION_JSON)
				        .entity(gson.toJson(exc))
				        .build());
			
		}
		
		
		if(result == -1) {
			
			exc.setDescrption("Operação não foi Realizada ");
			exc.setStatus(500);	
			
			  throw new WebApplicationException(Response
				        .status(Status.BAD_REQUEST)
				        .type(MediaType.APPLICATION_JSON)
				        .entity(gson.toJson(exc))
				        .build());
		}
	
			exc.setDescrption("Operação Realizada Com sucesso");
			exc.setStatus(200);			
			return 	gson.toJson(exc) ;	
		
		
		
	}
	
	@POST
	@Path("/concluir_tarefa")
	@Produces({MediaType.APPLICATION_JSON})
	public Object concluirTarefa(@FormParam("tarefaId") Integer tarefaId) {
		
		Integer result = (Integer) dao.update(tarefaId);
		
		Exception exc = new  Exception();
		
		if(result == 0) {
			exc.setDescrption("Operação não foi Realizada ");
			exc.setStatus(405);	
			
			  throw new WebApplicationException(Response
				        .status(Status.METHOD_NOT_ALLOWED)
				        .type(MediaType.APPLICATION_JSON)
				        .entity(gson.toJson(exc))
				        .build());
			
		}
		
		
		if(result == -1) {
			
			exc.setDescrption("Operação não foi Realizada ");
			exc.setStatus(500);	
			
			  throw new WebApplicationException(Response
				        .status(Status.BAD_REQUEST)
				        .type(MediaType.APPLICATION_JSON)
				        .entity(gson.toJson(exc))
				        .build());
		}
	
			exc.setDescrption("Operação Realizada Com sucesso");
			exc.setStatus(200);			
			return 	gson.toJson(exc) ;	
			
	}
		
		
		
		
	
	

}
