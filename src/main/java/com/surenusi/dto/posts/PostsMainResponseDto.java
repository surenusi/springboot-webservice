package com.surenusi.dto.posts;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

import com.surenusi.webservice.domain.posts.Posts;

import lombok.Getter;

@Getter
public class PostsMainResponseDto {
	
	private Long id;
	private String title;
	private String content;
	private String author;
	private String modifiedDate;
	
	public PostsMainResponseDto(Posts entity) {
		id = entity.getId();
		title = entity.getTitle();
		author = entity.getAuthor();
		content = entity.getContent();
		modifiedDate = toStringDateTime(entity.getModifiedDate());
	}
	
	//View영역에선 LocalDateTime타입을 모르기 때문에 인식할 수 있도록 메소드를 통해 문자열로 변경할 수 있도록 함
	private String toStringDateTime(LocalDateTime localDateTime) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		return Optional.ofNullable(localDateTime)
				.map(formatter::format)
				.orElse("");
	}
}
