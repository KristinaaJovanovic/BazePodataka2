package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import crud.FiilmCrud;
import crud.GlumacCrud;
import model.Fiilm;
import model.Glumac;

import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class DPrikazGlumaca extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable table;
	
	private FiilmCrud fc=new FiilmCrud();
	private GlumacCrud gc=new GlumacCrud();
	private JComboBox<Fiilm> cb_filmovi;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DPrikazGlumaca dialog = new DPrikazGlumaca();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DPrikazGlumaca() {
		setTitle("Prikaz Glumaca");
		setBounds(100, 100, 549, 405);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel, BorderLayout.NORTH);
			{
				JLabel lbl_filmovi = new JLabel("Izaberite neki film:");
				lbl_filmovi.setFont(new Font("Tahoma", Font.PLAIN, 11));
				panel.add(lbl_filmovi);
			}
			{
				this.cb_filmovi = new JComboBox<Fiilm>();
				cb_filmovi.setFont(new Font("Tahoma", Font.PLAIN, 10));
				List<Fiilm> filmovi=fc.listFilm();
				for(Fiilm f: filmovi) {
					cb_filmovi.addItem(f);
				}
				panel.add(cb_filmovi);
			}
			{
				JButton btn_prikaz = new JButton("Prikaz");
				btn_prikaz.setFont(new Font("Tahoma", Font.PLAIN, 15));
				btn_prikaz.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Fiilm f=(Fiilm) cb_filmovi.getSelectedItem();
						List<Glumac> glumci=gc.glumciUFilmu(f);
						//i sad, ne mogu odmah ovo da nalepim pa zato pravim model
						TableModelGlumac tmg=new TableModelGlumac(glumci);
						table.setModel(tmg);
					}
				});
				panel.add(btn_prikaz);
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
				JButton btn_izlaz = new JButton("Izlaz");
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

}
