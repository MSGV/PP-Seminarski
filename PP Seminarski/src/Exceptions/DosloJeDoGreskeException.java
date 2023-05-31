package Exceptions;

public class DosloJeDoGreskeException extends Exception
{
   private String additionalMessage;

	public DosloJeDoGreskeException(String message) 
	{
	    super(message);
	    additionalMessage = "";
	}

	public DosloJeDoGreskeException(String message, String additionalMessage) 
	{
	    super(message);
	    this.additionalMessage = additionalMessage;
	}

	public String getAdditionalMessage() 
	{
	    return additionalMessage;
	}
}
