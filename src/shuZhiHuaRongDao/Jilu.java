package shuZhiHuaRongDao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Jilu {
	private int sec;
	private int min;
	private int hour;
	private StringTokenizer st;
	private int step;
	private int nandu;
	private String name;
	private String[] a,b,c,an,bn,cn;
	public int getSec() {
		return sec;
	}
	public void setSec(int sec) {
		this.sec = sec;
	}
	public int getMin() {
		return min;
	}
	public void setMin(int min) {
		this.min = min;
	}
	public int getHour() {
		return hour;
	}
	public void setHour(int hour) {
		this.hour = hour;
	}
	public int getStep() {
		return step;
	}
	public void setStep(int step) {
		this.step = step;
	}
	public int getNandu() {
		return nandu;
	}
	public void setNandu(int nandu) {
		this.nandu = nandu;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String[] getA() {
		reada();
		return a;
	}
	public void setA(String[] a) {
		this.a = a;
	}
	public String[] getB() {
		readb();
		return b;
	}
	public void setB(String[] b) {
		this.b = b;
	}
	public String[] getC() {
		readc();
		return c;
	}
	public void setC(String[] c) {
		this.c = c;
	}
	public String[] getAn() {
		readan();
		return an;
	}
	public void setAn(String[] an) {
		this.an = an;
	}
	public String[] getBn() {
		readbn();
		return bn;
	}
	public void setBn(String[] bn) {
		this.bn = bn;
	}
	public String[] getCn() {
		readcn();
		return cn;
	}
	public void setCn(String[] cn) {
		this.cn = cn;
	}
	private String read_file(String file) throws IOException {
		String best = "";
		FileInputStream fis = new FileInputStream(file);
		BufferedReader dis = new BufferedReader(new InputStreamReader(fis));
		try
		{
			best = dis.readLine();
		}
		finally
		{
			dis.close();
		}
		return best;
	}
	//设置文件内容
	private void writecharts (String s,String file) throws IOException{
		FileWriter fw = null;
		BufferedWriter bw = null;
		try {
			fw = new FileWriter(file);//关联文件
			bw = new BufferedWriter(fw);
			bw.write(s);
			bw.flush();
		}finally{
			try {
				bw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				fw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public void reada() {
		String ra="";
		a = new String[9];
		try {
			ra=read_file("a.txt");
			st = new StringTokenizer(ra, ";");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(int i=0;i<9;i++) {
			a[i]=st.nextToken();
		}
	}
	public void readan() {
		String ran="";
		an = new String[9];
		try {
			ran=read_file("an.txt");
			st = new StringTokenizer(ran, ";");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(int i=0;i<9;i++) {
			an[i]=st.nextToken();
		}
	}
	public void readb() {
		String rb="";
		b = new String[9];
		try {
			rb=read_file("b.txt");
			st = new StringTokenizer(rb, ";");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(int i=0;i<9;i++) {
			b[i]=st.nextToken();
		}
	}
	public void readbn() {
		String rbn="";
		bn = new String[9];
		try {
			rbn=read_file("bn.txt");
			st = new StringTokenizer(rbn, ";");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(int i=0;i<9;i++) {
			bn[i]=st.nextToken();
		}
	}
	public void readc() {
		String rc="";
		c = new String[9];
		try {
			rc=read_file("c.txt");
			st = new StringTokenizer(rc, ";");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(int i=0;i<9;i++) {
			c[i]=st.nextToken();
		}
	}
	public void readcn() {
		String rcn="";
		cn = new String[9];
		try {
			rcn=read_file("cn.txt");
			st = new StringTokenizer(rcn, ";");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(int i=0;i<9;i++) {
			cn[i]=st.nextToken();
		}
	}
	public void writea() {
		a=getA();
		String wa ="";
		String smh = Integer.toString(hour)+":"+Integer.toString(min)+":"+Integer.toString(sec);
		for (int j = 0; j < a.length; j++) {
			if (nandu == j&&a[j].equals("0:0:0")||a[j].equals("00:00:00")) {
				a[j]=Integer.toString(hour)+":"+Integer.toString(min)+":"+Integer.toString(sec);
			} else if(nandu==j){
				st=new StringTokenizer(a[j], ":");
				a[j]=Integer.parseInt(st.nextToken())*360+
						Integer.parseInt(st.nextToken())*60+Integer.parseInt(st.nextToken())
						<hour*360+min*60+sec?a[j]:smh;
			}
			wa+=a[j]+";";
		}
		//String wa = "0:0:0;0:0:0;0:0:0;0:0:0;0:0:0;0:0:0;0:0:0;0:0:0;0:0:0;";
		try {
			writecharts(wa, "a.txt");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void writean() {
		an=getAn();
		String wan="";
		for (int i = 0; i < an.length; i++) {
			if (nandu==i) {
				an[i]="YOU";
			}
			wan+=an[i]+";";
		}
		//String wan = "电脑;电脑;电脑;电脑;电脑;电脑;电脑;电脑;电脑;";
		try {
			writecharts(wan, "an.txt");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	public void writeb() {
		b=getB();
		String wb="";
		String wstep = Integer.toString(step);
		for (int j = 0; j < b.length; j++) {
			if (nandu==j&&b[j].equals("0")) {
				b[j]=wstep;
			} else {
				b[j]=Integer.parseInt(b[j])<step?b[j]:wstep;
			}
			wb+=b[j]+";";
		}
		//String wb="0;0;0;0;0;0;0;0;0;";
		try {
			writecharts(wb, "b.txt");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	public void writebn() {
		bn=getBn();
		String wbn="";
		for (int i = 0; i < bn.length; i++) {
			if (nandu==i) {
				bn[i]="YOU";
			}
			wbn+=bn[i]+";";
		}
		//String wbn = "电脑;电脑;电脑;电脑;电脑;电脑;电脑;电脑;电脑;";
		try {
			writecharts(wbn, "bn.txt");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	public void writec() {
		c=getC();
		String wc="";
		String hmss = Double.toString((hour*360+min*60+sec)*1.0/step);
		for (int j = 0; j < c.length; j++) {
			if (nandu==j&&c[j].equals("0")) {
				c[j]=hmss;
			} else {
				c[j]=Double.parseDouble(c[j])<step?c[j]:hmss;
			}
			wc+=c[j]+";";
		}
		//String wc="0;0;0;0;0;0;0;0;0;";
		try {
			writecharts(wc, "c.txt");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	public void writecn() {
		cn=getCn();
		String wcn="";
		for (int i = 0; i < an.length; i++) {
			if (nandu==i) {
				cn[i]="YOU";
			}
			wcn+=cn[i]+";";
		}
		//String wcn = "电脑;电脑;电脑;电脑;电脑;电脑;电脑;电脑;电脑;";
		try {
			writecharts(wcn, "cn.txt");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
}
