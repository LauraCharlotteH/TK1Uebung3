package server;

public class Movie {
String title;
String pgRating;
String description;



public Movie(String title, String pgRating, String description) {
	super();
	this.title = title;
	this.pgRating = pgRating;
	this.description = description;
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

	
}
