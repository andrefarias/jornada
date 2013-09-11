package com.jornada.client;

import com.google.gwt.user.client.ui.Composite;

public class MainViewNotasEscolares extends Composite{

	
	public MainViewNotasEscolares(){
		
		String strTitle = "Students Grades";
		
		String strImageAddress = "images/chart-icon.png";
		
		String strText = "Follow your grades using: \n";
		strText+="- Interactive Charts.\n";
		strText+="- Detailed Tables.\n";
		
		MainViewComponent mainViewComp = new MainViewComponent(strTitle,strImageAddress,strText);
		
		initWidget(mainViewComp);	
		
		
	}


}
