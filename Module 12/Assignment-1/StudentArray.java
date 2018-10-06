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
