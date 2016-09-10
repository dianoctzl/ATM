package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.UIManager;
import javax.swing.JTable;
import javax.swing.JScrollBar;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

public class TelaVariavel extends JFrame {

	private JPanel contentPane;
	private JTextField tagencia;
	private JTextField tconta;
	private JPasswordField tsenha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaVariavel frame = new TelaVariavel();
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
	public TelaVariavel() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 463, 236);
		contentPane = new JPanel();
		contentPane.setBackground(UIManager.getColor("Button.background"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel text = new JLabel("Acesso");
		text.setFont(new Font("Tahoma", Font.BOLD, 20));
		text.setForeground(new Color(153, 51, 255));
		text.setBounds(105, 0, 237, 39);
		contentPane.add(text);
		
		JButton blogar = new JButton("Logar");
		blogar.setFont(new Font("Tahoma", Font.BOLD, 11));
		blogar.setForeground(new Color(153, 51, 255));
		blogar.setBackground(UIManager.getColor("MenuBar.background"));
		blogar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		blogar.setBounds(60, 166, 110, 23);
		contentPane.add(blogar);
		
		JButton bcancelar = new JButton("Sair");
		bcancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		bcancelar.setForeground(new Color(153, 51, 255));
		bcancelar.setFont(new Font("Tahoma", Font.BOLD, 11));
		bcancelar.setBounds(269, 166, 110, 23);
		contentPane.add(bcancelar);
		
		JLabel lagencia = new JLabel("Ag\u00EAncia");
		lagencia.setFont(new Font("Tahoma", Font.BOLD, 11));
		lagencia.setForeground(new Color(153, 51, 255));
		lagencia.setBounds(60, 50, 162, 14);
		contentPane.add(lagencia);
		
		JLabel lconta = new JLabel("Conta");
		lconta.setForeground(new Color(153, 51, 255));
		lconta.setFont(new Font("Tahoma", Font.BOLD, 11));
		lconta.setBounds(60, 88, 162, 14);
		contentPane.add(lconta);
		
		JLabel lsenha = new JLabel("Senha");
		lsenha.setFont(new Font("Tahoma", Font.BOLD, 11));
		lsenha.setForeground(new Color(153, 51, 255));
		lsenha.setBounds(60, 128, 199, 14);
		contentPane.add(lsenha);
		
		tagencia = new JTextField();
		tagencia.setForeground(new Color(153, 51, 255));
		tagencia.setBounds(269, 47, 105, 20);
		contentPane.add(tagencia);
		tagencia.setColumns(10);
		
		tconta = new JTextField();
		tconta.setForeground(new Color(153, 51, 255));
		tconta.setBounds(269, 85, 105, 20);
		contentPane.add(tconta);
		tconta.setColumns(10);
		
		tsenha = new JPasswordField();
		tsenha.setBounds(269, 125, 105, 20);
		contentPane.add(tsenha);
	}
}
