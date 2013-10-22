package com.jornada.client.adminescola;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RichTextArea;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.gwtext.client.data.Record;
import com.gwtext.client.widgets.Panel;
import com.gwtext.client.widgets.form.ComboBox;
import com.gwtext.client.widgets.form.event.ComboBoxListenerAdapter;
import com.jornada.client.classes.WorldXmlDS;
import com.smartgwt.client.widgets.Button;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.grid.ListGridField;

public class CadastroConteudoProgramatico extends Composite {

	public ListGrid countryGrid;

	public CadastroConteudoProgramatico() {
		Panel iconPanel = new Panel();

		iconPanel.setTitle("Disciplina");
		iconPanel.setIconCls("disciplina_16_16_icon");
		iconPanel.setWidth(800);
		iconPanel.setHeight(485);
		iconPanel.setCollapsible(true);
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

		Grid grid = new Grid(5, 3);
		verticalPanelBody.add(grid);
		grid.setCellPadding(3);
		// grid.setSize("493px", "3cm");
		// grid.setSize("100%", "100%");

		int cv = 0;

		Label labelCurso = new Label("Curso : ");
		labelCurso.setHeight("25px");
		grid.setWidget(cv, 0, labelCurso);

		final ComboBox countryCB = new ComboBox();
		countryCB.setFieldLabel("Select Country");
		// countryCB.setStore(countriesStore);
		countryCB.setDisplayField("country");
		countryCB.setMode(ComboBox.LOCAL);
		countryCB.setTriggerAction(ComboBox.ALL);
		countryCB.setForceSelection(true);
		countryCB.setValueField("cid");
		countryCB.setReadOnly(true);

		grid.setWidget(cv, 2, countryCB);

		cv++;

		Label labelPeriodo = new Label("Periodo : ");
		labelPeriodo.setHeight("25px");
		grid.setWidget(cv, 0, labelPeriodo);

		/*
		 * final Store citiesStore = new SimpleStore(new String[] { "id", "cid",
		 * "city" }, cities); citiesStore.load();
		 */

		final ComboBox cityCB = new ComboBox();
		cityCB.setFieldLabel("Select City");
		// cityCB.setStore(citiesStore);
		cityCB.setDisplayField("city");
		cityCB.setValueField("id");
		cityCB.setMode(ComboBox.LOCAL);
		cityCB.setTriggerAction(ComboBox.ALL);
		cityCB.setLinked(true);
		cityCB.setForceSelection(true);
		cityCB.setReadOnly(true);

		countryCB.addListener(new ComboBoxListenerAdapter() {

			public void onSelect(ComboBox comboBox, Record record, int index) {
				cityCB.setValue("");
				// citiesStore.filter("cid", comboBox.getValue());
			}
		});

		grid.setWidget(cv, 2, cityCB);

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

		grid.getCellFormatter().setHorizontalAlignment(3, 2,
				HasHorizontalAlignment.ALIGN_LEFT);

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
		ListGridField dataInicialField = new ListGridField("dataInicial",
				"Data Inicial");
		ListGridField dataFinalField = new ListGridField("dataFinal",
				"Data Final");
		countryGrid.setFields(nameField, capitalField, continentField,
				dataInicialField, dataFinalField);

		verticalPanelBody.add(countryGrid);

		verticalPanelPage.add(verticalPanelTitle);
		verticalPanelPage.add(verticalPanelBody);
		verticalPanelPage.add(verticalPanelFooter);

		initWidget(iconPanel);
	}

}