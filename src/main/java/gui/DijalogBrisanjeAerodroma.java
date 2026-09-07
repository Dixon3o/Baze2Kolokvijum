package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import crud.AerodromCrud;
import model.Caerodrom;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DijalogBrisanjeAerodroma extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	AerodromCrud ac = new AerodromCrud();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DijalogBrisanjeAerodroma dialog = new DijalogBrisanjeAerodroma();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DijalogBrisanjeAerodroma() {
		setTitle("Brisanje aerodroma");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblAerodrom = new JLabel("Izaberi aerodrom");
			lblAerodrom.setBounds(29, 53, 108, 17);
			contentPanel.add(lblAerodrom);
		}
		
		JComboBox cbAerodrom = new JComboBox();
		cbAerodrom.setBounds(170, 48, 222, 26);
		contentPanel.add(cbAerodrom);
		List<Caerodrom> lista = ac.lista();
		for(Caerodrom a : lista){
			cbAerodrom.addItem(a);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Caerodrom aerodrom = (Caerodrom) cbAerodrom.getSelectedItem();
						boolean u = ac.deleteAerodrom(aerodrom);
						if(u) {
							JOptionPane.showMessageDialog(DijalogBrisanjeAerodroma.this, "Uspesno", "Uspesno", JOptionPane.INFORMATION_MESSAGE);
						}else {
							JOptionPane.showMessageDialog(DijalogBrisanjeAerodroma.this, "Neuspesno", "Neuspesno", JOptionPane.ERROR_MESSAGE);
						}
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						setVisible(false);
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
