package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import crud.GlumacCrud;
import model.Glumac;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.util.List;

import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DBrisanjeGlumca extends JDialog {

	private GlumacCrud gc=new GlumacCrud();
	private JComboBox<Glumac> cb_glumac;
	
	//dinamicki ComboBox
	private DefaultComboBoxModel<Glumac> model=new DefaultComboBoxModel<Glumac>();
	
	
	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DBrisanjeGlumca dialog = new DBrisanjeGlumca(null, true);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DBrisanjeGlumca(JFrame frmGluma, boolean modal) {
		super(frmGluma, modal);
		setTitle("Brisanje Glumca");
		setBounds(100, 100, 523, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lbl_izaberiGlumca = new JLabel("Izaberite glumca:");
			lbl_izaberiGlumca.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lbl_izaberiGlumca.setBounds(10, 11, 117, 23);
			contentPanel.add(lbl_izaberiGlumca);
		}
		{
			this.cb_glumac = new JComboBox<Glumac>(model);
			List<Glumac> glumci=gc.listGlumac();
			for(Glumac g: glumci) {
				cb_glumac.addItem(g);
			}
			cb_glumac.setBounds(137, 13, 342, 22);
			contentPanel.add(cb_glumac);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btn_brisanje = new JButton("Obrisi");
				btn_brisanje.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Glumac g=(Glumac) cb_glumac.getSelectedItem();
						boolean uspesno=gc.deleteGlumac(g);
						if(uspesno) {
							deleteFromCB(g);
							JOptionPane.showMessageDialog(DBrisanjeGlumca.this,
								    "Uspesno obrisan nastavnik!");
						}else {
							JOptionPane.showMessageDialog(DBrisanjeGlumca.this,
								    "Neuspesno brisanje glumca",
								    "Greska",
								    JOptionPane.ERROR_MESSAGE);
						}
					}
				});
				btn_brisanje.setActionCommand("OK");
				buttonPane.add(btn_brisanje);
				getRootPane().setDefaultButton(btn_brisanje);
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
	
	private void deleteFromCB(Glumac g) {
		this.model.removeElement(g);
		this.cb_glumac.setModel(model);
	}

}
