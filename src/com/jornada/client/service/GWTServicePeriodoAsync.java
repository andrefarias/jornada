package com.jornada.client.service;

import java.util.List;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.jornada.shared.classes.Periodo;

public interface GWTServicePeriodoAsync {

	public void AdicionarPeriodo(Periodo periodo,
			AsyncCallback<Boolean> callback);
	
	public void getPeriodos(AsyncCallback<List<Periodo>> callback);
	
	public void getPeriodosByCurso(int idCurso, AsyncCallback<List<Periodo>> callback);

}