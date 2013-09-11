package com.jornada.client;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.jornada.client.adminescola.ViewAdminEscola;

public class MainViewAdminEscola extends Composite {
	
	VerticalPanel vPanelMain = new VerticalPanel(); 
	VerticalPanel vPanel1 = new VerticalPanel(); 
	VerticalPanel vPanel2 = new VerticalPanel(); 
	MainView mainView;
	
	public MainViewAdminEscola(MainView mainView) {		
		
		this.mainView=mainView;

		
		String strTitle = "Administracao";
		String strImageAddress = "images/blockdevice.png";
		String strText = "Adicionar e Alterar: \n";
		strText+="- Cursos, Disciplinas e M\u00F3dulos.\n";
		strText+="- Professores, Pais e Alunos.";
		
		MainViewComponent mainViewComponent = new MainViewComponent(strTitle, strImageAddress, strText);	
		mainViewComponent.flexTable.addClickHandler(new addClickHandler());		
	
		initWidget(mainViewComponent);

	}
	

	
	private class addClickHandler implements ClickHandler{

		@Override
		public void onClick(ClickEvent event) {
			//mainView.openAdminEscola();
			History.newItem("Admin");
//		    String initToken = History.getToken();
//		    if (initToken.length() == 0) {
//		      History.newItem("Admin");
//		    }

			
		}
		
	}
	
	
	
	
	

	
	
	

}
