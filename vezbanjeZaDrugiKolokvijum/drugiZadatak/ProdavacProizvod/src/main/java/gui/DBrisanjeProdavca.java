package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import crud.ProdavacCrud;
import model.Prodavac;

import javax.swing.JLabel;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;

public class DBrisanjeProdavca extends JDialog {
	
	private JComboBox<Prodavac> cb_prodavac;
	private ProdavacCrud pc=new ProdavacCrud();

	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DBrisanjeProdavca dialog = new DBrisanjeProdavca();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DBrisanjeProdavca() {
		setTitle("Brisanje prodavca");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lbl_prodavac = new JLabel("Izaberi prodavca:");
			lbl_prodavac.setBounds(10, 97, 100, 14);
			contentPanel.add(lbl_prodavac);
		}
		{
			this.cb_prodavac = new JComboBox<Prodavac>();
			List<Prodavac> lista=pc.listProdavci();
			for(Prodavac p: lista) {
				cb_prodavac.addItem(p);
			}
			cb_prodavac.setBounds(132, 93, 292, 22);
			contentPanel.add(cb_prodavac);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btn_obrisi = new JButton("Obrisi");
				btn_obrisi.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Prodavac prodavac=(Prodavac) cb_prodavac.getSelectedItem();
						pc.deleteProdavac(prodavac);
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
