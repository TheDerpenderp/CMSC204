import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Notation {


	public Notation() {



	}


	public static double evaluatePostfixExpression(String postfixExpr) throws InvalidNotationFormatException{
		MyStack<String> theStack;



		Pattern patternNum = Pattern.compile("[0-9, (]");

		Pattern patternOp = Pattern.compile("[+,\\-,*,\\/]");
		Matcher matcher;
		Matcher matcherNum;

		char[] postArr = postfixExpr.toCharArray();
		int indexAt = 0;


		theStack = new MyStack<String>(postArr.length);
		while (indexAt!=postArr.length) {
			matcher = patternOp.matcher(postArr[indexAt]+"");
			matcherNum = patternNum.matcher(postArr[indexAt]+"");

			if(postArr[indexAt] != ' ') {

				if(matcherNum.find()) {
					try {
						theStack.push(postArr[indexAt]+"");
					} catch (StackOverflowException e) {
						throw new InvalidNotationFormatException();
					}

				}
				else if(matcher.find()) {

					String thing1 = "";
					String thing2 = "";
					String res = "";
					try {
						thing1 += theStack.pop();
						thing2+= theStack.pop();
					} catch (StackUnderflowException e) {
						throw new InvalidNotationFormatException();
					}
					//find what operator
					if(postArr[indexAt] == '*') {
						res +=(Double.parseDouble(thing2)*Double.parseDouble(thing1));

					}
					else if(postArr[indexAt] == '/') {
						res +=(Double.parseDouble(thing2)/Double.parseDouble(thing1));

					}
					else if(postArr[indexAt] == '-') {
						res +=(Double.parseDouble(thing2)-Double.parseDouble(thing1));

					}
					else {
						res +=(Double.parseDouble(thing2)+Double.parseDouble(thing1));

					}
					try {
						theStack.push(res);
					} catch (StackOverflowException e) {
						throw new InvalidNotationFormatException();
					}
				}



			}

			indexAt++;


		}
		
		double toRet;
		
		try {
			toRet = Double.parseDouble(theStack.pop());
		} catch (NumberFormatException e) {
			throw new InvalidNotationFormatException();
		} catch (StackUnderflowException e) {
			throw new InvalidNotationFormatException();
		}
		
		return toRet;

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
		Matcher matcherNum;

		char[] inArr = infix.toCharArray();
		int indexAt = 0;


		theStack = new MyStack<String>(inArr.length);
		theQueue = new MyQueue<String>(inArr.length);



		while (indexAt!=inArr.length) {
			matcher = patternOp.matcher(inArr[indexAt]+"");
			matcherNum = patternNum.matcher(inArr[indexAt]+"");
			if(inArr[indexAt] != ' ') {
				if(matcherNum.find()) {
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
						throw new InvalidNotationFormatException();
					}


				}

				//do the operators
				else {

					matcher = patternOp.matcher(inArr[indexAt]+"");

					if(matcher.find()) {
						//pop operators in presidence
						//check if mult div
						try {
							matcher = patternOp.matcher(theStack.top()+"");
						} catch (StackUnderflowException e1) {
							throw new InvalidNotationFormatException();
						}
						if(matcher.find()) {

							String theOP = "";
							boolean isGreater = true;
							while(isGreater) {
								try {
									theOP = theStack.pop();
								} catch (StackUnderflowException e) {
									throw new InvalidNotationFormatException();
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
										throw new InvalidNotationFormatException();
									}

								}
								else {
									isGreater = false;
									try {
										theStack.push(inArr[indexAt]+"");
									} catch (StackOverflowException e) {
										throw new InvalidNotationFormatException();
									}
								}

							}

						}
						else {

							try {
								theStack.push(inArr[indexAt]+"");
							} catch (StackOverflowException e) {
								throw new InvalidNotationFormatException();
							}


						}

					}
					else if(inArr[indexAt] ==')') {
						String top = "";
						try {
							top = theStack.pop();
						} catch (StackUnderflowException e) {
							throw new InvalidNotationFormatException();
						}
						while(!top.equals("(")) {

							try {
								theQueue.enqueue(top);
							} catch (QueueOverflowException e) {
								throw new InvalidNotationFormatException();
							}
							try {
								top = theStack.pop();
							} catch (StackUnderflowException e) {
								throw new InvalidNotationFormatException();
							}
						}


					}
					else {



					}

				}


			}
			indexAt++;
		}
		String toRet = "";
		while(!theQueue.isEmpty()) {

			try {
				toRet+=theQueue.dequeue();
			} catch (QueueUnderflowException e) {
				throw new InvalidNotationFormatException();
			}

		}


		return toRet;





	}


}
