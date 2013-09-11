package com.jornada.client;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.FlexTable;

public class MainFooter extends Composite {
	
	public MainFooter(){
		
		FlexTable flexTable = new FlexTable();
		flexTable.setStyleName("rodape");
		initWidget(flexTable);
		flexTable.setSize("100%", "100%");
		
		Label lblNewLabel = new Label("Pr\u00E1ticas de Privacidade");
		lblNewLabel.setStyleName("label_rodape");
		flexTable.setWidget(0, 0, lblNewLabel);
		
		Label lblNewLabel_1 = new Label("Uso Interno da Escola");
		lblNewLabel_1.setStyleName("label_rodape");
		flexTable.setWidget(0, 1, lblNewLabel_1);
		
		Image image = new Image("images/chromelogo.png");
		flexTable.setWidget(0, 2, image);
		image.setHeight("28px");
		
		Label lblNewLabel_2 = new Label("Email de suporte");
		lblNewLabel_2.setStyleName("label_rodape");
		flexTable.setWidget(1, 0, lblNewLabel_2);
		
		Label lblNewLabel_3 = new Label("\u00A9 Copyright 2013, Inc. All rights reserved.");
		lblNewLabel_3.setStyleName("label_rodape");
		flexTable.setWidget(1, 1, lblNewLabel_3);
		lblNewLabel_3.setSize("100%", "100%");
		
		Label lblNewLabel_4 = new Label("Funciona melhor no Google Chrome.");
		lblNewLabel_4.setStyleName("label_rodape");
		flexTable.setWidget(1, 2, lblNewLabel_4);
		
	}

}
