package com.jornada.client.adminescola;

import java.util.List;

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
import com.gwtext.client.widgets.MessageBox;
import com.gwtext.client.widgets.Panel;
import com.gwtext.client.widgets.form.ComboBox;
import com.jornada.client.MainView;
import com.jornada.client.classes.WorldXmlDS;
import com.jornada.client.service.GWTServiceCurso;
import com.jornada.client.service.GWTServiceCursoAsync;
import com.jornada.client.service.GWTServicePeriodo;
import com.jornada.client.service.GWTServicePeriodoAsync;
import com.jornada.shared.classes.Curso;
import com.jornada.shared.classes.Periodo;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.Button;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.ImgButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.layout.HLayout;

public class CadastroPeriodo extends Composite {

	private static GWTServicePeriodoAsync periodoService = null;

	ComboBox cbCurso;
	TextBox txtNome;
	TextBox txtDescricao;
	TextBox txtNumeracao;
	RichTextArea rtaObjetivo;
	public ListGrid periodoGrid;
	private ListGridRecord rollOverRecord;
	private HLayout rollOverCanvas;

	// cursos store
	Object[][] cursos = null;
	private Store cursosStore;

	public static GWTServicePeriodoAsync getPeriodoService() {
		if (periodoService == null) {
			periodoService = GWT.create(GWTServicePeriodo.class);
		}
		return periodoService;
	}

	public CadastroPeriodo() {
		
		Panel iconPanel = new Panel();
		iconPanel.setTitle("Periodo");
		iconPanel.setIconCls("periodo_16_16_icon");
		iconPanel.setWidth(800);
		iconPanel.setHeight(485);
		iconPanel.setCollapsible(true);
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
		HorizontalPanel hPanel = new HorizontalPanel();
		hPanel.add(cssButton);
		hPanel.add(cssButtonAdicionar);
		hPanel.add(cssButtonRemover);

		verticalPanelTitle.add(hPanel);

		VerticalPanel verticalPanelFooter = new VerticalPanel();
		verticalPanelFooter.setSize("10px", "10px");

		VerticalPanel verticalPanelBody = new VerticalPanel();

		verticalPanelBody.setSize("400px", "400px");

		Grid grid = new Grid(6, 3);
		verticalPanelBody.add(grid);
		grid.setCellPadding(3);

		int cv = 0;

		Label labelCurso = new Label("Curso : ");
		labelCurso.setHeight("25px");
		grid.setWidget(cv, 0, labelCurso);

		cbCurso = new ComboBox();
		cbCurso.setFieldLabel("Selecione um curso");
		cbCurso.setDisplayField("curso");
		cbCurso.setMode(ComboBox.LOCAL);
		cbCurso.setForceSelection(true);
		cbCurso.setValueField("cid");
		popularCursos();

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

		Canvas canvas = new Canvas();

		periodoGrid = new ListGrid() {
			@Override
			protected Canvas getRollOverCanvas(Integer rowNum, Integer colNum) {
				rollOverRecord = this.getRecord(rowNum);

				if (rollOverCanvas == null) {
					rollOverCanvas = new HLayout(3);
					rollOverCanvas.setSnapTo("TR");
					rollOverCanvas.setWidth(50);
					rollOverCanvas.setHeight(22);

					ImgButton editImg = new ImgButton();
					editImg.setShowDown(false);
					editImg.setShowRollOver(false);
					editImg.setLayoutAlign(Alignment.CENTER);
					editImg.setSrc("../images/comment_edit.png");
					editImg.setPrompt("Edit Comments");
					editImg.setHeight(16);
					editImg.setWidth(16);
					editImg.addClickHandler(new ClickHandler() {
						@Override
						public void onClick(ClickEvent event) {
							SC.say("Edit Comment Icon Clicked for country : "
									+ rollOverRecord.getAttribute("nome_curso"));

						}
					});

					ImgButton chartImg = new ImgButton();
					chartImg.setShowDown(false);
					chartImg.setShowRollOver(false);
					chartImg.setLayoutAlign(Alignment.CENTER);
					chartImg.setSrc("../images/delete.png");
					chartImg.setPrompt("Remover Curso");
					chartImg.setHeight(16);
					chartImg.setWidth(16);
					chartImg.addClickHandler(new ClickHandler() {
						public void onClick(ClickEvent event) {
							SC.say("Do you really want to remove this course? : "
									+ rollOverRecord.getAttribute("nome_curso"));
						}
					});

					rollOverCanvas.addMember(editImg);
					rollOverCanvas.addMember(chartImg);
				}
				return rollOverCanvas;

			}
		};
		periodoGrid.setShowRollOverCanvas(true);

		periodoGrid.setWidth(800);
		periodoGrid.setHeight(150);
		periodoGrid.setDataSource(WorldXmlDS.getInstance());
		periodoGrid.setAutoFetchData(true);

		ListGridField nomeField = new ListGridField("nome_modulo", "Nome");
		ListGridField descricaoField = new ListGridField("descricao",
				"Descricao");
		ListGridField ementaField = new ListGridField("numeracao", "Ementa");
		periodoGrid.setFields(nomeField, descricaoField, ementaField);

		canvas.addChild(periodoGrid);

		verticalPanelBody.add(canvas);

		verticalPanelPage.add(verticalPanelTitle);
		verticalPanelPage.add(verticalPanelBody);
		verticalPanelPage.add(verticalPanelFooter);

		iconPanel.add(verticalPanelPage);

		initSelector();
		initWidget(iconPanel);

	}
	
	private void popularCursos() {
		
		MainView.showMessage("Carregando...");
		
		GWTServiceCursoAsync service = GWT.create(GWTServiceCurso.class);
		try {

			service.getCursos(new AsyncCallback<List<Curso>>() {

				@Override
				public void onFailure(Throwable caught) {
					System.out.println("Erro getCursos");
				}

				@Override
				public void onSuccess(List<Curso> result) {

					cursos = new Object[result.size()][2];

					int count = 0;
					for (Curso curso : result) {
						cursos[count++] = new Object[] { curso.getIdCurso(),
								curso.getNome() };
					}

					cursosStore = new SimpleStore(new String[] { "cid",
							"curso" }, cursos);
					cursosStore.load();
					cbCurso.setStore(cursosStore);
					
					MainView.hideMessage();
				}

			});
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			ex.printStackTrace();
		}
	}

	private void initSelector() {
		
		MainView.showMessage("Carregando...");
		
		getPeriodoService().getPeriodos(new AsyncCallback<List<Periodo>>() {

			@Override
			public void onFailure(Throwable caught) {
				MessageBox.alert("It was not possible to load data.");

			}

			@Override
			public void onSuccess(List<Periodo> result) {
				periodoGrid.selectAllRecords();
				periodoGrid.removeSelectedData();

				for (Periodo periodo : result) {

					ListGridRecord record = new ListGridRecord();

					record.setAttribute("nome_modulo", periodo.getNomeModulo());
					record.setAttribute("descricao", periodo.getDescricao());
					record.setAttribute("numeracao", periodo.getNumeracao());

					periodoGrid.addData(record);

					MainView.hideMessage();
				}

			}

		});
	}

	private class AdicionarPeriodoClickHandler implements ClickHandler {

		@Override
		public void onClick(ClickEvent event) {

			MainView.showMessage("Carregando...");
			
			Periodo periodo = new Periodo();

			periodo.setIdCurso(Integer.parseInt(cbCurso.getValue()));
			periodo.setNomeModulo(txtNome.getText());
			periodo.setDescricao(txtDescricao.getText());
			periodo.setNumeracao(txtNumeracao.getText());
			periodo.setObjetivo(rtaObjetivo.getText());

			getPeriodoService().AdicionarPeriodo(periodo,
					new AsyncCallback<Boolean>() {

						@Override
						public void onFailure(Throwable caught) {
							// TODO Auto-generated method stub

						}

						@Override
						public void onSuccess(Boolean result) {
							initSelector();
							MainView.hideMessage();
						}

					});

		}

	}

}