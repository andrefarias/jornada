package com.jornada.client.classes;


import com.smartgwt.client.data.DataSource;  
import com.smartgwt.client.data.fields.*;  
  
public class WorldXmlDS extends DataSource {  
  
    private static WorldXmlDS instance = null;  
  
    public static WorldXmlDS getInstance() {  
        if (instance == null) {  
            instance = new WorldXmlDS("worldDS");  
        }  
        return instance;  
    }  
  
    public WorldXmlDS(String id) {  
  
        setID(id);  
        setRecordXPath("/List/curso");  
        DataSourceIntegerField pkField = new DataSourceIntegerField("pk");  
        pkField.setHidden(true);  
        pkField.setPrimaryKey(true);  
  

        DataSourceTextField nomeCurso = new DataSourceTextField("nome_curso", "Nome");  
        nomeCurso.setRequired(true);  
  
        DataSourceTextField descricao = new DataSourceTextField("descricao", "Descricao");  
  
        DataSourceTextField ementa = new DataSourceTextField("ementa", "Ementa");  
          
        setFields(pkField, nomeCurso, descricao, ementa);  
  
        //setDataURL("ds/test_data/world.data.xml");  
        setClientOnly(true);  
    }  
}  
