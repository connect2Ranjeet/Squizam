package Response;
import java.util.Arrays;

/**
 * Contains each student's responses to a multiple choice quiz 
 * @author megumihora
 *
 */
public class MultipleChoiceResponse extends Response {
	
	protected char[] studentMCResponses;
	
	/**
	 * Default Constructor
	 */
	public MultipleChoiceResponse(){
		super(); 
	}
	
	/**
	 * Constructor that sets up which unique quizID's question set these responses are an answer to 
	 * @param quizID
	 */
	public MultipleChoiceResponse(int quizID){
		super(quizID); 
	}
	
	/**
	 * Constructor that sets up quizID of question set that these responses are an answer to, and an array of the student's actual responses
	 */
	public MultipleChoiceResponse(int quizID, char[] studentMCResponses){
		super(quizID); 
		this.studentMCResponses = Arrays.copyOf(studentMCResponses, studentMCResponses.length); 
	}
	
	
	/**
	 * Gets array of student's multiple choice responses
	 * @return studentMCResponses
	 */
	public char[] getStudentMCResponses() {
		return studentMCResponses;
	}
	
	/**
	 * Sets students multiple choice answers array
	 * @param studentMCResponses
	 */
	public void setStudentMCResponses(char[] studentMCResponses) {
		this.studentMCResponses = Arrays.copyOf(studentMCResponses, studentMCResponses.length);
	} 
	
	/**
	 * Sets one of the student's multiple choice answers in the array by index
	 * @param studentMCResponse
	 * @param index
	 */
	public void setStudentMCResponse(char studentMCResponse, int index){
		this.studentMCResponses[index] = studentMCResponse; 
	}
}
