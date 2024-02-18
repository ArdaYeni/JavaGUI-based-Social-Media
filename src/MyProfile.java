import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
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

public class MyProfile extends JFrame{
	User theUser;
	String postTitle;
	String postText;
	ImageIcon postImage;
/*
 * In this frame:
 * User informations are displayed
 * Suggested groups are dispalyed
 * suggested users are displayed
 * User Hobbies are displayed
 * User posts are displayed
 * User can search posts by title
 * User can change her/him informations
 * User can share a post
 * User can look friends
 * User can delete account
 * User can log out
 */
	MyProfile(User theUser){
		System.out.println("þifre: "+theUser.password);
		JFrame frame = new JFrame();
		frame.setBounds(100, 100, 933, 662);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		
		
		JPanel panel_1 = new JPanel();
		frame.add(panel_1);
		panel_1.setBackground(Color.CYAN);
		
		panel_1.setLayout(null);
		
		JLabel ProfilePictureLabel = new JLabel("");
		ProfilePictureLabel.setBounds(0, 44, 147, 140);
		panel_1.add(ProfilePictureLabel);
		ProfilePictureLabel.setIcon(theUser.profilePicture);
		
		JLabel UsernameLabel = new JLabel("Username: "+theUser.username);
		UsernameLabel.setBounds(181, 14, 238, 23);
		panel_1.add(UsernameLabel);
		
		
		JLabel Name_Label = new JLabel("Name: "+theUser.name);
		Name_Label.setBounds(181, 51, 200, 29);
		panel_1.add(Name_Label);
		
		JLabel AgeLabel = new JLabel("Age: "+theUser.age);
		AgeLabel.setBounds(403, 54, 181, 23);
		panel_1.add(AgeLabel);
		
		JLabel SurnameLabel = new JLabel("Surname: "+theUser.surname);
		SurnameLabel.setBounds(393, 11, 181, 29);
		panel_1.add(SurnameLabel);
		
		JLabel EmailLabel = new JLabel("Email: "+theUser.email);
		EmailLabel.setBounds(584, 54, 223, 23);
		
		panel_1.add(EmailLabel);
		
		JTextPane text = new JTextPane();
		text.setBounds(163, 225, 543, 97);
		panel_1.add(text);
		
		JTextPane title = new JTextPane();
		title.setBounds(163, 194, 147, 20);
		panel_1.add(title);
		
		JButton ChangeButton = new JButton("Change your informations");
		ChangeButton.setBounds(343, 156, 194, 23);
		panel_1.add(ChangeButton);
		ChangeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Change(theUser);
				frame.setVisible(false);
			}
		});
		
		JButton GroupsButton = new JButton("Groups");
		GroupsButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new GroupButton(theUser,theUser);
				frame.setVisible(false);
			}
		});
		GroupsButton.setBounds(10, 327, 89, 23);
		panel_1.add(GroupsButton);
		
		JScrollPane YourPostsScrollPane = new JScrollPane();
		YourPostsScrollPane.setBounds(150, 383, 543, 213);
		panel_1.add(YourPostsScrollPane);
		
		JPanel YourPostsPane = new JPanel();
		YourPostsScrollPane.setViewportView(YourPostsPane);
		YourPostsPane.setLayout(new BoxLayout(YourPostsPane, BoxLayout.Y_AXIS));
		
		JLabel YourPostsLabel = new JLabel("Your Posts");
		YourPostsLabel.setBounds(150, 353, 100, 30);
		panel_1.add(YourPostsLabel);
		
		JLabel SuggestedLabel = new JLabel("Suggested Users: ");
		SuggestedLabel.setBounds(703, 357, 182, 23);
		panel_1.add(SuggestedLabel);
		
		JScrollPane SuggestedUsersScrollPane = new JScrollPane();
		SuggestedUsersScrollPane.setBounds(703, 383, 182, 213);
		panel_1.add(SuggestedUsersScrollPane);
		
		JPanel SuggestedUsersPane = new JPanel();
		SuggestedUsersScrollPane.setViewportView(SuggestedUsersPane);
		SuggestedUsersPane.setLayout(new BoxLayout(SuggestedUsersPane, BoxLayout.Y_AXIS));
		
		ArrayList<User> ulist=new ArrayList<User>();
		ulist=theUser.sugest();
		if(ulist.size()>5) {
			for(int i=0;i<5;i++) {
				Component verticalStrut = Box.createVerticalStrut(20);
				User u=ulist.get(i);
				JButton profile=new JButton();
				profile.setText(u.username+" ("+u.name+" "+u.surname+")");
				SuggestedUsersPane.add(profile);
				SuggestedUsersPane.add(verticalStrut);
				profile.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						new NonFriendPage(u,theUser);
						frame.setVisible(false);
					}
				});
			}
		}
		else {
			for(int i=0;i<ulist.size();i++) {
				Component verticalStrut = Box.createVerticalStrut(20);
				User u=ulist.get(i);
				JButton profile=new JButton();
				profile.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						new NonFriendPage(u,theUser);
						frame.setVisible(false);
					}
				});
				profile.setText(u.username+" ("+u.name+" "+u.surname+")");
				SuggestedUsersPane.add(profile);
				SuggestedUsersPane.add(verticalStrut);
			}
		}
		
		
		

		JLabel lblNewLabel = new JLabel("Country: "+theUser.country);
		lblNewLabel.setBounds(584, 18, 217, 14);
		panel_1.add(lblNewLabel);
		
		JLabel Premium = new JLabel("Premium: "+theUser.premium);
		Premium.setBounds(393, 100, 217, 14);
		panel_1.add(Premium);
		
		JLabel YourHobbiesPanel = new JLabel("Your Hobbies:");
		YourHobbiesPanel.setBounds(10, 361, 123, 14);
		panel_1.add(YourHobbiesPanel);
		
		JScrollPane YourHobbiesScollPane = new JScrollPane();
		YourHobbiesScollPane.setBounds(8, 390, 125, 206);
		panel_1.add(YourHobbiesScollPane);
		
		JPanel panel_3 = new JPanel();
		YourHobbiesScollPane.setViewportView(panel_3);
		panel_3.setLayout(new BoxLayout(panel_3, BoxLayout.Y_AXIS));
		
		for(String hobies:theUser.hobbies) {
			Component small = Box.createVerticalStrut(30);
			JLabel hobi= new JLabel(hobies);
			panel_3.add(hobi);
			panel_3.add(small);
			
		}
		
		JButton btnNewButton_3 = new JButton("choose a file");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser fc=new JFileChooser();
				int response=fc.showOpenDialog(null);
				if(response==JFileChooser.APPROVE_OPTION) {
					postImage=new ImageIcon(fc.getSelectedFile().getAbsolutePath());
					
					//File file=new File(fc.getSelectedFile().getAbsolutePath());
					
					
				}
			}
		});
		btnNewButton_3.setBounds(163, 330, 147, 23);
		panel_1.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Post");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			for(User u:MainPage.userlist) {
				for(Post p:u.userPost) {
					if(title.getText().equals(p.title)) {
						new MyProfile(theUser);
						frame.setVisible(false);
						return;
					}
				}
				
			}
			for(Group g:MainPage.grouplist) {
				for(Post po:g.posts) {
					if(title.getText().equals(po.title)) {
						new MyProfile(theUser);
						frame.setVisible(false);
					}
				}
			}
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern(
			        "hh:mm:ss a", Locale.ENGLISH
			);
			LocalTime dt = LocalTime.now();
			String time=dt.format(formatter);
				new Post(title.getText(),time,theUser,text.getText(),postImage);
				
	
				//new Sign_in();
				new MyProfile(theUser);
				frame.setVisible(false);
			}
		});
		
		btnNewButton_4.setBounds(538, 330, 147, 23);
		panel_1.add(btnNewButton_4);
		
		JPanel panel_4 = new JPanel();
		
		theUser.sugest();
		JButton deleteButton = new JButton("Delete");
		deleteButton.setBounds(796, 44, 89, 23);
		panel_1.add(deleteButton);
		deleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainPage.userlist.remove(theUser);
				new Sign_in();
				frame.setVisible(false);
			}		});
		
		JButton btnNewButton = new JButton("Friends: "+theUser.friends.size());
		btnNewButton.setBackground(new Color(0, 255, 255));
		btnNewButton.setBounds(10, 293, 137, 23);
		panel_1.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Friends(theUser,theUser);
				frame.setVisible(false);
			}
		});
		
		JLabel lblNewLabel_1 = new JLabel("Suggested groups:");
		lblNewLabel_1.setBounds(713, 109, 172, 14);
		panel_1.add(lblNewLabel_1);

		JScrollPane suggestedGroupScrollPane = new JScrollPane();
		suggestedGroupScrollPane.setBounds(713, 134, 181, 222);
		panel_1.add(suggestedGroupScrollPane);
		
		JPanel suggestedGroupPane = new JPanel();
		suggestedGroupScrollPane.setViewportView(suggestedGroupPane);
		suggestedGroupPane.setLayout(new BoxLayout(suggestedGroupPane, BoxLayout.Y_AXIS));
		JButton btnNewButton_1 = new JButton("<--Home Page");
		btnNewButton_1.setBounds(8, 11, 125, 29);
		panel_1.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Log out");
		btnNewButton_2.setBounds(796, 11, 89, 23);
		panel_1.add(btnNewButton_2);
		
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				new Sign_in();
				frame.setVisible(false);
			}
		});
		
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				new HomePage(theUser);
				frame.setVisible(false);
			}
		});
		ArrayList<JLabel> a=new ArrayList<JLabel>();
		
		
		
		for(Post p: theUser.userPost) {
			JButton edit = new JButton("Edit");
			JButton remove = new JButton("Remove");
			edit.setSize(20, 90);
			edit.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					new Edit(p);
					frame.setVisible(false);
				}
			});
			
			remove.setSize(20, 90);
			remove.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					theUser.userPost.remove(p);
					new MyProfile(theUser);
					frame.setVisible(false);
				}
			});
			Component verticalStrut = Box.createVerticalStrut(200);
			JLabel Up= new JLabel(theUser.username+" ("+theUser.name+" "+theUser.surname+")");
			JLabel time= new JLabel(p.timeOfCreation);
			JLabel textP= new JLabel(p.text);
			JLabel titleP= new JLabel(p.title);
			JLabel emp= new JLabel("------------------------");
			
			text.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 32));
			//textField_1.setFont(new Font"Tw Cen MT Condensed", Font.PLAIN, 32));
			JLabel ab= new JLabel();
			
			Component horizontalStrut = Box.createHorizontalStrut(200);
			Component small = Box.createVerticalStrut(30);
			YourPostsPane.add(Up);
			YourPostsPane.add(time);
			YourPostsPane.add(emp);
			//panel_1.add(small);
			YourPostsPane.add(titleP);
			YourPostsPane.add(ab);
			YourPostsPane.add(textP);
			YourPostsPane.add(edit);
			YourPostsPane.add(remove);
			YourPostsPane.add(verticalStrut);
			YourPostsPane.add(horizontalStrut);
			ab.setSize(30, 30);
			if(p.image!=null) {
				ab.setIcon(p.image);
			}
			
			
			
		}
		JTextField SearchText = new JTextField();
		SearchText.setBounds(245, 358, 287, 14);
		panel_1.add(SearchText);
		SearchText.setColumns(10);
		
		JButton SearchButton = new JButton("Search");
		SearchButton.setBounds(548, 357, 89, 23);
		panel_1.add(SearchButton);
		SearchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for(Post p :theUser.userPost) {
					//PostGroup(Group g,User MainUser,Post p)
					if(p.title.equals(SearchText.getText())) {
						new PostUser(theUser,p);
						frame.setVisible(false);;
						return;
					}
					
				}
				
			}});
		ArrayList<Group> g=theUser.suggest();
		ArrayList<Group> suggestedGroupList=MainPage.grouplist.get(0).sortGr(g);
		
		if(g.size()>5) {
			for(int i=0;i<5;i++) {
				Component verticalStrut = Box.createVerticalStrut(20);
				Group gr=g.get(i);
				JButton profile=new JButton();
				profile.setText(gr.name);
				suggestedGroupPane.add(profile);
				suggestedGroupPane.add(verticalStrut);
				profile.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						new GroupPageNonFollower(gr,theUser,theUser);
						frame.setVisible(false);
					}
				});
			}
		}
		else {
			for(int i=0;i<g.size();i++) {
			
				Component verticalStrut = Box.createVerticalStrut(20);
				Group gr=g.get(i);
				JButton profile=new JButton();
				profile.setText(gr.name);
				profile.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						new GroupPageNonFollower(gr,theUser,theUser);
						frame.setVisible(false);
					}
				});
		
				suggestedGroupPane.add(profile);
				suggestedGroupPane.add(verticalStrut);

			}
		}
		
		frame.setVisible(true);
		
		
	}
}
