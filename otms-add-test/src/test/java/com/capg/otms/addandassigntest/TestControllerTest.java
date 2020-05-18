package com.capg.otms.addandassigntest;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import com.capg.otms.addandassigntest.model.Test;
import org.junit.Before;
import org.junit.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.capg.otms.addandassigntest.service.TestMangementServiceImpl;

class TestControllerTest extends OtmsAddAndAssignTestApplicationTests {

	@Autowired
	private WebApplicationContext wac;

	private MockMvc mockMvc;
	@Autowired
	TestMangementServiceImpl service;

	@Before
	public void setup() throws Exception {
		mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
	}

	@org.junit.Test
	public void testAddTest() throws Exception {
		String url = "/test/add";
		String json = "{\r\n" + "  \r\n" + "	\"testId\":\"201\",\r\n" + "	\"testTitle\":\"Java Test\",\r\n"
				+ "	\"startTime\":2020-05-02T14:00:00\",\r\n" + "	\"endTime\":2020-05-02T15:30:00\",\r\n"  + "}";
				
		mockMvc.perform(
				post(url).contentType(MediaType.APPLICATION_JSON).content(json).accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isNotFound());
	
	}

	@org.junit.Test
	public void testDeleteTest() throws Exception {

		String url = "/test/delete/102";

		MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.delete(url)).andReturn();
		
		int status = mvcResult.getResponse().getStatus(); 
		Test expected = service.deleteTest(102); 

		if(expected!=null) { 
			assertEquals(status,200); 
			} 
		
		else{
			assertEquals(status, 404);
		}

	}
	@org.junit.Test
	public void testGetAllTests() {
	List<Test> allTests=service.getAllTests();
	assertEquals(allTests.size(),10);
	}

}
