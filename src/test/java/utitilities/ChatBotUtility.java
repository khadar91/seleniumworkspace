package utitilities;

import java.util.HashMap;
import java.util.Map;

public class ChatBotUtility {
	private static Map<String,String> responses;
	static //questions with answer as key & value pairs
	{
		responses=new HashMap<>();
		responses.put("hi", "Hello!");
		responses.put("how are ypu?", "Great to see you here!");
		responses.put("what are you doing?", "i'm here to asist you .");
	}
	private static String getResponse(String question) 
	{
		String answer=responses.getOrDefault(question.toLowerCase(),"Sorry I dont understans.");
		return(answer);
		
	}
	
}