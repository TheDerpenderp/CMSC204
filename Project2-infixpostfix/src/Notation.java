import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Notation {


	public Notation() {



	}


	public static double evaluatePostfixExpression(String postfixExpr) throws InvalidNotationFormatException{
		return 0;


	}

	public static String convertPostfixToInfix(String postfix) throws InvalidNotationFormatException{
		MyStack<String> theStack;
		//hokay, its time to parse the string, and do things to it to make it normal
		//if space ignore

		//regex for the numbers
		Pattern patternNum = Pattern.compile("[0-9]");
		Pattern patternOp = Pattern.compile("[+,\\-,*,\\/]");
		Matcher matcher;


		char[] postArr = postfix.toCharArray();
		int indexAt = 0;

		theStack = new MyStack<String>(postArr.length);

		while (indexAt!=postArr.length) {

			//if operand, put in stack
			matcher = patternNum.matcher(postArr[indexAt]+"");
			if(postArr[indexAt] != ' ')
				if(matcher.find()) {
					try {
						theStack.push(postArr[indexAt]+"");
					} catch (StackOverflowException e) {
						throw new InvalidNotationFormatException();
					}


				}
				else {

					matcher = patternOp.matcher(postArr[indexAt]+"");

					if(matcher.find()) {
						String toAdd="";
						try {
							String one = theStack.pop();
							String two = theStack.pop();
							toAdd= "("+two+postArr[indexAt]+one+")";

						} catch (StackUnderflowException e) {

							throw new InvalidNotationFormatException();
						}

						try {

							theStack.push(toAdd);
						} catch (StackOverflowException e) {

							e.printStackTrace();
						}


					}
					else {
						System.out.println(postArr[indexAt]);
						throw new InvalidNotationFormatException();
					}
				}


			indexAt++;
		}
		if(theStack.size()!=1)
			throw new InvalidNotationFormatException();
		String toReturn="";

		try {
			toReturn = theStack.pop();
		} catch (StackUnderflowException e) {
			throw new InvalidNotationFormatException();
		}


		return toReturn;



	}

	public static String convertInfixToPostfix(String infix) throws InvalidNotationFormatException{
		MyStack<String> theStack;
		MyQueue<String> theQueue;


		Pattern patternNum = Pattern.compile("[0-9]");

		Pattern patternOp = Pattern.compile("[+,\\-,*,\\/]");
		Matcher matcher;


		char[] inArr = infix.toCharArray();
		int indexAt = 0;


		theStack = new MyStack<String>(inArr.length);
		theQueue = new MyQueue<String>(inArr.length);



		while (indexAt!=inArr.length) {
			matcher = patternOp.matcher(inArr[indexAt]+"");

			if(inArr[indexAt] != ' ') {
				if(matcher.find()) {
					try {
						theQueue.enqueue((inArr[indexAt]+""));
					} catch (QueueOverflowException e) {
						throw new InvalidNotationFormatException();
					}


				}
				else if(inArr[indexAt] =='(') {
					try {
						theStack.push(inArr[indexAt]+"");
					} catch (StackOverflowException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}


				}
				//do the operators
				else {

					matcher = patternOp.matcher(inArr[indexAt]+"");

					if(matcher.find()) {
						//pop operators in presidence
						//check if mult div
						String theOP = "";
						boolean isGreater = true;
						while(isGreater) {
							try {
								theOP = theStack.pop();
							} catch (StackUnderflowException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							if((theOP.equals("*")&&inArr[indexAt]=='/')||(theOP.equals("/")&&inArr[indexAt]=='/')||(theOP.equals("/")&&inArr[indexAt]=='*')||(theOP.equals("*")&&inArr[indexAt]=='*')) {
								try {
									theQueue.enqueue(theOP);
								} catch (QueueOverflowException e) {

								}

							}
							
							
							//now check if equal to +-, if not then give up
							else if((theOP.equals("+")&&inArr[indexAt]=='-')||(theOP.equals("+")&&inArr[indexAt]=='+')||(theOP.equals("-")&&inArr[indexAt]=='-')||(theOP.equals("-")&&inArr[indexAt]=='+')){
								try {
									theQueue.enqueue(theOP);
								} catch (QueueOverflowException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}

							}
							else if ((theOP.equals("*")&&theOP.equals("/"))) {
								
								
								
							}
							else {
								//not equal or higher
								
							}
							
						}

					}
					else if(inArr[indexAt] ==')') {



					}
					else {



					}

				}


			}
			indexAt++;
		}




		return infix;





	}


}
