package musicLibrary;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CompilationAlbum extends Album {
	
	
	private List<Artist> albumArtistList;
	private Map<MusicTrack, String> musicAndAlbumMap;

	
	/**
	 * @param musicAndAlbumMap
	 * @param albumName
	 * @param albumType
	 * @param albumArtistList
	 */
	public CompilationAlbum(Map<MusicTrack, String> musicAndAlbumMap, String albumName, String albumType, List<Artist> albumArtistList) {
		super(new ArrayList<MusicTrack>(musicAndAlbumMap.keySet()), albumName, albumType, null);
		this.musicAndAlbumMap = musicAndAlbumMap;
		this.albumArtistList = albumArtistList;
	}

	
	//Method to get the artist list for compilation album
	public List<Artist> getAlbumArtistList() {
		return albumArtistList;
	}
	/**
	 * @param albumArtistList
	 * Method to update the artist list 
	 */
	public void setAlbumArtistList(List<Artist> albumArtistList) {
		this.albumArtistList = albumArtistList;
	}

	//Method to get the music tracks and albums map 	
	public Map<MusicTrack, String> getMusicAndAlbumMap() {
		return musicAndAlbumMap;
	}

	// Method to update music track and album
	public void setMusicAndAlbumMap(Map<MusicTrack, String> musicAndAlbumMap) {
		this.musicAndAlbumMap = musicAndAlbumMap;
	}
	
	

}
