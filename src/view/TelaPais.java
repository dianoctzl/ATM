package view;

import factory.ConnectionFactory;

import javax.swing.*;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.ResourceBundle;

public class TelaPais extends JFrame implements MouseListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Connection conn = null;
	DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
	JLabel br;
	JLabel us;
	JLabel es;
	ResourceBundle bn;
	public ResourceBundle getBn() {
		return bn;
	}
	public void setBn(ResourceBundle bn) {
		this.bn = bn;
	}
	Locale Local;
	public Locale getLocal() {
		return Local;
	}
	public void setLocal(Locale local) {
		Local = local;
	}
	JPanel painel;
	private ConnectionFactory bd;
	public TelaPais()
	{
		Container c = getContentPane();
		 c.setLayout(new FlowLayout());
		 setContentPane(c);
		 painel = new JPanel();
		
	/*	 ImageIcon ibra = new ImageIcon(getClass().getResource("bra.png"));
		 ImageIcon iusa = new ImageIcon(getClass().getResource("usa.png"));
		 ImageIcon iesp = new ImageIcon(getClass().getResource("esp.png"));
		 */
		 br = new JLabel( new ImageIcon(getClass().getResource("bra.jpg")));
		 us = new JLabel(new ImageIcon(getClass().getResource("usa.jpg")));
		 es = new JLabel( new ImageIcon(getClass().getResource("esp.jpg")));
		
		 br.addMouseListener(this);
		 us.addMouseListener(this);
		 es.addMouseListener(this);
		 
		 br.setSize(300,300);
		 us.setSize(300,300);
		 es.setSize(300,300);
		 
		 
		 painel.add(br);
		 painel.add(us);
		 painel.add(es);
		 
		 c.add(br);
		 c.add(us);
		 c.add(es);
		 
		 setTitle("SCE");
			
		 setDefaultLookAndFeelDecorated(true);
		 setDefaultCloseOperation(EXIT_ON_CLOSE); 
		 setLocation(400,400); 
		 setSize(450,150);
		 
	}
	
	public void iniciar()
	{
		setVisible(true);
	}

	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == br)
		{
			bn = ResourceBundle.getBundle("ling",new Locale("pt","BR"));
			Util.setBundle(bn);
			Local = new Locale("pt","BR");
			setVisible(false);
			TelaAcesso a = new TelaAcesso();
			a.iniciar();
			setBd(new ConnectionFactory());
			try {
				conn = ConnectionFactory.obtemConexao();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			// *** IMPORTANTE ***: Força o uso de transação.
			try {
				conn.setAutoCommit(false);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if(e.getSource() == us)
		{
			bn = ResourceBundle.getBundle("ling",Locale.US);
			Util.setBundle(bn);
			Local = Locale.US;
			setVisible(false);
			TelaAcesso a = new TelaAcesso();
			a.iniciar();
			setBd(new ConnectionFactory());
			try {
				conn = ConnectionFactory.obtemConexao();
				Util.setConn(conn);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			// *** IMPORTANTE ***: Força o uso de transação.
			try {
				conn.setAutoCommit(true);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if(e.getSource()== es)
		{
			bn = ResourceBundle.getBundle("ling",new Locale("es","ES"));
			Util.setBundle(bn);
			Local = new Locale("es","ES");
			setVisible(false);
			setBd(new ConnectionFactory());
			try {
				Util.setConn(ConnectionFactory.obtemConexao());
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			TelaAcesso a = new TelaAcesso();
			a.iniciar();
			
			
		}
	}
	
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	public ConnectionFactory getBd() {
		return bd;
	}
	public void setBd(ConnectionFactory bd) {
		this.bd = bd;
	}
	
}
