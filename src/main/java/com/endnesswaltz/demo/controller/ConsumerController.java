package com.endnesswaltz.demo.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.endnesswaltz.demo.entity.Consumer;
import com.endnesswaltz.demo.entity.json.Response;
import com.endnesswaltz.demo.service.ConsumerService;

@RestController
@RequestMapping("/consumer")
public class ConsumerController {
	@Autowired
	private ConsumerService consumerService;
	
	@Value("${page.limit}")
    private String limit;
	
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public Response create(@RequestParam String id, @RequestParam String name, @RequestParam String age, @RequestParam String sex) {
		Response response = new Response();
		try {
			consumerService.create(id, name, age, sex);
		} catch (DuplicateKeyException e) {
			e.printStackTrace();
			return response.failure("data exists");
		} catch (Exception e) {
			e.printStackTrace();
			return response.failure("server is busy,try again later");
		}
		return response.success("create successfully");
	}
	
	@RequestMapping(value = "/retrieve", method = RequestMethod.GET)
	public Response retrieve(@RequestParam String offset) {
		Response response = new Response();
		List<Consumer> list = null;
		try {
			if ("-1".equals(offset)) {
				list =  consumerService.retrieveAll();
			} else {
				list =  consumerService.retrieveSeveral(limit, offset);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return response.failure("server is busy,try again later");
		}
		return response.success(list);
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.PUT)
	public Response update(@RequestParam String id, @RequestParam String name, @RequestParam String age, @RequestParam String sex) {
		Response response = new Response();
		try {
			consumerService.update(id, name, age, sex);
		} catch (Exception e) {
			e.printStackTrace();
			return response.failure("server is busy,try again later");
		}
		return response.success("update successfully");
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.DELETE)
	public Response delete(@RequestParam String[] ids) {
		Response response = new Response();
		try {
			consumerService.delete(Arrays.asList(ids));
		} catch (Exception e) {
			e.printStackTrace();
			return response.failure("server is busy,try again later");
		}
		return response.success("delete successfully");
	}
}
