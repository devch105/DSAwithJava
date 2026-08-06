package heaps;

import java.util.Comparator;
import java.util.PriorityQueue;

public class PriorityQue {


    static class Student implements Comparable<Student>{
        String name;
        int rank;
        public Student(String name, int rank){
            this.name = name;
            this.rank = rank;
        }

        @Override
        public int compareTo(Student o) {
            return this.rank - o.rank;
        }

        @Override
        public String toString() {
            return "Student{" +
                    "name='" + name + '\'' +
                    ", rank=" + rank +
                    '}';    
          }
        }   
     public static void main(String[] args) {
        

        PriorityQueue<Student> pq = new PriorityQueue<>(Comparator.reverseOrder()
    );
        pq.add(new Student("Alice", 3));
        pq.add(new Student("Bob", 1));
        pq.add(new Student("Charlie", 2));

        while (!pq.isEmpty()) {
            System.out.println("-> "+pq.peek().toString());
            pq.remove();
        }
        }
   
}