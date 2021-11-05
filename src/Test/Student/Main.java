package Test.Student;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
/**
 * 
 * @author dell
 *学生档案管理
 */
public class Main {

	//保存所有学生信息
	ArrayList<ArrayList<StudentModel>> stuInfoList = new ArrayList<ArrayList<StudentModel>>();
	//保存学生
	ArrayList<StudentModel> list =  new ArrayList<StudentModel>();
	//根据姓名保存学生信息
	HashMap<String, StudentModel> nameHashMap = new HashMap<String, StudentModel>(); 
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Main m = new Main();
		m.print();
		System.out.println("请输入录入的学生数量：");
		Scanner scanner = new Scanner(System.in);
		String s1 = scanner.nextLine();
		int n = Integer.valueOf(s1);
		m.insert(n);
		while(true) {
			System.out.println("请输入操作：");
			String s2 = scanner.nextLine();
			int operation = Integer.valueOf(s2);
			if(operation==0) {
				System.out.println("感谢使用，再见！");
				break;
			}
			while(operation!=0) {
				if(operation==1) {
					if(m.stuInfoList.size()==0) {
						System.out.println("当前学生档案为空！");
						break;
					}
					System.out.println("当前学生信息：");
					m.selectAllStudent();
					break;
				}else if(operation==2) {
					
					System.out.println("请输入要查找的学生姓名：");
					String nameString = scanner.nextLine();
					if(!m.nameHashMap.containsKey(nameString)) {
						System.out.println("不存在该学生");
						break;
					}
					m.selectByName(nameString);
					break;
				}else if(operation==3) {
					System.out.println("请输入要查找的专业：");
					String deptString = scanner.nextLine();
					int cou = m.selectByDept(deptString);
					if(cou==0) {
						System.out.println("该专业暂无学生");
						break;
					}
					break;
				}else if(operation==4) {
					//Scanner scanner = new Scanner(System.in);
					System.out.println("请输入存档学生数量");
					String s3 = scanner.nextLine();
					int nn = Integer.valueOf(s3);
					m.insert(nn);
					break;
				}
			}
		}
	}
	public void print() {
		System.out.println("-----学生信息管理-----");
		System.out.println("输入1：查看所有学生信息");
		System.out.println("输入2：根据学生姓名查找学生");
		System.out.println("输入3：根据专业查找学生");
		System.out.println("输入4：补录学生信息");
		System.out.println("输入0：退出本系统");
	}
	public void insert(int num) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("请输入学生信息");
		for(int i =0;i<num;i++) {
			System.out.print("姓名:");
			String name = scanner.nextLine();
			System.out.print("年龄:");
			String string = scanner.nextLine();
			int age = Integer.valueOf(string);
			System.out.print("性别:");
			String sex = scanner.nextLine();
			System.out.print("学号:");
			String sno = scanner.nextLine();
			System.out.print("专业:");
			String dept = scanner.nextLine();
			
			StudentModel student = new StudentModel(name, age, sex, sno, dept);
			list.add(student);
			nameHashMap.put(name, student);
			
		}
		stuInfoList.add(list);
		System.out.println("录入信息成功");
	}
	
	public void selectAllStudent() {
		for(int i =0;i<stuInfoList.size();i++) {
			System.out.println(stuInfoList.get(i).toString());
		}
		
	}
	
	public void selectByName(String name) {
		System.out.println("该学生的信息为：");
		System.out.println(nameHashMap.get(name).toString());
	}
	
	public int selectByDept(String dept) {
		int count=0;
		System.out.println("该专业学生信息：");
		for(int i =0;i<list.size();i++) {
			if(list.get(i).getDept().equals(dept)) {
				System.out.println(list.get(i).toString());
				count++;
			}
		}
		return count;
	}
}
