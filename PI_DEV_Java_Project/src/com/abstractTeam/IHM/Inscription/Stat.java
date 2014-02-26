package com.abstractTeam.IHM.Inscription;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import java.awt.event.WindowAdapter;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.Legend;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.DefaultPieDataset;

import com.abstractTeam.Controller.NoteDao;
import com.abstractTeam.Controller.PlatDao;
import com.abstractTeam.Model.ComparateurPlat;
import com.abstractTeam.Model.Plat;

public class Stat extends JFrame   {
	private JPanel pnl;
	
	public Stat() {
	
		setSize(600, 450);
		setLocationRelativeTo(null);

		addWindowListener(new WindowAdapter() {
			/*
			 * public void windowClosing(WindowEvent e) { dispose();
			 * System.exit(0); }
			 */
		});
		pnl = new JPanel(new BorderLayout());
		setContentPane(pnl);

		DefaultPieDataset pieDataset = new DefaultPieDataset();
		PlatDao dao = new PlatDao();
		List<Plat> plats = new ArrayList<Plat>();

		
		NoteDao noteDao = new NoteDao();
		plats = dao.DisplayAllStocks();
		
		Collections.sort(plats, new ComparateurPlat())	;
		
		int i=0;
		
		for (Plat plat : plats)
			{
			i++;
			if(i<6)
		{System.out.println(plat.getLabel());
				pieDataset.setValue(plat.getLabel(),
					noteDao.calculMoy(plat.getId()));
		}	}
		JFreeChart pieChart = ChartFactory.createPieChart3D("TOP 5 PLATS",
				pieDataset, true, true, true);
		PiePlot piePlot = (PiePlot) pieChart.getPlot();
		piePlot.setExplodePercent(1, 0.5);
		Legend legend = pieChart.getLegend();
		legend.setAnchor(Legend.EAST_NORTHEAST);
		ChartPanel cPanel = new ChartPanel(pieChart);

		File fichier = new File("image.png");
		try {
			ChartUtilities.saveChartAsPNG(fichier, pieChart, 400, 250);
		} catch (IOException e) {
			e.printStackTrace();
		}
		pnl.add(cPanel);
	}

	  public static void main(String args[]) { 
			 
		    Stat tpc = new Stat(); 
		    tpc.setVisible(true); 
		  } 

}
