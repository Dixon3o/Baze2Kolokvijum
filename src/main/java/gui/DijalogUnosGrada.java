package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import crud.GradCrud;
import model.Cgrad;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DijalogUnosGrada extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private GradCrud gc = new GradCrud();
	private JTextField tfIme;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DijalogUnosGrada dialog = new DijalogUnosGrada();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DijalogUnosGrada() {
		setTitle("Unos grada");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblGrad = new JLabel("Unesite ime grada");
		lblGrad.setBounds(49, 63, 129, 17);
		contentPanel.add(lblGrad);
		
		tfIme = new JTextField();
		tfIme.setBounds(196, 61, 143, 21);
		contentPanel.add(tfIme);
		tfIme.setColumns(10);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Unesi");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String naziv = tfIme.getText();
						Cgrad grad = new Cgrad();
						grad.setGradNaziv(naziv);
						boolean u = gc.insertGrad(grad);
						if(u) {
							JOptionPane.showMessageDialog(DijalogUnosGrada.this, "Uspesno", "Uspesno", JOptionPane.INFORMATION_MESSAGE);
						}else {
							JOptionPane.showMessageDialog(DijalogUnosGrada.this, "Neuspesno", "Neuspesno", JOptionPane.ERROR_MESSAGE);
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
						tfIme.setText("");
						setVisible(false);
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
