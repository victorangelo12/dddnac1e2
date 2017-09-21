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
	
	public void alterar (String placaAntiga ,String placaAtual) throws Exception{
		VeiculoDAO veiculoDAO = new VeiculoDAO();
		
		
		//RN A nova placa não pode sert igual a placa atual
		if (placaAtual == placaAntiga) {
			throw new Exception("A nova placa não pode ser igual a placa atual"); //RN1
		}else if((placaAntiga.substring(3,7)) == (placaAtual.substring(3,7))){
				throw new Exception("O número da placa não pode ser igual ao numero de placa antiga"); //RN2
			}else{
				veiculoDAO.alterar(placaAntiga,placaAtual);
			}
			
			
		}
		
		
	}

