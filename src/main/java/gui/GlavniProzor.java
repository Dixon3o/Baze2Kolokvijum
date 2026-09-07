package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GlavniProzor {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GlavniProzor window = new GlavniProzor();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GlavniProzor() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnUnosGrada = new JButton("Unesite grad");
		btnUnosGrada.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DijalogUnosGrada dug = new DijalogUnosGrada();
				dug.setVisible(true);
			}
		});
		btnUnosGrada.setBounds(33, 64, 159, 27);
		frame.getContentPane().add(btnUnosGrada);
		
		JButton btnUnosLeta = new JButton("Unesite let");
		btnUnosLeta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DijalogUnosLeta dul = new DijalogUnosLeta();
				dul.setVisible(true);
			}
		});
		btnUnosLeta.setBounds(228, 64, 159, 27);
		frame.getContentPane().add(btnUnosLeta);
		
		JButton btnBrisanjeAerodroma = new JButton("Obrisite aerodrom");
		btnBrisanjeAerodroma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DijalogBrisanjeAerodroma dba = new DijalogBrisanjeAerodroma();
				dba.setVisible(true);
			}
		});
		btnBrisanjeAerodroma.setBounds(33, 140, 159, 27);
		frame.getContentPane().add(btnBrisanjeAerodroma);
		
		JButton btnPrikazLetova = new JButton("Prikaz letova");
		btnPrikazLetova.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DijalogPrikazLetova dpl = new DijalogPrikazLetova();
				dpl.setVisible(true);
			}
		});
		btnPrikazLetova.setBounds(228, 140, 159, 27);
		frame.getContentPane().add(btnPrikazLetova);
	}
}
