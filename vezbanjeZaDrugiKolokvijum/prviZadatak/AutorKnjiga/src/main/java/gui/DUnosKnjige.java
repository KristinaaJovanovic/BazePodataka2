package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import crud.AutorCrud;
import crud.KnjigaCrud;
import crud.OblastCrud;
import model.Autor;
import model.Knjiga;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;

public class DUnosKnjige extends JDialog {
	
	private JComboBox<Autor> cb_autor;
	private KnjigaCrud kc=new KnjigaCrud();
	private AutorCrud ac=new AutorCrud();
	private OblastCrud oc=new OblastCrud();

	private final JPanel contentPanel = new JPanel();
	private JTextField tf_knjiga;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DUnosKnjige dialog = new DUnosKnjige();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DUnosKnjige() {
		setTitle("Unos knjige");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lbl_nazivKnjige = new JLabel("Naziv knjige: ");
		lbl_nazivKnjige.setBounds(10, 11, 75, 14);
		contentPanel.add(lbl_nazivKnjige);
		
		tf_knjiga = new JTextField();
		tf_knjiga.setBounds(105, 8, 226, 20);
		contentPanel.add(tf_knjiga);
		tf_knjiga.setColumns(10);
		
		JLabel lbl_autor = new JLabel("Autor:");
		lbl_autor.setBounds(10, 66, 46, 14);
		contentPanel.add(lbl_autor);
		
		this.cb_autor = new JComboBox<Autor>();
		List<Autor> autori=ac.listAutora();
		for(Autor a: autori) {
			cb_autor.addItem(a);
		}
		cb_autor.setBounds(105, 62, 308, 22);
		contentPanel.add(cb_autor);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btn_unesi = new JButton("Unesi");
				btn_unesi.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String naziv=tf_knjiga.getText();
						Autor a=(Autor) cb_autor.getSelectedItem();
						Knjiga k=new Knjiga();
						k.setAutor(a);
						k.setKnjigaNaziv(naziv);
						kc.insertKnjiga(k);
						
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
