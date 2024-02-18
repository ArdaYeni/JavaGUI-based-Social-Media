import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.Locale;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
/*
 * This is the home page frame where user can look friend's posts, search other users or groups, post a new post, and look into his/her own profile
 * String postTitle is for title of the post
	String postText is the text of the post
	ImageIcon postImage; is for displaying the posts in scrolled pane
 */
public class HomePage extends JFrame {
	User theUser;
	String postTitle;
	String postText;
	ImageIcon postImage;
	HomePage(User user){
		this.theUser=user;
		JFrame frame = new JFrame();
		frame.setBounds(100, 100, 956, 626);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel panel = new JPanel();
		panel.setBackground(Color.CYAN);
		
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 256, 920, 320);
		panel.add(scrollPane);
		
		JPanel panel_1 = new JPanel();
		scrollPane.setViewportView(panel_1);
		panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.Y_AXIS));
		int y=25;
		
		
		JButton btnNewButton = new JButton("My Profile");
		btnNewButton.setBounds(819, 0, 121, 45);
		panel.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new MyProfile(user);
				frame.setVisible(false);
					
					
					
					
				}
				
			
			}
		);
		
		JTextField txtSearch = new JTextField();
		txtSearch.setText("Search..");
		txtSearch.setBounds(167, 0, 541, 20);
		panel.add(txtSearch);
		txtSearch.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("Search");
		btnNewButton_1.setBounds(710, 0, 89, 23);
		panel.add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for(Group g:MainPage.grouplist) {
					/*
					 * It is iterating the grouplist for if it is in the MainPage.grouplist
					 */
					if(g.name.equals(txtSearch.getText())) {
						if(g.members.contains(theUser)|g.creator.equals(theUser)) {
							new GroupPage(g,theUser,theUser);
							frame.setVisible(false);
							/*
							 * This is a case if Main User is  in the searched group
							 */
						}
						else {
							new GroupPageNonFollower(g,theUser,theUser);
							frame.setVisible(false);
							/*
							 * This is a case if Main User is not in the searched group
							 */
						}
					}
					
				}
				for(User u:MainPage.userlist) {
					/*
					 * It is itearating the userlist for if it is in the MainPage.userlist
					 */
					if(u.username.equals(txtSearch.getText())) {
						if(u.friends.contains(theUser)) {
							new FriendPage(u,theUser);
							frame.setVisible(false);
							/*
							 * This is a case if searched user is friend of the Main User
							 */
						}
						else if(u.equals(theUser)) {
							new MyProfile(theUser);
							frame.setVisible(false);
							/*
							 * This is a case if searched user is  the Main User
							 */
						}
						else {
							new NonFriendPage(u,theUser);
							frame.setVisible(false);
							/*
							 * This is a case if searched user is not friend of the Main User
							 */
						}
					}
					
			}
			}});
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(86, 100, 525, 122);
		textPane.setText("How do you feel "+user.name+" ?");
		panel.add(textPane);
		
		JTextPane title = new JTextPane();
		title.setText("Add your title here");
		title.setBounds(86, 75, 224, 20);
		panel.add(title);
		
		JButton btnNewButton_2 = new JButton("Choose a video or photo");
		btnNewButton_2.setBounds(624, 82, 159, 29);
		panel.add(btnNewButton_2);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser fc=new JFileChooser();
				int response=fc.showOpenDialog(null);
				if(response==JFileChooser.APPROVE_OPTION) {
					postImage=new ImageIcon(fc.getSelectedFile().getAbsolutePath());
					
					
					
					
				}
				
				
			}
		});
		JLabel lblNewLabel = new JLabel("You succesfly posted!");
		lblNewLabel.setForeground(new Color(0, 100, 0));
		lblNewLabel.setBounds(314, 82, 312, 14);
		
		
		JButton btnNewButton_3 = new JButton("Post");
		btnNewButton_3.setBounds(634, 190, 159, 29);
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for(User u:MainPage.userlist) {
					for(Post p:u.userPost) {
						if(title.getText().equals(p.title)) {
							/*
							 * Title of the post must be unique so it is searching for title.gettext is unique
							 * If it is uniqe it is openning HomePageS(user) which is the exact same class with the HomePage but in the HomePageS(user) there is 
							 * a green label which indicates that post is succesfully posted
							 * If it is not unique it is directing to the HomePage
							 */
							new HomePage(theUser);
							frame.setVisible(false);
							return;
						}
					}
				
				}
				for(Group g:MainPage.grouplist) {
					for(Post po:g.posts) {
						/*
						 * It is doing the same thing for the froup posts
						 */
						if(title.getText().equals(po.title)) {
							new HomePage(theUser);
							frame.setVisible(false);
							return;
						}
					}
				}
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern(
				        "hh:mm:ss a", Locale.ENGLISH
				);
				LocalTime dt = LocalTime.now();
				String time=dt.format(formatter);
				new Post(title.getText(),time,user,textPane.getText(),postImage);
			
				
				
				new HomePageS(user);
				frame.setVisible(false);
			
			}
		});
		panel.add(btnNewButton_3);
		
		
		
		for(User u:MainPage.userlist) {
			
			
			for (Post p:u.userPost) {
				
				
				if(this.theUser.equals(u)) {
					
				}
				else if(theUser.friends.contains(u)){
					
					
					Component verticalStrut = Box.createVerticalStrut(200);
					JLabel Up= new JLabel("Creator: "+u.username+" ("+u.name+" "+u.surname+")");
					JLabel time= new JLabel("Time: "+p.timeOfCreation);
					JLabel text= new JLabel("Text: "+p.text);
					JLabel titleP= new JLabel("Title: "+p.title);
					JLabel emp= new JLabel("------------------------");
					
					text.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 32));
					
					JLabel ab= new JLabel();
					
					Component horizontalStrut = Box.createHorizontalStrut(200);
					Component small = Box.createVerticalStrut(30);
					
					
					if(p.groupPost) {
						for(Group g: MainPage.grouplist) {
							if(g.posts.contains(p)) {
								JLabel group= new JLabel("Group: "+g.name);
							
								panel_1.add(group);
							}
							
						}
					}
					panel_1.add(Up);
					panel_1.add(time);
					panel_1.add(emp);
					panel_1.add(titleP);
					panel_1.add(ab);
					panel_1.add(text);
					panel_1.add(verticalStrut);
					panel_1.add(horizontalStrut);
					ab.setSize(30, 30);
					if(p.image!=null) {
						ab.setIcon(p.image);
					}
					
					
					
				}
				
		}
	}
		
		

			
		
		
		frame.setVisible(true);
		
	
}
}