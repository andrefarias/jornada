package com.jornada.client;

import com.google.gwt.user.client.ui.Composite;
import com.smartgwt.client.widgets.layout.HStack;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.smartgwt.client.widgets.layout.LayoutSpacer;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.Hyperlink;

public class MenuNavigation extends Composite {
	
	
	MainView mainView;
	
	public MenuNavigation(MainView mainView){
		
		this.mainView = mainView;
		
		HorizontalPanel horizontalPanel = new HorizontalPanel();
		horizontalPanel.setStyleName("titulo_tabela");
		initWidget(horizontalPanel);
		horizontalPanel.setSize("0", "0");
		
		Image image = new Image("images/home.png");
		horizontalPanel.add(image);
		
		Hyperlink hprlnkNewHyperlink = new Hyperlink("Pagina Principal", false, "newHistoryToken");
		hprlnkNewHyperlink.setStyleName("a a:link");
		horizontalPanel.add(hprlnkNewHyperlink);
		
		Image image_1 = new Image("images/blockdevice_16.png");
		horizontalPanel.add(image_1);
		
		Label lblAdministracao_1 = new Label("Administracao");
		horizontalPanel.add(lblAdministracao_1);
		
		LayoutSpacer layoutSpacer = new LayoutSpacer();
		layoutSpacer.setHeight("35px");
		horizontalPanel.add(layoutSpacer);
		horizontalPanel.setCellVerticalAlignment(layoutSpacer, HasVerticalAlignment.ALIGN_MIDDLE);
		
	}

}
