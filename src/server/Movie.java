package server;

import com.sun.prism.Image;


public class Movie {
String title;
String pgRating;
String description;
Image poster;



public Movie(String title, String pgRating, String description, Image image) {
	super();
	this.title = title;
	this.pgRating = pgRating;
	this.description = description;
	this.poster = image;
}
//getter and setter
public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}
public String getPgRating() {
	return pgRating;
}
public void setPgRating(String pgRating) {
	this.pgRating = pgRating;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
public Image getPoster() {
	return poster;
}
public void setPoster(Image poster) {
	this.poster = poster;
}
	
}
