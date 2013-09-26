package com.jornada.client.service;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.jornada.shared.classes.Periodo;

@RemoteServiceRelativePath("GWTServicePeriodo")
public interface GWTServicePeriodo  extends RemoteService {

	public Boolean AdicionarPeriodo(Periodo periodo);
	
}
