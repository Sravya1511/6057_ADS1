import java.util.Scanner;
import java.util.Comparator;



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