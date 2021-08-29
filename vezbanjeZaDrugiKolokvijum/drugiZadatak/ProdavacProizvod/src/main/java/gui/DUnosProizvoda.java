package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import crud.ProizvodCrud;
import crud.VrstaCrud;
import model.Proizvod;
import model.Vrsta;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;

public class DUnosProizvoda extends JDialog {
	
	private JComboBox<Vrsta> cb_vrsta;
	private VrstaCrud vc=new VrstaCrud();
	private ProizvodCrud pc=new ProizvodCrud();

	private final JPanel contentPanel = new JPanel();
	private JTextField tf_naziv;
	private JTextField tf_cena;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DUnosProizvoda dialog = new DUnosProizvoda();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DUnosProizvoda() {
		setTitle("Unos");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lbl_naziv = new JLabel("Naziv:");
			lbl_naziv.setBounds(10, 23, 46, 14);
			contentPanel.add(lbl_naziv);
		}
		{
			JLabel lbl_cena = new JLabel("Cena:");
			lbl_cena.setBounds(10, 82, 46, 14);
			contentPanel.add(lbl_cena);
		}
		{
			JLabel lbl_vrsta = new JLabel("Vrsta:");
			lbl_vrsta.setBounds(10, 147, 46, 14);
			contentPanel.add(lbl_vrsta);
		}
		{
			tf_naziv = new JTextField();
			tf_naziv.setBounds(97, 20, 137, 20);
			contentPanel.add(tf_naziv);
			tf_naziv.setColumns(10);
		}
		{
			tf_cena = new JTextField();
			tf_cena.setBounds(97, 79, 137, 20);
			contentPanel.add(tf_cena);
			tf_cena.setColumns(10);
		}
		
		this.cb_vrsta = new JComboBox<Vrsta>();
		List<Vrsta> vrste=vc.listVrste();
		for(Vrsta v: vrste) {
			cb_vrsta.addItem(v);
		}
		cb_vrsta.setBounds(97, 143, 295, 22);
		contentPanel.add(cb_vrsta);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btn_unesi = new JButton("Unesi");
				btn_unesi.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String naziv=tf_naziv.getText();
						double cena=Double.parseDouble(tf_cena.getText());
						Vrsta vrsta=(Vrsta) cb_vrsta.getSelectedItem();
						Proizvod p=new Proizvod();
						p.setCena(cena);
						p.setNaziv(naziv);
						p.setVrsta(vrsta);
						pc.insertProizvod(p);
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
