package com.surenusi.dto.posts;

import com.surenusi.webservice.domain.posts.Posts;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Entity 클래스는 가장 Core하기 때문에
 * DTO클래스를 만들어 View Layer와 DB Layer를 철저하게 분리
 * @author NUSI
 *
 */
@Getter
@Setter
@NoArgsConstructor
public class PostsSaveRequestDto {
	
	private String title;
	private String content;
	private String author;
	
	public Posts toEntity() {
		return Posts.builder()
				.title(title)
				.content(content)
				.author(author)
				.build();
	}
}
