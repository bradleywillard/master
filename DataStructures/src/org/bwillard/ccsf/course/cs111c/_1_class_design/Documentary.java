package org.bwillard.ccsf.course.cs111c._1_class_design;

public class Documentary extends Movie {

	private String topic;
	private final static String DEFAULT_TOPIC = "Unknown Topic";
	
	//Constructors
	public Documentary(String title, int releaseYear, String topic) {
		super(title, releaseYear);
		this.topic = topic;
	}
	public Documentary(String title, int releaseYear) {
		this(title, releaseYear, DEFAULT_TOPIC);
	}
	public Documentary(String title) {
		super(title);//uses DEFAULT_RELEASE_YEAR
		//alternatively could just do this(title, DEFAULT_RELEASE_YEAR)
		//but wanted to invoke both parent constructors per the requirements
		this.topic = DEFAULT_TOPIC;
	}
	
	public String getTopic() {
		return topic;
	}
	public void changeTopic(String topic) {
		//Enforce initial setup of topic via constructor...
		if(this.topic != null && !"".equals(this.topic)) {
			this.topic = topic;
		}
	}
	
	@Override
	public String toString() {
		return super.toString() + ", " + this.topic;
	}
	
}
