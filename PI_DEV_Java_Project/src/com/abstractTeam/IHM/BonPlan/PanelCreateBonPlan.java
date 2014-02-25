package com.abstractTeam.IHM.BonPlan;


import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.TitledBorder;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JScrollBar;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import java.util.Date;
import java.util.Calendar;
import javax.swing.SpinnerListModel;
import javax.swing.JCheckBox;
import javax.swing.JEditorPane;

public class PanelCreateBonPlan extends JPanel {
	private JTextField textFieldNom;

	/**
	 * Create the panel.
	 */
	public PanelCreateBonPlan() {
		setBackground(Color.WHITE);
		setBorder(new TitledBorder(null, "Bon plan", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setBounds(337, 76, 1013, 611);
		setVisible(true);
		setLayout(null);
		
		JLabel lblNom = new JLabel("Nom :");
		lblNom.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNom.setBounds(47, 50, 46, 14);
		add(lblNom);
		
		textFieldNom = new JTextField();
		textFieldNom.setBounds(166, 49, 86, 20);
		add(textFieldNom);
		textFieldNom.setColumns(10);
		
		JButton btnCreer = new JButton("Cr\u00E9er");
		btnCreer.setFont(new Font("Tahoma", Font.PLAIN, 22));
		btnCreer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
			}
		});
		btnCreer.setBounds(824, 533, 168, 54);
		add(btnCreer);
		
		JLabel IblDescription = new JLabel("Description :");
		IblDescription.setFont(new Font("Tahoma", Font.PLAIN, 15));
		IblDescription.setBounds(47, 405, 95, 14);
		add(IblDescription);
		
		JLabel IblPhotos = new JLabel("Photos :");
		IblPhotos.setFont(new Font("Tahoma", Font.PLAIN, 15));
		IblPhotos.setBounds(47, 573, 86, 14);
		add(IblPhotos);
		
		JLabel lblType = new JLabel("Type :");
		lblType.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblType.setBounds(47, 137, 46, 14);
		add(lblType);
		
		JLabel lblDate = new JLabel("Date :");
		lblDate.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblDate.setBounds(47, 238, 46, 14);
		add(lblDate);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("Soir\u00E9e orientale");
		chckbxNewCheckBox.setForeground(Color.BLACK);
		chckbxNewCheckBox.setBounds(166, 135, 101, 23);
		add(chckbxNewCheckBox);
		
		JCheckBox chckbxSoireWestern = new JCheckBox("Soir\u00E9e Western");
		chckbxSoireWestern.setBounds(299, 135, 101, 23);
		add(chckbxSoireWestern);
		
		JCheckBox chckbxHalloween = new JCheckBox("Halloween");
		chckbxHalloween.setBounds(427, 135, 97, 23);
		add(chckbxHalloween);
		
		JCheckBox chckbxadhra = new JCheckBox("7adhra");
		chckbxadhra.setBounds(543, 135, 97, 23);
		add(chckbxadhra);
		
		JSpinner spinner = new JSpinner();
		spinner.setModel(new SpinnerDateModel(new Date(1393282800000L), null, null, Calendar.DAY_OF_YEAR));
		spinner.setBounds(166, 229, 114, 36);
		add(spinner);
		
		JLabel lblPrix = new JLabel("Prix :");
		lblPrix.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPrix.setBounds(47, 324, 46, 14);
		add(lblPrix);
		
		JSpinner spinner_1 = new JSpinner();
		spinner_1.setBounds(166, 318, 114, 31);
		add(spinner_1);
		
		JEditorPane editorPane = new JEditorPane();
		editorPane.setBackground(Color.LIGHT_GRAY);
		editorPane.setForeground(Color.BLACK);
		editorPane.setBounds(161, 405, 479, 155);
		add(editorPane);

	}
}
