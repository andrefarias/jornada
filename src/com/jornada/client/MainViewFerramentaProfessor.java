package com.jornada.client;

import com.google.gwt.user.client.ui.Composite;

public class MainViewFerramentaProfessor extends Composite {
	

	public MainViewFerramentaProfessor(){
		
		
		String strTitle = "Teacher Environment Tool";
		
		String strImageAddress = "images/Professor-icon.png";
		
		String strText = "Add and Change: \n";
		strText+="- Classrooms.\n";
		strText+="- Contents.\n";
		strText+="- Topics.\n";
		strText+="- Grades.\n";
		
		MainViewComponent mainViewComp = new MainViewComponent(strTitle,strImageAddress,strText);
		
		initWidget(mainViewComp);	
		
		
	}	

}
