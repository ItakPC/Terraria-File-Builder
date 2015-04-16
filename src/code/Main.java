package code;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.jgoodies.forms.factories.DefaultComponentFactory;

public class Main extends JFrame {
	
	public JPanel contentPane;
	public JTextField displayName;
	public JTextField tooltip;
	public JTextField maxStack;
	public JTextField fileName;
	public JTextField sizeX;
	public JTextField sizeY;
	public JTextField rare;
	public JTextField valueGold;
	public JTextField valueSilver;
	public JTextField valueCopper;
	public JTextField valuePlatinum;
	
	public static String filePath, jsonFilePath;	
	public static String name, toolTip, stack, rarity;
	public static String platinum, gold, silver, copper;
	public static String textureSizeX, textureSizeY;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public Main() {
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
		
		JLabel displayNameLabel = DefaultComponentFactory.getInstance().createLabel("");
		displayNameLabel.setBounds(93, 46, 60, 14);
		contentPane.add(displayNameLabel);
		
		displayName = new JTextField();
		displayName.setToolTipText("");
		displayName.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		displayName.setHorizontalAlignment(SwingConstants.LEFT);
		displayName.setForeground(Color.BLACK);
		displayName.setBounds(151, 64, 161, 30);
		contentPane.add(displayName);
		displayName.setColumns(10);
		
		sizeX = new JTextField();
		sizeX.setForeground(Color.BLACK);
		sizeX.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		sizeX.setHorizontalAlignment(SwingConstants.LEFT);
		sizeX.setBounds(151, 146, 55, 30);
		sizeX.setColumns(10);
		contentPane.add(sizeX);
		
		sizeY = new JTextField();
		sizeY.setForeground(Color.BLACK);
		sizeY.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		sizeY.setHorizontalAlignment(SwingConstants.LEFT);
		sizeY.setColumns(10);
		sizeY.setBounds(151, 187, 55, 30);
		contentPane.add(sizeY);
		
		JButton generateButton = new JButton("Generate Code!");
		generateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				filePath = fileName.getText();
				name = displayName.getText();
				textureSizeX = sizeX.getText();
				textureSizeY = sizeY.getText();
				toolTip = tooltip.getText();
				stack = maxStack.getText();
				platinum = valuePlatinum.getText();
				gold = valueGold.getText();
				silver = valueSilver.getText();
				copper = valueCopper.getText();
				rarity = rare.getText();
				
				System.out.println("File name: " + filePath);
				System.out.println("Display Name: " + name);
				System.out.println("Texture Size: [" + textureSizeX + ", " + textureSizeY + "]");

				random();
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
		
		tooltip = new JTextField();
		tooltip.setForeground(Color.BLACK);
		tooltip.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		tooltip.setHorizontalAlignment(SwingConstants.LEFT);
		tooltip.setToolTipText("");
		tooltip.setBounds(151, 105, 161, 30);
		contentPane.add(tooltip);
		tooltip.setColumns(10);
		
		JLabel lblDisplayName = DefaultComponentFactory.getInstance().createLabel("Display Name");
		lblDisplayName.setBounds(43, 71, 92, 14);
		contentPane.add(lblDisplayName);
		
		JLabel lblToolTip = DefaultComponentFactory.getInstance().createLabel("Tool Tip");
		lblToolTip.setBounds(43, 113, 92, 14);
		contentPane.add(lblToolTip);
		
		JLabel lblSizex = DefaultComponentFactory.getInstance().createLabel("Size [x]");
		lblSizex.setBounds(43, 154, 92, 14);
		contentPane.add(lblSizex);
		
		JLabel lblSizey = DefaultComponentFactory.getInstance().createLabel("Size [y]");
		lblSizey.setBounds(43, 195, 92, 14);
		contentPane.add(lblSizey);
		
		maxStack = new JTextField();
		maxStack.setBounds(151, 228, 161, 30);
		contentPane.add(maxStack);
		maxStack.setColumns(10);
		
		JLabel lblMaxStack = DefaultComponentFactory.getInstance().createLabel("Max Stack");
		lblMaxStack.setBounds(43, 236, 92, 14);
		contentPane.add(lblMaxStack);
		
		valuePlatinum = new JTextField();
		valuePlatinum.setColumns(10);
		valuePlatinum.setBounds(151, 269, 30, 30);
		contentPane.add(valuePlatinum);
		
		rare = new JTextField();
		rare.setColumns(10);
		rare.setBounds(151, 310, 161, 30);
		contentPane.add(rare);
		
		JLabel lblValue = DefaultComponentFactory.getInstance().createLabel("Value");
		lblValue.setBounds(43, 277, 92, 14);
		contentPane.add(lblValue);
		
		JLabel lblRarity = DefaultComponentFactory.getInstance().createLabel("Rarity");
		lblRarity.setBounds(43, 318, 92, 14);
		contentPane.add(lblRarity);
		
		valueGold = new JTextField();
		valueGold.setColumns(10);
		valueGold.setBounds(191, 269, 30, 30);
		contentPane.add(valueGold);
		
		valueSilver = new JTextField();
		valueSilver.setColumns(10);
		valueSilver.setBounds(231, 269, 30, 30);
		contentPane.add(valueSilver);
		
		valueCopper = new JTextField();
		valueCopper.setColumns(10);
		valueCopper.setBounds(271, 269, 30, 30);
		contentPane.add(valueCopper);
		
	}
	
	public void random() {
		final String jsonFilePath = "./src/out/" + filePath + ".json";
		String values = platinum + ", " + gold + ", " +  silver + ", " +  copper;
		
		Gson gson = new Gson();
		JsonObject jsonObject = new JsonObject();
		JsonObject jsonObject1 = new JsonObject();
		JsonArray jsonArray = new JsonArray();

		
		String[] string1 = {platinum, gold, silver, copper};
		String valueArray = gson.toJson(string1); 
		
		String[] string2 = {textureSizeX, textureSizeY};
		String sizeArray = gson.toJson(string2); 

		
		jsonObject.addProperty("displayName", name);
		jsonObject.addProperty("maxStack", stack);
		jsonObject.addProperty("value", valueArray);
		jsonObject.addProperty("rare", rarity);
		jsonObject.addProperty("tooltip", toolTip);
		
		try{
			
			FileWriter jsonFileWriter = new FileWriter(jsonFilePath);
			jsonFileWriter.write(jsonObject.toString());
			jsonFileWriter.flush();
			jsonFileWriter.close();
			System.out.println(jsonObject);
			
		}catch(IOException e){
			e.printStackTrace();
		}
		
	}
}
