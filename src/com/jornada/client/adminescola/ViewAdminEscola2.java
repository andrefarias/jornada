package com.jornada.client.adminescola;

import com.google.gwt.core.client.GWT;
import com.gwtext.client.widgets.tree.event.TreePanelListenerAdapter; 
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.user.client.ui.AbstractImagePrototype;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DockPanel;
import com.google.gwt.user.client.ui.ScrollPanel;
import com.google.gwt.user.client.ui.Tree;
import com.google.gwt.user.client.ui.TreeItem;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.gwtext.client.widgets.menu.BaseItem;
import com.gwtext.client.widgets.menu.Item;
import com.gwtext.client.widgets.menu.Menu;
import com.gwtext.client.widgets.menu.event.BaseItemListenerAdapter;
import com.gwtext.client.widgets.tree.TreeEditor;
import com.gwtext.client.widgets.tree.TreeNode;
import com.gwtext.client.widgets.tree.TreePanel;
import com.jornada.client.MainView;
import com.smartgwt.client.widgets.layout.PortalLayout;
import com.smartgwt.client.widgets.layout.Portlet;
import com.gwtext.client.core.EventObject;
import com.gwtext.client.data.NodeTraversalCallback;  
import com.gwtext.client.data.Node; 

public class ViewAdminEscola2 extends Composite {
	
	//MainView mainView;
	
	

    private Menu menu;  
    private TreeNode ctxNode;  
    private TreeEditor treeEditor; 	
	
	

	MainView mainView;
	
	@SuppressWarnings("deprecation")
	public ViewAdminEscola2(MainView mainView) {
		
		this.mainView = mainView;
		
		//Images images = GWT.create(Images.class);
		
	    
	    VerticalPanel vPanel = new VerticalPanel();
	    vPanel.setBorderWidth(0);
	    vPanel.setSize("100%", "100%");
	    initWidget(vPanel);

		
		DockPanel dockPanel = new DockPanel();
		dockPanel.setBorderWidth(0);
		dockPanel.setSpacing(5);
		vPanel.add(dockPanel);
		dockPanel.setSize("350px", "100%");
		
		VerticalPanel tabPanel = new VerticalPanel();
		tabPanel.setStyleName("fundo_tabela_componente");
		//tabPanel.setAnimationEnabled(true);
		dockPanel.add(tabPanel, DockPanel.WEST);
		tabPanel.setSize("400px", "450px");
		
						

						
						ScrollPanel scrollPanel = new ScrollPanel();
						scrollPanel.setAlwaysShowScrollBars(true);
						scrollPanel.setTouchScrollingDisabled(false);
						tabPanel.add(scrollPanel);
			//			tabPanel.selectTab(0);
						
						scrollPanel.setStyleName("label_rodape");
						scrollPanel.setSize("400px", "100%");
						
						VerticalPanel verticalPanel = new VerticalPanel();
						scrollPanel.setWidget(verticalPanel);
						verticalPanel.setSize("350px", "100%");
	    
	    TreePanel trpnlHierarquiaEscola = new TreePanel();
	    
	    trpnlHierarquiaEscola.addListener(new TreePanelListenerAdapter() {  
            public void onContextMenu(TreeNode node, EventObject e) {  
                int[] xy = e.getXY();  
                showContextMenu(node, e);  
            }  
        });	    
	    
	    TreeNode trndroot = new TreeNode("Escola : Rui Barbosa", "");
	    trndroot.setIcon("images/home.png");
	    
	    TreeNode trndCurso = new TreeNode("Curso : 1 ANO - Ensino Fundamental", "");
	    trndCurso.setIcon("images/curso.png");
	    
//	    TreeNode trndPeriodo = new TreeNode("Periodo", "");
//	    trndPeriodo.setIcon("image/config_date_1.png");
	    
	    TreeNode trndPrimeiroBimestre = new TreeNode("Primeiro Bimestre", "");
	    trndPrimeiroBimestre.setIcon("images/folder-icon.png");
	    
	    TreeNode trndPortugues = new TreeNode("Portugues", "");
	    trndPortugues.setIcon("images/book_16_16.png");
	    
	    TreeNode trndAvisos = new TreeNode("Conteudo Programatico", "");
	    trndAvisos.setIcon("images/conteudoprogramatico.png");
	    
	    TreeNode trndInterpretao = new TreeNode("1 - Interpreta\u00E7\u00E3o Texto", "");
	    trndInterpretao.setIcon("images/topico_old.png");
	    
	    TreeNode trndLeitura = new TreeNode("1.1 - Leitura", "");
	    trndLeitura.setIcon("images/topico.png");
	    trndInterpretao.appendChild(trndLeitura);
	    trndAvisos.appendChild(trndInterpretao);
	    
	    TreeNode trndTemposVerbais = new TreeNode("2 - Tempos Verbais", "");
	    trndTemposVerbais.setIcon("images/topico_old.png");
	    
	    TreeNode trndPassado = new TreeNode("2.1 - Passado", "");
	    trndPassado.setIcon("images/topico.png");
	    trndTemposVerbais.appendChild(trndPassado);
	    
	    TreeNode trndPresente = new TreeNode("2.2 - Presente", "");
	    trndPresente.setIcon("images/topico.png");
	    trndTemposVerbais.appendChild(trndPresente);
	    
	    TreeNode trndFuturo = new TreeNode("2.3 - Futuro", "");
	    trndFuturo.setIcon("images/topico.png");
	    trndTemposVerbais.appendChild(trndFuturo);
	    trndAvisos.appendChild(trndTemposVerbais);
	    trndPortugues.appendChild(trndAvisos);
	    trndPrimeiroBimestre.appendChild(trndPortugues);
	    
	    TreeNode trndMatematica = new TreeNode("Matematica", "");
	    trndMatematica.setIcon("images/book_16_16.png");
	    
	    TreeNode trndGeometria = new TreeNode("Geometria", "");
	    trndGeometria.setIcon("images/topico_old.png");
	    
	    TreeNode trndTriangulos = new TreeNode("Triangulos", "");
	    trndTriangulos.setIcon("images/topico.png");
	    trndGeometria.appendChild(trndTriangulos);
	    
	    TreeNode trndRetangulos = new TreeNode("Retangulos", "");
	    trndRetangulos.setIcon("images/topico.png");
	    trndGeometria.appendChild(trndRetangulos);
	    trndMatematica.appendChild(trndGeometria);
	    trndPrimeiroBimestre.appendChild(trndMatematica);
	    //trndPeriodo.appendChild(trndPrimeiroBimestre);
	    
	    TreeNode trndSegundoBimestre = new TreeNode("Segundo Bimestre", "");
	    trndSegundoBimestre.setIcon("images/folder-icon.png");
	    //trndPeriodo.appendChild(trndSegundoBimestre);
	    trndCurso.appendChild(trndPrimeiroBimestre);
	    trndCurso.appendChild(trndSegundoBimestre);
	    trndroot.appendChild(trndCurso);
	    trpnlHierarquiaEscola.setRootNode(trndroot);
	    trpnlHierarquiaEscola.setTitle("Hierarquia Escola");
	    verticalPanel.add(trpnlHierarquiaEscola);
	    trpnlHierarquiaEscola.setSize("380px", "430px");
	    scrollPanel.setHorizontalScrollPosition(1);
	    
      

	    CadastroCurso2 cadCurso = new CadastroCurso2();
	    //cadCurso.countryGrid.setVisible(false);
	    
//        final PortalLayout portalLayout = new PortalLayout(1);  
//        portalLayout.setSize("500px", "400px");  
//        //portalLayout.setHeight100();        
//        Portlet portlet = new Portlet();  
//        portlet.setTitle("Portlet");  
//        portlet.addItem(cadCurso);
//        portalLayout.setShowColumnMenus(false);
//        portalLayout.addPortlet(portlet);	    
//	    

	    
	    dockPanel.add(cadCurso, DockPanel.EAST);
	    cadCurso.setSize("801px", "458px");
						
	}
	
	
	
	
    private void showContextMenu(final TreeNode node, EventObject e) {  
        if (menu == null) {  
            menu = new Menu();  
            Item editItem = new Item("Editar", new BaseItemListenerAdapter() {  
                public void onClick(BaseItem item, EventObject e) {  
                    treeEditor.startEdit(ctxNode);  
                }  
            });  
            editItem.setId("edit-item");  
            menu.addItem(editItem);  
  
            Item disableItem = new Item("Desabilitar", new BaseItemListenerAdapter() {  
                public void onClick(BaseItem item, EventObject e) {  
                    ctxNode.disable();  
                    ctxNode.cascade(new NodeTraversalCallback() {  
                        public boolean execute(Node node) {  
                            ((TreeNode) node).disable();  
                            return true;  
                        }  
                    });  
                }  
            });  
            disableItem.setId("disable-item");  
            menu.addItem(disableItem);  
  
            Item enableItem = new Item("Habilitar", new BaseItemListenerAdapter() {  
                public void onClick(BaseItem item, EventObject e) {  
                    ctxNode.enable();  
                    ctxNode.cascade(new NodeTraversalCallback() {  
                        public boolean execute(Node node) {  
                            ((TreeNode) node).enable();  
                            return true;  
                        }  
                    });  
                }  
            });  
            enableItem.setId("enable-item");  
            menu.addItem(enableItem);  
  
            Item cloneItem = new Item("Copiar", new BaseItemListenerAdapter() {  
                public void onClick(BaseItem item, EventObject e) {  
                    TreeNode clone = ctxNode.cloneNode();  
                    clone.setText("Copy of " + clone.getText());  
                    ctxNode.getParentNode().appendChild(clone);  
                    treeEditor.startEdit(clone);  
                }  
            });  
            cloneItem.setId("clone-item");  
            menu.addItem(cloneItem);  
  
            Item newFolderItem = new Item("Novo", new BaseItemListenerAdapter() {  
                public void onClick(BaseItem item, EventObject e) {  
                    TreeNode newFolder = new TreeNode("New Folder");  
                    ctxNode.getParentNode().appendChild(newFolder);  
                    treeEditor.startEdit(newFolder);  
                }  
            });  
            newFolderItem.setId("newfolder-item");  
            menu.addItem(newFolderItem);  
        }  
  
        if (ctxNode != null) {  
            ctxNode = null;  
        }  
        ctxNode = node;  
  
  
        if (ctxNode.isDisabled()) {  
            menu.getItem("disable-item").disable();  
            menu.getItem("enable-item").enable();  
        } else {  
            menu.getItem("disable-item").enable();  
            menu.getItem("enable-item").disable();  
        }  
        menu.showAt(e.getXY());  
    }  	


	  
	  

	    	   
	  
	  

}



