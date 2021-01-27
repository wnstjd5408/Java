package manage;

public class Student_score {

	
	private int kor, eng, math, sci, his, sum ;
	private double avg;
	private String id;
	
	
	public int getSum() {
		return sum;
	}

	public void setSum(int sum) {
		this.sum = sum;
	}

	public double getAvg() {
		return avg;
	}

	public void setAvg(double avg) {
		this.avg = avg;
	}

	public Student_score(String id, int kor, int eng, int math, int sci, int his) {
		this.id =id;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
		this.sci = sci;
		this.his = his;
		
		
		sum = kor + eng + math + sci + his;
		avg = (double)sum/5;
	}

	public String getId() {
		return id;
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

	public int getSci() {
		return sci;
	}

	public void setSci(int sci) {
		this.sci = sci;
	}

	public int getHis() {
		return his;
	}

	public void setHis(int his) {
		this.his = his;
	}
	

	
	
	
	
}
