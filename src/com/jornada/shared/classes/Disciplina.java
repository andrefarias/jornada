package com.jornada.shared.classes;

import java.io.Serializable;

public class Disciplina implements Serializable {

	private int idDisciplina;
	private String nomeDisciplina;
	private int cargaHoraria;
	private String descricao;
	private String ementa;
	private String objetivo;
	private int idUsuario;
	private int idPeriodo;

	public static String DB_SELECT_TODAS_DISCIPLINAS = "SELECT * FROM Disciplina ORDER BY nome_disciplina ASC";
	public static String DB_SELECT_DISCIPLINAS_POR_PERIODO = "SELECT * FROM Disciplina WHERE id_periodo = ? ORDER BY nome_disciplina ASC";
	public static String DB_INSERT_DISCIPLINA = "INSERT INTO Disciplina (nome_disciplina, carga_horaria, descricao, ementa, objetivo, id_usuario, id_periodo) VALUES (?, ?, ?, ?, ?, ?, ?)";
	public static String DB_UPDATE_DISCIPLINA = "UPDATE Disciplina SET nome_disciplina = ?, carga_horaria = ?, descricao = ?, ementa = ?, objetivo = ?, id_usuario = ?, id_periodo = ? WHERE id_disciplina = ?";

	public int getIdDisciplina() {
		return idDisciplina;
	}

	public void setIdDisciplina(int idDisciplina) {
		this.idDisciplina = idDisciplina;
	}

	public String getNomeDisciplina() {
		return nomeDisciplina;
	}

	public void setNomeDisciplina(String nomeDisciplina) {
		this.nomeDisciplina = nomeDisciplina;
	}

	public int getCargaHoraria() {
		return cargaHoraria;
	}

	public void setCargaHoraria(int cargaHoraria) {
		this.cargaHoraria = cargaHoraria;
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

	public String getObjetivo() {
		return objetivo;
	}

	public void setObjetivo(String objetivo) {
		this.objetivo = objetivo;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public int getIdPeriodo() {
		return idPeriodo;
	}

	public void setIdPeriodo(int idPeriodo) {
		this.idPeriodo = idPeriodo;
	}

}