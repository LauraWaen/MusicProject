package MusicProject.Music;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import MusicProject.Music.domain.Music;
import MusicProject.Music.domain.MusicRepository;

@SpringBootApplication
public class MusicApplication {
	private static final Logger log = LoggerFactory.getLogger(MusicApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(MusicApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner musicDemo(MusicRepository mrepository) {
		return (args) -> {
			
			log.info("lisää musiikkia");
			
			Music music1 = new Music("Abreu","20 Avemariaa","Pop",2020);
			Music music2 = new Music("JVG", "Tarkenee","Pop", 2017);
			
			mrepository.save(music1);
			mrepository.save(music2);
			
			log.info("Get Music");
			for (Music music : mrepository.findAll()) {
				log.info(music.toString());
			}
		};
	}
	
	
}