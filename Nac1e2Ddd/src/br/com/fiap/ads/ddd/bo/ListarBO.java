package br.com.fiap.ads.ddd.bo;

import java.sql.SQLException;
import java.util.ArrayList;

import br.com.fiap.ads.ddd.dao.ListarDAO;
import br.com.fiap.ads.ddd.to.Veiculo;

public class ListarBO {

	public ArrayList<Veiculo> selecionarTodas() throws SQLException {
		try{
			ListarDAO listarDAO = new ListarDAO();
			return listarDAO.listarTodosOsVeiculos();
		}
		catch (SQLException e) {
			throw new SQLException();			
		}
	}
	
	public ArrayList<Veiculo> selecionaVeiculosAno2017() throws SQLException{
		try{
			ListarDAO listarDAO = new ListarDAO();
			return listarDAO.veiculos2017();
		}
		catch (SQLException e) {
			throw new SQLException();			
		}
	}
}


