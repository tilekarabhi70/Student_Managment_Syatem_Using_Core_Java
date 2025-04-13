package School;

public class Student {
private int id;
private String name;
private int age;
private String email;
private String course;

public Student() {
	
}
public Student(int id,String name,int age,String email,String course) {
	this.id=id;
	this.name=name;
	this.age=age;
	this.email=email;
	this.course=course;
	
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
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
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getCourse() {
	return course;
}
public void setCourse(String course) {
	this.course = course;
}
@Override
public String toString() {
	return "id=" + id +"|"+ "name=" + name+"|" + " age=" + age +"|"+ " email=" + email +"|"+ " course=" + course +"|";
}

}
