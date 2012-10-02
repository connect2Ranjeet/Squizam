/**
 * CombinationQuiz.java
 * Instantiates MultipleChoiceQuiz and ShortAnswerQuiz classes in order to gain access to both classes' variables and methods
 * via Composition as CombinationQuiz contains elements of both classes (as Java does not support Multiple Inheritance)
 * @author megumihora
 */
public class CombinationQuiz extends Quiz{
	
	//Create instances of MultipleChoiceQuiz and ShortAnswerQuiz classes to gain accesses to their variables and methods 
	protected MultipleChoiceQuiz myMCQuizPortion; 
	protected ShortAnswerQuiz mySAQuizPortion; 
	
	/**
	 * Default Constructor 
	 */
	public CombinationQuiz(){
		super(); 
	}
	
	/**
	 * Constructor that sets up name of quiz
	 * @param quizName
	 */
	public CombinationQuiz(String quizName){
		super(quizName); 
	}
	
	/**
	 * Constructor that sets up entirety of quiz questions, both MC and SA 
	 * @param MultipleChoiceQuestions
	 * @param ShortAnswerQuestions
	 */
	public CombinationQuiz(String quizName, String[] multipleChoiceQuestions, String[] shortAnswerQuestions){
		myMCQuizPortion = new MultipleChoiceQuiz(quizName, multipleChoiceQuestions); 
		mySAQuizPortion = new ShortAnswerQuiz(quizName, shortAnswerQuestions); 
	}
	
}
