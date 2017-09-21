package br.com.fiap.ads.ddd.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.fiap.ads.ddd.to.Veiculo;

public class VeiculoDAO {
	// INCLUIR VEICULO
	public void incluir(Veiculo veiculo) throws SQLException {

		Connection conn = null;

		try {

			conn = ConnectionManager.getInstance().getConnection();

			PreparedStatement stmtInsert = conn.prepareStatement("INSERT INTO TB_VEICULO"
					+ "(id_veiculo,modelo,placa,ano,motor)" + "VALUES" + "(sq_veiculo.NEXTVAL,?,?,?,?)");
			//define os valores do parametro
			stmtInsert.setString(1, veiculo.getModelo());
			stmtInsert.setString(2, veiculo.getPlaca());
			stmtInsert.setInt(3, veiculo.getAno());
			stmtInsert.setDouble(4, veiculo.getMotor());
			
			if (veiculo.getPlaca().equalsIgnoreCase(veiculo.getPlaca())) {
				System.out.println();
			}

			stmtInsert.executeUpdate();

		} catch (SQLException e) {
			System.err.println("Erro ao inserir veiculo"); //modificar 

		} finally {

			if (conn != null) // condi��o se tem uma conex�o aberta
				try {
					conn.close(); // fecha
				} catch (SQLException e2) {
					System.err.println("Erro ao fechar conex�o");
				}
		}

	}

	// EXCLUIR VEICULO
	public void excluir(String placa){
		Connection conn = null;
		try {
			conn = ConnectionManager.getInstance().getConnection();
			
			PreparedStatement stmtDelete = conn.prepareStatement("DELETE FROM TB_VEICULO WHERE PLACA=?");
			
			//define os valores dos parametros, no caso a placa do veiculo
			
			stmtDelete.setString(1,placa); 
			
			//Executa o comando de delete
			stmtDelete.executeUpdate();
			
		} catch (SQLException e) {
			System.err.println("Erro ao deletar veiculo");
		}
		
		
		
	}
}
