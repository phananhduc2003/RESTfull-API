package com.in28minutes.rest.webservices.restful_web_services.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.in28minutes.rest.webservices.restful_web_services.user.Post;

// repository(kho luu tru) noi cung cap cac phuong thuc de thuc hien cac thao tac CRUD
public interface PostRepository extends JpaRepository<Post, Integer> {

}
