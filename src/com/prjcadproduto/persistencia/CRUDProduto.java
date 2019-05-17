package com.prjcadproduto.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.prjcadcliente.dominio.Cliente;
import com.prjcadproduto.dominio.Produto;

/**
 * <b>CRUDProduto </b><br>
  * Essa classe permite manipular as informações do Produto. Aqui você
  * encontrará os seguintes comandos:
  * <ul>
  * <li>Cadastro</li>
  * <li>Pesquisar por nome e por id</li>
  * <li>Atualizar</li>
  * <li>Deletar</li>
  * </ul>
  * @author luiz.hssantos11
 */

public class CRUDProduto {
	
	//Declaração das instâncias de comunicação com o banco 
	//de dados
	private Connection con = null;//Estabelecer a comunicação com o banco de dados
	private ResultSet rs = null;//Guardar os retornos dos selects no banco de dados
	private PreparedStatement pst = null; //Executa as consultas de SQL
	
	public String cadastrar (Produto produto) {
		
		String msg = "";
		
		//Criação dos objetos para a conexao com o banco de dados
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cadprodutodb?serverTimezone=UTC","root","");//conexao com o banco de dados
			
			String consulta = "INSERT INTO tbcadastrar (nome, descricaoPr, fabricantePr, quantidade, preco) values(?,?,?,?)";
			
			//Executa as consultas de SQL
			pst = con.prepareStatement(consulta);
			
			pst.setString(1, produto.getNome());
			pst.setString(2, produto.getDescricaoPr());
			pst.setString(3, produto.getFabricantePr());
			pst.setInt(4, produto.getQuantidade());
			pst.setDouble(5, produto.getPreco());
			
			//Atualiza e retorna. Cadastra e diz quantos cadastrou.
			int r = pst.executeUpdate();
			
			if(r > 0)
				msg = "Cadastro realizado com sucesso!";
			else
				msg = "Não foi possível cadastrar!";
		}
		catch(SQLException ex) {
			msg = "Erro ao tentar cadastrar: "+ex.getMessage();
		}
		catch(Exception e) {
			msg = "Erro inesperado: "+e.getMessage();
		}
		finally {
			try {con.close();} catch(Exception e) {e.printStackTrace();}
		}
		
		return msg;
	}
	
	public String atualizar(Produto produto) {
		String msg = "";
		
		//Criação dos objetos para a conexao com o banco de dados
		try {
    		Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
    		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cadprodutodb?serverTimezone=UTC","root","");
    		
    		String consulta = "UPDATE tbcadastrar SET nome=?, descricaoPr=?, fabricantePr=?, quantidade=?, preco=? WHERE id=?";
    		
    		pst = con.prepareStatement(consulta);
    		
    		pst.setString(1, produto.getNome());
			pst.setString(2, produto.getDescricaoPr());
			pst.setString(3, produto.getFabricantePr());
			pst.setInt(4, produto.getQuantidade());
			pst.setDouble(5, produto.getPreco());
			pst.setInt(6, produto.getId());
    		
    		int r = pst.executeUpdate();
    		
    		
			if(r > 0)
    			msg = "Atualizado com sucesso!";
    		else
    			msg = "Não foi possível atualizar!";
    		     		
    	}
		
    	catch(SQLException ex) {
    		msg = "Erro ao tentar atualizar: "+ex.getMessage();
    	}
    	catch(Exception e) {
    		msg = "Erro inesperado: "+e.getMessage();
    	}
    	finally {
    		try{con.close();}catch(Exception e) {e.printStackTrace();}
    	}
    	
    	return msg;
    }
		
	public String deletar(Produto produto) {
		
    	String msg = "";
    	
    	
    	//Criação dos objetos para a conexao com o banco de dados
    	try {
    		Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
    		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cadprodutodb?serverTimezone=UTC","root","");
    		
    		String consulta = "DELETE FROM tbcadastrar WHERE id=?";
    		
    		pst = con.prepareStatement(consulta);
    		
    		pst.setInt(1, produto.getId());
    		
    		
    		int r = pst.executeUpdate();
    		
    		
			if(r > 0)
    			msg = "Deletado com sucesso!";
    		else
    			msg = "Não foi possível deletar!";
    		     		
    	}
    	catch(SQLException ex) {
    		msg = "Erro ao tentar deletar: "+ex.getMessage();
    	}
    	catch(Exception e) {
    		msg = "Erro inesperado: "+e.getMessage();
    	}
    	finally {
    		try{con.close();}catch(Exception e) {e.printStackTrace();}
    	}
    	
    	return msg;
    }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
		
}
