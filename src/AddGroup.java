import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
/*
 This is a frame for user to create a new group, if the user is premium.
 */
public class AddGroup extends JFrame {
	String name;
	String country;
	User MainUser;
	ImageIcon pp;
	ArrayList<String> hobieslist;
	AddGroup(User MainUser,ArrayList<String> hobieslist,String name,String country){
		this.MainUser=MainUser;

		JFrame frame = new JFrame();
		frame.setBounds(100, 100, 253, 507);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.CYAN);
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel NameLabel = new JLabel("Name:\r\n");
		NameLabel.setBounds(10, 11, 89, 23);
		panel.add(NameLabel);
		
		JTextPane NameText = new JTextPane();
		NameText.setBounds(10, 45, 181, 23);
		NameText.setText(name);
		panel.add(NameText);
		
		
		JLabel HobbiesLabel = new JLabel("Hobbies:");
		HobbiesLabel.setBounds(10, 136, 74, 14);
		panel.add(HobbiesLabel);
		
		JTextPane HobbiesText = new JTextPane();
		HobbiesText.setBounds(10, 161, 181, 23);
		panel.add(HobbiesText);
		
		JButton AddButton = new JButton("add");
		AddButton.setBounds(44, 195, 89, 23);
		panel.add(AddButton);
		
		JScrollPane HobbiesListScrollPane = new JScrollPane();
		HobbiesListScrollPane.setBounds(10, 254, 178, 159);
		panel.add(HobbiesListScrollPane);
		
		JPanel HobbiesListPanel = new JPanel();
		HobbiesListScrollPane.setViewportView(HobbiesListPanel);
		for(String s:hobieslist) {
			JLabel hobi=new JLabel(s);
			HobbiesListPanel.add(hobi);
		}
		
		JLabel CountryLabel = new JLabel("Country: ");
		CountryLabel.setBounds(10, 79, 74, 14);
		panel.add(CountryLabel);
		
		JTextPane CountryText = new JTextPane();
		CountryText.setBounds(10, 102, 181, 23);
		panel.add(CountryText);
		CountryText.setText(country);
		
		JButton CreateButton = new JButton("Create ");
		CreateButton.setBounds(44, 424, 89, 23);
		panel.add(CreateButton);
		CreateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				hobieslist.add(HobbiesText.getText());
				/*
				 * For hobbies of the group, the String in the HobbiesText is being used and then 
				 */
				new Group(NameText.getText(),CountryText.getText(),hobieslist,new ArrayList<Post>(),new ArrayList<User>(),MainUser);
				new GroupPage(MainPage.grouplist.get(MainPage.grouplist.size()-1),MainUser,MainUser);
				/*
				 * Group is being called by MainPage.grouplist.get(MainPage.grouplist.size()-1)
				 */
				frame.setVisible(false);
			}
		});
		JLabel HobbiesListLabel = new JLabel("Hobbies List:");
		HobbiesListLabel.setBounds(10, 229, 123, 14);
		panel.add(HobbiesListLabel);
		
		AddButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				hobieslist.add(HobbiesText.getText());
				new AddGroup(MainUser,hobieslist,NameText.getText(),CountryText.getText());
				frame.setVisible(false);
			}
		});
		
		frame.setVisible(true);
	}
}
