package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GlavniProzor {

	private JFrame frmGluma;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GlavniProzor window = new GlavniProzor();
					window.frmGluma.setVisible(true);
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
		frmGluma = new JFrame();
		frmGluma.setTitle("Gluma");
		frmGluma.setBounds(100, 100, 494, 300);
		frmGluma.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmGluma.getContentPane().setLayout(null);
		
		JButton btn_unosGlumca = new JButton("Unos Glumca");
		btn_unosGlumca.addActionListener(new ActionListener() {
			//TODO Napravi prozor za unos glumca
			public void actionPerformed(ActionEvent e) {
				DUnosGlumca dUnosGlumca=new DUnosGlumca();
				dUnosGlumca.setVisible(true);
			}
		});
		btn_unosGlumca.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btn_unosGlumca.setBounds(10, 11, 142, 31);
		frmGluma.getContentPane().add(btn_unosGlumca);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(-39, 77, -74, 23);
		frmGluma.getContentPane().add(btnNewButton);
		
		JButton btn_unosUloge = new JButton("Unos uloge");
		btn_unosUloge.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//TODO Napravi novi prozor koji ce povezati glumca sa filmom u kojem glumi
				DUnosGlume dUnosGlume=new DUnosGlume();
				dUnosGlume.setVisible(true);
			}
		});
		btn_unosUloge.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btn_unosUloge.setBounds(10, 77, 142, 31);
		frmGluma.getContentPane().add(btn_unosUloge);
		
		JButton btn_brisanjeGlumca = new JButton("Brisanje Glumca");
		btn_brisanjeGlumca.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//TODO Napravi prozor za brisanje glumca
				DBrisanjeGlumca dBrisanjeGlumca=new DBrisanjeGlumca(frmGluma, true);
				dBrisanjeGlumca.setVisible(true);
			}
		});
		btn_brisanjeGlumca.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btn_brisanjeGlumca.setBounds(179, 183, 135, 31);
		frmGluma.getContentPane().add(btn_brisanjeGlumca);
		
		JButton btn_promenaZanra = new JButton("Promena zanra");
		btn_promenaZanra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//TODO
				DPromenaZanra dPromenaZanra=new DPromenaZanra();
				dPromenaZanra.setVisible(true);
			}
		});
		btn_promenaZanra.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btn_promenaZanra.setBounds(301, 17, 167, 31);
		frmGluma.getContentPane().add(btn_promenaZanra);
		
		JButton btn_prikazGlumaca = new JButton("Prikazi Glumce");
		btn_prikazGlumaca.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//TODO
				DPrikazGlumaca dPrikazGlumaca=new DPrikazGlumaca();
				dPrikazGlumaca.setVisible(true);
			}
		});
		btn_prikazGlumaca.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btn_prikazGlumaca.setBounds(301, 77, 167, 31);
		frmGluma.getContentPane().add(btn_prikazGlumaca);
	}
}
