package org.bwillard.ccsf.course.cs211s.assn6.code_from_classes;

import java.io.Serializable;

public class Response implements Comparable<Response>, Serializable{

	private String name, question;
	private int answer;
	public Response(String name, String question, int answer) {
		this.name = name;
		this.question = question;
		this.answer = answer;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public int getAnswer() {
		return answer;
	}
	public void setAnswer(int answer) {
		this.answer = answer;
	}
	@Override
	public String toString() {
		return question + ": " + answer + " (" + name + ")";
	}
	public int compareTo(Response otherResponse) {
		if(question.equalsIgnoreCase(otherResponse.question)) {
			return name.compareTo(otherResponse.name);
		} else {
			return question.compareTo(otherResponse.question);
		}
	}
	
	
}
