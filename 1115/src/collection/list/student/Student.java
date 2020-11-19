package collection.list.student;

import java.util.Scanner;

public class Student {

	private String stuId;
	private String name;
	private int kor;
	private int eng;
	private int math;
	private int tot;
	private double avg;
	private char grade;
	
	
	public String getStuId() {
		return stuId;
	}
	public void setStuId(String stuId) {
		this.stuId = stuId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getKor() {
		return kor;
	}
	public void setKor(int kor) {
		this.kor = kor;
	}
	public int getEng() {
		return eng;
	}
	public void setEng(int eng) {
		this.eng = eng;
	}
	public int getMath() {
		return math;
	}
	public void setMath(int math) {
		this.math = math;
	}
	public int getTot() {
		return tot;
	}
	public void setTot(int tot) {
		this.tot = tot;
	}
	public double getAvg() {
		return avg;
	}
	public void setAvg(double avg) {
		this.avg = avg;
	}
	public char getGrade() {
		return grade;
	}
	public void setGrade(char grade) {
		this.grade = grade;
	}
	public Student(String stuId, String name, int kor, int eng, int math) {
		
		this.stuId = stuId;
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
		
		tot = kor + math + eng;
		avg = tot/3.0;
		grade = rank();
	}
	public Student() {
		// TODO Auto-generated constructor stub
	}
	
	public char rank() {
		if(avg > 90) {
			return 'A';
		}else if(avg>80){
			return 'B';
		}else if(avg>70) {
			return 'C';
		}else if(avg>60) {
			return 'D';
		}else
			return 'F';
		}
	
	}
