package MusicProject.Music.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class Genre {
	  @Id
	    @GeneratedValue(strategy=GenerationType.AUTO)
		public Long genreId;
		public String name;
		
		
		@OneToMany(cascade = CascadeType.ALL, mappedBy = "Genre")
		private List<Music> musics;
		
		public Genre() {}
		
		public Genre(String name) {
			super();
			this.name = name;
		}

		public Long getGenreId() {
			return genreId;
		}

		public void setGenreId(Long genreId) {
			this.genreId = genreId;
		}

		public String getName() {
			return name;
		}
		
		public void setName(String name) {
			this.name = name;
		}
		
		public List<Music> getMusics() {
			return musics;
		}

		public void setMusics(List<Music> musics) {
			this.musics = musics;
		}
		
		@Override
		public String toString() {
	 
			return "Genre [genreId=" + genreId + ", name=" + name + "]";
}
}
