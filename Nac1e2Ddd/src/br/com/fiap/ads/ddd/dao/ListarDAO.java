package br.com.fiap.ads.ddd.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.ads.ddd.to.Veiculo;


	
	

	/**
	 * Classe DAO da entidade da entidade <code>Turma</code> no banco de dados.
	 * 
	 * @see br.com.fiap.ads.ddd.designpatterns.exemplos.dao1.to.Turma
	 */
public class ListarDAO {

		/**
		 * Retorna todas as turmas.
		 * 
		 * @return Um <code>List</code> de <code>Turma</code>.
		 * @throws SQLException
		 * @see java.util.List
		 * @see br.com.fiap.ads.ddd.designpatterns.exemplos.dao1.to.Turma
		 */
		public List<Veiculo> getAll() throws SQLException {

			// Lista a ser Retornada
			List<Veiculo> veiculoList = new ArrayList<Veiculo>();

			Connection conn = null;// conexao com o SGBDR

			try {

				//
				// Obtem a conexao com o SGBDR
				//
				conn = ConnectionManager.getInstance().getConnection();

				//
				// Cria o PreparedStatement
				//
				PreparedStatement stmtSelect = conn.prepareStatement("SELECT * FROM TB_VEICULO");

				// executa a SQL
				ResultSet rs = stmtSelect.executeQuery();

				while (rs.next()) {// enquanto houver registros...

					// cria um objeto turma (que contem os dados deste registro)
					Veiculo veiculo = new Veiculo();

					// pega o valor da coluna e coloca na propriedade do objeto
					veiculo.setId(rs.getInt("id_veiculo"));
					veiculo.setModelo(rs.getString("modelo"));
					veiculo.setPlaca(rs.getString("placa"));
					veiculo.setAno(rs.getInt("ano"));
					veiculo.setMotor(rs.getDouble("motor"));
					

					// coloca o objeto turma na lista de turma
					veiculoList.add(veiculo);

				}

			} catch (SQLException e) {

				e.printStackTrace();
				throw new SQLException(
						"Erro ao conectar ou manipular o banco de dados!", e);

			} finally {

				if (conn != null) {// se ha uma conexao, fecha ela
					try {

						//
						// Fecha a conexao com o SGBDR
						//
						conn.close();

					} catch (SQLException e) {

						e.printStackTrace();
						throw new SQLException(
								"Erro ao fechar a conexao com o banco de dados!", e);
					}
				}

			}

			// retorna lista de turma
			return veiculoList;

		}

	



public List<Veiculo> veiculos2017() {
	
	ArrayList<Veiculo> listaVeiculo2017 = new ArrayList<Veiculo>();
	String sql = "select * from tb_veiculo where ano = 2016";


	
	Connection conn = null;// conexao com o SGBDR

	try {

		//
		// Obtem a conexao com o SGBDR
		//
		conn = ConnectionManager.getInstance().getConnection();

		//
		// Cria o PreparedStatement
		//
		PreparedStatement stmtSelect = conn.prepareStatement(sql);

		// executa a SQL
		ResultSet rs = stmtSelect.executeQuery();

		while (rs.next()) {// enquanto houver registros...

			// cria um objeto turma (que contem os dados deste registro)
			

			Veiculo veiculo = new Veiculo();

			veiculo.setId(rs.getInt("ID_VEICULO"));
			veiculo.setModelo(rs.getString("MODELO"));
			veiculo.setPlaca(rs.getString("PLACA"));
			veiculo.setAno(rs.getInt("ANO"));
			veiculo.setMotor(rs.getDouble("MOTOR"));

			listaVeiculo2017.add(veiculo);
		}
		rs.close();
		return listaVeiculo2017;
	} catch (SQLException e) {
		// Logando a mensagem p Dev
		e.printStackTrace();
		return null;
	} finally {
		try {
			conn.close();
		} catch (SQLException e) {
			// Logando a mensagem para o Dev
			e.printStackTrace();
		}
	}
}
	}


