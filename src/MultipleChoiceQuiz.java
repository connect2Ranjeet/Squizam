/**
 * MultipleChoiceQuiz.java
 * Provides additional variables and methods specific to a multiple choice quiz, on top of those available via Quiz
 * @author megumihora
 */

public class MultipleChoiceQuiz extends Quiz {
	protected int[] teacherMCAnswers; //each int corresponds to the correct char answer (A,B,C,D, etc) of a MC question
	
	
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
	 * Gets array of correct multiple choice answers, as defined by teacher
	 * @return teacherMCAnswers
	 */
	public int[] getTeacherMCAnswers() {
		return teacherMCAnswers;
	}
	
	/**
	 * Sets an array of correct multiple choice answers, as defined by teacher
	 * @param teacherMCAnswers
	 */
	public void setTeacherMCAnswers(int[] teacherMCAnswers) {
		this.teacherMCAnswers = teacherMCAnswers;
	}
	
	/**
	 * Sets one answer by index number in the correct multiple choice answers array 
	 * @param teacherMCAnswer
	 * @param index
	 */
	public void setTeacherMCAnswer(int teacherMCAnswer, int index){
		this.teacherMCAnswers[index] = teacherMCAnswer; 
	}
	
	
}
