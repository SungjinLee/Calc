package com.example.calc_sj;

import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;
import java.math.BigDecimal;
import java.math.MathContext; //������ ����¥������ ������..

import android.database.CursorJoiner.Result;



public class Calc {    //ArrayList<E>�̷������� ��ü Ÿ��������� �ϴµ�..
	private static ArrayList arr_postExp = new ArrayList(); //����Ʈ�Ƚ��� �����ιٲٱ�� �����ٲ۰Ű��� �ٻ��Ǽ� ���⿡ 
	private static Stack stack_op = new Stack();
	private static Stack stack_num = new Stack();

	public static String calc(String textexpression) {

   		StringTokenizer token = new StringTokenizer(textexpression, "+-x��");
   		String textexp = textexpression; //�̰� ���ֹ����� �ڿ����� �پ��� ������ ��ġ �ϼ���;
   		
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
				  		stack_op.push(textexp.charAt(k)); // +""�غ� �ȵǸ�
					}
				  	else if ( (Character)stack_op.peek() == '+' || (Character)stack_op.peek() == '-' ) {
				 		while(!stack_op.isEmpty()) {
				 			i++;
				 		arr_postExp.add(stack_op.pop()+"");
				 			
				 		}
				 		stack_op.push(textexp.charAt(k));
					}
				  	else if( (Character)stack_op.peek() == 'x' || (Character)stack_op.peek() == '��' ) {
				  		while(!stack_op.isEmpty()) {
				  			i++;
				 			arr_postExp.add(stack_op.pop()+"");
				 		}
				 		stack_op.push(textexp.charAt(k));
				  	}
			 }
			 else if( (char)textexp.charAt(k) == 'x' || (char)textexp.charAt(k) == '��' ) {
			 	  	if ( stack_op.isEmpty() ) {
			 	  		stack_op.push(textexp.charAt(k)); //
			 	  	}
			 	  	else if( (Character)stack_op.peek() == '+' || (Character)stack_op.peek() == '-' ) {
			 	  		stack_op.push(textexp.charAt(k));
			 	  	}
			 	  	else if( (Character)stack_op.peek() == 'x' || (Character)stack_op.peek() == '��' ) {
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
			if ( !arr_postExp.get(i).equals("+") && !arr_postExp.get(i).equals("-") && !arr_postExp.get(i).equals("x") && !arr_postExp.get(i).equals("��")) {
				stack_num.push(arr_postExp.get(i));
			}
			else if( arr_postExp.get(i).equals("+") || arr_postExp.get(i).equals("-") || arr_postExp.get(i).equals("x") || arr_postExp.get(i).equals("��") ) {
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
				case '��': 
					result = bd_num2.divide(bd_num1, MathContext.DECIMAL32);
					stack_num.push(result);
					break;
				}
			}
		} //for ������ �����
		arr_postExp.clear(); //���� Ŭ����.. �ٽ� �� ����Ʈ�� ����ؾ���.
		
		if(MainActivity.arr_sum.size() > 10) {
			MainActivity.arr_sum.removeLast();
			MainActivity.arr_sum.push(result);
		}
		else
			MainActivity.arr_sum.push(result); //sum ����
		
		return textexpression.concat("=" + MainActivity.arr_sum.get(0));

   		}

}


