package shuZhiHuaRongDao;

public class Paoshaizi {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SuiJiShu shu = new SuiJiShu(6,1);
		int a,b,c,d,e,f;
		a=0;b=0;c=0;d=0;e=0;f=0;
		int num;
		for (int i = 0; i < 10000; i++) {
			num=shu.getResultnum();
			if (num==1) {
				a++;
			} else if(num==2){
				b++;
			}else if(num==3){
				c++;
			}else if(num==4){
				d++;
			}else if(num==5){
				e++;
			}else if(num==6){
				f++;
			}
		}
		System.out.println(a+";"+b+";"+c+";"+d+";"+e+";"+f);
	}	

}
