package musicLibrary;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MusicLibrary {
	
	private List<Album> allAlbums;
	private List<MusicTrack> allTracks;
	
	/**
	 * Constructor to create a music library 
	 * @param allAlbums
	 * @param allTracks
	 */
	public  MusicLibrary(List<Album> allAlbums, List<MusicTrack> allTracks) {
		this.allAlbums=allAlbums;
		this.allTracks=allTracks;
	}


	public List<Album> getAllAlbums() {
		return allAlbums;
	}

	//method to get all tracks including tracks in albums and singles
	public List<MusicTrack> getAllTracks() {
		List<MusicTrack> allTracksInLibrary = allTracks;
		for (int i = 0; i < allAlbums.size(); i++) {
			allTracksInLibrary.addAll(allAlbums.get(i).getTrackList());
		}
		return allTracksInLibrary;
	}

	// method to add a list of tracks to the library
	public void addMultipleTracks(List<MusicTrack> newTracks) {
		List<MusicTrack> oldTracksList = getAllTracks();
		oldTracksList.addAll(newTracks);
		allTracks = oldTracksList;
	}
	
	//Method to add a single track to the library
	public void addTrack(MusicTrack newTrack) {
		List<MusicTrack> oldTracksList = getAllTracks();
		oldTracksList.add(newTrack);
		allTracks = oldTracksList;
	}
	
	//Method to add album(s) to the library
	public void addAlbums(List<Album> newAlbums) {
		allAlbums.addAll(newAlbums);
	}
	
	//Method to get the list of tracks with lowest rating
	public List<MusicTrack> getTracksWithLowestRating(){
		List<MusicTrack> allTracksInLibrary = getAllTracks();
		//Sorting the tracks based on lowest to highest rating
		allTracksInLibrary.sort(new Comparator<MusicTrack>() {

			@Override
			public int compare(MusicTrack o1, MusicTrack o2) {
				return Double.compare(o1.getRating(), o2.getRating());
			}
			
		});
		double minRating = allTracksInLibrary.get(0).getRating();
		
		int j=0;
		List<MusicTrack> lowestRatedTracks = new ArrayList<>();
		//getting list of all tracks with rating equivalent to the first track in sorted list
		while (allTracksInLibrary.get(j).getRating() == minRating) {
			lowestRatedTracks.add(allTracksInLibrary.get(j));
			j++;
		}
		return lowestRatedTracks;
		
	}
	
	public int backupMusicTracks(int discSpace) {
		List<MusicTrack> tracks = getAllTracks();
	
		int numOfTracks = tracks.size();
		int discCount = 0;
		double remSpace = discSpace;
		for (int i=0; i<numOfTracks; i++) {
			double trackSize = tracks.get(i).getSize();
			if ( trackSize >remSpace) {
				discCount++;
				remSpace = discSpace - trackSize;
			}
			else
				remSpace -= trackSize;
		}
		return discCount;
		
	
	}


	@Override
	public String toString() {
		return "Albums: " + allAlbums + "\t Music Tracks=" + allTracks + "]";
	}
	
	
	

}
