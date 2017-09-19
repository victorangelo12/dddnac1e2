package br.com.fiap.ads.ddd.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
	// instancia unica

	private static ConnectionManager instance;

	private ConnectionManager() throws ClassNotFoundException {

		// registra o drive jdbc

		Class.forName("oracle.jdbc.driver.OracleDriver");
	}

	public static ConnectionManager getInstance() throws SQLException {
		 		
		try {
			// verifica se ja uma conexão
			if (instance == null) {
				instance = new ConnectionManager();
			}

		} catch (ClassNotFoundException e) {
			throw new SQLException("O driver JBC não foi encontrado "+e.getMessage());
		}
		return instance;

	}
	
	//abre a conexão com o banco
	
	public Connection getConnection()throws SQLException{
		//parametros da conexão
		
		String usuario = "rm77917"; //rm00000
		String senha = "200997"; //DDMMAA
		String jdbcUrl = "jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL"; //acesso externo
		
		//abre a conexão 
		
		try {
			return DriverManager.getConnection(jdbcUrl,usuario,senha);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new SQLException("Erro ao se conectar com o banco de dados");
		}
		
	}

}
