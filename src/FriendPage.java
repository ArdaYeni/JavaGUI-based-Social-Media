import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;

public class FriendPage {
	/*
	 * This the frame where Main User can see its friend
	 * User theUser is mainUser's friend ,User mainUser is Main User
	 */
	User theUser;
	User mainUser;
	FriendPage(User theUser,User mainUser){
		this.theUser=theUser;
		JFrame frame = new JFrame();
		frame.setBounds(100, 100, 805, 564);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		
		
		JPanel panel_1 = new JPanel();
		frame.add(panel_1);
		panel_1.setBackground(Color.CYAN);
		
		panel_1.setLayout(null);
		
		JLabel ProfilePictureLabel = new JLabel("");
		ProfilePictureLabel.setBounds(8, 84, 147, 140);
		panel_1.add(ProfilePictureLabel);
		ProfilePictureLabel.setIcon(theUser.profilePicture);
		
		JLabel UsernameLabel = new JLabel("Username: "+theUser.username);
		UsernameLabel.setBounds(214, 11, 238, 23);
		panel_1.add(UsernameLabel);
		
		
		JLabel Name_Label = new JLabel("Name: "+theUser.name);
		Name_Label.setBounds(214, 48, 200, 29);
		panel_1.add(Name_Label);
		
		JLabel AgeLabel = new JLabel("Age: "+theUser.age);
		AgeLabel.setBounds(462, 48, 181, 23);
		panel_1.add(AgeLabel);
		
		JLabel SurnameLabel = new JLabel("Surname: "+theUser.surname);
		SurnameLabel.setBounds(462, 11, 181, 29);
		panel_1.add(SurnameLabel);
		
		
		
		
		
	
		
		JScrollPane YourPostsScrollPane = new JScrollPane();
		YourPostsScrollPane.setBounds(165, 193, 592, 297);
		panel_1.add(YourPostsScrollPane);
		
		JPanel YourPostsPane = new JPanel();
		YourPostsScrollPane.setViewportView(YourPostsPane);
		YourPostsPane.setLayout(new BoxLayout(YourPostsPane, BoxLayout.Y_AXIS));
		
		JLabel YourPostsLabel = new JLabel("Friend's Posts");
		YourPostsLabel.setBounds(165, 152, 100, 30);
		panel_1.add(YourPostsLabel);
		
		JLabel HobbiesLabel = new JLabel("Hobbies:");
		HobbiesLabel.setBounds(597, 11, 46, 14);
		panel_1.add(HobbiesLabel);
		
		JScrollPane hobbiesScrollPane = new JScrollPane();
		hobbiesScrollPane.setBounds(597, 45, 160, 140);
		panel_1.add(hobbiesScrollPane);
		
		JPanel HobbiesPanel = new JPanel();
		hobbiesScrollPane.setViewportView(HobbiesPanel);
		HobbiesPanel.setLayout(new BoxLayout(HobbiesPanel, BoxLayout.Y_AXIS));
		
		JTextPane SearchText = new JTextPane();
		SearchText.setBounds(275, 162, 216, 20);
		panel_1.add(SearchText);
		
		JButton SearchButton = new JButton("Search");
		SearchButton.setBounds(502, 159, 89, 23);
		panel_1.add(SearchButton);
		
		for(String hobi:theUser.hobbies) {
			JLabel hobis= new JLabel(hobi);
			Component horizontalStrut = Box.createHorizontalStrut(5);
			Component small = Box.createVerticalStrut(30);
			HobbiesPanel.add(horizontalStrut);
			HobbiesPanel.add(hobis);
			HobbiesPanel.add(small);
			
		}
		

		
		JButton btnNewButton = new JButton("Friends: "+theUser.friends.size());
		btnNewButton.setBackground(new Color(0, 255, 255));
		btnNewButton.setBounds(10, 235, 129, 23);
		panel_1.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Friends(theUser,mainUser);
				frame.setVisible(false);
			}
		});
		
		JButton GroupsButton = new JButton("Groups");
		GroupsButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new GroupButton(theUser,mainUser);
				frame.setVisible(false);
				/*
				 * It is creating new frame where theUser's groups being showed
				 */
			}
		});
		GroupsButton.setBounds(10, 269, 129, 23);
		panel_1.add(GroupsButton);
		
		JButton RemoveFriendButton = new JButton("Remove Friend");
		RemoveFriendButton.setBounds(8, 341, 131, 23);
		panel_1.add(RemoveFriendButton);
		RemoveFriendButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainUser.friends.remove(theUser);
				theUser.friends.remove(mainUser);
				new NonFriendPage(theUser,mainUser);
				frame.setVisible(false);
			}
		});
		
		JButton btnNewButton_1 = new JButton("<--Home Page");
		btnNewButton_1.setBounds(8, 11, 147, 29);
		panel_1.add(btnNewButton_1);
		
		
		
		
		
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				new HomePage(mainUser);
				frame.setVisible(false);
			}
		});
		ArrayList<JLabel> a=new ArrayList<JLabel>();
		
		
		
		for(Post p: theUser.userPost) {
			
		
			Component verticalStrut = Box.createVerticalStrut(200);
			JLabel Up= new JLabel(theUser.username+" ("+theUser.name+" "+theUser.surname+")");
			JLabel time= new JLabel(p.timeOfCreation);
			JLabel text= new JLabel(p.text);
			JLabel titleP= new JLabel(p.title);
			JLabel emp= new JLabel("------------------------");
			
			text.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 32));
			
			JLabel ab= new JLabel();
			
			Component horizontalStrut = Box.createHorizontalStrut(200);
			Component small = Box.createVerticalStrut(30);
			YourPostsPane.add(Up);
			YourPostsPane.add(time);
			YourPostsPane.add(emp);
	
			YourPostsPane.add(titleP);
			YourPostsPane.add(ab);
			YourPostsPane.add(text);
			
			YourPostsPane.add(verticalStrut);
			YourPostsPane.add(horizontalStrut);
			ab.setSize(30, 30);
			if(p.image!=null) {
				ab.setIcon(p.image);
			}
			
			
			
		}
		SearchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for(Post p :theUser.userPost) {
					/*
					 * Post are bing searched here and if is get found, new Frame(PostUser) is created.
					 */
					if(p.title.equals(SearchText.getText())) {
						new PostUser(mainUser,p);
						frame.setVisible(false);;
						return;
					}
					
				}
				
			}});
		
		frame.setVisible(true);
	}
}
