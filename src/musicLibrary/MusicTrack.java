package musicLibrary;

import java.util.*;

public class MusicTrack {

	private String title;
	private Artist artist;
	private Date date;
	private double length;
	private int rating;
	private String location;
	private double size;
	private List<Artist> guestArtists;
	private int playCount;
	
	
	/*
	 * Constructor for music class
	 * this is used to create a new track, 
	 * by passing in all required arguments 
	 */
	public MusicTrack(String title, Artist artist, List<Artist> guestArtists,
			Date date, double length, int rating, String location, double size) {
		this.title = title;
		this.artist = artist;
		this.date = date;
		this.length = length;
		this.rating = rating;
		this.location = location;
		this.size = size;
		this.guestArtists=guestArtists;
	}
	
	// to add to playcount, when a track is played
	public int incrementPlayCount() {
		return ++playCount;
	}
	
	//Method to get current playcount of the track
	public int getPlayCount() {
		return playCount;
	}
	
	//Method to get the title of the music track
	public String getTitle() {
		return title;
	}
	
	//Method to update the title of the music track
	public void setTitle(String title) {
		this.title = title;
	}
	
	//Method to get main artist for the track
	public Artist getArtist() {
		return artist;
	}
	
	//Method to update the main artist of the track
	public void setArtist(Artist artist) {
		this.artist = artist;
	}
	
	//Method to get the date of the music track
	public Date getDate() {
		return date;
	}
	
	//Method to update the date of the music track
	public void setDate(Date date) {
		this.date = date;
	}
	
	//Method to get the length of the music track in minutes
	public double getLength() {
		return length;
	}
	
	//Method to update the length of the music track in minutes
	public void setLength(float length) {
		this.length = length;
	}
	
	//Method to get the rating of the music track out of 5
	public double getRating() {
		return rating;
	}
	
	//Method to update the rating out of 5 of the music track
	public void setRating(int rating) {
		this.rating = rating;
	}
	
	//Method to get the location of the music track in memory
	public String getLocation() {
		return location;
	}
	
	//Method to update the location of the music track in memory
	public void setLocation(String location) {
		this.location = location;
	}
	
	//Method to get the size of the music track
	public double getSize() {
		return size;
	}
	
	//Method to update the size of the music track
	public void setSize(int size) {
		this.size = size;
	}
	
	//Method to get the list of all guest artists of the music track
	public List<Artist> getGuestArtists() {
		return guestArtists;
	}
	
	//Method to update the list of all guest artists of the music track
	public void setGuestArtists(List<Artist> guestArtists) {
		this.guestArtists = guestArtists;
	}
	
	
	/*
	 * get a list of all artists including guest artists and band members
	 */
	public List<String> getAllArtists() {
		try {
			
			List<String> artistNames = new ArrayList<String>();
			//adding main artist name to list
			artistNames.add(artist.getArtistName());
			
			//adding list of artists names to list
			if (!guestArtists.isEmpty()) {
				for (int i = 0; i< guestArtists.size(); i++) {
					artistNames.add(guestArtists.get(i).getArtistName());		
				}
			}
			
			return artistNames;
		} catch (Exception e) {
			return null;
		}
}
			
	/*
	 * this lets the program print the object data
	 */
	@Override
	public String toString() {
		return "Title: " + title + "\t Artist Name: " + artist + "\t Date: " + date + "\t Track Length: " + length
				+ "\t Track Rating: " + rating + "\t Location: " + location + "\t Track Size: " + size + "\t Guest Artists: " + guestArtists
				+ "\t No. of times track has been played: " + playCount + "]";
	}
	
	
	
}



