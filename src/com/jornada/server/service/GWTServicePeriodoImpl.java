package com.jornada.server.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.jornada.client.service.GWTServicePeriodo;
import com.jornada.shared.classes.Periodo;
import com.jornada.shared.database.JornadaDataBase;

public class GWTServicePeriodoImpl extends RemoteServiceServlet implements
		GWTServicePeriodo {

	@Override
	public Boolean AdicionarPeriodo(Periodo periodo) {
		
		Boolean isOperationDone = false; 
		
		JornadaDataBase db = new JornadaDataBase();

		try {
			db.open();
			Connection conn = db.getConnection();
			
			int param = 0;
			PreparedStatement pstmtUpdatePeriodo = conn.prepareStatement(Periodo.DB_UPDATE_PERIODO);
			pstmtUpdatePeriodo.setString(++param, periodo.getNomeModulo());
			pstmtUpdatePeriodo.setString(++param, periodo.getDescricao());
			pstmtUpdatePeriodo.setString(++param, periodo.getNumeracao());
			pstmtUpdatePeriodo.setString(++param, periodo.getObjetivo());
			pstmtUpdatePeriodo.setInt(++param, periodo.getIdCurso());
			
			int numberUpdate = pstmtUpdatePeriodo.executeUpdate();
			
			if(numberUpdate == 0)
			{
				param = 0;
				PreparedStatement pstmtInsertPeriodo = conn.prepareStatement(Periodo.DB_INSERT_PERIODO);
				pstmtInsertPeriodo.setString(++param, periodo.getNomeModulo());
				pstmtInsertPeriodo.setString(++param, periodo.getDescricao());
				pstmtInsertPeriodo.setString(++param, periodo.getNumeracao());
				pstmtInsertPeriodo.setString(++param, periodo.getObjetivo());
				pstmtInsertPeriodo.setInt(++param, periodo.getIdCurso());
				
				numberUpdate = pstmtInsertPeriodo.executeUpdate();
			}
			
			if(numberUpdate == 1)
			{
				isOperationDone = true;
			}
			
		}
		catch(Exception ex)
		{
			System.err.println(ex.getMessage());
		}
		finally
		{
			db.close();
			
		}
		
		return isOperationDone;
	}

	@Override
	public List<Periodo> getPeriodos()
	{
		List<Periodo> listPeriodo = new ArrayList<Periodo>();
		
		JornadaDataBase db = new JornadaDataBase();
		
		try
		{
			db.open();
			Connection conn = db.getConnection();
			
			PreparedStatement pstmt = conn.prepareStatement(Periodo.DB_GET_PERIODO_LISTA);
			
			ResultSet rs = pstmt.executeQuery();
			Periodo periodo;
			while(rs.next())
			{
				periodo = new Periodo();
				periodo.setIdPeriodo(rs.getInt("id_periodo"));
				periodo.setNomeModulo(rs.getString("nome_modulo"));
				periodo.setDescricao(rs.getString("descricao"));
				periodo.setNumeracao(rs.getString("numeracao"));
				periodo.setObjetivo(rs.getString("objetivo"));
				periodo.setIdCurso(rs.getInt("id_curso"));
				listPeriodo.add(periodo);
			}
		}
		catch(Exception ex)
		{
			System.err.println(ex.getMessage());
		}
		
		return listPeriodo;
	}

	@Override
	public List<Periodo> getPeriodosByCurso(int idCurso) {
		List<Periodo> listPeriodo = new ArrayList<Periodo>();
		
		JornadaDataBase db = new JornadaDataBase();
		
		try
		{
			db.open();
			Connection conn = db.getConnection();
			
			int count = 0;
			PreparedStatement pstmt = conn.prepareStatement(Periodo.DB_GET_PERIODO_LISTA + " WHERE id_curso = ?");
			pstmt.setInt(count++, idCurso);
			
			ResultSet rs = pstmt.executeQuery();
			Periodo periodo;
			while(rs.next())
			{
				periodo = new Periodo();
				periodo.setIdPeriodo(rs.getInt("id_periodo"));
				periodo.setNomeModulo(rs.getString("nome_modulo"));
				periodo.setDescricao(rs.getString("descricao"));
				periodo.setNumeracao(rs.getString("numeracao"));
				periodo.setObjetivo(rs.getString("objetivo"));
				periodo.setIdCurso(rs.getInt("id_curso"));
				listPeriodo.add(periodo);
			}
		}
		catch(Exception ex)
		{
			System.err.println(ex.getMessage());
		}
		
		return listPeriodo;
	}
	
}