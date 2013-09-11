package com.jornada.client.adminescola;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.PushButton;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
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
import com.gwtext.client.data.SimpleStore;
import com.gwtext.client.data.Store;
import com.gwtext.client.widgets.Panel;
import com.gwtext.client.widgets.form.ComboBox;
import com.gwtext.client.widgets.form.event.ComboBoxListenerAdapter;
import com.gwtext.client.data.Record;

public class CadastroPeriodo extends Composite {

	public ListGrid countryGrid;

	
    // countries store  
    Object[][] countries = new Object[][]{  
            new Object[]{"1Ano", "1 Ano - Ensino Fundamental"},  
            new Object[]{"2Ano", "2 Ano - Ensino Fundamental"},  
            new Object[]{"3Ano", "3 Ano - Ensino Fundamental"},  
            new Object[]{"4Ano", "4 Ano - Ensino Fundamental"},  
    };	
	
    
	public CadastroPeriodo() {
		
        final Store countriesStore = new SimpleStore(new String[]{"cid", "country"}, countries);  
        countriesStore.load(); 

		Panel iconPanel = new Panel();
		iconPanel.setTitle("Periodo");
		iconPanel.setIconCls("periodo_16_16_icon");
		iconPanel.setWidth(800);
		iconPanel.setHeight(485);
		iconPanel.setCollapsible(true);
		// iconPanel.setHtml(getShortBogusMarkup());
		iconPanel.setShadow(true);
		iconPanel.setPaddings(0);

		VerticalPanel verticalPanelPage = new VerticalPanel();

		Button cssButton = new Button("Salvar Disciplina");
		cssButton.setWidth("150px");
		cssButton.setShowRollOver(true);
		cssButton.setShowDisabled(true);
		cssButton.setShowDown(true);
		cssButton.setIcon("../images/save.png");

		Button cssButtonAdicionar = new Button("Adicionar Nova Disciplina");
		cssButtonAdicionar.setWidth("150px");
		cssButtonAdicionar.setShowRollOver(true);
		cssButtonAdicionar.setShowDisabled(true);
		cssButtonAdicionar.setShowDown(true);
		cssButtonAdicionar.setIcon("../images/plus-circle.png");

		Button cssButtonRemover = new Button("Remover Disciplina");
		cssButtonRemover.setWidth("150px");
		cssButtonRemover.setShowRollOver(true);
		cssButtonRemover.setShowDisabled(true);
		cssButtonRemover.setShowDown(true);
		cssButtonRemover.setIcon("../images/delete.png");

		VerticalPanel verticalPanelTitle = new VerticalPanel();
		// verticalPanelTitle.setSize("10px", "10px");
		HorizontalPanel hPanel = new HorizontalPanel();
		hPanel.add(cssButton);
		hPanel.add(cssButtonAdicionar);
		hPanel.add(cssButtonRemover);

		verticalPanelTitle.add(hPanel);

		VerticalPanel verticalPanelFooter = new VerticalPanel();
		verticalPanelFooter.setSize("10px", "10px");

		VerticalPanel verticalPanelBody = new VerticalPanel();
		// verticalPanelBody.setStyleName("fundo_tabela_componente");

		verticalPanelBody.setSize("400px", "400px");

		Grid grid = new Grid(6, 3);
		verticalPanelBody.add(grid);
		grid.setCellPadding(3);
		
		int cv=0;
		
		Label labelCurso = new Label("Curso : ");		
		labelCurso.setHeight("25px");
		grid.setWidget(cv, 0, labelCurso);
		
        final ComboBox countryCB = new ComboBox();  
        countryCB.setFieldLabel("Select Country");  
        countryCB.setStore(countriesStore);  
        countryCB.setDisplayField("country");  
        countryCB.setMode(ComboBox.LOCAL);  
        countryCB.setTriggerAction(ComboBox.ALL);  
        countryCB.setForceSelection(true);  
        countryCB.setValueField("cid");  
        countryCB.setReadOnly(true); 
        
		grid.setWidget(cv, 2, countryCB);
        
        
		cv++;
	

		Label label = new Label("Nome : ");
		label.setHeight("25px");
		grid.setWidget(cv, 0, label);

		TextBox textBox = new TextBox();
		textBox.setStyleName("design_text_boxes");
		grid.setWidget(cv, 2, textBox);
		
		cv++;

		Label label_1 = new Label("Descri\u00E7\u00E3o :");
		label_1.setHeight("25px");
		grid.setWidget(cv, 0, label_1);

		TextBox textBox_1 = new TextBox();
		textBox_1.setStyleName("design_text_boxes");
		grid.setWidget(cv, 2, textBox_1);
		// textBox_1.setWidth("250px");
		
		cv++;

		Label label_2 = new Label("Ementa : ");
		label_2.setHeight("25px");
		grid.setWidget(cv, 0, label_2);

		RichTextArea richTextArea = new RichTextArea();
		richTextArea.setStyleName("design_text_boxes");
		grid.setWidget(cv, 2, richTextArea);
		
		cv++;		
		
		Label label_3 = new Label("Data Inicial : ");
		label_3.setHeight("25px");
		grid.setWidget(cv, 0, label_3);
		
        DateItem dateItem = new DateItem();  
        dateItem.setTitle("");  
        //dateItem.setHint("<nobr>Picklist based date input</nobr>");
        DynamicForm dateForm = new DynamicForm(); 
        dateForm.setItems(dateItem);

        grid.setWidget(cv, 2, dateForm);
        
        cv++;
        
		Label label_4 = new Label("Data Final : ");
		label_4.setHeight("25px");
		grid.setWidget(cv, 0, label_4);
		
        DateItem dateItemFinal = new DateItem();  
        dateItemFinal.setTitle("");  
        //dateItemFinal.setHint("<nobr>Picklist based date input</nobr>");
        DynamicForm dateFormFinal = new DynamicForm(); 
        dateFormFinal.setItems(dateItemFinal);

        grid.setWidget(cv, 2, dateFormFinal);        
		
		

		grid.getCellFormatter().setHorizontalAlignment(3, 2,HasHorizontalAlignment.ALIGN_LEFT);

		countryGrid = new ListGrid();
		countryGrid.setWidth(800);
		countryGrid.setHeight(150);
		// countryGrid.setShowFilterEditor(true);
		// countryGrid.setFilterOnKeypress(true);
		countryGrid.setDataSource(WorldXmlDS.getInstance());
		countryGrid.setAutoFetchData(true);

		// ListGridField countryCodeField = new ListGridField("countryCode",
		// "Code", 50);
		ListGridField nameField = new ListGridField("courseName", "Nome");
		ListGridField capitalField = new ListGridField("descricao", "Descricao");
		ListGridField continentField = new ListGridField("ementa", "Ementa");
		ListGridField dataInicialField = new ListGridField("dataInicial","Data Inicial");
		ListGridField dataFinalField = new ListGridField("dataFinal","Data Final");
		countryGrid.setFields(nameField, capitalField, continentField,	dataInicialField, dataFinalField);

		verticalPanelBody.add(countryGrid);

		verticalPanelPage.add(verticalPanelTitle);
		verticalPanelPage.add(verticalPanelBody);
		verticalPanelPage.add(verticalPanelFooter);

		iconPanel.add(verticalPanelPage);

		initWidget(iconPanel);

	}

}
