package br.com.fiap.ads.ddd.main;

import java.sql.SQLException;
import java.util.Scanner;

import br.com.fiap.ads.ddd.bo.VeiculoBO;
import br.com.fiap.ads.ddd.dao.VeiculoDAO;
import br.com.fiap.ads.ddd.to.Veiculo;

public class Main {
	public static void main(String[] args) throws SQLException {
		Scanner tec = new Scanner(System.in);
		
		VeiculoBO veiculoBO = new VeiculoBO();
		Veiculo veiculo = new Veiculo();

		System.out.println(" *** BEM VINDO AO SISTEMA DE VEICULOS *** ");

		int opcao = 1;
		while (opcao != 6) {
			System.out.println("Escolha uma op��o:");
			System.out.println("[1] Incluir ");
			System.out.println("[2] Excluir ");
			System.out.println("[3] Alterar ");
			System.out.println("[4] Listar ");
			System.out.println("[5] Exportar ");
			System.out.println("[6] Incluir");
			System.out.print("Digite aqui a op��o desejada: ");

			opcao = tec.nextInt();

			switch (opcao) { 
			case 1: //INCLUIR OPCAO 1

			

				System.out.println("Digite o modelo do veiculo: ");
				veiculo.setModelo(tec.next() + tec.nextLine());

				System.out.println("Digite a placa: ");
				veiculo.setPlaca(tec.next().toUpperCase());

				System.out.println("Digite o ano:");
				veiculo.setAno(tec.nextInt());

				System.out.println("Digite o motor:");
				veiculo.setMotor(tec.nextDouble());

				
				veiculoBO.incluir(veiculo); //TRY
				break;
			
			case 2: //EXCLUIR OP��O 2
			
				System.out.println("Digite a placa: ");
				String placa = tec.next().toUpperCase();
				
				veiculoBO.excluir(placa);
					
				break;
			default:
				System.out.println("Op��o Invalida");
				break;
		
			
			case 3: //ALTERAR OP��O 3
				

				System.out.println("Digite placa atual: ");
				veiculo.setPlaca(tec.next());
				
				
				System.out.println("Digite nova placa: ");
				veiculo.setPlaca(tec.next());
		
				//passar PLACA para o objeto BO
				veiculoBO.alterar(veiculo);

				
	}
}
		
	}
}
