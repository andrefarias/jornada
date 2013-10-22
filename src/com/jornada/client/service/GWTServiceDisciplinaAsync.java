package com.jornada.client.service;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.jornada.shared.classes.Disciplina;

public interface GWTServiceDisciplinaAsync {

	public void adicionarDisciplina(Disciplina disciplina, AsyncCallback<Boolean> callback);
	
}