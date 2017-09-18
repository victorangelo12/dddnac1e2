package br.com.fiap.ads.ddd.to;

public class Veiculo {
	//atributos do veiculo
	private int id;
	private String modelo;
	private String placa;
	private int ano;
	private double motor;
	
	//geters e setters veiculos
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	public int getAno() {
		return ano;
	}
	public void setAno(int ano) {
		this.ano = ano;
	}
	public double getMotor() {
		return motor;
	}
	public void setMotor(double motor) {
		this.motor = motor;
	}
	
	
}
