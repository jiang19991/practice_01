package Test.Student;

public class StudentModel {

	private String name;
	private int age;
	private String sex;//0男1女
	private String sno;
	private String dept;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getSno() {
		return sno;
	}
	public void setSno(String sno) {
		this.sno = sno;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + ", sex=" + sex + ", sno=" + sno + ", dept=" + dept + "]";
	}
	public StudentModel(String name, int age, String sex, String sno, String dept) {
		super();
		this.name = name;
		this.age = age;
		this.sex = sex;
		this.sno = sno;
		this.dept = dept;
	}
	
}
