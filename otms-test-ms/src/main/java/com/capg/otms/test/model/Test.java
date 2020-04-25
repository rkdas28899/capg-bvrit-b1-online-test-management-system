package com.capg.otms.test.model;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Set;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "test_info")
public class Test {

	@Id
	private long testId; 
	private String testTitle;
	private LocalTime testDuration;
	@ElementCollection
	private Set<Long> testQuestions;
	private double testTotalMarks;
	private double testMarksScored;
	private long currentQuestion;
	private LocalDateTime startTime;
	private LocalDateTime endTime;
		
	
	public Test() {}
	

	public Test(long testId, String testTitle, LocalTime testDuration, Set<Long> testQuestions, double testTotalMarks,
			double testMarksScored, long currentQuestion, LocalDateTime startTime, LocalDateTime endTime) {
		super();
		this.testId = testId;
		this.testTitle = testTitle;
		this.testDuration = testDuration;
		this.testQuestions = testQuestions;
		this.testTotalMarks = testTotalMarks;
		this.testMarksScored = testMarksScored;
		this.currentQuestion = currentQuestion;
		this.startTime = startTime;
		this.endTime = endTime;
	}


	public long getTestId() {
		return testId;
	}


	public void setTestId(long testId) {
		this.testId = testId;
	}


	public String getTestTitle() {
		return testTitle;
	}


	public void setTestTitle(String testTitle) {
		this.testTitle = testTitle;
	}


	public LocalTime getTestDuration() {
		return testDuration;
	}


	public void setTestDuration(LocalTime testDuration) {
		this.testDuration = testDuration;
	}


	public Set<Long> getTestQuestions() {
		return testQuestions;
	}


	public void setTestQuestions(Set<Long> testQuestions) {
		this.testQuestions = testQuestions;
	}


	public double getTestTotalMarks() {
		return testTotalMarks;
	}


	public void setTestTotalMarks(double testTotalMarks) {
		this.testTotalMarks = testTotalMarks;
	}


	public double getTestMarksScored() {
		return testMarksScored;
	}


	public void setTestMarksScored(double testMarksScored) {
		this.testMarksScored = testMarksScored;
	}


	public long getCurrentQuestion() {
		return currentQuestion;
	}


	public void setCurrentQuestion(long currentQuestion) {
		this.currentQuestion = currentQuestion;
	}


	public LocalDateTime getStartTime() {
		return startTime;
	}


	public void setStartTime(LocalDateTime startTime) {
		this.startTime = startTime;
	}


	public LocalDateTime getEndTime() {
		return endTime;
	}


	public void setEndTime(LocalDateTime endTime) {
		this.endTime = endTime;
	}
	
	
}
