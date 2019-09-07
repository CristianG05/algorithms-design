
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class Main extends JFrame implements ActionListener {
	// Definition of global values and items that are part of the GUI.

	static public File opened_file, other_file;
	static long past, future;
	static JLabel redLabel, blueLabel, redScore, blueScore;
	static JPanel buttonPanel, titlePanel, scorePanel;
	static JButton ZL, UL, EX;

	public JPanel createContentPane() {
		// Creamos un JPanel inferior para colocar todo en cajas para organizar GUI.
		JPanel totalGUI = new JPanel();
		totalGUI.setLayout(null);

		titlePanel = new JPanel();
		titlePanel.setLayout(null);
		titlePanel.setLocation(90, 20);
		titlePanel.setSize(170, 70);
		totalGUI.add(titlePanel);

		redLabel = new JLabel("Seleccionar Archivo: ");
		redLabel.setLocation(0, 0);
		redLabel.setSize(150, 30);
		redLabel.setHorizontalAlignment(0);
		titlePanel.add(redLabel);

		blueLabel = new JLabel("tamaño del archivo Unzip/zip: ");
		blueLabel.setLocation(0, 30);
		blueLabel.setSize(170, 30);
		blueLabel.setHorizontalAlignment(0);
		titlePanel.add(blueLabel);

		scorePanel = new JPanel();
		scorePanel.setLayout(null);
		scorePanel.setLocation(270, 20);
		scorePanel.setSize(120, 60);
		totalGUI.add(scorePanel);

		redScore = new JLabel("");
		redScore.setLocation(0, 0);
		redScore.setSize(100, 30);
		redScore.setHorizontalAlignment(0);
		scorePanel.add(redScore);

		blueScore = new JLabel("");
		blueScore.setLocation(0, 30);
		blueScore.setSize(100, 30);
		blueScore.setHorizontalAlignment(0);
		scorePanel.add(blueScore);

		buttonPanel = new JPanel();
		buttonPanel.setLayout(null);
		buttonPanel.setLocation(10, 130);
		buttonPanel.setSize(5200, 150);
		totalGUI.add(buttonPanel);
                
		ZL = new JButton("Comprimir");
		ZL.setLocation(120, 0);
		ZL.setSize(120, 30);
		ZL.addActionListener(this);
		buttonPanel.add(ZL);

		UL = new JButton("Descomprimir");
		UL.setLocation(260, 0);
		UL.setSize(120, 30);
		UL.addActionListener(this);
		buttonPanel.add(UL);

		EX = new JButton("Salir");
		EX.setLocation(130, 70);
		EX.setSize(250, 30);
		EX.addActionListener(this);
		buttonPanel.add(EX);

		totalGUI.setOpaque(true);
		return totalGUI;
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == ZL) {
			Compresion.beginLzipping(opened_file.getPath());
			JOptionPane.showMessageDialog(null, "..........................Compresion de Archivo Terminada..........................",
					"Status", JOptionPane.PLAIN_MESSAGE);
			redScore.setText(opened_file.length() + "Bytes");
			other_file = new File(opened_file.getPath() + ".algoritmo");
			future = other_file.length();
			blueScore.setText(future + "Bytes");
		} else if (e.getSource() == UL) {
			DesCompresion.beginLunzipping(opened_file.getPath());
			JOptionPane.showMessageDialog(null,
					"..........................Descompresion de Archivo Terminada..........................", "Status",
					JOptionPane.PLAIN_MESSAGE);
			redScore.setText(opened_file.length() + "Bytes");
			String s = opened_file.getPath();
			s = s.substring(0, s.length() - 6);
			other_file = new File(s);
			future = other_file.length();
			blueScore.setText(future + "Bytes");
		} else if (e.getSource() == EX) {
			System.exit(0);
		}
	}

	private static void createAndShowGUI() {

		// JFrame.setDefaultLookAndFeelDecorated(true);
		JFrame frame = new JFrame("Compresor de archivos");

		// Create and set up the content pane.
		Main demo = new Main();
		frame.setContentPane(demo.createContentPane());

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(350, 170, 550, 300);

		frame.setVisible(true);

		JMenu fileMenu = new JMenu("Archivo");

		JMenuBar bar = new JMenuBar();
		frame.setJMenuBar(bar);
		bar.add(fileMenu);

		JMenuItem openItem = new JMenuItem("Abrir");
		fileMenu.add(openItem);
		openItem.addActionListener(

				new ActionListener() {

					public void actionPerformed(ActionEvent event) {
						JFileChooser fileChooser = new JFileChooser();
						fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
						int result = fileChooser.showOpenDialog(null);
						opened_file = fileChooser.getSelectedFile();
						past = opened_file.length();
						redScore.setText(past + "Bytes");
						blueScore.setText("Aún no calculado");
					}
				});

		JMenuItem exitItem = new JMenuItem("Salir");
		fileMenu.add(exitItem);
		exitItem.addActionListener(

				new ActionListener() {

					public void actionPerformed(ActionEvent event) {
						System.exit(0);
					}
				});

		JMenu helpMenu = new JMenu("Ayuda");
		frame.setJMenuBar(bar);
		bar.add(helpMenu);

		JMenuItem helpItem = new JMenuItem("Como Funciona");
		helpMenu.add(helpItem);
		helpItem.addActionListener(

				new ActionListener() {

					public void actionPerformed(ActionEvent event) {
						JOptionPane.showMessageDialog(null,
								"selecona arhivo y abrir luego el boton que descomprimir o comprimir",
								"Como Funciona", JOptionPane.PLAIN_MESSAGE);
					}
				});

		JMenuItem aboutItem = new JMenuItem("Acerca del Programa");
		helpMenu.add(aboutItem);

		aboutItem.addActionListener(

				new ActionListener() {
					public void actionPerformed(ActionEvent event) {
						JOptionPane.showMessageDialog(null,
								"Desarrollado Por: Michael Daniel Murillo López",
								"Acerca del Programa", JOptionPane.PLAIN_MESSAGE);
					}
				});

	}

	public static void main(String[] args) {
		// Schedule a job for the event-dispatching thread:
		// creating and showing this application's GUI.
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				createAndShowGUI();
			}
		});
	}
}
