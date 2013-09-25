/*******************************************************************************
 * Copyright 2011 Google Inc. All Rights Reserved.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
package com.jornada.server.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.jornada.client.Jornada;
import com.jornada.client.service.GWTServiceCurso;
import com.jornada.shared.classes.Curso;
import com.jornada.shared.database.JornadaDataBase;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

public class GWTServiceCursoImpl extends RemoteServiceServlet implements GWTServiceCurso {

	@Override
	public boolean AdicionarCurso(Curso curso) {
		// TODO Auto-generated method stub		

		boolean isOperationDone = false;
		
		JornadaDataBase dataBase = new JornadaDataBase();
		
		try
		{			
			dataBase.open();
			Connection connection = dataBase.getConnection();
			
			PreparedStatement updateCurso = connection.prepareStatement(Curso.DB_UPDATE_CURSO);
            int count = 0;
            updateCurso.setString(++count, curso.getNome());
            updateCurso.setString(++count, curso.getDescricao());
            updateCurso.setString(++count, curso.getEmenta());		
            updateCurso.setInt(++count, curso.getIdCurso());
            
            int numberUpdate = updateCurso.executeUpdate();  
            
            if (numberUpdate == 0)
            {
            	count=0;
            	PreparedStatement insertCurso = connection.prepareStatement(Curso.DB_INSERT_CURSO);
                insertCurso.setString(++count, curso.getNome());
                insertCurso.setString(++count, curso.getDescricao());
                insertCurso.setString(++count, curso.getEmenta());		            	
                numberUpdate = insertCurso.executeUpdate();
            }	
					
			
			if(numberUpdate==1){
				isOperationDone=true;
			}
			
		}catch (SQLException sqlex){
			System.err.println(sqlex.getMessage());
		}
		finally{
			dataBase.close();		
		}
		
		
		
		return isOperationDone;
	}


}
