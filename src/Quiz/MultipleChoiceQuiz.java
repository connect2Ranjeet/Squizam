package Quiz;
import java.util.Arrays;

/**
 * MultipleChoiceQuiz.java
 * Provides additional variables and methods specific to a multiple choice quiz, on top of those available via Quiz
 * @author megumihora
 */

public class MultipleChoiceQuiz extends Quiz {
	protected char[] teacherMCAnswers; //char answers to MC questions
	protected String[] textToMCAnswers; //text to correspond with MC char answers 
	
	/**
	 * Default Constructor
	 */
	public MultipleChoiceQuiz(){
		super(); 
	}
	
	/**
	 * Constructor 
	 * @param quizName
	 */
	public MultipleChoiceQuiz(String quizName){
		super(quizName); //call parent's default constructor 
	}
	
	/**
	 * Constructor that takes both quizName and questions array
	 * @param quizName
	 */
	public MultipleChoiceQuiz(String quizName, String[] questions){
		super(quizName, questions); //call parent's constructor 
	}
	
	/**
	 * Constructor that initializes all values for MultipleChoiceQuiz
	 */
	public MultipleChoiceQuiz(String quizName, String[] questions, char[] teacherMCAnswers, String[] textToMCAnswers){
		super(quizName, questions); 
		this.teacherMCAnswers = Arrays.copyOf(teacherMCAnswers, teacherMCAnswers.length);
		this.textToMCAnswers = Arrays.copyOf(textToMCAnswers, textToMCAnswers.length); 
	}
	
	
	/**
	 * Gets array of correct multiple choice answers, as defined by teacher
	 * @return teacherMCAnswers
	 */
	public char[] getTeacherMCAnswers() {
		return teacherMCAnswers;
	}
	
	/**
	 * Sets an array of correct multiple choice answers, as defined by teacher
	 * @param teacherMCAnswers
	 */
	public void setTeacherMCAnswers(char[] teacherMCAnswers) {
		this.teacherMCAnswers = Arrays.copyOf(teacherMCAnswers, teacherMCAnswers.length);
	}
	
	/**
	 * Sets one answer by index number in the correct multiple choice answers array 
	 * @param teacherMCAnswer
	 * @param index
	 */
	public void setTeacherMCAnswer(char teacherMCAnswer, int index){
		this.teacherMCAnswers[index] = teacherMCAnswer; 
	}
	
	/**
	 * Gets one answer by index number in the correct multiple choice answers array
	 * @return answer
	 */
	public char getTeacherMCAnswer(int index){
		return teacherMCAnswers[index]; 
	}
	
	/**
	 * Gets array of multiple choice answer texts
	 */
	public String[] getTextToMCAnswers(){
		return textToMCAnswers; 
	}
	
	/**
	 * Sets array of multiple choice answer texts
	 */
	public void setTextToMCAnswers(String[] textToMCAnswers){
		this.textToMCAnswers = textToMCAnswers; 
	}
	
	/**
	 * Sets one multiple choice answer text
	 */
	public void setTextToMCAnswer(String answer, int index){
		textToMCAnswers[index] = answer; 
	}
	
	/**
	 * Gets one multiple choice answer text
	 */
	public String getTextToMCAnswer(int index){
		return textToMCAnswers[index]; 
	}
	
}
