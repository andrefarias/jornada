package com.jornada.server.service;

import java.sql.Connection;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.jornada.client.service.GWTServiceDisciplina;
import com.jornada.shared.classes.Disciplina;
import com.jornada.shared.database.JornadaDataBase;

public class GWTServiceDisciplinaImpl extends RemoteServiceServlet implements
		GWTServiceDisciplina {

	@Override
	public Boolean adicionarDisciplina(Disciplina disciplina) {

		Boolean isOperationDone = false;

		JornadaDataBase db = new JornadaDataBase();

		try {
			db.open();
			Connection conn = db.getConnection();

		} catch (Exception ex) {
			System.err.println(ex.getMessage());
		} finally {
			db.close();
		}

		return null;
	}

}