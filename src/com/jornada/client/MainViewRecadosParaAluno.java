package com.jornada.client;

import com.google.gwt.user.client.ui.Composite;

public class MainViewRecadosParaAluno extends Composite {

	
	public MainViewRecadosParaAluno(){		
		
		String strTitle = "Students Informative";
		
		String strImageAddress = "images/text_enriched.png";
		
		String strText = "Teacher Informatives to: \n";
		strText+="- Parents.\n";
		strText+="- Students.\n";
		
		MainViewComponent mainViewComp = new MainViewComponent(strTitle,strImageAddress,strText);
		
		initWidget(mainViewComp);	
		
	}


}
