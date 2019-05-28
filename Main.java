import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

class Main {
  public static void main(String[] args) {
    String userName;
    String fileName= "user.txt";
    Scanner keyboard = new Scanner(System.in);
    Random random = new Random();
    int menu_num;

    //물고기 배열
    String[] fishArray = {"연어", "광어", "오징어", "문어", "피라미", "새우" };
    //이야기의 시작
	System.out.print("당신의 이름은? >> ");
    userName = keyboard.next();

    /*
    //파일 불러오기
    File file = new File(fileName);
    try{
      Scanner sc = new Scanner(file);
      int money = sc.nextInt(); //돈
      int rodLevel = sc.nextInt(); //로드레벨
      sc.close();
    }//try문 닫는 괄호
    catch(FileNotFoundException e){
      System.out.println("파일을 읽어오는 도중에 오류가 발생했습니다");
      file.createNewFile();
    }

    User user = new User(name, money, rodLevel);

   	System.out.println("한동대학교 전산전자공학부 " + userName + "은 부족한 학비를 모으기 위해 낚시를 시작하게 되는데 . . .");
// delay 후 콘솔창 clear

     */

    System.out.println("한동대학교 전산전자공학부 " + userName + "은 부족한 학비를 모으기 위해 낚시를 시작하게 되는데 . . .\n\n");





//콘솔창 clear
//타이틀
    System.out.println("\t낚시왕 " + userName + "!");
    System.out.println();
//콘솔창 clear

    User user = new User(userName);
    boolean gameEND = false;
    int menu;

//반복문 안에 메뉴 선택 스위치문으로
    while(!gameEND){
    	// 메뉴선택
      System.out.println("\t" + userName + "(돈: " + user.getMoney() + " | 낚싯대 레벨: " + user.getRodLevel() + ")");
      System.out.println("\t1. 낚시하러 가기");
      System.out.println("\t2. 상점 가기");
      System.out.println("\t3. 저장하기");
      System.out.println("\t4. 종료하기");
      System.out.print("\t>> ");

      menu = keyboard.nextInt();
      // 콘솔창 clear
      switch(menu){
      case 1: // 낚시하러
      //Fish fish = new Fish(랜덤한 물고기 이름, 랜덤한 물고기 무게);
        int randomInt = random.nextInt(fishArray.length -1);
        double fishWeight = 10 * random.nextDouble() + 1;
        int fishPrice = (int)(fishWeight * 1000);
        Fish fish = new Fish(fishArray[randomInt], fishWeight, fishPrice);

        	//낚시 실패하면
        System.out.println(fishArray[randomInt] + "를 낚는 데 실패했습니다… T.T");

        	//낚시 성공하면
        System.out.println(fishArray[randomInt] + "를 낚는 데 성공했습니다! O.O");
        user.sell(fish);

        break;

      case 2: // 상점으로

      	Rod rod = new Rod ();
      	rod.messageStore();
      	Scanner key = new Scanner(System.in);
		int selectRod = key.nextInt();
        rod.setName(selectRod);
        rod.setPrice(selectRod);
      	int currentMoney= user.getMoney() - rod.getPrice();
        user.setMoney(currentMoney);
      	System.out.println(rod.getName() + "을 구매하셨습니다");
      	break;

      case 3: //저장하기
      	savefile(user);
      	break;

      case 4: //게임종료
      	System.out.println("게임을 종료합니다");
      	savefile(user);
      	keyboard.close();
      	System.exit(0);
      	break;
      }//switch문 닫는 괄호
    }//while문 닫는 괄호
  }//main함수 닫는 괄호

  public void fishing(){ //낚시하기

  }//fishing 함수 닫는 괄호

  public void shop(){//상점

  }//shop 함수 닫는 괄호

  public static void savefile(User user){//user정보 저장
	String fileName= "user.txt";
    PrintWriter outputStream= null;
	try{
      outputStream= new PrintWriter(fileName);
    }
    catch(FileNotFoundException e){
      System.out.println("Error opening the file"+ fileName);
      System.exit(0);
    }
    Scanner keyboard= new Scanner(System.in);
    outputStream.println(user.getName() + user.getMoney() + user.getRodLevel());
    outputStream.close();

    System.out.println("저장 완료");

  }//savefile 함수 닫는 괄호

}//class Main 닫는 괄호














/*

//<User가 여러명일때>

//Scanner inputStream= null;
try{
inputStream= newScanner(newFile(fileName));
}
catch(FileNotFoundExceptione){
System.out.println("Error opening the file "+ fileName);
System.exit(0);
}
while(inputStream.hasNextLine()){
String line= inputStream.nextLine();
if(line==userName){
	System.out.println("이전의 기록된 사용자가 있습니다. 이어서 하시겠습니까?(1.예 2.아니오)");
	int n=keyboard.nextInt();
	if(n==1){
이름 돈 낚싯대 레벨
}
}//if
}//while문
inputStream.close();

while()
String name=sc.next();
if(userName==name)//그대로이어서
없으면 새로 만들기

< user.txt >
user
0
0

*/
