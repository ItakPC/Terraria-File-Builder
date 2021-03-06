package code;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import com.jgoodies.forms.factories.DefaultComponentFactory;

public class Window extends JFrame {
	
	public JPanel contentPane;
	public JTextField displayName;
	private JTextField tooltip;
	public static JTextField fileName;
	public JTextField sizeX;
	public JTextField sizeY;
	
	public static String filePath;
	public static String jsonFilePath;
	
	public static String name;
	public static String textureSizeX, textureSizeY;
	public static String toolTip;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Window frame = new Window();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public Window() {
		setTitle("Terraria File Builder");
		createWindow();
	}
	
	public void createWindow() {
		
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1280, 720);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel displayNameLabel = DefaultComponentFactory.getInstance().createLabel("displayName");
		displayNameLabel.setBounds(93, 46, 60, 14);
		contentPane.add(displayNameLabel);
		
		JLabel sizeYLabel = DefaultComponentFactory.getInstance().createLabel("size [y]");
		sizeYLabel.setBounds(306, 46, 40, 14);
		contentPane.add(sizeYLabel);
		
		displayName = new JTextField();
		displayName.setBounds(43, 65, 161, 29);
		contentPane.add(displayName);
		displayName.setColumns(10);
		
		sizeX = new JTextField();
		sizeX.setBounds(243, 65, 40, 29);
		sizeX.setColumns(10);
		contentPane.add(sizeX);
		
		sizeY = new JTextField();
		sizeY.setColumns(10);
		sizeY.setBounds(306, 65, 40, 29);
		contentPane.add(sizeY);
		
		JButton generateButton = new JButton("Generate Code!");
		generateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				filePath = fileName.getText();
				name = displayName.getText();
				textureSizeX = sizeX.getText();
				textureSizeY = sizeY.getText();
				toolTip = tooltip.getText();
				
				System.out.println("File name: " + filePath);
				System.out.println("Display Name: " + name);
				System.out.println("Texture Size: [" + textureSizeX + ", " + textureSizeY + "]");

			}
		});
		generateButton.setBounds(438, 635, 348, 34);
		contentPane.add(generateButton);
		
		fileName = new JTextField();
		fileName.setBounds(43, 635, 358, 34);
		contentPane.add(fileName);
		fileName.setColumns(10);
		
		JLabel lblFileName = DefaultComponentFactory.getInstance().createLabel("File name");
		lblFileName.setBounds(191, 610, 92, 14);
		contentPane.add(lblFileName);
		
		JLabel sizeXLabel = DefaultComponentFactory.getInstance().createLabel("size [x]");
		sizeXLabel.setBounds(243, 46, 40, 14);
		contentPane.add(sizeXLabel);
		
		tooltip = new JTextField();
		tooltip.setBounds(43, 135, 161, 29);
		contentPane.add(tooltip);
		tooltip.setColumns(10);
		
		JLabel lblTooltip = DefaultComponentFactory.getInstance().createLabel("tooltip");
		lblTooltip.setBounds(113, 116, 40, 14);
		contentPane.add(lblTooltip);
		
	}
}
