import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
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
import javax.swing.JTextPane;
/*
 * This is the frame if the Main User is the member of the group
 * User can delete by DeleteButton, 
 * User leave the Group group by  LeaveButton
 * User can look for other members by JButton cr =new JButton("Click for Profile");
 * User can search posts by  SearchNewButton
 * User can create a posts by  PostButton

 */
public class GroupPage extends JFrame {
	Group group;
	String postTitle;
	String postText;
	ImageIcon postImage;
	User u;
	GroupPage(Group group,User MainUser,User u){
		this.group=group;
		
		JFrame frame = new JFrame();
		frame.setBounds(100, 100, 989, 678);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.CYAN);
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		if(MainUser.equals(group.creator)) {
			JButton DeleteButton = new JButton("Delete Group");
			DeleteButton.setBounds(842, 45, 121, 23);
			panel.add(DeleteButton);
			DeleteButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					/*
					 * 
					 * It is deleting the group my removing from the grouplist
					 */
					MainPage.grouplist.remove(group);
					new HomePage(MainUser);
					frame.setVisible(false);
				}
			});
		}
		
		JLabel nameLabel = new JLabel(group.name);
		nameLabel.setFont(new Font("Tahoma", Font.PLAIN, 34));
		nameLabel.setBounds(10, 45, 217, 131);
		panel.add(nameLabel);
		
		JButton HomeButton = new JButton("<--Home Page");
		HomeButton.setBounds(10, 11, 89, 23);
		panel.add(HomeButton);
		HomeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				new HomePage(MainUser);
				frame.setVisible(false);
			}
		});
		
		JButton LeaveButton = new JButton("Leave");
		LeaveButton.setBounds(874, 11, 89, 23);
		panel.add(LeaveButton);
		
		JLabel CountryLabel = new JLabel("Country:"+group.country);
		CountryLabel.setBounds(237, 15, 191, 14);
		panel.add(CountryLabel);
		
		JLabel CreatorLabel = new JLabel("Creator: "+group.creator.username);
		CreatorLabel.setBounds(10, 187, 107, 14);
		panel.add(CreatorLabel);
		
		JLabel NumberMemberLabel = new JLabel("Number of Members: "+group.members.size());
		NumberMemberLabel.setBounds(438, 15, 224, 14);
		panel.add(NumberMemberLabel);
		
		JLabel HobbiesLabel = new JLabel("Hobbies:");
		HobbiesLabel.setBounds(766, 343, 130, 14);
		panel.add(HobbiesLabel);
		
		
		
		JScrollPane HobbiesScrollPane = new JScrollPane();
		HobbiesScrollPane.setBounds(762, 368, 134, 249);
		panel.add(HobbiesScrollPane);
		
		JPanel HobbiesPanel = new JPanel();
		HobbiesScrollPane.setViewportView(HobbiesPanel);
		HobbiesPanel.setLayout(new BoxLayout(HobbiesPanel, BoxLayout.Y_AXIS));
		
		for(String hobies:group.hobbies) {
			Component small = Box.createVerticalStrut(30);
			JLabel hobi= new JLabel(hobies);
			HobbiesPanel.add(hobi);
			HobbiesPanel.add(small);
			
		}
		
	
		JButton cr =new JButton("Click for Profile");
		
		cr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*
				 * Mainuser is directing to the several frames for different scenarios
				 * 
				 */
				
				/*
				 * Main User and User u friend
				 */
				if(MainUser.friends.contains(u)) {
					new FriendPage(u,MainUser);
					frame.setVisible(false);
				}
				/*
				 * Main user and User u same person
				 */
				else if(MainUser.equals(u)) {
					new MyProfile(u);
				}
				else {
					/*
					 * Main User is not friend of User u
					 */
					new NonFriendPage(u,MainUser);
					frame.setVisible(false);
				}
			}
		});
		JLabel MemberslLabel = new JLabel("Members:\r\n");
		MemberslLabel.setBounds(10, 279, 65, 14);
		panel.add(MemberslLabel);
		
		JScrollPane CreatorScrollPane = new JScrollPane();
		CreatorScrollPane.setBounds(10, 210, 208, 65);
		panel.add(CreatorScrollPane);
		
		
		JPanel CreatorpPanel = new JPanel();
		CreatorScrollPane.setViewportView(CreatorpPanel);
		JLabel creat= new JLabel(group.creator.username+" ("+group.creator.name+" "+group.creator.surname+")");
		CreatorpPanel.add(creat);
		CreatorpPanel.add(cr);
		
		JScrollPane MembersScrollPane = new JScrollPane();
		MembersScrollPane.setBounds(10, 291, 208, 337);
		panel.add(MembersScrollPane);
		
		
		
		JPanel MembersPanel = new JPanel();
		MembersScrollPane.setViewportView(MembersPanel);
		MembersScrollPane.setViewportView(MembersPanel);
		MembersPanel.setLayout(new BoxLayout(MembersPanel, BoxLayout.Y_AXIS));
		
		JTextPane titleText = new JTextPane();
		titleText.setBounds(237, 100, 246, 20);
		panel.add(titleText);
		
		JButton ChooseButton = new JButton("Choose a file");
		ChooseButton.setBounds(759, 153, 121, 23);
		panel.add(ChooseButton);
		ChooseButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser fc=new JFileChooser();
				int response=fc.showOpenDialog(null);
				if(response==JFileChooser.APPROVE_OPTION) {
					 postImage=new ImageIcon(fc.getSelectedFile().getAbsolutePath());
					
				
					
					
				}
			}
		});
		JTextPane TextText = new JTextPane();
		TextText.setBounds(237, 153, 457, 145);
		panel.add(TextText);
		
		JButton PostButton = new JButton("Post");
		PostButton.setBounds(759, 275, 121, 23);
		panel.add(PostButton);
		PostButton.addActionListener(new ActionListener() {
			
			
			public void actionPerformed(ActionEvent e) {
				/*
				 * It is checking uniqness of the title
				 */
				for(User u:MainPage.userlist) {
					for(Post p:u.userPost) {
						if(titleText.getText().equals(p.title)) {
							new GroupPage(group,MainUser,u);
							frame.setVisible(false);
							return;
						}
					}
					
				}
				for(Group g:MainPage.grouplist) {
					for(Post po:g.posts) {
						if(titleText.getText().equals(po.title)) {
							new GroupPage(group,MainUser,u);
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
				group.posts.add(new Post(titleText.getText(),time,MainUser,TextText.getText(),postImage));
				
				
				frame.setVisible(false);
				//new Sign_in();
				new GroupPage(group,MainUser,u);
			}
		});
		
		
		JLabel GroupPostsLabel = new JLabel("Group Posts:");
		GroupPostsLabel.setBounds(237, 331, 89, 14);
		panel.add(GroupPostsLabel);
		
		JScrollPane PostsScrollPane = new JScrollPane();
		PostsScrollPane.setBounds(237, 368, 457, 260);
		panel.add(PostsScrollPane);
		
		JPanel PostsPanel = new JPanel();
		PostsScrollPane.setViewportView(PostsPanel);
		PostsPanel.setLayout(new BoxLayout(PostsPanel, BoxLayout.Y_AXIS));
		
		JLabel TitleLabel = new JLabel("Title:");
		TitleLabel.setBounds(237, 87, 46, 14);
		panel.add(TitleLabel);
		
		JLabel TextLabel = new JLabel("Text");
		TextLabel.setBounds(237, 131, 46, 14);
		panel.add(TextLabel);
		
		for(User theUser: group.members) {
			JButton remove= new JButton();
			remove.setSize(90, 90);
			remove.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					group.members.remove(theUser);
					new GroupPage(group,MainUser,u);
					frame.setVisible(false);
				}
			});
			if(theUser==MainUser) {
				Component verticalStrut = Box.createVerticalStrut(20);
				JLabel Up= new JLabel(theUser.username+" ("+theUser.name+" "+theUser.surname+")");
				
			
				
				Up.setSize(10, 30);
				Component horizontalStrut = Box.createHorizontalStrut(10);
				Component small = Box.createVerticalStrut(5);
				JButton buton =new JButton("Click for Profile");
				
				buton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
					
						new MyProfile(MainUser)
;					}
				});
				
				
				MembersPanel.add(Up);
				MembersPanel.add(buton);
				if(MainUser.equals(group.creator)) {
					// Group Creator can remove the posts
					
					MembersPanel.add(small);
					MembersPanel.add(remove);
				}
				
				
				MembersPanel.add(verticalStrut);
				MembersPanel.add(horizontalStrut);
			}
			else {
				Component verticalStrut = Box.createVerticalStrut(20);
				JLabel Up= new JLabel(theUser.username+" ("+theUser.name+" "+theUser.surname+")");
				

				
				Up.setSize(10, 30);
				Component horizontalStrut = Box.createHorizontalStrut(10);
				Component small = Box.createVerticalStrut(5);
				JButton buton =new JButton("Click for Profile");
				
				buton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						
						if(MainUser.friends.contains(theUser)) {
							new FriendPage(theUser,MainUser);
							frame.setVisible(false);
						}
						else {
							new NonFriendPage(theUser,MainUser);
							frame.setVisible(false);
						}
					}
				});
				MembersPanel.add(Up);
				MembersPanel.add(buton);
				if(MainUser.equals(group.creator)) {
					MembersPanel.add(small);
					MembersPanel.add(remove);
				}
				
				
				
				MembersPanel.add(verticalStrut);
				MembersPanel.add(horizontalStrut);
			}
			
			
			
		}
		
		for(Post p:group.posts) {
			JButton edit = new JButton("Modify");
			edit.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
				
						new Modify(p,group);
		
						frame.setVisible(false);
						
					
				}
			});
			/*
			 * Group creator can remove the group
			 */
			JButton removeP = new JButton("Remove");
			removeP.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					
						group.posts.remove(p);
						new GroupPage(group,MainUser,u);
						frame.setVisible(false);
						
					
				}
			});
			JLabel name= new JLabel(group.name);
			JLabel Up= new JLabel(p.author.username+" ("+p.author.name+" "+p.author.surname+")");
			JLabel time= new JLabel(p.timeOfCreation);
			JLabel text= new JLabel(p.text);
			JLabel titleP= new JLabel(p.title);
			JLabel emp= new JLabel("------------------------");
			
			text.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 32));
	
			JLabel ab= new JLabel();
			
			Component horizontalStrut = Box.createHorizontalStrut(200);
			Component verticalStrut = Box.createVerticalStrut(200);
			Component small = Box.createVerticalStrut(30);
			PostsPanel.add(name);
			PostsPanel.add(Up);
			PostsPanel.add(time);
			PostsPanel.add(emp);
		
			PostsPanel.add(titleP);
			PostsPanel.add(ab);
			PostsPanel.add(text);
			/*
			 * Only post author and group creator can remove the post
			 * 
			 */
			if(MainUser.equals(p.author)|MainUser.equals(group.creator)) {
				if(MainUser.equals(p.author)) {
					PostsPanel.add(edit);
				}
				
				PostsPanel.add(removeP);
			}
			
			PostsPanel.add(verticalStrut);
			PostsPanel.add(horizontalStrut);
			if(p.image!=null) {
				ab.setIcon(p.image);
			}
		}
		
		LeaveButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			
				if(MainUser.equals(group.creator)) {
					group.members.remove(group.creator);
					/*
					 * If group creator is  leaving, the oldest member would be group.creator
					 * If there is no one left, group will be removed
					 */
					if(group.members.size()!=0) {
						group.creator=group.members.get(0);
					}
					else {
						MainPage.grouplist.remove(group);
						new HomePage(MainUser);
						frame.setVisible(false);
						
					}
					new HomePage(MainUser);
					frame.setVisible(false);
				}
				else {
					group.members.remove(MainUser);
					new HomePage(MainUser);
					frame.setVisible(false);
				}
			}
		});
		JTextPane txtSearch = new JTextPane();
		txtSearch.setBounds(356, 331, 239, 23);
		panel.add(txtSearch);
		
		JButton SearchNewButton = new JButton("Search");
		SearchNewButton.setBounds(605, 327, 89, 23);
		panel.add(SearchNewButton);
		SearchNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*
				 * It is searching the posts by title
				 */
				for(Post p :group.posts) {
				
					if(p.title.equals(txtSearch.getText())) {
						new PostGroup(group,MainUser,p);
						frame.setVisible(false);;
						return;
					}
					
				}
				
			}});
		
		frame.setVisible(true);
	}
}
