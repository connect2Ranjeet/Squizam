package Quiz;
import java.util.Arrays;

/**
 * ShortAnswerQuiz.java
 * Provides additional variables and methods specific to a short answer quiz, on top of those available via Quiz
 * @author megumihora
 */
public class ShortAnswerQuiz extends Quiz {
	
	protected String[] teacherShortAnswers; //Each string in the array is a response to one question

	/**
	 * Default Constructor
	 */
	public ShortAnswerQuiz(){
		super(); 
	}
	
	/**
	 * Constructor 
	 * @param quizName
	 */
	public ShortAnswerQuiz(String quizName){
		super(quizName); //call parent's default constructor 
	}
	
	/**
	 * Constructor that takes both quizName and questions array
	 * @param quizName
	 */
	public ShortAnswerQuiz(String quizName, String[] questions){
		super(quizName, questions); //call parent's constructor 
	}
	
	/**
	 * Constructor that initializes all values for MultipleChoiceQuiz
	 */
	public ShortAnswerQuiz(String quizName, String[] questions, String[] teacherShortAnswers){
		super(quizName, questions); 
		this.teacherShortAnswers = Arrays.copyOf(teacherShortAnswers, teacherShortAnswers.length);
	}
	
	/**
	 * Gets String array of correct short answers, as defined by teacher
	 * @return teacherShortAnswers 
	 */
	public String[] getTeacherShortAnswers() {
		return teacherShortAnswers;
	}
	/**
	 * Sets String array of correct short answers, as defined by teacher
	 * @param teacherShortAnswers
	 */
	public void setTeacherShortAnswers(String[] teacherShortAnswers) {
		this.teacherShortAnswers = Arrays.copyOf(teacherShortAnswers, teacherShortAnswers.length);
	}
	
	/**
	 * Sets one correct short answer by index, as defined by teacher
	 * @param teacherShortAnswer
	 * @param index
	 */
	public void setTeacherShortAnswer(String teacherShortAnswer, int index){
		this.teacherShortAnswers[index] = teacherShortAnswer;
	}


}
