package collection.list.student;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.Scanner;

class Intmored extends Exception{ //국  . 영 . 수 점수 범위가 넘칠 때 오류
	public Intmored() {
		// TODO Auto-generated constructor stub
	}


}
public class Control {
	LinkedList<Student> stu = new LinkedList<>();
	Scanner sc = new Scanner(System.in);
	//학새의 정보를 입력받는 메서드
	
	
	public void inputShowInfo() {
		int kor=0;
		int eng=0;
		int math=0;
		System.out.println(" # 성적정보 입력을 시작합니다");
		System.out.print(" -학번 :");
		String stuId = sc.next();
		System.out.print("-이름 :");
		String name = sc.next();
		while(true) {
			try {
				System.out.print("국어 : ");
				kor = sc.nextInt();
				if(kor < 0 || kor > 100) {throw new Intmored();}
				System.out.print("영어 : ");
				eng = sc.nextInt();
				if(eng < 0 || eng > 100) {throw new Intmored();}
				System.out.print("수학 : ");
				math = sc.nextInt();
				stu.add(new Student(stuId,name,kor,eng,math));
				break;
			} catch (InputMismatchException e) {
				System.out.println("※※※※※※※※※점수를 숫자로 입력해주세요※※※※※※※※※※※");
				sc.nextLine();
			} catch(Intmored e) {
				System.out.println("※※※※※※※※※※0~100 사이의 수를 입력하시오※※※※※※※※※※");
				sc.nextLine();
			}


		}
	}
	public void outputShowInfo() {
		System.out.println("===학생들의 정보===");
		if(stu.size() == 0) {
			System.out.println("학생의 정보가 없습니다");
			return;
		}
		for(Student s : stu) {
			
			System.out.println("이름 :" + s.getName());
		}
	
	}
	
	public void deleteShowInfo() {
		if(stu.size() == 0) {
			System.out.println("학생의 정보가 없습니다");
			return;
		}
		System.out.println("===삭제할 정보의 학생====");
		System.out.print("이름을 입력하시오 : ");
		
		String name=sc.next();
	
		for(int i = 0; i<stu.size(); i++) {
			if(stu.get(i).getName().equals(name)){
				stu.remove(i);
				break;
			}
			
		}
		System.out.println("학생의 정보가 삭제 되었습니다");
	}
	
	public void SearchShowInfo() {
		System.out.println("===학생 찾기===");
		System.out.print("이름을 입력하시오 : ");
		String name=sc.next();
		for(Student s : stu) {
			if(s.getName().equals(name)) {
				System.out.println("학번" +  s.getStuId());
				System.out.println("이름" +  s.getName());
				System.out.println("국어" +  s.getKor());
				System.out.println("수학" +  s.getMath());
				System.out.println("영어" +  s.getEng());
				System.out.println("총점" +  s.getTot());
				System.out.println("평균" +  s.getAvg());
				System.out.println("학점" +  s.getGrade());
				break;
			}
		}
		System.out.println("학생의 정보가 없습니다");
		
		
	}
	
	public void save() {
		try {
		OutputStream ot = new FileOutputStream("save.txt");
		
		for(Student s  : stu) {
			String result = s.getStuId() + " " + s.getName() + " "
					+ s.getKor() + " " + s.getMath() + " " + s.getEng() +"\n";
			
		ot.write(result.getBytes());
		}
		ot.close();
		System.out.println("파일이 저장되었습니다.");
	}catch(IOException e) {
		System.out.println("파일 오류");
	}
	}
	public void load() {
		File file = new File("save.txt");
		
	    try {
			Scanner sc =new Scanner(file);
			
			
			while(sc.hasNext()) {
				Student se = new Student(sc.next(), sc.next(),sc.nextInt(),sc.nextInt(),sc.nextInt());
				
				stu.add(se);
			}
			System.out.println("파일을 불러왔습니다");
		} catch (FileNotFoundException e) {
		
			
		}
	}
	public void showMenu() {
		int menu=0;
		Scanner sc = new Scanner(System.in);


		do { 
			System.out.println("===학생관리 ===");
			System.out.println("1. 학생추가");
			System.out.println("2. 학생목록");
			System.out.println("3. 학생검색");
			System.out.println("4. 학생삭제");
			System.out.println("5. 저장");
			System.out.println("6. 불러오기");
			System.out.println("0. 종료");
			System.out.println("============");
			System.out.print("입력 :");
			while(true) {
				try {
					menu =sc.nextInt();
					break;
				} catch (Exception e) {
					System.out.println("숫자(정수)를 입력해주세요 !!");
					sc.nextLine();
				}
			}
			switch (menu) {
			case 1:
				inputShowInfo();
				break;
			case 2:
				outputShowInfo();
				break;
			case 3:
				SearchShowInfo();
				break;
			case 4:
				deleteShowInfo();
			case 5:
				save();
				break;
			case 6 :
				load();
				break;
			case 0 :
				System.out.println("종료되었습니다");
				break;
			default:
				
				break;
			}
		}while(menu != 0);
	}
}
