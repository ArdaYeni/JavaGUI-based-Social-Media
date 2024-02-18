import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
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

public class GroupButton extends JFrame {
	
	User u;
	User MainUser;
	/*
	 * This is the frame where groups'of the User u is included
	 * * User u is a chosen user ,User mainUser is Main User, group g is 
	 */
	GroupButton(User u,User MainUser){
		JFrame frame=new JFrame();
		frame.setBounds(100, 100, 450, 458);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("<-- Back");
		btnNewButton.setBounds(335, 7, 89, 23);
		panel.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new MyProfile(MainUser);
				frame.setVisible(false);
			}
		});
		
		
		JButton AddButton = new JButton("Add New Group");
		AddButton.setBounds(140, 7, 128, 23);
		if(MainUser.premium) {
			panel.add(AddButton);
		}
		AddButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				new AddGroup(MainUser,new ArrayList<String>(),"","");
				frame.setVisible(false);
			}
		});
		
		
		JLabel lblNewLabel = new JLabel("Groups:\r\n");
		lblNewLabel.setBounds(10, 11, 61, 14);
		panel.add(lblNewLabel);
		panel.setBackground(Color.CYAN);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 43, 414, 365);
		panel.add(scrollPane);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.Y_AXIS));
		scrollPane.setViewportView(panel_1);
		frame.setVisible(true);
		panel_1.setBackground(Color.CYAN);
		
		for(Group group:MainPage.grouplist) {
			if(group.members.contains(u)|group.creator.equals(u)) {
				Component verticalStrut = Box.createVerticalStrut(20);
				JLabel Up= new JLabel(group.name);
				
				
				
				
				
				
				
				Up.setSize(10, 30);
				Component horizontalStrut = Box.createHorizontalStrut(10);
				Component small = Box.createVerticalStrut(5);
				JButton buton =new JButton("Click for Group");
				
				buton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						
						if(group.members.contains(MainUser)|group.creator.equals(MainUser)) {
							new GroupPage(group,MainUser,u);
							frame.setVisible(false);
						}
						else {
							new GroupPageNonFollower(group,MainUser,u);
							
							frame.setVisible(false);
						}
					}
				});
				panel_1.add(Up);
				panel_1.add(buton);
				
				
				panel_1.add(verticalStrut);
				panel_1.add(horizontalStrut);
			}
			
			
			
		}
	}
}
