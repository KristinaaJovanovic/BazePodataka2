package gui;

import java.awt.BorderLayout;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import crud.IgracCrud;
import model.Igrac;

import javax.swing.JLabel;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;

public class DBrisanjeIgraca extends JDialog {
	
	private JComboBox<Igrac> cb_igrac;
	private IgracCrud ic=new IgracCrud();

	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DBrisanjeIgraca dialog = new DBrisanjeIgraca();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DBrisanjeIgraca() {
		setTitle("Brisanje igraca");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lbl_igrac = new JLabel("Izaberi igraca:");
			lbl_igrac.setBounds(10, 84, 106, 23);
			contentPanel.add(lbl_igrac);
		}
		{
			this.cb_igrac = new JComboBox<Igrac>();
			List<Igrac> igraci=ic.listIgraci();
			for(Igrac i: igraci) {
				cb_igrac.addItem(i);
			}
			cb_igrac.setBounds(141, 84, 283, 22);
			contentPanel.add(cb_igrac);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btn_brisi = new JButton("Brisi");
				btn_brisi.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Igrac igrac=(Igrac) cb_igrac.getSelectedItem();
						ic.deleteIgrac(igrac);
					}
				});
				btn_brisi.setActionCommand("OK");
				buttonPane.add(btn_brisi);
				getRootPane().setDefaultButton(btn_brisi);
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
