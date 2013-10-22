package com.jornada.client;

import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.widget.client.TextButton;
import com.google.gwt.user.client.ui.HasHorizontalAlignment.HorizontalAlignmentConstant;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.InlineHTML;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.DecoratorPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Panel;
import com.google.gwt.user.client.ui.SimplePanel;
import com.jornada.client.adminescola.AdminEscola;
import com.jornada.client.adminescola.CadastroConteudoProgramatico;
import com.jornada.client.adminescola.CadastroCurso;
import com.jornada.client.adminescola.CadastroDisciplina;
import com.jornada.client.adminescola.CadastroPeriodo;
import com.jornada.client.adminescola.ViewAdminEscola;
import com.jornada.client.adminescola.ViewAdminEscola2;
import com.jornada.client.classes.ElementFader;

public class MainView extends Composite implements ValueChangeHandler{
	
	private MainTitle mainTitle =  new MainTitle();
	private MainMenu mainMenu;
	private MainBody mainBody;
	private MainFooter mainFooter = new MainFooter();
	private static Label lblMessage = new Label();
	
	VerticalPanel vPanelTitle = new VerticalPanel();
	VerticalPanel vPanelMenu = new VerticalPanel();
	VerticalPanel vPanelBody = new VerticalPanel();
	VerticalPanel vPanelFooter = new VerticalPanel();
	
	VerticalPanel vPanel = new VerticalPanel();


	public MainView() {	
				
		mainMenu = new MainMenu(this);
		mainBody = new MainBody(this);		
	
		lblMessage.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		lblMessage.setVisible(false);
		lblMessage.setStyleName("label_message");
		vPanelTitle.add(lblMessage);
		
		vPanelTitle.add(mainTitle);		
		vPanelMenu.add(mainMenu);		
		vPanelBody.add(mainBody);
		vPanelFooter.add(mainFooter);
		
		vPanel.add(vPanelTitle);
		vPanel.add(vPanelMenu);
		vPanel.add(vPanelBody);
		vPanel.add(vPanelFooter);
		
		vPanelTitle.setSize("100%", "100%");
		vPanelBody.setSize("100%", "100%");
		vPanelFooter.setSize("100%", "100%");
		vPanel.setSize("98%", "100%");
		
		vPanelMenu.setVisible(false);
		
		//new ElementFader().fade(vPanelBody.getElement(), 0, 1, 1500);
		
		vPanelTitle.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);		
		vPanelBody.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		vPanelFooter.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		vPanel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_RIGHT);	
		
		vPanel.setSpacing(2);	
		
		initWidget(vPanel);		
		
	}
	
	public static void showMessage(String message)
	{
		lblMessage.setText(message);
		lblMessage.setVisible(true);
	}
	
	public static void hideMessage()
	{
		lblMessage.setVisible(false);
	}
	
	public void openMainView(){
		History.newItem("Principal");
		this.vPanelBody.clear();
		//new ElementFader().fade(vPanelBody.getElement(), 0, 1, 500);
		vPanelBody.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_LEFT);
		mainBody = new MainBody(this);
		//mainMenu.setPaginaPrincipalNavigation();
		this.vPanelBody.add(mainBody);
		this.vPanelMenu.setVisible(false);
	}	
	
	public void openAdminEscola(){
		
		History.newItem("Admin");
		this.vPanelBody.clear();
		//new ElementFader().fade(vPanelBody.getElement(), 0, 1, 1500);
		
		AdminEscola adminEscola = new AdminEscola(this);
		//ViewAdminEscola2 adminEscola = new ViewAdminEscola2(this);
		
//		mainMenu.setVisibleLinkPaginaPrincipal(true);
//		mainMenu.setVisibleLinkAdministracao(true);
//		mainMenu.setVisibleLinkCurso(false);


		this.vPanelBody.add(adminEscola);
		this.vPanelMenu.setVisible(true);
		
	}
	
	public void openCadastroCurso(){
		
		History.newItem("Curso");
		
		//new ElementFader().fade(vPanelBody.getElement(), 0, 1, 1300);
		
		this.vPanelBody.clear();
		vPanelBody.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_LEFT);
		
//		mainMenu.setVisibleLinkPaginaPrincipal(true);
//		mainMenu.setVisibleLinkAdministracao(true);
//		mainMenu.setVisibleLinkCurso(true);
		
		
		CadastroCurso cadastroCurso = new CadastroCurso();
		this.vPanelBody.add(cadastroCurso);
		this.vPanelMenu.setVisible(true);
	
		
	}	
		
	public void openCadastroDisciplina(){
		
		History.newItem("Disciplina");
		
		//new ElementFader().fade(vPanelBody.getElement(), 0, 1, 1300);
		//new ElementFader().fade(vPanelMenu.getElement(), 0, 1, 1500);	
		this.vPanelBody.clear();
		vPanelBody.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_LEFT);
		
		CadastroDisciplina cadastroDisciplina = new CadastroDisciplina();
		this.vPanelBody.add(cadastroDisciplina);
		this.vPanelMenu.setVisible(true);
	
		
	}	
	
	public void openCadastroPeriodo(){
		
		//new ElementFader().fade(vPanelBody.getElement(), 0, 1, 1300);
		//new ElementFader().fade(vPanelMenu.getElement(), 0, 1, 1500);	
		this.vPanelBody.clear();
		vPanelBody.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_LEFT);
		
		CadastroPeriodo cadastroPeriodo = new CadastroPeriodo();
		this.vPanelBody.add(cadastroPeriodo);
		this.vPanelMenu.setVisible(true);
	
		
	}

	public void openCadastroConteudoProgramatico(){
		
		//new ElementFader().fade(vPanelBody.getElement(), 0, 1, 1300);
		//new ElementFader().fade(vPanelMenu.getElement(), 0, 1, 1500);	
		this.vPanelBody.clear();
		vPanelBody.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_LEFT);
		
		CadastroConteudoProgramatico cadastroConteudoProgramatico = new CadastroConteudoProgramatico();
		this.vPanelBody.add(cadastroConteudoProgramatico);
		this.vPanelMenu.setVisible(true);
	
		
	}

	
	public MainMenu getMainMenu() {
		return mainMenu;
	}


	@Override
	public void onValueChange(ValueChangeEvent event) {
		// TODO Auto-generated method stub
		
	}



	
	
	
	
	
	
}

