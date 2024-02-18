import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
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
 * This is the frame if the Main User is the not member of the group
 * User can delete by DeleteButton, 
 * User leave the Group group by  LeaveButton
 * User can look for other members by JButton cr =new JButton("Click for Profile");
 * User can search posts by  SearchNewButton
 * User can create a posts by  PostButton
 */
public class GroupPageNonFollower extends JFrame {
	Group group;
	User u;
	String postTitle;
	String postText;
	ImageIcon postImage;
	GroupPageNonFollower(Group group,User MainUser,User u){
		JFrame frame = new JFrame();
		frame.setBounds(100, 100, 452, 401);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.CYAN);
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel nameLabel = new JLabel(group.name);
		nameLabel.setFont(new Font("Tahoma", Font.PLAIN, 34));
		nameLabel.setBounds(10, 45, 217, 131);
		panel.add(nameLabel);
		
		JButton HomeButton = new JButton("<--Home Page");
		HomeButton.setBounds(10, 11, 138, 23);
		panel.add(HomeButton);
		HomeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				new HomePage(MainUser);
				frame.setVisible(false);
			}
		});
		
		JLabel CountryLabel = new JLabel(group.country);
		CountryLabel.setBounds(10, 202, 191, 14);
		panel.add(CountryLabel);
		
		JLabel NumberMemberLabel = new JLabel("Number of Members: "+group.members.size());
		NumberMemberLabel.setBounds(438, 15, 224, 14);
		panel.add(NumberMemberLabel);
		
		JScrollPane HobbiesScrollPane = new JScrollPane();
		HobbiesScrollPane.setBounds(237, 72, 134, 249);
		panel.add(HobbiesScrollPane);
		
		JPanel HobbiesPanel = new JPanel();
		HobbiesScrollPane.setViewportView(HobbiesPanel);
		HobbiesPanel.setLayout(new BoxLayout(HobbiesPanel, BoxLayout.Y_AXIS));
		JLabel HobbiesLabel = new JLabel("Hobbies: ");
		HobbiesLabel.setBounds(237, 47, 62, 14);
		panel.add(HobbiesLabel);
		
		JButton JoinButton = new JButton("Join");
		JoinButton.setBounds(59, 298, 89, 23);
		panel.add(JoinButton);
		JoinButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				group.members.add(MainUser);
				new GroupPage(group,MainUser,u);
				frame.setVisible(false);
			}
		});
		
		for(String hobies:group.hobbies) {
			Component small = Box.createVerticalStrut(30);
			JLabel hobi= new JLabel(hobies);
			HobbiesPanel.add(hobi);
			HobbiesPanel.add(small);
			
		}
		
		frame.setVisible(true);
	}
}
