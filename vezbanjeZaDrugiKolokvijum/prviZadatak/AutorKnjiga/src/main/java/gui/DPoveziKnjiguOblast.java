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
import model.Knjiga;
import model.Oblast;

import javax.swing.JLabel;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;

public class DPoveziKnjiguOblast extends JDialog {
	
	private JComboBox<Knjiga> cb_knjiga;
	private JComboBox<Oblast> cb_oblast;
	private AutorCrud ac=new AutorCrud();
	private OblastCrud oc=new OblastCrud();
	private KnjigaCrud kc=new KnjigaCrud();

	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DPoveziKnjiguOblast dialog = new DPoveziKnjiguOblast();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DPoveziKnjiguOblast() {
		setTitle("Povezivanje knjige i oblasti");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lbl_knjiga = new JLabel("Knjiga:");
			lbl_knjiga.setBounds(10, 11, 46, 14);
			contentPanel.add(lbl_knjiga);
		}
		{
			JLabel lbl_oblast = new JLabel("Oblast:");
			lbl_oblast.setBounds(10, 85, 46, 14);
			contentPanel.add(lbl_oblast);
		}
		{
			this.cb_knjiga = new JComboBox<Knjiga>();
			List<Knjiga> knjige=kc.listKnjiga();
			for(Knjiga k: knjige) {
				cb_knjiga.addItem(k);
			}
			cb_knjiga.setBounds(102, 7, 309, 22);
			contentPanel.add(cb_knjiga);
		}
		{
			this.cb_oblast = new JComboBox<Oblast>();
			List<Oblast> oblasti=oc.listOblasti();
			for(Oblast o: oblasti) {
				cb_oblast.addItem(o);
			}
			cb_oblast.setBounds(102, 81, 309, 22);
			contentPanel.add(cb_oblast);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btn_unesi = new JButton("Unesi");
				btn_unesi.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Knjiga k=(Knjiga) cb_knjiga.getSelectedItem();
						Oblast o=(Oblast) cb_oblast.getSelectedItem();
						kc.poveziKnjiguIOblast(k, o);
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
