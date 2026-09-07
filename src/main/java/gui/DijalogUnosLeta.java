package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import crud.AerodromCrud;
import crud.LetCrud;
import model.Caerodrom;
import model.Clet;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DijalogUnosLeta extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private AerodromCrud ac = new AerodromCrud();
	private LetCrud lc = new LetCrud();
	private JTextField tfVreme;
	private JTextField tfTrajanje;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DijalogUnosLeta dialog = new DijalogUnosLeta();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DijalogUnosLeta() {
		setTitle("Unos leta");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblPolazni = new JLabel("Polazni aerodrom");
			lblPolazni.setBounds(27, 56, 121, 17);
			contentPanel.add(lblPolazni);
		}
		
			JComboBox cbPolazni = new JComboBox();
			cbPolazni.setBounds(179, 51, 135, 26);
			contentPanel.add(cbPolazni);
			List<Caerodrom> l1 = ac.lista();
			for(Caerodrom l : l1){
				cbPolazni.addItem(l);
			}
		
		
			JLabel lblDolazni = new JLabel("Dolazni aerodrom");
			lblDolazni.setBounds(27, 106, 121, 17);
			contentPanel.add(lblDolazni);
		
		
			JComboBox cbDolazni = new JComboBox();
			cbDolazni.setBounds(179, 101, 135, 26);
			contentPanel.add(cbDolazni);
			{
				JLabel lblTrajanje = new JLabel("Trajanje");
				lblTrajanje.setBounds(27, 172, 58, 17);
				contentPanel.add(lblTrajanje);
			}
			{
				tfVreme = new JTextField();
				tfVreme.setBounds(79, 170, 80, 21);
				contentPanel.add(tfVreme);
				tfVreme.setColumns(10);
			}
			{
				JLabel lblVreme = new JLabel("Vreme:");
				lblVreme.setBounds(198, 172, 58, 17);
				contentPanel.add(lblVreme);
			}
			
			tfTrajanje = new JTextField();
			tfTrajanje.setBounds(257, 170, 94, 21);
			contentPanel.add(tfTrajanje);
			tfTrajanje.setColumns(10);
			List<Caerodrom> l2 = ac.lista();
			for(Caerodrom l : l2){
				cbDolazni.addItem(l);
			}
	
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Unesi");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Clet let = new Clet();
						Caerodrom prvi = (Caerodrom) cbPolazni.getSelectedItem();
						Caerodrom drugi = (Caerodrom) cbDolazni.getSelectedItem();
						String vreme = tfVreme.getText();
						String datum = tfTrajanje.getText();
						let.setCaerodrom1(prvi);
						let.setCaerodrom2(drugi);
						let.setVreme(datum);
						let.setTrajanje(vreme);
						boolean u = lc.insertLet(let);
						if(u) {
							JOptionPane.showMessageDialog(DijalogUnosLeta.this, "Uspesno", "Uspesno", JOptionPane.INFORMATION_MESSAGE);
						}else {
							JOptionPane.showMessageDialog(DijalogUnosLeta.this, "Neuspesno", "Neuspesno", JOptionPane.ERROR_MESSAGE);
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
						tfTrajanje.setText("");
						tfVreme.setText("");
						setVisible(false);
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
