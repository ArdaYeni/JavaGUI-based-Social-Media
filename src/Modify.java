import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class Modify extends JFrame{
	Post post;
	Group g;
	/*
	 * This is the frame for  changing the title,text and image of the photo
	 */
	Modify(Post post,Group g){
		JFrame frame = new JFrame();
		frame.setBounds(100, 100, 440, 437);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel EditPanelTitle = new JPanel();
		EditPanelTitle.setBackground(Color.CYAN);
		frame.getContentPane().add(EditPanelTitle, BorderLayout.CENTER);
		EditPanelTitle.setLayout(null);
		
		JLabel EditLabelTitle = new JLabel("Title:");
		EditLabelTitle.setBounds(20, 244, 46, 14);
		EditPanelTitle.add(EditLabelTitle);
		
		JLabel EditLabelText = new JLabel("Text");
		EditLabelText.setBounds(20, 363, 46, 14);
		EditPanelTitle.add(EditLabelText);
		
		JButton OkButtonw = new JButton("OK");
		OkButtonw.setBounds(171, 534, 89, 23);
		EditPanelTitle.add(OkButtonw);
		
		JLabel ImageEdit = new JLabel("Image:");
		ImageEdit.setBounds(20, 0, 46, 14);
		EditPanelTitle.add(ImageEdit);
		
		JLabel Picture = new JLabel("New label");
		Picture.setBounds(20, 25, 178, 185);
		Picture.setIcon(post.image);
		EditPanelTitle.add(Picture);
		
		JButton btnNewButton = new JButton("Choose a photo");
		btnNewButton.setBounds(20, 210, 124, 23);
		EditPanelTitle.add(btnNewButton);
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 287, 414, 65);
		EditPanelTitle.add(scrollPane);
		
		JTextField textTitle = new JTextField();
		scrollPane.setViewportView(textTitle);
		textTitle.setColumns(10);
		textTitle.setText(post.title);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(20, 395, 414, 134);
		EditPanelTitle.add(scrollPane_1);
		
		JTextField TextText = new JTextField();
		scrollPane_1.setViewportView(TextText);
		TextText.setColumns(10);
		TextText.setText(post.text);
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JFileChooser fc=new JFileChooser();
				int response=fc.showOpenDialog(null);
				if(response==JFileChooser.APPROVE_OPTION) {
					post.image=new ImageIcon(fc.getSelectedFile().getAbsolutePath());
					
					
			
					
					
				}
			}
		});
		OkButtonw.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				post.title=textTitle.getText();
				post.text=TextText.getText();
				new GroupPage(g,post.author,post.author);
				frame.setVisible(false);
			}
		});
		
		frame.setVisible(true);
}}
