package com.jornada.client.service;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.jornada.shared.classes.Periodo;

public interface GWTServicePeriodoAsync {

	public void AdicionarPeriodo(Periodo periodo,
			AsyncCallback<Boolean> callback);

}
