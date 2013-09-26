package com.jornada.server.service;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.jornada.client.service.GWTServicePeriodo;
import com.jornada.shared.classes.Periodo;
import com.jornada.shared.database.JornadaDataBase;

public class GWTServicePeriodoImpl extends RemoteServiceServlet implements
		GWTServicePeriodo {

	@Override
	public Boolean AdicionarPeriodo(Periodo periodo) {
		
		Boolean isOperationDone = false; 
		
		JornadaDataBase dataBase = new JornadaDataBase();

		try {
			dataBase.open();
			Connection conn = dataBase.getConnection();
			
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
			dataBase.close();
			
		}
		
		return isOperationDone;
	}

}
