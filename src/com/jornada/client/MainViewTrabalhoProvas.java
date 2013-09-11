package com.jornada.client;

import com.google.gwt.user.client.ui.Composite;

public class MainViewTrabalhoProvas extends Composite {

	
	public MainViewTrabalhoProvas(){
		
		String strTitle = "Exam and Schoolwork Schedule";
		
		String strImageAddress = "images/config_date.png";
		
		String strText = "See in our schedule: \n";
		strText+="- Exams.\n";
		strText+="- Schoolworks.\n";
		strText+="- Homeworks.\n";
		
		MainViewComponent mainViewComp = new MainViewComponent(strTitle,strImageAddress,strText);
		
		initWidget(mainViewComp);	
		
		
	}


}
