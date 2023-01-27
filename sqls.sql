

DROP TABLE IF EXISTS TAREFA;
CREATE TABLE TAREFA(
	TAREFA_ID SERIAL PRIMARY KEY NOT NULL,
	TAREFA_DESCRICAO VARCHAR ,
	TAREFA_PRIORIDADE VARCHAR,
	TAREFA_SITUACAO VARCHAR 
);


INSERT INTO
	TAREFA(TAREFA_DESCRICAO,TAREFA_PRIORIDADE,TAREFA_SITUACAO) 
	VALUES ('Exercicios as 15hs','ALTA','PENDENTE'),
	('Exercicios as 15hs','ALTA','PENDENTE'),
	('Faculdade as 13hs','ALTA','EXECUCAO'),
	('Jogo de futebol','ALTA','CONCLUIDO'),
	('Exercicios as 13hs','MEDIA','CONCLUIDO'),
	('Exercicios as 15hs','MEDIA','CONCLUIDO'),
	('Exercicios as 15hs','ALTA','PENDENTE'),
	('Exercicios as 15hs','MEDIA','PENDENTE')
	


SELECT * FROM TAREFA;
