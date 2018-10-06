import java.util.Scanner;
import java.util.Comparator;
class Student {
	String name;
	String dateOfBirth;
	int marks1;
	int marks2;
	int marks3;
	int total;
	String reservation;

	Student(String n, String dob, String m1, String m2, String m3, String t, String res) {
		this.name = n;
		this.dateOfBirth = dob;
		this.marks1 = Integer.parseInt(m1);
		this.marks2 = Integer.parseInt(m2);
		this.marks3 = Integer.parseInt(m3);
		this.total = Integer.parseInt(t);
		this.reservation = res;
	}

	public String toString() {
		return this.name+","+this.total+","+this.reservation;
	}

	static Comparator<Student> meritComparator = new Comparator<Student>() {
		public int compare(Student s1, Student s2) {
			if(s1.total - s2.total != 0)
				return s1.total - s2.total;
			else if(s1.marks3 - s2.marks3 != 0)
				return s1.marks3 - s2.marks3;
			// else if(s1.marks2 - s2.marks2 != 0)
			else if(s1.marks2 - s2.marks2 != 0)
				return s1.marks2 - s2.marks2;
			else
				return s1.dateOfBirth.compareTo(s2.dateOfBirth);
		}
	};
}


class StudentArray {
	Student[] studentArray;
	int size;

	StudentArray(int n) {
		studentArray = new Student[n];
		size = 0;
	}

	public void addStudent(Student student) {
		studentArray[size++] = student;
	}

	public Student[] getArray(){
		return studentArray;
	}

	public Student[] getReservationArray(int vacancies, Student[] meritArray, int openVacancies, int bcVacancies, int scVacancies, int stVacancies) {
		Student[] res;
		int x = 0;
		int y = 0;
		int z = 0;
		res = new Student[20];
		int count = 0;
		for(int i = 0; i<meritArray.length; i++) {
			if(meritArray[i].reservation.equals("ST"))
                 x++;
            if(meritArray[i].reservation.equals("SC"))
                 y++;
            if(meritArray[i].reservation.equals("Bc"))
                 z++;
		}
		for(int i = 0; i<openVacancies; i++) {
			res[count++] = meritArray[i];
			// if(meritArray[i].reservation.equals("ST"))
   //               x++;
   //          if(meritArray[i].reservation.equals("SC"))
   //               y++;
   //          if(meritArray[i].reservation.equals("Bc"))
   //               z++;
		}
        int a = 0;
        int b = 0;
        int c = 0;
		for(int i = openVacancies; i<meritArray.length;i++) {
			if(meritArray[i].reservation.equals("ST") && a!=stVacancies) {
                res[count++] = meritArray[i];
                a++;
			}
			else if(meritArray[i].reservation.equals("SC") && b!=scVacancies) {
                res[count++] = meritArray[i];
                b++;
			}
			else if(meritArray[i].reservation.equals("BC") && c!=bcVacancies) {
                res[count++] = meritArray[i];
                c++;
			}
			else if(x < stVacancies) {
				res[count++] = meritArray[i];
			}
		}
		return res;
	}
}

class Insertion {

	public Insertion() {}

	public static void sort(Object[] a, Comparator comparator) {
        int n = a.length;
        for (int i = 0; i < n; i++) {
            for (int j = i; j > 0 && great(a[j], a[j-1], comparator); j--) {
                exch(a, j, j-1);
            }
        }
    }
    private static  boolean great(Object v, Object w, Comparator comparator) {
        return comparator.compare(v, w) > 0;
    }

    private static void exch(Object[] a, int i, int j) {
        Object swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }
}


class Solution {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int number = Integer.parseInt(input.nextLine());
		int vacancies = Integer.parseInt(input.nextLine());
		int openVacancies = Integer.parseInt(input.nextLine());
        int bcVacancies = Integer.parseInt(input.nextLine());
        int scVacancies = Integer.parseInt(input.nextLine());
        int stVacancies = Integer.parseInt(input.nextLine());
        StudentArray array = new StudentArray(number);
        Student[] meritArray = array.getArray();
        for(int i = 0; i<number; i++) {
        	String[] token = input.nextLine().split(",");
            array.addStudent(new Student(token[0], token[1], token[2], token[3], token[4], token[5], token[6]));
        }
        Insertion insertion = new Insertion();
        insertion.sort(meritArray, Student.meritComparator);

        for(int i = 0; i<number; i++) {
        	System.out.println(meritArray[i]);
        }

        System.out.println();

        Student [] reservationArray;
        reservationArray = new Student[vacancies];
        reservationArray = array.getReservationArray(vacancies, meritArray, openVacancies, bcVacancies, scVacancies, stVacancies);

        for(int i = 0; i<vacancies; i++) {
        	System.out.println(reservationArray[i]);
        }

	}
}