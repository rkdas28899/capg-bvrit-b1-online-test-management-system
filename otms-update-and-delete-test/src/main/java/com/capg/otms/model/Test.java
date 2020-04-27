package com.capg.otms.model;


import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Set;


@Entity
@Table(name="Test_info")
public class Test{
	
	@Id
	
	
	
	private int testId;
	private String testTitle; 
	private String testDuration; 
	private String testQuestion;
	private int testQuestions;
	private double  testTotalMarks ;
	private double testMarksScored ;
	private String startTime ;
	private String endTime ;
	
	
	
	public int getTestId() {
		return testId;
	}
	public void setTestId(int testId) {
		this.testId = testId;
	}
	public String getTestTitle() {
		return testTitle;
	}
	public void setTestTitle(String testTitle) {
		this.testTitle = testTitle;
	}
	public String getTestDuration() {
		return testDuration;
	}
	public void setTestDuration(String testDuration) {
		this.testDuration = testDuration;
	}
	public String getTestQuestion() {
		return testQuestion;
	}
	public void setTestQuestion(String testQuestion) {
		this.testQuestion = testQuestion;
	}
	public int getTestQuestions() {
		return testQuestions;
	}
	public void setTestQuestions(int testQuestions) {
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
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	@Override
	public String toString() {
		return "TestBean [testId=" + testId + ", testTitle=" + testTitle + ", testDuration=" + testDuration
				+ ", testQuestion=" + testQuestion + ", testQuestions=" + testQuestions + ", testTotalMarks="
				+ testTotalMarks + ", testMarksScored=" + testMarksScored + ", startTime=" + startTime + ", endTime="
				+ endTime + "]";
	}
	

}