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
import com.gwtext.client.data.Record;
import com.gwtext.client.data.SimpleStore;
import com.gwtext.client.data.Store;
import com.gwtext.client.widgets.Panel;
import com.gwtext.client.widgets.form.ComboBox;
import com.gwtext.client.widgets.form.event.ComboBoxListenerAdapter;
import com.jornada.client.MainView;
import com.jornada.client.classes.WorldXmlDS;
import com.jornada.client.service.GWTServiceCurso;
import com.jornada.client.service.GWTServiceCursoAsync;
import com.jornada.client.service.GWTServicePeriodo;
import com.jornada.client.service.GWTServicePeriodoAsync;
import com.jornada.shared.classes.Curso;
import com.jornada.shared.classes.Periodo;
import com.smartgwt.client.widgets.Button;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.grid.ListGridField;

public class CadastroDisciplina extends Composite {

	private Button btnSalvarDisciplina;
	private Button btnAdicionarDisciplina;
	private Button btnRemoverDisciplina;

	private Store cursosStore;
	private final ComboBox cbCurso;
	private Store periodosStore;
	private final ComboBox cbPeriodo;
	private TextBox txtNome;
	private TextBox txtDescricao;
	private RichTextArea rtaEmenta;
	private RichTextArea rtaObjetivo;
	public ListGrid gridDisciplinas;

	// cursos store
	Object[][] cursos = null;

	// cities store
	Object[][] periodos = new Object[][] {
			new Object[] { new Integer(1), "1A	no", "1 Bimestre" },
			new Object[] { new Integer(2), "1Ano", "2 Bimestre" },
			new Object[] { new Integer(3), "1Ano", "3 Bimestre" },
			new Object[] { new Integer(4), "1Ano", "4 Bimestre" },
			new Object[] { new Integer(5), "2Ano", "1 Semestre" },
			new Object[] { new Integer(6), "2Ano", "2 Semestre" },
			new Object[] { new Integer(7), "4Ano", "1 Semestre" },
			new Object[] { new Integer(8), "4Ano", "2 Semestre" },
			new Object[] { new Integer(9), "3Ano", "1 Trimestre" },
			new Object[] { new Integer(10), "3Ano", "2 Trimestre" },
			new Object[] { new Integer(11), "3Ano", "3 Trimestre" } };

	public CadastroDisciplina() {

		Panel iconPanel = new Panel();
		iconPanel.setTitle("Disciplina");
		iconPanel.setIconCls("disciplina_16_16_icon");
		iconPanel.setWidth(800);
		iconPanel.setHeight(485);
		iconPanel.setCollapsible(true);
		iconPanel.setShadow(true);
		iconPanel.setPaddings(0);

		VerticalPanel verticalPanelPage = new VerticalPanel();

		btnSalvarDisciplina = new Button("Salvar Disciplina");
		btnSalvarDisciplina.setWidth("150px");
		btnSalvarDisciplina.setShowRollOver(true);
		btnSalvarDisciplina.setShowDisabled(true);
		btnSalvarDisciplina.setShowDown(true);
		btnSalvarDisciplina.setIcon("../images/save.png");

		btnAdicionarDisciplina = new Button("Adicionar Nova Disciplina");
		btnAdicionarDisciplina.setWidth("150px");
		btnAdicionarDisciplina.setShowRollOver(true);
		btnAdicionarDisciplina.setShowDisabled(true);
		btnAdicionarDisciplina.setShowDown(true);
		btnAdicionarDisciplina.setIcon("../images/plus-circle.png");

		btnRemoverDisciplina = new Button("Remover Disciplina");
		btnRemoverDisciplina.setWidth("150px");
		btnRemoverDisciplina.setShowRollOver(true);
		btnRemoverDisciplina.setShowDisabled(true);
		btnRemoverDisciplina.setShowDown(true);
		btnRemoverDisciplina.setIcon("../images/delete.png");

		VerticalPanel verticalPanelTitle = new VerticalPanel();
		// verticalPanelTitle.setSize("10px", "10px");
		HorizontalPanel hPanel = new HorizontalPanel();
		hPanel.add(btnSalvarDisciplina);
		hPanel.add(btnAdicionarDisciplina);
		hPanel.add(btnRemoverDisciplina);

		verticalPanelTitle.add(hPanel);

		VerticalPanel verticalPanelFooter = new VerticalPanel();
		verticalPanelFooter.setSize("10px", "10px");

		VerticalPanel verticalPanelBody = new VerticalPanel();

		verticalPanelBody.setSize("400px", "400px");

		Grid grid = new Grid(6, 3);
		verticalPanelBody.add(grid);
		grid.setCellPadding(3);

		int cv = 0;

		Label lblCurso = new Label("Curso : ");
		lblCurso.setHeight("25px");
		grid.setWidget(cv, 0, lblCurso);

		cbCurso = new ComboBox();
		cbCurso.setFieldLabel("Selecione o curso");
		cbCurso.setDisplayField("cursos");
		cbCurso.setMode(ComboBox.LOCAL);
		//cbCurso.setTriggerAction(ComboBox.ALL);
		cbCurso.setForceSelection(true);
		cbCurso.setValueField("cid");
		//cbCurso.addListener(new CustomComboBoxListener());
		popularCursos();
		
		grid.setWidget(cv, 2, cbCurso);

		cv++;

		Label lblPeriodo = new Label("Periodo : ");
		lblPeriodo.setHeight("25px");
		grid.setWidget(cv, 0, lblPeriodo);

		cbPeriodo = new ComboBox();
		cbPeriodo.setFieldLabel("Selecione o período");
		cbPeriodo.setDisplayField("periodos");
		cbPeriodo.setValueField("id");
		cbPeriodo.setMode(ComboBox.LOCAL);
		//cbPeriodo.setTriggerAction(ComboBox.ALL);
		cbPeriodo.setLinked(true);
		cbPeriodo.setForceSelection(true);
		cbPeriodo.setDisabled(true);

		grid.setWidget(cv, 2, cbPeriodo);

		cv++;

		Label lblNome = new Label("Nome : ");
		lblNome.setHeight("25px");
		grid.setWidget(cv, 0, lblNome);

		txtNome = new TextBox();
		txtNome.setStyleName("design_text_boxes");
		grid.setWidget(cv, 2, txtNome);
		txtNome.setEnabled(false);

		cv++;

		Label lblDescricao = new Label("Descri\u00E7\u00E3o :");
		lblDescricao.setHeight("25px");
		grid.setWidget(cv, 0, lblDescricao);

		txtDescricao = new TextBox();
		txtDescricao.setStyleName("design_text_boxes");
		grid.setWidget(cv, 2, txtDescricao);
		txtDescricao.setEnabled(false);

		cv++;

		Label lblEmenta = new Label("Ementa : ");
		lblEmenta.setHeight("25px");
		grid.setWidget(cv, 0, lblEmenta);

		rtaEmenta = new RichTextArea();
		rtaEmenta.setStyleName("design_text_boxes");
		grid.setWidget(cv, 2, rtaEmenta);
		rtaEmenta.setEnabled(false);

		cv++;

		Label lblObjetivo = new Label("Objetivo: ");
		lblObjetivo.setHeight("25px");
		grid.setWidget(cv, 0, lblObjetivo);

		rtaObjetivo = new RichTextArea();
		rtaObjetivo.setStyleName("design_text_boxes");
		grid.setWidget(cv, 2, rtaObjetivo);
		rtaObjetivo.setEnabled(false);

		grid.getCellFormatter().setHorizontalAlignment(3, 2,
				HasHorizontalAlignment.ALIGN_LEFT);

		gridDisciplinas = new ListGrid();
		gridDisciplinas.setWidth(800);
		gridDisciplinas.setHeight(150);
		gridDisciplinas.setDataSource(WorldXmlDS.getInstance());
		gridDisciplinas.setAutoFetchData(true);

		ListGridField nameField = new ListGridField("courseName", "Nome");
		ListGridField capitalField = new ListGridField("descricao", "Descricao");
		ListGridField continentField = new ListGridField("ementa", "Ementa");
		ListGridField dataInicialField = new ListGridField("dataInicial",
				"Data Inicial");
		ListGridField dataFinalField = new ListGridField("dataFinal",
				"Data Final");
		gridDisciplinas.setFields(nameField, capitalField, continentField,
				dataInicialField, dataFinalField);

		verticalPanelBody.add(gridDisciplinas);

		verticalPanelPage.add(verticalPanelTitle);
		verticalPanelPage.add(verticalPanelBody);
		verticalPanelPage.add(verticalPanelFooter);

		iconPanel.add(verticalPanelPage);

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
							"cursos" }, cursos);
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

	private void popularPeriodos(int idCurso) {
		GWTServicePeriodoAsync service = GWT.create(GWTServicePeriodo.class);

		service.getPeriodosByCurso(idCurso, new AsyncCallback<List<Periodo>>() {

			@Override
			public void onSuccess(List<Periodo> result) {
				periodos = new Object[result.size()][3];

				int count = 0;
				for (Periodo periodo : result) {
					cursos[count++] = new Object[] { periodo.getIdPeriodo(),
							periodo.getIdCurso(), periodo.getDescricao() };
				}

				periodosStore = new SimpleStore(new String[] { "id", "cid",
						"periodos" }, periodos);
				periodosStore.load();
				cbPeriodo.setStore(periodosStore);
			}

			@Override
			public void onFailure(Throwable caught) {
				System.out.println("Erro getPeriodosByCurso");
			}
		});

	}

	private class CustomComboBoxListener extends ComboBoxListenerAdapter {
		@Override
		public void onSelect(ComboBox comboBox, Record record, int index) {
			popularPeriodos(record.getAsInteger("cid"));
		}
		
		
	}

}
