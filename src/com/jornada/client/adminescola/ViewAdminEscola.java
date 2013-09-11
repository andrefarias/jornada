package com.jornada.client.adminescola;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.user.client.ui.AbstractImagePrototype;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Tree;
import com.google.gwt.user.client.ui.DockPanel;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.TreeItem;
import com.google.gwt.user.client.ui.Frame;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.cellview.client.CellTree;
import com.google.gwt.view.client.TreeViewModel;
import com.google.gwt.view.client.AbstractDataProvider;
import com.google.gwt.view.client.ListDataProvider;
import com.google.gwt.view.client.SelectionModel.AbstractSelectionModel;
import com.google.gwt.view.client.NoSelectionModel;
import com.google.gwt.view.client.TreeViewModel.NodeInfo;
import com.google.gwt.view.client.TreeViewModel.DefaultNodeInfo;
import com.google.gwt.cell.client.TextCell;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.CaptionPanel;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.RichTextArea;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.SplitLayoutPanel;
import com.google.gwt.user.client.ui.HorizontalSplitPanel;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.VerticalSplitPanel;
import com.google.gwt.user.client.ui.ScrollPanel;
import com.google.gwt.user.client.ui.NamedFrame;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.user.client.ui.TabPanel;
import com.jornada.client.MainMenu;
import com.jornada.client.MainView;
import com.jornada.client.classes.FadeAnimation;

public class ViewAdminEscola extends Composite {
	
	//MainView mainView;
	
	
	public interface Images extends ClientBundle, Tree.Resources {
	    ImageResource curso();
	    
	    ImageResource disciplina();
	    
	    ImageResource organizacao();

	    @Source("noimage.png")
	    ImageResource treeLeaf();

		ImageResource home();

		ImageResource conteudoprogramatico();

		ImageResource topico();
	  }
	
	

	MainView mainView;
	
	@SuppressWarnings("deprecation")
	public ViewAdminEscola(MainView mainView) {
		
		this.mainView = mainView;
		
		Images images = GWT.create(Images.class);
		
	    
	    VerticalPanel vPanel = new VerticalPanel();
	    vPanel.setSize("100%", "100%");
	    initWidget(vPanel);

		
		DockPanel dockPanel = new DockPanel();
		dockPanel.setBorderWidth(0);
		dockPanel.setSpacing(5);
		vPanel.add(dockPanel);
		dockPanel.setSize("919px", "100%");
		
		
		MainMenu mainMenu = new MainMenu(this.mainView);
		dockPanel.add(mainMenu, DockPanel.NORTH);
		
		TabPanel tabPanel = new TabPanel();
		tabPanel.setStyleName("fundo_tabela_componente");
		tabPanel.setAnimationEnabled(true);
		dockPanel.add(tabPanel, DockPanel.WEST);
		tabPanel.setSize("450px", "399px");
		
						

						
						ScrollPanel scrollPanel = new ScrollPanel();
						scrollPanel.setAlwaysShowScrollBars(true);
						scrollPanel.setTouchScrollingDisabled(false);
						tabPanel.add(scrollPanel, "Hierarquia Escolar", true);
						tabPanel.selectTab(0);
						
						scrollPanel.setStyleName("label_rodape");
						scrollPanel.setSize("433px", "356px");
						
						VerticalPanel verticalPanel = new VerticalPanel();
						scrollPanel.setWidget(verticalPanel);
						verticalPanel.setSize("100%", "100%");
						
						Button btnNewButton_1 = new Button("Cadastrar Curso");
						verticalPanel.add(btnNewButton_1);
						verticalPanel.setCellHorizontalAlignment(btnNewButton_1, HasHorizontalAlignment.ALIGN_CENTER);
						
	    Tree tree = new Tree(images);
	    verticalPanel.add(tree);
	    
	    TreeItem treeItemEscolaRuiBarbosa = new TreeItem(imageItemHTML(images.home(), "Escola : Rui Barbosa"));
	    tree.addItem(treeItemEscolaRuiBarbosa);
	    
	    	TreeItem treeItemCurso = new TreeItem(imageItemHTML(images.curso(), "Curso : Quarto Ano"));
	    	treeItemEscolaRuiBarbosa.addItem(treeItemCurso);
	    	
				TreeItem treeItemOrganizacao1 = new TreeItem(imageItemHTML(images.organizacao(), "Periodo : Primeiro Bimestre"));
				treeItemCurso.addItem(treeItemOrganizacao1);	    	
				
		    		TreeItem treeItemDisciplina = new TreeItem(imageItemHTML(images.disciplina(), "Disciplina : Portugues"));
		    		treeItemOrganizacao1.addItem(treeItemDisciplina);
		    		
		    			TreeItem treeItemConteudoProgramatico1 = new TreeItem(imageItemHTML(images.conteudoprogramatico(), "Conteudo Programatico : Interpretacao de Texto"));
		    			treeItemDisciplina.addItem(treeItemConteudoProgramatico1);
		    			
		    				TreeItem treeItemTopico1 = new TreeItem(imageItemHTML(images.topico(), "Topico : Leitura"));
		    				treeItemConteudoProgramatico1.addItem(treeItemTopico1);						
		    				
		    				TreeItem treeItemConteudoProgramatico2 = new TreeItem(imageItemHTML(images.conteudoprogramatico(), "Conteudo Programatico : Conjugacao Verbal"));
		    				treeItemDisciplina.addItem(treeItemConteudoProgramatico2);			
		    				
		    					TreeItem treeItemTopico2 = new TreeItem(imageItemHTML(images.topico(), "Topico : Passado"));
		    					treeItemConteudoProgramatico2.addItem(treeItemTopico2);
		    					
		    					TreeItem treeItemTopico3 = new TreeItem(imageItemHTML(images.topico(), "Topico : Presente"));
		    					treeItemConteudoProgramatico2.addItem(treeItemTopico3);
		    					
		    					TreeItem treeItemTopico4 = new TreeItem(imageItemHTML(images.topico(), "Topico : Futuro"));
		    					treeItemConteudoProgramatico2.addItem(treeItemTopico4);	
		    					
		    						TreeItem treeItemConteudoProgramatico3 = new TreeItem(imageItemHTML(images.conteudoprogramatico(), "Conteudo Programatico : Adjetivos"));
		    						treeItemDisciplina.addItem(treeItemConteudoProgramatico3);		
		    						
		    						
				    	TreeItem treeItemCurso_Y = new TreeItem(imageItemHTML(images.curso(), "Curso : Quinto Ano"));
				    	treeItemEscolaRuiBarbosa.addItem(treeItemCurso_Y);
				    	
							TreeItem treeItemOrganizacao1_Y = new TreeItem(imageItemHTML(images.organizacao(), "Periodo : Primeiro Bimestre"));
							treeItemCurso_Y.addItem(treeItemOrganizacao1_Y);	    	
							
					    		TreeItem treeItemDisciplina_Y = new TreeItem(imageItemHTML(images.disciplina(), "Disciplina : Matematica"));
					    		treeItemOrganizacao1_Y.addItem(treeItemDisciplina_Y);
					    		
					    			TreeItem treeItemConteudoProgramatico1_Y = new TreeItem(imageItemHTML(images.conteudoprogramatico(), "Conteudo Programatico : Trigonometria"));
					    			treeItemDisciplina_Y.addItem(treeItemConteudoProgramatico1_Y);
					    			
					    			
					    			
					    			
					    			
					    TreeItem treeItemEscola_X = new TreeItem(imageItemHTML(images.home(), "Escola : Da Villa"));
					    tree.addItem(treeItemEscola_X);
					    
					    	TreeItem treeItemCurso_X = new TreeItem(imageItemHTML(images.curso(), "Curso : Primeiro Ano"));
					    	treeItemEscola_X.addItem(treeItemCurso_X);
					    	
								TreeItem treeItemOrganizacao1_X = new TreeItem(imageItemHTML(images.organizacao(), "Periodo : Primeiro Bimestre"));
								treeItemCurso_X.addItem(treeItemOrganizacao1_X);	    	
								
						    		TreeItem treeItemDisciplina_X = new TreeItem(imageItemHTML(images.disciplina(), "Disciplina : Ciencias"));
						    		treeItemOrganizacao1_X.addItem(treeItemDisciplina_X);
						    		
						    			TreeItem treeItemConteudoProgramatico1_X = new TreeItem(imageItemHTML(images.conteudoprogramatico(), "Conteudo Programatico : Animais"));
						    			treeItemDisciplina_X.addItem(treeItemConteudoProgramatico1_X);
						    			
						    				TreeItem treeItemTopico1_X = new TreeItem(imageItemHTML(images.topico(), "Topico : Mamiferos"));
						    				treeItemConteudoProgramatico1_X.addItem(treeItemTopico1_X);						
						    				
						    				TreeItem treeItemConteudoProgramatico2_X = new TreeItem(imageItemHTML(images.conteudoprogramatico(), "Conteudo Programatico : Anfibios"));
						    				treeItemDisciplina_X.addItem(treeItemConteudoProgramatico2_X);			
						    				
						    					TreeItem treeItemTopico2_X = new TreeItem(imageItemHTML(images.topico(), "Topico : Repteis"));
						    					treeItemConteudoProgramatico2_X.addItem(treeItemTopico2_X);
						    					
						    					TreeItem treeItemTopico3_X = new TreeItem(imageItemHTML(images.topico(), "Topico : Insetos"));
						    					treeItemConteudoProgramatico2_X.addItem(treeItemTopico3_X);
						    					
						    					TreeItem treeItemTopico4_X = new TreeItem(imageItemHTML(images.topico(), "Topico : Peixes"));
						    					treeItemConteudoProgramatico2_X.addItem(treeItemTopico4_X);	
						    					
						
						
						//Tree tree = new Tree();
						tree.setAnimationEnabled(true);
						scrollPanel.setHorizontalScrollPosition(1);
						
						CaptionPanel cptnpnlCurso = new CaptionPanel("Curso");
						cptnpnlCurso.setStyleName("fundo_tabela_componente");
						dockPanel.add(cptnpnlCurso, DockPanel.CENTER);
						cptnpnlCurso.setSize("100%", "100%");
						
						Grid grid = new Grid(4, 3);
						cptnpnlCurso.setContentWidget(grid);
						grid.setSize("421px", "3cm");
						
						Label lblNome = new Label("Nome : ");
						grid.setWidget(0, 0, lblNome);
						
						TextBox textBox = new TextBox();
						textBox.setStyleName("design_text_boxes");
						grid.setWidget(0, 2, textBox);
						textBox.setWidth("250px");
						
						Label lblNewLabel = new Label("Descri\u00E7\u00E3o :");
						grid.setWidget(1, 0, lblNewLabel);
						
						TextBox textBox_1 = new TextBox();
						textBox_1.setStyleName("design_text_boxes");
						grid.setWidget(1, 2, textBox_1);
						textBox_1.setWidth("250px");
						
						Label lblNewLabel_1 = new Label("Ementa : ");
						grid.setWidget(2, 0, lblNewLabel_1);
						
						RichTextArea richTextArea = new RichTextArea();
						richTextArea.setStyleName("design_text_boxes");
						grid.setWidget(2, 2, richTextArea);
						richTextArea.setWidth("330px");
						
						Button btnNewButton = new Button("New button");
						btnNewButton.setText("Salvar Curso");
						grid.setWidget(3, 2, btnNewButton);
						grid.getCellFormatter().setHorizontalAlignment(3, 2, HasHorizontalAlignment.ALIGN_CENTER);
						
						FadeAnimation fadeAnimation = new FadeAnimation(verticalPanel.getElement());
						fadeAnimation.setOpacity(0.0);
						verticalPanel.setVisible(true);
						fadeAnimation.fade(1000, 1.0);	
	}
	
	

	  /**
	   * A helper method to simplify adding tree items that have attached images.
	   * {@link #addImageItem(TreeItem, String, ImageResource) code}
	   * 
	   * @param root the tree item to which the new item will be added.
	   * @param title the text associated with this item.
	   */
	  private TreeItem addImageItem(TreeItem root, String title,
	      ImageResource imageProto) {
	    TreeItem item = new TreeItem(imageItemHTML(imageProto, title));
	    root.addItem(item);
	    return item;
	  }

	  /**
	   * Generates HTML for a tree item with an attached icon.
	   * 
	   * @param imageProto the image prototype to use
	   * @param title the title of the item
	   * @return the resultant HTML
	   */
	  private String imageItemHTML(ImageResource imageProto, String title) {
	    return AbstractImagePrototype.create(imageProto).getHTML() + " " + title;
	  }
	  
	  
	   private class addClickHandler implements ClickHandler{

			@Override
			public void onClick(ClickEvent event) {
				// TODO Auto-generated method stub
				
				setVisible(false);
				//mainView.setVisible(true);
				
				
			}	


		}	  
	  
	  

}



