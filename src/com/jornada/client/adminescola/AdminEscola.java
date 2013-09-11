package com.jornada.client.adminescola;

import com.google.gwt.user.client.History;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Grid;
import com.jornada.client.MainView;
import com.jornada.client.MainViewComunicadosEscola;
import com.jornada.client.MainViewFerramentaProfessor;
import com.jornada.client.MainViewTrabalhoProvas;

public class AdminEscola extends Composite {

	

	

	
		
	AdminEscolaCurso adminEscolaCurso;
	AdminEscolaPeriodo adminEscolaPeriodo;
	AdminEscolaDisciplina adminEscolaDisciplina;
	AdminEscolaConteudoProgramatico adminEscolaConteudoProgramatico;
	AdminEscolaTopicos adminEscolaTopicos;
	AdminEscolaUsuario adminEscolaUsuarios;	


	VerticalPanel verticalPanel;
	HorizontalPanel horizontalPanel_1;
	HorizontalPanel horizontalPanel_2;
	HorizontalPanel horizontalPanel_3;	
	
	Grid grid;
	
	MainView mainView;

	public AdminEscola(MainView mainView) {
		
		this.mainView = mainView;		
		
		adminEscolaCurso = new AdminEscolaCurso(mainView);
		adminEscolaPeriodo = new AdminEscolaPeriodo(mainView);
		adminEscolaDisciplina = new AdminEscolaDisciplina(mainView);
		adminEscolaConteudoProgramatico = new AdminEscolaConteudoProgramatico(mainView);
		adminEscolaTopicos = new AdminEscolaTopicos(mainView);
		adminEscolaUsuarios = new AdminEscolaUsuario(mainView);
	
		verticalPanel = new VerticalPanel();
		verticalPanel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		verticalPanel.setSize("100%", "100%");
		
		grid = new Grid(2, 3);
		grid.setCellSpacing(10);
		grid.setCellPadding(10);
		grid.setWidget(0, 0, adminEscolaCurso);
		grid.setWidget(0, 1, adminEscolaPeriodo);
		grid.setWidget(0, 2, adminEscolaDisciplina);
		grid.setWidget(1, 0, adminEscolaConteudoProgramatico);
		grid.setWidget(1, 1, adminEscolaTopicos);
		grid.setWidget(1, 2, adminEscolaUsuarios);
		
		verticalPanel.add(grid);
		
		initWidget(verticalPanel);
		
		
	}

}
