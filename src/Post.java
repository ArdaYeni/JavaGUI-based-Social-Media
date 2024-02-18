import javax.swing.ImageIcon;

public class Post {
/*
 * This is a class for post
 * Post titles are unique
 * When posts are created , author is being intialzied and adding to the MainPage.postlist
 */
	/* 
	 * title must be unique
	 */
	String title;
	String timeOfCreation;//bunu derste öðrendiðin zamanla birlstir
	User author;
	String text;
	ImageIcon image;
	boolean groupPost;
	Post(String title,String timeOfCreation,User author,String text,ImageIcon image){
		System.out.println("post created");
		this.title=title;
		this.text=title;
		this.timeOfCreation=timeOfCreation;
		this.author=author;
		this.text=text;
		this.image=image;
		this.groupPost=false;
		author.userPost.add(this);
		System.out.println("post"+author.username);
		MainPage.postlist.add(this);
	}
	@Override
	public String toString() {
		System.out.println("Post [title=" + title + ", timeOfCreation=" + timeOfCreation + ", author=" + author.username + ", text=" + text
	 + "]");
		return "";
		
	}
}
