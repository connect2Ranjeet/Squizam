package Response;
/**
 * Abstract class containing each student's responses to a Quiz
 * @author megumihora
 *
 */

public class Response {
	int quizID; 
	
	//Default Constructor
	public Response(){
		
	}
	
	/**
	 * Constructor that sets quizID of the quiz questions that the responses are in answer to
	 * @param quizName
	 */
	public Response(int quizID){
		this.quizID = quizID; 
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
