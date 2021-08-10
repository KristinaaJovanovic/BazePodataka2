package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import crud.GlumacCrud;
import model.Glumac;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DUnosGlumca extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField tf_ime;
	private JTextField tf_prezime;
	private JTextField tf_godinaRodjenja;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DUnosGlumca dialog = new DUnosGlumca();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DUnosGlumca() {
		setTitle("Unos Glumca");
		setBounds(100, 100, 490, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lbl_ime = new JLabel("Unesite ime glumca:");
		lbl_ime.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl_ime.setBounds(10, 11, 140, 23);
		contentPanel.add(lbl_ime);
		
		JLabel lbl_prezime = new JLabel("Unesite prezime glumca:");
		lbl_prezime.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl_prezime.setBounds(10, 54, 154, 23);
		contentPanel.add(lbl_prezime);
		
		JLabel lbl_godinaRodjenja = new JLabel("Unesite godinu rodjenja:");
		lbl_godinaRodjenja.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl_godinaRodjenja.setBounds(10, 104, 154, 23);
		contentPanel.add(lbl_godinaRodjenja);
		
		tf_ime = new JTextField();
		tf_ime.setBounds(160, 14, 190, 20);
		contentPanel.add(tf_ime);
		tf_ime.setColumns(10);
		
		tf_prezime = new JTextField();
		tf_prezime.setBounds(174, 57, 177, 20);
		contentPanel.add(tf_prezime);
		tf_prezime.setColumns(10);
		
		tf_godinaRodjenja = new JTextField();
		tf_godinaRodjenja.setBounds(174, 107, 176, 20);
		contentPanel.add(tf_godinaRodjenja);
		tf_godinaRodjenja.setColumns(10);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btn_unos = new JButton("Unesi");
				btn_unos.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String ime=tf_ime.getText();
						String prezime=tf_prezime.getText();
						int godinaRodjenja=Integer.parseInt(tf_godinaRodjenja.getText());
						
						Glumac g=new Glumac();
						g.setIme(ime);
						g.setPrezime(prezime);
						g.setGodinaRodjenja(godinaRodjenja);
						
						GlumacCrud gc=new GlumacCrud();
						gc.insertGlumac(g);
					}
				});
				btn_unos.setActionCommand("OK");
				buttonPane.add(btn_unos);
				getRootPane().setDefaultButton(btn_unos);
			}
			{
				JButton btn_izlaz = new JButton("Izadji");
				btn_izlaz.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						setVisible(false);
					}
				});
				btn_izlaz.setActionCommand("Cancel");
				buttonPane.add(btn_izlaz);
			}
		}
	}
}
