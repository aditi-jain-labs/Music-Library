package musicLibrary;

import java.util.*;

public class Artist {

	/*
	 * Defining artist's name and list of all bands they are part of
	 */
	private String artistName;
	private List<String> bandMemberships;
	
	//Method to get the artist name
	/**
	 * @return String
	 */
	public String getArtistName() {
		return artistName;
	}
	
	/*
	 * Method to set artists name, 
	 * pass the artist's name as a string through the arguments
	 */
	
	public void setArtistName(String artistName) {
		this.artistName = artistName;
	}
	
	//Method to get list of bands the artist if part of 
	public List<String> getBandMemberships() {
		return bandMemberships;
	}
	
	/*
	 * Method to set a list of bands a artist is member of, 
	 * pass in the arguments a list of strings containing band names
	 */
	public void setBandMemberships(List<String> bandMemberships) {
		this.bandMemberships = bandMemberships;
	}
	
	/*
	 * this lets the program print the object data
	 */
	@Override
	public String toString() {
		return "Artist Name: "+artistName + "\t Band Memberships: " + bandMemberships+"]";
	} 
	
	
	
}

