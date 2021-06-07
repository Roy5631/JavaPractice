//import
import java.util.Scanner;

class Calculator {
	// 単語が演算子ならば true を返す
	private boolean isOperator (String token) {
		return (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/"));
	}
	// 単語が数値ならば true を返す
	private boolean isNumber (String token) {
		boolean result = true;
		for(int i = 0; i < token.length(); i++) {

		    //i文字めの文字についてCharacter.isDigitメソッドで判定する
		    if(Character.isDigit(token.charAt(i)) || ".".equals(String.valueOf(token.charAt(i)))) {

		      //数字の場合は次の文字の判定へ
		      continue;

		    }else {

		      //数字でない場合は検証結果をfalseに上書きする
		    	result =false;
		      break;
		    }
		}
		return result;
	}
	// 逆ポーランド記法の文字列を計算して答えを返す
	public String getAnswer (String equation) {
		Stack stack = new Stack();
		String [] str= equation.split(" ");
		for (int i=0 ; i<str.length ; i++) {
			//数値の場合push
			if (isNumber(str[i])) {
				stack.push(str[i]);
			}
			//演算子の場合計算してpush
			if (isOperator(str[i])) {
				double y=Double.parseDouble(stack.pop());
				double x=Double.parseDouble(stack.pop());
				
				if ("+".equals(str[i])) {
					stack.push(String.valueOf(x+y));
				}
				if ("-".equals(str[i])) {
					stack.push(String.valueOf(x-y));
				}
				if ("*".equals(str[i])) {
					stack.push(String.valueOf(x*y));
				}
				if ("/".equals(str[i])) {
					stack.push(String.valueOf(x/y));
				}
			}
		}
		return stack.peek();
	}
	// 逆ポーランド記法の文字列を通常の式（中置記法）にする．
	public String getEquation (String equation) {
		Stack stack = new Stack();
		String [] str= equation.split(" ");
		for (int i=0 ; i<str.length ; i++) {
			//数値の場合
			if (isNumber(str[i])) {
				stack.push(str[i]);
			}
			//演算子の場合
			if (isOperator(str[i])) {
				String y=stack.pop();
				String x=stack.pop();
				
				if ("+".equals(str[i])) {
					stack.push("("+x+"+"+y+")");
				}
				if ("-".equals(str[i])) {
					stack.push("("+x+"-"+y+")");
				}
				if ("*".equals(str[i])) {
					stack.push(x+"*"+y);
				}
				if ("/".equals(str[i])) {
					stack.push(x+"/"+y);
				}
			}
		}
		return stack.peek();
	}
}

class CalculatorMain{
	public static void main(String[] args) {
		//読み込み
		Calculator cal = new Calculator();
		Scanner scanner = new Scanner(System.in);
		//宣言
    	String string=null;
    	//入力
	    string = scanner.nextLine();
	    scanner.close();
	    //print
    	System.out.println(cal.getEquation(string)+"="+cal.getAnswer(string));
    }
 }










