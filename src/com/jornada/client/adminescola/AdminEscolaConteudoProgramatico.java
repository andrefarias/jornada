package com.jornada.client.adminescola;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.jornada.client.MainView;
import com.jornada.client.MainViewComponent;
import com.jornada.client.adminescola.ViewAdminEscola;

public class AdminEscolaConteudoProgramatico extends Composite {
	
	VerticalPanel vPanelMain = new VerticalPanel(); 
	VerticalPanel vPanel1 = new VerticalPanel(); 
	VerticalPanel vPanel2 = new VerticalPanel(); 
	MainView mainView;
	
	public AdminEscolaConteudoProgramatico(MainView mainView) {		
		
		this.mainView=mainView;

		
		String strTitle = "Conteudo Programatico";
		String strImageAddress = "images/Text-Document-icon_128.png";
		String strText = "Adicionar e Alterar Conteudo: \n";
		strText+="- Exemplo 01) Trigonometria.\n";
		strText+="- Exemplo 02) Geometria.";
		
		MainViewComponent mainViewComponent = new MainViewComponent(strTitle, strImageAddress, strText);	
		mainViewComponent.flexTable.addClickHandler(new addClickHandler());		
	
		initWidget(mainViewComponent);

	}
	

	
	private class addClickHandler implements ClickHandler{

		@Override
		public void onClick(ClickEvent event) {
			mainView.openCadastroConteudoProgramatico();
			
		}
		
	}
	
	
	
	
	

	
	
	

}
