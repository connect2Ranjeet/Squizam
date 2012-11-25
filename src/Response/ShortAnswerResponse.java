package Response;
import java.util.Arrays;

/**
 * Contains each student's responses to a short answer quiz 
 * @author megumihora
 *
 */
public class ShortAnswerResponse extends Response {
	protected String[] studentShortResponses;

	
	/**
	 * Default Constructor
	 */
	public ShortAnswerResponse(){
		super(); 
	}
	
	/**
	 * Constructor that sets up which unique quizID's question set these responses are an answer to 
	 * @param quizID
	 */
	public ShortAnswerResponse(int quizID){
		super(quizID); 
	}
	
	/**
	 * Constructor that sets up quizID of question set that these responses are an answer to, and an array of the student's actual responses
	 */
	public ShortAnswerResponse(int quizID, String[] studentShortResponses){
		super(quizID); 
		this.studentShortResponses = Arrays.copyOf(studentShortResponses, studentShortResponses.length); 
	}	
	
	/**
	 * Gets String array of student's short answer responses
	 * @return studentShortResponses 
	 */
	public String[] getStudentShortResponses() {
		return studentShortResponses;
	}

	/**
	 * Sets array of student short answer responses 
	 * @param studentShortResponses
	 */
	public void setStudentShortResponses(String[] studentShortResponses) {
		this.studentShortResponses = Arrays.copyOf(studentShortResponses, studentShortResponses.length);
	}
	
	public void setStudentShortResponse(String studentShortResponse, int index){
		this.studentShortResponses[index] = studentShortResponse; 
	}
	
}
