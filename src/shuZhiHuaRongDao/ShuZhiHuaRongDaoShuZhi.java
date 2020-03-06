package shuZhiHuaRongDao;

/**
 * 
 * @author 向贵龙
 *  用于生成n*n宫格随机数排表，末尾值为0或者为空（待定）
 */
public class ShuZhiHuaRongDaoShuZhi {
	private int a;/*宫格大小，限制条件大于2*/
	private String[][] array;/*宫格数组*/
	private String[] array1;
	private int index = 0;/*统计交换成功的次数*/
	private final String ay = "0";/*用于全局字符串的数字为零的判断,不可以改变*/
	/*构造方法*/
	/** 
	 * @param a
	 * 调用此方法生成一个a*a的二元数组
	 * 此方法中array的默认大小是3*3数组，可通关控制a的大小来改变数组大小，生成array[a][a]数组。
	 * a的范围是3-100；如果超出，则显示默认值3
	 */
	protected ShuZhiHuaRongDaoShuZhi(int a) {
		if(a<=2||a>=100) {
			this.a=3;
			this.array = new String[this.a][this.a];//空数组，根据需要填充数字
			this.array1 = new String[this.a*this.a];
		}else {
			this.a = a;
			this.array = new String[a][a];//空数组，根据需要填充数字
			this.array1 = new String[this.a*this.a];
		}
		Shuzhi();
	}
	/**
	 * 调用此方法需要设置参数a的值
	 */
	protected ShuZhiHuaRongDaoShuZhi() {
		super();
	}
	/*不能创建string的构造方法，防止调用者修改string的数据*/
	
	/*setter，getter方法*/
	/**
	 * 获取生成表格的大小  a*a；
	 * @return a的值
	 */
	protected int getA() {
		return a;
	}
	/**
	 * 设置表格的大小 a*a
	 * (此方法暂时未实现，请勿调用)
	 * @param a
	 */
	protected void setA(int a) {
		if(a<2||a>=100) {
			this.a=3;
			this.array = new String[this.a][this.a];//空数组，根据需要填充数字
		}else {
			this.a = a;
			this.array = new String[this.a][this.a];//空数组，根据需要填充数字
		}
	}
	/*不能创建string[][]的setter方法，防止调用者修改array的数据*/
	/**
	 * 
	 * @return 一个字符串数组，此字符串用于宫格随机数正常排列
	 * 例如：array[3][3]的九个数产生的随机数是437561280；末尾值始终产生0；防止错误
	 * 那么 string返回的值也是437561280，然后再利用其它方式将这个字符串拆分放入到一个宫格里面
	 */
	public String getArray(int x,int y) {
		return array[x][y];
	}
	public String getArray2(int x) {
		int n=0;
		for (int i = 0; i < a; i++) {
			for (int j = 0; j < a; j++) {
				array1[n]=Integer.toString(n+1);
				n++;
			}
		}
		/*
		array1[89]="99";
		array1[88]="90";
		array1[98]="89";*/
		/*
		array1[10]="11";
		array1[11]="15";
		array1[14]="12";
		*/
		array1[4]="6";
		array1[5]="8";
		array1[7]="5";
		return array1[x];

	}
	/**
	 * 
	 * @return 一个字符串数组，此字符串用于宫格随机数正常排列
	 * 例如：array[9]的九个数产生的随机数是437561280；末尾值始终产生0；防止错误
	 * 那么 string返回的值也是437561280，然后再利用其它方式将这个字符串拆分放入到一个宫格里面
	 */
	public String getArray1(int x) {
		int n=0;
		for (int i = 0; i < a; i++) {
			for (int j = 0; j < a; j++) {
				array1[n]=this.getArray(i, j);
				n++;
			}
			
		}
		return array1[x];
	}
	/**
	 * 此方法用于实现随机数据的生成，本方法不给用户实现，用于当前调用
	 * @return 一个字符串数组
	 */
	private String[][] Shuzhi() {
		/*遍历数组并赋值*/
		int numi=1;
		for(int j=0;j<array.length;j++){
			for(int k=0;k<array.length;k++){
				String str="";/*临时字符串，将int型数据转换成字符串*/
				str += numi; 
				array[j][k]= str;
				numi++;
			}
		}
		array[a-1][a-1]="0";
		/*随机改位置*/
		for(int n=0;n<999999;n++) {
			/*统一改位置*/
			for(int ty=0;ty<a;ty++) {
				left();
				top();
			}//第一次归位左上角
			//打乱前三排顺序，防止随机算法未打乱
			for(int ty=0;ty<a;ty++) {
				right();
				bottom();
				right();
				top();
			}
			bottom();
			for(int ty=0;ty<a;ty++) {
				left();
				bottom();
				left();
				top();
			}
			bottom();
			for(int ty=0;ty<a;ty++) {
				right();
				bottom();
				right();
				top();
			}
			for(int ty=0;ty<a;ty++) {
				left();
				bottom();
				left();
				top();
			}
			top();
			top();
			/*生成1-4的随机数*/
			SuiJiShu suiJiShu = new SuiJiShu(12,1);
			int resault = suiJiShu.getResultnum();
			/*更改数组数字位置*/
			switch (resault) {
			/*空（0）数字和左边数字交换*/
			case 1:
				left();
				break;
			/*空（0）数字和右边数字交换*/
			case 2:
				right();
				break;
			/*空（0）数字和上边数字交换*/
			case 3:
				top();
				break;
			/*空（0）数字和下边数字交换*/
			case 4:
				bottom();
				break;
			/*空（0）数字和左下边数字交换*/
			case 5:
				bottom();
				left();
				break;
			/*空（0）数字和左上边数字交换*/	
			case 6:
				left();
				top();
				break;
			/*空（0）数字和右下边数字交换*/
			case 7:
				bottom();
				right();
				break;
			/*空（0）数字和右上边数字交换*/
			case 8:
				top();
				right();
				break;
			case 9:
				top();
				right();
				bottom();
				break;
			case 10:
				top();
				left();
				bottom();
				break;
			case 11:
				bottom();
				right();
				top();
				right();
				break;
			case 12:
				top();
				left();
				bottom();
				left();
				break;
			default:
				break;
			}
			if(index>50000 &&array[a-1][a-1].equals(ay)) {
				return array;
			}
		}
		return array;
	}
	/**
	 * 此方法在array[][]数组中执行array[i][j]=array[i][j-1];array[i][j-1]=0;
	 */
	 private void left() {
		 for(int i=0;i<array.length;i++){
				for(int j=0;j<array.length;j++){
					while(array[i][j].equals(ay)&&(j-1)>=0){ 					
						array[i][j]=array[i][j-1];
						array[i][j-1]=ay;
						index++;
						break;
		 			}
				}
			}
	 }
	 /**
	  * 此方法在array[][]数组中执行array[i][j]=array[i][j+1];array[i][j+1]=0;
	  */
	private void right() {
		for(int i=0;i<array.length;i++){
			for(int j=0;j<array.length;j++){
				while(array[i][j].equals(ay)&&(j+1)<a){ 					
					array[i][j]=array[i][j+1];
					array[i][j+1]=ay;
					index++;
					break;
	 			}
			}
		}
	}
	/**
	 * 此方法在array[][]数组中执行array[i][j]=array[i-1][j];array[i-1][j]=0;
	 */
	private void top() {
		for(int i=0;i<array.length;i++){
			for(int j=0;j<array.length;j++){
				while(array[i][j].equals(ay)&&(i-1)>=0){ 					
					array[i][j]=array[i-1][j];
					array[i-1][j]=ay;
					index++;
					break;
	 			}
			}
		}
	}
	/**
	 * 此方法在array[][]数组中执行array[i][j]=array[i+1][j];array[i+1][j]=0;
	 */
	private void bottom() {
		for(int i=0;i<array.length;i++){
			for(int j=0;j<array.length;j++){
				while(array[i][j].equals(ay)&&(i+1)<a){ 					
					array[i][j]=array[i+1][j];
					array[i+1][j]=ay;
					index++;
					break;
	 			}
			}
		}
	}
}
