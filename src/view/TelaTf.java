package view;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import dao.ContaDAO;
import to.ContaTO;
import util.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class TelaTf extends JFrame implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	String titulo;
	TextField tagencia;
	TextField tconta;
	TextField tvalor;
	JPanel painelAcesso;
	String sconta;
	JLabel lconta;
	JLabel lcliente;
	JLabel ltf;
	JLabel lagencia;
	JLabel lconta2;
	JLabel lvalor;
	JLabel ldados;
	JButton bconfirma;
	JButton bcancela;
	ResourceBundle bn;
	Connection conn;

	public TelaTf() throws SQLException
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 463, 236);
		contentPane = new JPanel();
		contentPane.setBackground(UIManager.getColor("Button.background"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		bn = Util.getBundle();
		conn = Util.getConn();
		
		tagencia = new TextField(7);
		tagencia.setForeground(new Color(153, 51, 255));
		tagencia.setBounds(269, 47, 105, 20);
		contentPane.add(tagencia);
		tagencia.setColumns(10);
		
		tconta = new TextField(7); 
		tconta.setForeground(new Color(153, 51, 255));
		tconta.setBounds(269, 85, 105, 20);
		contentPane.add(tconta);
		tconta.setColumns(10);
		
		tvalor = new TextField(7);
		tvalor.setBounds(269, 125, 105, 20);
		contentPane.add(tvalor);
		tvalor.setColumns(10);
		
		lconta = new JLabel (bn.getString("TelaAcesso.lconta")+": "+Util.getCli().getConta());
		lconta.setFont(new Font("Tahoma", Font.BOLD, 13));
		lconta.setForeground(new Color(153, 51, 255));
		lconta.setBounds(269, 11, 168, 14);
		contentPane.add(lconta);
		
		lcliente = new JLabel (bn.getString("TelaDebito.lcliente")+ ": "+Util.getContaDAO().getNome(Util.getConta()));
		lcliente.setFont(new Font("Tahoma", Font.BOLD, 13));
		lcliente.setForeground(new Color(153, 51, 255));
		lcliente.setBounds(63, 11, 130, 14);
		contentPane.add(lcliente);
		
		lagencia = new JLabel(bn.getString("TelaTf.lagencia"));
		lagencia.setHorizontalAlignment(SwingConstants.RIGHT);
		lagencia.setFont(new Font("Tahoma", Font.BOLD, 11));
		lagencia.setForeground(new Color(153, 51, 255));
		lagencia.setBounds(65, 50, 95, 14);
		contentPane.add(lagencia);
		
		lconta2 = new JLabel(bn.getString("TelaTf.lconta2"));
		lconta2.setHorizontalAlignment(SwingConstants.RIGHT);
		lconta2.setForeground(new Color(153, 51, 255));
		lconta2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lconta2.setBounds(63, 88, 97, 14);
		contentPane.add(lconta2);
		
		lvalor =  new JLabel(bn.getString("TelaTf.lvalor"));
		lvalor.setHorizontalAlignment(SwingConstants.RIGHT);
		lvalor.setFont(new Font("Tahoma", Font.BOLD, 11));
		lvalor.setForeground(new Color(153, 51, 255));
		lvalor.setBounds(63, 128, 97, 14);
		contentPane.add(lvalor);
		
		
		bconfirma = new JButton(bn.getString("TelaTf.bconfirma"));
		bconfirma.setFont(new Font("Tahoma", Font.BOLD, 11));
		bconfirma.setForeground(new Color(153, 51, 255));
		bconfirma.setBackground(UIManager.getColor("MenuBar.background"));
		bconfirma.setBounds(60, 166, 110, 23);
		contentPane.add(bconfirma);
		
		bcancela = new JButton(bn.getString("TelaTf.bcancela"));
		bcancela.setForeground(new Color(153, 51, 255));
		bcancela.setFont(new Font("Tahoma", Font.BOLD, 11));
		bcancela.setBounds(269, 166, 110, 23);
		contentPane.add(bcancela);
		
		

		bcancela.addActionListener(this);
		bconfirma.addActionListener(this);


		setDefaultLookAndFeelDecorated(true);
		setTitle(bn.getString("TelaTf.titulo")); 
		

	}

	public void iniciar()
	{
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == bcancela)
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
		if(e.getSource() == bconfirma)
		{

			int dialogButton = JOptionPane.showConfirmDialog (null, "Deseja Realmente fazer este movimento?","TRANSFERÊNCIA",JOptionPane.YES_NO_OPTION);
			System.out.println("OPÇÃO: "+dialogButton);
			if(dialogButton == JOptionPane.YES_OPTION)
			{
				int conta    = Integer.parseInt(tconta.getText());
				int agencia  = Integer.parseInt(tagencia.getText());
				double valor = Double.parseDouble(tvalor.getText());
				System.out.println("Agencia: "+agencia+"\nConta: "+conta+"\nValor:"+valor);

				JSONWrite.gravaJSON(JSONWrite.geraTO(conta),"rec");
				JSONWrite.gravaJSON(JSONWrite.geraTO(Util.getConta().getConta()), "pag");

				ContaDAO dao = new ContaDAO();
				ContaTO rec = JSONRead.lerJSON("rec");
				ContaTO pag = JSONRead.lerJSON("pag");

				try {
					dao.transfere(pag, rec, valor);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			else
			{
				JOptionPane.showMessageDialog(null,"Transferência Cancelada!!!");
			}
		}

	}
}
