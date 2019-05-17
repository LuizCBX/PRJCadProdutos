package com.prjcadproduto.dominio;

public class Produto {
	
	private int id;
	private String nome;
	private String descricaoPr;
	private String fabricantePr;
	private int quantidade;
	private double preco;
	
	
	//Construtores
	
	//Sem marcar
	public Produto() {
	}

	//Marcar
	public Produto(int id, String nome, String descricaoPr, String fabricantePr, int quantidade, double preco) {
		this.id = id;
		this.nome = nome;
		this.descricaoPr = descricaoPr;
		this.fabricantePr = fabricantePr;
		this.quantidade = quantidade;
		this.preco = preco;
	}

	
	//GETTERS e SETTERS
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricaoPr() {
		return descricaoPr;
	}

	public void setDescricaoPr(String descricaoPr) {
		this.descricaoPr = descricaoPr;
	}

	public String getFabricantePr() {
		return fabricantePr;
	}

	public void setFabricantePr(String fabricantePr) {
		this.fabricantePr = fabricantePr;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}
	
	
	
	
	
	
	

}
