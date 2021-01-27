package student;

import java.util.*;

import manage.Student;
import manage.Student_score;

import java.io.*;

public class Play {
	private String id, pwd;
	private String name;
	private String address;
	private int age;
	private int menu, menu1;
	private Scanner sc = new Scanner(System.in);
	private LinkedList<Student> li = new LinkedList<>();
	private Student s = new Student(name, id, pwd, address, age);
	private Student_score st;

	public Play() {
		// TODO Auto-generated constructor stub
	}
	private boolean idcheck(String id) { // id 중복체크 검사 메서드
		boolean check = true;
		Student s = FindById(id);
		if (s == null) {
			check = false;
		}
		return check;
	}
	
	private Student FindById(String id) { // 컬렉션에 저장되어있는거 찾는 메서드
		//		load();
		for (Student s : li) {
			if (s.getId().equals(id)) {
				return s;
			}
		}
		return null;

	}


	public void login() { // login method
		System.out.println("=======================");
		System.out.println("          LOGIN    ");
		System.out.println("=======================");
		System.out.print(" ID : 	");
		id = sc.next();
		System.out.print(" PW : 	");
		pwd = sc.next();
		Student s = FindById(id);

		//		if(s !=null && s.getPwd().equals(pwd)){
		//			System.out.println(s.getName() + "님이 로그인 되었습니다");
		//			return s;
		//		}else if(s != null){
		//			
		//			return s;
		//		}


		if(s == null) 
		{ 
			System.out.println("등록되지 않은 ID 입니다"); 
		} 
		else if(s.getPwd().equals(pwd)) { 
			System.out.println( s.getName() +"님이 로그인 되었습니다 ");
			show_login();
			}
		else {
			System.out.println("비밀번호가 틀렸습니다!!!");
			}
	}
	public void student_show() { // 학생의 정보 출력 메서드
		System.out.println("학생 이름 : " + s.getName());
		System.out.println("학생의 ID :" + s.getId());
		System.out.println("학생의 나이 : " + s.getAge());
		System.out.println("학생의 주소 : " + s.getAddress());
	}

	public void show() { // 전체 메뉴 메서드 보기

		load();
		do {
			System.out.println("---------------");
			System.out.println("1.로그인 ");
			System.out.println("2.회원가입");
			System.out.println("0.종료");
			System.out.println("=-=-=-=-=-=-==-");
			System.out.print("입력 :");
			menu = sc.nextInt();

			switch (menu) {
			case 1:
				login();
				break;
			case 2:
				join();
				break;
			case 0:
				System.out.println("종료되었습니다");
				sc.close();
				break;
			default: {
				System.out.println("잘못입력하였습니다");
				break;
			}
			}
		} while (menu != 0);

	}

	public void show_login() {
		student_score_load();
		do {
			System.out.println("=========================");
			System.out.println("1. 	학생의 성적 입력 ");
			System.out.println("2. 	학생 점수 ");
			System.out.println("3. 	학생의 정보 ");
			System.out.println("0. 	로그아웃 ");
			System.out.println("=========================");
			System.out.print("입력 : ");
			menu1 = sc.nextInt();

			switch (menu1) {
			case 1:
				student_translate();
				System.out.println("성적을 입력하였습니다!!!!!!!!!!!!!");
				break;
			case 2:
				show_score();
				break;
			case 3:
				student_show();
				break;
			case 0:
				System.out.println("로그아웃되었습니다!!");
				break;
			}

		} while (menu1 != 0);
	}

	public void student_translate() {

		if (st == null) {
			int kor = 0;
			int eng = 0;
			int math = 0;
			int sci = 0;
			int his = 0;

			System.out.println("----학생의 성적 입력----");
			System.out.print("국어 : ");
			kor = sc.nextInt();
			System.out.print("수학 : ");
			math = sc.nextInt();
			System.out.print("영어 : ");
			eng = sc.nextInt();
			System.out.print("과학 : ");
			sci = sc.nextInt();
			System.out.print("역사 : ");
			his = sc.nextInt();

			st = new Student_score(s.getId(), kor, eng, math, sci, his);
			student_score_save();
		} else {
			System.out.println("※※※성적이 입력되어있습니다※※※");
		}
	}

	public void show_score() {
		try {
			System.out.println("******" + s.getName() + " 학생의 정보******");
			System.out.println("국어 : " + st.getKor());
			System.out.println("수학 : " + st.getMath());
			System.out.println("영어 : " + st.getEng());
			System.out.println("과학 : " + st.getSci());
			System.out.println("역사 : " + st.getHis());
			System.out.println("총점 : " + st.getSum());
			System.out.println("평균 : " + st.getAvg());
			System.out.println("********************");
		} catch (NullPointerException e) {
			System.out.println("성적을 입력해주세요!!!");
		}
	}

	public void load() { // 로그인 정보 파일 불러오기 Load method
		File file = new File("save.txt");

		try {
			Scanner sc = new Scanner(file);

			while (sc.hasNext()) {
				Student se = new Student(sc.next(), sc.next(), sc.next(), sc.next(), sc.nextInt());

				li.add(se);
			}
			//			System.out.println("파일을 불러왔습니다");
		} catch (FileNotFoundException e) {
			System.out.println("파일이 없습니다!!!!");

		}
	}

	public void student_score_load() { // 로그인 정보 파일 불러오기 Load method
		File file = new File("score.txt");

		try {
			Scanner sc = new Scanner(file);

			while (sc.hasNext()) {
				Student_score se = new Student_score(sc.next(), sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt(),
						sc.nextInt());

				if (s.getId().equals(se.getId())) {

					st = se;
				}
			}
			//			System.out.println("파일을 불러왔습니다");
		} catch (FileNotFoundException e) {
			System.out.println("파일이 없습니다!!!!");

		}
	}

	

	public void join() { // join method
		System.out.println("===========회원 가입입니다============");
		System.out.print("이름 : ");
		name = sc.next();
		s.setName(name);
		while (true) {
			System.out.print("아이디 : ");
			id = sc.next();
			if (idcheck(id)) {
				System.out.println("중복된 아이디입니다");
			} else {
				System.out.println("사용 가능한 ID 입니다");
				break;
			}
		}
		s.setId(id);

		a: while (true) {
			System.out.print("비밀번호  :");
			String pw = sc.next();
			System.out.print("비밀번호 확인 :");
			String pw_one = sc.next();

			if (pw.equals(pw_one)) {
				System.out.println("비밀번호가 일치 합니다!!!");
				s.setPwd(pw);
				sc.nextLine();
				break a;
			} else {
				System.out.println("비밀번호가 일치 하지않습니다!!!");
				sc.nextLine();
			}
		}
		System.out.print("나이 : ");
		age = sc.nextInt();
		s.setAge(age);

		System.out.print("주소  : ");
		address = sc.next();
		s.setAddress(address);

		li.add(s);

		save();
	}

	public void student_score_save() {// 학생 점수 정보 파일 한줄씩 저장 메서드 추가 save method
		try {
			FileWriter fw = new FileWriter("score.txt", true);
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter out = new PrintWriter(bw);

			String result = st.getId() + " " + st.getKor() + " " + st.getMath() + " " + st.getEng() + " " + st.getSci()
			+ " " + st.getHis() + "\n";
			out.print(result);
			out.close();
		} catch (IOException e) {
			System.out.println("파일 오류");
		} finally {

		}
	}

	public void save() {// 로그인 정보 파일 한줄씩 저장 메서드 추가 save method
		try {
			FileWriter fw = new FileWriter("save.txt", true);
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter out = new PrintWriter(bw);

			String result = s.getName() + " " + s.getId() + " " + s.getPwd() + " " + s.getAddress() + " " + s.getAge()
			+ "\n";
			out.print(result);
			out.close();
		} catch (IOException e) {
			System.out.println("파일 오류");
		} finally {

		}
	}
}
