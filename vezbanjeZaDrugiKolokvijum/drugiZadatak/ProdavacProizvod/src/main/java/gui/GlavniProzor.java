package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GlavniProzor {

	private JFrame frmProdaja;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GlavniProzor window = new GlavniProzor();
					window.frmProdaja.setVisible(true);
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
		frmProdaja = new JFrame();
		frmProdaja.setTitle("Prodaja");
		frmProdaja.setBounds(100, 100, 450, 300);
		frmProdaja.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmProdaja.getContentPane().setLayout(null);
		
		JButton btn_prikaz = new JButton("Prikazi");
		btn_prikaz.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//TODO prozor za prikaz prodaje
				DPrikazProdaje dPrikaz=new DPrikazProdaje();
				dPrikaz.setVisible(true);
			}
		});
		btn_prikaz.setBounds(175, 108, 89, 23);
		frmProdaja.getContentPane().add(btn_prikaz);
		
		JButton btn_unosVrste = new JButton("Unos vrste proizvoda");
		btn_unosVrste.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//TODO prozor za unos vrste proizvoda
				DUnosVrste dUnosVrste=new DUnosVrste();
				dUnosVrste.setVisible(true);
			}
		});
		btn_unosVrste.setBounds(10, 23, 164, 23);
		frmProdaja.getContentPane().add(btn_unosVrste);
		
		JButton btn_unosProizvoda = new JButton("Unos novog proizvoda");
		btn_unosProizvoda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//TODO prozor za unos novog proizvoda
				DUnosProizvoda dUnosProizvoda=new DUnosProizvoda();
				dUnosProizvoda.setVisible(true);
			}
		});
		btn_unosProizvoda.setBounds(260, 23, 164, 23);
		frmProdaja.getContentPane().add(btn_unosProizvoda);
		
		JButton btn_obrisi = new JButton("Obrisi prodavca");
		btn_obrisi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//TODO prozor za brisanje prodavca
				DBrisanjeProdavca dBrisanjeProdavca=new DBrisanjeProdavca();
				dBrisanjeProdavca.setVisible(true);
			}
		});
		btn_obrisi.setBounds(154, 172, 144, 23);
		frmProdaja.getContentPane().add(btn_obrisi);
	}
}
