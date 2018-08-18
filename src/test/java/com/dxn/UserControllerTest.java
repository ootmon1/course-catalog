//package com.dxn;
//
//import static org.hamcrest.CoreMatchers.containsString;
//import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.*;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
//import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.test.web.servlet.MockMvc;
//
//import com.dxn.model.Topic;
//import com.dxn.user.UserController;
//
//@RunWith(SpringRunner.class)
//@WebMvcTest(UserController.class)
//public class UserControllerTest {
//
//	@Autowired
//	private MockMvc mockMvc;
//	
//	@Test
//	public void testGetAllTopics() throws Exception {
//		
//		List<Topic> expected = new ArrayList<>();
//		expected.add(new Topic("test1", "test1"));
//		expected.add(new Topic("test2", "test2"));
//		
//		this.mockMvc.perform(get("/api/topics").with(user("user"))).andDo(print()).andExpect(status().isOk())
//			.andExpect(content().string(containsString(expected.toString())));
//	}
//}
