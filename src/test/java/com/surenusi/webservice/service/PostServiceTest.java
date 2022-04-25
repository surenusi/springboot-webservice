package com.surenusi.webservice.service;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.surenusi.dto.posts.PostsSaveRequestDto;
import com.surenusi.webservice.domain.posts.Posts;
import com.surenusi.webservice.domain.posts.PostsRepository;

@SpringBootTest
public class PostServiceTest {
	
	@Autowired
	private PostsService postService;
	
	@Autowired
	private PostsRepository postRepository;
	
	@AfterEach
	public void cleanup() {
		postRepository.deleteAll();
	}
	
	@Test
	public void saveDtoDataToPostRepository() {
		//given
		PostsSaveRequestDto dto = PostsSaveRequestDto.builder()
				.title("Test title")
				.content("Test content")
				.author("Test author")
				.build();
		
		//when
		postService.save(dto);
		
		//then
		Posts posts = postRepository.findAll().get(0);
		assertThat(posts.getAuthor()).isEqualTo("Test author");
		assertThat(posts.getContent()).isEqualTo("Test content");
		assertThat(posts.getTitle()).isEqualTo("Test title");
		
	}
}
