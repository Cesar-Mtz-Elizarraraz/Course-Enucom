package com.mx.entidad;

public class Cuenta {
	// Atributos
	int numero;
	double saldo;
	double adeudo;
	String tipo;
	String banco;
	String estatus;
	
	public Cuenta() {
	}
	
	public Cuenta(int numero) {
		this.numero = numero;
	}
	
	public Cuenta(int numero, double saldo, double adeudo, String tipo, String banco, String estatus) {
		this.numero = numero;
		this.saldo = saldo;
		this.adeudo = adeudo;
		this.tipo = tipo;
		this.banco = banco;
		this.estatus = estatus;
	}
	
	@Override
	public String toString() {
		return "\nCuenta => [Número: "+ numero + ", Saldo:" + saldo + ", Adeudo:" + adeudo + ", Tipo:" + tipo +
				", Banco:" + banco + ", Estatus:" + estatus + "]";
	}
	
	public int getNumero() {
		return numero;
	}
	
	public String getNumeroToString() {
		return Integer.toString(numero);
	}
	
	public void setNumero(int numero) {
		this.numero = numero;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public double getAdeudo() {
		return adeudo;
	}

	public void setAdeudo(double adeudo) {
		this.adeudo = adeudo;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getBanco() {
		return banco;
	}

	public void setBanco(String banco) {
		this.banco = banco;
	}

	public String getEstatus() {
		return estatus;
	}

	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}
	

}
