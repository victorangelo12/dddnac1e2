package br.com.fiap.ads.ddd.bo;

import java.sql.SQLException;

import br.com.fiap.ads.ddd.dao.VeiculoDAO;
import br.com.fiap.ads.ddd.to.Veiculo;

/**
 * 
 * @author Victor Angelo RM 77917 e Nicole Bono RM76188 
 *
 */
public class VeiculoBO {
	/**
	 * Regra de negocio para incluir veiculo como não possui passa para DAO
	 * @param veiculo
	 * @throws SQLException
	 * @see VeiculoDAO-Incluir
	 */
	
	public void incluir(Veiculo veiculo) throws SQLException {

		VeiculoDAO veiculoDAO = new VeiculoDAO();
		veiculoDAO.incluir(veiculo);
		
		
	}
	/**
	 * Regra de negocio para excluir veiculo, como não possui passa para o DAO
	 * @param placa
	 * @see VeiculoDAO-Excluir
	 */
	
	public void excluir(String placa){
		VeiculoDAO veiculoDAO = new VeiculoDAO();
		veiculoDAO.excluir(placa);
		
	}
	/**
	 * Regra de negocio para Alterar placa veiculo
	 * RN01 - A nova placa não pode ser igual a placa atual
	 * RN02 - O número da placa não pode ser igual a placa antiga
	 * @param placa
	 * @see VeiculoDAO-Alterar
	 */
	
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

