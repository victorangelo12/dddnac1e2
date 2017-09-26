package br.com.fiap.ads.ddd.main;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.sun.javafx.util.Utils;

import br.com.fiap.ads.ddd.bo.ListarBO;
import br.com.fiap.ads.ddd.bo.VeiculoBO;
import br.com.fiap.ads.ddd.dao.ListarDAO;
import br.com.fiap.ads.ddd.dao.VeiculoDAO;
import br.com.fiap.ads.ddd.to.Veiculo;

/**
 * 
 * @author Victor Angelo RM 77917 e Nicole Bono RM76188
 *
 */

public class Main {

	private static Veiculo veiculo = new Veiculo();
	private static Scanner tec = new Scanner(System.in);
	
	public static void exportarLista2017(){
		ListarBO listarBo = new ListarBO();
		List<Veiculo> veiculoLista;
		String caminho = "D:/veiculos2017.csv";
		FileWriter fileWriter = null;
		PrintWriter printWriter = null;

		try {
			fileWriter = new FileWriter(caminho);
			printWriter = new PrintWriter(fileWriter);
			veiculoLista = listarBo.selecionaVeiculosAno2017();

			printWriter.println("Ano;" + "Placa;" + "Modelo;" + "Motor");
			for (Veiculo veiculo : veiculoLista) {
				printWriter.print(veiculo.getAno() + ";" + veiculo.getPlaca() + ";" + veiculo.getModelo() + ";" + veiculo.getMotor() + "\n");
			}
			System.out.println("Arquivos exportados com sucesso" + System.lineSeparator());
		}catch(SQLException e){
			System.out.println("Ocorreu um problema com o banco de dados");
		}catch(IOException e){
			System.out.println("Ocorreu um problema ao criar o arquivo");
		}finally {
			try {
				printWriter.close();
				fileWriter.close();
			} catch (IOException e) {
				System.out.println("Ocorreu um problema ao criar o arquivo");
			}
		}

	}

	public static void listarTodosOsVeiculos(){
		ListarBO listarBo = new ListarBO();
		
		try {
			ArrayList<Veiculo> listaVeiculos = listarBo.selecionarTodas();
			for(Veiculo i : listaVeiculos){
				String placaNumeros = i.getPlaca().substring(3, 7);
				String placaLetras = i.getPlaca().substring(0, 3);
				System.out.println(placaLetras + "-" + placaNumeros + " - " + i.getModelo() + "/" + i.getAno() + " " + i.getMotor());
			}
		} catch (SQLException e) {
			System.out.println("Ocorreu um problema com o banco de dados");
		}
	}
	
	/**
	 * Metodo para incluir veiculo.
	 * @see VeiculoBO - incluir
	 */
	public static void incluirVeiculo(){
		VeiculoBO veiculoBO = new VeiculoBO();
		
		System.out.println("Digite o modelo do veiculo: ");
		veiculo.setModelo(tec.next() + tec.nextLine());

		System.out.println("Digite a placa: ");
		veiculo.setPlaca(tec.next().toUpperCase());

		System.out.println("Digite o ano:");
		veiculo.setAno(tec.nextInt());

		System.out.println("Digite o motor:");
		veiculo.setMotor(tec.nextDouble());

		try {
			veiculoBO.incluir(veiculo);
		} catch (SQLException e) {
			System.out.println("Ocorreu um problema com o banco de dados");
		}
	}
	
	/**
	 * Metodo para excluir veiculo
	 * 
	 * @see VeiculoBO - ecluir
	 */
	public static void excluirVeiculo(){
		VeiculoBO veiculoBo = new VeiculoBO();
		System.out.println("Digite a placa: ");
		String placa = tec.next().toUpperCase();

		veiculoBo.excluir(placa);
	}
	
	/**
	 * Main Alterar veiculo
	 * @see VeiculoBO - alterar
	 */
	public static void alterarVeiculo(){
		VeiculoBO veiculoBo = new VeiculoBO();
		System.out.println("Digite placa atual: ");
		String placaAtual = tec.next();

		System.out.println("Digite nova placa: ");
		String placaAntiga = tec.next();

		// passar PLACA para o objeto BO
		try {
			veiculoBo.alterar(placaAtual, placaAntiga);
		} catch (SQLException e) {
			System.out.println("Ocorreu um problema com o banco de dados");
		}
	}
	public static void main(String[] args){

		System.out.println(" *** BEM VINDO AO SISTEMA DE VEICULOS *** ");

		int opcao = 1;
		while (opcao != 6) { // opções
			System.out.println("Escolha uma opção:");
			System.out.println("[1] Incluir ");
			System.out.println("[2] Excluir ");
			System.out.println("[3] Alterar ");
			System.out.println("[4] Listar ");
			System.out.println("[5] Exportar ");
			System.out.println("[6] Incluir");
			System.out.print("Digite aqui a opção desejada: ");

			opcao = tec.nextInt();

			switch (opcao) {
			case 1:
				incluirVeiculo();
				break;
			case 2:
				excluirVeiculo();
				break;
			case 3: // ALTERAR OPÇÃO 3
				alterarVeiculo();
				break;
			case 4:
				listarTodosOsVeiculos();
				break;
			case 5:
				exportarLista2017();
				break;
			default:
				System.out.println("Opção Invalida");
				break;
			}
		}


	}
}
