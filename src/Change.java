
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
/* 
 * This is the frame where user can change their informations
 */
public class Change extends JFrame{
 User theUser;
 	Change(User theUser){
 		this.theUser=theUser;
 		JFrame frame = new JFrame();
		frame.setBackground(Color.CYAN);
		frame.setBounds(100, 100, 507, 665);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.CYAN);
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel UsernameLabel = new JLabel("Username:");
		UsernameLabel.setBounds(26, 147, 66, 14);
		panel.add(UsernameLabel);
		
		JTextPane UsernameTextPane = new JTextPane();
		UsernameTextPane.setBounds(26, 172, 156, 28);
		UsernameTextPane.setText(theUser.username);
		UsernameTextPane.setEditable(false);
		panel.add(UsernameTextPane);
		
		JLabel PasswordLabel = new JLabel("Password:");
		PasswordLabel.setBounds(26, 211, 72, 14);
		
		panel.add(PasswordLabel);
		
		JTextPane PasswordTextPane = new JTextPane();
		PasswordTextPane.setBounds(26, 236, 156, 28);
		panel.add(PasswordTextPane);
		PasswordTextPane.setText(theUser.password);
		
		JLabel EmailLabel = new JLabel("Email:");
		EmailLabel.setBounds(26, 275, 66, 14);
		panel.add(EmailLabel);
		
		JTextPane EmailTextPane = new JTextPane();
		EmailTextPane.setBounds(26, 300, 156, 25);
		panel.add(EmailTextPane);
		EmailTextPane.setText(theUser.email);
		
		JLabel CountryLabel = new JLabel("Country:");
		CountryLabel.setBounds(26, 336, 46, 14);
		panel.add(CountryLabel);
		
		JTextPane CountryTextPane = new JTextPane();
		CountryTextPane.setBounds(26, 361, 156, 31);
		panel.add(CountryTextPane);
		CountryTextPane.setText(theUser.country);
		
		JLabel AgeLabel = new JLabel("Age:");
		AgeLabel.setBounds(26, 403, 46, 14);
		panel.add(AgeLabel);
		
		JTextPane AgeTextPane = new JTextPane();
		AgeTextPane.setBounds(26, 428, 156, 31);
		panel.add(AgeTextPane);
		AgeTextPane.setText(theUser.age);
		
		JLabel NameLabel = new JLabel("Name:");
		NameLabel.setBounds(26, 470, 46, 14);
		panel.add(NameLabel);
		
		
		JTextPane NameTextPane = new JTextPane();
		NameTextPane.setBounds(26, 495, 156, 28);
		panel.add(NameTextPane);
		NameTextPane.setText(theUser.name);
		
		JLabel SurnameLabel = new JLabel("Surname:");
		SurnameLabel.setBounds(26, 534, 66, 14);
		panel.add(SurnameLabel);
		
		JLabel ProfilePictureLabel = new JLabel("New label");
		ProfilePictureLabel.setBounds(26, 11, 131, 115);
		ProfilePictureLabel.setIcon(theUser.profilePicture);
		panel.add(ProfilePictureLabel);
		
		JButton ChangeButton = new JButton("Change");
		ChangeButton.setBounds(167, 57, 78, 23);
		panel.add(ChangeButton);
		ChangeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JFileChooser fc=new JFileChooser();
				int response=fc.showOpenDialog(null);
				if(response==JFileChooser.APPROVE_OPTION) {
					theUser.profilePicture=new ImageIcon(fc.getSelectedFile().getAbsolutePath());
					new Change(theUser);
					frame.setVisible(false);
					
					
					/*
					 * I used JFileChooser to choose file and get the absoulute path. With the absoulte path, image is being created
					 */
					
					
				}
			}
		});
		
		JLabel HobbiesLabel = new JLabel("Hobbies:");
		HobbiesLabel.setBounds(250, 131, 89, 14);
		panel.add(HobbiesLabel);
		
		JLabel AddHobbiesLabel = new JLabel("Add Hobbies:");
		AddHobbiesLabel.setBounds(250, 470, 89, 14);
		panel.add(AddHobbiesLabel);
		
		JTextPane AddHobbiesTextPane = new JTextPane();
		AddHobbiesTextPane.setBounds(250, 492, 203, 31);
		panel.add(AddHobbiesTextPane);
		
		
		
		JButton UpdateButton = new JButton("Update");
		UpdateButton.setBounds(193, 592, 89, 23);
		panel.add(UpdateButton);
		
		JButton YourProfileButton = new JButton("<--My Profile");
		YourProfileButton.setBounds(306, 11, 111, 23);
		panel.add(YourProfileButton);
		
		
		
		JButton AddButton = new JButton("Add");
		AddButton.setBounds(297, 530, 89, 23);
		panel.add(AddButton);
		AddButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				theUser.hobbies.add(AddHobbiesTextPane.getText());
				new Change(theUser);
				frame.setVisible(false);
				
			}
		});
		
		JScrollPane HobbiesScrollPlane = new JScrollPane();
		HobbiesScrollPlane.setBounds(246, 171, 203, 272);
		panel.add(HobbiesScrollPlane);
		
		JPanel HobbiesPlane = new JPanel();
		HobbiesScrollPlane.setViewportView(HobbiesPlane);
		HobbiesPlane.setLayout(new BoxLayout(HobbiesPlane, BoxLayout.Y_AXIS));
		
		for(String hobi:theUser.hobbies) {
			JButton remove=new JButton("Remove");
			remove.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					theUser.hobbies.remove(hobi);
					new Change(theUser);
					frame.setVisible(false);
				}
			});
			
			Component small = Box.createVerticalStrut(30);
			JLabel hobiL= new JLabel(hobi);
			 HobbiesPlane.add(hobiL);
			 HobbiesPlane.add(remove);
			 HobbiesPlane.add(small);
			
		}
		
		JTextPane SurnameTextPane = new JTextPane();
		SurnameTextPane.setBounds(26, 559, 156, 28);
		panel.add(SurnameTextPane);
		SurnameTextPane.setText(theUser.surname);
		
		UpdateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index=MainPage.userlist.indexOf(theUser);
				
				MainPage.userlist.get(index).age=AgeTextPane.getText();
				MainPage.userlist.get(index).name=NameTextPane.getText();
				MainPage.userlist.get(index).surname=SurnameTextPane.getText();
				MainPage.userlist.get(index).country=CountryTextPane.getText();
				MainPage.userlist.get(index).email=EmailTextPane.getText();
				MainPage.userlist.get(index).password=PasswordTextPane.getText();	
				new Change(theUser);
				frame.setVisible(false);
				
			}
		});
		
		YourProfileButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index=MainPage.userlist.indexOf(theUser);
				MainPage.userlist.get(index).age=AgeTextPane.getText();
				MainPage.userlist.get(index).name=NameTextPane.getText();
				MainPage.userlist.get(index).surname=SurnameTextPane.getText();
				MainPage.userlist.get(index).country=CountryTextPane.getText();
				MainPage.userlist.get(index).email=EmailTextPane.getText();
				MainPage.userlist.get(index).password=PasswordTextPane.getText();	
				new MyProfile(MainPage.userlist.get(index));
				frame.setVisible(false);
				
			}
		});
		/*
		 * User turns to its profile by this button
		 */
		frame.setVisible(true);
 	}
}
