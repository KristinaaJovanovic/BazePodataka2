package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import crud.FiilmCrud;
import model.Fiilm;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;

public class DPromenaZanra extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField tf_zanr;
	private JComboBox<Fiilm> cb_izaberiFilm;
	private FiilmCrud fc=new FiilmCrud();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DPromenaZanra dialog = new DPromenaZanra();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DPromenaZanra() {
		setTitle("Promena Zanra");
		setBounds(100, 100, 518, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lbl_film = new JLabel("Izaberite film:");
		lbl_film.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl_film.setBounds(10, 11, 94, 23);
		contentPanel.add(lbl_film);
		
		this.cb_izaberiFilm = new JComboBox<Fiilm>();
		List<Fiilm> filmovi=fc.listFilm();
		for(Fiilm f: filmovi) {
			cb_izaberiFilm.addItem(f);
		}
		cb_izaberiFilm.setBounds(114, 13, 378, 22);
		contentPanel.add(cb_izaberiFilm);
		
		JLabel lbl_zanr = new JLabel("Unesite novi zanr:");
		lbl_zanr.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl_zanr.setBounds(10, 110, 124, 23);
		contentPanel.add(lbl_zanr);
		
		tf_zanr = new JTextField();
		tf_zanr.setBounds(144, 113, 156, 20);
		contentPanel.add(tf_zanr);
		tf_zanr.setColumns(10);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btn_promeni = new JButton("Promeni");
				btn_promeni.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Fiilm f=(Fiilm) cb_izaberiFilm.getSelectedItem();
						String zanr=tf_zanr.getText();
						fc.promeniZanr(f, zanr);
					}
				});
				btn_promeni.setActionCommand("OK");
				buttonPane.add(btn_promeni);
				getRootPane().setDefaultButton(btn_promeni);
			}
			{
				JButton btn_izadji = new JButton("Izadji");
				btn_izadji.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						setVisible(false);
					}
				});
				btn_izadji.setActionCommand("Cancel");
				buttonPane.add(btn_izadji);
			}
		}
	}
}
