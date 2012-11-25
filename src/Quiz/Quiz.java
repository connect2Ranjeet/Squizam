package Quiz;
import java.util.Arrays;

/**
 * Quiz.java
 * Abstract Class Quiz - cannot be instantiated as it is too general 
 * Provides properties common to MultipleChoice, ShortAnswer, and Combination quizzes
 * @author megumihora
 *
 */

public abstract class Quiz {
	protected String quizName; 
	protected String[] questions;
	protected int quizID; //unique ID issued to each quiz to match questions object to answers objects 
	
	/**
	 * Default Constructor
	 */
	public Quiz(){
		
	}
	
	/**
	 * Abstract Constructor
	 * Creates a new Quiz object, setting just the quizName.The questions can be set later. 
	 * @param quizName
	 */
	public Quiz(String quizName){
		this.quizName = quizName; 
	}
	
	/**
	 * Abstract Constructor
	 * Creates a new Quiz object, setting quizName and questions array
	 * @param quizName
	 * @param questions
	 */
	public Quiz(String quizName, String[] questions){
		this(quizName); //call default constructor 
		this.questions = Arrays.copyOf(questions, questions.length); //make copy of array object so as not to overwrite old value
	}
	
	/**
	 * gets quizName variable
	 * @return quizName
	 */
	public String getQuizName() {
		return quizName;
	}
	
	/**
	 * sets quizName variable
	 * @param quizName
	 */
	public void setQuizName(String quizName) {
		this.quizName = quizName;
	}
	
	/** 
	 * gets array of quiz's questions 
	 * @return questions 
	 */
	public String[] getQuestions() {
		return questions;
	}
	
	/**
	 * gets number of questions in questions array
	 * @return questions.length
	 */
	public int getNumQuestions(){
		return questions.length; 
	}
	
	/**
	 * sets all questions in quiz in one go
	 * @param questions - questions String array 
	 */
	public void setQuestions(String[] questions) {
		this.questions = questions;
	} 
	
	/** 
	 * sets one question in questions array at a specified index
	 * @param question - question string
	 * @param index - position in questions array
	 */
	public void setQuestion(String question, int index){
		questions[index] = question; 
	}
	
	/**
	 * gets unique quizID
	 * @return quizID
	 */
	public int getQuizID(){
		return this.quizID; 
	}
	
	/**
	 * sets unique quizID
	 * @param quizID
	 */
	public void setQuizID(int quizID) {
		this.quizID = quizID;
	} 
	
	
}
