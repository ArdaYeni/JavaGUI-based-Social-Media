import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class NonFriendPage {
	User u;
	User Mainuser;
	NonFriendPage(User u,User Mainuser) {
		
		JFrame frame = new JFrame();
		frame.setBounds(100, 100, 510, 343);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.CYAN);
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JButton returnHomePageButton = new JButton("<--Return Home Page\r\n");
		returnHomePageButton.setBounds(10, 11, 155, 23);
		panel.add(returnHomePageButton);
		returnHomePageButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new HomePage(Mainuser);
				frame.setVisible(false);
			}
		});
		
		JLabel ProilePictureLabel = new JLabel();
		ProilePictureLabel.setBounds(20, 45, 173, 157);
		ProilePictureLabel.setIcon(u.profilePicture);
		panel.add(ProilePictureLabel);
		
		JLabel UsernameLabel = new JLabel("Username: ");
		UsernameLabel.setBounds(219, 45, 78, 14);
		panel.add(UsernameLabel);
		
		JLabel lblNewLabel = new JLabel(u.username);
		lblNewLabel.setBounds(307, 45, 133, 14);
		panel.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Add Friend\r\n");
		btnNewButton.setBackground(new Color(0, 191, 255));
		btnNewButton.setBounds(307, 70, 133, 33);
		panel.add(btnNewButton);
		
		JLabel succ = new JLabel("You succesfully added!");
		succ.setForeground(new Color(0, 128, 0));
		succ.setBackground(Color.CYAN);
		succ.setBounds(147, 213, 167, 33);
		
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.add(succ);
				Mainuser.addFriend(u);
				new FriendPage(u,Mainuser);
				frame.setVisible(false);
			}
		});
		
		frame.setVisible(true);
	}
}
