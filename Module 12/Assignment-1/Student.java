import java.util.Comparator;
/**
 * Class for student.
 * The student class studnet attibutes.
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
	 * marks2 of student
	 */
	private int marks2;
	/**
	 * marks3 of student.
	 */
	private int marks3;
	/**
	 * total marks of student
	 */
	private int total;
	/**
	 * Reservation of student.
	 */
	private String reservation;

    /**
     * Constructs the object.
     *
     * @param      n     { name of type string }
     * @param      dob   The dob of type String
     * @param      m1    The m1 of int type
     * @param      m2    The m2 of int type
     * @param      m3    The m3 of int type
     * @param      t     total marks of int type.
     * @param      res   The reservation od string type.
     */
	Student(String n, String dob, String m1, String m2, String m3, String t, String res) {
		this.name = n;
		this.dateOfBirth = dob;
		this.marks1 = Integer.parseInt(m1);
		this.marks2 = Integer.parseInt(m2);
		this.marks3 = Integer.parseInt(m3);
		this.total = Integer.parseInt(t);
		this.reservation = res;
	}

    public int getMarks1() {
        return marks1;
    }
    public int getMarks2() {
        return marks2;
    }
    public int getMarks3() {
        return marks3;
    }
    public String getName() {
        return name;
    }

    public String getDob() {
        return dateOfBirth;
    }
    public int getTotal() {
        return total;
    }
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

	static Comparator<Student> meritComparator = new Comparator<Student>() {
		public int compare(Student s1, Student s2) {
			if(s1.total - s2.total != 0)
				return s1.total - s2.total;
			else if(s1.marks3 - s2.marks3 != 0)
				return s1.marks3 - s2.marks3;
			else if(s1.marks2 - s2.marks2 != 0)
				return s1.marks2 - s2.marks2;
			else
				return s1.dateOfBirth.compareTo(s2.dateOfBirth);
		}
	};
}
