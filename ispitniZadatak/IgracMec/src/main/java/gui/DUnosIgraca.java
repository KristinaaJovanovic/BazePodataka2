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
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DUnosIgraca extends JDialog {
	
	private IgracCrud ic=new IgracCrud();

	private final JPanel contentPanel = new JPanel();
	private JTextField tf_ime;
	private JTextField tf_prezime;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DUnosIgraca dialog = new DUnosIgraca();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DUnosIgraca() {
		setTitle("Unos igraca");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lbl_ime = new JLabel("Ime:");
		lbl_ime.setBounds(10, 25, 46, 14);
		contentPanel.add(lbl_ime);
		
		JLabel lbl_prezime = new JLabel("Prezime:");
		lbl_prezime.setBounds(10, 95, 85, 14);
		contentPanel.add(lbl_prezime);
		
		tf_ime = new JTextField();
		tf_ime.setBounds(105, 22, 182, 20);
		contentPanel.add(tf_ime);
		tf_ime.setColumns(10);
		
		tf_prezime = new JTextField();
		tf_prezime.setBounds(105, 92, 182, 20);
		contentPanel.add(tf_prezime);
		tf_prezime.setColumns(10);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btn_unesi = new JButton("Unesi");
				btn_unesi.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String ime=tf_ime.getText();
						String prezime=tf_prezime.getText();
						Igrac igrac=new Igrac();
						igrac.setIgracIme(ime);
						igrac.setIgracPrezime(prezime);
						ic.insertIgrac(igrac);
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
