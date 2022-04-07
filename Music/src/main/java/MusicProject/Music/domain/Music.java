package MusicProject.Music.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;




@Entity
public class Music {
	 @Id
	 @GeneratedValue(strategy=GenerationType.AUTO)
	 public Long musicId;
	 public String Artist;
	 public String Song;
	 public String Genre;
	 public int Year;
	 
	
	 
	 public Music() {}
	 
	 public Music(String Artist, String Song, String Genre, int Year) {
		 super();
		 this.Artist = Artist;
		 this.Song = Song;
		 this.Genre = Genre;
		 this.Year = Year;
	}
	public Long getId() {
		return musicId;
	}

	public void setId(Long id) {
		this.musicId = id;
	}
	
	public String getArtist() {
		return Artist;
	}

	public void setArtist(String artist) {
		Artist = artist;
	}
	
	public String getSong() {
		return Song;
	}

	public void setSong(String song) {
		Song = song;
	}

	public String getGenre() {
		return Genre;
	}

	public void setGenre(String genre) {
		this.Genre = genre;
	}
	
	public int getYear() {
		return Year;
	}
	
	public void setYear(int year) {
		Year = year;
	}
	 
	@Override
	public String toString() {
		return "Music [musicId=" + musicId + ", Artist=" + Artist + ", Song=" + Song + ", Genre=" + Genre + ", Year=" + Year +"]";

	 
	 
	 
}

	
}