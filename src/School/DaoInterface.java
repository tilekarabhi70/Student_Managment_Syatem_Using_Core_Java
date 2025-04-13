package School;

import java.util.Collection;

public interface DaoInterface<T,K> {
  Collection<T> viewAllStudent();
  T retriveStudentById(K key);
  void addStudent(T t);
  void updateStudentDetails(T t);
  void deleteStudent(K key);
  
}
