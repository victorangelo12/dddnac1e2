package br.com.fiap.ads.ddd.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.fiap.ads.ddd.to.Veiculo;

public class VeiculoDAO {
	public void incluir(Veiculo veiculo) throws SQLException{
		Connection conn = null;
		
		conn = ConnectionManager.getInstance().getConnection();
		
		PreparedStatement stmtInsert = conn.prepareStatement("INSERT INTO TB_ALUNO"
														+ "(id_veiculo,modelo,placa,ano,motor)"+"VALUES"
														+"(sq_veiculo.NEXTVAL,?,?,?,?)");
		
		stmtInsert.setString(1, veiculo.getModelo());
		stmtInsert.setString(2,veiculo.getPlaca());
		stmtInsert.setInt(3, veiculo.getAno());
		stmtInsert.setDouble(4, veiculo.getMotor());
		
		stmtInsert.executeUpdate();
														
	}
}
