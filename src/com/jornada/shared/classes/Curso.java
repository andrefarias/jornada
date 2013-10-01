package com.jornada.shared.classes;

import java.io.Serializable;
import java.util.Date;

public class Curso implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int idCurso;
	private String nome;
	private String descricao;
	private String ementa;
	private Date dtInicio;
	private Date dtFim;

//	public static String DB_INSERT_CURSO = "INSERT INTO curso (nome_curso, descricao, ementa, data_inicial, data_final) VALUES (?,?,?,?,?)";
//	public static String DB_UPDATE_CURSO = "UPDATE curso set nome_curso=?, descricao=?, ementa=?, data_inicial=?, data_final=? where id_curso=?";
	public static String DB_INSERT_CURSO = "INSERT INTO curso (nome_curso, descricao, ementa) VALUES (?,?,?)";
	public static String DB_UPDATE_CURSO = "UPDATE curso set nome_curso=?, descricao=?, ementa=? where id_curso=?";	
	public static String DB_SELECT_CURSO = "SELECT * FROM curso";

	public Curso() {
	}
	
	public int getIdCurso() {
		return idCurso;
	}

	public void setIdCurso(int idCurso) {
		this.idCurso = idCurso;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getEmenta() {
		return ementa;
	}

	public void setEmenta(String ementa) {
		this.ementa = ementa;
	}

//	public Date getDtInicio() {
//		return dtInicio;
//	}
//
//	public void setDtInicio(Date dtInicio) {
//		this.dtInicio = dtInicio;
//	}
//
//	public Date getDtFim() {
//		return dtFim;
//	}
//
//	public void setDtFim(Date dtFim) {
//		this.dtFim = dtFim;
//	}

}
