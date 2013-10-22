package com.jornada.client.service;

import java.util.List;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.jornada.shared.classes.Periodo;

@RemoteServiceRelativePath("GWTServicePeriodo")
public interface GWTServicePeriodo  extends RemoteService {

	public Boolean AdicionarPeriodo(Periodo periodo);

	public List<Periodo> getPeriodos();
	
	public List<Periodo> getPeriodosByCurso(int idCurso);
}