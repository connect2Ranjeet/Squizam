package Response;
/**
 * CombinationResponses.java
 * Instantiates MultipleChoiceResponses and ShortAnswerResponses classes in order to gain access to both classes' variables and methods
 * via Composition as CombinationResponses contains elements of both classes (as Java does not support Multiple Inheritance)
 * @author megumihora
 *
 */
public class CombinationResponse extends Response {
	
	//Create instances of MultipleChoiceQuiz and ShortAnswerQuiz classes to gain accesses to their variables and methods 
	protected MultipleChoiceResponse myMCResponsesPortion; 
	protected ShortAnswerResponse mySAResponsesPortion; 
	
	/**
	 * Default Constructor 
	 */
	public CombinationResponse(){
		super(); 
	}
	
	/**
	 * Constructor that sets up name of quiz that the responses are in answer to 
	 * @param quizName
	 */
	public CombinationResponse(int quizID){
		super(quizID); 
	}
	
	/**
	 * Constructor that sets up entirety of quiz questions, both MC and SA 
	 * @param MultipleChoiceQuestions
	 * @param ShortAnswerQuestions
	 */
	public CombinationResponse(String quizName, char[] multipleChoiceResponses, String[] shortAnswerResponses){
		myMCResponsesPortion = new MultipleChoiceResponse(quizID, multipleChoiceResponses); 
		mySAResponsesPortion = new ShortAnswerResponse(quizID, shortAnswerResponses); 
	}

}
