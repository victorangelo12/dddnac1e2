package br.com.fiap.ads.ddd.bo;

import java.sql.SQLException;

import br.com.fiap.ads.ddd.dao.VeiculoDAO;
import br.com.fiap.ads.ddd.to.Veiculo;

public class VeiculoBO {

	// Não possui regras de negocio ou seja
	// passa o veiculo direto para camada de persistencia
	public void incluir(Veiculo veiculo) throws SQLException {

		VeiculoDAO veiculoDAO = new VeiculoDAO();
		veiculoDAO.incluir(veiculo);
	}
}
