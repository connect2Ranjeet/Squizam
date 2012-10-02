/**
 * CombinationResponses.java
 * Instantiates MultipleChoiceResponses and ShortAnswerResponses classes in order to gain access to both classes' variables and methods
 * via Composition as CombinationResponses contains elements of both classes (as Java does not support Multiple Inheritance)
 * @author megumihora
 *
 */
public class CombinationResponses extends Responses {
	
	//Create instances of MultipleChoiceQuiz and ShortAnswerQuiz classes to gain accesses to their variables and methods 
	protected MultipleChoiceResponses myMCResponsesPortion; 
	protected ShortAnswerResponses mySAResponsesPortion; 
	
	/**
	 * Default Constructor 
	 */
	public CombinationResponses(){
		super(); 
	}
	
	/**
	 * Constructor that sets up name of quiz that the responses are in answer to 
	 * @param quizName
	 */
	public CombinationResponses(int quizID){
		super(quizID); 
	}
	
	/**
	 * Constructor that sets up entirety of quiz questions, both MC and SA 
	 * @param MultipleChoiceQuestions
	 * @param ShortAnswerQuestions
	 */
	public CombinationResponses(String quizName, int[] multipleChoiceResponses, String[] shortAnswerResponses){
		myMCResponsesPortion = new MultipleChoiceResponses(quizID, multipleChoiceResponses); 
		mySAResponsesPortion = new ShortAnswerResponses(quizID, shortAnswerResponses); 
	}

}
