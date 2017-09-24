package br.com.fiap.ads.ddd.bo;

import java.sql.SQLException;
import java.util.List;

import br.com.fiap.ads.ddd.dao.ListarDAO;
import br.com.fiap.ads.ddd.to.Veiculo;

public class ListarBO {

	
	
	/**
	 *Classe que contem as regras de negocio para Turma.
	 */

		
		public List<Veiculo> selecionarTodas() throws Exception {
			
			
			//
			// Regras de negocio para obter as turmas
			//
			
			//ok, sem regras... acesso direto
			
			
			
			//----------------------------------------------- negocio OK, persistencia agora
			
			
			
			//
			//seleciona todas as turmas cadastradas no BD
			//
			try{
				
				//cria o DAO da Turma
				ListarDAO listarDAO = new ListarDAO();
				return listarDAO.getAll();
			}
			catch (SQLException e) {
				
				throw new Exception("Erro ao consultar as turmas cadastradas no banco de dados");
							
			}
			
		}

	}


