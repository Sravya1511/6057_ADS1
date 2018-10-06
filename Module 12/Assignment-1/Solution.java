import java.util.Scanner;
import java.util.Comparator;


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
		res = new Student[30];
		int count = 0;
		for(int i = 0; i<meritArray.length; i++) {
			if(meritArray[i].getReservation().equals("ST"))
                 x++;
            if(meritArray[i].getReservation().equals("SC"))
                 y++;
            if(meritArray[i].getReservation().equals("Bc"))
                 z++;
		}
		for(int i = 0; i<openVacancies; i++) {
			res[count++] = meritArray[i];
			// if(meritArray[i].reservation.equals("ST"))
   //               countSt++;
   //          if(meritArray[i].reservation.equals("SC"))
   //               countSc++;
   //          if(meritArray[i].reservation.equals("Bc"))
   //               ++;
		}
        int a = 0;
        int b = 0;
        int c = 0;
		for(int i = openVacancies; i<meritArray.length;i++) {
			if(meritArray[i].getReservation().equals("ST") && a!=stVacancies) {
                res[count++] = meritArray[i];
                a++;
			}
			else if(meritArray[i].getReservation().equals("SC") && b!=scVacancies) {
                res[count++] = meritArray[i];
                b++;
			}
			else if(meritArray[i].getReservation().equals("BC") && c!=bcVacancies) {
                res[count++] = meritArray[i];
                c++;
			}
			else if(x < stVacancies) {
				res[count++] = meritArray[i];
			}
			else if(y < scVacancies) {
				res[count++] = meritArray[i];
			}
			else if(z < bcVacancies) {
				res[count++] = meritArray[i];
			}
		}
		return res;
	}
}

/**
 * Class for solution.
 */


final class Solution {
	/**
	 * Constructs the object.
	 */
	private Solution () {
	}
	/**
	 * { reads input  }.
	 * creates object for Student Array class.
	 * adds students object to student array class.
	 *
	 * @param      args  The arguments
	 */
	public static void main(final String[] args) {
		Scanner input = new Scanner(System.in);
		int number = Integer.parseInt(input.nextLine());
		int vacancies = Integer.parseInt(input.nextLine());
		int openVacancies = Integer.parseInt(input.nextLine());
        int bcVacancies = Integer.parseInt(input.nextLine());
        int scVacancies = Integer.parseInt(input.nextLine());
        int stVacancies = Integer.parseInt(input.nextLine());
        StudentArray array = new StudentArray(number);
        Student[] meritArray = array.getArray();
        for (int i = 0; i < number; i++) {
        	String[] token = input.nextLine().split(",");
            array.addStudent(new Student(token[0], token[1], token[2], token[3], token[4], token[5], token[6]));
        }
        Insertion insertion = new Insertion();
        insertion.sort(meritArray, Student.meritComparator);

        for (int i = 0; i < number; i++) {
        	System.out.println(meritArray[i]);
        }

        System.out.println();

        Student [] reservationArray;
        reservationArray = new Student[vacancies];
        reservationArray = array.getReservationArray(vacancies, meritArray, openVacancies, bcVacancies, scVacancies, stVacancies);

        for (int i = 0; i < vacancies; i++) {
        	System.out.println(reservationArray[i]);
        }

	}
}