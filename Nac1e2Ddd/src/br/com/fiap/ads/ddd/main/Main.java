package br.com.fiap.ads.ddd.main;

import java.sql.SQLException;
import java.util.Scanner;

import br.com.fiap.ads.ddd.bo.VeiculoBO;
import br.com.fiap.ads.ddd.dao.VeiculoDAO;
import br.com.fiap.ads.ddd.to.Veiculo;

public class Main {
	public static void main(String[] args) throws SQLException {
		Scanner tec = new Scanner(System.in);

		System.out.println(" *** BEM VINDO AO SISTEMA DE VEICULOS *** ");
		
		int opcao = 1;
		while (opcao!=6) {
			System.out.println("Escolha uma opção:");
			System.out.println("[1] Incluir ");
			System.out.println("[2] Excluir ");
			System.out.println("[3] Alterar ");
			System.out.println("[4] Listar ");
			System.out.println("[5] Exportar ");
			System.out.println("[6] Incluir");
			System.out.print("Digite aqui a opção desejada");
		
		opcao = tec.nextInt();
		
		switch (opcao) {
		case 1:
			
			Veiculo veiculo = new Veiculo();
			
			System.out.println("Digite o modelo do veiculo: ");
			veiculo.setModelo(tec.next()+tec.nextLine());
			
			System.out.println("Digite a placa: ");
			veiculo.setPlaca(tec.next());
			
			System.out.println("Digite o ano:");
			veiculo.setAno(tec.nextInt());
			
			System.out.println("Digite o motor:");
			veiculo.setMotor(tec.nextDouble());
			
			VeiculoBO veiculoBO = new VeiculoBO();
			veiculoBO.incluir(veiculo);
			break;

		default:
			System.out.println("Opção Invalida");
			break;
		}
		}
		

	}
}
