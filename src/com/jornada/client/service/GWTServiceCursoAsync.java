	package com.jornada.client.service;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.jornada.shared.classes.Curso;

public interface GWTServiceCursoAsync {

	public void AdicionarCurso(Curso curso, AsyncCallback callback);

}
