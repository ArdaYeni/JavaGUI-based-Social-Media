import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.swing.ImageIcon;
import java.lang.Math;
public class User implements Comparable<User>{
	/* 
	 * This is the User class
	 * User has a properties like username,passowrd,name,surname,age,email,premium,country
	 * SuggestPoint is  a parameter for suggesting users to the user.Higher suggestpoint is better suggestion for the user. It will be explained in sugest method
	 * 
	 * If the user is premium the boolean premium equals to true
	 *
	 */
	public String username;
	public String password;
	public String name;	
	public String surname;
	public String age;
	public String email;
	public ImageIcon profilePicture;
	public boolean premium;
	public Integer suggestPoint;
	public String suggestPointS;
	
	public String country;
	public List<User> friends;
	public List<String> hobbies;
	public ArrayList<User> suggesteds;
	


	public List<Post> userPost;
	
	User(String username,String password,String name,String surname,String age,String email,ImageIcon profilePicture,String country,boolean premium){
		
		this.username=username;
		this.password=password;
		this.name=name;
		
		this.surname=surname;
		this.age=age;
		this.country=country;
		this.email=email;
		this.premium=premium;
		if(profilePicture==null) {
			/*
			 * If the proifle picture is not selected, there will be default profile picture
			 */
			this.profilePicture=new ImageIcon("C:\\Users\\derya\\eclipse-workspace\\Project\\defaultProfilePicture.png");
		}
		else {
			this.profilePicture=profilePicture;
		}
		/*
		 * User it is being added to MainPage.userlist when it is created
		 */
		MainPage.userlist.add(this);
		userPost= new ArrayList<Post>();
		hobbies=new ArrayList<String>();
		friends=new ArrayList<User>();
		
		
		

	}
	

	
	
	
	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + ", name=" + name + ", surname=" + surname
				+ ", age=" + age + ", email=" + email + ", country=" + country
				+ ", friends=";
	}

/*
 * this is for suggestion to the user
 * Basically it is initializing all users's suggestPoint in MainPage.userlist to 0
 * If the this user and User us is in the same country, User us is gaining +6 point
 * Also it is gaining 2*(5-age_difference_of_this_user_And_User_user) point
 * Also it is gaining 2 points for each common hobbies 
 * 
 */
	public ArrayList<User> sugest(){
		ArrayList<User> ulist=new ArrayList<User>();
		/*
		 * ulist is a speacial list which this User and Friends of the this User are not in the list
		 * But all the other users are here
		 */
		for(User us:MainPage.userlist) {
			us.suggestPoint=0;
		}
		
		for(User us:MainPage.userlist) {
			if(us.equals(this)) {
				
			}
			else if(us.friends.contains(this)) {
				
			}
			else {
				ulist.add(us);
				if(us.country.equals(this.country)) {
					us.suggestPoint+=6;
				}
				int age_a=Integer.parseInt(us.age);
				int age_b=Integer.parseInt(this.age);
				int age_diff=1000;
				if(age_a>age_b);{
					 age_diff=age_a-age_b;
				}
				if(age_a<=age_b) {
					 age_diff=age_b-age_a;
				}
				if(age_diff<=5){
					us.suggestPoint+=2*(5-age_diff);
				}
				for(String hobi:this.hobbies) {
					if(us.hobbies.contains(hobi)) {
						us.suggestPoint+=2;
					}
				}	
			}
			
		}
		
		/*
		 * Then the list is sorting here
		 */
		
		Collections.sort(ulist);
		Collections.reverse(ulist);
		
		
		return ulist;
	}
/*
 * It is method for adding friend

 */

	public void addFriend(User u) {
		u.friends.add(this);
		this.friends.add(u);
	}
	/*
	 * It is for suggesting group to the user
	 * This is the first part, second part is in the Group Class' suggest method
	 * Every group's suggestPoint is initializing to the 0 first
	 * glist is a special list which has all the group this user is not in
	 * If this user and group is in the same country Group gr is gaining +6 points
	 * Also Group gr is gaining +2 points for each common hobby with user
	 * 
	 */
	public ArrayList<Group> suggest(){
		ArrayList<Group> glist=new ArrayList<Group>();
		for(Group gr:MainPage.grouplist) {
			gr.suggestPoint=0;
		}
		for(Group gr:MainPage.grouplist) {
			
			if(gr.members.contains(this)) {
				
			}
			else {
				glist.add(gr);
				if(this.country.equals(gr.country)) {
					gr.suggestPoint+=6;
				}
				
				for(String hobi:this.hobbies) {
					if(gr.hobbies.contains(hobi)) {
						gr.suggestPoint+=2;
					}
				}
			
			}
			
		}
		return glist;
	}
	/*
	 * 
	 */
	




/*
 * This is  the compare method
 * It comapres User's with the suggestpoint field
 */
	@Override
	public int compareTo(User o) {
		// TODO Auto-generated method stub
		
		return this.suggestPoint.compareTo(o.suggestPoint);
	}
	
	





	
	
}
