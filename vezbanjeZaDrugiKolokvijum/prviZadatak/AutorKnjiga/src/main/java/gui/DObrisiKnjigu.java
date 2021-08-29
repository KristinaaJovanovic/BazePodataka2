package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import crud.KnjigaCrud;
import model.Knjiga;

import javax.swing.JLabel;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;

public class DObrisiKnjigu extends JDialog {
	
	private JComboBox<Knjiga> cb_knjiga;
	private KnjigaCrud kc=new KnjigaCrud();

	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DObrisiKnjigu dialog = new DObrisiKnjigu();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DObrisiKnjigu() {
		setTitle("Brisanje knjige");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lbl_knjiga = new JLabel("Izaberite knjigu:");
			lbl_knjiga.setBounds(10, 29, 86, 14);
			contentPanel.add(lbl_knjiga);
		}
		{
			this.cb_knjiga = new JComboBox<Knjiga>();
			List<Knjiga> knjige=kc.listKnjiga();
			for(Knjiga k: knjige) {
				cb_knjiga.addItem(k);
			}
			cb_knjiga.setBounds(106, 25, 318, 22);
			contentPanel.add(cb_knjiga);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btn_obrisi = new JButton("Obrisi");
				btn_obrisi.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Knjiga knjiga=(Knjiga) cb_knjiga.getSelectedItem();
						kc.deleteKnjiga(knjiga);
					}
				});
				btn_obrisi.setActionCommand("OK");
				buttonPane.add(btn_obrisi);
				getRootPane().setDefaultButton(btn_obrisi);
			}
			{
				JButton btn_zatvori = new JButton("Zatvori");
				btn_zatvori.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						setVisible(false);
					}
				});
				btn_zatvori.setActionCommand("Cancel");
				buttonPane.add(btn_zatvori);
			}
		}
	}

}
