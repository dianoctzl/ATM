package view;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Locale;
import java.util.ResourceBundle;

@SuppressWarnings("serial")
public class TelaDebito extends JFrame implements ActionListener {
	JPanel painelAcesso;
	String sconta;
	JLabel lconta;
	JLabel lcliente;
	JLabel ldebito;
	JLabel ldesc;
	JLabel ldata;
	JLabel lvalor;
	JTextField tvalor;
	JTextField tdesc;
	JTextField tdata;
	JButton bsair;
	JButton bcadastrar;
	String titulo;
	ResourceBundle bn;
	Locale Local;
	Connection conn;
	
	public TelaDebito() throws SQLException {
		Container c = getContentPane();
		c.setLayout(new GridLayout(1, 2));
		setContentPane(c);
		conn = Util.getConn();
		bn = Util.getBundle();
		sconta = "xxx.xxx-z";
		ldebito = new JLabel(bn.getString("TelaDebito.ldebito"));
		lconta = new JLabel(""+Util.getCli().getConta());
		lcliente = new JLabel(Util.getContaDAO().getNome(Util.getConta()));
		ldesc = new JLabel(bn.getString("TelaDebito.ldesc"));
		ldata = new JLabel(bn.getString("TelaDebito.ldata"));
		lvalor = new JLabel(bn.getString("TelaDebito.lvalor"));
		tvalor = new JTextField(10);
		tdesc = new JTextField(10);
		tdata = new JTextField(10);
		bsair = new JButton(bn.getString("TelaDebito.bsair"));
		bcadastrar = new JButton(bn.getString("TelaDebito.bcadastrar"));

		painelAcesso = new JPanel();

		painelAcesso.add(lcliente);
		painelAcesso.add(lconta);
		painelAcesso.add(ldebito);
		painelAcesso.add(ldata);
		painelAcesso.add(tdata);
		painelAcesso.add(lvalor);
		painelAcesso.add(tvalor);
		painelAcesso.add(ldesc);
		painelAcesso.add(tdesc);
		painelAcesso.add(bcadastrar);
		painelAcesso.add(bsair);
		
		bsair.addActionListener(this);
		bcadastrar.addActionListener(this);
		
		c.add(painelAcesso);
		setDefaultLookAndFeelDecorated(true);
		setTitle(bn.getString("TelaDebito.titulo"));
		setLocation(400, 400);
		setSize(200, 200);
		
	}

	public void iniciar()
	{
		setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == bsair)
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
		if(e.getSource() == bcadastrar)
		{
			JOptionPane.showMessageDialog( null,"Cadastrado");
		}
	}
}
