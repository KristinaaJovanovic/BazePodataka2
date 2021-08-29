package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import crud.VrstaCrud;
import model.Vrsta;

import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DUnosVrste extends JDialog {
	
	private VrstaCrud vc=new VrstaCrud();

	private final JPanel contentPanel = new JPanel();
	private JTextField tf_vrsta;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DUnosVrste dialog = new DUnosVrste();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DUnosVrste() {
		setTitle("Unos");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lbl_vrsta = new JLabel("Vrsta proizvoda:");
		lbl_vrsta.setBounds(10, 112, 94, 14);
		contentPanel.add(lbl_vrsta);
		
		tf_vrsta = new JTextField();
		tf_vrsta.setBounds(143, 109, 145, 20);
		contentPanel.add(tf_vrsta);
		tf_vrsta.setColumns(10);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btn_unesi = new JButton("Unesi");
				btn_unesi.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String vrstaProizvoda=tf_vrsta.getText();
						Vrsta vrsta=new Vrsta();
						vc.insertVrsta(vrsta);
						
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
