package view;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class TelaInicial extends JFrame implements ActionListener{

	JButton bdebito;
	JButton btf;
	JButton bextrato;
	JButton bsaque;
	JButton bsaldo;
	JButton bsair;
	JLabel lcliente;
	JLabel lconta;
	JPanel painelAcesso ;
	String conta;
	String titulo;
	Locale local;
	ResourceBundle bn;
	Connection conn;
	private JPanel contentPane;
	public TelaInicial() throws SQLException
	{
		// Container c = getContentPane();
		// c.setLayout(new GridLayout(3,4,10,10));
		// setContentPane(c);
		 bn = Util.getBundle();
		// local = l;
		
		 setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(100, 100, 450, 300);
			contentPane = new JPanel();
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			setContentPane(contentPane);
			contentPane.setLayout(null);
		 
		 conta = "xxx.xxx-z";
		 JLabel vazio = new JLabel("           ");
		 JLabel vazio2 = new JLabel("           ");
		 JLabel vazio3 = new JLabel("           ");
		 JLabel vazio4 = new JLabel("           ");
		 
		 lcliente = new JLabel(bn.getString("TelaDebito.lcliente")+ ": "+Util.getContaDAO().getNome(Util.getConta()));
		 lcliente.setFont(new Font("Tahoma", Font.BOLD, 13));
			lcliente.setForeground(new Color(153, 51, 255));
		 lcliente.setBounds(44, 11, 150, 14);
			contentPane.add(lcliente);
		 
		 lconta = new JLabel(bn.getString("TelaAcesso.lconta")+": "+Util.getCli().getConta());
		 lconta.setFont(new Font("Tahoma", Font.BOLD, 13));
			lconta.setForeground(new Color(153, 51, 255));
		 lconta.setBounds(239, 11, 97, 14);
			contentPane.add(lconta);
		 
		 bdebito = new JButton(bn.getString("TelaInicial.bdebito"));
		 bdebito.setFont(new Font("Tahoma", Font.BOLD, 11));
			bdebito.setForeground(new Color(153, 51, 255));
		 bdebito.setBounds(44, 157, 97, 53);
			contentPane.add(bdebito);
		 
		 btf = new JButton(bn.getString("TelaInicial.btf"));
		 btf.setFont(new Font("Tahoma", Font.BOLD, 11));
			btf.setForeground(new Color(153, 51, 255));
		 btf.setBounds(239, 96, 97, 50);
			contentPane.add(btf);
		 
		 bextrato = new JButton(bn.getString("TelaInicial.bextrato"));
		 bextrato.setFont(new Font("Tahoma", Font.BOLD, 11));
			bextrato.setForeground(new Color(153, 51, 255));
		 bextrato.setBounds(44, 96, 97, 50);
			contentPane.add(bextrato);
		 
		 bsaque = new JButton(bn.getString("TelaInicial.bsaque"));
		 bsaque.setFont(new Font("Tahoma", Font.BOLD, 11));
			bsaque.setForeground(new Color(153, 51, 255));
		 bsaque.setBounds(239, 36, 97, 49);
			contentPane.add(bsaque);
		 
		 bsaldo	= new JButton(bn.getString("TelaInicial.bsaldo"));
		 bsaldo.setFont(new Font("Tahoma", Font.BOLD, 11));
			bsaldo.setForeground(new Color(153, 51, 255));
		 bsaldo.setBounds(44, 36, 97, 49);
			contentPane.add(bsaldo);
		 
		 bsair = new JButton(bn.getString("TelaInicial.bsair"));
		 bsair.setFont(new Font("Tahoma", Font.BOLD, 11));
			bsair.setForeground(new Color(153, 51, 255));
		 bsair.setBounds(239, 157, 97, 53);
			contentPane.add(bsair);
			
		 
		 
		 
		 /*
		 painelAcesso = new JPanel();
		 painelAcesso.add(lcliente);
		 painelAcesso.add(vazio);
		 painelAcesso.add(vazio2);
		 painelAcesso.add(lconta);
		 painelAcesso.add(bdebito);
		 painelAcesso.add(bextrato);
		 painelAcesso.add(bsaque);
		 painelAcesso.add(btf);
		 painelAcesso.add(vazio3);
		 painelAcesso.add(bsaldo);
		 painelAcesso.add(bsair);
		 painelAcesso.add(vazio4);*/
		
		 bsair.addActionListener(this);
		 btf.addActionListener(this);
		 bextrato.addActionListener(this);
		 bsaque.addActionListener(this);
		 bsaldo.addActionListener(this);
		 bdebito.addActionListener(this);
		 
		 
		 
		// c.add(painelAcesso);
		 
		 setTitle(bn.getString("TelaInicial.titulo"));
		
		 setDefaultLookAndFeelDecorated(true);
	}
	
	public void inicar()
	{
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource() == bsair)
		{
			System.exit(0);
		}
		
		if(e.getSource() == bsaldo)
		{
			try {
				TelaSaldo a = new TelaSaldo();
				a.iniciar();
				setVisible(false);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	
		if(e.getSource() == bsaque)
		{
			try {
				TelaSaque a = new TelaSaque();
				a.iniciar();
				setVisible(false);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
		if(e.getSource() == btf)
		{
			try {
				TelaTf a = new TelaTf();
				a.iniciar();
				setVisible(false);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	
		if(e.getSource() == bextrato)
		{
			try {
				TelaExtrato a = new TelaExtrato();
				a.iniciar();
				setVisible(false);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
		if(e.getSource() == bdebito)
		{
			try {
				TelaDebito a = new TelaDebito();
				a.iniciar();
				setVisible(false);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
	}

		
	
}
