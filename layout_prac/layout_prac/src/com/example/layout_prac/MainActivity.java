package com.example.layout_prac;

import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.ClipboardManager;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnKeyListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.PopupMenu;
import android.widget.Toast;
import android.widget.AutoCompleteTextView;
import android.view.View.OnLongClickListener;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

import android.view.inputmethod.*; //Ű�е� �ø��� ������ ����Ʈ

@SuppressLint("NewApi")
public class MainActivity extends Activity {
	
	public static ArrayList<String> autocomplet_list = new ArrayList<String>();
	public static LinkedList arr_sum = new LinkedList();
	private static int index_Arr_sum = 0; //ans ��ȯ�� ���� �ε���..
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
	AutoCompleteTextView textname;
	EditText textmain;
	LinearLayout bottom_layout;
	LinearLayout top_layout;
	LinearLayout exp_layout;
	static boolean pushed_ans = false;  
	
	
	
	
    @TargetApi(Build.VERSION_CODES.GINGERBREAD)
	@SuppressLint("NewApi")
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
		allcopy  = (Button) findViewById(R.id.allcopy);
		keypad  = (Button) findViewById(R.id.keypad);
		addlist = (Button) findViewById(R.id.addlist_1);
		alldelete  = (Button) findViewById(R.id.alldelete);
		linedelete  = (Button) findViewById(R.id.linedelete);
		send  = (Button) findViewById(R.id.send_1);
		textname = (AutoCompleteTextView)this.findViewById(R.id.textname);
		textname.requestFocus();
		textexpression = (EditText)this.findViewById(R.id.textexpression);
		textmain = (EditText)this.findViewById(R.id.textmain);
		bottom_layout= (LinearLayout)this.findViewById(R.id.bottom_l);
		top_layout=(LinearLayout)this.findViewById(R.id.top_l);
		exp_layout=(LinearLayout)this.findViewById(R.id.exp_layout);
		textname = (AutoCompleteTextView)findViewById(R.id.textname);
		final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, 
		        android.R.layout.simple_dropdown_item_1line, autocomplet_list);
		textname.setAdapter(adapter);
        	
       textname.setOnKeyListener(new OnKeyListener()
        
                {
        
                 
        
                    public boolean onKey(View v, int keyCode, KeyEvent event)
        
                    {
       
                        if(keyCode ==  KeyEvent.KEYCODE_ENTER )
        
                        {
        
                        	InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);

            				imm.toggleSoftInput (InputMethodManager.SHOW_FORCED, 0);
        
                           return true;
        
                        }
        
                        // TODO Auto-generated method stub
       
                        return false;
        
                    }
       
                });
       

       
		
		one.setOnClickListener(new View.OnClickListener() 
		{
			public void onClick(View arg0) 
			{
				checkForNum("1");
				pushed_ans = false;
			}
		});
		two.setOnClickListener(new View.OnClickListener() 
		{
			public void onClick(View arg0) 
			{
				checkForNum("2");
				pushed_ans = false;
			}
		});
		three.setOnClickListener(new View.OnClickListener() 
		{
			public void onClick(View arg0) 
			{
				checkForNum("3");
				pushed_ans = false;
			}
		});
		four.setOnClickListener(new View.OnClickListener() 
		{
			public void onClick(View arg0) 
			{
				checkForNum("4");
				pushed_ans = false;
			}
		});
		five.setOnClickListener(new View.OnClickListener() 
		{
			public void onClick(View arg0) 
			{
				checkForNum("5");
				pushed_ans = false;
			}
		});
		six.setOnClickListener(new View.OnClickListener() 
		{
			public void onClick(View arg0) 
			{
				checkForNum("6");
				pushed_ans = false;
			}
		});
		seven.setOnClickListener(new View.OnClickListener() 
		{
			public void onClick(View arg0) 
			{
				checkForNum("7");
				pushed_ans = false;
			}
		});
		eight.setOnClickListener(new View.OnClickListener() 
		{
			public void onClick(View arg0) 
			{
				checkForNum("8");
				pushed_ans = false;
			}
		});
		nine.setOnClickListener(new View.OnClickListener() 
		{
			public void onClick(View arg0) 
			{
				checkForNum("9");
				pushed_ans = false;
			}
		});
		zero.setOnClickListener(new View.OnClickListener() 
		{
			public void onClick(View arg0) 
			{
				checkForNum("0");
				pushed_ans = false;
			}
		});
		dot.setOnClickListener(new View.OnClickListener() 
		{
			public void onClick(View arg0) 
			{
				String exp = textexpression.getText().toString();
				
				if(check_empty()) 
					put_num_op("0.");
				else if( exp.charAt(exp.length()-1) == '.')
					return;
				else if( exp.charAt(exp.length()-1) == '+' || exp.charAt(exp.length()-1) == 'x' || exp.charAt(exp.length()-1) == 'x' || exp.charAt(exp.length()-1) == '��' )
					put_num_op("0.");
				else if(check_ans()) {
					textexpression.setText("");
					put_num_op("0.");
				}
				else if( check_equal() ) {
					textexpression.setText("");
					put_num_op("0.");
				}
				else {
					StringTokenizer token = new StringTokenizer(exp, "+-x��");

					while(token.hasMoreTokens()) {
						String number = token.nextToken();
						for(int j=0; j<number.length()-1; j++)
							if(number.charAt(j) == '.') {
								if(!token.hasMoreTokens())
									return;
							}
					}
					put_num_op(".");
				}
					
	
			}
		});
		plus.setOnClickListener(new View.OnClickListener() 
		{
			public void onClick(View arg0) 
			{
				String exp = textexpression.getText().toString();
				
				if(check_empty())
					textexpression.setText("");
				else if (exp.charAt(exp.length()-1) == '-' || exp.charAt(exp.length()-1) == 'x' || exp.charAt(exp.length()-1) == '��' || exp.charAt(exp.length()-1) == '+') {
					textexpression.setText(exp.substring(0, exp.length()-1));
					put_num_op("+");
				}

				else if(check_ans()) {
					textexpression.setText("");
					put_num_op("+");
				}
				else if( exp.charAt(exp.length()-1) == '.')
					put_num_op("0+");
				else if(check_equal()) {
					textexpression.setText("");
					put_num_op( exp.substring(findEqualIndex(exp)+1) + "+");
				}
				else if(exp.charAt(exp.length()-1) == '.')
					return;
				else
					put_num_op("+");
			}
		});
		minus.setOnClickListener(new View.OnClickListener() 
		{
			public void onClick(View arg0) 
			{
				String exp = textexpression.getText().toString();
				
				if(check_empty())
					textexpression.setText("");
				else if (exp.charAt(exp.length()-1) == '+' || exp.charAt(exp.length()-1) == 'x' || exp.charAt(exp.length()-1) == '��' || exp.charAt(exp.length()-1) == '-') {
					textexpression.setText(exp.substring(0, exp.length()-1));
					put_num_op("-");
				}
				else if(check_ans()) {
					textexpression.setText("");
					put_num_op("-");
				}
				else if( exp.charAt(exp.length()-1) == '.')
					put_num_op("0-");
				else if(check_equal()) {
					textexpression.setText("");
					put_num_op( exp.substring(findEqualIndex(exp)+1) + "-");
				}
				else if(exp.charAt(exp.length()-1) == '.')
					return;
				else
					put_num_op("-");
			}
		});
		mul.setOnClickListener(new View.OnClickListener() 
		{
			public void onClick(View arg0) 
			{
				String exp = textexpression.getText().toString();
				
				if(check_empty()) 
					textexpression.setText("");
				else if (exp.charAt(exp.length()-1) == '+' || exp.charAt(exp.length()-1) == '-' || exp.charAt(exp.length()-1) == '��' || exp.charAt(exp.length()-1) == 'x') {
					textexpression.setText(exp.substring(0, exp.length()-1));
					put_num_op("x");
				}
				else if(check_ans()) {
					textexpression.setText("");
					put_num_op("x");
				}
				else if( exp.charAt(exp.length()-1) == '.')
					put_num_op("0x");
				else if(check_equal()) {
					textexpression.setText("");
					put_num_op( exp.substring(findEqualIndex(exp)+1) + "x");
				}
				else if(exp.charAt(exp.length()-1) == '.')
					return;
				else
					put_num_op("x");
			}
		});
		div.setOnClickListener(new View.OnClickListener() 
		{
			public void onClick(View arg0) 
			{
				String exp = textexpression.getText().toString();
				
				if(check_empty())
					textexpression.setText("");
				else if (exp.charAt(exp.length()-1) == '+' || exp.charAt(exp.length()-1) == 'x' || exp.charAt(exp.length()-1) == '-' || exp.charAt(exp.length()-1) == '��') {
					textexpression.setText(exp.substring(0, exp.length()-1));
					put_num_op("��");
				}
				else if(check_ans()) {
					textexpression.setText("");
					put_num_op("��");
				}
				else if( exp.charAt(exp.length()-1) == '.')
					put_num_op("0��");
				else if(check_equal()) {
					textexpression.setText("");
					put_num_op( exp.substring(findEqualIndex(exp)+1) + "��");
				}
				else if(exp.charAt(exp.length()-1) == '.')
					return;
				else
					put_num_op("��");
			}
		});
		del.setOnLongClickListener(new View.OnLongClickListener() {
		    @Override
		    public boolean onLongClick(View v) {
		    	textexpression.setText("");
		    	return true; 
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
			}
		});
		equal.setOnClickListener(new View.OnClickListener() 
		{
			public void onClick(View arg0) 
			{
				String exp = textexpression.getText().toString();
				if(exp.isEmpty()) {
					return;
				}
				 else if(exp.charAt(exp.length()-1) == '+' || exp.charAt(exp.length()-1) == '-' || exp.charAt(exp.length()-1) == 'x' || exp.charAt(exp.length()-1) == '��' ) {
					Toast toast = Toast.makeText(getApplicationContext(), "�߸��Ƚ��Դϴ�.", Toast.LENGTH_SHORT);
				   	toast.show();
					   return;
				 }//�ӽ� ����

				else if(check_ans()) {
					textexpression.setText("");
				}
				else if(check_equal()) {
					textexpression.setText("");
				}
				else if(exp.charAt(exp.length()-1) == '.')
					return;
				else if(!exp.contains("+") && !exp.contains("-") && !exp.contains("x") && !exp.contains("��") )
					textexpression.append("="+exp);
				else if(exp.charAt(0) == '-' ) //������ �����ϸ�(ans������ ������.�ƴϸ� ���� �Ǿ� �����ϰ��ұ�?
					textexpression.setText(Calc.calc("0" + exp));
				else
					textexpression.setText(Calc.calc(textexpression.getText().toString()));

			}
		});
		ans.setOnLongClickListener(new View.OnLongClickListener() {
		    @Override
		    public boolean onLongClick(View v) {
		    	arr_sum.clear();
		    	Toast toast = Toast.makeText(getApplicationContext(), "ANS ��� �ʱ�ȭ", Toast.LENGTH_SHORT);
			   	toast.show();
		        return true; 
		    }
		});



  
		ans.setOnClickListener(new View.OnClickListener() 
		{
			public void onClick(View arg0) 
			{
				
				/// 3,6,9
				/// 6 ������ ans������ �ñ�
				//boolean if_i_did = false;  //�̰ɷ� ans�� �Ѱ��� �׳ɾ��� ans���������� �ɷ����°� �߰��ؾ���!!!
				String exp = textexpression.getText().toString();
	
				if(!arr_sum.isEmpty()) {

						if(exp.equals("")) {
							textexpression.setText(arr_sum.get(index_Arr_sum).toString());
							index_Arr_sum++;
							pushed_ans = true;
						}
						else if(check_equal()) {
							textexpression.setText(arr_sum.get(index_Arr_sum).toString());
							index_Arr_sum++;
							pushed_ans = true;
						}
						else if (index_Arr_sum == 0) {
							if(exp.equals(arr_sum.get(arr_sum.size()-1).toString())
									&& pushed_ans == true) {
								textexpression.setText(arr_sum.get(index_Arr_sum).toString());
								index_Arr_sum++;
								pushed_ans = true;
							}
							else if(exp.charAt(exp.length()-1) == '+' || exp.charAt(exp.length()-1) == '-' || exp.charAt(exp.length()-1) == 'x' || exp.charAt(exp.length()-1) == '��'
									&& pushed_ans == true) {
								textexpression.append(arr_sum.get(index_Arr_sum).toString());
								index_Arr_sum++;
								pushed_ans = true;
							}
							else if( exp.length() - (arr_sum.get(arr_sum.size()-1).toString().length()) < 0)
								return;
							else if( exp.substring(exp.length() - (arr_sum.get(arr_sum.size()-1).toString().length())).equals(arr_sum.get(arr_sum.size()-1).toString())
									&& pushed_ans == true) {
								textexpression.setText(exp.substring(0, exp.length() - arr_sum.get(arr_sum.size()-1).toString().length()) + arr_sum.get(index_Arr_sum).toString() );
								index_Arr_sum++;
								pushed_ans = true;
							}
							
						}
						else if (index_Arr_sum != 0) {
							if(exp.equals(arr_sum.get(index_Arr_sum-1).toString())
									&& pushed_ans == true) {
								textexpression.setText(arr_sum.get(index_Arr_sum).toString());
								index_Arr_sum++;
								pushed_ans = true;
							}
							else if(exp.charAt(exp.length()-1) == '+' || exp.charAt(exp.length()-1) == '-' || exp.charAt(exp.length()-1) == 'x' || exp.charAt(exp.length()-1) == '��'
									&& pushed_ans == true) {
								textexpression.append(arr_sum.get(index_Arr_sum).toString());
								index_Arr_sum++;
								pushed_ans = true;
							}
							else if( exp.length() - (arr_sum.get(index_Arr_sum-1).toString().length()) < 0)
								return;
							else if( exp.substring(exp.length() - (arr_sum.get(index_Arr_sum-1).toString().length())).equals(arr_sum.get(index_Arr_sum-1).toString())
									&& pushed_ans == true ) {
								textexpression.setText(exp.substring(0, exp.length() - arr_sum.get(index_Arr_sum-1).toString().length() ) + arr_sum.get(index_Arr_sum).toString() );
								index_Arr_sum++;
								pushed_ans = true;
							}
						}
				}
				
				else 
					textexpression.setText("���� ��갪�� �����ϴ�.");
	
				
				
				if(index_Arr_sum>arr_sum.size()-1)
					index_Arr_sum = 0; //ans�� pop���ϰ� ��ȸ�ϸ鼭 ��������..	
			}
		});
		keypad.setOnClickListener(new View.OnClickListener() 
		{
			public void onClick(View arg0) 
			{
				if(bottom_layout.getVisibility()==View.GONE)
			    {
				    exp_layout.setVisibility(View.VISIBLE);
					bottom_layout.setVisibility(View.VISIBLE);
			    }
			    else
			    {
				    exp_layout.setVisibility(View.GONE);
				    bottom_layout.setVisibility(View.GONE);
			    }
				/*
				InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);

				imm.toggleSoftInput (InputMethodManager.SHOW_FORCED, 0);
	*/
			}
		});
		addlist.setOnClickListener(new View.OnClickListener() 
		{
			@TargetApi(Build.VERSION_CODES.GINGERBREAD)
			@SuppressLint("NewApi")
			public void onClick(View arg0) 
			{
				
				
				adapter.add(textname.getText().toString());
				adapter.notifyDataSetInvalidated();
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
		

	
  }
    public	void  onPopupButtonClick(View button) {
		
		PopupMenu popup  = new PopupMenu(this,send);
		popup.getMenuInflater().inflate(R.menu.popup, popup.getMenu());
		popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
			
			
			@Override
			public boolean onMenuItemClick(MenuItem item) {
				// TODO Auto-generated method stub
				switch(item.getItemId())
				{
				case R.id.sms:
					
					
					Uri smsUri=Uri.parse("tel:1234");
				       Intent retunIt= new Intent(Intent.ACTION_VIEW,smsUri);
				       
				       retunIt.putExtra("sms_body", textmain.getText().toString());
				      
				       retunIt.setType("vnd.android-dir/mms-sms");
				       startActivity(retunIt);
					
					break;
				case R.id.kakao: 
				{
					
					KakaoLink kakaoLink = KakaoLink.getLink(getApplicationContext());
		            
		            if (!kakaoLink.isAvailableIntent()) {
		            	Toast toast = Toast.makeText(getApplicationContext(), "�߸��Ƚ��Դϴ�.", Toast.LENGTH_SHORT);
		    		   	toast.show();
		                 // alert("īī������ ��ġ�Ǿ� ���� �ʽ��ϴ�.");
		                  return false;
		            }
		            if(!textmain.getText().toString().equals("")) {
		            	kakaoLink.openKakaoLink(MainActivity.this, "http//:���ôٿ�����ּҾ���", textmain.getText().toString(),"2.0",
		            		      "0515", "Calc_sj_beta", "UTF-8"); 
		            }
		            else
		            	return false;
					
					break;
				}
				}
				return true;
			}
		});
		popup.show();
		
		
	}
   
    public boolean check_empty() {
    	String text = textexpression.getText().toString();
    	return text.isEmpty();
    }
    private int findEqualIndex(String exp) {
    	for(int i=0; i<exp.length()-1; i++)
    		if(exp.charAt(i) == '=')	
    			return i;
    	return -1;
    }

  
    public boolean check_equal() {
    	String text = textexpression.getText().toString();
    	return text.contains("=");
    }
    
    public boolean check_ans() {
    	String text = textexpression.getText().toString();
    	return text.equals("���� ��갪�� �����ϴ�.");
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
    
  @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

  public boolean onKeyDown(int keyCode, KeyEvent event)
  {
    if ( event.getAction() == KeyEvent.ACTION_DOWN )
    {
        if ( keyCode == KeyEvent.KEYCODE_BACK )
        {
        }
        if ( keyCode == KeyEvent.KEYCODE_MENU )
        {
        	Toast toast = Toast.makeText(getApplicationContext(), "credit: ��ǥ��-����ȣ , ������ -�̼���,����� .", Toast.LENGTH_LONG);
		   	toast.show();
        }
    }
    return super.onKeyDown(keyCode, event);
  }
}




/*
0. ans ��������� �ٽ� �Է��ϸ� �ñ�°�
 	
1. ans ����� ��Ͽ� �߰��� �͸� ��µǵ��� ��ɱ����ϱ� (����)

2. �ؽ�Ʈ�� ���̴� ��Ŀ�� ������ (����)


3. �ؽ�Ʈ(��ġ�ϼ���)
   ��(
 
4. �ؽ�Ʈ �Է��ϰ�, ���� ������ ���ǳ��������� ��ɱ����ϱ� (���)
   ���� �������� ���� �� ���� ����� �����ϴ� ����. (���ǳ����°� �� ����Ű)

5. �հ� ����� �����̰� ���Ѵ�� ���� (����)
   >  ��ü ���� ��ư �� ������ ���� ��� ����Ʈ ���̴� �������� �ű�� 
      ��ü ���� ��ư ��� �հ� ��ư���� ����
   >  ���� ��ư�� ��ġ�� �ؽ�Ʈ/�� �� ���� ��ġ
   >  ���� ��ư ������ ���� �ڿ� (-) ǥ�� ���ֱ�
 
6. �ܾ� �ϼ������ ����̰� ���Ѵ�� ���� (���)
   > ����Ʈ�� �ö󰬴� �ܾ� �Ǵ� ���� �Ʒ� ����Ʈ�� ������

7. ���� ��� (���)

8. ���� ������ ��� (���)

9. .0���� �����°� ������ �ϱ� (����) //ok

10. �����е� ũ�Ⱑ �ٸ�
 	
*/
