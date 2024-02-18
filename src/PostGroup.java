import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
/*
 * This frame is being showed when User searched for a post which is not group post
 */
public class PostGroup extends JFrame {
	Group g;
	User MainUser;
	Post p;
	PostGroup(Group g,User MainUser,Post p){
		JFrame frame = new JFrame();
		frame.setBounds(100, 100, 487, 493);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.CYAN);
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel ProfilePictureLabel = new JLabel("");
		ProfilePictureLabel.setBackground(Color.CYAN);
		ProfilePictureLabel.setBounds(30, 109, 194, 180);
		ProfilePictureLabel.setIcon(p.image);
		panel.add(ProfilePictureLabel);
		
		JLabel TitleLabel = new JLabel(p.title);
		TitleLabel.setBounds(30, 45, 194, 14);
		TitleLabel.setText(p.text);
		panel.add(TitleLabel);
		
		JLabel AuthorLabel = new JLabel(p.author.name);
		AuthorLabel.setBounds(30, 60, 194, 14);
		panel.add(AuthorLabel);
		
		JLabel TimeLabel = new JLabel(p.timeOfCreation);
		TimeLabel.setBounds(30, 85, 194, 14);
		TimeLabel.setText(p.timeOfCreation);
		panel.add(TimeLabel);
		
		JTextField TextText = new JTextField(p.text);
		TextText.setBounds(30, 300, 368, 109);
		TextText.setText(p.text);
		TextText.setEditable(false);
		panel.add(TextText);
		
		TextText.setColumns(10);
		
		JButton EditButton = new JButton("Edit");
		EditButton.setBounds(30, 420, 89, 23);
		panel.add(EditButton);
		EditButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//u.friends.contains(MainUser)
					new Modify(p,g);
	
					frame.setVisible(false);
					
				
			}
		});
		
		JButton RemoveButton = new JButton("Remove");
		RemoveButton.setBounds(309, 420, 89, 23);
		panel.add(RemoveButton);
		RemoveButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//u.friends.contains(MainUser)
					g.posts.remove(p);
					new GroupPage(g,MainUser,MainUser);
					frame.setVisible(false);
					
				
			}
		});
		
		JButton HomePageButton = new JButton("<--Group");
		HomePageButton.setBounds(30, 11, 124, 23);
		panel.add(HomePageButton);
		HomePageButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//u.friends.contains(MainUser)
					new GroupPage(g,MainUser,MainUser);
					frame.setVisible(false);
					
				
			}
		});
		
		frame.setVisible(true);
	}
}
