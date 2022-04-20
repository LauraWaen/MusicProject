package MusicProject.Music.web;



import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import MusicProject.Music.domain.GenreRepository;
import MusicProject.Music.domain.Message;
import MusicProject.Music.domain.Music;
import MusicProject.Music.domain.MusicRepository;


@Controller
public class MusicController {
	
	@Autowired
	private MusicRepository mrepository;
	
	 @Autowired
	 private GenreRepository grepository;
	
	
 //sisäänkirjautumimen
	 @RequestMapping(value="/login")
	 public String login() {	
	     return "login";
	 }	

	
	 //Näyttää musiikkilistan
		
	 @RequestMapping(value="/musiclist")
	 	public String bookList(Model model) {
	 	model.addAttribute("musics", mrepository.findAll());
	 			return "musiclist";
	 		}
	 //Hakukenttä
	@RequestMapping(value ="musiclist", method=RequestMethod.GET)
	public String musics(Model model, @Param("keyword") String keyword) {
		if (keyword != null) {
			model.addAttribute("musics", mrepository.findByArtist(keyword));
			model.addAttribute("musics", mrepository.findBySong(keyword));
			
			return "music";
		}
			model.addAttribute("musics", mrepository.findAll());
			return "music";
	}
	
	 //Rest rajapinnat
 @RequestMapping(value="/musics", method = RequestMethod.GET)
 public @ResponseBody List<Music> musicListRest() {    
     return (List<Music>) mrepository.findAll();
 }  
 
 @RequestMapping(value="/musics/{id}", method = RequestMethod.GET)
 public @ResponseBody Optional<Music> findMusicRest(@PathVariable("id") Long musicId) {    
     return mrepository.findById(musicId);
 } 
 
 @RequestMapping(value="/musics", method = RequestMethod.POST)
 public @ResponseBody Music saveMusicRest(@RequestBody Music music) {    
     return mrepository.save(music);
 }
 //Näyttää kirjan lisäys näkymän
@RequestMapping(value = "/addmusic", method = RequestMethod.GET)
public String addMusic(Model model){
	model.addAttribute("music", new Music());
	model.addAttribute("genres", grepository.findAll());
    return "addmusic";
}  

//Tallentaa uuden musiikin
@RequestMapping(value = "/save", method = RequestMethod.POST)
public String saveMusic(Music music){
  mrepository.save(music);
    return "redirect:/musiclist";
}   

//Poistaa musiikin jos on kirjautunut admin käyttäjänä
@PreAuthorize("hasAuthority('ADMIN')")
@RequestMapping(value = "/deletemusic/{id}", method = RequestMethod.GET)
public String deleteMusic(@PathVariable("id") Long musicId, Model model) {
	mrepository.deleteById(musicId);
    return "redirect:../musiclist";
   
}
//Näyttää kirjan muokkaus näkymän

@RequestMapping(value="edit/{id}", method = RequestMethod.GET)
public String editMusic(@PathVariable("id") Long musicId, Model model) {
	Optional<Music> music = mrepository.findById(musicId);
	model.addAttribute("music", music);
	model.addAttribute("genres", grepository.findAll());
	return "editmusic";
}

} 
	 
	 
