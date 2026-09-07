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
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DijalogPrikazLetova extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private AerodromCrud ac = new AerodromCrud();
	private LetCrud lc = new LetCrud();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DijalogPrikazLetova dialog = new DijalogPrikazLetova();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DijalogPrikazLetova() {
		setTitle("Prikaz letova");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel, BorderLayout.NORTH);
			{
				JLabel lblAerodrom = new JLabel("Izaberite aerodrom");
				panel.add(lblAerodrom);
			}
			
				JComboBox cbAerodrom = new JComboBox();
				panel.add(cbAerodrom);
				List<Caerodrom> letovi = ac.lista();
				for(Caerodrom l : letovi){
					cbAerodrom.addItem(l);
				}
		
			{
				JButton btnPrikazi = new JButton("Prikazi");
				btnPrikazi.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Caerodrom a = (Caerodrom) cbAerodrom.getSelectedItem();
						List<Clet> letovi = lc.listaLetovaZaAerodrom(a);
						PrikazLetova pl = new PrikazLetova(letovi);
						table.setModel(pl);
					}
				});
				panel.add(btnPrikazi);
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
