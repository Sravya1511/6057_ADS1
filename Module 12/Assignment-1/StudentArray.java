/**
 * Class for student array.
 */
class StudentArray {
	Student[] studentArray;
	int size;

    /**
     * Constructs the object.
     *
     * @param      n     { int n - size of student array }
     */
	StudentArray(int n) {
		studentArray = new Student[n];
		size = 0;
	}
    /**
     * Adds a student.
     * The time complexity is O(1).
     *
     * @param      student  The student of type student
     */
	public void addStudent(Student student) {
		studentArray[size++] = student;
	}
	/**
	 * Gets the array.
	 * The time complexity is O(N).
	 *
	 * @return     The array of student type.
	 */

	public Student[] getArray(){
		return studentArray;
	}
	/**
	 * Gets the reservation array.
	 * The time complexity is O(N).
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

	public Student[] getReservationArray(final int vacancies, final Student[] meritArray,
		final int openVacancies, final int bcVacancies, final int scVacancies,
		final int stVacancies) {
		Student[] res;
		int x = 0;
		int y = 0;
		int z = 0;
		res = new Student[30];
		int count = 0;
		for (int i = 0; i < meritArray.length; i++) {
			if (meritArray[i].getReservation().equals("ST")) {
				 x++;
			}
            if (meritArray[i].getReservation().equals("SC")) {
            	y++;
            }
            if (meritArray[i].getReservation().equals("Bc")) {
            	z++;
            }

		}
		for (int i = 0; i < openVacancies; i++) {
			res[count++] = meritArray[i];
		}
        int a = 0;
        int b = 0;
        int c = 0;
		for (int i = openVacancies; i < meritArray.length; i++) {
			if (meritArray[i].getReservation().equals("ST") && a!=stVacancies) {
                res[count++] = meritArray[i];
                a++;
			} else if (meritArray[i].getReservation().equals("SC") && b != scVacancies) {
                res[count++] = meritArray[i];
                b++;
			} else if (meritArray[i].getReservation().equals("BC") && c != bcVacancies) {
                res[count++] = meritArray[i];
                c++;
			} else if (x < stVacancies) {
				res[count++] = meritArray[i];
			} else if (y < scVacancies) {
				res[count++] = meritArray[i];
			} else if (z < bcVacancies) {
				res[count++] = meritArray[i];
			}
		}
		return res;
	}
}
