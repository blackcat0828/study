package exday1203;

public class Member {
		private String id;
		private String password;
		private String name;
		
		public Member() {
			
		}

		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}
		
		public void memberInfo() {
			System.out.println("ID : "+id+" Password : " + password + " name : " + name );
		}

}
