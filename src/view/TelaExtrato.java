package view;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import org.json.JSONException;

import dao.MovimentacaoDAO;
import to.MovimentacaoTO;
import util.JSONWrite;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ResourceBundle;

@SuppressWarnings("serial")
public class TelaExtrato extends JFrame implements ActionListener{
	JPanel contentPane;
	String sconta;
	JLabel lconta;
	JLabel lcliente;
	JLabel lext;
	JTable text;
	JButton bsair;
	String titulo;
	ResourceBundle bn;
	Connection conn;
	Date dataIni;
	Date dataFim;
	JButton bgera;
	public TelaExtrato() throws SQLException 
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 284);
		contentPane = new JPanel();
		contentPane.setBackground(UIManager.getColor("Button.background"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		bn = Util.getBundle();

		JLabel lcliente = new JLabel("Nome: Adriano");
		lcliente.setFont(new Font("Tahoma", Font.BOLD, 13));
		lcliente.setForeground(new Color(153, 51, 255));
		lcliente.setBounds(47, 11, 181, 14);
		contentPane.add(lcliente);
		
		JLabel lconta = new JLabel("Conta: 20765-9");
		lconta.setFont(new Font("Tahoma", Font.BOLD, 13));
		lconta.setForeground(new Color(153, 51, 255));
		lconta.setBounds(385, 11, 227, 14);
		contentPane.add(lconta);
		
		
		text = new JTable();
		text.setBackground(new Color(153, 51, 255));
		text.setFont(new Font("Tahoma", Font.BOLD, 11));
		text.setBounds(35, 36, 577, 164);
		contentPane.add(text);
		
		bsair= new JButton(bn.getString("TelaExtrato.bsair"));
		bsair.setForeground(new Color(153, 51, 255));
		bsair.setFont(new Font("Tahoma", Font.BOLD, 11));
		bsair.setBounds(369, 211, 72, 23);
		contentPane.add(bsair);
		
		bgera= new JButton(bn.getString("TelaExtrato.bgerar"));
		bgera.setFont(new Font("Tahoma", Font.BOLD, 11));
		bgera.setForeground(new Color(153, 51, 255));
		bgera.setBackground(UIManager.getColor("MenuBar.background"));
		bgera.setBounds(156, 211, 72, 23);
		contentPane.add(bgera);
		
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(359, 36, 17, 164);
		contentPane.add(scrollBar);
		
		bsair.addActionListener(this);
		bgera.addActionListener(this);

		

		setDefaultLookAndFeelDecorated(true);
		

		// As colunas da tabela
		String colunas[] = {"Data","Cliente" ,"Lançamento","Valor", "Agencia","Conta","Agencia Destino","Conta Destino"};

		// Cria um DefaultTableModel para manipular os dados do JTable. Os parâmetros são um array que identifica as colunas e um int que seta o número inicial que linhas
		
		MovimentacaoDAO dao = new MovimentacaoDAO();
		DefaultTableModel modelo = new DefaultTableModel(colunas,0);
		int i = 1;
		int seq = dao.mostraQuantidade(Util.getConta().getConta());
		modelo.addRow(colunas);
		// Insere os dados no DefaultTableModel
		while(i <= seq )
		{
			MovimentacaoTO to = dao.carregar(i);
			if(to.getConta() == Util.getConta().getConta())
			{
				modelo.addRow(new String[]{""+to.getData(),to.getNome() ,to.getOperacao(),""+to.getValor(),""+to.getAgencia(),""+to.getConta(),""+to.getAgenciaDestino(),""+to.getContaDestino()});
			}
			i++;
		}
		// Associa o DefaultTableModel ao JTable
		text.setModel(modelo);

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
		if(e.getSource() == bgera)
		{
			MovimentacaoTO to = new MovimentacaoTO();
			try {
				JSONWrite.listExtract(to.geraLista());
			} catch (JSONException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
}
