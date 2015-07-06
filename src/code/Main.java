package code;

import static java.lang.Integer.*;

import java.awt.EventQueue;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.jgoodies.forms.factories.DefaultComponentFactory;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

@SuppressWarnings("serial")
public class Main extends JFrame {
	
	public JPanel contentPane;
	
	private Item item;
	
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
		setTitle("Terraria File Builder - Menu");
		createWindow();
		item = new Item();
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void createWindow() {
		
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(615, 350);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel displayNameLabel = DefaultComponentFactory.getInstance().createLabel("");
		displayNameLabel.setBounds(93, 46, 60, 14);
		contentPane.add(displayNameLabel);
		
		/** Item */
		JButton btnItem = new JButton("Item");
		btnItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				item.setVisible(true);
			}
		});;

		btnItem.setBounds(30, 50, 90, 25);
		contentPane.add(btnItem);
		
		/** Tile */
		JButton btnTile = new JButton("Tile");
		btnTile.setBounds(180, 50, 90, 25);
		contentPane.add(btnTile);
		
		/** Accessory */
		JButton btnAccessory = new JButton("Accessory");
		btnAccessory.setBounds(330, 50, 90, 25);
		contentPane.add(btnAccessory);
		
		/** Armor */
		JButton btnArmor = new JButton("Armor");
		btnArmor.setBounds(480, 50, 90, 25);
		contentPane.add(btnArmor);
		
		JLabel lblApplicationWrittenAnd = new JLabel("Application written and designed by Itorius 2015.");
		lblApplicationWrittenAnd.setBounds(10, 297, 278, 14);
		contentPane.add(lblApplicationWrittenAnd);

		String[] options = {"Item", "Tile", "Armor", "Accessory", "NPC"};
		
	}	
}
