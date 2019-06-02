package userinterface;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;
import javax.swing.UIManager;
import javax.swing.JFileChooser;

public class ApplicationInterface {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (Throwable e) {
			e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ApplicationInterface window = new ApplicationInterface();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ApplicationInterface() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 262, 182);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setBorder(new EmptyBorder(10, 10, 10, 10));
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JButton btnRecord = new JButton("Record (F3)");
		GridBagConstraints gbc_btnRecord = new GridBagConstraints();
		gbc_btnRecord.insets = new Insets(0, 0, 0, 5);
		gbc_btnRecord.gridx = 0;
		gbc_btnRecord.gridy = 3;
		panel.add(btnRecord, gbc_btnRecord);
		
		JButton btnStopRecording = new JButton("Stop Recording (F4)");
		GridBagConstraints gbc_btnStopRecording = new GridBagConstraints();
		gbc_btnStopRecording.gridx = 1;
		gbc_btnStopRecording.gridy = 3;
		panel.add(btnStopRecording, gbc_btnStopRecording);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("File");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmOpen = new JMenuItem("Open");
		mnNewMenu.add(mntmOpen);
		
		JMenuItem mntmRecord = new JMenuItem("Record");
		mntmRecord.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F3, 0));
		mnNewMenu.add(mntmRecord);
		
		JMenuItem mntmStopRecording = new JMenuItem("Stop Recording");
		mntmStopRecording.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F4, 0));
		mnNewMenu.add(mntmStopRecording);
	}

}
