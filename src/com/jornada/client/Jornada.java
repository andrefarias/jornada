package com.jornada.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.HistoryListener;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.Hyperlink;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.smartgwt.client.types.Alignment;  
import com.smartgwt.client.types.ListGridFieldType;  
import com.smartgwt.client.widgets.Canvas;  
import com.smartgwt.client.widgets.IButton;  
import com.smartgwt.client.widgets.events.ClickEvent;  
import com.smartgwt.client.widgets.events.ClickHandler;  
import com.smartgwt.client.widgets.grid.ListGrid;  
import com.smartgwt.client.widgets.grid.ListGridField;  
//import com.smartgwt.sample.showcase.client.data.CountryData;
import com.smartgwt.client.widgets.layout.HLayout;

public class Jornada implements EntryPoint {	

	MainView mainView = new MainView();
	private static Label lblMessage = null;
	
	public void onModuleLoad() {	
	    
		VerticalPanel vPanel = new VerticalPanel();
		vPanel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		vPanel.setSize("100%", "100%");

		lblMessage = new Label();
		lblMessage.setVisible(true);
		
		//vPanel.add(lblMessage);
		vPanel.add(mainView);
		
		RootPanel.get().add(vPanel);    
	    
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
	
}


