package MusicProject.Music;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import MusicProject.Music.domain.Music;
import MusicProject.Music.domain.MusicRepository;



  
	@ExtendWith(SpringExtension.class)  
	@DataJpaTest
	public class MusicRepositoryTests {

	    @Autowired
	    private MusicRepository mrepository;

	    @Test  // testataan MusicRepositoryn findByArtist()-metodin toimivuutta
	    public void findByArtistShouldReturnArtist() {
	        List<Music> musics = mrepository.findByArtist("Tuisku");
	        
	        assertThat(musics).hasSize(1);
	        assertThat(musics.get(0).getArtist()).isEqualTo("Antti");
	    }
	    
	    @Test // testataan MusicRepositoryn save()-metodin toimivuutta
	    public void createNewMusic() {
	    	Music music = new Music("Ed Sheeran", "Shivers", 2020, null);
	    	mrepository.save(music);
	    	assertThat(music.getMusicId()).isNotNull();
	    }    

	}
