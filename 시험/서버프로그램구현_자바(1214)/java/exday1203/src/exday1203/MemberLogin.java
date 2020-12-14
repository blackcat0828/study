package exday1203;

public class MemberLogin {
		String id, password;
		public MemberLogin(String id, String password) {
			this.id = id;
			this.password = password;
			
		}
		
		public void login() {
			if(id.equals("fintech")&&password.equals("fintech1234")) {
					System.out.println("fintech 정상적으로 로그인 되었습니다.");
					logout();
			}else {
				System.out.println("아이디 또는 비밀번호 오류");
			}
		}
		
		private void logout() {
			System.out.println("fintech 정상적으로 로그아웃 되었습니다.");
		}
}
