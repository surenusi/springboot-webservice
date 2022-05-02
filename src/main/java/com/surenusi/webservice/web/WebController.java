package com.surenusi.webservice.web;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.surenusi.webservice.service.PostsService;

@Controller
@RequiredArgsConstructor
public class WebController {
	
	private final PostsService postsService;
    /**
     * handlerbars-spring-boot-starter 덕분에 컨트롤러에서 문자열을 반환할 때, 
     * 앞의 path와 뒤의 파일 확장자는 자동으로 지정 (prefix : src/main/resources/templates, suffix : .hbs)
     * 해당 메소드는 src/main/resources/templates/main.hbs로 전환되어 View Resolver가 처리
     */
    @GetMapping("/") // = @RequestMapping(value="/", method = RequestMethod.GET)
    public String main(Model model) {
    	model.addAttribute("posts", postsService.findAllDesc());
        return "main";
    }
}
