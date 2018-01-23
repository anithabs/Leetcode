
Evaluate the value of an arithmetic expression in Reverse Polish Notation.

Valid operators are +, -, *, /. Each operand may be an integer or another expression.

Some examples:
  ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
  ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
  
  
  
class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> intermediateResults = new ArrayDeque<>();
        for(String token : tokens){
            if(token.length() == 1 && ("*-+/".contains(token))){
                final int y = intermediateResults.removeFirst();
                final int x = intermediateResults.removeFirst();
                switch(token.charAt(0)){
                    case '+':
                        intermediateResults.addFirst(x + y);
                        break;
                    case '-':
                        intermediateResults.addFirst(x - y);
                        break;
                    case '*':
                        intermediateResults.addFirst(x * y);
                        break;
                    case '/':
                        if(y == 0){
                          intermediateResults.addFirst(0);  
                        }
                        else{
                        intermediateResults.addFirst(x / y);
                        }
                        break;
                    default:
                        throw new IllegalArgumentException("Malformed RPN at :"+ token);
                }
            }else{
                    intermediateResults.addFirst(Integer.parseInt(token));
                }
            
            }
           return intermediateResults.removeFirst(); 
        }
        
    }
