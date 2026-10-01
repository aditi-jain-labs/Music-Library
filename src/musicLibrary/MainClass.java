package musicLibrary;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/*
 * @author Aditi Jain
 * @dateCreated 19/10/2023
 * OOPs Project
 */

public class MainClass {

	/**
	 * @param args
	 * @throws FileNotFoundException
	 */
	public static void main(String[] args) throws FileNotFoundException {
		
		
		FileOutputStream outputFile = new FileOutputStream("src/resources/myOutputs.txt");
		PrintWriter writeFile = new PrintWriter(outputFile);
		
		
		// Reading Artist File
			Scanner sc = new Scanner(new FileReader("src/resources/artists.txt"));
			
			Map<String, Artist> artistMap = new HashMap<>();
			
			while(sc.hasNextLine()) {
				String[] artistInfo = sc.nextLine().split("-");
				Artist artist = new Artist();
				artist.setArtistName(artistInfo[1]);
				artist.setBandMemberships(List.of(artistInfo[2].split(",")));
				artistMap.put(artistInfo[0], artist);
			}
			
		//Reading Music Tracks file
		  sc = new Scanner(new FileReader("src/resources/music_tracks.txt"));
			
			Map<String, MusicTrack> musicMap = new HashMap<>();
			
			
			while(sc.hasNextLine()) {
				String[] trackInfo = sc.nextLine().split("-");
				String[] guestArtistsIds=trackInfo[3].split(",");
				List<Artist> guestArtistsList= new ArrayList<Artist>();
				for (int i=0;i<guestArtistsIds.length;i++) {
					guestArtistsList.add(artistMap.get(guestArtistsIds[i]));
				}
				//calling constructor to create music track object
				MusicTrack mTrack = new MusicTrack(trackInfo[1], artistMap.get(trackInfo[2]), guestArtistsList,
						parseDate(trackInfo[4]), Double.valueOf(trackInfo[5]), Integer.parseInt(trackInfo[6]),
						trackInfo[7], Double.valueOf(trackInfo[8]));
				musicMap.put(trackInfo[0], mTrack);	
			}
			
		//Reading Albums File	
			sc = new Scanner(new FileReader("src/resources/albums.txt"));
			
			Map<String, Album> albumMap = new HashMap<>();
			
			
			while(sc.hasNextLine()) {
				String[] albumInfo = sc.nextLine().split("-");
				String[] trackIds=albumInfo[1].split(",");
				List<MusicTrack> tracksList= new ArrayList<MusicTrack>();
				for (int i=0;i<trackIds.length;i++) {
					tracksList.add(musicMap.get(trackIds[i]));
					
				}
				//calling constructor to create album object
				Album albumObj = new Album(tracksList, albumInfo[2], albumInfo[3], artistMap.get(albumInfo[4]));
				albumMap.put(albumInfo[0],albumObj);		
			}
			
			
	//Testing Artist class methods
	    	writeFile.println("Artist Name   | \t Band Memberships");	
	    	writeFile.println(artistMap.get("10").getArtistName() + "  | \t " + artistMap.get("10").getBandMemberships());
			//System.out.println(artistMap.get("10").getBandMemberships());		
			artistMap.get("10").setArtistName("Miley Cyrus");
			artistMap.get("10").setBandMemberships(List.of("Hanna Montana"));
			writeFile.println("Updated artist after Setter Methods: ");
			writeFile.println(artistMap.get("10").getArtistName() + "   | \t " + artistMap.get("10").getBandMemberships());
		
	
	//Testing MusicTrack class methods
			writeFile.println("\n -------------Now turn for Music Tracks---------------------");
			writeFile.println("Title  | \t Main Artist | \t  Rating  |  \t Location  | \t Play Count  | \t Duration  | \t Date  | \t GuestArtists");
			writeFile.println(musicMap.get("7").getTitle() +"  | \t "+musicMap.get("7").getArtist() + "  | \t" + musicMap.get("7").getRating() + "  | \t" + musicMap.get("7").getLocation() + "  | \t" + musicMap.get("7").getPlayCount() + "  | \t" + musicMap.get("7").getLength() + "  | \t" + musicMap.get("7").getDate() +"  | \t" + musicMap.get("7").getGuestArtists());
			writeFile.println("Names of All Artists: " + musicMap.get("7").getAllArtists());
			writeFile.println("Play the track - Updated Play Count:  "+ musicMap.get("7").incrementPlayCount());
			
		//Testing Album Class
			writeFile.println("\n -----------Now Turn for Albums--------------");
			writeFile.println(albumMap.get("1"));
			
	//creating MusicLibrary object
			List<Album> listAlbum = new ArrayList<>();
			for (int i=1; i<albumMap.size();i++) {
				listAlbum.add(albumMap.get(String.valueOf(i)));
			}
			List<MusicTrack> listTracks = new ArrayList<MusicTrack>();
			for (int i=1; i<musicMap.size();i++) {
				listTracks.add(musicMap.get(String.valueOf(i)));
			}
			MusicLibrary myLibrary = new MusicLibrary(listAlbum, listTracks);
			//Testing music library methods
			writeFile.println("\n--------------Now Turn for MusicLibrary----------------");
			writeFile.println(myLibrary.getAllAlbums());
			writeFile.println(myLibrary.getAllTracks());
			//Extension Problem 2
			writeFile.println("Number of discs required to backup all tracks: "+ myLibrary.backupMusicTracks(10) );
//			
			
			
			
	//Reading Compilation Album Input file
			sc = new Scanner(new FileReader("src/resources/compilationAlbum.txt"));
			Map<String, CompilationAlbum> cAlbumMap = new HashMap<>();
			Map<MusicTrack, String> musicAndAlbumMap = new HashMap<>();
			while(sc.hasNextLine()) {
				String[] cAlbumInfo = sc.nextLine().split("-");
				String[] cTrackIds = cAlbumInfo[1].split(",");
				String[] cAlbumIds = cAlbumInfo[2].split(",");
				String[] cArtistIds= cAlbumInfo[5].split(",");
				List<Artist> cArtistIdList= new ArrayList<Artist>();
				for (int i=0;i<cArtistIds.length;i++) {
					cArtistIdList.add(artistMap.get(cArtistIds[i]));
				}
				for (int i=0; i<cTrackIds.length;i++) {
					if (albumMap.get(cAlbumIds[i]) != null) {
					musicAndAlbumMap.put(musicMap.get(cTrackIds[i]), albumMap.get(cAlbumIds[i]).getAlbumName());
					} else  
					musicAndAlbumMap.put(musicMap.get(cTrackIds[i]), null);
				}
				
				CompilationAlbum cAlbumObj = new CompilationAlbum(musicAndAlbumMap, cAlbumInfo[3], cAlbumInfo[4], cArtistIdList);
				cAlbumMap.put(cAlbumInfo[0], cAlbumObj);
			}
			writeFile.println("\n -------Compilation Album-----------");
			writeFile.println("Compilation Album - calling album class methods : " + cAlbumMap.get("1").getAlbumName());
			writeFile.println("Compilation Album Music Tracks with Original Artist:  " + cAlbumMap.get("1").getMusicAndAlbumMap());
//			writeFile.println("Compilation Album Object " + cAlbumMap.get("1").getMusicAndAlbumMap());
			writeFile.close();
	}
	
	
	
	public static Date parseDate(String date) {
		try {
			return new SimpleDateFormat("dd/MM/yyyy").parse(date);
		} catch (Exception e) {
			return null;
		}
	}

}
