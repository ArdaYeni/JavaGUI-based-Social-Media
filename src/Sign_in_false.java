import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
/*
 * when user entered false password/username, this frame is being showed
 * This frame is similar with sign_in, only diffrence is in this frame there is a red label which indicates user entered wrong data
 */
public class Sign_in_false {
Sign_in_false(){
		
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
	JLabel lblNewLabel_3 = new JLabel("Your username of password is false!");
	lblNewLabel_3.setForeground(Color.RED);
	lblNewLabel_3.setBounds(330, 335, 492, 33);
	frame.getContentPane().add(lblNewLabel_3);
	
	frame.setBounds(100, 100, 803, 529);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	
}
