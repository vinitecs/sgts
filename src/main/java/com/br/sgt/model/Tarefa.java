package com.br.sgt.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Tarefa {
	
	@JsonProperty
	private Integer tarefaId;
	
	@JsonProperty
	private String descricao;

	@JsonProperty
	private String prioridade;
	
	@JsonProperty
	private String situacao;

	public Integer getTarefaId() {
		return tarefaId;
	}

	public void setTarefaId(Integer tarefaId) {
		this.tarefaId = tarefaId;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getPrioridade() {
		return prioridade;
	}

	public void setPrioridade(String prioridade) {
		this.prioridade = prioridade;
	}

	public String getSituacao() {
		return situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}
	
	
	
}
