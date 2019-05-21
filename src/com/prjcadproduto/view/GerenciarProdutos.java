package com.prjcadproduto.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.prjcadproduto.dominio.Produto;
import com.prjcadproduto.persistencia.CRUDProduto;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextPane;

public class GerenciarProdutos extends JFrame {

	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtDescricao;
	private JTextField txtFabricacao;//fabricantePr
	private JTextField txtQuantidade;
	private JTextField txtPreco;
	private JTable tbCadastrar;
	private CRUDProduto crud;
	private Produto produto;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GerenciarProdutos frame = new GerenciarProdutos();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GerenciarProdutos() {
		
		//Vamos instanciar as classes Cliente e CRUD 
		//Gera um objeto termo "new"
		produto = new Produto();
		crud = new CRUDProduto();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 449, 498);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNomeDoProduto = new JLabel("Nome do produto:");
		lblNomeDoProduto.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNomeDoProduto.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNomeDoProduto.setBounds(10, 11, 138, 30);
		contentPane.add(lblNomeDoProduto);
		
		JLabel lblDescricao = new JLabel("Descri\u00E7\u00E3o:");
		lblDescricao.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDescricao.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblDescricao.setBounds(22, 66, 126, 20);
		contentPane.add(lblDescricao);
		
		txtNome = new JTextField();
		txtNome.setBounds(160, 18, 248, 20);
		contentPane.add(txtNome);
		txtNome.setColumns(10);
		
		JLabel lblFabricao = new JLabel("Fabrica\u00E7\u00E3o:");
		lblFabricao.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblFabricao.setHorizontalAlignment(SwingConstants.RIGHT);
		lblFabricao.setBounds(54, 118, 94, 20);
		contentPane.add(lblFabricao);
		
		txtDescricao = new JTextField();
		txtDescricao.setBounds(160, 48, 248, 61);
		contentPane.add(txtDescricao);
		txtDescricao.setColumns(10);
		
		txtFabricacao = new JTextField();
		txtFabricacao.setColumns(10);
		txtFabricacao.setBounds(160, 120, 248, 20);
		contentPane.add(txtFabricacao);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			//CADASTRAR
			public void actionPerformed(ActionEvent e) {
				
				//Passar os dados do formulário para o objeto Produto
				produto.setNome(txtNome.getText());
				produto.setDescricaoPr(txtDescricao.getText());
				produto.setFabricantePr(txtFabricacao.getText());
				produto.setQuantidade(Integer.parseInt(txtQuantidade.getText()));
				produto.setPreco(Double.parseDouble(txtPreco.getText()));
				
				String retorno = crud.cadastrar(produto);
				JOptionPane.showMessageDialog(null, retorno);
				
				//Zera os campos preenchidos
				txtNome.setText("");
				txtDescricao.setText("");
				txtFabricacao.setText("");
				txtQuantidade.setText("");
				txtPreco.setText("");
				carregarDados();
				
			}
		});
		btnCadastrar.setBounds(10, 227, 89, 49);
		contentPane.add(btnCadastrar);
		
		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.addActionListener(new ActionListener() {
			//ATUALIZAR
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnAtualizar.setBounds(109, 227, 89, 49);
		contentPane.add(btnAtualizar);
		
		JButton btnDeletar = new JButton("Deletar");
		btnDeletar.setBounds(235, 227, 89, 49);
		contentPane.add(btnDeletar);
		
		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.setBounds(334, 227, 89, 49);
		contentPane.add(btnPesquisar);
		
		JLabel lblQuantidade = new JLabel("Quantidade:");
		lblQuantidade.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblQuantidade.setHorizontalAlignment(SwingConstants.RIGHT);
		lblQuantidade.setBounds(60, 149, 88, 19);
		contentPane.add(lblQuantidade);
		
		txtQuantidade = new JTextField();
		txtQuantidade.setColumns(10);
		txtQuantidade.setBounds(160, 148, 94, 20);
		contentPane.add(txtQuantidade);
		
		JLabel lblPreco = new JLabel("Pre\u00E7o:");
		lblPreco.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPreco.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPreco.setBounds(60, 179, 88, 19);
		contentPane.add(lblPreco);
		
		txtPreco = new JTextField();
		txtPreco.setColumns(10);
		txtPreco.setBounds(160, 179, 94, 20);
		contentPane.add(txtPreco);
		
		carregarDados();
		
		
	}
	
	private void carregarDados() {
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 287, 413, 161);
		contentPane.add(scrollPane);
		
		// ---------- Criar colunas na janela do CONSTRUTO00R!!
		String[] colunas = {"Id", "Nome do Pr.", "Descrição", "Fabricante", "Quant.", "Preço"};
		
		
		//Vamos construir o modelo de dados para exibir na tabela
		DefaultTableModel modelo = new DefaultTableModel(colunas,0);
		
		for(Produto c : crud.PesquisarTodos()) {
			modelo.addRow(new Object[] {
					c.getId(),
					c.getNome(),
					c.getDescricaoPr(),
					c.getFabricantePr(),
					c.getQuantidade(),
					c.getPreco()
			});
		}
		
		
		tbCadastrar = new JTable(modelo);
		scrollPane.setViewportView(tbCadastrar);
	}
}
