package com.jornada.shared.classes;

import java.io.Serializable;

public class Periodo implements Serializable {

	private int idCurso;
	private String nomeModulo;
	private String descricao;
	private String numeracao;
	private String objetivo;
	
	public static String DB_INSERT_PERIODO = "INSERT INTO periodo (nome_modulo, descricao, numeracao, objetivo, id_curso) VALUES (?,?,?,?,?)";
	public static String DB_UPDATE_PERIODO = "UPDATE periodo set nome_modulo=?, descricao=?, numeracao=?, objetivo=? where id_curso=?";
	
	public Periodo()
	{}
	
	public int getIdCurso() {
		return idCurso;
	}
	public void setIdCurso(int idCurso) {
		this.idCurso = idCurso;
	}
	public String getNomeModulo() {
		return nomeModulo;
	}

	public void setNomeModulo(String nomeModulo) {
		this.nomeModulo = nomeModulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getNumeracao() {
		return numeracao;
	}

	public void setNumeracao(String numeracao) {
		this.numeracao = numeracao;
	}

	public String getObjetivo() {
		return objetivo;
	}

	public void setObjetivo(String objetivo) {
		this.objetivo = objetivo;
	}
	
}
