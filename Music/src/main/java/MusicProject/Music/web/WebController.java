package MusicProject.Music.web;

	import javax.validation.Valid;

	import org.springframework.stereotype.Controller;
	import org.springframework.validation.BindingResult;
	import org.springframework.web.bind.annotation.GetMapping;
	import org.springframework.web.bind.annotation.PostMapping;
	import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
	import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import MusicProject.Music.domain.Music;


	@Controller
	public class WebController implements WebMvcConfigurer {

		@Override
		public void addViewControllers(ViewControllerRegistry registry) {
			registry.addViewController("/results").setViewName("results");
		}

		@GetMapping("/result")
		public String show(Music music) {
			return "result";
		}

		@PostMapping("/musicform")
		public String checkPersonInfo(@Valid Music music, BindingResult bindingResult) {

			if (bindingResult.hasErrors()) {
				return "musicform";
			}

			return "redirect:/musiclist";
		}
	}

