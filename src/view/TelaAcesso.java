package view;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import model.Conta;
import to.ContaTO;
import dao.ContaDAO;
import factory.ConnectionFactory;

public class TelaAcesso extends JFrame implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JPasswordField tsenha;
	TextField tagencia;
	TextField tconta;
	Label lconta;
	Label lagencia;
	Label lsenha;
	Label text;
	JButton blogar;
	JButton bcancelar;
	JPanel painelAcesso;
	String titulo;
	ResourceBundle bn;
	Locale local;
	Connection conn;
	JPanel contentPane;
	Locale Local;
	public TelaAcesso() {
		bn = Util.getBundle();        // ResourceBundle.getBundle("ling",l );	
		conn = Util.getConn();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 463, 236);
		contentPane = new JPanel();
		contentPane.setBackground(UIManager.getColor("Button.background"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		tsenha = new JPasswordField(20);
		tsenha.setBounds(269, 125, 105, 20);
		contentPane.add(tsenha);
		
		tagencia = new TextField(20);
		tagencia.setForeground(new Color(153, 51, 255));
		tagencia.setBounds(269, 47, 105, 20);
		contentPane.add(tagencia);
		tagencia.setColumns(10);
		
		tconta = new TextField(20);
		tconta.setForeground(new Color(153, 51, 255));
		tconta.setBounds(269, 85, 105, 20);
		contentPane.add(tconta);
		tconta.setColumns(10);
		
		text = new Label(bn.getString("TelaAcesso.text"));
		text.setFont(new Font("Tahoma", Font.BOLD, 20));
		text.setForeground(new Color(153, 51, 255));
		text.setBounds(105, 0, 237, 39);
		contentPane.add(text);
		
		lconta = new Label(bn.getString("TelaAcesso.lconta"));
		lconta.setForeground(new Color(153, 51, 255));
		lconta.setFont(new Font("Tahoma", Font.BOLD, 11));
		lconta.setBounds(60, 88, 162, 14);
		contentPane.add(lconta);
		
		lagencia = new Label(bn.getString("TelaAcesso.llogin"));
		lagencia.setFont(new Font("Tahoma", Font.BOLD, 11));
		lagencia.setForeground(new Color(153, 51, 255));
		lagencia.setBounds(60, 50, 162, 14);
		contentPane.add(lagencia);
		
		lsenha = new Label(bn.getString("TelaAcesso.lsenha"));
		lsenha.setFont(new Font("Tahoma", Font.BOLD, 11));
		lsenha.setForeground(new Color(153, 51, 255));
		lsenha.setBounds(60, 128, 199, 14);
		contentPane.add(lsenha);
		
		blogar = new JButton(bn.getString("TelaAcesso.blogar"));
		blogar.setFont(new Font("Tahoma", Font.BOLD, 11));
		blogar.setForeground(new Color(153, 51, 255));
		blogar.setBackground(UIManager.getColor("MenuBar.background"));
		blogar.setBounds(60, 166, 110, 23);
		contentPane.add(blogar);
		
		bcancelar = new JButton(bn.getString("TelaAcesso.bcancelar"));
		bcancelar.setForeground(new Color(153, 51, 255));
		bcancelar.setFont(new Font("Tahoma", Font.BOLD, 11));
		bcancelar.setBounds(269, 166, 110, 23);
		contentPane.add(bcancelar);
		
		blogar.addActionListener(this);
		bcancelar.addActionListener(this);
		

		setTitle(bn.getString("TelaAcesso.titulo"));
		setDefaultLookAndFeelDecorated(true);
		

	}
	
	public void iniciar()
	{
		setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == blogar)
		{
			
			Conta conta = new Conta(Integer.parseInt(tconta.getText()));
			ContaDAO dao = new ContaDAO();
			ContaTO to = dao.carregar(Integer.parseInt(tconta.getText()));
			conta.carrega();
			
			@SuppressWarnings("unused")
			ConnectionFactory bd = new ConnectionFactory();
			try {
				conn = ConnectionFactory.obtemConexao();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			Util.setConn(conn);
			Util.setCli(conta);
			Util.setConta(to);
			Util.setContaDAO(dao);
			//	cliente.setConta(Long.parseLong(tconta.getText()));
			System.out.println("Login");
			setVisible(false);
			try {
				TelaInicial c = new TelaInicial();
				c.inicar();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		/*	ArquivoLogin login = new ArquivoLogin();
			if(login.verificaUsuario(cliente) != null){
				System.out.println("Login");
				setVisible(false);
				TelaInicial c = new TelaInicial();
			}
			System.out.println("nao login");*/
			
		}
		if(e.getSource() == bcancelar)
		{
			System.exit(0);
		}
	
	}

}
