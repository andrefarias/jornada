package com.jornada.client.adminescola;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.jornada.client.MainView;
import com.jornada.client.MainViewComponent;
import com.jornada.client.adminescola.ViewAdminEscola;

public class AdminEscolaUsuario extends Composite {
	
	VerticalPanel vPanelMain = new VerticalPanel(); 
	VerticalPanel vPanel1 = new VerticalPanel(); 
	VerticalPanel vPanel2 = new VerticalPanel(); 
	MainView mainView;
	
	public AdminEscolaUsuario(MainView mainView) {		
		
		this.mainView=mainView;

		
		String strTitle = "Usuarios";
		String strImageAddress = "images/Actions-list-add-user-icon_128.png";
		String strText = "Adicionar e Alterar Usuarios: \n";
		strText+="- Professores.\n";
		strText+="- Pais.\n";
		strText+="- Alunos.";
		
		MainViewComponent mainViewComponent = new MainViewComponent(strTitle, strImageAddress, strText);	
		mainViewComponent.flexTable.addClickHandler(new addClickHandler());		
	
		initWidget(mainViewComponent);

	}
	

	
	private class addClickHandler implements ClickHandler{

		@Override
		public void onClick(ClickEvent event) {
			mainView.openAdminEscola();
			
		}
		
	}
	
	
	
	
	

	
	
	

}
