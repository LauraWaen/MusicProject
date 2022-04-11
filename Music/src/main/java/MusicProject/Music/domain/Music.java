package MusicProject.Music.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
public class Music {
	 @Id
	 @GeneratedValue(strategy=GenerationType.AUTO)
	 public Long musicId;
	 public String Artist;
	 public String Song;
	 public int Year;
	 
	 @ManyToOne
	   @JsonIgnoreProperties ("musics") 
	   @JoinColumn(name = "genreId")
	   private Genre genre;
	 
	 public Music() {}
	 
	 public Music(String Artist, String Song, int Year, Genre genre) {
		 super();
		 this.Artist = Artist;
		 this.Song = Song;
		 this.Year = Year;
		 this.genre = genre;
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
	
	public int getYear() {
		return Year;
	}
	
	public void setYear(int year) {
		Year = year;
	}
	
	 
	public Genre getGenre() {
		return genre;
	}

	public void setGenre(Genre genre) {
		this.genre = genre;
	}

	@Override
	public String toString() {
		if (this.genre != null)
		return "Music [musicId=" + musicId + ", Artist=" + Artist + ", Song=" + Song + ", Year=" + Year + "Genre=" + this.getGenre() + "]";
		else 
			return "Music [musicId=" + musicId + ", Artist=" + Artist + ", Song=" + Song + ", Year=" + Year + "]";
			
	 
	 
	 
}

	
}