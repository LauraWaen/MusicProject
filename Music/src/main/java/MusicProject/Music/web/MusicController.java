package MusicProject.Music.web;



import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import MusicProject.Music.domain.Music;
import MusicProject.Music.domain.MusicRepository;


@Controller
public class MusicController {
	
	@Autowired
	private MusicRepository mrepository;
	

	 

 @RequestMapping(value="/musics", method = RequestMethod.GET)
	public String musics(Model model) {
	model.addAttribute("musics", mrepository.findAll());
				return "Music"; //Music.html
			}
	 

@RequestMapping(value = "/addmusic", method = RequestMethod.GET)
public String addMusic(Model model){
	model.addAttribute("music", new Music());
    return "addmusic";
}  

@RequestMapping(value = "/save", method = RequestMethod.POST)
public String saveMusic(Music music){
  mrepository.save(music);
    return "redirect:/musics";
}   



} 
	 
	 
