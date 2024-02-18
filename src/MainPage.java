import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MainPage extends JFrame {
	/*
	 * This is the class where datas are hard code
	 * There is two button for user:
	 * Sign in and sign up
	 * this class has a userlist which stores all of the users.
	 * public static ArrayList<User> userlist is static because it is being called outside of the class.
	 * When new User is created, this new user is beind added to the MainPage.userlist
	 * this class has a grouplist which stores all of the groups
	 * public static ArrayList<Group>grouplist is static because it is being called outside of the class
	 * When new Group is created, this new Group is beind added to the MainPage.grouplist
	 * this class has a postlist which contains all of the posts
	 * when new post created, this post is being added to the MainPage.grouplist
	 * 
	 */
	public static ArrayList<User> userlist;
	public static ArrayList<Group>grouplist;
	public static ArrayList<Post>postlist;
	
 MainPage(){
	 
	JFrame frame = new JFrame();
		frame.getContentPane().setBackground(Color.CYAN);
		frame.setBackground(Color.CYAN);
		frame.setForeground(Color.CYAN);
		frame.getContentPane().setForeground(Color.CYAN);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Matebok\r\n");
		lblNewLabel.setFont(new Font("Tw Cen MT Condensed", Font.ITALIC, 30));
		lblNewLabel.setBounds(360, 145, 133, 70);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Please sign in or sign up\r\n");
		lblNewLabel_1.setBounds(350, 197, 153, 50);
		frame.getContentPane().add(lblNewLabel_1);
		
		userlist=new ArrayList<User>();
		grouplist=new ArrayList<Group>();
		postlist=new ArrayList<Post>();
		JButton btnNewButton = new JButton("Sign in");
		btnNewButton.setBounds(360, 258, 89, 23);
		frame.getContentPane().add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				new Sign_in();
				frame.setVisible(false);
			}
		});
		
		JButton btnNewButton_1 = new JButton("Sign up");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				new Signup();
				frame.setVisible(false);
			}
		});
		btnNewButton_1.setBounds(360, 292, 89, 23);
		frame.getContentPane().add(btnNewButton_1);
		frame.setBounds(100, 100, 800, 532);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.userlist=userlist;
		
		

		/*
		 * Users
		 */
		System.out.println(22332);
		new User("a","a","root","root","21","-",null,"turkey",true);
		new User("ardaye","istanbul34","arda","yeni","20","ardaye@hotmail.com",new ImageIcon("C:\\\\Users\\\\derya\\\\eclipse-workspace\\\\Project\\\\a1.jpg"),"turkey",true);
		new User("bakaye","adana1","burak","yener","20","bakaye@hotmail.com",null,"turkey",true);
		new User("demonHunter","123321","John","Doe","9","iloveanime@hotmil.com",null,"germany",true);
		new User("ahmedo","123","ahmet","sol","31","ahhhotmail.com",null,"usa",false);
		new User("aarar","aadad","raf","fra","24","-",null,"kenya",false);
		new User("sword","321","ayþe","la","22","-",null,"france",false);
		new User("demon","132","fatma","si","55","-",null,"bolivia",false);
		new User("khotnkar","aa2","arda","ardarda","44","-",null,"china",false);
		new User("chinesebot1","ara1","chong","khan","13","-",null,"china",false);
		new User("drknysterien","f3d2","magnus","carlsen","27","mcarlsenq@hotmai.com",null,"norway",false);
		new User("ljames","king1","lebron","james","37","ljames@hotmail.com",null,"usa",false);
		
		/*
		 * Adding hobbies to the users
		 */
		userlist.get(0).hobbies.add("football");
		userlist.get(0).hobbies.add("basketball");
		userlist.get(0).hobbies.add("tenis");
		userlist.get(0).hobbies.add("video game");
		
		
		userlist.get(1).hobbies.add("football");
		userlist.get(1).hobbies.add("tv series");
		userlist.get(1).hobbies.add("tenis");
		userlist.get(1).hobbies.add("video game");
		
		userlist.get(2).hobbies.add("reading");
		userlist.get(2).hobbies.add("jogging");
		userlist.get(2).hobbies.add("tenis");
		userlist.get(2).hobbies.add("video game");
		
		userlist.get(3).hobbies.add("fitness");
		userlist.get(3).hobbies.add("anime");
		userlist.get(3).hobbies.add("instagram");
		userlist.get(3).hobbies.add("voleybal");
		
		userlist.get(4).hobbies.add("video game");
		userlist.get(4).hobbies.add("painting");
		userlist.get(4).hobbies.add("piano");
		userlist.get(4).hobbies.add("video game");
		
		userlist.get(5).hobbies.add("video game");
		userlist.get(5).hobbies.add("painting");
		userlist.get(5).hobbies.add("piano");
		userlist.get(5).hobbies.add("guitar");
		
		
		userlist.get(0).addFriend(userlist.get(1));
		userlist.get(0).addFriend(userlist.get(2));
		userlist.get(0).addFriend(userlist.get(3));
		
		userlist.get(0).addFriend(userlist.get(5));
		
		userlist.get(0).addFriend(userlist.get(7));
		
		userlist.get(0).addFriend(userlist.get(9));
		
		userlist.get(0).addFriend(userlist.get(11));

		
		userlist.get(1).addFriend(userlist.get(2));
		userlist.get(1).addFriend(userlist.get(3));
		
		userlist.get(2).addFriend(userlist.get(3));
		
		
		userlist.get(4).addFriend(userlist.get(5));	
		userlist.get(4).addFriend(userlist.get(6));
		userlist.get(4).addFriend(userlist.get(7));
		
		userlist.get(5).addFriend(userlist.get(6));
		userlist.get(5).addFriend(userlist.get(7));
		
		userlist.get(5).addFriend(userlist.get(7));
		
		userlist.get(7).addFriend(userlist.get(8));
		userlist.get(7).addFriend(userlist.get(9));
		userlist.get(7).addFriend(userlist.get(10));
		
		userlist.get(8).addFriend(userlist.get(9));
		userlist.get(8).addFriend(userlist.get(10));
		
		userlist.get(9).addFriend(userlist.get(10));
		
		userlist.get(9).addFriend(userlist.get(10));
		
		
		userlist.get(10).addFriend(userlist.get(11));
		
		
	
		
		
		
		System.out.println(11);
		/*
		 * Posts
		 */
		
		new Post("MyBird","31.04.2002",userlist.get(0),"I love my bird",new ImageIcon("C:\\\\Users\\\\derya\\\\eclipse-workspace\\\\Project\\\\bird.jpg"));
		new Post("tv","11.03.2022",userlist.get(1),"I love anime",new ImageIcon("C:\\\\Users\\\\derya\\\\eclipse-workspace\\\\Project\\\\zenitsu.jpg"));
		new Post("MyCat","15.04.2001",userlist.get(2),"I love cat",new ImageIcon("C:\\\\Users\\\\derya\\\\eclipse-workspace\\\\Project\\\\cat.jpg"));
		new Post("MyCode","1.04.2002",userlist.get(3),"My code is working!",new ImageIcon("C:\\\\Users\\\\derya\\\\eclipse-workspace\\\\Project\\\\proj1.png"));
		new Post("MyDog","1.04.20100",userlist.get(4),"I love dog",new ImageIcon("C:\\\\Users\\\\derya\\\\eclipse-workspace\\\\Project\\\\dog.jpg"));
		new Post("deathnote","1.04.201420",userlist.get(5),"Death Note is gooooood",new ImageIcon("C:\\\\Users\\\\derya\\\\eclipse-workspace\\\\Project\\\\a3.jpg"));
		new Post("newanime","1.04.201420",userlist.get(6),"I started to new anime",new ImageIcon("C:\\\\Users\\\\derya\\\\eclipse-workspace\\\\Project\\\\a4.jpg"));
		new Post("friend","1.04.201420",userlist.get(7),"We watched movie with my friend",new ImageIcon("C:\\\\Users\\\\derya\\\\eclipse-workspace\\\\Project\\\\a5.jpg"));
		new Post("howareyou","1.04.201420",userlist.get(8),"How are you my deer friends",new ImageIcon("C:\\\\Users\\\\derya\\\\eclipse-workspace\\\\Project\\\\a6.jpg"));
		new Post("queenSacrifice","1.04.201420",userlist.get(9),"I sacriiced my queen",new ImageIcon("C:\\\\Users\\\\derya\\\\eclipse-workspace\\\\Project\\\\chess1.jpg"));
		new Post("chess","1.04.201420",userlist.get(10),"I lost this position...",new ImageIcon("C:\\\\Users\\\\derya\\\\eclipse-workspace\\\\Project\\\\chess2.jpg"));
		new Post("chessplayer","1.04.201420",userlist.get(5),"This is true",new ImageIcon("C:\\\\Users\\\\derya\\\\eclipse-workspace\\\\Project\\\\chess3.jpg"));
		
		
		new Post("lebronJames","1.2.2000",userlist.get(0),"Lebron james is a very extraordinary player",new ImageIcon(""));//12
		new Post("manuwin","1.2.33",userlist.get(0),"Manchester United scores with Ronaldo. It's 1-1",new ImageIcon(""));
		new Post("messi","1.2.33",userlist.get(0),"Messi is the greatest footbal player of all the time",new ImageIcon(""));
		
		new Post("dicaprio","1.2.33",userlist.get(1),"Leanardo Dicaprio is the best actor",new ImageIcon(""));
		new Post("german","1.2.33",userlist.get(1),"German is a very hard language. I cant speak it",new ImageIcon(""));
		new Post("myday","1.2.3",userlist.get(1),"Today is a beatiful day",new ImageIcon(""));
		
		new Post("bday","1.04.201420",userlist.get(2),"Today is my birthday!!",new ImageIcon());
		new Post("apple","1.04.201420",userlist.get(2),"Apple is good",new ImageIcon());
		new Post("samsung","1.04.201420",userlist.get(2),"Samsung is better than Huawei",new ImageIcon());
		
		new Post("Halo","1.04.201420",userlist.get(3),"Das ist meine erste Photo in Matebok",new ImageIcon());
		new Post("koln","1.04.201420",userlist.get(3),"Ich komme aus Koln",new ImageIcon());
		new Post("du","1.04.201420",userlist.get(3),"Du hast nich gesagt",new ImageIcon());
		
		new Post("champions","1.04.201420",userlist.get(4),"We are the champions my friend",new ImageIcon());
		new Post("stop","1.04.201420",userlist.get(4),"Dont stop me know. I am having such a good time",new ImageIcon());
		new Post("bohemian","1.04.201420",userlist.get(4),"Mama I just killed a man",new ImageIcon());
		
		new Post("aot","1.04.201420",userlist.get(5),"Attack on titan my favorite anime",new ImageIcon());
		new Post("eren","1.04.201420",userlist.get(5),"eren jaeger was the main antagonsit of the show",new ImageIcon());
		new Post("mikasa","1.04.201420",userlist.get(5),"Mikasa is my love",new ImageIcon());
		
		new Post("muse","1.04.201420",userlist.get(6),"I am going down",new ImageIcon());
		new Post("good","1.04.201420",userlist.get(6),"BECAUSE I AM FEELING GOOD",new ImageIcon());
		new Post("tarkan","1.04.201420",userlist.get(6),"Seni gidi fýndýk kýran yýlaðýný deliðinden çýkaran",new ImageIcon());
		
		new Post("toret","1.04.201420",userlist.get(7),"I love toret",new ImageIcon());
		new Post("bershka","1.04.201420",userlist.get(7),"bershka is too expensive",new ImageIcon());
		new Post("berlin","1.04.201420",userlist.get(7),"berlin is a very good city",new ImageIcon());
		
		new Post("math","1.04.201420",userlist.get(8),"math is so BORINGGG",new ImageIcon());
		new Post("java","1.04.201420",userlist.get(8),"Java>Python",new ImageIcon());
		new Post("physic","1.04.201420",userlist.get(8),"I got 77 from physic midterm :((",new ImageIcon());
		
		new Post("ww2","1.04.201420",userlist.get(9),"ww2 is so horrible",new ImageIcon());
		new Post("comp132","1.04.201420",userlist.get(9),"comp132>comp100",new ImageIcon());
		new Post("comp100","1.04.201420",userlist.get(9),"comp100 is bad",new ImageIcon());
		
		new Post("red","1.04.201420",userlist.get(10),"my favorite colour is red",new ImageIcon());
		new Post("blue","1.04.201420",userlist.get(10),"blue is the warmest color",new ImageIcon());
		new Post("guitar","1.04.201420",userlist.get(10),"I love playing guitar",new ImageIcon());
		
		new Post("a","1.04.201420",userlist.get(11),"a stands",new ImageIcon());
		new Post("aot","1.04.201420",userlist.get(11),"Attack on titan my favorite anime",new ImageIcon());
		new Post("aot","1.04.201420",userlist.get(11),"Attack on titan my favorite anime",new ImageIcon());
		
		ArrayList<String> bgy= new ArrayList<String>();
		ArrayList<Post> bgyposts=new ArrayList<Post>();
		ArrayList<User> members=new ArrayList<User>();
		
		members.add(userlist.get(0));
		members.add(userlist.get(1));
		members.add(userlist.get(2));
		
		
		bgyposts.add(postlist.get(0));
		bgyposts.add(postlist.get(15));
		bgyposts.add(postlist.get(18));
		/*
		 * User.grouppost is initilazing to the true because in the homepage if User.grouppost equals to the true, it is also adding group name.
		 */
		postlist.get(0).groupPost=true;
		postlist.get(15).groupPost=true;
		postlist.get(18).groupPost=true;
		
		/*
		 * Group hobbies
		 */
		bgy.add("football");
		bgy.add("basketball");
		bgy.add("politics");
		bgy.add("technology");
		
		/*
		 * Other groups are get executed in the same process
		 */
		ArrayList<String> aog= new ArrayList<String>();
		ArrayList<Post> aogposts=new ArrayList<Post>();
		ArrayList<User> aogmembers=new ArrayList<User>();
		
		aogmembers.add(userlist.get(3));
		aogmembers.add(userlist.get(4));
		aogmembers.add(userlist.get(5));
		aogposts.add(postlist.get(3));
		aogposts.add(postlist.get(27));
		aogposts.add(postlist.get(24));
		postlist.get(3).groupPost=true;
		postlist.get(24).groupPost=true;
		postlist.get(27).groupPost=true;
		
		aog.add("dance");
		aog.add("comics");
		aog.add("marvel");
		aog.add("video game");
		
		ArrayList<String> flowoverstock= new ArrayList<String>();
		ArrayList<Post> flowoverstockposts=new ArrayList<Post>();
		ArrayList<User> flowoverstockmembers=new ArrayList<User>();
		
		flowoverstockmembers.add(userlist.get(6));
		flowoverstockmembers.add(userlist.get(7));
		flowoverstockmembers.add(userlist.get(8));
		
		flowoverstock.add("java");
		flowoverstock.add("python");
		flowoverstock.add("computer");
		flowoverstock.add("yazýlým");
		flowoverstockposts.add(postlist.get(6));
		flowoverstockposts.add(postlist.get(33));
		flowoverstockposts.add(postlist.get(36));
		postlist.get(6).groupPost=true;
		postlist.get(33).groupPost=true;
		postlist.get(36).groupPost=true;
		
		ArrayList<String> footballovers= new ArrayList<String>();
		ArrayList<Post> footballoversposts=new ArrayList<Post>();
		ArrayList<User> footballoversmembers=new ArrayList<User>();
		
		footballoversmembers.add(userlist.get(9));
		footballoversmembers.add(userlist.get(10));
		footballoversmembers.add(userlist.get(11));
		footballoversposts.add(postlist.get(6));
		footballovers.add("messi");
		footballovers.add("ronaldo");
		footballovers.add("messi");
		footballovers.add("galatasaray");
		footballoversposts.add(postlist.get(9));
		footballoversposts.add(postlist.get(42));
		footballoversposts.add(postlist.get(45));
		postlist.get(9).groupPost=true;
		postlist.get(42).groupPost=true;
		postlist.get(45).groupPost=true;
		/*
		 * Groups are being created and the last parameter of the constructor is group leader.
		 * It is now not checking for if the premium , because choosen users are already premiumu
		 */
		new Group("BGY","turkey",bgy,bgyposts,members,userlist.get(0));
		new Group("AOG","turkey",aog,aogposts,aogmembers,userlist.get(3));
		new Group("FLOW OVER STOCK","international",flowoverstock,flowoverstockposts,flowoverstockmembers,userlist.get(6));
		new Group("FootbalLovers","england",footballovers,footballoversposts,footballoversmembers,userlist.get(9));
		
		frame.setVisible(true);
 }

}

