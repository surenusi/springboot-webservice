package com.surenusi.webservice.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.surenusi.dto.posts.PostsMainResponseDto;
import com.surenusi.dto.posts.PostsSaveRequestDto;
import com.surenusi.webservice.domain.posts.PostsRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class PostsService {
	
	private final PostsRepository postsRepository;
	
	@Transactional
	/**
	 * DB데이터에 접근하는 Service클래스는 트랜잭션이 발생하므로
	 * @Transactional 어노테이션을 필수로 가져감
	 * Exception이 발생할 때의 Rollback등의 중요한 작업을 담당
	 */
	public Long save(PostsSaveRequestDto dto) {
		/**
		 * Controller에서 dto.toEntity를 통해서 Service에 바로 전달하지 않는 이유는 
		 * 비즈니스 로직과 트랜잭션 관리를 Service에서 View에 대한 처리는 Controller에서 담당하도록 구성하기 위함
		 * 즉, Controller와 Service의 역할을 분리하기 위함
		 */
		return postsRepository.save(dto.toEntity()).getId();
	}
	
	@Transactional(readOnly = true)
	public List<PostsMainResponseDto> findAllDesc() {
		return postsRepository.findByOrderByIdDesc()
				.map(PostsMainResponseDto::new)
				.collect(Collectors.toList());
	}

}
