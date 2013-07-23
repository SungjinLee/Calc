package com.example.calc_sj;

import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;
import java.math.BigDecimal;
import java.math.MathContext; //수소점 몇제짜리까지 끊을지..

import android.database.CursorJoiner.Result;



public class Calc {    //ArrayList<E>이런식으로 객체 타입정해줘야 하는듯..
	private static ArrayList arr_postExp = new ArrayList(); //포스트픽스용 후위로바꾸기랑 후위바꾼거계산시 다사용되서 여기에 
	private static Stack stack_op = new Stack();
	private static Stack stack_num = new Stack();

	public static String calc(String textexpression) {

   		StringTokenizer token = new StringTokenizer(textexpression, "+-x÷");
   		String textexp = textexpression; //이거 없애버리고 뒤에껄로 다쓸수 있을듯 조치 완성후;
   		
        for(int i=0, k=0; token.hasMoreTokens(); i++, k++) {
			arr_postExp.add(token.nextToken());
			String tmp = (String)arr_postExp.get(i);
			k += tmp.length(); 
			if( k >= textexp.length()-1) {
				while(!stack_op.isEmpty()) {
					i++;
					arr_postExp.add(stack_op.pop()+"");
				}
				break;
			}
			else if( (char)textexp.charAt(k) == '+' || (char)textexp.charAt(k) == '-' ) {
					if( stack_op.isEmpty() ) {
				  		stack_op.push(textexp.charAt(k)); // +""해봐 안되면
					}
				  	else if ( (Character)stack_op.peek() == '+' || (Character)stack_op.peek() == '-' ) {
				 		while(!stack_op.isEmpty()) {
				 			i++;
				 		arr_postExp.add(stack_op.pop()+"");
				 			
				 		}
				 		stack_op.push(textexp.charAt(k));
					}
				  	else if( (Character)stack_op.peek() == 'x' || (Character)stack_op.peek() == '÷' ) {
				  		while(!stack_op.isEmpty()) {
				  			i++;
				 			arr_postExp.add(stack_op.pop()+"");
				 		}
				 		stack_op.push(textexp.charAt(k));
				  	}
			 }
			 else if( (char)textexp.charAt(k) == 'x' || (char)textexp.charAt(k) == '÷' ) {
			 	  	if ( stack_op.isEmpty() ) {
			 	  		stack_op.push(textexp.charAt(k)); //
			 	  	}
			 	  	else if( (Character)stack_op.peek() == '+' || (Character)stack_op.peek() == '-' ) {
			 	  		stack_op.push(textexp.charAt(k));
			 	  	}
			 	  	else if( (Character)stack_op.peek() == 'x' || (Character)stack_op.peek() == '÷' ) {
			 	  		while(!stack_op.isEmpty()) {
			 	  			i++;
			 	  			arr_postExp.add(stack_op.pop()+"");
				  		}
				  		stack_op.push(textexp.charAt(k));
			 	  	}
			 }			
		} //for
        
        BigDecimal result = new BigDecimal(0);
		for(int i=0; i<arr_postExp.size(); i++) {
			if ( !arr_postExp.get(i).equals("+") && !arr_postExp.get(i).equals("-") && !arr_postExp.get(i).equals("x") && !arr_postExp.get(i).equals("÷")) {
				stack_num.push(arr_postExp.get(i));
			}
			else if( arr_postExp.get(i).equals("+") || arr_postExp.get(i).equals("-") || arr_postExp.get(i).equals("x") || arr_postExp.get(i).equals("÷") ) {
				BigDecimal bd_num1 = new BigDecimal(stack_num.pop()+"");
				BigDecimal bd_num2 = new BigDecimal(stack_num.pop()+"");
				
				switch( (arr_postExp.get(i)+"").charAt(0) ) {
				case '+': 
					result = bd_num2.add(bd_num1);
					stack_num.push(result);
					break;
				case '-': 
					result = bd_num2.subtract(bd_num1);
					stack_num.push(result);					
					break;
				case 'x': 
					result = bd_num2.multiply(bd_num1);
					stack_num.push(result);
					break;
				case '÷': 
					result = bd_num2.divide(bd_num1, MathContext.DECIMAL32);
					stack_num.push(result);
					break;
				}
			}
		} //for 후위식 연산용
		arr_postExp.clear(); //전식 클리어.. 다시 이 리스트로 계산해야함.
		
		if(MainActivity.arr_sum.size() > 10) {
			MainActivity.arr_sum.removeLast();
			MainActivity.arr_sum.push(result);
		}
		else
			MainActivity.arr_sum.push(result); //sum 저장
		
		return textexpression.concat("=" + MainActivity.arr_sum.get(0));

   		}

}


