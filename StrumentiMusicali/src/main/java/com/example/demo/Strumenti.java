package com.example.demo;

public class Strumenti {
	
	private String nome;
	private String marca;
	private double prezzo;
	private String url;
	private int pezzi;
	private int pezziV;
	
	public Strumenti(String nome, String marca, double prezzo, String url, int pezzi, int pezziV) {
		super();
		this.nome = nome;
		this.marca = marca;
		this.prezzo = prezzo;
		this.url = url;
		this.pezzi = pezzi;
		this.pezziV = pezziV;
	}
	
	public Strumenti(String nome, String marca, double prezzo, String url, int pezzi) {
		super();
		this.nome = nome;
		this.marca = marca;
		this.prezzo = prezzo;
		this.url = url;
		this.pezzi = pezzi;
		
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public double getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public int getPezzi() {
		return pezzi;
	}

	public void setPezzi(int pezzi) {
		this.pezzi = pezzi;
	}

	public int getPezziV() {
		return pezziV;
	}

	public void setPezziV(int pezziV) {
		this.pezziV = pezziV;
	}

	public Strumenti() {
		super();
	}

	@Override
	public String toString() {
		return "Strumenti [nome=" + nome + ", marca=" + marca + ", prezzo=" + prezzo + ", url=" + url + ", pezzi="
				+ pezzi + ", pezziV=" + pezziV + "]";
	}
	
	

	
}
