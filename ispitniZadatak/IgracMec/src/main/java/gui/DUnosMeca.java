package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import crud.IgracCrud;
import crud.MecCrud;
import model.Igrac;
import model.Mec;

import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;

public class DUnosMeca extends JDialog {
	
	private JComboBox<Igrac> cb_prviIgrac;
	private IgracCrud ic=new IgracCrud();
	private JComboBox<Igrac> cb_drugiIgrac;
	private MecCrud mc=new MecCrud();

	private final JPanel contentPanel = new JPanel();
	private JTextField tf_datum;
	private JTextField tf_rezultat;
	private JTextField tf_vreme;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DUnosMeca dialog = new DUnosMeca();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DUnosMeca() {
		setTitle("Unos meca");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lbl_prviIgrac = new JLabel("Prvi igrac:");
			lbl_prviIgrac.setBounds(10, 11, 92, 14);
			contentPanel.add(lbl_prviIgrac);
		}
		{
			JLabel lbl_drugiIgrac = new JLabel("Drugi igrac:");
			lbl_drugiIgrac.setBounds(10, 65, 71, 14);
			contentPanel.add(lbl_drugiIgrac);
		}
		
		this.cb_prviIgrac = new JComboBox<Igrac>();
		List<Igrac> igraci1=ic.listIgraci();
		for(Igrac i1: igraci1) {
			cb_prviIgrac.addItem(i1);
		}
		cb_prviIgrac.setBounds(144, 7, 280, 22);
		contentPanel.add(cb_prviIgrac);
		
		this.cb_drugiIgrac = new JComboBox<Igrac>();
		List<Igrac> igraci2=ic.listIgraci();
		for(Igrac i2: igraci2) {
			cb_drugiIgrac.addItem(i2);
		}
		cb_drugiIgrac.setBounds(144, 61, 280, 22);
		contentPanel.add(cb_drugiIgrac);
		
		JLabel lbl_datum = new JLabel("Datum");
		lbl_datum.setBounds(10, 129, 46, 14);
		contentPanel.add(lbl_datum);
		
		JLabel lbl_rezultat = new JLabel("Rezultat");
		lbl_rezultat.setBounds(10, 172, 71, 14);
		contentPanel.add(lbl_rezultat);
		
		tf_datum = new JTextField();
		tf_datum.setBounds(91, 126, 86, 20);
		contentPanel.add(tf_datum);
		tf_datum.setColumns(10);
		
		tf_rezultat = new JTextField();
		tf_rezultat.setBounds(91, 169, 86, 20);
		contentPanel.add(tf_rezultat);
		tf_rezultat.setColumns(10);
		
		JLabel lbl_vreme = new JLabel("Vreme");
		lbl_vreme.setBounds(221, 129, 46, 14);
		contentPanel.add(lbl_vreme);
		
		tf_vreme = new JTextField();
		tf_vreme.setBounds(297, 126, 86, 20);
		contentPanel.add(tf_vreme);
		tf_vreme.setColumns(10);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btn_unesi = new JButton("Unesi");
				btn_unesi.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Igrac prvi=(Igrac) cb_prviIgrac.getSelectedItem();
						Igrac drugi=(Igrac) cb_drugiIgrac.getSelectedItem();
						String datum=tf_datum.getText();
						String rezultat=tf_rezultat.getText();
						String vreme=tf_vreme.getText();
						
						Mec mec=new Mec();
						mec.setIgrac1(prvi);
						mec.setIgrac2(drugi);
						mec.setDatum(datum);
						mec.setRezultat(rezultat);
						mec.setVreme(vreme);
						
						mc.insertMec(mec);
					}
				});
				btn_unesi.setActionCommand("OK");
				buttonPane.add(btn_unesi);
				getRootPane().setDefaultButton(btn_unesi);
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
