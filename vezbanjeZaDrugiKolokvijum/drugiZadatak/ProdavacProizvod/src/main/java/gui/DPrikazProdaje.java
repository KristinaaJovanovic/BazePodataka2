package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import crud.ProdajaCrud;
import crud.ProdavacCrud;
import crud.TableModelProdaja;
import model.Prodaja;
import model.Prodavac;

import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class DPrikazProdaje extends JDialog {
	
	private JComboBox<Prodavac> cb_prodavac;
	private ProdavacCrud pc=new ProdavacCrud();
	private ProdajaCrud prc=new ProdajaCrud();

	private final JPanel contentPanel = new JPanel();
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DPrikazProdaje dialog = new DPrikazProdaje();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DPrikazProdaje() {
		setTitle("Prikaz");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel, BorderLayout.NORTH);
			{
				JLabel lbl_prodavac = new JLabel("Prodavac:");
				lbl_prodavac.setFont(new Font("Tahoma", Font.PLAIN, 7));
				panel.add(lbl_prodavac);
			}
			{
				this.cb_prodavac = new JComboBox<Prodavac>();
				cb_prodavac.setFont(new Font("Tahoma", Font.PLAIN, 6));
				List<Prodavac> prodavci=pc.listProdavci();
				for(Prodavac p: prodavci) {
					cb_prodavac.addItem(p);
				}
				panel.add(cb_prodavac);
			}
			{
				JButton btn_prikazi = new JButton("Prikazi");
				btn_prikazi.setFont(new Font("Tahoma", Font.PLAIN, 9));
				btn_prikazi.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Prodavac prodavac=(Prodavac) cb_prodavac.getSelectedItem();
						List<Prodaja> list=prc.prodatiProizvodi(prodavac);
						TableModelProdaja tmp=new TableModelProdaja(list);
						table.setModel(tmp);
						
					}
				});
				panel.add(btn_prikazi);
			}
		}
		{
			JScrollPane scrollPane = new JScrollPane();
			contentPanel.add(scrollPane, BorderLayout.CENTER);
			{
				table = new JTable();
				scrollPane.setViewportView(table);
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
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
