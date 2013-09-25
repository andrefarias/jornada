package com.jornada.client;

import com.google.gwt.user.client.ui.Composite;

public class MainViewComunicadosEscola extends Composite {
	
	NewFlexTable flexTable;
	
public MainViewComunicadosEscola(){	
	
	String strTitle = "Communications and News";
	String strImageAddress = "images/notes.png";
	String strText = "Communications and News: \n";
	strText+="- To parents and students.\n";
	
	MainViewComponent mainViewComp = new MainViewComponent(strTitle,strImageAddress,strText);
	
	initWidget(mainViewComp);
	
}




}
