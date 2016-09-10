package view;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ResourceBundle;

@SuppressWarnings("serial")
public class TelaSaque extends JFrame implements ActionListener {
	JPanel painelAcesso;
	String sconta;
	JLabel lconta;
	JLabel lcliente;
	JButton bsacar;
	JButton bsair;
	JLabel lvalor;
	JLabel lsaque;
	TextField tvalor;
	String titulo;
	ResourceBundle bn;
	Connection conn;

	public TelaSaque() throws SQLException {
		conn = Util.getConn();
		Container c = getContentPane();
		c.setLayout(new GridLayout(1, 1));
		setContentPane(c);
		bn = Util.getBundle();
		sconta = "xxx.xxx-z";
		bsacar = new JButton(bn.getString("TelaSaque.bsacar"));
		bsair = new JButton(bn.getString("TelaSaque.bsair"));
		lvalor = new JLabel(bn.getString("TelaSaque.lvalor"));
		tvalor = new TextField(7);
		lconta = new JLabel(""+Util.getCli().getConta());
		lcliente = new JLabel(Util.getContaDAO().getNome(Util.getConta()));
		lsaque = new JLabel(bn.getString("TelaSaque.lsaque"));

		bsacar.addActionListener(this);
		bsair.addActionListener(this);
		
		painelAcesso = new JPanel();

		painelAcesso.add(lcliente);
		painelAcesso.add(lconta);
		painelAcesso.add(lsaque);
		painelAcesso.add(lvalor);
		painelAcesso.add(tvalor);
		painelAcesso.add(bsacar);
		painelAcesso.add(bsair);

		c.add(painelAcesso);
		setDefaultLookAndFeelDecorated(true);
		setTitle(bn.getString("TelaSaque.titulo"));
		setLocation(400, 400);
		setSize(170, 180);
		
	}

	public void iniciar()
	{
		setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == bsacar) {
			double as = Double.parseDouble(tvalor.getText());
			System.out.println(as);
			try {
				if(as < Util.getContaDAO().mostraSaldo(Util.getConta()))
				{	
					try {
						Util.getCli().saque(as);
					}catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					JOptionPane.showMessageDialog(null,"Você Sacou: "+ as + " Com Sucesso","Saque Efetuado",1);
				}
				else { JOptionPane.showMessageDialog(null,"SALDO INSUFICIENTE", "Saldo insuficiente",2); }
			} catch (HeadlessException | SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	
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
	}
}
