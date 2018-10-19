import java.util.Comparator;
import java.util.Scanner;
/**
 * Class for student array.
 * The student array creates array of student class.
 */
class StudentArray {
    /**
     * student array of student class.
     */
    private Student[] studentArray;
    /**
     * size of student array of int type.
     */
    private int size;
    /**
     * student array res of type student.
     */
    private Student[] res;
    // res = new Student[30];


    /**
     * Constructs the object.
     *
     * @param      n     { int n - size of student array }
     */
    StudentArray(final int n) {
        studentArray = new Student[n];
        size = 0;
    }
    /**
     * Adds a student.
     * The time complexity is O(1).
     *
     * @param      student  The student of type student
     */
    public void addStudent(final Student student) {
        studentArray[size++] = student;
    }
    /**
     * Gets the array.
     * The time complexity is O(1).
     *
     * @return     The array of student type.
     */

    public Student[] getArray() {
        return studentArray;
    }
    /**
     * Gets the reservation array.
     * The time complexity is O(N^2).
     *
     * @param      vacancies      The vacancies of type int.
     * @param      meritArray     The merit array of type studnet.
     * @param      openVacancies  The open vacancies of type int
     * @param      bcVacancies    The bc vacancies of type int.
     * @param      scVacancies    The screen vacancies of type int.
     * @param      stVacancies    The st vacancies of type int.
     *
     * @return     The reservation array.
     */

    public Student[] getReservationArray(final int vacancies,
        final Student[] meritArray,
        final int openVacancies, final int bcVacancies,
        final int scVacancies,
        final int stVacancies) {
        final int th = 30;
        res = new Student[th];

        int count = 0;

        for (int i = 0; i < openVacancies; i++) {
            res[count++] = meritArray[i];
        }
        int a = 0;
        int b = 0;
        int c = 0;
        for (int i = openVacancies; i < meritArray.length; i++) {
            if (meritArray[i].getReservation().equals("ST")
                && a != stVacancies) {
                res[count++] = meritArray[i];
                a++;
            } else if (meritArray[i].getReservation().equals("SC")
                && b != scVacancies) {
                res[count++] = meritArray[i];
                b++;
            } else if (meritArray[i].getReservation().equals("BC")
                && c != bcVacancies) {
                res[count++] = meritArray[i];
                c++;
            }
        }

            if (a != stVacancies) {
                for (int i = openVacancies;
                    i < meritArray.length; i++) {
                    if (!contains(meritArray[i])) {
                         res[count++] = meritArray[i];
                         a++;
                         if (a == stVacancies) {
                            break;
                         }
                    }
                }
            }
            if (b != scVacancies) {
                for (int i = openVacancies;
                    i < meritArray.length; i++) {
                    if (!contains(meritArray[i])) {
                         res[count++] = meritArray[i];
                         b++;
                         if (b == scVacancies) {
                            break;
                         }
                    }
                }
            }
            if (c != bcVacancies) {
                for (int i = openVacancies;
                    i < meritArray.length; i++) {
                    if (!contains(meritArray[i])) {
                         res[count++] = meritArray[i];
                         c++;
                         if (c == bcVacancies) {
                            break;
                         }
                    }
                }
            }
        // return res;
            Student[] result = new Student[count];
            for (int i = 0; i < count; i++) {
                result[i] = res[i];
            }
            Insertion insertion = new Insertion();
            insertion.sort(result, Student.meritComparator());
            return result;
    }
    /**
     * checks if there is element present or not.
     * The time complexity is O(N) - worst case.
     *
     *
     * @param      name  The name of student type
     *
     * @return     { returns boolean  }
     */

    public boolean contains(final Student name) {
        for (Student i : res) {
            if (i != (null)) {
            if (i.equals(name))  {
                return true;
            }
            }

        }
        return false;
    }
}




/**
 * Class for solution.
 */


final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {
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
        final int two = 2;
        final int three = 3;
        final int four = 4;
        final int five = 5;
        final int six = 6;
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
            array.addStudent(new Student(token[0], token[1],
                token[two], token[three], token[four],
                token[five], token[six]));
        }
        Insertion insertion = new Insertion();
        insertion.sort(meritArray, Student.meritComparator());

        for (int i = 0; i < number; i++) {
            System.out.println(meritArray[i]);
        }

        System.out.println();

        Student[] reservationArray;
        reservationArray = new Student[vacancies];
        reservationArray = array.getReservationArray(vacancies,
            meritArray, openVacancies, bcVacancies,
            scVacancies, stVacancies);

        for (int i = 0; i < vacancies; i++) {
            System.out.println(reservationArray[i]);
        }

    }
}
/**
 * Class for insertion.
 * The time complexity is O(N^2).
 */
class Insertion {
    /**
     * Constructs the object.
     */

    Insertion() {

    }

    /**
     * sorts the object array.
     * The time complexity is O(N^2).
     *
     * @param      a           { object of student type}.
     * @param      comparator  The comparator.
     */

    public void sort(final Object[] a, final Comparator comparator) {
        int n = a.length;
        for (int i = 0; i < n; i++) {
            for (int j = i; j > 0 && great(a[j], a[j - 1], comparator); j--) {
                exch(a, j, j - 1);
            }
        }
    }
    /**
     * compares two objects of student class
     * The time complexity is O(1).
     *
     * @param      v           { student object }
     * @param      w           { student object}
     * @param      comparator  The comparator
     *
     * @return     { returns boolean }
     */
    private boolean great(final Object v,
        final Object w, final Comparator comparator) {
        return comparator.compare(v, w) > 0;
    }

    /**
     * exchanges two objects
     * The time complexity is O(1).
     *
     *
     * @param      a     { student object }
     * @param      i     { index of int type}
     * @param      j     { index of int type }
     */

    private void exch(final Object[] a, final int i, final int j) {
        Object swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }
}

/**
 * Class for student.
 * The student class student attibutes.
 *
 */
class Student {
    /**
     * name of the student.
     */
    private String name;
    /**
     * date of birth of the student.
     */
    private String dateOfBirth;
    /**
     * marks1 of student.
     */
    private int marks1;
    /**
     * marks2 of student.
     */
    private int marks2;
    /**
     * marks3 of student.
     */
    private int marks3;
    /**
     * total marks of student.
     */
    private int total;
    /**
     * Reservation of student.
     */
    private String reservation;

    /**
     * Constructs the object.
     *
     * @param      n     { name of type string }.
     * @param      dob   The dob of type String.
     * @param      m1    The m1 of int type.
     * @param      m2    The m2 of int type.
     * @param      m3    The m3 of int type.
     * @param      t     total marks of int type.
     * @param      res   The reservation od string type.
     */
    Student(final String n, final String dob, final String m1,
        final String m2,
        final String m3, final String t, final String res) {
        this.name = n;
        this.dateOfBirth = dob;
        this.marks1 = Integer.parseInt(m1);
        this.marks2 = Integer.parseInt(m2);
        this.marks3 = Integer.parseInt(m3);
        this.total = Integer.parseInt(t);
        this.reservation = res;
    }
/**
 * Constructs the object.
 */
    Student() {

    }

    /**
     * Gets the marks 1.
     *
     * @return     The marks 1 of int type.
     */

    public int getMarks1() {
        return marks1;
    }
    /**
     * Gets the marks 2.
     *
     * @return     The marks 2 of int type.
     */
    public int getMarks2() {
        return marks2;
    }
    /**
     * Gets the marks 3.
     *
     * @return     The marks 3 of int type.
     */
    public int getMarks3() {
        return marks3;
    }
    /**
     * Gets the name.
     *
     * @return     The name of String type.
     */
    public String getName() {
        return name;
    }
    /**
     * Gets the year.
     *
     * @return     The year of int type.
     */

   public int getYear() {
        String[] date = dateOfBirth.split("-");
        int year = Integer.parseInt(date[2]);
        return year;
    }
    /**
     * Gets the month.
     *
     * @return     The month of int type.
     */
    public int getMonth() {
        String[] date = dateOfBirth.split("-");
        int month = Integer.parseInt(date[1]);
        return month;
    }
    /**
     * Gets the day.
     *
     * @return     The day of int type.
     */
    public int getDay() {
        String[] date = dateOfBirth.split("-");
        int day = Integer.parseInt(date[0]);
        return day;
    }
    /**
     * Gets the total.
     *
     * @return     The total of int type.
     */
    public int getTotal() {
        return total;
    }
    /**
     * Gets the reservation.
     *
     * @return     The reservation of String type.
     */
    public String getReservation() {
        return reservation;
    }

    /**
     * returns the string containing students name, total, reservation.
     *
     * @return     String.
     */

    public String toString() {
        return this.name + "," + this.total + "," + this.reservation;
    }

    /**
     * comparator method to compare the marks, total, dob.
     */

private static Comparator<Student> meritComparator =
new Comparator<Student>() {
        public int compare(final Student s1, final Student s2) {
            if (s1.total - s2.total != 0) {
                return s1.total - s2.total;
            } else if (s1.marks3 - s2.marks3 != 0) {
                return s1.marks3 - s2.marks3;
            } else if (s1.marks2 - s2.marks2 != 0) {
                return s1.marks2 - s2.marks2;
            } else if (s1.getYear() - s2.getYear() != 0) {
                return s1.getYear() - s2.getYear();
            } else if (s1.getMonth() - s2.getMonth() != 0) {
                return s1.getMonth() - s2.getMonth();
            }
                return s1.getDay() - s2.getDay();
        }
    };
/**
 * getter method.
 *
 * @return     { returns comparator }
 */
    static Comparator<Student> meritComparator() {
        return meritComparator;
    }

// static Comparator<Student> totalComparator = new Comparator<Student>(){
    //  public int compare(Student b1, Student b2) {
    //      return b1.total - b2.total;
    //  }
    // };
}
