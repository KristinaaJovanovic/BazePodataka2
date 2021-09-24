package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GlavniProzor {

	private JFrame frmIgra;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GlavniProzor window = new GlavniProzor();
					window.frmIgra.setVisible(true);
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
		frmIgra = new JFrame();
		frmIgra.setTitle("Igra");
		frmIgra.setBounds(100, 100, 450, 300);
		frmIgra.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmIgra.getContentPane().setLayout(null);
		
		JButton btn_unosIgraca = new JButton("Unos igraca");
		btn_unosIgraca.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//TODO prozor za unos igraca
				DUnosIgraca dUnosIgraca=new DUnosIgraca();
				dUnosIgraca.setVisible(true);
			}
		});
		btn_unosIgraca.setBounds(10, 29, 107, 23);
		frmIgra.getContentPane().add(btn_unosIgraca);
		
		JButton btn_unosMeca = new JButton("Unos meca");
		btn_unosMeca.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//TODO prozor za unos meca
				DUnosMeca dUnosMeca=new DUnosMeca();
				dUnosMeca.setVisible(true);
			}
		});
		btn_unosMeca.setBounds(10, 87, 107, 23);
		frmIgra.getContentPane().add(btn_unosMeca);
		
		JButton btn_obrisi = new JButton("Brisanje igraca");
		btn_obrisi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//TODO prozor za brisanje igraca
				DBrisanjeIgraca dBrisanjeIgraca=new DBrisanjeIgraca();
				dBrisanjeIgraca.setVisible(true);
			}
		});
		btn_obrisi.setBounds(244, 29, 138, 23);
		frmIgra.getContentPane().add(btn_obrisi);
		
		JButton btn_prikaz = new JButton("Prikaz meceva");
		btn_prikaz.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//TODO prozor za prikaz meceva
				DPrikazMeceva dPrikazMeceva=new DPrikazMeceva();
				dPrikazMeceva.setVisible(true);
			}
		});
		btn_prikaz.setBounds(244, 87, 138, 23);
		frmIgra.getContentPane().add(btn_prikaz);
	}
}
