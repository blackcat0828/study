package exday1203;

public class MemberLogin {
		String id, password;
		public MemberLogin(String id, String password) {
			this.id = id;
			this.password = password;
			
		}
		
		public void login() {
			if(id.equals("fintech")&&password.equals("fintech1234")) {
					System.out.println("fintech ���������� �α��� �Ǿ����ϴ�.");
					logout();
			}else {
				System.out.println("���̵� �Ǵ� ��й�ȣ ����");
			}
		}
		
		private void logout() {
			System.out.println("fintech ���������� �α׾ƿ� �Ǿ����ϴ�.");
		}
}
