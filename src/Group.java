import java.util.ArrayList;
import java.util.Collections;
/*
 * This is the group class.
 * It has fields for its properties like name,country
 * ArrayList<String> hobbies is a list which stores hobbies of the group
 * ArrayList<User> members is a list which stores users of the group
 * ArrayList<Post> posts is a list which stores posts of the group
 *  every group has a suggestPoint for a choosen user
	 suggestPoint is related to the common hobbies and the country of the user and group
 * 
 */
public class Group implements  Comparable<Group>{
	String name;
	String country;
	ArrayList<String> hobbies;
	ArrayList<Post> posts;
	ArrayList<User> members;
	
	User creator;
	public Integer suggestPoint;
	public ArrayList<Group> suggesteds;
	public Group(String name, String country, ArrayList<String> hobbies, ArrayList<Post> posts, ArrayList<User> members,
			User creator) {
		
		this.name = name;
		this.country = country;
		this.hobbies = hobbies;
		this.posts = posts;
		this.members = members;
		this.creator = creator;
		/*
		 * When group is created, it is automatically being added to MainPage.grouplist where all of the groups stored
		 */
		MainPage.grouplist.add(this);
		members=new ArrayList<User>();
		posts=new ArrayList<Post>();
		hobbies=new ArrayList<String>();
	}
	
	@Override
	public String toString() {
		System.out.println("Group [name=" + name + ", country=" + country+", creator="+this.creator.username+"]");
		System.out.println("Hobbies:");
		for(String i: hobbies) {
			System.out.println(i);
		}
		
		for(User b: members) {
			System.out.println(b.username);
		}
		return "1";
	}
	public ArrayList<Group> sortGr(ArrayList<Group> g){
		/*
		 * This method is for suggesting groups.
		 * It uses ArrayList which it comes from User Class's public ArrayList<Group> suggest() method.
		 * It sorts the list and reverses it
		
		 *  
		 */
		Collections.sort(g);
		Collections.reverse(g);
		/*for(Group a: g) {
			System.out.println(a.name+" "+a.suggestPoint);
		}*/
		return g;
	}
/*
 * compareTo it is comparing groups by suggestion points
 */
	@Override
	public int compareTo(Group g) {
		// TODO Auto-generated method stub
		
		return this.suggestPoint.compareTo(g.suggestPoint);
	}
	
}
