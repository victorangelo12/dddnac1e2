package br.com.fiap.ads.ddd.main;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.sun.javafx.util.Utils;

import br.com.fiap.ads.ddd.bo.ListarBO;
import br.com.fiap.ads.ddd.bo.VeiculoBO;
import br.com.fiap.ads.ddd.dao.ListarDAO;
import br.com.fiap.ads.ddd.dao.VeiculoDAO;
import br.com.fiap.ads.ddd.to.Veiculo;

public class Main {
	public static void main(String[] args) throws Exception {
		Scanner tec = new Scanner(System.in);
		
		VeiculoBO veiculoBO = new VeiculoBO();
		Veiculo veiculo = new Veiculo();

		System.out.println(" *** BEM VINDO AO SISTEMA DE VEICULOS *** ");

		int opcao = 1;
		while (opcao != 6) {
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
			
			case 2: //EXCLUIR OPÇÃO 2
			
				System.out.println("Digite a placa: ");
				String placa = tec.next().toUpperCase();
				
				veiculoBO.excluir(placa);
					
				break;
			default:
				System.out.println("Opção Invalida");
				break;
		
			
			case 3: //ALTERAR OPÇÃO 3
				

				System.out.println("Digite placa atual: ");
				String placaAtual = tec.next();
				
				
				System.out.println("Digite nova placa: ");
				String placaAntiga = tec.next();
		
				//passar PLACA para o objeto BO
				veiculoBO.alterar(placaAtual, placaAntiga);
				break;
				
			case 4: //LISTAR OPÇÃO 4
				
				Veiculo veiculoSelecionado = null;
				
				
				try {
					
					
					//cria o objeto que contem as regras para selecionar todas as turmas
					ListarBO turmaBO = new ListarBO();

					//objeto que conterah as turmas cadastradas no sistema
					List<Veiculo> veiculoList = turmaBO.selecionarTodas();
								
					//monta o menu 
					StringBuffer sb = new StringBuffer();
					for(int i = 0; i < veiculoList.size(); i++){
						
						Veiculo t = veiculoList.get(i);
						
						System.out.println("\t["+ i +": " + t.getPlaca() + " - " + t.getModelo() + "/" + t.getAno()+" " + t.getMotor());			
						sb.append(i).append(", ");
						
					}
					
					
					System.out.print("\t["+sb.substring(0, sb.length()-2).toString()+"]: ");		
					int veiculoSelecionadoIndex = tec.nextInt();
				
					tec.close();
					
					
					veiculoSelecionado = veiculoList.get(veiculoSelecionadoIndex);
					
					
				} catch (Exception e1) {
								
					//mensagem de erro exibida se nao for possivel obter a lista de turmas
					System.err.println("ERRO - " + e1.getMessage());
					System.exit(1);
					break;
				
				}
				
				case 5: //EXPORTAR
			
				private ListarDAO listarDAO;

				public void exportar() {

					List<Veiculo> veiculoLista = listarDAO.veiculos2017();
					String caminho = "C:\\Users\\NicoleBono\\Downloads\\veiculos2017.csv";
					FileWriter fileWriter = null;
					
					
					PrintWriter printWriter = null;
					try {
						fileWriter = new FileWriter(caminho);
						printWriter = new PrintWriter(fileWriter);

						printWriter.println("Ano;" + "Placa;" + "Modelo;" + "Motor");
						for (Veiculo veiculo : veiculoLista) {
							printWriter.print(veiculo.getAno() + ";" + veiculo.getPlaca() + ";" + veiculo.getModelo() + ";"
									+ veiculo.getMotor() + "\n");
						}
						System.out.println("Arquivos exportados com sucesso \n");
					} catch (IOException e) {
						// e.printStackTrace(); Logando p Dev
						System.out.println("Ocorreu um problema com o arquivo");
					} finally {
						try {
							printWriter.close();
							fileWriter.close();
						} catch (Exception e2) {
							// e2.getMessage(); // Log p o Dev
						}
					}

				}
			}
			
				
