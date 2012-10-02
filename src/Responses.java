/**
 * Abstract class containing each student's responses to a Quiz
 * @author megumihora
 *
 */

public class Responses {
	int quizID; 
	
	//Default Constructor
	public Responses(){
		
	}
	
	/**
	 * Constructor that sets quizID of the quiz questions that the responses are in answer to
	 * @param quizName
	 */
	public Responses(int quizID){
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
