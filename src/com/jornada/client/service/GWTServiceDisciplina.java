package com.jornada.client.service;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.jornada.shared.classes.Disciplina;

@RemoteServiceRelativePath("GWTServiceDisciplina")
public interface GWTServiceDisciplina extends RemoteService {

	public Boolean adicionarDisciplina(Disciplina disciplina);
	
}