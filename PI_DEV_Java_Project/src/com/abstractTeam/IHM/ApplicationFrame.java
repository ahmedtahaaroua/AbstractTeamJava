package com.abstractTeam.IHM;



import java.awt.Container;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.TrayIcon.MessageType;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URI;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JToolBar;
import javax.swing.JTree;

import com.abstractTeam.IHM.GestionResLiv.PanelReservations;
import com.abstractTeam.IHM.Inscription.PanelInscriptionRestaurant;
import com.abstractTeam.IHM.Inscription.PanelStatistique;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.SwingConstants;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.data.DefaultPieDataset;


@SuppressWarnings("serial")
public class ApplicationFrame extends JFrame {

	static URI url;

	public static JPanel panelLeftTop;
	public static JPanel panelLeftBottom ;
	// public static PanelContenu panelContenu;
	public static JPanel panelContenu;
	
	public static Container content;
	public static JTree tree;
	public static Thread thread;
	private final Action action = new SwingAction();

	/**
	 * Create the application.
	 */

	public ApplicationFrame() {
		super();
		// setType(Type.POPUP);
		setFont(new Font("Dialog", Font.BOLD, 12));
		initialize();
	
	}
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ApplicationFrame window = new ApplicationFrame();
					window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	/**
	 * Initialize the contents of the frame.
	 */

	@SuppressWarnings("static-access")
	private void initialize() {
		

		content = getContentPane();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(100, 100, 1366, 731);
		this.setLocationRelativeTo(null);
		this.content.setLayout(null);
		
		this.setTitle("Resto Tunisie");

		panelLeftTop = new PanelLeftTop();
		content.add(panelLeftTop);

		panelLeftBottom =  new PanelLeftBottom();
		content.add(panelLeftBottom);
		
		JButton btnStatistique_2 = new JButton("Statistique");
		btnStatistique_2.addActionListener(new ActionListener() {
			//@azza Belkacem      
			public void actionPerformed(ActionEvent arg0) {
	
					ApplicationFrame.content.remove(ApplicationFrame.panelContenu);
					ApplicationFrame.panelContenu= new PanelStatistique();
					ApplicationFrame.content.add(ApplicationFrame.panelContenu);
					ApplicationFrame.content.validate();
					ApplicationFrame.content.repaint();
				}



				
				
				
			
			}
		);
		btnStatistique_2.setHorizontalAlignment(SwingConstants.LEFT);
		btnStatistique_2.setBounds(10, 249, 317, 33);
		panelLeftBottom.add(btnStatistique_2);

		panelContenu =   new PanelContenu();

		content.add(panelContenu);

		JButton btnNewButton_7 = new JButton("Serveurs");
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				
			}
		});
		
		

		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 1350, 24);
		this.content.add(menuBar);

		JMenu mnNewMenu = new JMenu("Connection");
		menuBar.add(mnNewMenu);

		JMenuItem mntmNewMenuItem = new JMenuItem("Inscription");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ApplicationFrame.content.remove(ApplicationFrame.panelContenu);
				ApplicationFrame.panelContenu= new PanelInscriptionRestaurant();
				ApplicationFrame.content.add(ApplicationFrame.panelContenu);
				ApplicationFrame.content.validate();
				ApplicationFrame.content.repaint();
			}
		});
		mnNewMenu.add(mntmNewMenuItem);

		JMenu mnNewMenu_1 = new JMenu("Statistiques");
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem2 = new JMenuItem("meilleurs plats");
		mntmNewMenuItem2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					ApplicationFrame.content.remove(ApplicationFrame.panelContenu);
					ApplicationFrame.panelContenu= new PanelStatistique();
					ApplicationFrame.content.add(ApplicationFrame.panelContenu);
					ApplicationFrame.content.validate();
					ApplicationFrame.content.repaint();
				}
			});
		mnNewMenu_1.add(mntmNewMenuItem2);
		
		JMenu mnNewMenu_2 = new JMenu("Outils");
		menuBar.add(mnNewMenu_2);

		JMenuItem mntmNewMenuItem_1 = new JMenuItem("A propos");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
     JOptionPane.showMessageDialog(ApplicationFrame.content,"R�alis� par ABSTRACT-TEAM","a propos",JOptionPane.INFORMATION_MESSAGE);
			}
		});
		mnNewMenu_2.add(mntmNewMenuItem_1);

		this.content.validate();
		this.content.repaint();

	}
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "SwingAction");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
}
