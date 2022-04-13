package com.surenusi.webservice.domain.posts;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.surenusi.webservice.domain.BaseTimeEntity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @NoArgsConstructor : 기본 생성자를 자동으로 추가
 * 	access = AccessLevel.PROTECTED : 기본생성자의 접근 권한을 protected로 제한
 *	@NoArgsConstructor(access = AccessLevel.PROTECTED) = protected Posts() {}
 *	@author NUSI
 *
 */	
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity //DB의 테이블과 링크될 클래스를 의미
public class Posts extends BaseTimeEntity {
	
	@Id //테이블의 PK필드를 나타냄
	@GeneratedValue //PK의 생성규칙을 나타냄. 기본값은 AUTO로, MySQL의 auto_increament와 같이 자동증가하는 정수형 값이 됨
	private long id;
	
	/**
	 * 굳이 선언하지 않더라도 해당 클래스의 필드는 모두 컬럼이 됨
	 * 사용하는 경우는 기본값 외에 추가로 변경이 필요한 경우
	 */
	@Column(length = 500, nullable = false)
	private String title;
	
	@Column(columnDefinition = "TEXT", nullable = false)
	private String content;
	
	private String author;
	
	/**
	 * 무분별한 Setter 메소드 사용은 비권장
	 * 기본생성자도 AccessLevel.PROTECTED로 제한 되어 있기 때문에
	 * 해당이벤트에 맞는 public 메소드를 호출하여 변경하는 것이 전제됨
	 * 기본 생성자보다 가독성 및 개발자의 실수를 줄일 수 있는 Builder패턴을 사용 
	 */
	@Builder
	public Posts(String title, String content, String author) {
		this.title = title;
		this.content = content;
		this.author = author;
	}
}
