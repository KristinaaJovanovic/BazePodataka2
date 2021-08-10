package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import crud.FiilmCrud;
import crud.GlumacCrud;
import model.Fiilm;
import model.Glumac;

import javax.swing.JLabel;
import java.awt.Font;
import java.util.List;

import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DUnosGlume extends JDialog {
	
	private GlumacCrud gc=new GlumacCrud();
	private FiilmCrud fc=new FiilmCrud();

	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DUnosGlume dialog = new DUnosGlume();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DUnosGlume() {
		setTitle("Unos glume");
		setBounds(100, 100, 498, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lbl_izaberiGlumca = new JLabel("Izaberite glumca:");
			lbl_izaberiGlumca.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lbl_izaberiGlumca.setBounds(10, 11, 120, 24);
			contentPanel.add(lbl_izaberiGlumca);
		}
		{
			JLabel lbl_izaberiFilm = new JLabel("Izaberite film:");
			lbl_izaberiFilm.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lbl_izaberiFilm.setBounds(10, 76, 105, 24);
			contentPanel.add(lbl_izaberiFilm);
		}
		
		JComboBox<Glumac> cb_glumac = new JComboBox<Glumac>();
		List<Glumac> glumci=gc.listGlumac();
		for(Glumac g: glumci) {
			cb_glumac.addItem(g);
		}
		cb_glumac.setBounds(130, 14, 329, 22);
		contentPanel.add(cb_glumac);
		
		JComboBox<Fiilm> cb_film = new JComboBox<Fiilm>();
		List<Fiilm> filmovi=fc.listFilm();
		for(Fiilm f: filmovi) {
			cb_film.addItem(f);
		}
		
		cb_film.setBounds(125, 79, 334, 22);
		contentPanel.add(cb_film);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btn_unesi = new JButton("Unesi");
				btn_unesi.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Glumac g=(Glumac) cb_glumac.getSelectedItem();
						Fiilm f=(Fiilm) cb_film.getSelectedItem();
						
						gc.poveziGlumcaIFilm(g, f);
					}
				});
				btn_unesi.setActionCommand("OK");
				buttonPane.add(btn_unesi);
				getRootPane().setDefaultButton(btn_unesi);
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
