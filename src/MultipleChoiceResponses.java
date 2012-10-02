/**
 * Contains each student's responses to a multiple choice quiz 
 * @author megumihora
 *
 */
public class MultipleChoiceResponses extends Responses {
	
	protected int[] studentMCResponses;
	
	/**
	 * Default Constructor
	 */
	public MultipleChoiceResponses(){
		super(); 
	}
	
	/**
	 * Constructor that sets up which unique quizID's question set these responses are an answer to 
	 * @param quizID
	 */
	public MultipleChoiceResponses(int quizID){
		super(quizID); 
	}
	
	/**
	 * Constructor that sets up quizID of question set that these responses are an answer to, and an array of the student's actual responses
	 */
	public MultipleChoiceResponses(int quizID, int[] studentMCResponses){
		super(quizID); 
		this.studentMCResponses = studentMCResponses; 
	}
	
	
	/**
	 * Gets array of student's multiple choice responses
	 * @return studentMCResponses
	 */
	public int[] getStudentMCResponses() {
		return studentMCResponses;
	}
	
	/**
	 * Sets students multiple choice answers array
	 * @param studentMCResponses
	 */
	public void setStudentMCResponses(int[] studentMCResponses) {
		this.studentMCResponses = studentMCResponses;
	} 
	
	/**
	 * Sets one of the student's multiple choice answers in the array by index
	 * @param studentMCResponse
	 * @param index
	 */
	public void setStudentMCResponse(int studentMCResponse, int index){
		this.studentMCResponses[index] = studentMCResponse; 
	}
}
