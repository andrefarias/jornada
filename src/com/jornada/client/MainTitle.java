package com.jornada.client;

import com.gargoylesoftware.htmlunit.OnbeforeunloadHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.DateLabel;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.i18n.client.HasDirection.Direction;
import com.google.gwt.user.client.ui.HorizontalSplitPanel;
import com.google.gwt.user.client.ui.MenuBar;
import com.google.gwt.user.client.ui.MenuItem;
import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.FlowPanel;

public class MainTitle extends Composite {
	
	//Jornada jornada;
	
	public MainTitle() {
		
		//this.jornada = jornada;
		
		VerticalPanel verticalPanel = new VerticalPanel();
		verticalPanel.setStyleName("titulo_tabela");
		
		HorizontalPanel horizontalPanelTop = new HorizontalPanel();
		horizontalPanelTop.setSpacing(5);
		horizontalPanelTop.setBorderWidth(0);
		horizontalPanelTop.setStyleName("tabela_mainview_titulo");
		horizontalPanelTop.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
		initWidget(verticalPanel);
		verticalPanel.setSize("100%", "100px");
		horizontalPanelTop.setSize("100%", "80px");
		verticalPanel.add(horizontalPanelTop);
		
		Image image = new Image("images/Courses-128.png");
		image.addClickHandler(new addClicker());
		horizontalPanelTop.add(image);
		horizontalPanelTop.setCellHorizontalAlignment(image, HasHorizontalAlignment.ALIGN_CENTER);
		image.setSize("62px", "62px");
		
		Label lblNewLabel = new Label("Ambiente Web de Apoio Escolar");
		lblNewLabel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_LEFT);
		lblNewLabel.setStyleName("MainViewTitleLabel");
		horizontalPanelTop.add(lblNewLabel);
		lblNewLabel.setWidth("631px");
		
		HorizontalPanel horizontalPanelDown = new HorizontalPanel();
		verticalPanel.add(horizontalPanelDown);
		horizontalPanelDown.setSize("100%", "100%");
		
		HorizontalPanel horizontalPanel_1 = new HorizontalPanel();
		horizontalPanelDown.add(horizontalPanel_1);
		
		Label lblWelcomeAndreLuiz = new Label("Bem Vindo Andre Luiz Freire de Farias");
		lblWelcomeAndreLuiz.setStyleName("MainViewSubTitleLabel");
		horizontalPanel_1.add(lblWelcomeAndreLuiz);
		
		Label lblNewLabel_2 = new Label("|");
		lblNewLabel_2.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		horizontalPanel_1.add(lblNewLabel_2);
		lblNewLabel_2.setWidth("24px");
		
		Label lblNewLabel_1 = new Label("Julho 5, 2013 8:17:00");
		lblNewLabel_1.setStyleName("MainViewSubTitleLabel");
		horizontalPanel_1.add(lblNewLabel_1);
		lblNewLabel_1.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_LEFT);
		
		HorizontalPanel horizontalPanel = new HorizontalPanel();
		horizontalPanel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_RIGHT);
		horizontalPanelDown.add(horizontalPanel);
		horizontalPanelDown.setCellHorizontalAlignment(horizontalPanel, HasHorizontalAlignment.ALIGN_RIGHT);
		
		Image image_3 = new Image("images/Gear_16.png");
		horizontalPanelDown.add(image_3);
		horizontalPanelDown.setCellHorizontalAlignment(image_3, HasHorizontalAlignment.ALIGN_RIGHT);
		
		Label lblNewLabel_5 = new Label("Configura\u00E7\u00F5es");
		lblNewLabel_5.setStyleName("MainViewSubTitleLabel");
		lblNewLabel_5.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_RIGHT);
		horizontalPanelDown.add(lblNewLabel_5);
		lblNewLabel_5.setSize("30px", "100%");
		
		Image image_2 = new Image("images/help.png");
		horizontalPanelDown.add(image_2);
		horizontalPanelDown.setCellHorizontalAlignment(image_2, HasHorizontalAlignment.ALIGN_RIGHT);
		
		Label lblNewLabel_4 = new Label("Ajuda");
		lblNewLabel_4.setStyleName("MainViewSubTitleLabel");
		lblNewLabel_4.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_RIGHT);
		horizontalPanelDown.add(lblNewLabel_4);
		lblNewLabel_4.setSize("10px", "100%");
		
		Image image_1 = new Image("images/exit.png");
		horizontalPanelDown.add(image_1);
		image_1.setSize("", "");
		horizontalPanelDown.setCellHorizontalAlignment(image_1, HasHorizontalAlignment.ALIGN_RIGHT);
		
		Label lblNewLabel_3 = new Label("Sair");
		lblNewLabel_3.setStyleName("MainViewSubTitleLabel");
		lblNewLabel_3.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_RIGHT);
		horizontalPanelDown.add(lblNewLabel_3);
		lblNewLabel_3.setSize("10px", "");
	}
	
	
	private class addClicker implements ClickHandler{

		@Override
		public void onClick(ClickEvent event) {

			
		}
		
	}

}
