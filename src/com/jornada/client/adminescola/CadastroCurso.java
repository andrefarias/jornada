package com.jornada.client.adminescola;


import java.util.List;


import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.InlineHTML;
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
import com.jornada.client.service.GWTServiceCurso;
import com.jornada.client.service.GWTServiceCursoAsync;
import com.jornada.server.service.GWTServiceCursoImpl;
import com.jornada.shared.classes.Curso;
import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.data.fields.DataSourceTextField;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.AnimationEffect;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.Button;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.ImgButton;
import com.smartgwt.client.widgets.RichTextEditor;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.DateItem;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.layout.VLayout;
import com.gwtext.client.widgets.MessageBox;
import com.gwtext.client.widgets.Panel;
import com.smartgwt.client.widgets.layout.HLayout; 

public class CadastroCurso extends Composite{

	Label labelLoading;
	TextBox textBoxNome;
	TextBox textBoxDescricao;
	RichTextArea richTextEmenta;
	public ListGrid countryGrid;
	AsyncCallback callback;
	Curso curso;
	DynamicForm dateFormInicial;
	private ListGridRecord rollOverRecord;  
	private HLayout rollOverCanvas; 
	DateItem dateItemInicial;
	DateItem dateItemFinal;

	public CadastroCurso() {

		Panel iconPanel = new Panel();
		iconPanel.setTitle("Curso");
		iconPanel.setIconCls("curso_16_16_icon");
		iconPanel.setWidth(800);
		iconPanel.setHeight(485);
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

		HorizontalPanel hPanelGrig = new HorizontalPanel();
		hPanelGrig.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
		
		labelLoading = new Label("Loading...");
		labelLoading.setHeight("25px");
		labelLoading.setVisible(false);
		labelLoading.setStyleName("label_loading");
		labelLoading.setAutoHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		
		Grid grid = new Grid(5, 3);
		hPanelGrig.add(grid);
		hPanelGrig.add(new InlineHTML("&nbsp"));
		hPanelGrig.add(labelLoading);
		
		verticalPanelBody.add(hPanelGrig);
		grid.setCellPadding(3);
		//grid.setBorderWidth(1);


		Label labelNome = new Label("Nome : ");
		labelNome.setHeight("25px");
		grid.setWidget(0, 0, labelNome);

		textBoxNome = new TextBox();
		textBoxNome.setStyleName("design_text_boxes");
		grid.setWidget(0, 2, textBoxNome);

		
		Label labelDescricao = new Label("Descri\u00E7\u00E3o :");
		labelDescricao.setHeight("25px");
		grid.setWidget(1, 0, labelDescricao);

		textBoxDescricao = new TextBox();
		textBoxDescricao.setStyleName("design_text_boxes");
		grid.setWidget(1, 2, textBoxDescricao);
		// textBox_1.setWidth("250px");

		Label labelEmenta = new Label("Ementa : ");
		labelEmenta.setHeight("25px");
		grid.setWidget(2, 0, labelEmenta);

		richTextEmenta = new RichTextArea();
		richTextEmenta.setStyleName("design_text_boxes");
		grid.setWidget(2, 2, richTextEmenta);
		// richTextArea.setWidth("330px");

		Label labelDataInicial = new Label("Data Inicial : ");
		labelDataInicial.setHeight("25px");
		grid.setWidget(3, 0, labelDataInicial);

		dateItemInicial = new DateItem("dateItemInicial");
		dateItemInicial.setTitle("");
		//dateItemInicial.setHint("<nobr>Picklist based date input</nobr>");
		dateFormInicial = new DynamicForm();
		dateFormInicial.setItems(dateItemInicial);

		grid.setWidget(3, 2, dateFormInicial);

		Label labelDataFinal = new Label("Data Final : ");
		labelDataFinal.setHeight("25px");
		grid.setWidget(4, 0, labelDataFinal);

		dateItemFinal = new DateItem();
		dateItemFinal.setTitle("");
		//dateItemFinal.setHint("<nobr>Picklist based date input</nobr>");
		DynamicForm dateFormFinal = new DynamicForm();
		dateFormFinal.setItems(dateItemFinal);

		grid.setWidget(4, 2, dateFormFinal);

		grid.getCellFormatter().setHorizontalAlignment(3, 2,
				HasHorizontalAlignment.ALIGN_LEFT);

		Canvas canvas = new Canvas();  
		
	
		countryGrid = new ListGrid(){  
            @Override  
            protected Canvas getRollOverCanvas(Integer rowNum, Integer colNum) {  
                rollOverRecord = this.getRecord(rowNum);  
  
                if(rollOverCanvas == null) {  
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
							SC.say("Edit Comment Icon Clicked for country : " + rollOverRecord.getAttribute("nome_curso"));  
							
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
                            SC.say("Do you really want to remove this course? : " + rollOverRecord.getAttribute("nome_curso"));  
                        }  
                    });  
  
                    rollOverCanvas.addMember(editImg);  
                    rollOverCanvas.addMember(chartImg);  
                }  
                return rollOverCanvas;  
  
            }  
        };  
        countryGrid.setShowRollOverCanvas(true);
		
		
		
		countryGrid.setWidth(800);
		countryGrid.setHeight(150);
		countryGrid.setShowFilterEditor(true);
		countryGrid.setFilterOnKeypress(true);
	    countryGrid.setShowAllRecords(true);
	    countryGrid.setShowEmptyMessage(true);
		countryGrid.setDataSource(WorldXmlDS.getInstance());
		initSelector();			
		countryGrid.setAutoFetchData(true);
	

		// ListGridField countryCodeField = new ListGridField("countryCode",
		// "Code", 50);
		ListGridField nameField = new ListGridField("nome_curso", "Nome");
		ListGridField descricaoField = new ListGridField("descricao", "Descricao");
		ListGridField ementaField = new ListGridField("ementa", "Ementa");
		ListGridField dataInicialField = new ListGridField("dataInicial","Data Inicial");
		ListGridField dataFinalField = new ListGridField("dataFinal","Data Final");
		ListGridField editarField = new ListGridField("edit","Editar");
		editarField.setWidth("60px");
		countryGrid.setFields(nameField, descricaoField, ementaField,dataInicialField, dataFinalField, editarField);

		canvas.addChild(countryGrid);
		
		verticalPanelBody.add(canvas);

		verticalPanelPage.add(verticalPanelTitle);
		verticalPanelPage.add(verticalPanelBody);
		verticalPanelPage.add(verticalPanelFooter);

		iconPanel.add(verticalPanelPage);
		


		initWidget(iconPanel);

		// Create an asynchronous callback to handle the result.
		callback = new AsyncCallback() {

			public void onFailure(Throwable caught) {
				// lblServerReply.setText("Communication failed");
				//System.err.println("Communication failed");
				MessageBox.alert("2)Curso nao pode ser salvo com sucesso");
			}

			@Override
			public void onSuccess(Object result) {
				labelLoading.setVisible(false);
				boolean isSuccess = (Boolean)result;
				if(isSuccess){
					MessageBox.alert("Curso salvo com sucesso");					
				}
				else{
					MessageBox.alert("1)Curso nao pode ser salvo com sucesso");
				}
				
				  

			}
			
		};
		
		
		
		
//		ArrayList<Map<String, Object>> data = getService().getCursos();
//		DataSource dataSource = new DataSource();
//		
//		for(Map<String, Object> dataItem : data){
//			ListGridRecord record = new ListGridRecord();
//			record.setAttribute("id_curso",(String)dataItem.get("id_curso"));
//			record.setAttribute("nome_curso",(String)dataItem.get("nome_curso"));
//			record.setAttribute("descricao",(String)dataItem.get("descricao"));
//			record.setAttribute("ementa",(String)dataItem.get("ementa"));
//			record.setAttribute("data_inicial",(String)dataItem.get("data_inicial"));
//			record.setAttribute("data_final",(String)dataItem.get("data_final"));
//			record.setAttribute("id_departamento",(String)dataItem.get("id_departamento"));
//			dataSource.addData(record);
//		}
		
		

	}

	public static GWTServiceCursoAsync getServiceAsync() {

		return GWT.create(GWTServiceCurso.class);
	}	


	private class ClickHanderAdicionarCurso implements ClickHandler {

		@Override
		public void onClick(com.smartgwt.client.widgets.events.ClickEvent event) {
			labelLoading.setVisible(true);
			curso = new Curso();
			curso.setNome(textBoxNome.getText());
			curso.setDescricao(textBoxDescricao.getText());
			curso.setEmenta(richTextEmenta.getText());
//			curso.setDtInicio(dateItemInicial.getValueAsDate());
//			curso.setDtFim(dateItemFinal.getValueAsDate());

			//DateItem dateItemInicial = (DateItem) dateFormInicial.getItem("dateItemInicial");
			//System.out.println("DateInicial:"+ dateItemInicial.getValueAsDate());
			getServiceAsync().AdicionarCurso(curso, callback);

		}

	}

	
	
	private void initSelector() {
		getServiceAsync().getCursos(
				new AsyncCallback<List<Curso>>() {

					@Override
					public void onFailure(Throwable caught) {
						// TODO Auto-generated method stub
						MessageBox.alert("It was not possible to load data.");

					}

					@Override
					public void onSuccess(List<Curso> listCursos) {
						
						countryGrid.selectAllRecords();
						countryGrid.removeSelectedData();

						for(Curso curso : listCursos){
							
							ListGridRecord record = new ListGridRecord();
							
							record.setAttribute("nome_curso",curso.getNome());							
							record.setAttribute("descricao",curso.getDescricao());
							record.setAttribute("ementa",curso.getEmenta());

							countryGrid.addData(record);

						}

					}

				});

	}
	
	
}
