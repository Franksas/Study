
/*
 * 英才汇硕信息科技有限公司版权所有  @2018
 */
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.sql.rowset.JdbcRowSet;
import javax.xml.stream.events.StartDocument;

/**

@author yinhansong
@version  1.0
*/

class Student implements Serializable {
	String studentId;
	String studentName;
	int score;
	/**
	 * 学生继承父类Serializable
	 */
	public Student() {
		super();
	}
	/**
	 * @param studentId
	 * @param studentName
	 * @param score
	 */
	public Student(String studentId, String studentName, int score) {
		super();
		this.studentId = studentId;
		this.studentName = studentName;
		this.score = score;
	}
	public String getStudentId() {
		return studentId;
	}
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	@Override
	public String toString() {
		return " [studentId=" + studentId + ", studentName=" + studentName + ", score=" + score + "]";
	}


}
public class StudentDisplay {
	public static void main(String[] args) {
		Student s1 = new Student("101","小王",98);
		Student s2 = new Student("102","小海",100);
		Student s3 = new Student("103","小乐",99);
		List<Student> studentList = new ArrayList<Student>();
		studentList.add(s1);
		studentList.add(s2);
		studentList.add(s3);
		for (Student s : studentList){
			System.out.println(s);
		}
	}

}
