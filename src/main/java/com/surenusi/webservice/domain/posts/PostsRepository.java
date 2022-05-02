package com.surenusi.webservice.domain.posts;

import java.util.stream.Stream;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


/**
 * DB Layer 접근자
 * DAO와 같은 역할을 수행함
 * @Repository <- 추가할 필요가 없다 왜? 머하는 놈이고 -> JpaRepository를 extends 했기 때문에
 * @author NUSI
 *
 */
public interface PostsRepository extends JpaRepository<Posts, Long> {
	
	//JPA에서 제공하지 않는 메소드는 @Query를 통해 작성할 수 있다.
	//실무에서 복잡한 쿼리는 Mybatis등의 SQL Mapper로 구현하는 것이 좋다.
	@Query("SELECT p FROM Posts p ORDER BY p.id DESC")
	Stream<Posts> selectAllOrderByIdDesc();
	
    Stream<Posts> findByOrderByIdDesc();
}
