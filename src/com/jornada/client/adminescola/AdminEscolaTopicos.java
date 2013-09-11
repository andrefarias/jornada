package com.jornada.client.adminescola;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.jornada.client.MainView;
import com.jornada.client.MainViewComponent;
import com.jornada.client.adminescola.ViewAdminEscola;

public class AdminEscolaTopicos extends Composite {
	
	VerticalPanel vPanelMain = new VerticalPanel(); 
	VerticalPanel vPanel1 = new VerticalPanel(); 
	VerticalPanel vPanel2 = new VerticalPanel(); 
	MainView mainView;
	
	public AdminEscolaTopicos(MainView mainView) {		
		
		this.mainView=mainView;

		
		String strTitle = "Topicos";
		String strImageAddress = "images/type_list_128.png";
		String strText = "Adicionar e Alterar Topicos: \n";
		strText+="- Exemplo 01) Geometria Analitica.\n";
		strText+="- Exemplo 02) Geometria Plana.";
		
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
