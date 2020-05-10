package com.capg.otms;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.capg.otms.question.model.Question;
import com.capg.otms.question.repository.QuestionRepository;
import com.capg.otms.question.service.QuestionServiceImpl;

public class QuestionControllerTest extends OtmsModuleApplicationTests {

	@Autowired
	private WebApplicationContext wac;

	private MockMvc mockMvc;
	@Autowired
	QuestionServiceImpl service;
	@Autowired
	QuestionRepository daoImp;

	@Before
	public void setup() throws Exception {
		mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
	}

	@Test
	public void testAddQuestion() throws Exception {
		String url = "/questions/add";
		String json = "{\r\n" + "  \r\n" + "	\"questionId\":\"990\",\r\n" + "	\"questionTitle\":\"3+4\",\r\n"
				+ "	\"questionOption\":[\"0\",\"7\",\"4\",\"6\"],\r\n" + "	\"questionAnswer\":7,\r\n"
				+ "	\"questionMarks\":5\r\n" + "	\r\n" + "}";
		mockMvc.perform(
				post(url).contentType(MediaType.APPLICATION_JSON).content(json).accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isNotFound());
	
	}

	@Test
	public void testDeleteQuestion() throws Exception {

		String url = "/question/delete/id/1011";

		MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.delete(url)).andReturn();
		
		int status = mvcResult.getResponse().getStatus(); 
		Question expected = service.deleteQuestion(1011); 

		if(expected!=null) { 
			assertEquals(status,200); 
			} 
		
		else{
			assertEquals(status, 404);
		}

	}
	
	@Test
	public void testUpdateQuestion() throws Exception {

		String url = "/question/update";

		String json = "{\r\n" + "  \r\n" + "	\"questionId\":\"999\",\r\n" + "	\"questionTitle\":\"3+4\",\r\n"
				+ "	\"questionOption\":[\"0\",\"7\",\"4\",\"6\"],\r\n" + "	\"questionAnswer\":7,\r\n"
				+ "	\"questionMarks\":5\r\n" + "	\r\n" + "}";
		mockMvc.perform(
				post(url).contentType(MediaType.APPLICATION_JSON).content(json).accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());

	}

	@Test
	public void testGetListOfQuestions() {
		
	List<Question> questionList=service.getListOfQuestions();
	assertEquals(questionList.size(),10);
	}

}

