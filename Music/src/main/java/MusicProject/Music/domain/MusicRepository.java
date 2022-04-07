package MusicProject.Music.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;



public interface MusicRepository extends CrudRepository<Music, Long> {
	
	 List<Music> findByMusicId(Long musicId);
	
}
