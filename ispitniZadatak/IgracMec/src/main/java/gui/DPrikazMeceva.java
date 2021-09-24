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
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class DPrikazMeceva extends JDialog {
	
	private JComboBox<Igrac> cb_igrac;
	private MecCrud mc=new MecCrud();
	private IgracCrud ic=new IgracCrud();

	private final JPanel contentPanel = new JPanel();
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DPrikazMeceva dialog = new DPrikazMeceva();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DPrikazMeceva() {
		setTitle("Prikaz meceva");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel, BorderLayout.NORTH);
			{
				JLabel lbl_igrac = new JLabel("Izaberi igraca:");
				lbl_igrac.setFont(new Font("Tahoma", Font.PLAIN, 8));
				panel.add(lbl_igrac);
			}
			{
				this.cb_igrac = new JComboBox<Igrac>();
				cb_igrac.setFont(new Font("Tahoma", Font.PLAIN, 9));
				List<Igrac> igraci=ic.listIgraci();
				for(Igrac i: igraci) {
					cb_igrac.addItem(i);
				}
				panel.add(cb_igrac);
			}
			{
				JButton btn_prikazi = new JButton("Prikazi");
				btn_prikazi.setFont(new Font("Tahoma", Font.PLAIN, 19));
				btn_prikazi.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						//TODO
						Igrac i=(Igrac) cb_igrac.getSelectedItem();
						List<Mec> mecevi=mc.meceviKojiSuOdigrani(i);
						if(mecevi!=null) {
							TableModelPrikaz tmp=new TableModelPrikaz(mecevi);
							table.setModel(tmp);
						}else {
							JOptionPane.showMessageDialog(DPrikazMeceva.this, "Ne postji lista!");
						}
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
