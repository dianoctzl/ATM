package view;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.util.ResourceBundle;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class TelaSaldo extends JFrame implements ActionListener {

	private JPanel contentPane;
	JLabel lcliente;
	JLabel lconta;
	JLabel lconsultar;
	JLabel lsaldo;
	JButton bvolta;
	JButton bsair;
	JPanel painelAcesso ;
	String conta;
	NumberFormat numberFormatter;
	private double saldo;
	String titulo;
	ResourceBundle bn;
	Connection conn;
	public TelaSaldo() throws SQLException
	{
     	 bn = Util.getBundle();
		conn = Util.getConn();
		saldo = Util.getConta().getSaldo();
		NumberFormat currencyFormatter = NumberFormat
				.getCurrencyInstance(bn.getLocale());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 402, 284);
		contentPane = new JPanel();
		contentPane.setBackground(UIManager.getColor("Button.background"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
				
		
		lcliente = new JLabel (bn.getString("TelaDebito.lcliente")+ ": "+Util.getContaDAO().getNome(Util.getConta()));
		lcliente.setFont(new Font("Tahoma", Font.BOLD, 13));
		lcliente.setForeground(new Color(153, 51, 255));
		lcliente.setBounds(47, 11, 150, 14);
		contentPane.add(lcliente);
		
		lconta = new JLabel (bn.getString("TelaAcesso.lconta")+": "+Util.getCli().getConta());
		lconta.setFont(new Font("Tahoma", Font.BOLD, 13));
		lconta.setForeground(new Color(153, 51, 255));
		lconta.setBounds(238, 11, 101, 14);
		contentPane.add(lconta);
		
		lsaldo = new JLabel(bn.getString("TelaSaldo.lsaldo")+": "+currencyFormatter.format(saldo));
		lsaldo.setForeground(new Color(105,105,105));
		lsaldo.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lsaldo.setBounds(47, 52, 292, 80);
		contentPane.add(lsaldo);
		
		bvolta = new JButton(bn.getString("TelaSaldo.bvolta"));
		bvolta.setFont(new Font("Tahoma", Font.BOLD, 11));
		bvolta.setForeground(new Color(153, 51, 255));
		bvolta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		bvolta.setBounds(47, 157, 97, 53);
		contentPane.add(bvolta);
		
		bsair = new JButton(bn.getString("TelaSaldo.bsair"));
		bsair.setForeground(new Color(153, 51, 255));
		bsair.setFont(new Font("Tahoma", Font.BOLD, 11));
		bsair.setBounds(242, 157, 97, 53);
		contentPane.add(bsair);
				
		bvolta.addActionListener(this);
		bsair.addActionListener(this);
		
		
		setTitle(bn.getString("TelaSaldo.titulo"));
		setDefaultLookAndFeelDecorated(true);
		 
		
	}
	
	public void iniciar()
	{
		setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == bvolta)
		{
			try {
				TelaInicial i = new TelaInicial();
				i.inicar();
				setVisible(false);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}
		
		if(e.getSource() == bsair)
		{
			System.exit(0);
		}
	}

	
}
