package br.com.fiap.ads.ddd.bo;

import java.sql.SQLException;

import br.com.fiap.ads.ddd.dao.VeiculoDAO;
import br.com.fiap.ads.ddd.to.Veiculo;

public class VeiculoBO {
	
	public void incluir(Veiculo veiculo) throws SQLException {

		VeiculoDAO veiculoDAO = new VeiculoDAO();
		veiculoDAO.incluir(veiculo);
	}
	
	public void excluir(String placa){
		VeiculoDAO veiculoDAO = new VeiculoDAO();
		veiculoDAO.excluir(placa);
		
	}
}

