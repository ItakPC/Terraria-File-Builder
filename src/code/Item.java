package code;

import static java.lang.Integer.*;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Window.Type;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;

public class Item extends JFrame {

	private JPanel contentPane;
	public static String filePath, jsonFilePath;	
	public static String name, toolTip, stack, rarity;
	public static String platinum, gold, silver, copper;
	public static String textureSizeX, textureSizeY;
	private JTextField displayName;
	private JTextField sizeX;
	private JTextField sizeY;
	private JTextField tooltip;
	private JTextField fileName;
	private JTextField maxStack;
	private JTextField rare;
	private JTextField valuePlatinum;
	private JTextField valueSilver;
	private JTextField valueGold;
	private JTextField valueCopper;
	private JLabel lblName;
	private JLabel lblMaxStack;
	private JLabel lblTooltip;
	private JLabel lblRarity;
	private JLabel lblSizeX;
	private JLabel lblSizeY;
	private JLabel lblValuepgsc;
	private JLabel lblFileName;

	public Item() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(576, 269);
		setTitle("Terraria File Builder - Item");
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnGenerate = new JButton("Generate");
		btnGenerate.addActionListener(new ActionListener() {
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

				generate();
			}
		});
		btnGenerate.setBounds(385, 140, 90, 23);
		contentPane.add(btnGenerate);
		/* ---------------------------------*/
		displayName = new JTextField();
		displayName.setBounds(120, 20, 86, 20);
		contentPane.add(displayName);
		displayName.setColumns(10);

		maxStack = new JTextField();
		maxStack.setBounds(120, 50, 86, 20);
		contentPane.add(maxStack);
		maxStack.setColumns(10);
		
		tooltip = new JTextField();
		tooltip.setBounds(120, 80, 86, 20);
		contentPane.add(tooltip);
		tooltip.setColumns(10);
		
		rare = new JTextField();
		rare.setBounds(120, 110, 86, 20);
		contentPane.add(rare);
		rare.setColumns(10);
		
		sizeX = new JTextField();
		sizeX.setBounds(120, 140, 86, 20);
		contentPane.add(sizeX);
		sizeX.setColumns(10);
		
		sizeY = new JTextField();
		sizeY.setBounds(120, 170, 86, 20);
		contentPane.add(sizeY);
		sizeY.setColumns(10);
		/* ---------------------------------*/
		valuePlatinum = new JTextField();
		valuePlatinum.setBounds(330, 20, 35, 20);
		contentPane.add(valuePlatinum);
		valuePlatinum.setColumns(10);
			
		valueGold = new JTextField();
		valueGold.setColumns(10);
		valueGold.setBounds(375, 20, 35, 20);
		contentPane.add(valueGold);
		
		valueSilver = new JTextField();
		valueSilver.setColumns(10);
		valueSilver.setBounds(420, 20, 35, 20);
		contentPane.add(valueSilver);

		valueCopper = new JTextField();
		valueCopper.setColumns(10);
		valueCopper.setBounds(465, 20, 35, 20);
		contentPane.add(valueCopper);

		fileName = new JTextField();
		fileName.setBounds(355, 108, 150, 20);
		contentPane.add(fileName);
		fileName.setColumns(10);
/*--------------------------------------------------------------------------------*/
		lblName = new JLabel("Name:");
		lblName.setBounds(24, 23, 46, 14);
		contentPane.add(lblName);
		
		lblMaxStack = new JLabel("Max. Stack:");
		lblMaxStack.setBounds(24, 53, 86, 14);
		contentPane.add(lblMaxStack);
		
		lblTooltip = new JLabel("Tooltip:");
		lblTooltip.setBounds(24, 83, 46, 14);
		contentPane.add(lblTooltip);
		
		lblRarity = new JLabel("Rarity:");
		lblRarity.setBounds(24, 113, 46, 14);
		contentPane.add(lblRarity);
		
		lblSizeX = new JLabel("Size X:");
		lblSizeX.setBounds(24, 143, 46, 14);
		contentPane.add(lblSizeX);
		
		lblSizeY = new JLabel("Size Y:");
		lblSizeY.setBounds(24, 173, 46, 14);
		contentPane.add(lblSizeY);
		
		lblValuepgsc = new JLabel("Value (p-g-s-c):");
		lblValuepgsc.setBounds(235, 23, 85, 14);
		contentPane.add(lblValuepgsc);
		
		lblFileName = new JLabel("File Name:");
		lblFileName.setBounds(405, 83, 50, 14);
		contentPane.add(lblFileName);
	}
	
	@SuppressWarnings("unchecked")
	public void generate() {
		final String jsonFilePath = "./src/out/" + filePath + ".json";
		
		JSONObject obj = new JSONObject();
		JSONArray size = new JSONArray();
		JSONArray value = new JSONArray();
		
		/** Everything else that's not an array ^.^ */
		obj.put("displayName", name);
		obj.put("tooltip", toolTip);
		obj.put("maxStack", stack);
		obj.put("rare", parseInt(rarity));
		
		/** Size of item */
		size.add(parseInt(textureSizeX));
		size.add(parseInt(textureSizeY));
		obj.put("size", size);
		
		/** Value of item */
		value.add(parseInt(platinum));
		value.add(parseInt(gold));
		value.add(parseInt(silver));
		value.add(parseInt(copper));
		obj.put("value", value);
		
		try {
			FileWriter file = new FileWriter(jsonFilePath);
			file.write(obj.toString());
			file.flush();
			file.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}
}
