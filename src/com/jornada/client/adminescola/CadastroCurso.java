package com.jornada.client.adminescola;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RichTextArea;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.gwtext.client.widgets.Panel;
import com.jornada.client.classes.WorldXmlDS;
import com.jornada.client.service.GWTServiceCurso;
import com.jornada.client.service.GWTServiceCursoAsync;
import com.jornada.shared.classes.Curso;
import com.smartgwt.client.widgets.Button;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.DateItem;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.grid.ListGridField;

public class CadastroCurso extends Composite {

	TextBox textBoxNome;
	TextBox textBoxDescricao;
	RichTextArea richTextEmenta;
	DateItem dateItemInicial;
	DateItem dateItemFinal;
	public ListGrid countryGrid;
	DynamicForm dateFormInicial;

	public CadastroCurso() {

		Panel iconPanel = new Panel();
		iconPanel.setTitle("Curso");
		iconPanel.setIconCls("curso_16_16_icon");
		iconPanel.setWidth(800);
		iconPanel.setHeight(485);
		iconPanel.setCollapsible(true);
		// iconPanel.setHtml(getShortBogusMarkup());
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
		cssButtonAdicionar.addClickHandler(new ClickHanderAdicionarCurso());

		Button cssButtonRemover = new Button("Remover Curso");
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

		Label labelNome = new Label("Nome : ");
		labelNome.setHeight("25px");
		grid.setWidget(0, 0, labelNome);

		textBoxNome = new TextBox();
		textBoxNome.setStyleName("design_text_boxes");
		grid.setWidget(0, 2, textBoxNome);
		// textBox.setWidth("250px");

		Label labelDescricao = new Label("Descri\u00E7\u00E3o :");
		labelDescricao.setHeight("25px");
		grid.setWidget(1, 0, labelDescricao);

		textBoxDescricao = new TextBox();
		textBoxDescricao.setStyleName("design_text_boxes");
		grid.setWidget(1, 2, textBoxDescricao);
		// textBox_1.setWidth("250px");

		Label label_2 = new Label("Ementa : ");
		label_2.setHeight("25px");
		grid.setWidget(2, 0, label_2);

		richTextEmenta = new RichTextArea();
		richTextEmenta.setStyleName("design_text_boxes");
		grid.setWidget(2, 2, richTextEmenta);
		// richTextArea.setWidth("330px");

		Label label_3 = new Label("Data Inicial : ");
		label_3.setHeight("25px");
		grid.setWidget(3, 0, label_3);

		dateItemInicial = new DateItem("dateItemInicial");
		dateItemInicial.setTitle("");
		dateItemInicial.setHint("<nobr>Picklist based date input</nobr>");
		dateFormInicial = new DynamicForm();
		dateFormInicial.setItems(dateItemInicial);

		grid.setWidget(3, 2, dateFormInicial);

		Label label_4 = new Label("Data Final : ");
		label_4.setHeight("25px");
		grid.setWidget(4, 0, label_4);

		dateItemFinal = new DateItem();
		dateItemFinal.setTitle("");
		dateItemFinal.setHint("<nobr>Picklist based date input</nobr>");
		DynamicForm dateFormFinal = new DynamicForm();
		dateFormFinal.setItems(dateItemFinal);

		grid.setWidget(4, 2, dateFormFinal);

		// Button button = new Button("New button");
		// button.setText("Salvar Curso");
		// PushButton pushButton = new PushButton(new
		// Image("image/blockdevice_16.png"));
		// pushButton.setHTML("<Table cellspacing=2> <tr> <td>" + new
		// Image("image/image002.png") + "</td> <td  align=middle>" +
		// "Salvar Curso" + "</td></tr></Table>");
		// final Button cssButton = new Button("Salvar Curso");
		// cssButton.setShowRollOver(true);
		// cssButton.setShowDisabled(true);
		// cssButton.setShowDown(true);
		// cssButton.setIcon("../images/image002.png");
		//
		// grid.setWidget(5, 2, cssButton);
		// pushButton.setWidth("130px");
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

	public static GWTServiceCursoAsync getService() {
		// Create the client proxy. Note that although you are creating the
		// service interface proper, you cast the result to the asynchronous
		// version of the interface. The cast is always safe because the
		// generated proxy implements the asynchronous interface automatically.

		return GWT.create(GWTServiceCurso.class);
	}

	private class ClickHanderAdicionarCurso implements ClickHandler {

		@Override
		public void onClick(com.smartgwt.client.widgets.events.ClickEvent event) {
			Curso curso = new Curso();
			curso.setNome(textBoxNome.getText());
			curso.setDescricao(textBoxDescricao.getText());
			curso.setEmenta(richTextEmenta.getText());
			curso.setDtInicio(dateItemInicial.getValueAsDate());
			curso.setDtFim(dateItemFinal.getValueAsDate());

			getService().AdicionarCurso(curso, new AsyncCallback<Boolean>() {

				public void onFailure(Throwable caught) {
					// lblServerReply.setText("Communication failed");
					System.err.println("Communication failed");
				}

				@Override
				public void onSuccess(Boolean result) {
					// TODO Auto-generated method stub

				}
			});

		}
	}

}
