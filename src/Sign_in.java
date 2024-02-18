import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
/*
 * This frame is for sign in to the user profile
 * It is checking username and password input with the MainPage.userlist.
 * If there is not valid data, sign_in_false frame is being called
 */
public class Sign_in {
	Sign_in()  {
		System.out.println("signinnn");
		JFrame frame = new JFrame();
		
		frame.getContentPane().setBackground(Color.CYAN);
		
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Matebok\r\n");
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setFont(new Font("Tw Cen MT Condensed", Font.ITALIC, 35));
		lblNewLabel.setBounds(356, 127, 207, 102);
		frame.getContentPane().add(lblNewLabel);	
		
		JLabel lblNewLabel_1 = new JLabel("Username:");
		lblNewLabel_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_1.setBounds(250, 230, 83, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(343, 230, 151, 14);
		frame.getContentPane().add(textArea);
		
		JLabel lblNewLabel_2 = new JLabel("Password\r\n:");
		lblNewLabel_2.setForeground(new Color(0, 0, 0));
		lblNewLabel_2.setBounds(250, 255, 83, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setBounds(343, 255, 151, 14);
		frame.getContentPane().add(textArea_1);
		
		
		JButton btnNewButton = new JButton("Sign in\r\n");
		btnNewButton.setFont(new Font("Tw Cen MT Condensed", Font.ITALIC, 15));
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setBounds(356, 300, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel_3 = new JLabel("If you dont have an account, you can create a one easily!");
		lblNewLabel_3.setBounds(266, 381, 492, 14);
		frame.getContentPane().add(lblNewLabel_3);
		
		JButton btnNewButton_1 = new JButton("Sign Up");
		btnNewButton_1.setBounds(362, 406, 83, 14);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Signup();
				frame.setVisible(false);
				
				
				
					
	
				
			}
		});
		frame.getContentPane().add(btnNewButton_1);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					for(User i:MainPage.userlist) {
	
			
						
						if(i.password.equals(textArea_1.getText())&&i.username.equals(textArea.getText())) {
							System.out.println("Enter is succesfuli");
							HomePage hp=new HomePage(i);
							frame.setVisible(false);
							return;
							
						}
						
					
					}
					frame.setVisible(false);
					Sign_in_false sf=new Sign_in_false();
					
				}
				catch(Exception event) {
					frame.setVisible(false);
					Sign_in_false sf=new Sign_in_false();
				}
				
				
				
					
	
				
			}
		});
		
		frame.setBounds(100, 100, 803, 529);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
