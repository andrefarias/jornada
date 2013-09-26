package com.jornada.client.adminescola;

import com.google.gwt.core.shared.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RichTextArea;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.gwtext.client.data.SimpleStore;
import com.gwtext.client.data.Store;
import com.gwtext.client.widgets.Panel;
import com.gwtext.client.widgets.form.ComboBox;
import com.jornada.client.classes.WorldXmlDS;
import com.jornada.client.service.GWTServicePeriodo;
import com.jornada.client.service.GWTServicePeriodoAsync;
import com.jornada.shared.classes.Periodo;
import com.smartgwt.client.widgets.Button;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.DateItem;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.grid.ListGridField;

public class CadastroPeriodo extends Composite {

	private class AdicionarPeriodoClickHandler implements ClickHandler {

		@Override
		public void onClick(ClickEvent event) {

			GWTServicePeriodoAsync service = GWT
					.create(GWTServicePeriodo.class);
			
			Periodo periodo = new Periodo();
			
			periodo.setIdCurso(Integer.parseInt(cbCurso.getValue()));
			periodo.setNomeModulo(txtNome.getText());
			periodo.setDescricao(txtDescricao.getText());
			periodo.setNumeracao(txtNumeracao.getText());
			periodo.setObjetivo(rtaObjetivo.getText());
			
			service.AdicionarPeriodo(periodo, new AsyncCallback<Boolean>() {

				@Override
				public void onFailure(Throwable caught) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void onSuccess(Boolean result) {
					// TODO Auto-generated method stub
					
				}
				
			});

		}

	}

	ComboBox cbCurso;
	TextBox txtNome;
	TextBox txtDescricao;
	TextBox txtNumeracao;
	RichTextArea rtaObjetivo;
	public ListGrid countryGrid;

	// countries store
	Object[][] countries = new Object[][] {
			new Object[] { 1, "1 Ano - Ensino Fundamental" },
			new Object[] { 2, "2 Ano - Ensino Fundamental" },
			new Object[] { 3, "3 Ano - Ensino Fundamental" },
			new Object[] { 4, "4 Ano - Ensino Fundamental" }, };

	public CadastroPeriodo() {

		final Store countriesStore = new SimpleStore(new String[] { "cid",
				"country" }, countries);
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

		Button cssButton = new Button("Salvar Período");
		cssButton.setWidth("150px");
		cssButton.setShowRollOver(true);
		cssButton.setShowDisabled(true);
		cssButton.setShowDown(true);
		cssButton.setIcon("../images/save.png");

		Button cssButtonAdicionar = new Button("Adicionar Novo Período");
		cssButtonAdicionar.setWidth("150px");
		cssButtonAdicionar.setShowRollOver(true);
		cssButtonAdicionar.setShowDisabled(true);
		cssButtonAdicionar.setShowDown(true);
		cssButtonAdicionar.setIcon("../images/plus-circle.png");
		cssButtonAdicionar.addClickHandler(new AdicionarPeriodoClickHandler());

		Button cssButtonRemover = new Button("Remover Período");
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

		int cv = 0;

		Label labelCurso = new Label("Curso : ");
		labelCurso.setHeight("25px");
		grid.setWidget(cv, 0, labelCurso);

		cbCurso = new ComboBox();
		cbCurso.setFieldLabel("Select Country");
		cbCurso.setStore(countriesStore);
		cbCurso.setDisplayField("country");
		cbCurso.setMode(ComboBox.LOCAL);
		cbCurso.setTriggerAction(ComboBox.ALL);
		cbCurso.setForceSelection(true);
		cbCurso.setValueField("cid");
		cbCurso.setReadOnly(true);

		grid.setWidget(cv, 2, cbCurso);

		cv++;

		Label label = new Label("Nome : ");
		label.setHeight("25px");
		grid.setWidget(cv, 0, label);

		txtNome = new TextBox();
		txtNome.setStyleName("design_text_boxes");
		grid.setWidget(cv, 2, txtNome);

		cv++;

		Label label_1 = new Label("Descri\u00E7\u00E3o :");
		label_1.setHeight("25px");
		grid.setWidget(cv, 0, label_1);

		txtDescricao = new TextBox();
		txtDescricao.setStyleName("design_text_boxes");
		grid.setWidget(cv, 2, txtDescricao);

		cv++;

		Label label_2 = new Label("Numeracao : ");
		label_2.setHeight("25px");
		grid.setWidget(cv, 0, label_2);

		txtNumeracao = new TextBox();
		txtNumeracao.setStyleName("design_text_boxes");
		grid.setWidget(cv, 2, txtNumeracao);

		cv++;

		Label label_3 = new Label("Objetivo : ");
		label_3.setHeight("25px");
		grid.setWidget(cv, 0, label_3);

		rtaObjetivo = new RichTextArea();
		rtaObjetivo.setStyleName("design_text_boxes");
		grid.setWidget(cv, 2, rtaObjetivo);

		cv++;

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

		iconPanel.add(verticalPanelPage);

		initWidget(iconPanel);

	}

}
