package MusicProject.Music.web;



import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import MusicProject.Music.domain.GenreRepository;
import MusicProject.Music.domain.Music;
import MusicProject.Music.domain.MusicRepository;


@Controller
public class MusicController {
	
	@Autowired
	private MusicRepository mrepository;
	
	 @Autowired
	 private GenreRepository grepository;

	 
	 /*@RequestMapping(value="/login")
	 public String login() {	
	     return "login";
	 }	*/

 @RequestMapping(value="/musics", method = RequestMethod.GET)
	public String musics(Model model) {
	model.addAttribute("musics", mrepository.findAll());
				return "Music"; //Music.html
			}
	 

@RequestMapping(value = "/addmusic", method = RequestMethod.GET)
public String addMusic(Model model){
	model.addAttribute("music", new Music());
	model.addAttribute("genres", grepository.findAll());
    return "addmusic";
}  
@RequestMapping(value="edit/{id}", method = RequestMethod.GET)
public String editMusic(@PathVariable("id") Long musicId, Model model) {
	Optional<Music> music = mrepository.findById(musicId);
	model.addAttribute("music", music);
	model.addAttribute("genres", grepository.findAll());
	return "editmusic";
}

@RequestMapping(value = "/save", method = RequestMethod.POST)
public String saveMusic(Music music){
  mrepository.save(music);
    return "redirect:/musics";
}   


@RequestMapping(value = "/deletemusic/{id}", method = RequestMethod.GET)
public String deleteMusic(@PathVariable("id") Long musicId, Model model) {
	mrepository.deleteById(musicId);
    return "redirect:../musics";
   
}

} 
	 
	 
