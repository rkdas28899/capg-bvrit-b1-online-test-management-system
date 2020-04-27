package com.capg.otms.updateanddeletetest.model;



import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;

public class Question{
	private BigInteger questionId;
	private ArrayList<String> questionOptions;
	private String questionTitle;
	private Integer questionAnswer;
	private BigDecimal questionMarks;
	private Integer chosenAnswer;
	private BigDecimal marksScored;
	public BigInteger getQuestionId() {
		return questionId;
	}
	public void setQuestionId(BigInteger questionId) {
		this.questionId = questionId;
	}
	public ArrayList<String> getQuestionOptions() {
		return questionOptions;
	}
	public void setQuestionOptions(ArrayList<String> questionOptions) {
		this.questionOptions = questionOptions;
	}
	public String getQuestionTitle() {
		return questionTitle;
	}
	public void setQuestionTitle(String questionTitle) {
		this.questionTitle = questionTitle;
	}
	public Integer getQuestionAnswer() {
		return questionAnswer;
	}
	public void setQuestionAnswer(Integer questionAnswer) {
		this.questionAnswer = questionAnswer;
	}
	public BigDecimal getQuestionMarks() {
		return questionMarks;
	}
	public void setQuestionMarks(BigDecimal questionMarks) {
		this.questionMarks = questionMarks;
	}
	public Integer getChosenAnswer() {
		return chosenAnswer;
	}
	public void setChosenAnswer(Integer chosenAnswer) {
		this.chosenAnswer = chosenAnswer;
	}
	public BigDecimal getMarksScored() {
		return marksScored;
	}
	public void setMarksScored(BigDecimal marksScored) {
		this.marksScored = marksScored;
	}
}



