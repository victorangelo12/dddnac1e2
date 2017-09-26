package br.com.fiap.ads.ddd.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.fiap.ads.ddd.to.Veiculo;

public class ListarDAO {
	Connection conn = null;

	public ArrayList<Veiculo> listarTodosOsVeiculos() throws SQLException {
		ArrayList<Veiculo> veiculoLista = new ArrayList<Veiculo>();
		
		try {
			conn = ConnectionManager.getInstance().getConnection();
			PreparedStatement stmtSelect = conn.prepareStatement("SELECT * FROM TB_VEICULO");
			ResultSet rs = stmtSelect.executeQuery();

			while (rs.next()) {
				Veiculo veiculo = new Veiculo();

				veiculo.setId(rs.getInt("id_veiculo"));
				veiculo.setModelo(rs.getString("modelo"));
				veiculo.setPlaca(rs.getString("placa"));
				veiculo.setAno(rs.getInt("ano"));
				veiculo.setMotor(rs.getDouble("motor"));

				veiculoLista.add(veiculo);
			}

		} catch (SQLException e) {
			throw new SQLException();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					throw new SQLException();
				}
			}
		}

		return veiculoLista;

	}

	public ArrayList<Veiculo> veiculos2017() throws SQLException{
		ArrayList<Veiculo> listaVeiculo2017 = new ArrayList<Veiculo>();
		String sql = "SELECT * FROM TB_VEICULO WHERE ANO= 2017";

		try {
			conn = ConnectionManager.getInstance().getConnection();
			PreparedStatement stmtSelect = conn.prepareStatement(sql);
			ResultSet rs = stmtSelect.executeQuery();

			while (rs.next()) {

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
			throw new SQLException();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				throw new SQLException();
			}
		}
	}

}


