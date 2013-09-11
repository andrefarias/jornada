package com.jornada.client;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.widget.client.TextButton;
import com.google.gwt.user.client.ui.HasHorizontalAlignment.HorizontalAlignmentConstant;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.DecoratorPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Panel;
import com.google.gwt.user.client.ui.SimplePanel;
import com.jornada.client.adminescola.ViewAdminEscola;
import com.jornada.client.classes.FadeAnimation;
import com.smartgwt.client.widgets.layout.PortalLayout;
import com.smartgwt.client.widgets.layout.Portlet;

public class MainBody extends Composite {

	
	MainViewTrabalhoProvas trabalhoProvas = new MainViewTrabalhoProvas();
	MainViewComunicadosEscola comunicadosEscola = new MainViewComunicadosEscola();
	MainViewFerramentaProfessor ferramentaProfessor = new MainViewFerramentaProfessor();
	MainViewRecadosParaAluno recadosParaAluno = new MainViewRecadosParaAluno();
	MainViewNotasEscolares notasEscolares = new MainViewNotasEscolares();
	MainViewAdminEscola adminEscola;

	//PopupPanel1 pop1 = new PopupPanel1();
	
	VerticalPanel verticalPanel;
	HorizontalPanel horizontalPanel_1;
	HorizontalPanel horizontalPanel_2;
	HorizontalPanel horizontalPanel_3;	
	
	Grid grid;
	
	MainView mainView;

	public MainBody(MainView mainView) {
		
		this.mainView = mainView;
		
		
		adminEscola = new MainViewAdminEscola(mainView);
	
		verticalPanel = new VerticalPanel();
		verticalPanel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		verticalPanel.setSize("100%", "100%");
		
		grid = new Grid(2, 3);
		grid.setCellSpacing(10);
		grid.setCellPadding(10);
		grid.setWidget(0, 0, adminEscola);
		grid.setWidget(0, 1, trabalhoProvas);
		grid.setWidget(0, 2, comunicadosEscola);
		grid.setWidget(1, 0, ferramentaProfessor);
		grid.setWidget(1, 1, recadosParaAluno);
		grid.setWidget(1, 2, notasEscolares);			
		
		verticalPanel.add(grid);		
		
//		FadeAnimation fadeAnimation = new FadeAnimation(verticalPanel.getElement());
//		fadeAnimation.setOpacity(0.0);
//		verticalPanel.setVisible(true);
//		fadeAnimation.fade(1000, 1.0);	
		
		
		initWidget(verticalPanel);

		
		
	}

}
