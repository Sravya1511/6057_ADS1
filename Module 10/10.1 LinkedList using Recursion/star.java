class star {
	static String m = "";
	public static String star(String a) {
		if(a.length() == 0) {
             return m;
		}

		if(a.substring(0,1).equals(a.substring(1,2))) {
             m += a.substring(0,1)+"*"+a.substring(1,2);

		}
		else {
			m += a.substring(0,1);
			return star(a.substring(1));
		}
        return m+a.substring(a.length()-1);
	}
	public static void main(String[] args) {
		System.out.println(star("hiii"));

	}
}