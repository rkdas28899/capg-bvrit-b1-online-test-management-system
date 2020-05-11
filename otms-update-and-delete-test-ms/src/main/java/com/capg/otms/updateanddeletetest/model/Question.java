package com.capg.otms.updateanddeletetest.model;



import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;

public class Question{
	private long questionId;
	private ArrayList<String> questionOptions;
	private String questionTitle;
	private int questionAnswer;
	private double questionMarks;
	private int chosenAnswer;
	private double marksScored;
	public long getQuestionId() {
		return questionId;
	}
	public void setQuestionId(long questionId) {
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
	public int getQuestionAnswer() {
		return questionAnswer;
	}
	public void setQuestionAnswer(int questionAnswer) {
		this.questionAnswer = questionAnswer;
	}
	public double getQuestionMarks() {
		return questionMarks;
	}
	public void setQuestionMarks(double questionMarks) {
		this.questionMarks = questionMarks;
	}
	public int getChosenAnswer() {
		return chosenAnswer;
	}
	public void setChosenAnswer(int chosenAnswer) {
		this.chosenAnswer = chosenAnswer;
	}
	public double getMarksScored() {
		return marksScored;
	}
	public void setMarksScored(double marksScored) {
		this.marksScored = marksScored;
	}
	
}



