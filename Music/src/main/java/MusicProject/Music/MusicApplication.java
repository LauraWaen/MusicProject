package MusicProject.Music;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


import MusicProject.Music.domain.Genre;
import MusicProject.Music.domain.GenreRepository;
import MusicProject.Music.domain.Music;
import MusicProject.Music.domain.MusicRepository;
import MusicProject.Music.domain.UserRepository;


@SpringBootApplication
public class MusicApplication {
	private static final Logger log = LoggerFactory.getLogger(MusicApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(MusicApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner musicDemo(MusicRepository mrepository, GenreRepository grepository, UserRepository urepository) {
		return (args) -> {
			
			log.info("lisää musiikkia");
	
			
			Genre genre1 = new Genre("Pop");
			grepository.save(genre1);
			Genre genre2 = new Genre("Rap");
			grepository.save(genre2);
			Genre genre3 = new Genre("Electronic");
			grepository.save(genre3);
			Genre genre4 = new Genre("HipHop");
			grepository.save(genre4);
			Genre genre5 = new Genre("Jazz");
			grepository.save(genre5);
			Genre genre6 = new Genre("Latin");
			grepository.save(genre6);
			Genre genre7 = new Genre("Reggae");
			grepository.save(genre7);
			Genre genre8 = new Genre("Rock");
			grepository.save(genre8);
			Genre genre9 = new Genre("Soul and R&B");
			grepository.save(genre9);
			Genre genre10 = new Genre("Country");
			grepository.save(genre10);
			
			mrepository.save(new Music("Abreu", "20 Ave Mariaa", 2020, genre1));
			mrepository.save(new Music("JVG", "Tarkenee", 2017, genre1));
		
			
			log.info("Get Music");
			for (Music music : mrepository.findAll()) {
				log.info(music.toString());
			}
		};
	}
	
	
}