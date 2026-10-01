package musicLibrary;

import java.util.List;

public class Album {
	
	
	private List<MusicTrack> trackList;
	private String albumName;
	private String albumType;
	private Artist albumArtist;
	
	/*
	 * Constructor for album class
	 * this is used to create a new album, 
	 * by passing in all required arguments in the method parameters below
	 */
	public Album(List<MusicTrack> trackList, String albumName, String albumType, Artist albumArtist) {
		this.trackList = trackList;
		this.albumName = albumName;
		this.albumType = albumType;
		this.albumArtist = albumArtist;
	}
	

	//Get the Albums artist
	public Artist getAlbumArtist() {
		return albumArtist;
	}

	//Update the Album Artist
	public void setAlbumArtist(Artist albumArtist) {
		this.albumArtist = albumArtist;
	}
	
	//Get list of music tracks in album
	public List<MusicTrack> getTrackList() {
		return trackList;
	}
	
	//Update list of music tracks in album
	public void setTrackList(List<MusicTrack> trackList) {
		this.trackList = trackList;
	}
	
	//Get the album name
	public String getAlbumName() {
		return albumName;
	}
	
	//Update the album name
	public void setAlbumName(String albumName) {
		this.albumName = albumName;
	}
	
	//Get the type of album
	public String getAlbumType() {
		return albumType;
	}
	
	//Update Album type
	public void setAlbumType(String albumType) {
		this.albumType = albumType;
	}
	
	//Calculate duration of album by adding duration of all music tracks
	public float getAlbumDuration() {
		float albumDuration=0;
		for(int i=0;i<trackList.size();i++) {
			albumDuration += trackList.get(i).getLength();
		}
		return albumDuration;
	}
	
	//Get size of album by adding sizes of all music tracks
	public int getAlbumSize() {
		int albumSize = 0;
		for(int i=0;i<trackList.size();i++) {
			albumSize += trackList.get(i).getSize();
		}
		return albumSize;
	}
	
	//Calculate Average Rating by  using individual ratings of all tracks in the album
	public float getAvgRating() {
		int avgRating = 0;
		for(int i=0;i<trackList.size();i++) {
			avgRating += trackList.get(i).getRating();
			
		}
		return avgRating/trackList.size();
	}
	
	
	/*
	 * this lets the program print the object data
	 */
	@Override
	public String toString() {
		return "Album Name: " + albumName + "\t Album Type: " + albumType
				+ "\t Album Artist: " + albumArtist +"\t Track List: "+trackList  +"]";
	}

	

}
