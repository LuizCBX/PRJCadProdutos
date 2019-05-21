package com.prjcadproduto.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class GerenciarProdutos extends JFrame {

	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField textField;
	private JTextField txtFabricacao;
	private JTextField txtQuantidade;
	private JTextField txtPreco;
	private JTable table;

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
		
		textField = new JTextField();
		textField.setBounds(160, 48, 248, 61);
		contentPane.add(textField);
		textField.setColumns(10);
		
		txtFabricacao = new JTextField();
		txtFabricacao.setColumns(10);
		txtFabricacao.setBounds(160, 120, 248, 20);
		contentPane.add(txtFabricacao);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setBounds(10, 227, 89, 49);
		contentPane.add(btnCadastrar);
		
		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.addActionListener(new ActionListener() {
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
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 287, 413, 161);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
	}
}
