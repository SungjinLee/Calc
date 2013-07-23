package com.example.calc_sj;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
//import android.content.pm.PackageManager.NameNotFoundException;
//카톡추가에서 catch에서 임폴트됨
//import javax.naming.NameNotFoundException;

import android.text.ClipboardManager;
//import android.app.AlertDialog;
//import android.content.DialogInterface;
//import android.widget.Toast;
//import android.text.StaticLayout;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import java.util.LinkedList;
import android.view.inputmethod.*; //키패드 올리기 내리기 임폴트

public class MainActivity extends Activity {

	public static LinkedList arr_sum = new LinkedList();
	private static int index_Arr_sum = 0; //ans 순환을 위한 인덱스..
	Button one;
	Button two;
	Button three;
	Button four;
	Button five;
	Button six;
	Button seven;
	Button eight;
	Button nine;
	Button zero;
	Button dot;
	Button plus;
	Button minus;
	Button div;
	Button mul;
	Button equal;
	Button ans;
	Button del;
	Button allcopy;
	Button keypad;
	Button send;
	Button addlist;
	Button alldelete;
	Button linedelete;
	EditText textexpression;
	EditText textname;
	EditText textmain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
    	super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
    	one = (Button) findViewById(R.id.one);
		two = (Button) findViewById(R.id.two);
		three = (Button) findViewById(R.id.three);
		four = (Button) findViewById(R.id.four);
		five = (Button) findViewById(R.id.five);
		six = (Button) findViewById(R.id.six);
		seven = (Button) findViewById(R.id.seven);
		eight = (Button) findViewById(R.id.eight);
		nine = (Button) findViewById(R.id.nine);
		zero = (Button) findViewById(R.id.zero);
		dot = (Button) findViewById(R.id.dot);
		plus = (Button) findViewById(R.id.plus);
		minus = (Button) findViewById(R.id.minus);
		div = (Button) findViewById(R.id.div);
		mul = (Button) findViewById(R.id.mul);
		equal = (Button) findViewById(R.id.equal);
		ans = (Button) findViewById(R.id.ans);
		del = (Button) findViewById(R.id.del);
		keypad = (Button) findViewById(R.id.keypad);
		allcopy  = (Button) findViewById(R.id.allcopy);
		keypad  = (Button) findViewById(R.id.keypad);
		addlist = (Button) findViewById(R.id.addlist);
		alldelete  = (Button) findViewById(R.id.alldelete);
		linedelete  = (Button) findViewById(R.id.linedelete);
		send  = (Button) findViewById(R.id.send);
		textname = (EditText)this.findViewById(R.id.textname);
		textexpression = (EditText)this.findViewById(R.id.textexpression);
		textmain = (EditText)this.findViewById(R.id.textmain);
		
		
		one.setOnClickListener(new View.OnClickListener() 
		{
			public void onClick(View arg0) 
			{
				checkForNum("1");
			}
		});
		two.setOnClickListener(new View.OnClickListener() 
		{
			public void onClick(View arg0) 
			{
				checkForNum("2");
			}
		});
		three.setOnClickListener(new View.OnClickListener() 
		{
			public void onClick(View arg0) 
			{
				checkForNum("3");
			}
		});
		four.setOnClickListener(new View.OnClickListener() 
		{
			public void onClick(View arg0) 
			{
				checkForNum("4");
			}
		});
		five.setOnClickListener(new View.OnClickListener() 
		{
			public void onClick(View arg0) 
			{
				checkForNum("5");
			}
		});
		six.setOnClickListener(new View.OnClickListener() 
		{
			public void onClick(View arg0) 
			{
				checkForNum("6");
			}
		});
		seven.setOnClickListener(new View.OnClickListener() 
		{
			public void onClick(View arg0) 
			{
				checkForNum("7");
			}
		});
		eight.setOnClickListener(new View.OnClickListener() 
		{
			public void onClick(View arg0) 
			{
				checkForNum("8");
			}
		});
		nine.setOnClickListener(new View.OnClickListener() 
		{
			public void onClick(View arg0) 
			{
				checkForNum("9");
			}
		});
		zero.setOnClickListener(new View.OnClickListener() 
		{
			public void onClick(View arg0) 
			{
				checkForNum("0");
			}
		});
		dot.setOnClickListener(new View.OnClickListener() 
		{
			public void onClick(View arg0) 
			{
				if(check_empty()) 
					put_num_op("0.");
				else if(check_ans()) {
					textexpression.setText("");
					put_num_op("0.");
				}
				else if( check_equal() ) {
					textexpression.setText("");
					put_num_op("0.");
				}
				else
					put_num_op(".");
			}
		});
		plus.setOnClickListener(new View.OnClickListener() 
		{
			public void onClick(View arg0) 
			{
				if(check_empty()) {
					textexpression.setText("");
				}
				else if(check_ans()) {
					textexpression.setText("");
					put_num_op("+");
				}
				else if(check_equal()) {
					textexpression.setText("");
					put_num_op( arr_sum.pop() + "+");
				}
				else
					put_num_op("+");
			}
		});
		minus.setOnClickListener(new View.OnClickListener() 
		{
			public void onClick(View arg0) 
			{
				if(check_empty()) {
					textexpression.setText("");
				}
				else if(check_ans()) {
					textexpression.setText("");
					put_num_op("-");
				}
				else if(check_equal()) {
					textexpression.setText("");
					put_num_op( arr_sum.pop() + "-");
				}
				else
					put_num_op("-");
			}
		});
		mul.setOnClickListener(new View.OnClickListener() 
		{
			public void onClick(View arg0) 
			{
				if(check_empty()) {
					textexpression.setText("");
				}
				else if(check_ans()) {
					textexpression.setText("");
					put_num_op("x");
				}
				else if(check_equal()) {
					textexpression.setText("");
					put_num_op( arr_sum.pop() + "x");
				}
				else
					put_num_op("x");
			}
		});
		div.setOnClickListener(new View.OnClickListener() 
		{
			public void onClick(View arg0) 
			{
				if(check_empty()) {
					textexpression.setText("");
				}
				else if(check_ans()) {
					textexpression.setText("");
					put_num_op("÷");
				}
				else if(check_equal()) {
					textexpression.setText("");
					put_num_op( arr_sum.pop() + "÷");
				}
				else
					put_num_op("÷");
			}
		});
		del.setOnClickListener(new View.OnClickListener() 
		{
			public void onClick(View arg0) 
			{
				String text = textexpression.getText().toString();
				if(check_empty())
					textexpression.setText("");
				else if(check_ans())
					textexpression.setText("");
				else if(check_equal())
					textexpression.setText("");
				else		
					textexpression.setText(text.substring(0, text.length()-1));
				// 전체삭제랑(식입력도중만) 나머지는 그냥 지우기로 해놈..
			}
		});
		equal.setOnClickListener(new View.OnClickListener() 
		{
			public void onClick(View arg0) 
			{
				textexpression.setText(Calc.calc(textexpression.getText().toString()));
			}
		});
		ans.setOnClickListener(new View.OnClickListener() 
		{
			public void onClick(View arg0) 
			{
				
				boolean if_i_did = false;
				String exp = textexpression.getText().toString();
				
				if(!arr_sum.isEmpty()) {
					if(exp.equals("")) {
						textexpression.setText(arr_sum.get(index_Arr_sum).toString());  //???????????????
						index_Arr_sum++;
						if_i_did = true;
					}
					else if(!exp.equals("") && index_Arr_sum==0) {
						//exp.charAt(exp.length()-1) == '+' || exp.charAt(exp.length()-1) == '-' || exp.charAt(exp.length()-1) == 'x' || exp.charAt(exp.length()-1) == '÷')
						if(if_i_did) {
							if(exp.equals(arr_sum.get(arr_sum.size()-1).toString())) {
								int a = exp.length() - arr_sum.get(arr_sum.size()-1).toString().length();
								exp.substring(0, a);
							}
						}
					}
					else if(!exp.equals("") && !(index_Arr_sum == 0)) {
						
					}
					
					//else if( exp.charAt(exp.length()-1) == '+' || exp.charAt(exp.length()-1) == '-' || exp.charAt(exp.length()-1) == 'x' || exp.charAt(exp.length()-1) == '÷')
					//	textexpression.append(arr_sum.get(index_Arr_sum).toString());
					
				}
				else 
					textexpression.setText("직전 계산값이 없습니다.");

				if(index_Arr_sum>arr_sum.size()-1)
					index_Arr_sum = 0; //ans값 pop안하고 순회하면서 보기위해..	
					
				
			}
		});
		keypad.setOnClickListener(new View.OnClickListener() 
		{
			public void onClick(View arg0) 
			{
				InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);

				imm.toggleSoftInput (InputMethodManager.SHOW_FORCED, 0);

			}
		});
		addlist.setOnClickListener(new View.OnClickListener() 
		{
			public void onClick(View arg0) 
			{
				String exp = textexpression.getText().toString();
				String name = textname.getText().toString();
				if ( !exp.isEmpty() && !name.isEmpty() ) {
					textmain.append(name +") " + exp +"\n");
					textname.setText("");
					textexpression.setText("");
				}
				else if( !exp.isEmpty() && name.isEmpty() ) {
					textmain.append(exp +"\n");
					textexpression.setText("");
				}
				else if ( !name.isEmpty() && exp.isEmpty()) {
					textmain.append(name +"\n");
					textname.setText("");
				}
				else
					return;
			}
		});
		alldelete.setOnClickListener(new View.OnClickListener() 
		{
			public void onClick(View arg0) 
			{
				textmain.setText("");
			}
		});
		linedelete.setOnClickListener(new View.OnClickListener() 
		{
			public void onClick(View arg0) 
			{
				char findenter;
				String text = textmain.getText().toString();
				boolean lastline = false;
				for(int i = textmain.length()-2; i>=0; i--) {
					findenter = textmain.getText().toString().charAt(i);
					if ( findenter == '\n') {
						textmain.setText(text.substring(0, i));
						lastline = true;
						return;
					}
				}
				
				if (!lastline)
					textmain.setText("");
					
			}
		});
		allcopy.setOnClickListener(new View.OnClickListener() 
		{
			public void onClick(View arg0) 
			{
				ClipboardManager cm = (ClipboardManager)getSystemService(Context.CLIPBOARD_SERVICE);					
				cm.setText(textmain.getText().toString());
			}
		});
		send.setOnClickListener(new View.OnClickListener() 
		{
			
			public void onClick(View arg0) 
			{
				
				KakaoLink kakaoLink = KakaoLink.getLink(getApplicationContext());
	            
	            if (!kakaoLink.isAvailableIntent()) {
	                 // alert("카카오톡이 설치되어 있지 않습니다.");
	                  return;
	            }
	            if(!textmain.getText().toString().equals("")) {
	            	kakaoLink.openKakaoLink(MainActivity.this, "http//:어플다운받을주소쓸곳", textmain.getText().toString(),"2.0",
	            		      "0515", "Calc_sj_beta", "UTF-8"); 
	            }
	            else
	            	return;
	            
				/*
				KakaoLink kakaoLink = KakaoLink.getLink(getApplicationContext());
		            
		            if (!kakaoLink.isAvailableIntent()) {
		                 // alert("카카오톡이 설치되어 있지 않습니다.");
		                  return;
		            }
		            
		           try {
		            	kakaoLink.openKakaoLink(MainActivity.this, "다운받을주소쓸곳", "Calc_sj","2.0",
		            		      textmain.getText().toString(), "[Calc_sj]", "UTF-8");         							
		           } 
		            catch (NameNotFoundException e) {
		                // TODO Auto-generated catch block
		                e.printStackTrace();
		            } 
		          */
		                       
		            
		        }
	
		});

  }
   
    public boolean check_empty() {
    	String text = (String)textexpression.getText().toString();
    	return text.isEmpty();
    }
  
    public boolean check_equal() {
    	String text = (String)textexpression.getText().toString();
    	return text.contains("=");
    }
    
    public boolean check_ans() {
    	String text = (String)textexpression.getText().toString();
    	return text.equals("직전 계산값이 없습니다.");
    }
    
    public void put_num_op(String c) {
    	textexpression.append(c);
    }
    
    public void checkForNum(String num) {
    	if (check_ans()) {
    		textexpression.setText("");
    		put_num_op(num);
    	}
    	else if(check_empty()) {
    		put_num_op(num);
    	}
    	else if(check_equal()) {
    		textexpression.setText("");
    		put_num_op(num);
    	}
    	else put_num_op(num);
    } 
    public boolean checkExp(String exp) {
    	boolean check = true;
    	
    	if(exp.charAt(0) == '-')
    		check = false;
    	//else if( )
    	
    	
    	
    	return check;
    }
    
  @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}

/*
 	이상한식 걸러내야됨...ans에서 나온 -2음수로 시작하는수 +식..등등
 	ans로 -9였던거 이어서 계산하면 병신됨. 기본계산기는 되더라..
 	소수점 계산이 이상함.....0.3 * 3  8.99999999999999999
 	익입력창도 textedit으로해서 수정 불가하게해서 칸을맞출까..?
 	
 	1. ans를 계속 남길것인지(메모리 언젠간 차겟지..아마안차긴할듯) or 지금처럼 pop해서 사라짐
 	2. 리스트 편집창만들고 으로 가서 지출과 수입 + -로 체크하던 뭐던해서 총합으로 나타내는거라던지
 	3. Ans 완성...
 	4. 잘못된식 거르기 완성..
 	
*/