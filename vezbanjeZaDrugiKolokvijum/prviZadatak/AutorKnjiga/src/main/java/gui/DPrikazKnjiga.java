package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import crud.KnjigaCrud;
import crud.OblastCrud;
import model.Knjiga;
import model.Oblast;

import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DPrikazKnjiga extends JDialog {
	
	JComboBox<Oblast> cb_oblast;
	private OblastCrud oc=new OblastCrud();
	private KnjigaCrud kc=new KnjigaCrud();

	private final JPanel contentPanel = new JPanel();
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DPrikazKnjiga dialog = new DPrikazKnjiga();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DPrikazKnjiga() {
		setTitle("Prikaz knjiga");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel, BorderLayout.NORTH);
			{
				JLabel lbl_oblast = new JLabel("Izaberite oblast:");
				panel.add(lbl_oblast);
			}
			{
				this.cb_oblast = new JComboBox<Oblast>();
				List<Oblast> oblasti=oc.listOblasti();
				for(Oblast o: oblasti) {
					cb_oblast.addItem(o);
				}
				panel.add(cb_oblast);
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
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Oblast o=(Oblast) cb_oblast.getSelectedItem();
						List<Knjiga> knjige=kc.knjigeKojePripadajuOblasti(o);
						TableModelKnjige tmk=new TableModelKnjige(knjige);
						table.setModel(tmk);
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

}
