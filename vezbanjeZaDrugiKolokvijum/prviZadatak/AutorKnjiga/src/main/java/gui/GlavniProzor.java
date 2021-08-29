package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GlavniProzor {

	private JFrame frmKnjigeINjihovi;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GlavniProzor window = new GlavniProzor();
					window.frmKnjigeINjihovi.setVisible(true);
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
		frmKnjigeINjihovi = new JFrame();
		frmKnjigeINjihovi.setTitle("Knjige i njihovi autori");
		frmKnjigeINjihovi.setBounds(100, 100, 450, 300);
		frmKnjigeINjihovi.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmKnjigeINjihovi.getContentPane().setLayout(null);
		
		JButton btn_unos = new JButton("Unos knjige");
		btn_unos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//TODO prozor za unos knjige
				DUnosKnjige dUnos=new DUnosKnjige();
				dUnos.setVisible(true);
			}
		});
		btn_unos.setBounds(148, 28, 128, 37);
		frmKnjigeINjihovi.getContentPane().add(btn_unos);
		
		JButton btn_prikaz = new JButton("Prikaz knjiga");
		btn_prikaz.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//TODO prozor za prikaz knjiga
				DPrikazKnjiga dPrikaz=new DPrikazKnjiga();
				dPrikaz.setVisible(true);
			}
		});
		btn_prikaz.setBounds(148, 94, 128, 37);
		frmKnjigeINjihovi.getContentPane().add(btn_prikaz);
		
		JButton btn_obrisi = new JButton("Brisanje knjige");
		btn_obrisi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//TODO prozor za brisanje
				DObrisiKnjigu dObrisi=new DObrisiKnjigu();
				dObrisi.setVisible(true);
			}
		});
		btn_obrisi.setBounds(148, 158, 128, 37);
		frmKnjigeINjihovi.getContentPane().add(btn_obrisi);
		
		JButton btn_povezi = new JButton("Povezi");
		btn_povezi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//TODO prozor za povezivanje knjige i oblasti
				DPoveziKnjiguOblast dPovezi=new DPoveziKnjiguOblast();
				dPovezi.setVisible(true);
			}
		});
		btn_povezi.setBounds(148, 221, 128, 29);
		frmKnjigeINjihovi.getContentPane().add(btn_povezi);
	}
}
