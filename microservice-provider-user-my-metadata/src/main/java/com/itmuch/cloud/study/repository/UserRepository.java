package com.itmuch.cloud.study.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.itmuch.cloud.study.entity.User;

/**
 * 用户
 *
 * @Author sunk
 * @Date 2022/2/18
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
