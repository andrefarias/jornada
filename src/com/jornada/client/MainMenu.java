package com.jornada.client;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Hyperlink;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.smartgwt.client.widgets.Img;

public class MainMenu extends Composite implements ValueChangeHandler {
//public class MainMenu extends Composite  {
	
	private MainView mainView;
	
    private Hyperlink link0;
    private Image image; 
    private Label lblNewLabel_0; 
    
    private Hyperlink link1;
    private Image image_1; 
    private Label lblNewLabel_1;
    
    private Hyperlink link2;
    private Image image_2;
    private Label lblNewLabel_2;
	
	public MainMenu(MainView mainView){
		
		this.mainView = mainView; 
		
	    // Create three hyperlinks that change the application's history.	    
	    
	    image = new Image("images/home-icon.png");
	    link0 = new Hyperlink("Principal", "Principal");
	    lblNewLabel_0 = new Label(" >> ");	    
	    link0.setStyleName("a");
	    
	    image_1 = new Image("images/blockdevice_16.png");
	    link1 = new Hyperlink("Admin", "Admin");
	    lblNewLabel_1 = new Label(" >> ");
	    link1.setStyleName("a");
	    
	    image_2 = new Image("images/curso.png");
	    link2 = new Hyperlink("Curso", "Curso");
	    link2.setStyleName("a");
    
	    // Add history listener
	    History.addValueChangeHandler(this);
		
	    HorizontalPanel hPanel = new HorizontalPanel();
	    hPanel.setStyleName("titulo_tabela");
	    hPanel.setSize("50%", "20px");

	    
	    hPanel.add(image);	
	    hPanel.add(link0);
	    hPanel.add(lblNewLabel_0);
	    hPanel.add(image_1);
	    hPanel.add(link1);
	    hPanel.add(lblNewLabel_1);
	    hPanel.add(image_2);
	    hPanel.add(link2);
	    
	    VerticalPanel vPanel = new VerticalPanel();
	    VerticalPanel vPanelBlank = new VerticalPanel();
	    vPanelBlank.setSize("10px", "10px");
	    vPanel.add(vPanelBlank);
	    vPanel.add(hPanel);
		
		initWidget(vPanel);
		
	}
	
	@Override
	public void onValueChange(ValueChangeEvent event) {
		// TODO Auto-generated method stub
		changePage(History.getToken());		
	}	
	
	public void changePage(String token) {
		
		if(History.getToken().equals("Principal")) {
			mainView.openMainView();
		} else if (History.getToken().equals("Admin")) {
			mainView.openAdminEscola();
			this.setVisibleLinkPaginaPrincipal(true);
			this.setVisibleLinkAdministracao(true);
			this.setVisibleLinkCurso(false);
			
		} else if (History.getToken().equals("Curso")) {
			mainView.openCadastroCurso();
			this.setVisibleLinkPaginaPrincipal(true);
			this.setVisibleLinkAdministracao(true);
			this.setVisibleLinkCurso(true);			
		}
	}
	

	
	public void setVisibleLinkPaginaPrincipal(boolean isVisible){
		
		image.setVisible(isVisible);
		link0.setVisible(isVisible);
		lblNewLabel_0.setVisible(isVisible);		
		
	}
	
	public void setVisibleLinkAdministracao(boolean isVisible){
		
		image_1.setVisible(isVisible);
		link1.setVisible(isVisible);
		lblNewLabel_1.setVisible(isVisible);		
		
	}
	
	public void setVisibleLinkCurso(boolean isVisible){
		
		image_2.setVisible(isVisible);
		link2.setVisible(isVisible);
		lblNewLabel_2.setVisible(isVisible);		
		
	}		


	

	
}
