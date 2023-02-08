package com.itmuch.cloud.study.user.controller;

import com.itmuch.cloud.study.user.entity.User;
import com.itmuch.cloud.study.user.feign.UserFeignClient;
import feign.Client;
import feign.Contract;
import feign.Feign;
import feign.auth.BasicAuthRequestInterceptor;
import feign.codec.Decoder;
import feign.codec.Encoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClientsConfiguration;
import org.springframework.context.annotation.Import;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author sunk
 * @Date 2022/2/18
 */
@Import(FeignClientsConfiguration.class)
@RestController
public class MovieController {

	private UserFeignClient userUserFeignClient;

	private UserFeignClient adminUserFeignClient;

	@Autowired
	public MovieController(Decoder decoder, Encoder encoder, Client client, Contract contract) {
		// 这边的decoder、encoder、client、contract，可以Debug看看是什么实例
		this.userUserFeignClient = Feign.builder().client(client).encoder(encoder).decoder(decoder).contract(contract)
				.requestInterceptor(new BasicAuthRequestInterceptor("user", "password1"))
				.target(UserFeignClient.class, "http://microservice-provider-user/");
		this.adminUserFeignClient = Feign.builder().client(client).encoder(encoder).decoder(decoder).contract(contract)
				.requestInterceptor(new BasicAuthRequestInterceptor("admin", "password2"))
				.target(UserFeignClient.class, "http://microservice-provider-user/");
	}

	@GetMapping("/user-user/{id}")
	public User findByIdUser(@PathVariable Long id) {
		return this.userUserFeignClient.findByid(id);
	}

	@GetMapping("/user-admin/{id}")
	public User findbyIdAdmin(@PathVariable Long id) {
		return this.adminUserFeignClient.findByid(id);
	}

}
