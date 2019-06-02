import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Random;
import java.io.File;
import java.util.Scanner;
import java.awt.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

class Main2{
	public static int money;
	public static int rodLevel;
	private static String userName;

    public static void main(String[] args){
		String[] fishArray = {"Salmon", "Flatfish", "Squid", "Octopus", "Minnow", "Shrimp", "Carp", "Tuna", "Mackerel", "Saury"};
		Random random = new Random();
		loadFile file = new loadFile();
		new Intro(fishArray);
	}
	public static void setUserName(String userName) {
		Main2.userName = userName;
	}
}
class loadFile{
	public loadFile(){
		String fileName= "user.txt";
		File file = new File(fileName);
		String buffer;
		int money=0;
		int rodLevel=1;
		try{
			Scanner sc = new Scanner(file);
			buffer = sc.nextLine();
			Main2.money = Integer.parseInt(buffer);
			buffer = sc.nextLine();
			Main2.rodLevel = Integer.parseInt(buffer);
			sc.close();
		}
		catch(FileNotFoundException e){
			System.out.println("Error occurred while trying to read the file");
		//file.createNewFile();
		}
	}
}
class ButtonMenu{
    JButton b1 = new JButton("FISHING");
    JButton b2 = new JButton("SHOP");
	JButton b3 = new JButton("SAVE");
	JButton b4 = new JButton("HELP");
	JButton b5 = new JButton("EXIT");
    
    public ButtonMenu(User user, String[] fishArray)
	{
		JFrame menu = new JFrame("Fishing game"); 
		menu.setLayout(new GridLayout(5,1)); 
		menu.add(b1);
		menu.add(b2);
		menu.add(b3);
		menu.add(b4);
		menu.add(b5);
		
		menu.setLocation(100,100);
		menu.setSize(300, 400); 
		menu.setVisible(true); 
		menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		b1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				MyLabel bar = new MyLabel(20);
				TabAndThreadEx frame = new TabAndThreadEx(bar);
				bar.setFrame(frame);
			}
		});//b1 ActionListener
		b2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				new Shopping(user);
			}
		});//b2 ActionListener
		b3.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				new SaveFile(user);
			}
		});//b3 ActionListener
		b4.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				new Ask(user);
			}
		});//b4 ActionListener
		b5.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				System.exit(0);
			}
		});//b5 ActionListener
	}//ButtonThree()
}//ButtonMenu
class Shopping{
	JButton beginner = new JButton("beginner");
	JLabel beginnerPrice = new JLabel("         100000");
	JButton intermediate = new JButton("intermediate");
	JLabel intermediatePrice = new JLabel("         500000");
	JButton advanced = new JButton("advanced");
	JLabel advancedPrice = new JLabel("         1000000");
	public Shopping(User user){
		JFrame shop = new JFrame("SHOP");
		shop.setLayout(new GridLayout(1,3));

		JPanel panel1 = new JPanel();
		panel1.setLayout(new GridLayout(2,1));
		panel1.add(beginner);
		panel1.add(beginnerPrice);
		JPanel panel2 = new JPanel();
		panel2.setLayout(new GridLayout(2,1));
		panel2.add(intermediate);
		panel2.add(intermediatePrice);
		JPanel panel3 = new JPanel();
		panel3.setLayout(new GridLayout(2,1));
		panel3.add(advanced);
		panel3.add(advancedPrice);

		shop.add(panel1);
		shop.add(panel2);
		shop.add(panel3);

		shop.pack();
        shop.setVisible(true);

		beginner.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(user.getMoney()>100000){
					user.setMoney(-100000);
					new Print("Shopping","Success to buy beginner fishing rod");
				}
				else
					new Print("Shopping","Not enough balance!");
			}
		});
		intermediate.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(user.getMoney()>500000){
					user.setMoney(-500000);
					new Print("Shopping","Success to buy intermediate fishing rod");
				}
				else
					new Print("Shopping","Not enough balance!");
			}
		});
		advanced.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(user.getMoney()>1000000){
					user.setMoney(-1000000);
					new Print("Shopping","Success to buy advanced fishing rod");
				}
				else
					new Print("Shopping","Not enough balance!");
			}
		});
	}
}
class SaveFile{
	public SaveFile(User user){
		new Print("saveFile","Saved:)");
		String fileName= "user.txt";
		PrintWriter outputStream= null;
		try{
		outputStream= new PrintWriter(fileName);
		}
		catch(FileNotFoundException f){
		System.out.println("Error opening the file"+ fileName);
		System.exit(0);
		}
		Scanner keyboard= new Scanner(System.in);
		outputStream.println(user.getMoney());
		outputStream.println(user.getRodLevel());
		outputStream.close();
	}
}//SaveFile
class Print{
    public Print(String frameName, String message){
        Dimension dim = new Dimension(300,100);
		JFrame frame = new JFrame(frameName);
		frame.setLayout(new BorderLayout());
        frame.setLocation(300,400);
        frame.setPreferredSize(dim);

        JLabel label = new JLabel();
        label.setText("                "+message);
        frame.add(label,BorderLayout.CENTER);
        frame.pack();
        frame.setVisible(true);
	}//Print()
}//Print
class Help{
	public Help(String selected,User user){
		Dimension dim;
		JLabel label = new JLabel();
		JFrame frame = new JFrame("fishing game");
		JButton button = new JButton("confirm");
		frame.setLocation(300,400);
	
		int selectHelp = Integer.parseInt(selected);
		if(selectHelp == 1){
			dim = new Dimension(200,400);
            label.setText("<html>| Salmon<br/>| Flatfish<br/>| Squid<br/>| Octopus<br/>| Minnow<br/>| Shrimp<br/>| Carp<br/>| Tuna<br/>| Mackerel<br/>| Saury</html>");
		}else if (selectHelp == 2){
			dim = new Dimension(200,200);
			label.setText("<html>| Fishing nod lists:<br/>| beginner<br/>| intermediate<br/>| advanced<br/></html>");
        }else if (selectHelp == 3){
			dim = new Dimension(700,200);
			label.setText("<html>| This program was made by Kiwoong Kim, Narin Kang, Geonha Baek, Goeun Lee, and Hyerim Lee<br/>| for Java Team Project in 2019 spring semester<br/>| This game is also supported by Prof. Ahn in Handong Global University<br/>| Any inquries, just Contact us: Handong@hanodong.edu</html>");
		}else if (selectHelp == 4){
			dim = new Dimension(200,200);
			label.setText("<html>Your name: "+user.getName()+"<br/>Your money: "+user.getMoney()+"<br/>Your rodLevel: "+user.getRodLevel()+"</html>");
		}else{
			dim = new Dimension(200,200);
            new Print("warining","\nYou entered wrong option");
		}
		frame.setPreferredSize(dim);
		frame.setLayout(new BorderLayout());
		frame.add(label,BorderLayout.CENTER);
		frame.add(button,BorderLayout.SOUTH);
		frame.pack();
		frame.setVisible(true);
		button.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				frame.dispose();
			}
		});
		
	}
}
class Ask{
	Ask(User user){
		Dimension dim = new Dimension(600,200);
		JFrame frame = new JFrame("askmenu");
		JButton button = new JButton("ENTER");
		JLabel label = new JLabel();
		JTextField text = new JTextField();

		label.setText("<html>| Creator: How can I help you?<br/>| 1: Show me the fish list<br/>| 2: Show me the fishing nod list<br/>| 3: Show me the creators who made this prgoram<br/>| 4:Your current information</html>");
		
		frame.setLocation(300,400);
		frame.setPreferredSize(dim);

		frame.setLayout(new BorderLayout());
		frame.add(label,BorderLayout.CENTER);
		frame.add(text,BorderLayout.SOUTH);
		frame.add(button,BorderLayout.EAST);

		frame.pack();
		frame.setVisible(true);

		button.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				new Help(text.getText(),user);
				frame.dispose();
			}
		});//button ActionListener
	}
}
class Intro{
    public Intro(String[] fishArray){
		JFrame frame = new JFrame("Move Label");
		JTextField name = new JTextField();
		JButton enter = new JButton("ENTER");
		MyPanel panel=new MyPanel();

        frame.setTitle("Enter your name");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.add(panel,BorderLayout.CENTER);
		frame.add(name,BorderLayout.SOUTH);
		frame.add(enter,BorderLayout.EAST);

		enter.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				String userName = name.getText();
				Main2.setUserName(userName);
				User user = new User(userName, Main2.money, Main2.rodLevel);
				//new Print("intro","In Handong University Electronic Engineering Department " + userName + "starts fishing to earn money for insufficient tuition. . . .");
				new ButtonMenu(user,fishArray);
				frame.dispose();
			}
		});
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setLocation(100,100);
        frame.setSize(800,500);
		frame.setVisible(true);
    }
    class MyPanel extends JPanel{
      ImageIcon icon=new ImageIcon("fishing.jpg");
      Image img=icon.getImage();
      public void paintComponent(Graphics g){
			super.paintComponent(g);
			g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
			g.setFont(new Font("myFont",Font.BOLD ,50));
			g.setColor(Color.BLACK);
			g.drawString("Fishing Game", 200, 70);
			g.setFont(new Font("secondFont",Font.PLAIN,20));
			g.setColor(Color.WHITE);
			g.drawString("Enter your name to start the game",10,430);
           }
	}
}
class MyLabel extends JLabel{
    int barSize=0;//바의 크기
    int maxBarSize; //바의 맥스 사이즈
    JFrame frame;
    MyLabel(int maxBarSize){
        this.maxBarSize=maxBarSize;
    }
    public void setFrame(JFrame frame){
        this.frame = frame;
    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(Color.darkGray);
        int width =(int)(((double)(this.getWidth()))/maxBarSize*barSize); //크기
        if(width==0) return;//크기가 0이면 바를 그릴 필요 없음
        g.fillRect(0,0,width,this.getHeight());
    }
    synchronized void fill(){
        if(barSize==maxBarSize){
            try{
                frame.dispose();
            }
            catch(Exception e){
                return;
            }
        }
        barSize++;
        this.repaint();//바 다시그리기
        this.notify();//기다리는 ConsumerThread 스레드 깨우기
    }
    synchronized void consume(){
        if(barSize==0){
            try{
                this.wait();//바의 크기가 0이면 바의 크기가 0보다 커질때까지 대기
            }
            catch(Exception e){
                return;
            }
        }
        barSize--;
        this.repaint();//바 다시 그리기
        this.notify();//기다리는 이벤트 스레드 깨우기
    }
}

class ConsumerThread extends Thread{
    MyLabel con;
    ConsumerThread(MyLabel con){
        this.con=con;
    }
    public void run(){
        while(true){
            try{
                sleep(500);
                con.consume();//0.2초마다 바를 1씩 줄인다.
            }
            catch(Exception e){
                return;
            }
        }
    }
}
class TabAndThreadEx extends JFrame{
    MyLabel bar;//바의 최대 크기를 100으로 지정
    JLabel letter = new JLabel("        click");
    
    TabAndThreadEx(MyLabel bar){
        this.bar = bar;
        this.setTitle("아무키나 빨리 눌러 바 채우기");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new GridLayout(2,1));
        
        JLabel text = new JLabel("아무거나");
        this.add(text);
        
        bar.setBackground(Color.ORANGE);
        bar.setOpaque(true);
        bar.setLocation(20, 50);
        bar.setSize(300,20);
        this.add(bar);
        
        this.pack();
        this.setVisible(true);
        this.addKeyListener(new KeyListener(){
            @Override
            public void keyTyped(KeyEvent ke) {
            }
            
            @Override
            public void keyPressed(KeyEvent ke) {
                Random ran = new Random();
                int rnd2 = ran.nextInt(10)/3;
                
                if(rnd2 == 0)
                {if(ke.getKeyChar() == 'a')
                    bar.fill();}//키를 누를때마다 바가 1씩 증가
                if(rnd2 == 1)
                {if(ke.getKeyChar() == 's')
                    bar.fill();}//키를 누를때마다 바가 1씩 증가
                if(rnd2 == 2)
                {if(ke.getKeyChar() == 'd')
                    bar.fill();}//키를 누를때마다 바가 1씩 증가
                if(rnd2 == 3)
                {if(ke.getKeyChar() == 'f')
                    bar.fill();}
            }
            @Override
            public void keyReleased(KeyEvent ke) {
            }
        });
        this.setLocationRelativeTo(null);
        this.setSize(350,200);
        this.setVisible(true);
        this.requestFocus();//키 처리권 부여
        ConsumerThread th = new ConsumerThread(bar);//스레드 생성
        th.start();//스레드 시작
    }
}