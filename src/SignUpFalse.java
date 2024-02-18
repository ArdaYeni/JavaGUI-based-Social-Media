import java.awt.BorderLayout;
import java.awt.Checkbox;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextPane;
/*
 * This class is similiar with Signup class
 * The different is in this class there is red label which indicates user name is being used
 */
public class SignUpFalse extends JFrame{
	ImageIcon pp;
	SignUpFalse(){
		JFrame frame = new JFrame();
		frame.setBackground(Color.CYAN);
		frame.setBounds(100, 100, 313, 725);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.CYAN);
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel UsernameLabel = new JLabel("Username:");
		UsernameLabel.setBounds(26, 147, 66, 14);
		panel.add(UsernameLabel);
		
		JTextPane UsernameTextPane = new JTextPane();
		UsernameTextPane.setBounds(26, 172, 240, 28);
		panel.add(UsernameTextPane);
		
		JLabel PasswordLabel = new JLabel("Password:");
		PasswordLabel.setBounds(26, 211, 72, 14);
		panel.add(PasswordLabel);
		
		JTextPane PasswordTextPane = new JTextPane();
		PasswordTextPane.setBounds(26, 236, 240, 28);
		panel.add(PasswordTextPane);
		
		JLabel EmailLabel = new JLabel("Email:");
		EmailLabel.setBounds(26, 275, 66, 14);
		panel.add(EmailLabel);
		
		JTextPane EmailTextPane = new JTextPane();
		EmailTextPane.setBounds(26, 300, 240, 25);
		panel.add(EmailTextPane);
		
		JLabel CountryLabel = new JLabel("Country:");
		CountryLabel.setBounds(26, 336, 46, 14);
		panel.add(CountryLabel);
		
		JTextPane CountryTextPane = new JTextPane();
		CountryTextPane.setBounds(26, 361, 240, 31);
		panel.add(CountryTextPane);
		
		JLabel AgeLabel = new JLabel("Age:");
		AgeLabel.setBounds(26, 403, 46, 14);
		panel.add(AgeLabel);
		
		JLabel lblNewLabel = new JLabel("This username is being used by someone!");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setBounds(26, 91, 240, 31);
		panel.add(lblNewLabel);
		
		JTextPane AgeTextPane = new JTextPane();
		AgeTextPane.setBounds(26, 428, 240, 31);
		panel.add(AgeTextPane);
		
		JLabel NameLabel = new JLabel("Name:");
		NameLabel.setBounds(26, 470, 46, 14);
		panel.add(NameLabel);
		
		JTextPane NameTextPane = new JTextPane();
		NameTextPane.setBounds(26, 495, 240, 28);
		panel.add(NameTextPane);
		
		JLabel SurnameLabel = new JLabel("Surname:");
		SurnameLabel.setBounds(26, 534, 66, 14);
		panel.add(SurnameLabel);
		
		JLabel ProfilePictureLabel = new JLabel("New label");
		ProfilePictureLabel.setBounds(26, 11, 131, 115);
		panel.add(ProfilePictureLabel);
		
		JButton SignUpButton = new JButton("Sign Up");
		SignUpButton.setBounds(98, 650, 89, 23);
		panel.add(SignUpButton);
		
		
		JTextPane SurnameTextPane = new JTextPane();
		SurnameTextPane.setBounds(26, 559, 240, 28);
		panel.add(SurnameTextPane);
		
		JButton ChooseButton = new JButton("Choose");
		ChooseButton.setBounds(167, 57, 89, 23);
		panel.add(ChooseButton);
		ChooseButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser fc=new JFileChooser();
				int response=fc.showOpenDialog(null);
				if(response==JFileChooser.APPROVE_OPTION) {
					pp=new ImageIcon(fc.getSelectedFile().getAbsolutePath());
					
					//File file=new File(fc.getSelectedFile().getAbsolutePath());
					
					
				}
				
			}
		});
		Checkbox PremiumCheckbox = new Checkbox("Premium");
		PremiumCheckbox.setBounds(26, 622, 95, 22);
		panel.add(PremiumCheckbox);
		
		JLabel ProfileStatusLabel = new JLabel("Profile Status:");
		ProfileStatusLabel.setBounds(26, 602, 95, 14);
		panel.add(ProfileStatusLabel);
		
		SignUpButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
					
					for(User u:MainPage.userlist) {
						System.out.println(u.username+" "+UsernameTextPane.getText() );
						
						if(u.username.equals(UsernameTextPane.getText())) {
						
							new SignUpFalse();
							frame.setVisible(false);
							return;
						}
					}
					new HomePage(new User(UsernameTextPane.getText(),PasswordTextPane.getText(), NameTextPane.getText(),SurnameTextPane.getText(),AgeTextPane.getText(),EmailTextPane.getText(),pp,CountryTextPane.getText(),PremiumCheckbox.getState()));
					frame.setVisible(false);
				
				
				}
				
		});
		frame.setVisible(true);
	}
}
