package com.jornada.shared.classes;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.jornada.shared.database.JornadaDataBase;

public class Curso implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int idCurso;
	private String nome;
	private String descricao;
	private String ementa;
	
    public static String DB_INSERT_CURSO = "INSERT INTO curso (nome_curso, descricao, ementa) VALUES (?,?,?)";
    public static String DB_UPDATE_CURSO = "UPDATE curso set nome_curso=?, descricao=?, ementa=? where id_curso=?";	
	
	
	public Curso(){
		
	}
	
	
	public boolean AdicionarCurso(Curso curso) 
	{
		boolean isOperationDone=false;
//		JornadaDataBase dataBase = new JornadaDataBase();
//		
//		try
//		{			
//			dataBase.open();
//			Connection connection = dataBase.getConnection();
//			
//			PreparedStatement updateCurso = connection.prepareStatement(DB_UPDATE_CURSO);
//            int count = 0;
//            updateCurso.setString(++count, curso.getNome());
//            updateCurso.setString(++count, curso.getDescricao());
//            updateCurso.setString(++count, curso.getEmenta());		
//            updateCurso.setInt(++count, curso.getIdCurso());
//            
//            int numberUpdate = updateCurso.executeUpdate();  
//            
//            if (numberUpdate == 0)
//            {
//            	count=0;
//            	PreparedStatement insertCurso = connection.prepareStatement(DB_INSERT_CURSO);
//                insertCurso.setString(++count, curso.getNome());
//                insertCurso.setString(++count, curso.getDescricao());
//                insertCurso.setString(++count, curso.getEmenta());		            	
//                numberUpdate = updateCurso.executeUpdate();
//            }	
//					
//			
//			if(numberUpdate==1){
//				isOperationDone=true;
//			}
//			
//		}catch (SQLException sqlex){
//			System.err.println(sqlex.getMessage());
//		}
//		finally{
//			dataBase.close();		
//		}
		
		return isOperationDone;
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
	
	
	
	
	

}
