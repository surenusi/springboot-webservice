package com.surenusi.webservice.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * DB Layer 접근자
 * DAO와 같은 역할을 수행함
 * @Repository <- 추가할 필요가 없다 왜? 머하는 놈이고 -> JpaRepository를 extends 했기 때문에
 * @author NUSI
 *
 */
public interface PostsRepository extends JpaRepository<Posts, Long> {

}
