package MusicProject.Music.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;



@Entity
public class Music {
	 @Id
	 @GeneratedValue(strategy=GenerationType.AUTO)
	 public Long musicId;
	 @NotNull
	 @Size(min=2, max=30)
	 public String artist;
	 
	 @NotNull
	 @Size(min=1, max=30)
	 public String song;
	 
	 @NotNull
	 public int year;
	 
	 
	 @ManyToOne
	   @JsonIgnoreProperties ("musics") 
	   @JoinColumn(name = "genreId")
	   private Genre genre;
	 
	 public Music() {}
	 
	 public Music(String artist, String song, int year, Genre genre) {
		 super();
		 this.artist = artist;
		 this.song = song;
		 this.year = year;
		 this.genre = genre;
	}
	public Long getMusicId() {
		return musicId;
	}

	public void setMusicId(Long id) {
		this.musicId = id;
	}
	
	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}
	
	public String getSong() {
		return song;
	}

	public void setSong(String song) {
		this.song = song;
	}
	
	public int getYear() {
		return year;
	}
	
	public void setYear(int year) {
		this.year = year;
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
		return "Music [musicId=" + musicId + ", Artist=" + artist + ", Song=" + song + ", Year=" + year + "Genre=" + this.getGenre() + "]";
		else 
			return "Music [musicId=" + musicId + ", Artist=" + artist + ", Song=" + song + ", Year=" + year + "]";
			
	 
	 
	 
}

	
}