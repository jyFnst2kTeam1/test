package per.kayu.test;

public class Huge3 {

	public static void main(String[] args){
		 long beforeTime=System.currentTimeMillis();
		long i_two = 0;
		long i_three = 0;
		int num = 987654321;
		for(int i=1;i<=num;i++){
			int temp_num1=i;
			while(true){
				if(temp_num1%2!=0){
					break;
				}else{
					temp_num1=temp_num1/2;
					i_two++;
				}
				
			}
			int temp_num2=i;
			while(true){
				if(temp_num2%3!=0){
					break;
				}else{
					temp_num2=temp_num2/3;
					i_three++;
				}
				
			}
		}
		System.out.println(i_two);
		System.out.println(i_two/2);
		System.out.println(i_three);
		
		 long afterTime=System.currentTimeMillis();
	        long timeDistance=afterTime-beforeTime;

	        System.out.println(timeDistance);
		

	       
	}
	
	
}
