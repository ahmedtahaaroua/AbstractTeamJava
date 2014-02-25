

package com.abstractTeam.IHM.Inscription;


import java.awt.Color;

import java.awt.Font;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.MatteBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JTextField;
import javax.swing.JButton;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.Legend;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.DefaultPieDataset;

@SuppressWarnings("serial")
public class PanelStatistique  extends JPanel {


	
	public PanelStatistique() {
		setBackground(Color.WHITE);
		
		setBorder(new TitledBorder(new MatteBorder(2, 2, 2, 2,
				(Color) new Color(192, 192, 192)),
				"Statistique  - Resto-Tunisie -", TitledBorder.LEADING,
				TitledBorder.TOP, new Font(" Arial ", Font.BOLD, 15),
				Color.DARK_GRAY));
		setBounds(337, 76, 1013, 611);

		setLayout(null);
		setVisible(true);
		
		JPanel panelConnection = new JPanel();
		
		panelConnection.setBounds(10, 23, 993, 577);
		add(panelConnection);
		panelConnection.setLayout(null);
		
		  ImageIcon icon = new ImageIcon("C:\\Users\\farouk-skander\\Pictures\\azza.jpg");
	       JLabel img = new JLabel(icon);
	       panelConnection.add(img);
	       //pack();
		 Stat tpc = new Stat(); 
		    tpc.setVisible(true);
		    
		    
		    
		
	//	panelConnection.add(textAddresse);
		//textAddresse.setColumns(10);
		
	
		
		
	}}
	
