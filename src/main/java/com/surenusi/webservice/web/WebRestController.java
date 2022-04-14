package com.surenusi.webservice.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.surenusi.dto.posts.PostsSaveRequestDto;
import com.surenusi.webservice.domain.posts.PostsRepository;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class WebRestController {
	
	private final PostsRepository postsRepository;
	
	@GetMapping("/hello")
	public String hello() {
		return "HelloWorld";
	}
	
	@PostMapping("/posts")
	public void savePosts(@RequestBody PostsSaveRequestDto dto) {
		postsRepository.save(dto.toEntity());
	}
}
