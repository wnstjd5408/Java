package manage;

public class Student {

	private String id, pwd, name, address;
	private int age;
	public Student() {
		// TODO Auto-generated constructor stub
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}

	
	public Student(String name, String id, String pwd,  String address, int age) {
		this.id = id;
		this.pwd = pwd;
		this.name = name;
		this.address = address;
		this.age = age;
	}
	
	
	
	
	
	
	
}
