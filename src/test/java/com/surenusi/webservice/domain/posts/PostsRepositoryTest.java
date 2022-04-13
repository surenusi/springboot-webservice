package com.surenusi.webservice.domain.posts;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDateTime;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PostsRepositoryTest {
	
	@Autowired
	PostsRepository postsRepository;
	public void cleanup() {
		/**
		 * 이후 테스트 코드에 영향을 미치지 않기 위해
		 * 테스트 메소드가 끝날때 마다 repository 전체를 비우는 코드
		 */
		postsRepository.deleteAll();
	}
	
	@Test
	public void postsSaveAndLoad() {
		//given
		LocalDateTime now = LocalDateTime.now();
		postsRepository.save(Posts.builder()
				.title("테스트 제목")
				.content("테스트 내용")
				.author("surenusi@gmail.com")
				.build());
		
		//when
		List<Posts> postsList = postsRepository.findAll();
		
		//then
		Posts posts = postsList.get(0);
		assertThat(posts.getTitle()).isEqualTo("테스트 제목");
		assertThat(posts.getContent()).isEqualTo("테스트 내용");
		assertThat(posts.getCreatedDate()).isAfter(now);
		assertThat(posts.getModifiedDate()).isAfter(now);
	}
}
