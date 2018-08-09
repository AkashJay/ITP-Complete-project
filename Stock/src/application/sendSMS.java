package application;

import com.teknikindustries.bulksms.SMS;

public class sendSMS {

	public void sms(String msg,String number) {
		 int a=2;
		 char no[]=new char[11];
		 no[0]='9';
		 no[1]='4';
		 
		 for(int i=1;i<number.length();i++){
			 
			 no[a]=number.charAt(i);
			 a++;
		 }
		 String num=String.valueOf(no);
		 System.out.println(num+"aaaaaaaaaaaaaaaaaaaaaaaaaa");
		 
		try {
			 SMS sms=new SMS();
			 sms.SendSMS("dressmo99 ", "shalika93", msg, num, "https://bulksms.vsms.net/eapi/submission/send_sms/2/2.0");
			
			
			
		} catch (Exception e2) {
			System.out.println(e2);
			
		}
	}
}
