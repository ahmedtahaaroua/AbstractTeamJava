package com.abstractTeam.IHM.Inscription;

import java.awt.BorderLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.Legend;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.DefaultPieDataset;

public class Stat extends JFrame { 
  private JPanel pnl; 

  public Stat() { 
    addWindowListener(new WindowAdapter() { 
      public void windowClosing(WindowEvent e) { 
        dispose(); 
        System.exit(0); 
      } 
    }); 
    pnl = new JPanel(new BorderLayout()); 
    setContentPane(pnl); 
    setSize(400, 250); 

    DefaultPieDataset pieDataset = new DefaultPieDataset(); 
    pieDataset.setValue("PLAT TOP1", new Integer(27)); 
    pieDataset.setValue("PLAT TOP2", new Integer(10)); 
    pieDataset.setValue("PLAT TOP3", new Integer(50)); 
    pieDataset.setValue("PLAT TOP4", new Integer(5)); 
    pieDataset.setValue("PLAT TOP5", new Integer(2)); 

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