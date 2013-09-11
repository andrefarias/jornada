package com.jornada.client.adminescola;

import com.google.gwt.core.client.EntryPoint;  
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.RootPanel;  
import com.gwtext.client.widgets.Panel;  
import com.gwtext.client.widgets.Window;
import com.gwtext.client.widgets.form.FormPanel;  
import com.gwtext.client.widgets.form.TextField;  
import com.gwtext.client.widgets.form.TimeField;  
import com.gwtext.client.widgets.form.VType;  
import com.gwtext.client.widgets.layout.BorderLayout;
import com.gwtext.client.widgets.layout.FitLayout;
import com.smartgwt.client.widgets.Label;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.PushButton;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.RichTextArea;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.SimplePanel;
import com.jornada.client.classes.FadeAnimation;
import com.jornada.client.classes.WorldXmlDS;
import com.smartgwt.client.types.AnimationEffect;
import com.smartgwt.client.widgets.Button;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.DateItem;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.layout.VLayout;


public class CadastroCurso2 extends Composite {
//	public CadastroCurso2() {
//		
//		
//		Panel panel = new Panel();  
//        panel.setBorder(false);  
//        panel.setPaddings(0);
//        
//  
//        final FormPanel formPanel = new FormPanel();  
//        formPanel.setFrame(true);  
//        //formPanel.setTitle("Curso");  
//  
//        formPanel.setWidth(550);  
//        formPanel.setLabelWidth(75);  
//        formPanel.setUrl("save-form.php");  
//  
//        Label label = new Label();  
//        //label.seth("<p>This is an example of a Form Label. This can have any <b>HTML</b> content.</p>");  
//        //label.setCls("simple-form-label");  
//        label.setWidth(350);  
//        label.setHeight(20);  
//  
//        TextField firstName = new TextField("Nome Curso", "nomeCurso", 230);  
//        firstName.setAllowBlank(false);  
//        formPanel.add(firstName);  
//  
//        TextField lastName = new TextField("Descri\u00E7\u00E3o", "descricaoCurso", 230);  
//        formPanel.add(lastName);  
//  
//        TextField company = new TextField("Ementa", "ementa", 230);  
//        formPanel.add(company);  
//  
// 
//        DateItem dateItem = new DateItem();  
//        dateItem.setTitle("");  
//        //dateItem.setHint("<nobr>Picklist based date input</nobr>");
//        DynamicForm dateForm = new DynamicForm(); 
//        dateForm.setItems(dateItem);  
//        formPanel.add(dateForm);
//        
//        
//        DateItem dateItemFinal = new DateItem();  
//        dateItemFinal.setTitle("");  
//        //dateItemFinal.setHint("<nobr>Picklist based date input</nobr>");
//        DynamicForm dateFormFinal = new DynamicForm(); 
//        dateFormFinal.setItems(dateItemFinal);      
//        
//        formPanel.add(dateFormFinal);
//        
//        
////		Grid grid = new Grid(6, 3);
////		//verticalPanelBody.add(grid);
////		//grid.setSize("493px", "3cm");
////		//grid.setSize("100%", "100%");
////		
////		Label label = new Label("Nome : ");
////		grid.setWidget(0, 0, label);
////		
////		TextBox textBox = new TextBox();
////		textBox.setStyleName("design_text_boxes");
////		grid.setWidget(0, 2, textBox);
////		textBox.setWidth("250px");
////		
////		Label label_1 = new Label("Descri\u00E7\u00E3o :");
////		grid.setWidget(1, 0, label_1);
////		
////		TextBox textBox_1 = new TextBox();
////		textBox_1.setStyleName("design_text_boxes");
////		grid.setWidget(1, 2, textBox_1);
////		textBox_1.setWidth("250px");
////		
////		Label label_2 = new Label("Ementa : ");
////		grid.setWidget(2, 0, label_2);
////		
////		RichTextArea richTextArea = new RichTextArea();
////		richTextArea.setStyleName("design_text_boxes");
////		grid.setWidget(2, 2, richTextArea);
////		richTextArea.setWidth("330px");
////		
////		
////		Label label_3 = new Label("Data Inicial : ");
////		grid.setWidget(3, 0, label_3);
////		
////        DateItem dateItem = new DateItem();  
////        dateItem.setTitle("");  
////        dateItem.setHint("<nobr>Picklist based date input</nobr>");
////        DynamicForm dateForm = new DynamicForm(); 
////        dateForm.setItems(dateItem);
////
////        grid.setWidget(3, 2, dateForm);
////        
////		Label label_4 = new Label("Data Final : ");
////		grid.setWidget(4, 0, label_4);
////		
////        DateItem dateItemFinal = new DateItem();  
////        dateItemFinal.setTitle("");  
////        dateItemFinal.setHint("<nobr>Picklist based date input</nobr>");
////        DynamicForm dateFormFinal = new DynamicForm(); 
////        dateFormFinal.setItems(dateItemFinal);
////
////        grid.setWidget(4, 2, dateFormFinal); 
//        
////        formPanel.add(grid);
//        
//  
//        Button save = new Button("Save");  
//        formPanel.addButton(save);  
//  
//        Button cancel = new Button("Cancel");  
//        formPanel.addButton(cancel);  
//  
//        panel.add(formPanel);
//        //window.add(formPanel);
//        //panel.add(window);
//        
//        
////        Panel windowPanel = new Panel();  
////        //windowPanel.setHtml();  
////        windowPanel.setShadow(true);  
//  
////        final Window window = new Window();  
////        window.setTitle("Curso");  
////        window.setIconCls("images/folder_library_16_16.png");  
////        window.setMaximizable(true);  
////        window.setResizable(true);  
////        window.setCollapsible(true);  
////        window.setLayout(new FitLayout());  
////        window.setWidth(500);
////        window.setHeight(400);  
////        window.setModal(false);  
////        window.add(windowPanel);
////        windowPanel.add(panel);
////        window.show();
//        
//       // panel.add(window);
//
//	        
//	        initWidget(panel);
//		
//	}
	
	public CadastroCurso2()
	{
		

        Panel iconPanel = new Panel();  
        iconPanel.setTitle("Curso");  
        iconPanel.setIconCls("curso_16_16_icon");
        iconPanel.setWidth(800);  
        iconPanel.setHeight(450);
        iconPanel.setCollapsible(true);  
        //iconPanel.setHtml(getShortBogusMarkup());  
        iconPanel.setShadow(true);
        iconPanel.setPaddings(0);

        
		VerticalPanel verticalPanelPage = new VerticalPanel();
	
		
        Button cssButton = new Button("Salvar Curso");
        cssButton.setWidth("150px");
        cssButton.setShowRollOver(true);
        cssButton.setShowDisabled(true);
        cssButton.setShowDown(true);
        cssButton.setIcon("../images/save.png");		

        Button cssButtonAdicionar = new Button("Adicionar Novo Curso");
        cssButtonAdicionar.setWidth("150px");
        cssButtonAdicionar.setShowRollOver(true);
        cssButtonAdicionar.setShowDisabled(true);
        cssButtonAdicionar.setShowDown(true);
        cssButtonAdicionar.setIcon("../images/plus-circle.png");
        
        Button cssButtonRemover = new Button("Remover Curso");
        cssButtonRemover.setWidth("150px");
        cssButtonRemover.setShowRollOver(true);
        cssButtonRemover.setShowDisabled(true);
        cssButtonRemover.setShowDown(true);
        cssButtonRemover.setIcon("../images/delete.png");	        
        
        
        
		VerticalPanel verticalPanelTitle = new VerticalPanel();
		//verticalPanelTitle.setSize("10px", "10px");
		HorizontalPanel hPanel = new HorizontalPanel();
		hPanel.add(cssButton);
		hPanel.add(cssButtonAdicionar);
		hPanel.add(cssButtonRemover);
				
				verticalPanelTitle.add(hPanel);
		
		
		VerticalPanel verticalPanelFooter = new VerticalPanel();
		verticalPanelFooter.setSize("10px", "10px");
		
		
		VerticalPanel verticalPanelBody = new VerticalPanel();
		//verticalPanelBody.setStyleName("fundo_tabela_componente");

		verticalPanelBody.setSize("400px", "400px");
		
		Grid grid = new Grid(6, 3);
		verticalPanelBody.add(grid);
		grid.setCellPadding(3);
		//grid.setSize("493px", "3cm");
		//grid.setSize("100%", "100%");
		
		Label label = new Label("Nome : ");
		label.setHeight("25px");
		grid.setWidget(0, 0, label);
		
		TextBox textBox = new TextBox();
		textBox.setStyleName("design_text_boxes");
		grid.setWidget(0, 2, textBox);
		//textBox.setWidth("250px");
		
		Label label_1 = new Label("Descri\u00E7\u00E3o :");
		label_1.setHeight("25px");
		grid.setWidget(1, 0, label_1);
		
		TextBox textBox_1 = new TextBox();
		textBox_1.setStyleName("design_text_boxes");
		grid.setWidget(1, 2, textBox_1);
		//textBox_1.setWidth("250px");
		
		Label label_2 = new Label("Ementa : ");
		label_2.setHeight("25px");
		grid.setWidget(2, 0, label_2);
		
		RichTextArea richTextArea = new RichTextArea();
		richTextArea.setStyleName("design_text_boxes");
		grid.setWidget(2, 2, richTextArea);
		//richTextArea.setWidth("330px");
		
		
		Label label_3 = new Label("Data Inicial : ");
		label_3.setHeight("25px");
		grid.setWidget(3, 0, label_3);
		
        DateItem dateItem = new DateItem();  
        dateItem.setTitle("");  
        dateItem.setHint("<nobr>Picklist based date input</nobr>");
        DynamicForm dateForm = new DynamicForm(); 
        dateForm.setItems(dateItem);

        grid.setWidget(3, 2, dateForm);
        
		Label label_4 = new Label("Data Final : ");
		label_4.setHeight("25px");
		grid.setWidget(4, 0, label_4);
		
        DateItem dateItemFinal = new DateItem();  
        dateItemFinal.setTitle("");  
        dateItemFinal.setHint("<nobr>Picklist based date input</nobr>");
        DynamicForm dateFormFinal = new DynamicForm(); 
        dateFormFinal.setItems(dateItemFinal);

        grid.setWidget(4, 2, dateFormFinal);        
		
//		Button button = new Button("New button");
//		button.setText("Salvar Curso");
//	    PushButton pushButton = new PushButton(new Image("image/blockdevice_16.png"));
//	    pushButton.setHTML("<Table cellspacing=2> <tr> <td>" + new Image("image/image002.png") + "</td> <td  align=middle>" + "Salvar Curso" + "</td></tr></Table>");
//        final Button cssButton = new Button("Salvar Curso");
//        cssButton.setShowRollOver(true);
//        cssButton.setShowDisabled(true);
//        cssButton.setShowDown(true);
//        cssButton.setIcon("../images/image002.png");		
//		
//		grid.setWidget(5, 2, cssButton);
		//pushButton.setWidth("130px");
		grid.getCellFormatter().setHorizontalAlignment(3, 2, HasHorizontalAlignment.ALIGN_LEFT);
		
		
		verticalPanelPage.add(verticalPanelTitle);
		verticalPanelPage.add(verticalPanelBody);
		verticalPanelPage.add(verticalPanelFooter);
	


	    iconPanel.add(verticalPanelPage);
        
        
        initWidget(iconPanel);
		
	}

}
