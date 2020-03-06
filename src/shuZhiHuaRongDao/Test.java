package shuZhiHuaRongDao;

import java.awt.Dialog.ModalExclusionType;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.SystemColor;
import java.awt.Toolkit;

import javax.imageio.ImageIO;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.StringTokenizer;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import javax.swing.SwingConstants;

import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JLabel;


import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;



public class Test {
	//定义变量存储时分秒
	private int hour;
	private int min;
	private int sec;
	private boolean isRun = true;
	private JLabel timech;
	private boolean yingxiao=false;
	/**
	 * 主界面frame
	 */
	private JFrame frame;
	/**
	 * 开始游戏frame
	 */
	private JFrame frame1;
	/**
	 * 继续游戏frame
	 */
	private JFrame frame2;
	/**
	 * 帮助文档frame
	 */
	private JFrame frame3;
	/**
	 * 游戏界面frame
	 */
	private JFrame frame4;
	/**
	 * 设置界面frame5
	 */
	private JFrame frame5;
	private ImageIcon icon;
	private Dimension scrnsize;
	private ShuZhiHuaRongDaoShuZhi shuZhi;
	/**
	 * frame4全局变量
	 */
	private int yd=0;

	Jilu jilu = new Jilu();
	private int f4w;
	private int f4h;
	private int []f4x=new int[121];
	private int []f4y=new int[121];
	private List<JPanel> JPlist = new ArrayList<JPanel>();
	private List<JLabel> JLlist = new ArrayList<JLabel>();
	private JLabel label;
	private JButton shezi4;
	private JButton kaishi;
	private JFileChooser chooser;
	private StringTokenizer st;
	private JLabel showtime;
	private String file="";
	private String src = "3230001.jpg";
	private JButton retu;
	private JButton goon;
	private JButton exit;
	private JButton three;
	private JButton four;
	private JButton five;
	private JButton six;
	private JButton seven;
	private JButton eight;
	private JButton nine;
	private JButton ten;
	private JButton eleven;
	private int numa=0;
	//frame2界面全局变量
	private JButton timecharts;
	private JButton stepcharts;
	private	JButton totalcharts;
	//private JPanel Panel_1;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					Test window = new Test();
					window.frame.setVisible(true);
					window.frame1.setVisible(false);
					window.frame2.setVisible(false);
					window.frame3.setVisible(false);
					window.frame4.setVisible(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	/**
	 * 初始化坐标方法//即将过时//采用宫格方法
	 * @param x
	 * @param y
	 * @param wh
	 * @param num
	 */
	public void zbcsf(int x,int y,int wh,int num) {
		for (int i = 0; i < f4x.length; i++) {
			f4x[i]=f4y[i]=-60;
		}
		int n=0;
		for (int i = 0; i < num; i++) {
			for (int j = 0; j < num; j++) {
				f4y[n]=y+i*wh;
				f4x[n]=x+j*wh;
				n++;
			}
		}
	}
	/**
	 * 生成宫格方法//此方法暂未成功//
	 * @param index
	 * @param wh
	 * @param x
	 * @param y
	 */
	/*public void gongge(int index,int wh,int x,int y) {
		Panel_1 = new JPanel();
		for(int i=0;i<index*index;i++){
			Panel_1.setBackground(Color.BLUE);
			Panel_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
			list.add(Panel_1);
		}
		for (int i=0;i<index;i++) {
			for (int j = 0; j < index; j++) {
				list.get(i*j).setVisible(true);
				list.get(i*j).setBounds(x+j*wh, y+i*wh, wh, wh);
				frame4.getContentPane().add(list.get(i*j));
				System.out.println(list.get(i*j));
			}
		}
		for(;num<list.size();num++) {
			list.get(index).addMouseListener(new MouseAdapter() {
				int n=num;
				int w=list.get(n).getWidth();
				int h=list.get(n).getHeight();
				@Override
				public void mouseClicked(MouseEvent e) {
					if (true) {
						
					}else if(true){

					}else if(true){

					}else if(true){

					}
				}
			});
		}
		
	}*/


	/**
	 * Create the application.
	 */
	public Test() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		//初始化主界面窗口
		frame = new JFrame();
		frame.setTitle("超级数字华容道");
		frame.setUndecorated(true);
		frame.setResizable(false);
		int yanse = 1;
		frame.setModalExclusionType(ModalExclusionType.TOOLKIT_EXCLUDE);
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		scrnsize = toolkit.getScreenSize();
		frame.setBounds((scrnsize.width-600)/2,(scrnsize.height-400)/2 , 600, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.getRootPane().setWindowDecorationStyle(yanse);

		//初始化开始游戏窗口
		frame1 = new JFrame("选择关卡");
		frame1.getContentPane().setForeground(new Color(255, 255, 255));
		frame1.setUndecorated(true);
		frame1.setResizable(false);
		frame1.setModalExclusionType(ModalExclusionType.TOOLKIT_EXCLUDE);
		frame1.setBounds((scrnsize.width-600)/2,(scrnsize.height-400)/2 , 600, 400);
		frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame1.getContentPane().setLayout(null);
		frame1.getRootPane().setWindowDecorationStyle(yanse);
		//初始化继续游戏窗口
		frame2 = new JFrame("数字华容道");
		frame2.setUndecorated(true);
		frame2.setResizable(false);
		frame2.setModalExclusionType(ModalExclusionType.TOOLKIT_EXCLUDE);
		frame2.setBounds((scrnsize.width-600)/2,(scrnsize.height-400)/2 , 600, 400);
		frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame2.getContentPane().setLayout(null);
		frame2.getRootPane().setWindowDecorationStyle(yanse);
		//初始化游戏简介窗口
		frame3 = new JFrame("游戏简介");
		frame3.setUndecorated(true);
		frame3.setResizable(false);
		frame3.setModalExclusionType(ModalExclusionType.TOOLKIT_EXCLUDE);
		frame3.setBounds((scrnsize.width-600)/2,(scrnsize.height-400)/2 , 600, 400);
		frame3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame3.getContentPane().setLayout(null);
		frame3.getRootPane().setWindowDecorationStyle(yanse);

		//初始化运行游戏窗口
		frame4 = new JFrame("数字华容道");
		frame4.setUndecorated(true);
		frame4.setResizable(false);
		frame4.setModalExclusionType(ModalExclusionType.TOOLKIT_EXCLUDE);
		frame4.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame4.getContentPane().setLayout(null);
		frame4.getRootPane().setWindowDecorationStyle(yanse);
		//设置窗口
		frame5 = new JFrame("设置窗口");
		frame5.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosed(WindowEvent e) {
				frame5.setVisible(false);
				frame4.setVisible(true);
			}
		});
		frame5.setBounds(100, 100, 450, 300);
		frame5.getContentPane().setLayout(null);
		/**
		 * 设置窗口界面设计
		 */
		JRadioButton yanshe1 = new JRadioButton("");
		yanshe1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (yanshe1.isSelected()) {
					((JPanel)frame4.getContentPane()).setOpaque(true);
					frame4.getContentPane().setBackground(Color.MAGENTA);
				}
			}
		});
		yanshe1.setBackground(Color.MAGENTA);
		yanshe1.setBounds(130, 49, 21, 23);
		frame5.getContentPane().add(yanshe1);

		JRadioButton yanshe2 = new JRadioButton("");
		yanshe2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (yanshe2.isSelected()) {
					((JPanel)frame4.getContentPane()).setOpaque(true);
					frame4.getContentPane().setBackground(Color.WHITE);
				}
			}
		});
		yanshe2.setBackground(Color.WHITE);
		yanshe2.setBounds(151, 49, 21, 23);
		frame5.getContentPane().add(yanshe2);

		JRadioButton yanshe3 = new JRadioButton("");
		yanshe3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (yanshe3.isSelected()) {
					((JPanel)frame4.getContentPane()).setOpaque(true);
					frame4.getContentPane().setBackground(Color.LIGHT_GRAY);
				}
			}
		});
		yanshe3.setBackground(Color.LIGHT_GRAY);
		yanshe3.setBounds(172, 49, 21, 23);
		frame5.getContentPane().add(yanshe3);

		JRadioButton yanshe4 = new JRadioButton("");
		yanshe4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (yanshe4.isSelected()) {
					((JPanel)frame4.getContentPane()).setOpaque(true);
					frame4.getContentPane().setBackground(Color.GRAY);
				}
			}
		});
		yanshe4.setBackground(Color.GRAY);
		yanshe4.setBounds(193, 49, 21, 23);
		frame5.getContentPane().add(yanshe4);

		JRadioButton yanshe5 = new JRadioButton("");
		yanshe5.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (yanshe5.isSelected()) {
					((JPanel)frame4.getContentPane()).setOpaque(true);
					frame4.getContentPane().setBackground(Color.CYAN);
				}
			}
		});
		yanshe5.setBackground(Color.CYAN);
		yanshe5.setBounds(214, 49, 21, 23);
		frame5.getContentPane().add(yanshe5);

		JRadioButton yanshe6 = new JRadioButton("");
		yanshe6.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (yanshe6.isSelected()) {
					((JPanel)frame4.getContentPane()).setOpaque(true);
					frame4.getContentPane().setBackground(Color.BLUE);
				}
			}
		});
		yanshe6.setBackground(Color.BLUE);
		yanshe6.setBounds(235, 49, 21, 23);
		frame5.getContentPane().add(yanshe6);

		JRadioButton yanshe7 = new JRadioButton("");
		yanshe7.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (yanshe7.isSelected()) {
					((JPanel)frame4.getContentPane()).setOpaque(true);
					frame4.getContentPane().setBackground(Color.GREEN);
				}
			}
		});
		yanshe7.setBackground(Color.GREEN);
		yanshe7.setBounds(256, 49, 21, 23);
		frame5.getContentPane().add(yanshe7);

		JRadioButton yanshe8 = new JRadioButton("");
		yanshe8.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (yanshe8.isSelected()) {
					((JPanel)frame4.getContentPane()).setOpaque(true);
					frame4.getContentPane().setBackground(Color.PINK);
				}
			}
		});
		yanshe8.setBackground(Color.PINK);
		yanshe8.setBounds(277, 49, 21, 23);
		frame5.getContentPane().add(yanshe8);

		JRadioButton yanshe9 = new JRadioButton("");
		yanshe9.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (yanshe9.isSelected()) {
					((JPanel)frame4.getContentPane()).setOpaque(true);
					frame4.getContentPane().setBackground(Color.RED);
				}
			}
		});
		yanshe9.setBackground(Color.RED);
		yanshe9.setBounds(298, 49, 21, 23);
		frame5.getContentPane().add(yanshe9);

		JRadioButton yanshe10 = new JRadioButton("");
		yanshe10.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (yanshe10.isSelected()) {
					((JPanel)frame4.getContentPane()).setOpaque(true);
					frame4.getContentPane().setBackground(Color.ORANGE);
				}
			}
		});
		yanshe10.setBackground(Color.ORANGE);
		yanshe10.setBounds(319, 49, 21, 23);
		frame5.getContentPane().add(yanshe10);

		JRadioButton yanshe11 = new JRadioButton("");
		yanshe11.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (yanshe11.isSelected()) {
					((JPanel)frame4.getContentPane()).setOpaque(true);
					frame4.getContentPane().setBackground(Color.BLACK);
				}
			}
		});
		yanshe11.setBackground(Color.BLACK);
		yanshe11.setBounds(340, 49, 21, 23);
		frame5.getContentPane().add(yanshe11);

		ButtonGroup group = new ButtonGroup();
		group.add(yanshe1);
		group.add(yanshe2);
		group.add(yanshe3);
		group.add(yanshe4);
		group.add(yanshe5);
		group.add(yanshe6);
		group.add(yanshe7);
		group.add(yanshe8);
		group.add(yanshe9);
		group.add(yanshe10);
		group.add(yanshe11);

		JLabel szlb = new JLabel("设置游戏背景：");
		szlb.setFont(new Font("Microsoft JhengHei UI", Font.BOLD, 14));
		szlb.setForeground(Color.RED);
		szlb.setHorizontalAlignment(SwingConstants.CENTER);
		szlb.setBounds(24, 49, 117, 23);
		frame5.getContentPane().add(szlb);
		JButton button = new JButton("选择图片背景");
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				chooser = new JFileChooser();
				FileNameExtensionFilter filter = new FileNameExtensionFilter(
						"JPG & PNG Images", "jpg", "png");
				chooser.setFileFilter(filter);
				Component parent = null;
				chooser.showOpenDialog(parent);
				try {
					st = new StringTokenizer(chooser.getSelectedFile().getAbsolutePath(), "\\");
				} catch (NullPointerException e2) {
					// TODO: handle exception
					return;
				}
				for (int i = 0; i < 100; i++) {
					try {
						String string = st.nextToken();
						file+=string+"\\\\";
					} catch (NoSuchElementException e2) {
						// TODO: handle exception
						break;
					}
				}
				try {
					ImageResizer(file, src,
							frame.getContentPane().getWidth(),
							frame.getContentPane().getHeight());
					ImageIcon img = new ImageIcon(src);
					JLabel imglable= new JLabel(img);
					frame4.getLayeredPane().add(imglable,new Integer(Integer.MIN_VALUE));
					imglable.setBounds(0, 0, img.getIconWidth(), img.getIconHeight());
					((JPanel)frame4.getContentPane()).setOpaque(false);
				} catch (Exception e1) {
					// TODO 自动生成的 catch 块
					e1.printStackTrace();
				}
			}
		});
		button.setBounds(37, 78, 117, 23);
		frame5.getContentPane().add(button);

		JLabel beizhu = new JLabel("设置图片背景时，每次重启都需重新设置");
		beizhu.setBounds(166, 82, 218, 15);
		frame5.getContentPane().add(beizhu);

		/****************************主界面开始***********************************/
		/**
		 * 主界面背景设计
		 */
		@SuppressWarnings("serial")
		JPanel panel1 = new JPanel(){
			@Override
			public void paintComponent(Graphics g) {
				/*icon = new ImageIcon("D:"
						+ "\\新建文件夹\\eclipse4.7.2\\workspace\\"
						+ "ShuZhiHuaRongDao_1.0.2\\src\\shuZhiHuaRongDao\\beijin.jpg");*/
				// 图片随窗体大小而变化
				icon = new ImageIcon("beijing.jpg");
				g.drawImage(icon.getImage(), 0, 0, frame.getSize().width,frame.getSize().height,frame);
			}
		};
		panel1.setBounds(0, 0,this.frame.getSize().width,this.frame.getSize().height);
		panel1.setLayout(null);
		frame.getContentPane().add(panel1);

		/**
		 * 主界面元素设计
		 */
		JButton start = new JButton("开始");
		start.setHorizontalAlignment(SwingConstants.RIGHT);
		start.setFont(new Font("Microsoft YaHei UI Light", Font.BOLD, 16));
		start.setForeground(Color.BLACK);
		start.setBackground(Color.ORANGE);
		start.setBounds(-100,110,160,40);
		panel1.add(start);

		JButton next = new JButton("纪录");
		next.setHorizontalAlignment(SwingConstants.RIGHT);
		next.setForeground(Color.BLACK);
		next.setBackground(Color.ORANGE);
		next.setFont(new Font("Microsoft YaHei UI Light", Font.BOLD, 16));
		next.setBounds(-100, 170, 160, 40);
		panel1.add(next);

		JButton help = new JButton("简介");
		help.setHorizontalAlignment(SwingConstants.RIGHT);
		help.setForeground(Color.BLACK);
		help.setBackground(Color.ORANGE);
		help.setFont(new Font("Microsoft YaHei UI Light", Font.BOLD, 16));
		help.setBounds(-100, 230, 160, 40);
		panel1.add(help);
		/**
		 * 主界面元素事件
		 */

		start.addMouseListener(new MouseAdapter() {
			@Override
			/**
			 * 开始游戏鼠标移出
			 */
			public void mouseExited(MouseEvent e) {
				start.setBounds(-100,110,160,40);
				start.setIcon(null);
				start.setText("开始");
				start.setHorizontalAlignment(SwingConstants.RIGHT);
				start.setFont(new Font("Microsoft YaHei UI Light", Font.BOLD, 16));
			}
			@Override
			/**
			 * 开始游戏点击事件
			 */
			public void mouseClicked(MouseEvent e) {
				frame.setVisible(false);
				frame1.setVisible(true);
			}
		});
		start.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			/**
			 * 开始游戏鼠标移入
			 */
			public void mouseMoved(MouseEvent e) {
				start.setBounds(0,110,160,40);
				start.setText(null);
				start.setHorizontalAlignment(SwingConstants.CENTER);
				start.setIcon(new ImageIcon("kaishi.jpg"));
			}
		});
		next.addMouseListener(new MouseAdapter() {
			@Override
			/**
			 * 继续游戏鼠标移出
			 */
			public void mouseExited(MouseEvent e) {
				next.setBounds(-100, 170, 160, 40);
				next.setIcon(null);
				next.setText("纪录");
				next.setHorizontalAlignment(SwingConstants.RIGHT);
				next.setFont(new Font("Microsoft YaHei UI Light", Font.BOLD, 16));
			}
			@Override
			/**
			 * 继续游戏点击事件
			 */
			public void mouseClicked(MouseEvent e) {
				frame.setVisible(false);
				frame2.setVisible(true);
			}
		});
		next.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			/**
			 * 继续游戏鼠标移入
			 */
			public void mouseMoved(MouseEvent e) {
				next.setBounds(0,170,160,40);
				next.setText(null);
				next.setHorizontalAlignment(SwingConstants.CENTER);
				next.setIcon(new ImageIcon("jixu.jpg"));
			}
		});
		help.addMouseListener(new MouseAdapter() {
			@Override
			/**
			 * 游戏简介鼠标移除
			 */
			public void mouseExited(MouseEvent e) {
				help.setBounds(-100, 230, 160, 40);
				help.setIcon(null);
				help.setText("简介");
				help.setHorizontalAlignment(SwingConstants.RIGHT);
				help.setFont(new Font("Microsoft YaHei UI Light", Font.BOLD, 16));
			}
			@Override
			/**
			 * 游戏简介点击事件
			 */
			public void mouseClicked(MouseEvent e) {
				frame.setVisible(false);
				frame3.setVisible(true);
			}
		});
		help.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			/**
			 * 游戏简介鼠标移入
			 */
			public void mouseMoved(MouseEvent e) {
				help.setBounds(0,230,160,40);
				help.setText(null);
				help.setHorizontalAlignment(SwingConstants.CENTER);
				help.setIcon(new ImageIcon("jianjie.jpg"));
			}
		});
		/*frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				
				TimeThread thread= new TimeThread();
				thread.start();
				try {
					TimeThread.sleep(1000);
					isstart=true;
				} catch (InterruptedException e1) {
					// TODO 自动生成的 catch 块
					e1.printStackTrace();
				}
			}
		});*/

		/******************************主界面结束*************************************/
		/******************************开始游戏界面开始*********************************/
		@SuppressWarnings("serial")
		/**
		 * 开始游戏背景设置
		 */
				JPanel panel2 = new JPanel(){
			@Override
			public void paintComponent(Graphics g) {
				icon = new ImageIcon("beijing.jpg");
				// 图片随窗体大小而变化
				g.drawImage(icon.getImage(), 0, 0, frame1.getSize().width,frame1.getSize().height,frame1);
			}
		};
		panel2.setBounds(0, 0,this.frame1.getSize().width,this.frame1.getSize().height);
		panel2.setLayout(null);
		frame1.getContentPane().add(panel2);
		/**
		 * 选择游戏难度按钮
		 */
		/*****************************************************/
		three = new JButton("3*3");
		three.setBounds(180, 80, 80,80);
		panel2.add(three);

		four = new JButton("4*4");
		four.setBounds(260, 80,  80,80);
		panel2.add(four);

		five = new JButton("5*5");
		five.setBounds(340, 80,  80,80);
		panel2.add(five);

		six = new JButton("6*6");
		six.setBounds(180, 160,  80,80);
		panel2.add(six);

		seven = new JButton("7*7");
		seven.setBounds(260, 160,  80,80);
		panel2.add(seven);

		eight = new JButton("8*8");
		eight.setBounds(340, 160, 80,80);
		panel2.add(eight);

		nine = new JButton("9*9");
		nine.setBounds(180, 240,  80,80);
		panel2.add(nine);

		ten = new JButton("10*10");
		ten.setBounds(260, 240, 80,80);
		panel2.add(ten);

		eleven = new JButton("11*11");
		eleven.setBounds(340, 240,  80,80);
		panel2.add(eleven);
		/******************************************************/
		showtime = new JLabel();
		showtime.setBounds(50, 0, 80, 25);
		showtime.setHorizontalAlignment(SwingConstants.LEFT);
		frame4.getContentPane().add(showtime);
		showtime.setBackground(Color.gray);
		showtime.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		showtime.setVisible(false);

		timech = new JLabel("用时：");
		timech.setBounds(0, 0, 50, 20);
		timech.setFont(new Font("华文楷体", Font.PLAIN, 14));
		timech.setHorizontalAlignment(SwingConstants.CENTER);
		frame4.getContentPane().add(timech);
		timech.setVisible(false);

		new Timer();
		three.addMouseListener(new MouseAdapter() {
			@Override
			/**
			 * 150*150窗口，3*3宫格难度
			 */
			public void mouseClicked(MouseEvent e) {
				frame1.setVisible(false);
				f4h=f4w=50;
				zbcsf(125, 45, 50, 3);
				shengcheng();
				shujuchushihua(3*3);
				frame4.setBounds((scrnsize.width-400)/2,(scrnsize.height-300)/2 , 400, 300);
				images();
				goon = new Goon();
				frame4.getContentPane().add(goon);
				label.setSize(frame4.getWidth(),20);
				shezi4.setBounds(frame4.getWidth()-90, 0,80,30);
				kaishi.setBounds(frame4.getWidth()-120, frame4.getHeight()-100,100,35);
				frame4.getContentPane().add(shezi4);
				frame4.getContentPane().add(kaishi);
				frame4.getContentPane().add(label);
				shezi4.setVisible(true);
				kaishi.setVisible(true);
				label.setVisible(true);
				numa=4;
				kaishi.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						sjssc(3*3);
						chenggong(3);
						youxifangfa(3);
						label.setVisible(false);
						kaishi.setVisible(false);
						jilu.setNandu(1);
						if (isRun) {
							sec=0;
							min=0;
							hour=0;
							frame4.getContentPane().add(showtime);
							frame4.getContentPane().add(timech);
							showtime.setVisible(true);
							timech.setVisible(true);
						} else {
							sec=0;
							min=0;
							hour=0;
							isRun=true;
							frame4.getContentPane().add(showtime);
							frame4.getContentPane().add(timech);
							showtime.setVisible(true);
							timech.setVisible(true);
						}
					}
				});
				shezi4.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						frame5.setVisible(true);
					}
				});
				frame4.setVisible(true);
			}
		});
		four.addMouseListener(new MouseAdapter() {
			@Override
			/**
			 * 200*200窗口，4*4宫格难度
			 */
			public void mouseClicked(MouseEvent e) {
				frame1.setVisible(false);
				f4h=f4w=50;
				zbcsf(95, 50, 50, 4);
				shengcheng();
				shujuchushihua(4*4);
				frame4.setBounds((scrnsize.width-400)/2,(scrnsize.height-350)/2 , 400, 350);
				images();
				goon = new Goon();
				frame4.getContentPane().add(goon);
				label.setSize(frame4.getWidth(),20);
				shezi4.setBounds(frame4.getWidth()-90, 0,80,30);
				kaishi.setBounds(frame4.getWidth()-120, frame4.getHeight()-100,100,35);
				frame4.getContentPane().add(shezi4);
				frame4.getContentPane().add(kaishi);
				frame4.getContentPane().add(label);
				shezi4.setVisible(true);
				kaishi.setVisible(true);
				label.setVisible(true);
				numa=5;
				kaishi.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						sjssc(4*4);
						chenggong(4);
						youxifangfa(4);
						label.setVisible(false);
						kaishi.setVisible(false);
						if (isRun) {
							sec=0;
							min=0;
							hour=0;
							frame4.getContentPane().add(showtime);
							frame4.getContentPane().add(timech);
							showtime.setVisible(true);
							timech.setVisible(true);
						} else {
							sec=0;
							min=0;
							hour=0;
							isRun=true;
							frame4.getContentPane().add(showtime);
							frame4.getContentPane().add(timech);
							showtime.setVisible(true);
							timech.setVisible(true);
						}
					}
				});
				shezi4.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						frame5.setVisible(true);
					}
				});
				frame4.setVisible(true);
			}
		});
		five.addMouseListener(new MouseAdapter() {
			@Override
			/**
			 * 250*250窗口，5*5宫格难度
			 */
			public void mouseClicked(MouseEvent e) {
				frame1.setVisible(false);
				f4h=f4w=50;
				zbcsf(85, 45, 50, 5);
				shengcheng();
				shujuchushihua(5*5);
				frame4.setBounds((scrnsize.width-450)/2,(scrnsize.height-338)/2 , 450, 338);
				images();
				goon = new Goon();
				frame4.getContentPane().add(goon);
				label.setSize(frame4.getWidth(),20);
				shezi4.setBounds(frame4.getWidth()-90, 0,80,30);
				kaishi.setBounds(frame4.getWidth()-120, frame4.getHeight()-100,100,35);
				frame4.getContentPane().add(shezi4);
				frame4.getContentPane().add(kaishi);
				frame4.getContentPane().add(label);
				shezi4.setVisible(true);
				kaishi.setVisible(true);
				label.setVisible(true);
				numa=6;
				kaishi.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						sjssc(5*5);
						chenggong(5);
						youxifangfa(5);
						label.setVisible(false);
						kaishi.setVisible(false);
						if (isRun) {
							sec=0;
							min=0;
							hour=0;
							frame4.getContentPane().add(showtime);
							frame4.getContentPane().add(timech);
							showtime.setVisible(true);
							timech.setVisible(true);
						} else {
							sec=0;
							min=0;
							hour=0;
							isRun=true;
							frame4.getContentPane().add(showtime);
							frame4.getContentPane().add(timech);
							showtime.setVisible(true);
							timech.setVisible(true);
						}
					}
				});
				shezi4.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						frame5.setVisible(true);
					}
				});
				frame4.setVisible(true);
			}
		});
		six.addMouseListener(new MouseAdapter() {
			@Override
			/**
			 * 300*300，6*6宫格难度
			 */
			public void mouseClicked(MouseEvent e) {
				frame1.setVisible(false);
				f4h=f4w=50;
				zbcsf(95, 45, 50, 6);
				shengcheng();
				shujuchushihua(6*6);
				frame4.setBounds((scrnsize.width-500)/2,(scrnsize.height-374)/2 , 500, 375);
				images();
				goon = new Goon();
				frame4.getContentPane().add(goon);
				label.setSize(frame4.getWidth(),20);
				shezi4.setBounds(frame4.getWidth()-90, 0,80,30);
				kaishi.setBounds(frame4.getWidth()-120, frame4.getHeight()-100,100,35);
				frame4.getContentPane().add(shezi4);
				frame4.getContentPane().add(kaishi);
				frame4.getContentPane().add(label);
				shezi4.setVisible(true);
				kaishi.setVisible(true);
				label.setVisible(true);
				numa=7;
				kaishi.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						sjssc(6*6);
						chenggong(6);
						youxifangfa(6);
						label.setVisible(false);
						kaishi.setVisible(false);
						if (isRun) {
							sec=0;
							min=0;
							hour=0;
							frame4.getContentPane().add(showtime);
							frame4.getContentPane().add(timech);
							showtime.setVisible(true);
							timech.setVisible(true);
						} else {
							sec=0;
							min=0;
							hour=0;
							isRun=true;
							frame4.getContentPane().add(showtime);
							frame4.getContentPane().add(timech);
							showtime.setVisible(true);
							timech.setVisible(true);
						}
					}
				});
				shezi4.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						frame5.setVisible(true);
					}
				});
				frame4.setVisible(true);
			}
		});
		seven.addMouseListener(new MouseAdapter() {
			@Override
			/**
			 * 280*280，7*7宫格难度
			 */
			public void mouseClicked(MouseEvent e) {
				frame1.setVisible(false);
				f4h=f4w=40;
				zbcsf(85, 45, 40, 7);
				shengcheng();
				shujuchushihua(7*7);
				frame4.setBounds((scrnsize.width-500)/2,(scrnsize.height-374)/2 , 500, 375);
				images();
				goon = new Goon();
				frame4.getContentPane().add(goon);
				label.setSize(frame4.getWidth(),20);
				shezi4.setBounds(frame4.getWidth()-90, 0,80,30);
				kaishi.setBounds(frame4.getWidth()-120, frame4.getHeight()-100,100,35);
				frame4.getContentPane().add(shezi4);
				frame4.getContentPane().add(kaishi);
				frame4.getContentPane().add(label);
				shezi4.setVisible(true);
				kaishi.setVisible(true);
				label.setVisible(true);
				numa=8;
				kaishi.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						sjssc(7*7);
						chenggong(7);
						youxifangfa(7);
						label.setVisible(false);
						kaishi.setVisible(false);
						if (isRun) {
							sec=0;
							min=0;
							hour=0;
							frame4.getContentPane().add(showtime);
							frame4.getContentPane().add(timech);
							showtime.setVisible(true);
							timech.setVisible(true);
						} else {
							sec=0;
							min=0;
							hour=0;
							isRun=true;
							frame4.getContentPane().add(showtime);
							frame4.getContentPane().add(timech);
							showtime.setVisible(true);
							timech.setVisible(true);
						}
					}
				});
				shezi4.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						frame5.setVisible(true);
					}
				});
				frame4.setVisible(true);
			}
		});
		eight.addMouseListener(new MouseAdapter() {
			@Override
			/**
			 * 320*320，8*8宫格难度
			 */
			public void mouseClicked(MouseEvent e) {
				frame1.setVisible(false);
				f4h=f4w=40;
				zbcsf(90, 45, 40, 8);
				shengcheng();
				shujuchushihua(8*8);
				frame4.setBounds((scrnsize.width-500)/2,(scrnsize.height-420)/2 , 550, 420);
				images();
				goon = new Goon();
				frame4.getContentPane().add(goon);
				label.setSize(frame4.getWidth(),20);
				shezi4.setBounds(frame4.getWidth()-90, 0,80,30);
				kaishi.setBounds(frame4.getWidth()-120, frame4.getHeight()-100,100,35);
				frame4.getContentPane().add(shezi4);
				frame4.getContentPane().add(kaishi);
				frame4.getContentPane().add(label);
				shezi4.setVisible(true);
				kaishi.setVisible(true);
				label.setVisible(true);
				numa=9;
				kaishi.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						sjssc(8*8);
						chenggong(8);
						youxifangfa(8);
						label.setVisible(false);
						kaishi.setVisible(false);
						if (isRun) {
							sec=0;
							min=0;
							hour=0;
							frame4.getContentPane().add(showtime);
							frame4.getContentPane().add(timech);
							showtime.setVisible(true);
							timech.setVisible(true);
						} else {
							sec=0;
							min=0;
							hour=0;
							isRun=true;
							frame4.getContentPane().add(showtime);
							frame4.getContentPane().add(timech);
							showtime.setVisible(true);
							timech.setVisible(true);
						}
					}
				});
				shezi4.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						frame5.setVisible(true);
					}
				});
				frame4.setVisible(true);
			}
		});
		nine.addMouseListener(new MouseAdapter() {
			@Override
			/**
			 * 360*360，9*9宫格难度
			 */
			public void mouseClicked(MouseEvent e) {
				frame1.setVisible(false);
				f4h=f4w=40;
				zbcsf(90, 45, 40, 9);
				shengcheng();
				shujuchushihua(9*9);
				frame4.setBounds((scrnsize.width-550)/2,(scrnsize.height-450)/2 , 550, 450);
				images();
				goon = new Goon();
				frame4.getContentPane().add(goon);
				label.setSize(frame4.getWidth(),20);
				shezi4.setBounds(frame4.getWidth()-90, 0,80,30);
				kaishi.setBounds(frame4.getWidth()-120, frame4.getHeight()-100,100,35);
				frame4.getContentPane().add(shezi4);
				frame4.getContentPane().add(kaishi);
				frame4.getContentPane().add(label);
				shezi4.setVisible(true);
				kaishi.setVisible(true);
				label.setVisible(true);
				numa=10;
				kaishi.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						sjssc(9*9);
						chenggong(9);
						youxifangfa(9);
						label.setVisible(false);
						kaishi.setVisible(false);
						if (isRun) {
							sec=0;
							min=0;
							hour=0;
							frame4.getContentPane().add(showtime);
							frame4.getContentPane().add(timech);
							showtime.setVisible(true);
							timech.setVisible(true);
						} else {
							sec=0;
							min=0;
							hour=0;
							isRun=true;
							frame4.getContentPane().add(showtime);
							frame4.getContentPane().add(timech);
							showtime.setVisible(true);
							timech.setVisible(true);
						}
					}
				});
				shezi4.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						frame5.setVisible(true);
					}
				});
				frame4.setVisible(true);

			}
		});
		ten.addMouseListener(new MouseAdapter() {
			@Override
			/**
			 * 400*400，10*10难度
			 */
			public void mouseClicked(MouseEvent e) {
				frame1.setVisible(false);
				f4h=f4w=40;
				zbcsf(125, 45, 40, 10);
				shengcheng();
				shujuchushihua(10*10);
				frame4.setBounds((scrnsize.width-650)/2,(scrnsize.height-500)/2 , 650, 500);
				images();
				goon = new Goon();
				frame4.getContentPane().add(goon);
				label.setSize(frame4.getWidth(),20);
				shezi4.setBounds(frame4.getWidth()-90, 0,80,30);
				kaishi.setBounds(frame4.getWidth()-120, frame4.getHeight()-100,100,35);
				frame4.getContentPane().add(shezi4);
				frame4.getContentPane().add(kaishi);
				frame4.getContentPane().add(label);
				shezi4.setVisible(true);
				kaishi.setVisible(true);
				label.setVisible(true);
				numa=11;
				kaishi.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						sjssc(10*10);
						chenggong(10);
						youxifangfa(10);
						label.setVisible(false);
						kaishi.setVisible(false);
						if (isRun) {
							sec=0;
							min=0;
							hour=0;
							frame4.getContentPane().add(showtime);
							frame4.getContentPane().add(timech);
							showtime.setVisible(true);
							timech.setVisible(true);
						} else {
							sec=0;
							min=0;
							hour=0;
							isRun=true;
							frame4.getContentPane().add(showtime);
							frame4.getContentPane().add(timech);
							showtime.setVisible(true);
							timech.setVisible(true);
						}
					}
				});
				shezi4.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						frame5.setVisible(true);
					}
				});
				frame4.setVisible(true);

			}
		});
		eleven.addMouseListener(new MouseAdapter() {
			@Override
			/**
			 * 440*440，11*11难度
			 */
			public void mouseClicked(MouseEvent e) {
				frame1.setVisible(false);
				f4h=f4w=40;
				zbcsf(130, 45, 40, 11);
				shengcheng();
				shujuchushihua(11*11);
				frame4.setBounds((scrnsize.width-700)/2,(scrnsize.height-550)/2 , 700, 550);
				images();
				goon = new Goon();
				frame4.getContentPane().add(goon);
				label.setSize(frame4.getWidth(),20);
				shezi4.setBounds(frame4.getWidth()-90, 0,80,30);
				kaishi.setBounds(frame4.getWidth()-120, frame4.getHeight()-100,100,35);
				frame4.getContentPane().add(shezi4);
				frame4.getContentPane().add(kaishi);
				frame4.getContentPane().add(label);
				shezi4.setVisible(true);
				kaishi.setVisible(true);
				label.setVisible(true);
				numa=0;
				kaishi.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						sjssc(11*11);
						chenggong(11);
						youxifangfa(11);
						label.setVisible(false);
						kaishi.setVisible(false);
						if (isRun) {
							sec=0;
							min=0;
							hour=0;
							frame4.getContentPane().add(showtime);
							frame4.getContentPane().add(timech);
							showtime.setVisible(true);
							timech.setVisible(true);
						} else {
							sec=0;
							min=0;
							hour=0;
							isRun=true;
							frame4.getContentPane().add(showtime);
							frame4.getContentPane().add(timech);
							showtime.setVisible(true);
							timech.setVisible(true);
						}
					}
				});
				shezi4.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						frame5.setVisible(true);
					}
				});
				frame4.setVisible(true);

			}
		});

		/******************************开始游戏界面结束*********************************/
		/******************************继续游戏界面开始*********************************/
		/**
		 * 继续游戏背景设置
		 */


		JPanel panel3 = new JPanel();
		panel3.setBounds(0, 0,this.frame2.getSize().width,this.frame2.getSize().height);
		panel3.setLayout(null);
		frame2.getContentPane().add(panel3);

		JButton retuf1 = new JButton("返回主界面");
		retuf1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame2.setVisible(false);
				frame.setVisible(true);
			}
		});
		retuf1.setFont(new Font("微软雅黑", Font.BOLD, 18));
		retuf1.setBounds(0, 10, 130, 52);
		panel3.add(retuf1);

		timecharts = new JButton("时间排行榜");
		timecharts.setFont(new Font("微软雅黑", Font.BOLD, 18));
		timecharts.setBounds(140, 10, 130, 52);
		panel3.add(timecharts);

		stepcharts = new JButton("步数排行榜");
		stepcharts.setFont(new Font("微软雅黑", Font.BOLD, 18));
		stepcharts.setBounds(290, 10, 130, 52);
		panel3.add(stepcharts);

		totalcharts = new JButton("总排行榜");
		totalcharts.setFont(new Font("微软雅黑", Font.BOLD, 18));
		totalcharts.setBounds(430, 10, 130, 52);
		panel3.add(totalcharts);
		JPanel tp1 = new JPanel();
		tp1.setBorder(new TitledBorder(null, "3*3", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		tp1.setBounds(46, 81, 120, 71);
		panel3.add(tp1);
		tp1.setLayout(null);

		JLabel tp1n = new JLabel("姓名：");
		tp1n.setHorizontalAlignment(SwingConstants.CENTER);
		tp1n.setBounds(2, 25, 40, 15);
		tp1.add(tp1n);

		JLabel tpt1 = new JLabel("时间：");
		tpt1.setHorizontalAlignment(SwingConstants.CENTER);
		tpt1.setBounds(2, 50, 40, 15);
		tp1.add(tpt1);

		JLabel tn1 = new JLabel(jilu.getAn()[0]);
		tn1.setBounds(35, 25, 54, 15);
		tp1.add(tn1);

		JLabel tt1 = new JLabel(jilu.getA()[0]);
		tt1.setBounds(35, 50, 54, 15);
		tp1.add(tt1);

		JPanel tp2 = new JPanel();
		tp2.setBorder(new TitledBorder(null, "4*4", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		tp2.setBounds(218, 81, 120, 71);
		panel3.add(tp2);
		tp2.setLayout(null);

		JLabel tp2n = new JLabel("姓名：");
		tp2n.setHorizontalAlignment(SwingConstants.CENTER);
		tp2n.setBounds(2, 25, 40, 15);
		tp2.add(tp2n);

		JLabel tpt2 = new JLabel("时间：");
		tpt2.setHorizontalAlignment(SwingConstants.CENTER);
		tpt2.setBounds(2, 50, 40, 15);
		tp2.add(tpt2);

		JLabel tn2 = new JLabel(jilu.getAn()[1]);
		tn2.setBounds(35, 25, 54, 15);
		tp2.add(tn2);

		JLabel tt2 = new JLabel(jilu.getA()[1]);
		tt2.setBounds(35, 50, 54, 15);
		tp2.add(tt2);

		JPanel tp3 = new JPanel();
		tp3.setBorder(new TitledBorder(null, "5*5", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		tp3.setBounds(379, 81, 120, 71);
		panel3.add(tp3);
		tp3.setLayout(null);

		JLabel tp3n = new JLabel("姓名：");
		tp3n.setHorizontalAlignment(SwingConstants.CENTER);
		tp3n.setBounds(2, 25, 40, 15);
		tp3.add(tp3n);

		JLabel tpt3 = new JLabel("时间：");
		tpt3.setHorizontalAlignment(SwingConstants.CENTER);
		tpt3.setBounds(2, 50, 40, 15);
		tp3.add(tpt3);

		JLabel tn3 = new JLabel(jilu.getAn()[2]);
		tn3.setBounds(35, 25, 54, 15);
		tp3.add(tn3);

		JLabel tt3 = new JLabel(jilu.getA()[2]);
		tt3.setBounds(35, 50, 54, 15);
		tp3.add(tt3);

		JPanel tp4 = new JPanel();
		tp4.setBorder(new TitledBorder(null, "6*6", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		tp4.setBounds(46, 176, 120, 71);
		panel3.add(tp4);
		tp4.setLayout(null);

		JLabel tp4n = new JLabel("姓名：");
		tp4n.setHorizontalAlignment(SwingConstants.CENTER);
		tp4n.setBounds(2, 25, 40, 15);
		tp4.add(tp4n);

		JLabel tpt4 = new JLabel("时间：");
		tpt4.setHorizontalAlignment(SwingConstants.CENTER);
		tpt4.setBounds(2, 50, 40, 15);
		tp4.add(tpt4);

		JLabel tn4 = new JLabel(jilu.getAn()[3]);
		tn4.setBounds(35, 25, 54, 15);
		tp4.add(tn4);

		JLabel tt4 = new JLabel(jilu.getA()[3]);
		tt4.setBounds(35, 50, 54, 15);
		tp4.add(tt4);

		JPanel tp7 = new JPanel();
		tp7.setBorder(new TitledBorder(null, "9*9", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		tp7.setBounds(46, 280, 120, 71);
		panel3.add(tp7);
		tp7.setLayout(null);

		JLabel tp7n = new JLabel("姓名：");
		tp7n.setHorizontalAlignment(SwingConstants.CENTER);
		tp7n.setBounds(2, 25, 40, 15);
		tp7.add(tp7n);

		JLabel tpt7 = new JLabel("时间：");
		tpt7.setHorizontalAlignment(SwingConstants.CENTER);
		tpt7.setBounds(2, 46, 40, 15);
		tp7.add(tpt7);

		JLabel tn7 = new JLabel(jilu.getAn()[6]);
		tn7.setBounds(35, 25, 54, 15);
		tp7.add(tn7);

		JLabel tt7 = new JLabel(jilu.getA()[6]);
		tt7.setBounds(35, 50, 54, 15);
		tp7.add(tt7);

		JPanel tp5 = new JPanel();
		tp5.setBorder(new TitledBorder(null, "7*7", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		tp5.setBounds(218, 176, 120, 71);
		panel3.add(tp5);
		tp5.setLayout(null);

		JLabel tp5n = new JLabel("姓名：");
		tp5n.setHorizontalAlignment(SwingConstants.CENTER);
		tp5n.setBounds(2, 25, 40, 15);
		tp5.add(tp5n);

		JLabel tpt5 = new JLabel("时间：");
		tpt5.setHorizontalAlignment(SwingConstants.CENTER);
		tpt5.setBounds(2, 50, 40, 15);
		tp5.add(tpt5);

		JLabel tn5 = new JLabel(jilu.getAn()[4]);
		tn5.setBounds(35, 25, 54, 15);
		tp5.add(tn5);

		JLabel tt5 = new JLabel(jilu.getA()[4]);
		tt5.setBounds(35, 50, 54, 15);
		tp5.add(tt5);

		JPanel tp8 = new JPanel();
		tp8.setBorder(new TitledBorder(null, "10*10", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		tp8.setBounds(218, 280, 120, 71);
		panel3.add(tp8);
		tp8.setLayout(null);

		JLabel tp8n = new JLabel("姓名：");
		tp8n.setHorizontalAlignment(SwingConstants.CENTER);
		tp8n.setBounds(2, 25, 40, 15);
		tp8.add(tp8n);

		JLabel tpt8 = new JLabel("时间：");
		tpt8.setHorizontalAlignment(SwingConstants.CENTER);
		tpt8.setBounds(2, 50, 40, 15);
		tp8.add(tpt8);

		JLabel tn8 = new JLabel(jilu.getAn()[7]);
		tn8.setBounds(35, 25, 54, 15);
		tp8.add(tn8);

		JLabel tt8 = new JLabel(jilu.getA()[7]);
		tt8.setBounds(35, 50, 54, 15);
		tp8.add(tt8);

		JPanel tp6 = new JPanel();
		tp6.setBorder(new TitledBorder(null, "8*8", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		tp6.setBounds(379, 176, 120, 71);
		panel3.add(tp6);
		tp6.setLayout(null);

		JLabel tp6n = new JLabel("姓名：");
		tp6n.setHorizontalAlignment(SwingConstants.CENTER);
		tp6n.setBounds(2, 25, 40, 15);
		tp6.add(tp6n);

		JLabel tpt6 = new JLabel("时间：");
		tpt6.setHorizontalAlignment(SwingConstants.CENTER);
		tpt6.setBounds(2, 50, 40, 15);
		tp6.add(tpt6);

		JLabel tn6 = new JLabel(jilu.getAn()[5]);
		tn6.setBounds(35, 25, 54, 15);
		tp6.add(tn6);

		JLabel tt6 = new JLabel(jilu.getA()[5]);
		tt6.setBounds(35, 50, 54, 15);
		tp6.add(tt6);

		JPanel tp9 = new JPanel();
		tp9.setBorder(new TitledBorder(null, "11*11", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		tp9.setBounds(379, 280, 120, 71);
		panel3.add(tp9);
		tp9.setLayout(null);

		JLabel tp9n = new JLabel("姓名：");
		tp9n.setHorizontalAlignment(SwingConstants.CENTER);
		tp9n.setBounds(2, 25, 40, 15);
		tp9.add(tp9n);


		JLabel tpt9 = new JLabel("时间：");
		tpt9.setHorizontalAlignment(SwingConstants.CENTER);
		tpt9.setBounds(2, 50, 40, 15);
		tp9.add(tpt9);

		JLabel tn9 = new JLabel(jilu.getAn()[8]);
		tn9.setBounds(35, 25, 54, 15);
		tp9.add(tn9);

		JLabel tt9 = new JLabel(jilu.getA()[8]);
		tt9.setBounds(35, 50, 54, 15);
		tp9.add(tt9);

		/****/
		JPanel bp1 = new JPanel();
		bp1.setBorder(new TitledBorder(null, "3*3", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		bp1.setBounds(46, 81, 120, 71);
		panel3.add(bp1);
		bp1.setLayout(null);

		JLabel bp1n = new JLabel("姓名：");
		bp1n.setHorizontalAlignment(SwingConstants.CENTER);
		bp1n.setBounds(2, 25, 40, 15);
		bp1.add(bp1n);

		JLabel bpt1 = new JLabel("步数：");
		bpt1.setHorizontalAlignment(SwingConstants.CENTER);
		bpt1.setBounds(2, 50, 40, 15);
		bp1.add(bpt1);

		JLabel bn1 = new JLabel(jilu.getBn()[0]);
		bn1.setBounds(35, 25, 54, 15);
		bp1.add(bn1);

		JLabel bt1 = new JLabel(jilu.getB()[0]);
		bt1.setBounds(35, 50, 54, 15);
		bp1.add(bt1);

		JPanel bp2 = new JPanel();
		bp2.setBorder(new TitledBorder(null, "4*4", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		bp2.setBounds(218, 81, 120, 71);
		panel3.add(bp2);
		bp2.setLayout(null);

		JLabel bp2n = new JLabel("姓名：");
		bp2n.setHorizontalAlignment(SwingConstants.CENTER);
		bp2n.setBounds(2, 25, 40, 15);
		bp2.add(bp2n);

		JLabel bpt2 = new JLabel("步数：");
		bpt2.setHorizontalAlignment(SwingConstants.CENTER);
		bpt2.setBounds(2, 50, 40, 15);
		bp2.add(bpt2);

		JLabel bn2 = new JLabel(jilu.getBn()[1]);
		bn2.setBounds(35, 25, 54, 15);
		bp2.add(bn2);

		JLabel bt2 = new JLabel(jilu.getB()[1]);
		bt2.setBounds(35, 50, 54, 15);
		bp2.add(bt2);

		JPanel bp3 = new JPanel();
		bp3.setBorder(new TitledBorder(null, "5*5", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		bp3.setBounds(379, 81, 120, 71);
		panel3.add(bp3);
		bp3.setLayout(null);

		JLabel bp3n = new JLabel("姓名：");
		bp3n.setHorizontalAlignment(SwingConstants.CENTER);
		bp3n.setBounds(2, 25, 40, 15);
		bp3.add(bp3n);

		JLabel bpt3 = new JLabel("步数：");
		bpt3.setHorizontalAlignment(SwingConstants.CENTER);
		bpt3.setBounds(2, 50, 40, 15);
		bp3.add(bpt3);

		JLabel bn3 = new JLabel(jilu.getBn()[2]);
		bn3.setBounds(35, 25, 54, 15);
		bp3.add(bn3);

		JLabel bt3 = new JLabel(jilu.getB()[2]);
		bt3.setBounds(35, 50, 54, 15);
		bp3.add(bt3);

		JPanel bp4 = new JPanel();
		bp4.setBorder(new TitledBorder(null, "6*6", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		bp4.setBounds(46, 176, 120, 71);
		panel3.add(bp4);
		bp4.setLayout(null);

		JLabel bp4n = new JLabel("姓名：");
		bp4n.setHorizontalAlignment(SwingConstants.CENTER);
		bp4n.setBounds(2, 25, 40, 15);
		bp4.add(bp4n);

		JLabel bpt4 = new JLabel("步数：");
		bpt4.setHorizontalAlignment(SwingConstants.CENTER);
		bpt4.setBounds(2, 50, 40, 15);
		bp4.add(bpt4);

		JLabel bn4 = new JLabel(jilu.getBn()[3]);
		bn4.setBounds(35, 25, 54, 15);
		bp4.add(bn4);

		JLabel bt4 = new JLabel(jilu.getB()[3]);
		bt4.setBounds(35, 50, 54, 15);
		bp4.add(bt4);

		JPanel bp7 = new JPanel();
		bp7.setBorder(new TitledBorder(null, "9*9", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		bp7.setBounds(46, 280, 120, 71);
		panel3.add(bp7);
		bp7.setLayout(null);

		JLabel bp7n = new JLabel("姓名：");
		bp7n.setHorizontalAlignment(SwingConstants.CENTER);
		bp7n.setBounds(2, 25, 40, 15);
		bp7.add(bp7n);

		JLabel bpt7 = new JLabel("步数：");
		bpt7.setHorizontalAlignment(SwingConstants.CENTER);
		bpt7.setBounds(2, 46, 40, 15);
		bp7.add(bpt7);

		JLabel bn7 = new JLabel(jilu.getBn()[6]);
		bn7.setBounds(35, 25, 54, 15);
		bp7.add(bn7);

		JLabel bt7 = new JLabel(jilu.getB()[6]);
		bt7.setBounds(35, 50, 54, 15);
		bp7.add(bt7);

		JPanel bp5 = new JPanel();
		bp5.setBorder(new TitledBorder(null, "7*7", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		bp5.setBounds(218, 176, 120, 71);
		panel3.add(bp5);
		bp5.setLayout(null);

		JLabel bp5n = new JLabel("姓名：");
		bp5n.setHorizontalAlignment(SwingConstants.CENTER);
		bp5n.setBounds(2, 25, 40, 15);
		bp5.add(bp5n);

		JLabel bpt5 = new JLabel("步数：");
		bpt5.setHorizontalAlignment(SwingConstants.CENTER);
		bpt5.setBounds(2, 50, 40, 15);
		bp5.add(bpt5);

		JLabel bn5 = new JLabel(jilu.getBn()[4]);
		bn5.setBounds(35, 25, 54, 15);
		bp5.add(bn5);

		JLabel bt5 = new JLabel(jilu.getB()[4]);
		bt5.setBounds(35, 50, 54, 15);
		bp5.add(bt5);

		JPanel bp8 = new JPanel();
		bp8.setBorder(new TitledBorder(null, "10*10", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		bp8.setBounds(218, 280, 120, 71);
		panel3.add(bp8);
		bp8.setLayout(null);

		JLabel bp8n = new JLabel("姓名：");
		bp8n.setHorizontalAlignment(SwingConstants.CENTER);
		bp8n.setBounds(2, 25, 40, 15);
		bp8.add(bp8n);

		JLabel bpt8 = new JLabel("步数：");
		bpt8.setHorizontalAlignment(SwingConstants.CENTER);
		bpt8.setBounds(2, 50, 40, 15);
		bp8.add(bpt8);

		JLabel bn8 = new JLabel(jilu.getBn()[7]);
		bn8.setBounds(35, 25, 54, 15);
		bp8.add(bn8);

		JLabel bt8 = new JLabel(jilu.getB()[7]);
		bt8.setBounds(35, 50, 54, 15);
		bp8.add(bt8);

		JPanel bp6 = new JPanel();
		bp6.setBorder(new TitledBorder(null, "8*8", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		bp6.setBounds(379, 176, 120, 71);
		panel3.add(bp6);
		bp6.setLayout(null);

		JLabel bp6n = new JLabel("姓名：");
		bp6n.setHorizontalAlignment(SwingConstants.CENTER);
		bp6n.setBounds(2, 25, 40, 15);
		bp6.add(bp6n);

		JLabel bpt6 = new JLabel("步数：");
		bpt6.setHorizontalAlignment(SwingConstants.CENTER);
		bpt6.setBounds(2, 50, 40, 15);
		bp6.add(bpt6);

		JLabel bn6 = new JLabel(jilu.getBn()[5]);
		bn6.setBounds(35, 25, 54, 15);
		bp6.add(bn6);

		JLabel bt6 = new JLabel(jilu.getB()[5]);
		bt6.setBounds(35, 50, 54, 15);
		bp6.add(bt6);

		JPanel bp9 = new JPanel();
		bp9.setBorder(new TitledBorder(null, "11*11", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		bp9.setBounds(379, 280, 120, 71);
		panel3.add(bp9);
		bp9.setLayout(null);

		JLabel bp9n = new JLabel("姓名：");
		bp9n.setHorizontalAlignment(SwingConstants.CENTER);
		bp9n.setBounds(2, 25, 40, 15);
		bp9.add(bp9n);


		JLabel bpt9 = new JLabel("步数：");
		bpt9.setHorizontalAlignment(SwingConstants.CENTER);
		bpt9.setBounds(2, 50, 40, 15);
		bp9.add(bpt9);

		JLabel bn9 = new JLabel(jilu.getBn()[8]);
		bn9.setBounds(35, 25, 54, 15);
		bp9.add(bn9);

		JLabel bt9 = new JLabel(jilu.getB()[8]);
		bt9.setBounds(35, 50, 54, 15);
		bp9.add(bt9);
		/****/
		JPanel zp1 = new JPanel();
		zp1.setBorder(new TitledBorder(null, "3*3", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		zp1.setBounds(46, 81, 120, 71);
		panel3.add(zp1);
		zp1.setLayout(null);

		JLabel zp1n = new JLabel("姓名：");
		zp1n.setHorizontalAlignment(SwingConstants.CENTER);
		zp1n.setBounds(2, 25, 40, 15);
		zp1.add(zp1n);

		JLabel zpt1 = new JLabel("步时：");
		zpt1.setHorizontalAlignment(SwingConstants.CENTER);
		zpt1.setBounds(2, 50, 40, 15);
		zp1.add(zpt1);

		JLabel zn1 = new JLabel(jilu.getCn()[0]);
		zn1.setBounds(35, 25, 54, 15);
		zp1.add(zn1);

		JLabel zt1 = new JLabel(jilu.getC()[0]);
		zt1.setBounds(35, 50, 54, 15);
		zp1.add(zt1);

		JPanel zp2 = new JPanel();
		zp2.setBorder(new TitledBorder(null, "4*4", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		zp2.setBounds(218, 81, 120, 71);
		panel3.add(zp2);
		zp2.setLayout(null);

		JLabel zp2n = new JLabel("姓名：");
		zp2n.setHorizontalAlignment(SwingConstants.CENTER);
		zp2n.setBounds(2, 25, 40, 15);
		zp2.add(zp2n);

		JLabel zpt2 = new JLabel("步时：");
		zpt2.setHorizontalAlignment(SwingConstants.CENTER);
		zpt2.setBounds(2, 50, 40, 15);
		zp2.add(zpt2);

		JLabel zn2 = new JLabel(jilu.getCn()[1]);
		zn2.setBounds(35, 25, 54, 15);
		zp2.add(zn2);

		JLabel zt2 = new JLabel(jilu.getC()[1]);
		zt2.setBounds(35, 50, 54, 15);
		zp2.add(zt2);

		JPanel zp3 = new JPanel();
		zp3.setBorder(new TitledBorder(null, "5*5", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		zp3.setBounds(379, 81, 120, 71);
		panel3.add(zp3);
		zp3.setLayout(null);

		JLabel zp3n = new JLabel("姓名：");
		zp3n.setHorizontalAlignment(SwingConstants.CENTER);
		zp3n.setBounds(2, 25, 40, 15);
		zp3.add(zp3n);

		JLabel zpt3 = new JLabel("步时：");
		zpt3.setHorizontalAlignment(SwingConstants.CENTER);
		zpt3.setBounds(2, 50, 40, 15);
		zp3.add(zpt3);

		JLabel zn3 = new JLabel(jilu.getCn()[2]);
		zn3.setBounds(35, 25, 54, 15);
		zp3.add(zn3);

		JLabel zt3 = new JLabel(jilu.getC()[2]);
		zt3.setBounds(35, 50, 54, 15);
		zp3.add(zt3);

		JPanel zp4 = new JPanel();
		zp4.setBorder(new TitledBorder(null, "6*6", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		zp4.setBounds(46, 176, 120, 71);
		panel3.add(zp4);
		zp4.setLayout(null);

		JLabel zp4n = new JLabel("姓名：");
		zp4n.setHorizontalAlignment(SwingConstants.CENTER);
		zp4n.setBounds(2, 25, 40, 15);
		zp4.add(zp4n);

		JLabel zpt4 = new JLabel("步时：");
		zpt4.setHorizontalAlignment(SwingConstants.CENTER);
		zpt4.setBounds(2, 50, 40, 15);
		zp4.add(zpt4);

		JLabel zn4 = new JLabel(jilu.getCn()[3]);
		zn4.setBounds(35, 25, 54, 15);
		zp4.add(zn4);

		JLabel zt4 = new JLabel(jilu.getC()[3]);
		zt4.setBounds(35, 50, 54, 15);
		zp4.add(zt4);

		JPanel zp7 = new JPanel();
		zp7.setBorder(new TitledBorder(null, "9*9", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		zp7.setBounds(46, 280, 120, 71);
		panel3.add(zp7);
		zp7.setLayout(null);

		JLabel zp7n = new JLabel("姓名：");
		zp7n.setHorizontalAlignment(SwingConstants.CENTER);
		zp7n.setBounds(2, 25, 40, 15);
		zp7.add(zp7n);

		JLabel zpt7 = new JLabel("步时：");
		zpt7.setHorizontalAlignment(SwingConstants.CENTER);
		zpt7.setBounds(2, 46, 40, 15);
		zp7.add(zpt7);

		JLabel zn7 = new JLabel(jilu.getCn()[6]);
		zn7.setBounds(35, 25, 54, 15);
		zp7.add(zn7);

		JLabel zt7 = new JLabel(jilu.getC()[6]);
		zt7.setBounds(35, 50, 54, 15);
		zp7.add(zt7);

		JPanel zp5 = new JPanel();
		zp5.setBorder(new TitledBorder(null, "7*7", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		zp5.setBounds(218, 176, 120, 71);
		panel3.add(zp5);
		zp5.setLayout(null);

		JLabel zp5n = new JLabel("姓名：");
		zp5n.setHorizontalAlignment(SwingConstants.CENTER);
		zp5n.setBounds(2, 25, 40, 15);
		zp5.add(zp5n);

		JLabel zpt5 = new JLabel("步时：");
		zpt5.setHorizontalAlignment(SwingConstants.CENTER);
		zpt5.setBounds(2, 50, 40, 15);
		zp5.add(zpt5);

		JLabel zn5 = new JLabel(jilu.getCn()[4]);
		zn5.setBounds(35, 25, 54, 15);
		zp5.add(zn5);

		JLabel zt5 = new JLabel(jilu.getC()[4]);
		zt5.setBounds(35, 50, 54, 15);
		zp5.add(zt5);

		JPanel zp8 = new JPanel();
		zp8.setBorder(new TitledBorder(null, "10*10", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		zp8.setBounds(218, 280, 120, 71);
		panel3.add(zp8);
		zp8.setLayout(null);

		JLabel zp8n = new JLabel("姓名：");
		zp8n.setHorizontalAlignment(SwingConstants.CENTER);
		zp8n.setBounds(2, 25, 40, 15);
		zp8.add(zp8n);

		JLabel zpt8 = new JLabel("步时：");
		zpt8.setHorizontalAlignment(SwingConstants.CENTER);
		zpt8.setBounds(2, 50, 40, 15);
		zp8.add(zpt8);

		JLabel zn8 = new JLabel(jilu.getCn()[7]);
		zn8.setBounds(35, 25, 54, 15);
		zp8.add(zn8);

		JLabel zt8 = new JLabel(jilu.getC()[7]);
		zt8.setBounds(35, 50, 54, 15);
		zp8.add(zt8);

		JPanel zp6 = new JPanel();
		zp6.setBorder(new TitledBorder(null, "8*8", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		zp6.setBounds(379, 176, 120, 71);
		panel3.add(zp6);
		zp6.setLayout(null);

		JLabel zp6n = new JLabel("姓名：");
		zp6n.setHorizontalAlignment(SwingConstants.CENTER);
		zp6n.setBounds(2, 25, 40, 15);
		zp6.add(zp6n);

		JLabel zpt6 = new JLabel("步时：");
		zpt6.setHorizontalAlignment(SwingConstants.CENTER);
		zpt6.setBounds(2, 50, 40, 15);
		zp6.add(zpt6);

		JLabel zn6 = new JLabel(jilu.getCn()[5]);
		zn6.setBounds(35, 25, 54, 15);
		zp6.add(zn6);

		JLabel zt6 = new JLabel(jilu.getC()[5]);
		zt6.setBounds(35, 50, 54, 15);
		zp6.add(zt6);

		JPanel zp9 = new JPanel();
		zp9.setBorder(new TitledBorder(null, "11*11", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		zp9.setBounds(379, 280, 120, 71);
		panel3.add(zp9);
		zp9.setLayout(null);

		JLabel zp9n = new JLabel("姓名：");
		zp9n.setHorizontalAlignment(SwingConstants.CENTER);
		zp9n.setBounds(2, 25, 40, 15);
		zp9.add(zp9n);


		JLabel zpt9 = new JLabel("步时：");
		zpt9.setHorizontalAlignment(SwingConstants.CENTER);
		zpt9.setBounds(2, 50, 40, 15);
		zp9.add(zpt9);

		JLabel zn9 = new JLabel(jilu.getCn()[8]);
		zn9.setBounds(35, 25, 54, 15);
		zp9.add(zn9);

		JLabel zt9 = new JLabel(jilu.getC()[8]);
		zt9.setBounds(35, 50, 54, 15);
		zp9.add(zt9);

		tp1.setVisible(true);
		tp2.setVisible(true);
		tp3.setVisible(true);
		tp4.setVisible(true);
		tp5.setVisible(true);
		tp6.setVisible(true);
		tp7.setVisible(true);
		tp8.setVisible(true);
		tp9.setVisible(true);
		zp1.setVisible(false);
		zp2.setVisible(false);
		zp3.setVisible(false);
		zp4.setVisible(false);
		zp5.setVisible(false);
		zp6.setVisible(false);
		zp7.setVisible(false);
		zp8.setVisible(false);
		zp9.setVisible(false);
		bp1.setVisible(false);
		bp2.setVisible(false);
		bp3.setVisible(false);
		bp4.setVisible(false);
		bp5.setVisible(false);
		bp6.setVisible(false);
		bp7.setVisible(false);
		bp8.setVisible(false);
		bp9.setVisible(false);
		timecharts.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tp1.setVisible(true);
				tp2.setVisible(true);
				tp3.setVisible(true);
				tp4.setVisible(true);
				tp5.setVisible(true);
				tp6.setVisible(true);
				tp7.setVisible(true);
				tp8.setVisible(true);
				tp9.setVisible(true);
				zp1.setVisible(false);
				zp2.setVisible(false);
				zp3.setVisible(false);
				zp4.setVisible(false);
				zp5.setVisible(false);
				zp6.setVisible(false);
				zp7.setVisible(false);
				zp8.setVisible(false);
				zp9.setVisible(false);
				bp1.setVisible(false);
				bp2.setVisible(false);
				bp3.setVisible(false);
				bp4.setVisible(false);
				bp5.setVisible(false);
				bp6.setVisible(false);
				bp7.setVisible(false);
				bp8.setVisible(false);
				bp9.setVisible(false);
				frame2.setTitle("时间记录");
			}
		});
		stepcharts.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tp1.setVisible(false);
				tp2.setVisible(false);
				tp3.setVisible(false);
				tp4.setVisible(false);
				tp5.setVisible(false);
				tp6.setVisible(false);
				tp7.setVisible(false);
				tp8.setVisible(false);
				tp9.setVisible(false);
				zp1.setVisible(false);
				zp2.setVisible(false);
				zp3.setVisible(false);
				zp4.setVisible(false);
				zp5.setVisible(false);
				zp6.setVisible(false);
				zp7.setVisible(false);
				zp8.setVisible(false);
				zp9.setVisible(false);
				bp1.setVisible(true);
				bp2.setVisible(true);
				bp3.setVisible(true);
				bp4.setVisible(true);
				bp5.setVisible(true);
				bp6.setVisible(true);
				bp7.setVisible(true);
				bp8.setVisible(true);
				bp9.setVisible(true);
				frame2.setTitle("步数记录");
			}
		});
		totalcharts.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tp1.setVisible(false);
				tp2.setVisible(false);
				tp3.setVisible(false);
				tp4.setVisible(false);
				tp5.setVisible(false);
				tp6.setVisible(false);
				tp7.setVisible(false);
				tp8.setVisible(false);
				tp9.setVisible(false);
				bp1.setVisible(false);
				bp2.setVisible(false);
				bp3.setVisible(false);
				bp4.setVisible(false);
				bp5.setVisible(false);
				bp6.setVisible(false);
				bp7.setVisible(false);
				bp8.setVisible(false);
				bp9.setVisible(false);
				tp1.setVisible(false);
				tp2.setVisible(false);
				tp3.setVisible(false);
				tp4.setVisible(false);
				tp5.setVisible(false);
				tp6.setVisible(false);
				tp7.setVisible(false);
				tp8.setVisible(false);
				tp9.setVisible(false);
				zp1.setVisible(true);
				zp2.setVisible(true);
				zp3.setVisible(true);
				zp4.setVisible(true);
				zp5.setVisible(true);
				zp6.setVisible(true);
				zp7.setVisible(true);
				zp8.setVisible(true);
				zp9.setVisible(true);
				frame2.setTitle("步时");
			}
		});
		/******************************继续游戏界面结束*********************************/
		/******************************游戏简介界面开始*********************************/
		JButton rt1 = new JButton("返回主界面");
		rt1.setBackground(Color.CYAN);
		rt1.setForeground(Color.RED);
		rt1.setFont(new Font("Microsoft JhengHei", Font.BOLD, 24));
		rt1.setBounds(0, 0, frame3.getSize().width-10, 40);
		frame3.getContentPane().add(rt1);
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(frame3.getSize().width-10, 1650));
		JScrollPane scrollPane = new JScrollPane(panel);
		scrollPane.setLocation(0, 40);

		scrollPane.setSize(frame3.getSize().width-10,frame3.getSize().height-70);
		scrollPane.setVisible(true);
		scrollPane.getVerticalScrollBar().setUnitIncrement(20);//滚动条显示速度
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);//滚动条显示与不显示
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		frame3.getContentPane().add(scrollPane);
		JLabel zwm = new JLabel("中文名：超级数字华容道\n ");
		zwm.setForeground(Color.MAGENTA);
		zwm.setFont(new Font("华文行楷", Font.PLAIN, 14));
		zwm.setBounds(30, 0, 400, 30);
		panel.add(zwm);

		JLabel version = new JLabel("版本号：1.0.2 \n");
		version.setForeground(Color.RED);
		version.setFont(new Font("华文行楷", Font.PLAIN, 14));
		version.setBounds(30, 31, 400, 30);
		panel.add(version);

		JLabel author = new JLabel("开发者：向贵龙团队\n");
		author.setForeground(Color.GREEN);
		author.setFont(new Font("华文行楷", Font.PLAIN, 14));
		author.setBounds(30, 61, 400, 30);
		panel.add(author);

		JLabel rj = new JLabel("开发软件：eclipse4.7.2；jdk1.8；Photoshop；VLC。\n");
		rj.setForeground(Color.BLUE);
		rj.setFont(new Font("华文行楷", Font.PLAIN, 14));
		rj.setBounds(30, 94, 400, 30);
		panel.add(rj);

		JLabel lvg = new JLabel("软件语言：中文\n");
		lvg.setForeground(Color.BLACK);
		lvg.setFont(new Font("华文行楷", Font.PLAIN, 14));
		lvg.setBounds(30, 124, 400, 30);
		panel.add(lvg);

		JTextArea message = new JTextArea();
		message.setBackground(SystemColor.window);
		message.setLineWrap(true);
		message.setEditable(false);
		message.setForeground(Color.MAGENTA);
		message.setFont(new Font("华文行楷", Font.PLAIN, 16));
		message.setText("游戏玩法：\r\n玩法1：点击空白块旁边的任意方块；点击方块向空白块移动；"
				+ "也可以点击空白块上下左右的任意方块点击方块变为空白，其他方块向原空白块方向移动；直到达到目标图形即完成游戏；"
				+ "\r\n玩法2：利用键盘移动（软件提供WASD，以及键盘的上下左右；用户可自定义设置）；键盘只支持单一移动；\r\n"
				+ "W/上：空白块向上移动\r\nS/下：空白块向上移动\r\nA/左：空白块向上移动\r\nD/右：空白块向上移动\r\n"
				+ "直到达到目标图形即完成游戏");
		message.setBounds(30, 154, 385, 100);
		panel.add(message);

		JTextArea tedian = new JTextArea();
		tedian.setLineWrap(true);
		tedian.setText("软件特点：本软件加入了视频播放器；可以加入教学视频等；本软件对数字华容道游戏难度进行了加大；"
				+ "最高可扩充至100*100；由于随机算法生成的数据量庞大，超过10之后生成的数据不稳定；"
				+ "所以本软件只提供3-11阶难度选择；因为随机算法由本人自己编写，所以本软件避免了不可能复原问题");
		tedian.setForeground(Color.MAGENTA);
		tedian.setFont(new Font("华文行楷", Font.PLAIN, 16));
		tedian.setEditable(false);
		tedian.setBackground(SystemColor.window);
		tedian.setBounds(30, 300, 385, 110);
		panel.add(tedian);

		JTextArea baidu = new JTextArea();
		baidu.setLineWrap(true);
		baidu.setEditable(false);
		baidu.setText("百度经验：\r\n" +
				"首先，以4阶数字推盘为例，复原分为3个阶段第一阶段：复原前两行，n阶推盘为前n-2行，"
				+ "第二阶段：将后两行排列为形式，第三阶段：全部复原将推盘各位置命名。"
				+ "第一阶段：依照数字由小到大顺序依次复原1-8一、复原1 2 3 4数字1 2 3的复原比较简单，按照数字大小顺序从1开始，依次复原。"
				+ "在保持已复原较小数字位置不变的情况下，很容易把较大数字移到相应位置，没有什么技术含量。"
				+ "数字4分为两种情况：数字3复原后4恰巧移入相应位置，十分走运。事实上在移动1、2、3过程中稍加留意，"
				+ "可以人为制造直接移入机会，省去下步笨办法。"
				+ "\r\n"
				+"然后，大多数情况下4无法直接移入，在D1处有其他数字占位。"
				+ "这时很容易把4排列在D3的位置，依次移动D1→D2；C1→D1；"
				+ "C2→C1；D2→C2；D3→D2，推盘变为，这时通过使C1、C2、C3依次挪位，可把3、4逆时针转入C1、D1，完成。"
				+ "二、复原5 6 7 8，与1 2 3 4同理。第二阶段：保持前两行不动，复原后两行1、将9移动至A3，并使A4不为空格，没有技术含量。"
				+ "2、分两种情况    一、A4数字不是10：保持A3、A4不动，很容易将10移至B3   "
				+ " 二、A4数字是10：保持9、10不动，将空格移至B4。\r\n");
		baidu.setForeground(Color.MAGENTA);
		baidu.setFont(new Font("华文行楷", Font.PLAIN, 16));
		baidu.setBackground(SystemColor.window);
		baidu.setBounds(30, 410, 385, 400);
		panel.add(baidu);

		JTextArea textArea = new JTextArea();
		textArea.setText(
				"然后，依次移动A4→B4，A3→A4，B3→A3，保持A3、A4不动，"
						+ "将10移至C3，依次移动A3→B3，A4→A3，B4→A4，B3→B4，C3→B3两种情况最后均得到"
						+ "，之后将9、10依次逆时针转入A4、A3，完成。3、将11、12移动至B4、B3注意到移动9、10过程中只用到了A3：C4六格区域。"
						+ "所以保持9、10不变，利用B3：D4六格区域同理可以完成11、12的移动。第三阶段：复原在第二阶段基础上，移动C3：D4四格数字，"
						+ "依次移动9-12与13-15，很容易复原（12→C3，11→B3，13→B4，14→C4，15→D4，如此依次）。\r\n" +
						"然后，以上为四阶数字推盘通法，同理可推广至n 阶推盘。数字推盘这种解法主要利用的是四格"
						+ "（3数字+1空格）、六格（5数字+1空格）的小区域旋转循环。"
						+ "注意到循环的最小区域为2*2四格，所以边角地区，如3和4需两列一起解决。"
						+ "最后两行通过将较小数字如9、10并列放置在最左侧一列，为之后复原提供空间。"
						+ "n阶最后两行即需要依次把较小数字并列放在最左侧，腾出右侧空间。以上方法为考虑各种情况，适用n阶的最常规解法，略显繁琐。"
						+ "按照此法普通人一分钟内可以完成4阶复原。练熟后有些步骤可以省去。玩了两小时发现的个人解法，可能有更优解。"
						+ "好多评论问到了无解的情况，补充一下相关讨论。\r\n" +
						"然后，复原最后一步13 14 15时会遇到两种情况，不妨设空位为数字0（所设数字并不影响最终结论）："
						+ "把推盘变为一阶排列Ⅰ:（1 2 3 … 12 13 14 15 0）与Ⅱ:（1 2 3 … 12 13 15 14 0）"
						+ "这时每次移动可看作数字0与其它某一数字x的对换（设0所在序数为n，事实上是0与n±1、n±4位置上元素的对换）Ⅰ为正常情况，"
						+ "现考虑如何复原Ⅱ：复原排列Ⅱ等价于对排列Ⅱ进行对换（14，15），问题转化为对换（14，15）能否写成若干个（0，x）对换的乘积。"
						+ "由于一次对换（14，15）改变原排列奇偶性，所以（0，x）对换个数必为奇数。而要将D4处数字0最终移回D4，"
						+ "移动次数必为偶数（上移次数等于下移次数，左移次数等于右移次数），所以排列Ⅱ无法还原为（1 2 3 … 12 13 14 15 0）。"
						+ "也就是说，在保证其它数字位置不变的情况下，无法实现两个数字的位置互换。@高世奇 的回答里有更普遍的证明。\r\n" +
						"最后，由于数字1-13的复原只利用6或4小区域循环移动，只涉及位置调整，与其它位置的数字无关，所以无论原始推盘如何排列，"
						+ "最终都可变换为Ⅰ、Ⅱ两种情况。设1-15全排列为A：A=B∪C，B中排列复原后为情况Ⅰ，C为情况Ⅱ。?排列b∈B，作用对换（14，15），"
						+ "得排列c∈C，集合C同理。所以可以构造集合B到C的一一映射，"
						+ "即card(B)=card(C)。因此在数字推盘所有随机排列中，有1/2的排列无解。");
		textArea.setLineWrap(true);
		textArea.setForeground(Color.MAGENTA);
		textArea.setFont(new Font("华文行楷", Font.PLAIN, 16));
		textArea.setEditable(false);
		textArea.setBackground(SystemColor.window);
		textArea.setBounds(30, 810, 385, 500);
		panel.add(textArea);

		rt1.addMouseListener(new MouseAdapter(){

			@Override
			public void mouseClicked(MouseEvent e) {
				frame3.setVisible(false);
				frame.setVisible(true);
			}
		});
		/******************************游戏简介界面结束*********************************/
		/******************************游戏界面开始*********************************/
		label = new JLabel("你的目标是");
		label.setVisible(true);
		label.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 20));
		label.setForeground(new Color(255, 0, 255));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		frame4.getContentPane().add(label);

		shezi4 = new JButton("设置");
		shezi4.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 14));
		shezi4.setForeground(new Color(125, 0, 255));
		shezi4.setHorizontalAlignment(SwingConstants.CENTER);
		frame4.getContentPane().add(shezi4);
		kaishi= new JButton("开始挑战");
		kaishi.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 16));
		kaishi.setForeground(new Color(125, 0, 255));
		kaishi.setHorizontalAlignment(SwingConstants.CENTER);
		frame4.getContentPane().add(kaishi);

		retu = new JButton("界面");
		exit = new JButton("退出");

		retu.setHorizontalAlignment(SwingConstants.RIGHT);
		retu.setForeground(Color.BLACK);
		retu.setBackground(Color.ORANGE);
		retu.setFont(new Font("Microsoft YaHei UI Light", Font.BOLD, 16));

		exit.setHorizontalAlignment(SwingConstants.RIGHT);
		exit.setForeground(Color.BLACK);
		exit.setBackground(Color.ORANGE);
		exit.setFont(new Font("Microsoft YaHei UI Light", Font.BOLD, 16));





		/******************************游戏界面结束*********************************/
	}
	/*********************************************************************/




	/**
	 * frame4方块组键,//即将过时//采用宫格方法生成
	 */
	public void shengcheng() {

		JPanel p1 = new JPanel();
		p1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		p1.setBackground(Color.YELLOW);
		p1.setBounds(f4x[0], f4y[0], f4w, f4h);
		frame4.getContentPane().add(p1);


		JLabel l1 = new JLabel();
		l1.setForeground(Color.GREEN);
		l1.setFont(new Font("宋体", Font.BOLD, 24));
		p1.add(l1);


		JPanel p2 = new JPanel();
		p2.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		p2.setBackground(Color.YELLOW);
		p2.setBounds(f4x[1], f4y[1], f4w, f4h);
		frame4.getContentPane().add(p2);


		JLabel l2 = new JLabel();
		l2.setForeground(Color.GREEN);
		l2.setFont(new Font("宋体", Font.BOLD, 24));
		p2.add(l2);


		JPanel p3 = new JPanel();
		p3.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		p3.setBackground(Color.YELLOW);
		p3.setBounds(f4x[2], f4y[2], f4w, f4h);
		frame4.getContentPane().add(p3);

		JLabel l3 = new JLabel();
		l3.setForeground(Color.GREEN);
		l3.setFont(new Font("宋体", Font.BOLD, 24));
		p3.add(l3);

		JPanel p4 = new JPanel();
		p4.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		p4.setBackground(Color.YELLOW);
		p4.setBounds(f4x[3], f4y[3], f4w, f4h);
		frame4.getContentPane().add(p4);

		JLabel l4 = new JLabel();
		l4.setForeground(Color.GREEN);
		l4.setFont(new Font("宋体", Font.BOLD, 24));
		p4.add(l4);

		JPanel p5 = new JPanel();
		p5.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		p5.setBackground(Color.YELLOW);
		p5.setBounds(f4x[4], f4y[4], f4w, f4h);
		frame4.getContentPane().add(p5);

		JLabel l5 = new JLabel();
		l5.setForeground(Color.GREEN);
		l5.setFont(new Font("宋体", Font.BOLD, 24));
		p5.add(l5);

		JPanel p6 = new JPanel();
		p6.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		p6.setBackground(Color.YELLOW);
		p6.setBounds(f4x[5], f4y[5], f4w, f4h);
		frame4.getContentPane().add(p6);

		JLabel l6 = new JLabel();
		l6.setForeground(Color.GREEN);
		l6.setFont(new Font("宋体", Font.BOLD, 24));
		p6.add(l6);

		JPanel p7 = new JPanel();
		p7.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		p7.setBackground(Color.YELLOW);
		p7.setBounds(f4x[6], f4y[6], f4w, f4h);
		frame4.getContentPane().add(p7);

		JLabel l7 = new JLabel();
		l7.setForeground(Color.GREEN);
		l7.setFont(new Font("宋体", Font.BOLD, 24));
		p7.add(l7);

		JPanel p8 = new JPanel();
		p8.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		p8.setBackground(Color.YELLOW);
		p8.setBounds(f4x[7], f4y[7], f4w, f4h);
		frame4.getContentPane().add(p8);

		JLabel l8 = new JLabel();
		l8.setForeground(Color.GREEN);
		l8.setFont(new Font("宋体", Font.BOLD, 24));
		p8.add(l8);

		JPanel p9 = new JPanel();
		p9.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		p9.setBackground(Color.YELLOW);
		p9.setBounds(f4x[8], f4y[8], f4w, f4h);
		frame4.getContentPane().add(p9);

		JLabel l9 = new JLabel();
		l9.setForeground(Color.GREEN);
		l9.setFont(new Font("宋体", Font.BOLD, 24));
		p9.add(l9);

		JPanel p10 = new JPanel();
		p10.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		p10.setBackground(Color.YELLOW);
		p10.setBounds(f4x[9], f4y[9], f4w, f4h);
		frame4.getContentPane().add(p10);

		JLabel l10 = new JLabel();
		l10.setForeground(Color.GREEN);
		l10.setFont(new Font("宋体", Font.BOLD, 24));
		p10.add(l10);

		JPanel p11 = new JPanel();
		p11.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		p11.setBackground(Color.YELLOW);
		p11.setBounds(f4x[10], f4y[10], f4w, f4h);
		frame4.getContentPane().add(p11);

		JLabel l11 = new JLabel();
		l11.setForeground(Color.GREEN);
		l11.setFont(new Font("宋体", Font.BOLD, 24));
		p11.add(l11);

		JPanel p12 = new JPanel();
		p12.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		p12.setBackground(Color.YELLOW);
		p12.setBounds(f4x[11], f4y[11], f4w, f4h);
		frame4.getContentPane().add(p12);

		JLabel l12 = new JLabel();
		l12.setForeground(Color.GREEN);
		l12.setFont(new Font("宋体", Font.BOLD, 24));
		p12.add(l12);

		JPanel p13 = new JPanel();
		p13.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		p13.setBackground(Color.YELLOW);
		p13.setBounds(f4x[12], f4y[12], f4w, f4h);
		frame4.getContentPane().add(p13);

		JLabel l13 = new JLabel();
		l13.setForeground(Color.GREEN);
		l13.setFont(new Font("宋体", Font.BOLD, 24));
		p13.add(l13);

		JPanel p14 = new JPanel();
		p14.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		p14.setBackground(Color.YELLOW);
		p14.setBounds(f4x[13], f4y[13], f4w, f4h);
		frame4.getContentPane().add(p14);

		JLabel l14 = new JLabel();
		l14.setForeground(Color.GREEN);
		l14.setFont(new Font("宋体", Font.BOLD, 24));
		p14.add(l14);

		JPanel p15 = new JPanel();
		p15.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		p15.setBackground(Color.YELLOW);
		p15.setBounds(f4x[14], f4y[14], f4w, f4h);
		frame4.getContentPane().add(p15);

		JLabel l15 = new JLabel();
		l15.setForeground(Color.GREEN);
		l15.setFont(new Font("宋体", Font.BOLD, 24));
		p15.add(l15);

		JPanel p16 = new JPanel();
		p16.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		p16.setBackground(Color.YELLOW);
		p16.setBounds(f4x[15], f4y[15], f4w, f4h);
		frame4.getContentPane().add(p16);

		JLabel l16 = new JLabel();
		l16.setForeground(Color.GREEN);
		l16.setFont(new Font("宋体", Font.BOLD, 24));
		p16.add(l16);

		JPanel p17 = new JPanel();
		p17.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		p17.setBackground(Color.YELLOW);
		p17.setBounds(f4x[16], f4y[16], f4w, f4h);
		frame4.getContentPane().add(p17);

		JLabel l17 = new JLabel();
		l17.setForeground(Color.GREEN);
		l17.setFont(new Font("宋体", Font.BOLD, 24));
		p17.add(l17);

		JPanel p18 = new JPanel();
		p18.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		p18.setBackground(Color.YELLOW);
		p18.setBounds(f4x[17], f4y[17], f4w, f4h);
		frame4.getContentPane().add(p18);

		JLabel l18 = new JLabel();
		l18.setForeground(Color.GREEN);
		l18.setFont(new Font("宋体", Font.BOLD, 24));
		p18.add(l18);

		JPanel p19 = new JPanel();
		p19.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		p19.setBackground(Color.YELLOW);
		p19.setBounds(f4x[18], f4y[18], f4w, f4h);
		frame4.getContentPane().add(p19);

		JLabel l19 = new JLabel();
		l19.setForeground(Color.GREEN);
		l19.setFont(new Font("宋体", Font.BOLD, 24));
		p19.add(l19);

		JPanel p20 = new JPanel();
		p20.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		p20.setBackground(Color.YELLOW);
		p20.setBounds(f4x[19], f4y[19], f4w, f4h);
		frame4.getContentPane().add(p20);

		JLabel l20 = new JLabel();
		l20.setForeground(Color.GREEN);
		l20.setFont(new Font("宋体", Font.BOLD, 24));
		p20.add(l20);

		JPanel p21 = new JPanel();
		p21.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		p21.setBackground(Color.YELLOW);
		p21.setBounds(f4x[20], f4y[20], f4w, f4h);
		frame4.getContentPane().add(p21);

		JLabel l21 = new JLabel();
		l21.setForeground(Color.GREEN);
		l21.setFont(new Font("宋体", Font.BOLD, 24));
		p21.add(l21);

		JPanel p22 = new JPanel();
		p22.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		p22.setBackground(Color.YELLOW);
		p22.setBounds(f4x[21], f4y[21], f4w, f4h);
		frame4.getContentPane().add(p22);

		JLabel l22 = new JLabel();
		l22.setForeground(Color.GREEN);
		l22.setFont(new Font("宋体", Font.BOLD, 24));
		p22.add(l22);

		JPanel p23 = new JPanel();
		p23.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		p23.setBackground(Color.YELLOW);
		p23.setBounds(f4x[22], f4y[22], f4w, f4h);
		frame4.getContentPane().add(p23);

		JLabel l23 = new JLabel();
		l23.setForeground(Color.GREEN);
		l23.setFont(new Font("宋体", Font.BOLD, 24));
		p23.add(l23);

		JPanel p24 = new JPanel();
		p24.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		p24.setBackground(Color.YELLOW);
		p24.setBounds(f4x[23], f4y[23], f4w, f4h);
		frame4.getContentPane().add(p24);

		JLabel l24 = new JLabel();
		l24.setForeground(Color.GREEN);
		l24.setFont(new Font("宋体", Font.BOLD, 24));
		p24.add(l24);

		JPanel p25 = new JPanel();
		p25.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		p25.setBackground(Color.YELLOW);
		p25.setBounds(f4x[24], f4y[24], f4w, f4h);
		frame4.getContentPane().add(p25);

		JLabel l25 = new JLabel();
		l25.setForeground(Color.GREEN);
		l25.setFont(new Font("宋体", Font.BOLD, 24));
		p25.add(l25);

		JPanel p26 = new JPanel();
		p26.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		p26.setBackground(Color.YELLOW);
		p26.setBounds(f4x[25], f4y[25], f4w, f4h);
		frame4.getContentPane().add(p26);

		JLabel l26 = new JLabel();
		l26.setForeground(Color.GREEN);
		l26.setFont(new Font("宋体", Font.BOLD, 24));
		p26.add(l26);

		JPanel p27 = new JPanel();
		p27.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		p27.setBackground(Color.YELLOW);
		p27.setBounds(f4x[26], f4y[26], f4w, f4h);
		frame4.getContentPane().add(p27);

		JLabel l27 = new JLabel();
		l27.setForeground(Color.GREEN);
		l27.setFont(new Font("宋体", Font.BOLD, 24));
		p27.add(l27);

		JPanel p28 = new JPanel();
		p28.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		p28.setBackground(Color.YELLOW);
		p28.setBounds(f4x[27], f4y[27], f4w, f4h);
		frame4.getContentPane().add(p28);

		JLabel l28 = new JLabel();
		l28.setForeground(Color.GREEN);
		l28.setFont(new Font("宋体", Font.BOLD, 24));
		p28.add(l28);

		JPanel p29 = new JPanel();
		p29.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		p29.setBackground(Color.YELLOW);
		p29.setBounds(f4x[28], f4y[28], f4w, f4h);
		frame4.getContentPane().add(p29);

		JLabel l29 = new JLabel();
		l29.setForeground(Color.GREEN);
		l29.setFont(new Font("宋体", Font.BOLD, 24));
		p29.add(l29);

		JPanel p30 = new JPanel();
		p30.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		p30.setBackground(Color.YELLOW);
		p30.setBounds(f4x[29], f4y[29], f4w, f4h);
		frame4.getContentPane().add(p30);

		JLabel l30 = new JLabel();
		l30.setForeground(Color.GREEN);
		l30.setFont(new Font("宋体", Font.BOLD, 24));
		p30.add(l30);

		JPanel p31 = new JPanel();
		p31.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		p31.setBackground(Color.YELLOW);
		p31.setBounds(f4x[30], f4y[30], f4w, f4h);
		frame4.getContentPane().add(p31);

		JLabel l31 = new JLabel();
		l31.setForeground(Color.GREEN);
		l31.setFont(new Font("宋体", Font.BOLD, 24));
		p31.add(l31);

		JPanel p32 = new JPanel();
		p32.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		p32.setBackground(Color.YELLOW);
		p32.setBounds(f4x[31], f4y[31], f4w, f4h);
		frame4.getContentPane().add(p32);

		JLabel l32 = new JLabel();
		l32.setForeground(Color.GREEN);
		l32.setFont(new Font("宋体", Font.BOLD, 24));
		p32.add(l32);

		JPanel p33 = new JPanel();
		p33.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		p33.setBackground(Color.YELLOW);
		p33.setBounds(f4x[32], f4y[32], f4w, f4h);
		frame4.getContentPane().add(p33);

		JLabel l33 = new JLabel();
		l33.setForeground(Color.GREEN);
		l33.setFont(new Font("宋体", Font.BOLD, 24));
		p33.add(l33);

		JPanel p34 = new JPanel();
		p34.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		p34.setBackground(Color.YELLOW);
		p34.setBounds(f4x[33], f4y[33], f4w, f4h);
		frame4.getContentPane().add(p34);

		JLabel l34 = new JLabel();
		l34.setForeground(Color.GREEN);
		l34.setFont(new Font("宋体", Font.BOLD, 24));
		p34.add(l34);

		JPanel p35 = new JPanel();
		p35.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		p35.setBackground(Color.YELLOW);
		p35.setBounds(f4x[34], f4y[34], f4w, f4h);
		frame4.getContentPane().add(p35);

		JLabel l35 = new JLabel();
		l35.setForeground(Color.GREEN);
		l35.setFont(new Font("宋体", Font.BOLD, 24));
		p35.add(l35);

		JPanel p36 = new JPanel();
		p36.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		p36.setBackground(Color.YELLOW);
		p36.setBounds(f4x[35], f4y[35], f4w, f4h);
		frame4.getContentPane().add(p36);

		JLabel l36 = new JLabel();
		l36.setForeground(Color.GREEN);
		l36.setFont(new Font("宋体", Font.BOLD, 24));
		p36.add(l36);

		JPanel p37 = new JPanel();
		p37.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		p37.setBackground(Color.YELLOW);
		p37.setBounds(f4x[36], f4y[36], f4w, f4h);
		frame4.getContentPane().add(p37);

		JLabel l37 = new JLabel();
		l37.setForeground(Color.GREEN);
		l37.setFont(new Font("宋体", Font.BOLD, 24));
		p37.add(l37);

		JPanel p38 = new JPanel();
		p38.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		p38.setBackground(Color.YELLOW);
		p38.setBounds(f4x[37], f4y[37], f4w, f4h);
		frame4.getContentPane().add(p38);

		JLabel l38 = new JLabel();
		l38.setForeground(Color.GREEN);
		l38.setFont(new Font("宋体", Font.BOLD, 24));
		p38.add(l38);

		JPanel p39 = new JPanel();
		p39.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		p39.setBackground(Color.YELLOW);
		p39.setBounds(f4x[38], f4y[38], f4w, f4h);
		frame4.getContentPane().add(p39);

		JLabel l39 = new JLabel();
		l39.setForeground(Color.GREEN);
		l39.setFont(new Font("宋体", Font.BOLD, 24));
		p39.add(l39);

		JPanel p40 = new JPanel();
		p40.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		p40.setBackground(Color.YELLOW);
		p40.setBounds(f4x[39], f4y[39], f4w, f4h);
		frame4.getContentPane().add(p40);

		JLabel l40 = new JLabel();
		l40.setForeground(Color.GREEN);
		l40.setFont(new Font("宋体", Font.BOLD, 24));
		p40.add(l40);

		JPanel p41 = new JPanel();
		p41.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		p41.setBackground(Color.YELLOW);
		p41.setBounds(f4x[40], f4y[40], f4w, f4h);
		frame4.getContentPane().add(p41);

		JLabel l41 = new JLabel();
		l41.setForeground(Color.GREEN);
		l41.setFont(new Font("宋体", Font.BOLD, 24));
		p41.add(l41);

		JPanel p42 = new JPanel();
		p42.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		p42.setBackground(Color.YELLOW);
		p42.setBounds(f4x[41], f4y[41], f4w, f4h);
		frame4.getContentPane().add(p42);

		JLabel l42 = new JLabel();
		l42.setForeground(Color.GREEN);
		l42.setFont(new Font("宋体", Font.BOLD, 24));
		p42.add(l42);

		JPanel p43 = new JPanel();
		p43.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		p43.setBackground(Color.YELLOW);
		p43.setBounds(f4x[42], f4y[42], f4w, f4h);
		frame4.getContentPane().add(p43);

		JLabel l43 = new JLabel();
		l43.setForeground(Color.GREEN);
		l43.setFont(new Font("宋体", Font.BOLD, 24));
		p43.add(l43);

		JPanel p44 = new JPanel();
		p44.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		p44.setBackground(Color.YELLOW);
		p44.setBounds(f4x[43], f4y[43], f4w, f4h);
		frame4.getContentPane().add(p44);

		JLabel l44 = new JLabel();
		l44.setForeground(Color.GREEN);
		l44.setFont(new Font("宋体", Font.BOLD, 24));
		p44.add(l44);

		JPanel p45 = new JPanel();
		p45.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		p45.setBackground(Color.YELLOW);
		p45.setBounds(f4x[44], f4y[44], f4w, f4h);
		frame4.getContentPane().add(p45);

		JLabel l45 = new JLabel();
		l45.setForeground(Color.GREEN);
		l45.setFont(new Font("宋体", Font.BOLD, 24));
		p45.add(l45);

		JPanel p46 = new JPanel();
		p46.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		p46.setBackground(Color.YELLOW);
		p46.setBounds(f4x[45], f4y[45], f4w, f4h);
		frame4.getContentPane().add(p46);

		JLabel l46 = new JLabel();
		l46.setForeground(Color.GREEN);
		l46.setFont(new Font("宋体", Font.BOLD, 24));
		p46.add(l46);

		JPanel p47 = new JPanel();
		p47.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		p47.setBackground(Color.YELLOW);
		p47.setBounds(f4x[46], f4y[46], f4w, f4h);
		frame4.getContentPane().add(p47);

		JLabel l47 = new JLabel();
		l47.setForeground(Color.GREEN);
		l47.setFont(new Font("宋体", Font.BOLD, 24));
		p47.add(l47);

		JPanel p48 = new JPanel();
		p48.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		p48.setBackground(Color.YELLOW);
		p48.setBounds(f4x[47], f4y[47], f4w, f4h);
		frame4.getContentPane().add(p48);

		JLabel l48 = new JLabel();
		l48.setForeground(Color.GREEN);
		l48.setFont(new Font("宋体", Font.BOLD, 24));
		p48.add(l48);

		JPanel p49 = new JPanel();
		p49.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		p49.setBackground(Color.YELLOW);
		p49.setBounds(f4x[48], f4y[48], f4w, f4h);
		frame4.getContentPane().add(p49);

		JLabel l49 = new JLabel();
		l49.setForeground(Color.GREEN);
		l49.setFont(new Font("宋体", Font.BOLD, 24));
		p49.add(l49);

		JPanel p50 = new JPanel();
		p50.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		p50.setBackground(Color.YELLOW);
		p50.setBounds(f4x[49], f4y[49], f4w, f4h);
		frame4.getContentPane().add(p50);

		JLabel l50 = new JLabel();
		l50.setForeground(Color.GREEN);
		l50.setFont(new Font("宋体", Font.BOLD, 24));
		p50.add(l50);
		JPanel p51 = new JPanel();
		p51.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		p51.setBackground(Color.YELLOW);
		p51.setBounds(f4x[50], f4y[50], f4w, f4h);
		frame4.getContentPane().add(p51);

		JLabel l51 = new JLabel();
		l51.setForeground(Color.GREEN);
		l51.setFont(new Font("宋体", Font.BOLD, 24));
		p51.add(l51);

		JPanel p52 = new JPanel();
		p52.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		p52.setBackground(Color.YELLOW);
		p52.setBounds(f4x[51], f4y[51], f4w, f4h);
		frame4.getContentPane().add(p52);

		JLabel l52 = new JLabel();
		l52.setForeground(Color.GREEN);
		l52.setFont(new Font("宋体", Font.BOLD, 24));
		p52.add(l52);

		JPanel p53 = new JPanel();
		p53.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		p53.setBackground(Color.YELLOW);
		p53.setBounds(f4x[52], f4y[52], f4w, f4h);
		frame4.getContentPane().add(p53);

		JLabel l53 = new JLabel();
		l53.setForeground(Color.GREEN);
		l53.setFont(new Font("宋体", Font.BOLD, 24));
		p53.add(l53);

		JPanel p54 = new JPanel();
		p54.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		p54.setBackground(Color.YELLOW);
		p54.setBounds(f4x[53], f4y[53], f4w, f4h);
		frame4.getContentPane().add(p54);

		JLabel l54 = new JLabel();
		l54.setForeground(Color.GREEN);
		l54.setFont(new Font("宋体", Font.BOLD, 24));
		p54.add(l54);

		JPanel p55 = new JPanel();
		p55.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		p55.setBackground(Color.YELLOW);
		p55.setBounds(f4x[54], f4y[54], f4w, f4h);
		frame4.getContentPane().add(p55);

		JLabel l55 = new JLabel();
		l55.setForeground(Color.GREEN);
		l55.setFont(new Font("宋体", Font.BOLD, 24));
		p55.add(l55);

		JPanel p56 = new JPanel();
		p56.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		p56.setBackground(Color.YELLOW);
		p56.setBounds(f4x[55], f4y[55], f4w, f4h);
		frame4.getContentPane().add(p56);

		JLabel l56 = new JLabel();
		l56.setForeground(Color.GREEN);
		l56.setFont(new Font("宋体", Font.BOLD, 24));
		p56.add(l56);

		JPanel p57 = new JPanel();
		p57.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		p57.setBackground(Color.YELLOW);
		p57.setBounds(f4x[56], f4y[56], f4w, f4h);
		frame4.getContentPane().add(p57);

		JLabel l57 = new JLabel();
		l57.setForeground(Color.GREEN);
		l57.setFont(new Font("宋体", Font.BOLD, 24));
		p57.add(l57);

		JPanel p58 = new JPanel();
		p58.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		p58.setBackground(Color.YELLOW);
		p58.setBounds(f4x[57], f4y[57], f4w, f4h);
		frame4.getContentPane().add(p58);

		JLabel l58 = new JLabel();
		l58.setForeground(Color.GREEN);
		l58.setFont(new Font("宋体", Font.BOLD, 24));
		p58.add(l58);

		JPanel p59 = new JPanel();
		p59.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		p59.setBackground(Color.YELLOW);
		p59.setBounds(f4x[58], f4y[58], f4w, f4h);
		frame4.getContentPane().add(p59);

		JLabel l59 = new JLabel();
		l59.setForeground(Color.GREEN);
		l59.setFont(new Font("宋体", Font.BOLD, 24));
		p59.add(l59);

		JPanel p60 = new JPanel();
		p60.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		p60.setBackground(Color.YELLOW);
		p60.setBounds(f4x[59], f4y[59], f4w, f4h);
		frame4.getContentPane().add(p60);

		JLabel l60 = new JLabel();
		l60.setForeground(Color.GREEN);
		l60.setFont(new Font("宋体", Font.BOLD, 24));
		p60.add(l60);

		JPanel p61 = new JPanel();
		p61.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		p61.setBackground(Color.YELLOW);
		p61.setBounds(f4x[60], f4y[60], f4w, f4h);
		frame4.getContentPane().add(p61);

		JLabel l61 = new JLabel();
		l61.setForeground(Color.GREEN);
		l61.setFont(new Font("宋体", Font.BOLD, 24));
		p61.add(l61);

		JPanel p62 = new JPanel();
		p62.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		p62.setBackground(Color.YELLOW);
		p62.setBounds(f4x[61], f4y[61], f4w, f4h);
		frame4.getContentPane().add(p62);

		JLabel l62 = new JLabel();
		l62.setForeground(Color.GREEN);
		l62.setFont(new Font("宋体", Font.BOLD, 24));
		p62.add(l62);

		JPanel p63 = new JPanel();
		p63.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		p63.setBackground(Color.YELLOW);
		p63.setBounds(f4x[62], f4y[62], f4w, f4h);
		frame4.getContentPane().add(p63);

		JLabel l63 = new JLabel();
		l63.setForeground(Color.GREEN);
		l63.setFont(new Font("宋体", Font.BOLD, 24));
		p63.add(l63);

		JPanel p64 = new JPanel();
		p64.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		p64.setBackground(Color.YELLOW);
		p64.setBounds(f4x[63], f4y[63], f4w, f4h);
		frame4.getContentPane().add(p64);

		JLabel l64 = new JLabel();
		l64.setForeground(Color.GREEN);
		l64.setFont(new Font("宋体", Font.BOLD, 24));
		p64.add(l64);

		JPanel p65 = new JPanel();
		p65.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		p65.setBackground(Color.YELLOW);
		p65.setBounds(f4x[64], f4y[64], f4w, f4h);
		frame4.getContentPane().add(p65);

		JLabel l65 = new JLabel();
		l65.setForeground(Color.GREEN);
		l65.setFont(new Font("宋体", Font.BOLD, 24));
		p65.add(l65);

		JPanel p66 = new JPanel();
		p66.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		p66.setBackground(Color.YELLOW);
		p66.setBounds(f4x[65], f4y[65], f4w, f4h);
		frame4.getContentPane().add(p66);

		JLabel l66 = new JLabel();
		l66.setForeground(Color.GREEN);
		l66.setFont(new Font("宋体", Font.BOLD, 24));
		p66.add(l66);

		JPanel p67 = new JPanel();
		p67.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		p67.setBackground(Color.YELLOW);
		p67.setBounds(f4x[66], f4y[66], f4w, f4h);
		frame4.getContentPane().add(p67);

		JLabel l67 = new JLabel();
		l67.setForeground(Color.GREEN);
		l67.setFont(new Font("宋体", Font.BOLD, 24));
		p67.add(l67);

		JPanel p68 = new JPanel();
		p68.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		p68.setBackground(Color.YELLOW);
		p68.setBounds(f4x[67], f4y[67], f4w, f4h);
		frame4.getContentPane().add(p68);

		JLabel l68 = new JLabel();
		l68.setForeground(Color.GREEN);
		l68.setFont(new Font("宋体", Font.BOLD, 24));
		p68.add(l68);

		JPanel p69 = new JPanel();
		p69.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		p69.setBackground(Color.YELLOW);
		p69.setBounds(f4x[68], f4y[68], f4w, f4h);
		frame4.getContentPane().add(p69);

		JLabel l69 = new JLabel();
		l69.setForeground(Color.GREEN);
		l69.setFont(new Font("宋体", Font.BOLD, 24));
		p69.add(l69);

		JPanel p70 = new JPanel();
		p70.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		p70.setBackground(Color.YELLOW);
		p70.setBounds(f4x[69], f4y[69], f4w, f4h);
		frame4.getContentPane().add(p70);

		JLabel l70 = new JLabel();
		l70.setForeground(Color.GREEN);
		l70.setFont(new Font("宋体", Font.BOLD, 24));
		p70.add(l70);
		JPanel p71 = new JPanel();
		p71.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		p71.setBackground(Color.YELLOW);
		p71.setBounds(f4x[70], f4y[70], f4w, f4h);
		frame4.getContentPane().add(p71);

		JLabel l71 = new JLabel();
		l71.setForeground(Color.GREEN);
		l71.setFont(new Font("宋体", Font.BOLD, 24));
		p71.add(l71);

		JPanel p72 = new JPanel();
		p72.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		p72.setBackground(Color.YELLOW);
		p72.setBounds(f4x[71], f4y[71], f4w, f4h);
		frame4.getContentPane().add(p72);

		JLabel l72 = new JLabel();
		l72.setForeground(Color.GREEN);
		l72.setFont(new Font("宋体", Font.BOLD, 24));
		p72.add(l72);

		JPanel p73 = new JPanel();
		p73.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		p73.setBackground(Color.YELLOW);
		p73.setBounds(f4x[72], f4y[72], f4w, f4h);
		frame4.getContentPane().add(p73);

		JLabel l73 = new JLabel();
		l73.setForeground(Color.GREEN);
		l73.setFont(new Font("宋体", Font.BOLD, 24));
		p73.add(l73);

		JPanel p74 = new JPanel();
		p74.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		p74.setBackground(Color.YELLOW);
		p74.setBounds(f4x[73], f4y[73], f4w, f4h);
		frame4.getContentPane().add(p74);

		JLabel l74 = new JLabel();
		l74.setForeground(Color.GREEN);
		l74.setFont(new Font("宋体", Font.BOLD, 24));
		p74.add(l74);

		JPanel p75 = new JPanel();
		p75.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		p75.setBackground(Color.YELLOW);
		p75.setBounds(f4x[74], f4y[74], f4w, f4h);
		frame4.getContentPane().add(p75);

		JLabel l75 = new JLabel();
		l75.setForeground(Color.GREEN);
		l75.setFont(new Font("宋体", Font.BOLD, 24));
		p75.add(l75);

		JPanel p76 = new JPanel();
		p76.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		p76.setBackground(Color.YELLOW);
		p76.setBounds(f4x[75], f4y[75], f4w, f4h);
		frame4.getContentPane().add(p76);

		JLabel l76 = new JLabel();
		l76.setForeground(Color.GREEN);
		l76.setFont(new Font("宋体", Font.BOLD, 24));
		p76.add(l76);

		JPanel p77 = new JPanel();
		p77.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		p77.setBackground(Color.YELLOW);
		p77.setBounds(f4x[76], f4y[76], f4w, f4h);
		frame4.getContentPane().add(p77);

		JLabel l77 = new JLabel();
		l77.setForeground(Color.GREEN);
		l77.setFont(new Font("宋体", Font.BOLD, 24));
		p77.add(l77);

		JPanel p78 = new JPanel();
		p78.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		p78.setBackground(Color.YELLOW);
		p78.setBounds(f4x[77], f4y[77], f4w, f4h);
		frame4.getContentPane().add(p78);

		JLabel l78 = new JLabel();
		l78.setForeground(Color.GREEN);
		l78.setFont(new Font("宋体", Font.BOLD, 24));
		p78.add(l78);

		JPanel p79 = new JPanel();
		p79.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		p79.setBackground(Color.YELLOW);
		p79.setBounds(f4x[78], f4y[78], f4w, f4h);
		frame4.getContentPane().add(p79);

		JLabel l79 = new JLabel();
		l79.setForeground(Color.GREEN);
		l79.setFont(new Font("宋体", Font.BOLD, 24));
		p79.add(l79);

		JPanel p80 = new JPanel();
		p80.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		p80.setBackground(Color.YELLOW);
		p80.setBounds(f4x[79], f4y[79], f4w, f4h);
		frame4.getContentPane().add(p80);

		JLabel l80 = new JLabel();
		l80.setForeground(Color.GREEN);
		l80.setFont(new Font("宋体", Font.BOLD, 24));
		p80.add(l80);

		JPanel p81 = new JPanel();
		p81.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		p81.setBackground(Color.YELLOW);
		p81.setBounds(f4x[80], f4y[80], f4w, f4h);
		frame4.getContentPane().add(p81);

		JLabel l81 = new JLabel();
		l81.setForeground(Color.GREEN);
		l81.setFont(new Font("宋体", Font.BOLD, 24));
		p81.add(l81);

		JPanel p82 = new JPanel();
		p82.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		p82.setBackground(Color.YELLOW);
		p82.setBounds(f4x[81], f4y[81], f4w, f4h);
		frame4.getContentPane().add(p82);

		JLabel l82 = new JLabel();
		l82.setForeground(Color.GREEN);
		l82.setFont(new Font("宋体", Font.BOLD, 24));
		p82.add(l82);

		JPanel p83 = new JPanel();
		p83.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		p83.setBackground(Color.YELLOW);
		p83.setBounds(f4x[82], f4y[82], f4w, f4h);
		frame4.getContentPane().add(p83);

		JLabel l83 = new JLabel();
		l83.setForeground(Color.GREEN);
		l83.setFont(new Font("宋体", Font.BOLD, 24));
		p83.add(l83);

		JPanel p84 = new JPanel();
		p84.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		p84.setBackground(Color.YELLOW);
		p84.setBounds(f4x[83], f4y[83], f4w, f4h);
		frame4.getContentPane().add(p84);

		JLabel l84 = new JLabel();
		l84.setForeground(Color.GREEN);
		l84.setFont(new Font("宋体", Font.BOLD, 24));
		p84.add(l84);

		JPanel p85 = new JPanel();
		p85.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		p85.setBackground(Color.YELLOW);
		p85.setBounds(f4x[84], f4y[84], f4w, f4h);
		frame4.getContentPane().add(p85);

		JLabel l85 = new JLabel();
		l85.setForeground(Color.GREEN);
		l85.setFont(new Font("宋体", Font.BOLD, 24));
		p85.add(l85);

		JPanel p86 = new JPanel();
		p86.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		p86.setBackground(Color.YELLOW);
		p86.setBounds(f4x[85], f4y[85], f4w, f4h);
		frame4.getContentPane().add(p86);

		JLabel l86 = new JLabel();
		l86.setForeground(Color.GREEN);
		l86.setFont(new Font("宋体", Font.BOLD, 24));
		p86.add(l86);

		JPanel p87 = new JPanel();
		p87.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		p87.setBackground(Color.YELLOW);
		p87.setBounds(f4x[86], f4y[86], f4w, f4h);
		frame4.getContentPane().add(p87);

		JLabel l87 = new JLabel();
		l87.setForeground(Color.GREEN);
		l87.setFont(new Font("宋体", Font.BOLD, 24));
		p87.add(l87);

		JPanel p88 = new JPanel();
		p88.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		p88.setBackground(Color.YELLOW);
		p88.setBounds(f4x[87], f4y[87], f4w, f4h);
		frame4.getContentPane().add(p88);

		JLabel l88 = new JLabel();
		l88.setForeground(Color.GREEN);
		l88.setFont(new Font("宋体", Font.BOLD, 24));
		p88.add(l88);

		JPanel p89 = new JPanel();
		p89.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		p89.setBackground(Color.YELLOW);
		p89.setBounds(f4x[88], f4y[88], f4w, f4h);
		frame4.getContentPane().add(p89);

		JLabel l89 = new JLabel();
		l89.setForeground(Color.GREEN);
		l89.setFont(new Font("宋体", Font.BOLD, 24));
		p89.add(l89);

		JPanel p90 = new JPanel();
		p90.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		p90.setBackground(Color.YELLOW);
		p90.setBounds(f4x[89], f4y[89], f4w, f4h);
		frame4.getContentPane().add(p90);

		JLabel l90 = new JLabel();
		l90.setForeground(Color.GREEN);
		l90.setFont(new Font("宋体", Font.BOLD, 24));
		p90.add(l90);

		JPanel p91 = new JPanel();
		p91.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		p91.setBackground(Color.YELLOW);
		p91.setBounds(f4x[90], f4y[90], f4w, f4h);
		frame4.getContentPane().add(p91);

		JLabel l91 = new JLabel();
		l91.setForeground(Color.GREEN);
		l91.setFont(new Font("宋体", Font.BOLD, 24));
		p91.add(l91);

		JPanel p92 = new JPanel();
		p92.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		p92.setBackground(Color.YELLOW);
		p92.setBounds(f4x[91], f4y[91], f4w, f4h);
		frame4.getContentPane().add(p92);

		JLabel l92 = new JLabel();
		l92.setForeground(Color.GREEN);
		l92.setFont(new Font("宋体", Font.BOLD, 24));
		p92.add(l92);

		JPanel p93 = new JPanel();
		p93.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		p93.setBackground(Color.YELLOW);
		p93.setBounds(f4x[92], f4y[92], f4w, f4h);
		frame4.getContentPane().add(p93);

		JLabel l93 = new JLabel();
		l93.setForeground(Color.GREEN);
		l93.setFont(new Font("宋体", Font.BOLD, 24));
		p93.add(l93);

		JPanel p94 = new JPanel();
		p94.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		p94.setBackground(Color.YELLOW);
		p94.setBounds(f4x[93], f4y[93], f4w, f4h);
		frame4.getContentPane().add(p94);

		JLabel l94 = new JLabel();
		l94.setForeground(Color.GREEN);
		l94.setFont(new Font("宋体", Font.BOLD, 24));
		p94.add(l94);

		JPanel p95 = new JPanel();
		p95.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		p95.setBackground(Color.YELLOW);
		p95.setBounds(f4x[94], f4y[94], f4w, f4h);
		frame4.getContentPane().add(p95);

		JLabel l95 = new JLabel();
		l95.setForeground(Color.GREEN);
		l95.setFont(new Font("宋体", Font.BOLD, 24));
		p95.add(l95);

		JPanel p96 = new JPanel();
		p96.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		p96.setBackground(Color.YELLOW);
		p96.setBounds(f4x[95], f4y[95], f4w, f4h);
		frame4.getContentPane().add(p96);

		JLabel l96 = new JLabel();
		l96.setForeground(Color.GREEN);
		l96.setFont(new Font("宋体", Font.BOLD, 24));
		p96.add(l96);

		JPanel p97= new JPanel();
		p97.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		p97.setBackground(Color.YELLOW);
		p97.setBounds(f4x[96], f4y[96], f4w, f4h);
		frame4.getContentPane().add(p97);

		JLabel l97 = new JLabel();
		l97.setForeground(Color.GREEN);
		l97.setFont(new Font("宋体", Font.BOLD, 24));
		p97.add(l97);

		JPanel p98 = new JPanel();
		p98.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		p98.setBackground(Color.YELLOW);
		p98.setBounds(f4x[97], f4y[97], f4w, f4h);
		frame4.getContentPane().add(p98);

		JLabel l98 = new JLabel();
		l98.setForeground(Color.GREEN);
		l98.setFont(new Font("宋体", Font.BOLD, 24));
		p98.add(l98);

		JPanel p99 = new JPanel();
		p99.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		p99.setBackground(Color.YELLOW);
		p99.setBounds(f4x[98], f4y[98], f4w, f4h);
		frame4.getContentPane().add(p99);

		JLabel l99 = new JLabel();
		l99.setForeground(Color.GREEN);
		l99.setFont(new Font("宋体", Font.BOLD, 24));
		p99.add(l99);

		JPanel p100 = new JPanel();
		p100.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		p100.setBackground(Color.YELLOW);
		p100.setBounds(f4x[99], f4y[99], f4w, f4h);
		frame4.getContentPane().add(p100);

		JLabel l100 = new JLabel();
		l100.setForeground(Color.GREEN);
		l100.setFont(new Font("宋体", Font.BOLD, 24));
		p100.add(l100);

		JPanel p101 = new JPanel();
		p101.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		p101.setBackground(Color.YELLOW);
		p101.setBounds(f4x[100], f4y[100], f4w, f4h);
		frame4.getContentPane().add(p101);

		JLabel l101 = new JLabel();
		l101.setForeground(Color.GREEN);
		l101.setFont(new Font("宋体", Font.BOLD, 24));
		p101.add(l101);

		JPanel p102 = new JPanel();
		p102.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		p102.setBackground(Color.YELLOW);
		p102.setBounds(f4x[101], f4y[101], f4w, f4h);
		frame4.getContentPane().add(p102);

		JLabel l102 = new JLabel();
		l102.setForeground(Color.GREEN);
		l102.setFont(new Font("宋体", Font.BOLD, 24));
		p102.add(l102);

		JPanel p103 = new JPanel();
		p103.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		p103.setBackground(Color.YELLOW);
		p103.setBounds(f4x[102], f4y[102], f4w, f4h);
		frame4.getContentPane().add(p103);

		JLabel l103 = new JLabel();
		l103.setForeground(Color.GREEN);
		l103.setFont(new Font("宋体", Font.BOLD, 24));
		p103.add(l103);

		JPanel p104 = new JPanel();
		p104.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		p104.setBackground(Color.YELLOW);
		p104.setBounds(f4x[103], f4y[103], f4w, f4h);
		frame4.getContentPane().add(p104);

		JLabel l104= new JLabel();
		l104.setForeground(Color.GREEN);
		l104.setFont(new Font("宋体", Font.BOLD, 24));
		p104.add(l104);

		JPanel p105 = new JPanel();
		p105.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		p105.setBackground(Color.YELLOW);
		p105.setBounds(f4x[104], f4y[104], f4w, f4h);
		frame4.getContentPane().add(p105);

		JLabel l105 = new JLabel();
		l105.setForeground(Color.GREEN);
		l105.setFont(new Font("宋体", Font.BOLD, 24));
		p105.add(l105);

		JPanel p106 = new JPanel();
		p106.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		p106.setBackground(Color.YELLOW);
		p106.setBounds(f4x[105], f4y[105], f4w, f4h);
		frame4.getContentPane().add(p106);

		JLabel l106 = new JLabel();
		l106.setForeground(Color.GREEN);
		l106.setFont(new Font("宋体", Font.BOLD, 24));
		p106.add(l106);

		JPanel p107 = new JPanel();
		p107.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		p107.setBackground(Color.YELLOW);
		p107.setBounds(f4x[106], f4y[106], f4w, f4h);
		frame4.getContentPane().add(p107);

		JLabel l107 = new JLabel();
		l107.setForeground(Color.GREEN);
		l107.setFont(new Font("宋体", Font.BOLD, 24));
		p107.add(l107);

		JPanel p108 = new JPanel();
		p108.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		p108.setBackground(Color.YELLOW);
		p108.setBounds(f4x[107], f4y[107], f4w, f4h);
		frame4.getContentPane().add(p108);

		JLabel l108 = new JLabel();
		l108.setForeground(Color.GREEN);
		l108.setFont(new Font("宋体", Font.BOLD, 24));
		p108.add(l108);

		JPanel p109 = new JPanel();
		p109.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		p109.setBackground(Color.YELLOW);
		p109.setBounds(f4x[108], f4y[108], f4w, f4h);
		frame4.getContentPane().add(p109);

		JLabel l109 = new JLabel();
		l109.setForeground(Color.GREEN);
		l109.setFont(new Font("宋体", Font.BOLD, 24));
		p109.add(l109);

		JPanel p110 = new JPanel();
		p110.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		p110.setBackground(Color.YELLOW);
		p110.setBounds(f4x[109], f4y[109], f4w, f4h);
		frame4.getContentPane().add(p110);

		JLabel l110 = new JLabel();
		l110.setForeground(Color.GREEN);
		l110.setFont(new Font("宋体", Font.BOLD, 24));
		p110.add(l110);

		JPanel p111 = new JPanel();
		p111.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		p111.setBackground(Color.YELLOW);
		p111.setBounds(f4x[110], f4y[110], f4w, f4h);
		frame4.getContentPane().add(p111);

		JLabel l111 = new JLabel();
		l111.setForeground(Color.GREEN);
		l111.setFont(new Font("宋体", Font.BOLD, 24));
		p111.add(l111);

		JPanel p112 = new JPanel();
		p112.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		p112.setBackground(Color.YELLOW);
		p112.setBounds(f4x[111], f4y[111], f4w, f4h);
		frame4.getContentPane().add(p112);

		JLabel l112 = new JLabel();
		l112.setForeground(Color.GREEN);
		l112.setFont(new Font("宋体", Font.BOLD, 24));
		p112.add(l112);

		JPanel p113 = new JPanel();
		p113.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		p113.setBackground(Color.YELLOW);
		p113.setBounds(f4x[112], f4y[112], f4w, f4h);
		frame4.getContentPane().add(p113);

		JLabel l113 = new JLabel();
		l113.setForeground(Color.GREEN);
		l113.setFont(new Font("宋体", Font.BOLD, 24));
		p113.add(l113);

		JPanel p114 = new JPanel();
		p114.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		p114.setBackground(Color.YELLOW);
		p114.setBounds(f4x[113], f4y[113], f4w, f4h);
		frame4.getContentPane().add(p114);

		JLabel l114 = new JLabel();
		l114.setForeground(Color.GREEN);
		l114.setFont(new Font("宋体", Font.BOLD, 24));
		p114.add(l114);

		JPanel p115 = new JPanel();
		p115.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		p115.setBackground(Color.YELLOW);
		p115.setBounds(f4x[114], f4y[114], f4w, f4h);
		frame4.getContentPane().add(p115);

		JLabel l115 = new JLabel();
		l115.setForeground(Color.GREEN);
		l115.setFont(new Font("宋体", Font.BOLD, 24));
		p115.add(l115);

		JPanel p116 = new JPanel();
		p116.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		p116.setBackground(Color.YELLOW);
		p116.setBounds(f4x[115], f4y[115], f4w, f4h);
		frame4.getContentPane().add(p116);

		JLabel l116 = new JLabel();
		l116.setForeground(Color.GREEN);
		l116.setFont(new Font("宋体", Font.BOLD, 24));
		p116.add(l116);

		JPanel p117 = new JPanel();
		p117.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		p117.setBackground(Color.YELLOW);
		p117.setBounds(f4x[116], f4y[116], f4w, f4h);
		frame4.getContentPane().add(p117);

		JLabel l117 = new JLabel();
		l117.setForeground(Color.GREEN);
		l117.setFont(new Font("宋体", Font.BOLD, 24));
		p117.add(l117);

		JPanel p118 = new JPanel();
		p118.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		p118.setBackground(Color.YELLOW);
		p118.setBounds(f4x[117], f4y[117], f4w, f4h);
		frame4.getContentPane().add(p118);

		JLabel l118 = new JLabel();
		l118.setForeground(Color.GREEN);
		l118.setFont(new Font("宋体", Font.BOLD, 24));
		p118.add(l118);

		JPanel p119 = new JPanel();
		p119.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		p119.setBackground(Color.YELLOW);
		p119.setBounds(f4x[118], f4y[118], f4w, f4h);
		frame4.getContentPane().add(p119);

		JLabel l119 = new JLabel();
		l119.setForeground(Color.GREEN);
		l119.setFont(new Font("宋体", Font.BOLD, 24));
		p119.add(l119);

		JPanel p120 = new JPanel();
		p120.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		p120.setBackground(Color.YELLOW);
		p120.setBounds(f4x[119], f4y[119], f4w, f4h);
		frame4.getContentPane().add(p120);

		JLabel l120 = new JLabel();
		l120.setForeground(Color.GREEN);
		l120.setFont(new Font("宋体", Font.BOLD, 24));
		p120.add(l120);

		JPanel p121 = new JPanel();
		p121.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		p121.setBackground(Color.YELLOW);
		p121.setBounds(f4x[120], f4y[120], f4w, f4h);
		frame4.getContentPane().add(p121);

		JLabel l121 = new JLabel();
		l121.setForeground(Color.GREEN);
		l121.setFont(new Font("宋体", Font.BOLD, 24));
		p121.add(l121);
		/************将元素放入数组中***************/
		JPlist.add(p1);
		JPlist.add(p2);
		JPlist.add(p3);
		JPlist.add(p4);
		JPlist.add(p5);
		JPlist.add(p6);
		JPlist.add(p7);
		JPlist.add(p8);
		JPlist.add(p9);
		JPlist.add(p10);
		JPlist.add(p11);
		JPlist.add(p12);
		JPlist.add(p13);
		JPlist.add(p14);
		JPlist.add(p15);
		JPlist.add(p16);
		JPlist.add(p17);
		JPlist.add(p18);
		JPlist.add(p19);
		JPlist.add(p20);
		JPlist.add(p21);
		JPlist.add(p22);
		JPlist.add(p23);
		JPlist.add(p24);
		JPlist.add(p25);
		JPlist.add(p26);
		JPlist.add(p27);
		JPlist.add(p28);
		JPlist.add(p29);
		JPlist.add(p30);
		JPlist.add(p31);
		JPlist.add(p32);
		JPlist.add(p33);
		JPlist.add(p34);
		JPlist.add(p35);
		JPlist.add(p36);
		JPlist.add(p37);
		JPlist.add(p38);
		JPlist.add(p39);
		JPlist.add(p40);
		JPlist.add(p41);
		JPlist.add(p42);
		JPlist.add(p43);
		JPlist.add(p44);
		JPlist.add(p45);
		JPlist.add(p46);
		JPlist.add(p47);
		JPlist.add(p48);
		JPlist.add(p49);
		JPlist.add(p50);
		JPlist.add(p51);
		JPlist.add(p52);
		JPlist.add(p53);
		JPlist.add(p54);
		JPlist.add(p55);
		JPlist.add(p56);
		JPlist.add(p57);
		JPlist.add(p58);
		JPlist.add(p59);
		JPlist.add(p60);
		JPlist.add(p61);
		JPlist.add(p62);
		JPlist.add(p63);
		JPlist.add(p64);
		JPlist.add(p65);
		JPlist.add(p66);
		JPlist.add(p67);
		JPlist.add(p68);
		JPlist.add(p69);
		JPlist.add(p70);
		JPlist.add(p71);
		JPlist.add(p72);
		JPlist.add(p73);
		JPlist.add(p74);
		JPlist.add(p75);
		JPlist.add(p76);
		JPlist.add(p77);
		JPlist.add(p78);
		JPlist.add(p79);
		JPlist.add(p80);
		JPlist.add(p81);
		JPlist.add(p82);
		JPlist.add(p83);
		JPlist.add(p84);
		JPlist.add(p85);
		JPlist.add(p86);
		JPlist.add(p87);
		JPlist.add(p88);
		JPlist.add(p89);
		JPlist.add(p90);
		JPlist.add(p91);
		JPlist.add(p92);
		JPlist.add(p93);
		JPlist.add(p94);
		JPlist.add(p95);
		JPlist.add(p96);
		JPlist.add(p97);
		JPlist.add(p98);
		JPlist.add(p99);
		JPlist.add(p100);
		JPlist.add(p101);
		JPlist.add(p102);
		JPlist.add(p103);
		JPlist.add(p104);
		JPlist.add(p105);
		JPlist.add(p106);
		JPlist.add(p107);
		JPlist.add(p108);
		JPlist.add(p109);
		JPlist.add(p110);
		JPlist.add(p111);
		JPlist.add(p112);
		JPlist.add(p113);
		JPlist.add(p114);
		JPlist.add(p115);
		JPlist.add(p116);
		JPlist.add(p117);
		JPlist.add(p118);
		JPlist.add(p119);
		JPlist.add(p120);
		JPlist.add(p121);

		JLlist.add(l1);
		JLlist.add(l2);
		JLlist.add(l3);
		JLlist.add(l4);
		JLlist.add(l5);
		JLlist.add(l6);
		JLlist.add(l7);
		JLlist.add(l8);
		JLlist.add(l9);
		JLlist.add(l10);
		JLlist.add(l11);
		JLlist.add(l12);
		JLlist.add(l13);
		JLlist.add(l14);
		JLlist.add(l15);
		JLlist.add(l16);
		JLlist.add(l17);
		JLlist.add(l18);
		JLlist.add(l19);
		JLlist.add(l20);
		JLlist.add(l21);
		JLlist.add(l22);
		JLlist.add(l23);
		JLlist.add(l24);
		JLlist.add(l25);
		JLlist.add(l26);
		JLlist.add(l27);
		JLlist.add(l28);
		JLlist.add(l29);
		JLlist.add(l30);
		JLlist.add(l31);
		JLlist.add(l32);
		JLlist.add(l33);
		JLlist.add(l34);
		JLlist.add(l35);
		JLlist.add(l36);
		JLlist.add(l37);
		JLlist.add(l38);
		JLlist.add(l39);
		JLlist.add(l40);
		JLlist.add(l41);
		JLlist.add(l42);
		JLlist.add(l43);
		JLlist.add(l44);
		JLlist.add(l45);
		JLlist.add(l46);
		JLlist.add(l47);
		JLlist.add(l48);
		JLlist.add(l49);
		JLlist.add(l50);
		JLlist.add(l51);
		JLlist.add(l52);
		JLlist.add(l53);
		JLlist.add(l54);
		JLlist.add(l55);
		JLlist.add(l56);
		JLlist.add(l57);
		JLlist.add(l58);
		JLlist.add(l59);
		JLlist.add(l60);
		JLlist.add(l61);
		JLlist.add(l62);
		JLlist.add(l63);
		JLlist.add(l64);
		JLlist.add(l65);
		JLlist.add(l66);
		JLlist.add(l67);
		JLlist.add(l68);
		JLlist.add(l69);
		JLlist.add(l70);
		JLlist.add(l71);
		JLlist.add(l72);
		JLlist.add(l73);
		JLlist.add(l74);
		JLlist.add(l75);
		JLlist.add(l76);
		JLlist.add(l77);
		JLlist.add(l78);
		JLlist.add(l79);
		JLlist.add(l80);
		JLlist.add(l81);
		JLlist.add(l82);
		JLlist.add(l83);
		JLlist.add(l84);
		JLlist.add(l85);
		JLlist.add(l86);
		JLlist.add(l87);
		JLlist.add(l88);
		JLlist.add(l89);
		JLlist.add(l90);
		JLlist.add(l91);
		JLlist.add(l92);
		JLlist.add(l93);
		JLlist.add(l94);
		JLlist.add(l95);
		JLlist.add(l96);
		JLlist.add(l97);
		JLlist.add(l98);
		JLlist.add(l99);
		JLlist.add(l100);
		JLlist.add(l101);
		JLlist.add(l102);
		JLlist.add(l103);
		JLlist.add(l104);
		JLlist.add(l105);
		JLlist.add(l106);
		JLlist.add(l107);
		JLlist.add(l108);
		JLlist.add(l109);
		JLlist.add(l110);
		JLlist.add(l111);
		JLlist.add(l112);
		JLlist.add(l113);
		JLlist.add(l114);
		JLlist.add(l115);
		JLlist.add(l116);
		JLlist.add(l117);
		JLlist.add(l118);
		JLlist.add(l119);
		JLlist.add(l120);
		JLlist.add(l121);

	}
	/*******************************************/
	/**
	 * 数据初始化
	 */
	public void shujuchushihua(int listnum) {
		for (int i = 0; i < listnum-1; i++) {
			JLlist.get(i).setText(Integer.toString(i+1));
		}
	}

	/**
	 * 随机数生成
	 */
	public void sjssc(int listnum) {
		int num=0;
		for (int i = 0; i < listnum; i++) {
			if (i*i==listnum) {
				num=i;
				break;
			}
		}
		shuZhi = new ShuZhiHuaRongDaoShuZhi(num);
		for (int i = 0; i < listnum; i++) {
			JLlist.get(i).setText(shuZhi.getArray1(i));
		}
		JLlist.get(listnum-1).setText(null);
	}

	/**
	 * 游戏方法
	 */
	public void youxifangfa(int a) {
		/**
		 * 鼠标点击移动
		 */
		for (int i = 0; i <a*a; i++) {
			int index=i;
			JLlist.get(i).addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent e) {
					if (index-1>=0&&JLlist.get(index-1).getText()==null) {
						JLlist.get(index-1).setText(JLlist.get(index).getText());
						JLlist.get(index).setText(null);
						new AePlayWave("dianji.wav").start();
						yingxiao=true;
						yd++;
					} else if (index+1<a*a&&JLlist.get(index+1).getText()==null){
						JLlist.get(index+1).setText(JLlist.get(index).getText());
						JLlist.get(index).setText(null);
						new AePlayWave("dianji.wav").start();
						yingxiao=true;
						yd++;
					}else if (index-a>0&&JLlist.get(index-a).getText()==null){
						JLlist.get(index-a).setText(JLlist.get(index).getText());
						JLlist.get(index).setText(null);
						new AePlayWave("dianji.wav").start();
						yingxiao=true;
						yd++;
					}else if (index+a<a*a&&JLlist.get(index+a).getText()==null){
						JLlist.get(index+a).setText(JLlist.get(index).getText());
						JLlist.get(index).setText(null);
						new AePlayWave("dianji.wav").start();
						yingxiao=true;
						yd++;
					}
					chenggong(a);
				}
			});
		}
		/**
		 * 键盘控制 WASD 上下左右箭头
		 */
		shezi4 = new SheZhi(a);
		frame4.getContentPane().add(shezi4);
		if (!yingxiao) {
			new AePlayWave("jinggao.wav").start();
		}
	}
	/**
	 * 定位空值
	 * @return 空值所在位置
	 */
	private int findnull(int ma) {
		for (int i = 0; i < ma*ma; i++) {
			if (JLlist.get(i).getText()==null) {
				return i;
			}
		}
		return -1;
	}
	/**
	 * 判断成功
	 * @param am
	 */
	public void chenggong(int am) {
		if (findnull(am)==am*am-1) {
			boolean cg = false;
			for (int i = 0; i < am*am-1; i++) {
				if (JLlist.get(i).getText().equals(Integer.toString(i+1))) {
					cg=true;
				} else {
					cg=false;
					break;
				}
			}
			if (cg) {
				System.out.println(hour+":"+min+":"+sec+am+yd);
				jilu.setNandu(am-3);
				jilu.setSec(sec);
				jilu.setMin(min);
				jilu.setHour(hour);
				jilu.setStep(yd);
				jilu.writea();
				jilu.writean();
				jilu.writeb();
				jilu.writebn();
				jilu.writec();
				jilu.writecn();
				new AePlayWave("shengli.wav").start();
				int result=JOptionPane.showConfirmDialog
						(null, "恭喜你成功通关\n用时:"+hour+":"+min+":"+sec+"\n"+"移动步数:"+yd+"\n"
								+"是:返回主界面,否：退出游戏","Information", JOptionPane.YES_NO_OPTION);
				if (result==JOptionPane.YES_NO_OPTION) {
					frame4.getContentPane().removeAll();
					JLlist.removeAll(JLlist);
					JPlist.removeAll(JPlist);
					frame4.setVisible(false);
					frame.setVisible(true);
				} else {
					System.exit(0);
				}
			}
		}
	}
	/**
	 * 找边界方法
	 * @param
	 */
	public boolean zbj(int av,char v) {
		if (v=='L') {
			if (findnull(av)%av==0) {
				return false;
			}
		} else {
			if ((findnull(av)+1)%av==0) {
				return false;
			}
		}
		return true;
	}
	/**
	 * 修改图片
	 * @param srcImgPath
	 * @param distImgPath
	 * @param width
	 * @param height
	 * @throws Exception
	 */
	public void ImageResizer(String srcImgPath,String distImgPath
			,int width,int height)throws Exception {
		File srcFile=new File(srcImgPath);
		Image srcImg = ImageIO.read(srcFile);
		BufferedImage buffImg =null;
		buffImg = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		buffImg.getGraphics().drawImage(srcImg.getScaledInstance(width,
				height, Image.SCALE_SMOOTH), 0, 0,null);
		ImageIO.write(buffImg, "JPEG", new File(distImgPath));
	}
	/**
	 * 设置按钮
	 */
	public void images() {
		retu.setBounds(-100, (frame4.getHeight()-50)/2-50,185,40);
		exit.setBounds(-100,(frame4.getHeight()-50)/2+50,185,40);
		frame4.getContentPane().add(retu);
		frame4.getContentPane().add(exit);
		retu.addMouseListener(new MouseAdapter() {
			@Override
			/**
			 * 返回主界面鼠标移出
			 */
			public void mouseExited(MouseEvent e) {
				retu.setBounds(-100,(frame4.getHeight()-50)/2-50,185,40);
				retu.setIcon(null);
				retu.setText("开始");
				retu.setHorizontalAlignment(SwingConstants.RIGHT);
				retu.setFont(new Font("Microsoft YaHei UI Light", Font.BOLD, 16));
			}
			@Override
			/**
			 * 返回主界面点击事件
			 */
			public void mouseClicked(MouseEvent e) {
				frame4.getContentPane().removeAll();
				JLlist.removeAll(JLlist);
				JPlist.removeAll(JPlist);
				frame4.setVisible(false);
				frame.setVisible(true);
			}
		});
		retu.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			/**
			 * 返回主界面鼠标移入
			 */
			public void mouseMoved(MouseEvent e) {
				retu.setBounds(0,(frame4.getHeight()-50)/2-50,185,40);
				retu.setText(null);
				retu.setHorizontalAlignment(SwingConstants.CENTER);
				retu.setIcon(new ImageIcon("return.jpg"));
			}
		});
		exit.addMouseListener(new MouseAdapter() {
			@Override
			/**
			 * 退出游戏鼠标移出
			 */
			public void mouseExited(MouseEvent e) {
				exit.setBounds(-100,(frame4.getHeight()-50)/2+50,185,40);
				exit.setIcon(null);
				exit.setText("退出");
				exit.setHorizontalAlignment(SwingConstants.RIGHT);
				exit.setFont(new Font("Microsoft YaHei UI Light", Font.BOLD, 16));
			}
			@Override
			/**
			 * 退出点击事件
			 */
			public void mouseClicked(MouseEvent e) {
				Timer.interrupted();
				System.exit(0);
			}
		});
		exit.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			/**
			 * 退出游戏鼠标移入
			 */
			public void mouseMoved(MouseEvent e) {
				exit.setBounds(0,(frame4.getHeight()-50)/2+50,185,40);
				exit.setText(null);
				exit.setHorizontalAlignment(SwingConstants.CENTER);
				exit.setIcon(new ImageIcon("exit.jpg"));
			}
		});
	}
	/**
	 * 通用
	 * @author asus
	 *	时间走动
	 */
	//计时器类

	class Timer extends Thread{

		public Timer(){


			sec=0;
			min=0;
			hour=0;
			this.start();
		}
		@Override
		public void run() {
			while(true){
				if(isRun){
					sec +=1 ;
					if(sec >= 60){
						sec = 0;
						min +=1 ;
					}
					if(min>=60){
						min=0;
						hour+=1;
					}
					showTime();
				}
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

			}
		}

		private void showTime(){
			String strTime ="" ;
			if(hour < 10)
				strTime = "0"+hour+":";
			else
				strTime = ""+hour+":";

			if(min < 10)
				strTime = strTime+"0"+min+":";
			else
				strTime =strTime+ ""+min+":";

			if(sec < 10)
				strTime = strTime+"0"+sec;
			else
				strTime = strTime+""+sec;

			//在窗体上设置显示时间
			showtime.setText("   " + strTime);
		}
	}
	@SuppressWarnings("serial")
	class Goon extends JButton{
		public Goon() {
			// TODO 自动生成的构造函数存根
			setBounds(-100,(frame4.getHeight()-50)/2,185,40);
			setHorizontalAlignment(SwingConstants.RIGHT);
			setForeground(Color.BLACK);
			setBackground(Color.ORANGE);
			setFont(new Font("Microsoft YaHei UI Light", Font.BOLD, 16));
			setText("挑战");
			this.addMouseMotionListener(new MouseMotionAdapter() {
				@Override
				/**
				 * 挑战下一关鼠标移入
				 */
				public void mouseMoved(MouseEvent e) {
					setBounds(0,(frame4.getHeight()-50)/2,185,40);
					setText(null);
					setHorizontalAlignment(SwingConstants.CENTER);
					setIcon(new ImageIcon("next.jpg"));
				}
			});
			this.addMouseListener(new MouseAdapter() {
				@Override
				/**
				 * 继续游戏鼠标移出
				 */
				public void mouseExited(MouseEvent e) {
					setBounds(-100,(frame4.getHeight()-50)/2,185,40);
					setIcon(null);
					setText("挑战");
					setHorizontalAlignment(SwingConstants.RIGHT);
					setFont(new Font("Microsoft YaHei UI Light", Font.BOLD, 16));
				}
				@Override
				/**
				 * 挑战下一关点击事件
				 */
				public void mouseClicked(MouseEvent e) {
					frame4.getContentPane().removeAll();
					JLlist.removeAll(JLlist);
					JPlist.removeAll(JPlist);
					//shezi4.removeKeyListener(null);
					frame4.setVisible(false);
					if (numa==4) {
						f4h=f4w=50;
						zbcsf(95, 25, 50, 4);
						shengcheng();
						shujuchushihua(4*4);
						frame4.setBounds((scrnsize.width-400)/2,(scrnsize.height-300)/2 , 400, 300);
						retu.setBounds(-100, (frame4.getHeight()-50)/2-50,185,40);
						setBounds(-100,(frame4.getHeight()-50)/2,185,40);
						exit.setBounds(-100,(frame4.getHeight()-50)/2+50,185,40);
						frame4.getContentPane().add(retu);
						frame4.getContentPane().add(goon);
						frame4.getContentPane().add(exit);
						numa=5;
						label.setSize(frame4.getWidth(),20);
						shezi4.setBounds(frame4.getWidth()-90, 0,80,30);
						kaishi.setBounds(frame4.getWidth()-120, frame4.getHeight()-100,100,35);
						frame4.getContentPane().add(shezi4);
						frame4.getContentPane().add(kaishi);
						frame4.getContentPane().add(label);
						shezi4.setVisible(true);
						kaishi.setVisible(true);
						label.setVisible(true);
						kaishi.addMouseListener(new MouseAdapter() {
							@Override
							public void mouseClicked(MouseEvent e) {
								sjssc(4*4);
								chenggong(4);
								youxifangfa(4);
								label.setVisible(false);
								kaishi.setVisible(false);
								if (isRun) {
									sec=0;
									min=0;
									hour=0;
									frame4.getContentPane().add(showtime);
									frame4.getContentPane().add(timech);
									showtime.setVisible(true);
									timech.setVisible(true);
								} else {
									sec=0;
									min=0;
									hour=0;
									isRun=true;
									frame4.getContentPane().add(showtime);
									frame4.getContentPane().add(timech);
									showtime.setVisible(true);
									timech.setVisible(true);
								}
							}
						});
					}else if (numa==5) {
						f4h=f4w=50;
						zbcsf(85, 25, 50, 5);
						shengcheng();
						shujuchushihua(5*5);
						frame4.setBounds((scrnsize.width-450)/2,(scrnsize.height-338)/2 , 450, 338);
						retu.setBounds(-100, (frame4.getHeight()-50)/2-50,185,40);
						setBounds(-100,(frame4.getHeight()-50)/2,185,40);
						exit.setBounds(-100,(frame4.getHeight()-50)/2+50,185,40);
						frame4.getContentPane().add(retu);
						frame4.getContentPane().add(goon);
						frame4.getContentPane().add(exit);
						numa=6;
						label.setSize(frame4.getWidth(),20);
						shezi4.setBounds(frame4.getWidth()-90, 0,80,30);
						kaishi.setBounds(frame4.getWidth()-120, frame4.getHeight()-100,100,35);
						frame4.getContentPane().add(shezi4);
						frame4.getContentPane().add(kaishi);
						frame4.getContentPane().add(label);
						shezi4.setVisible(true);
						kaishi.setVisible(true);
						label.setVisible(true);
						kaishi.addMouseListener(new MouseAdapter() {
							@Override
							public void mouseClicked(MouseEvent e) {
								sjssc(5*5);
								chenggong(5);
								youxifangfa(5);
								label.setVisible(false);
								kaishi.setVisible(false);
								if (isRun) {
									sec=0;
									min=0;
									hour=0;
									frame4.getContentPane().add(showtime);
									frame4.getContentPane().add(timech);
									showtime.setVisible(true);
									timech.setVisible(true);
								} else {
									sec=0;
									min=0;
									hour=0;
									isRun=true;
									frame4.getContentPane().add(showtime);
									frame4.getContentPane().add(timech);
									showtime.setVisible(true);
									timech.setVisible(true);
								}
							}
						});
					}else if (numa==6) {
						f4h=f4w=50;
						zbcsf(95, 25, 50, 6);
						shengcheng();
						shujuchushihua(6*6);
						frame4.setBounds((scrnsize.width-500)/2,(scrnsize.height-374)/2 , 500, 375);
						retu.setBounds(-100, (frame4.getHeight()-50)/2-50,185,40);
						setBounds(-100,(frame4.getHeight()-50)/2,185,40);
						exit.setBounds(-100,(frame4.getHeight()-50)/2+50,185,40);
						frame4.getContentPane().add(retu);
						frame4.getContentPane().add(goon);
						frame4.getContentPane().add(exit);
						numa=7;
						label.setSize(frame4.getWidth(),20);
						shezi4.setBounds(frame4.getWidth()-90, 0,80,30);
						kaishi.setBounds(frame4.getWidth()-120, frame4.getHeight()-100,100,35);
						frame4.getContentPane().add(shezi4);
						frame4.getContentPane().add(kaishi);
						frame4.getContentPane().add(label);
						shezi4.setVisible(true);
						kaishi.setVisible(true);
						label.setVisible(true);
						kaishi.addMouseListener(new MouseAdapter() {
							@Override
							public void mouseClicked(MouseEvent e) {
								sjssc(6*6);
								chenggong(6);
								youxifangfa(6);
								label.setVisible(false);
								kaishi.setVisible(false);
								if (isRun) {
									sec=0;
									min=0;
									hour=0;
									frame4.getContentPane().add(showtime);
									frame4.getContentPane().add(timech);
									showtime.setVisible(true);
									timech.setVisible(true);
								} else {
									sec=0;
									min=0;
									hour=0;
									isRun=true;
									frame4.getContentPane().add(showtime);
									frame4.getContentPane().add(timech);
									showtime.setVisible(true);
									timech.setVisible(true);
								}
							}
						});
					}else if (numa==7) {
						f4h=f4w=40;
						zbcsf(85, 25, 40, 7);
						shengcheng();
						shujuchushihua(7*7);
						frame4.setBounds((scrnsize.width-500)/2,(scrnsize.height-374)/2 , 500, 375);
						retu.setBounds(-100, (frame4.getHeight()-50)/2-50,185,40);
						setBounds(-100,(frame4.getHeight()-50)/2,185,40);
						exit.setBounds(-100,(frame4.getHeight()-50)/2+50,185,40);
						frame4.getContentPane().add(retu);
						frame4.getContentPane().add(goon);
						frame4.getContentPane().add(exit);
						numa=8;
						label.setSize(frame4.getWidth(),20);
						shezi4.setBounds(frame4.getWidth()-90, 0,80,30);
						kaishi.setBounds(frame4.getWidth()-120, frame4.getHeight()-100,100,35);
						frame4.getContentPane().add(shezi4);
						frame4.getContentPane().add(kaishi);
						frame4.getContentPane().add(label);
						shezi4.setVisible(true);
						kaishi.setVisible(true);
						label.setVisible(true);
						kaishi.addMouseListener(new MouseAdapter() {
							@Override
							public void mouseClicked(MouseEvent e) {
								sjssc(7*7);
								chenggong(7);
								youxifangfa(7);
								label.setVisible(false);
								kaishi.setVisible(false);
								if (isRun) {
									sec=0;
									min=0;
									hour=0;
									frame4.getContentPane().add(showtime);
									frame4.getContentPane().add(timech);
									showtime.setVisible(true);
									timech.setVisible(true);
								} else {
									sec=0;
									min=0;
									hour=0;
									isRun=true;
									frame4.getContentPane().add(showtime);
									frame4.getContentPane().add(timech);
									showtime.setVisible(true);
									timech.setVisible(true);
								}
							}
						});
					}else if (numa==8) {
						f4h=f4w=40;
						zbcsf(90, 35, 40, 8);
						shengcheng();
						shujuchushihua(8*8);
						frame4.setBounds((scrnsize.width-500)/2,(scrnsize.height-420)/2 , 550, 420);
						retu.setBounds(-100, (frame4.getHeight()-50)/2-50,185,40);
						exit.setBounds(-100,(frame4.getHeight()-50)/2+50,185,40);
						setBounds(-100,(frame4.getHeight()-50)/2,185,40);
						frame4.getContentPane().add(retu);
						frame4.getContentPane().add(goon);
						frame4.getContentPane().add(exit);
						numa=9;
						label.setSize(frame4.getWidth(),20);
						shezi4.setBounds(frame4.getWidth()-90, 0,80,30);
						kaishi.setBounds(frame4.getWidth()-120, frame4.getHeight()-100,100,35);
						frame4.getContentPane().add(shezi4);
						frame4.getContentPane().add(kaishi);
						frame4.getContentPane().add(label);
						shezi4.setVisible(true);
						kaishi.setVisible(true);
						label.setVisible(true);
						kaishi.addMouseListener(new MouseAdapter() {
							@Override
							public void mouseClicked(MouseEvent e) {
								sjssc(8*8);
								chenggong(8);
								youxifangfa(8);
								label.setVisible(false);
								kaishi.setVisible(false);
								if (isRun) {
									sec=0;
									min=0;
									hour=0;
									frame4.getContentPane().add(showtime);
									frame4.getContentPane().add(timech);
									showtime.setVisible(true);
									timech.setVisible(true);
								} else {
									sec=0;
									min=0;
									hour=0;
									isRun=true;
									frame4.getContentPane().add(showtime);
									frame4.getContentPane().add(timech);
									showtime.setVisible(true);
									timech.setVisible(true);
								}
							}
						});
					}else if (numa==9) {
						f4h=f4w=40;
						zbcsf(90, 35, 40, 9);
						shengcheng();
						shujuchushihua(9*9);
						frame4.setBounds((scrnsize.width-550)/2,(scrnsize.height-450)/2 , 550, 450);
						retu.setBounds(-100, (frame4.getHeight()-50)/2-50,185,40);
						goon.setBounds(-100,(frame4.getHeight()-50)/2,185,40);
						exit.setBounds(-100,(frame4.getHeight()-50)/2+50,185,40);
						frame4.getContentPane().add(retu);
						frame4.getContentPane().add(goon);
						frame4.getContentPane().add(exit);
						numa=10;
						label.setSize(frame4.getWidth(),20);
						shezi4.setBounds(frame4.getWidth()-90, 0,80,30);
						kaishi.setBounds(frame4.getWidth()-120, frame4.getHeight()-100,100,35);
						frame4.getContentPane().add(shezi4);
						frame4.getContentPane().add(kaishi);
						frame4.getContentPane().add(label);
						shezi4.setVisible(true);
						kaishi.setVisible(true);
						label.setVisible(true);
						kaishi.addMouseListener(new MouseAdapter() {
							@Override
							public void mouseClicked(MouseEvent e) {
								sjssc(9*9);
								chenggong(9);
								youxifangfa(9);
								label.setVisible(false);
								kaishi.setVisible(false);
								if (isRun) {
									sec=0;
									min=0;
									hour=0;
									frame4.getContentPane().add(showtime);
									frame4.getContentPane().add(timech);
									showtime.setVisible(true);
									timech.setVisible(true);
								} else {
									sec=0;
									min=0;
									hour=0;
									isRun=true;
									frame4.getContentPane().add(showtime);
									frame4.getContentPane().add(timech);
									showtime.setVisible(true);
									timech.setVisible(true);
								}
							}
						});
					}else if (numa==10) {
						f4h=f4w=40;
						zbcsf(125, 40, 40, 10);
						shengcheng();
						shujuchushihua(10*10);
						frame4.setBounds((scrnsize.width-650)/2,(scrnsize.height-500)/2 , 650, 500);
						retu.setBounds(-100, (frame4.getHeight()-50)/2-50,185,40);
						goon.setBounds(-100,(frame4.getHeight()-50)/2,185,40);
						exit.setBounds(-100,(frame4.getHeight()-50)/2+50,185,40);
						frame4.getContentPane().add(retu);
						frame4.getContentPane().add(goon);
						frame4.getContentPane().add(exit);
						numa=11;
						label.setSize(frame4.getWidth(),20);
						shezi4.setBounds(frame4.getWidth()-90, 0,80,30);
						kaishi.setBounds(frame4.getWidth()-120, frame4.getHeight()-100,100,35);
						frame4.getContentPane().add(shezi4);
						frame4.getContentPane().add(kaishi);
						frame4.getContentPane().add(label);
						shezi4.setVisible(true);
						kaishi.setVisible(true);
						label.setVisible(true);
						kaishi.addMouseListener(new MouseAdapter() {
							@Override
							public void mouseClicked(MouseEvent e) {
								sjssc(10*10);
								chenggong(10);
								youxifangfa(10);
								label.setVisible(false);
								kaishi.setVisible(false);
								if (isRun) {
									sec=0;
									min=0;
									hour=0;
									frame4.getContentPane().add(showtime);
									frame4.getContentPane().add(timech);
									showtime.setVisible(true);
									timech.setVisible(true);
								} else {
									sec=0;
									min=0;
									hour=0;
									isRun=true;
									frame4.getContentPane().add(showtime);
									frame4.getContentPane().add(timech);
									showtime.setVisible(true);
									timech.setVisible(true);
								}
							}
						});
					}else if (numa==11) {
						f4h=f4w=40;
						zbcsf(130, 45, 40, 11);
						shengcheng();
						shujuchushihua(11*11);
						frame4.setBounds((scrnsize.width-700)/2,(scrnsize.height-550)/2 , 700, 550);
						retu.setBounds(-100, (frame4.getHeight()-50)/2-50,185,40);
						exit.setBounds(-100,(frame4.getHeight()-50)/2+50,185,40);
						frame4.getContentPane().add(retu);
						frame4.getContentPane().add(exit);
						numa=0;
						label.setSize(frame4.getWidth(),20);
						shezi4.setBounds(frame4.getWidth()-90, 0,80,30);
						kaishi.setBounds(frame4.getWidth()-120, frame4.getHeight()-100,100,35);
						frame4.getContentPane().add(shezi4);
						frame4.getContentPane().add(kaishi);
						frame4.getContentPane().add(label);
						shezi4.setVisible(true);
						kaishi.setVisible(true);
						label.setVisible(true);
						kaishi.addMouseListener(new MouseAdapter() {
							@Override
							public void mouseClicked(MouseEvent e) {
								sjssc(11*11);
								chenggong(11);
								youxifangfa(11);
								label.setVisible(false);
								kaishi.setVisible(false);
								if (isRun) {
									sec=0;
									min=0;
									hour=0;
									frame4.getContentPane().add(showtime);
									frame4.getContentPane().add(timech);
									showtime.setVisible(true);
									timech.setVisible(true);
								} else {
									sec=0;
									min=0;
									hour=0;
									isRun=true;
									frame4.getContentPane().add(showtime);
									frame4.getContentPane().add(timech);
									showtime.setVisible(true);
									timech.setVisible(true);
								}
							}
						});
					}else {
						System.exit(0);
						return;
					}
					shezi4.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent e) {
							frame5.setVisible(true);
						}
					});
					frame4.setVisible(true);
				}
			});
		}
	}
	/**
	 *
	 * @author asus
	 * 设置类
	 */
	@SuppressWarnings("serial")
	class SheZhi extends JButton{
		public SheZhi(int sa) {
			// TODO 自动生成的构造函数存根
			setText("设置");
			setBounds(frame4.getWidth()-90, 0,80,30);
			this.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					frame5.setVisible(true);
				}
			});
			this.addKeyListener(new KeyAdapter() {
				@Override
				/**
				 * WASD
				 */
				public void keyTyped(KeyEvent e) {
					switch (e.getKeyChar()) {
						case KeyEvent.VK_W:
							if (findnull(sa)-sa>=0) {
								int setnull=findnull(sa)-sa;
								JLlist.get(findnull(sa)).setText(JLlist.get(findnull(sa)-sa).getText());
								JLlist.get(setnull).setText(null);
								chenggong(sa);
								new AePlayWave("dianji.wav").start();
								yingxiao=true;
								yd++;
							}
							break;
						case KeyEvent.VK_S:
							if(findnull(sa)+sa<sa*sa) {
								int setnull=findnull(sa)+sa;
								JLlist.get(findnull(sa)).setText(JLlist.get(findnull(sa)+sa).getText());
								JLlist.get(setnull).setText(null);
								chenggong(sa);
								new AePlayWave("dianji.wav").start();
								yingxiao=true;
								yd++;
							}
							break;
						case KeyEvent.VK_A:
							if (findnull(sa)-1>=0&zbj(sa,'L')) {
								int setnull=findnull(sa)-1;
								JLlist.get(findnull(sa)).setText(JLlist.get(findnull(sa)-1).getText());
								JLlist.get(setnull).setText(null);
								chenggong(sa);
								new AePlayWave("dianji.wav").start();
								yingxiao=true;
								yd++;
							}
							break;
						case KeyEvent.VK_D:
							if (findnull(sa)+1<sa*sa&&zbj(sa,'R')) {
								int setnull=findnull(sa)+1;
								JLlist.get(findnull(sa)).setText(JLlist.get(findnull(sa)+1).getText());
								JLlist.get(setnull).setText(null);
								chenggong(sa);
								new AePlayWave("dianji.wav").start();
								yingxiao=true;
								yd++;
							}
							break;
						default:
							break;
					}
				}
				@Override
				/**
				 * 上下左右
				 */
				public void keyPressed(KeyEvent e) {
					switch (e.getKeyCode()) {
						case KeyEvent.VK_UP:
							if (findnull(sa)-sa>=0) {
								int setnull=findnull(sa)-sa;
								JLlist.get(findnull(sa)).setText(JLlist.get(findnull(sa)-sa).getText());
								JLlist.get(setnull).setText(null);
								chenggong(sa);
								new AePlayWave("dianji.wav").start();
								yingxiao=true;
								yd++;
							}
							break;
						case KeyEvent.VK_DOWN:
							if(findnull(sa)+sa<sa*sa) {
								int setnull=findnull(sa)+sa;
								JLlist.get(findnull(sa)).setText(JLlist.get(findnull(sa)+sa).getText());
								JLlist.get(setnull).setText(null);
								chenggong(sa);
								new AePlayWave("dianji.wav").start();
								yingxiao=true;
								yd++;
							}
							break;
						case KeyEvent.VK_LEFT:
							if (findnull(sa)-1>=0&&zbj(sa,'L')) {
								int setnull=findnull(sa)-1;
								JLlist.get(findnull(sa)).setText(JLlist.get(findnull(sa)-1).getText());
								JLlist.get(setnull).setText(null);
								chenggong(sa);
								new AePlayWave("dianji.wav").start();
								yingxiao=true;
								yd++;
							}
							break;
						case KeyEvent.VK_RIGHT:
							if (findnull(sa)+1<sa*sa&&zbj(sa,'R')) {
								int setnull=findnull(sa)+1;
								JLlist.get(findnull(sa)).setText(JLlist.get(findnull(sa)+1).getText());
								JLlist.get(setnull).setText(null);
								chenggong(sa);
								new AePlayWave("dianji.wav").start();
								yingxiao=true;
								yd++;
							}
							break;
						default:
							break;
					}
				}
			});
			shezi4.setVisible(false);
			setVisible(true);
		}
	}
	class AePlayWave extends Thread {
		private String filename;
		private final int EXTERNAL_BUFFER_SIZE = 524288; // 128Kb

		public AePlayWave(String wavfile) {
			filename = wavfile;
		}

		@Override
		public void run() {
			File soundFile = new File(filename);
			AudioInputStream audioInputStream = null;
			try {
				audioInputStream = AudioSystem.getAudioInputStream(soundFile);
			} catch (UnsupportedAudioFileException e1) {
				e1.printStackTrace();
				return;
			} catch (IOException e1) {
				e1.printStackTrace();
				return;
			}

			AudioFormat format = audioInputStream.getFormat();
			SourceDataLine auline = null;
			DataLine.Info info = new DataLine.Info(SourceDataLine.class, format);

			try {
				auline = (SourceDataLine) AudioSystem.getLine(info);
				auline.open(format);
			} catch (LineUnavailableException e) {
				e.printStackTrace();
				return;
			} catch (Exception e) {
				e.printStackTrace();
				return;
			}

			auline.start();
			int nBytesRead = 0;
			byte[] abData = new byte[EXTERNAL_BUFFER_SIZE];

			try {
				while (nBytesRead != -1) {
					nBytesRead = audioInputStream.read(abData, 0, abData.length);
					if (nBytesRead >= 0)
						auline.write(abData, 0, nBytesRead);
				}
			} catch (IOException e) {
				e.printStackTrace();
				return;
			} finally {
				auline.drain();
				auline.close();
			}
		}
	}

}
