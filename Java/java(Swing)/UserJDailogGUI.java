package swing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
 
public class UserJDailogGUI extends JDialog implements ActionListener{

	private static final long serialVersionUID = 1L;
	
	//GridLayout(x,y) : 지정된 행,열 을 가지는 레이아웃 생성
	JPanel pw = new JPanel(new GridLayout(4,1));//서쪽판넬
    JPanel pc = new JPanel(new GridLayout(4,1));//중앙판넬
    JPanel ps = new JPanel();//남쪽판넬

    //입력화면 타이틀 지정
    JLabel titleId = new JLabel("회원번호");
    JLabel titleName = new JLabel("이름");
    JLabel titleAge = new JLabel("나이");
    JLabel titleAddr = new JLabel("주소");

    //한줄 입력창 지정 
    JTextField id = new JTextField();
    JTextField name = new JTextField();
    JTextField age = new JTextField();
    JTextField addr = new JTextField();

    JButton confirm;
    JButton reset = new JButton("취소");
    JButton remove = new JButton("삭제");
 
    MenuJTabaleExam me;
 
//    BorderLayout은 컨테이너를 North, South, East, West, Center 
//    모두 5개의 영역으로 나누고, 각 영역에 하나의 컴포넌트만을 배치할 수 있도록 한다. 
//    그래서 한 영역에 여러 개의 컴포넌트를 배치하면, 마지막에 추가한 컴포넌트만 보이게 된다.
//
//     한 영역에 하나 이상의 컴포넌트를 넣기 위해 Panel을 이용해야 한다. 
//     Panel에 원하는 컴포넌트들을 넣은 다음, BorderLayout의 한 영역에 다시 이 Panel을 넣으면 된다.
//
//    BorderLayout은 컨테이너인 Window, Frame, Dialog의 기본 Layout이다. 
//       즉, 이 컨테이너들의 레이아웃 매너저는 따로 설정하지 않아도 생성되어질 때부터 이미 
//    BorderLayout으로 설정되어 있다는 것이다.
    
    
    JPanel idCkP = new JPanel(new BorderLayout());
    
    JButton idCkBtn = new JButton("IDCheck");//id 중복 체크
   
    UserDefaultJTableDAO dao = new UserDefaultJTableDAO();
   
    public UserJDailogGUI(MenuJTabaleExam me, String index){
        super(me,"다이어로그");
        this.me = me;
       
        //폰트지정
        Font font = new Font("맑은고딕", Font.BOLD, 20);
        Font font2 = new Font("맑은고딕",Font.PLAIN, 18);
        
        //입력화면 타이틀 글자폰트및 색상 지정
        titleId.setFont(font);
        titleId.setForeground(Color.blue);
        titleName.setFont(font);
        titleName.setForeground(Color.blue);
        titleAge.setFont(font);
        titleAge.setForeground(Color.blue);
        titleAddr.setFont(font);
        titleAddr.setForeground(Color.blue);
        
        //입력화면 입력창 글자폰트및 색상 지정
        id.setFont(font2);
        id.setBackground(Color.yellow);
        name.setFont(font2);
        name.setBackground(Color.yellow);
        age.setFont(font2);
        age.setBackground(Color.yellow);
        addr.setFont(font2);
        addr.setBackground(Color.yellow);
        
        if(index.equals("가입")){
            confirm=new JButton(index);
        }else{
            confirm=new JButton("수정"); 

            //text박스에 선택된 레코드의 정보 넣기
            int row = me.jt.getSelectedRow();//선택된 행
            
            //클릭한 행의 정보를 가져온다.
            id.setText(me.jt.getValueAt(row,0).toString());//첫번째 컬럼값
            name.setText(me.jt.getValueAt(row,1).toString());//두번째 컬럼값
            age.setText(me.jt.getValueAt(row,2).toString());//세번쨰 컬럼값
            addr.setText(me.jt.getValueAt(row,3).toString());//네번째 컬럼값
           
            //id text박스 비활성
            id.setEditable(false);
   
            //IDCheck버튼 비활성화
            idCkBtn.setEnabled(false);
        }
       
        confirm.setFont(font2);//확인
        remove.setFont(font2);//삭제
        reset.setFont(font2);//취소    
        
        pw.add(titleId);
        pw.add(titleName);
        pw.add(titleAge);
        pw.add(titleAddr);
       
        idCkP.add(id,"Center");
        idCkP.add(idCkBtn,"East");
       
        //TextField 추가
        pc.add(idCkP);
        pc.add(name);
        pc.add(age);
        pc.add(addr);
      
        ps.add(confirm);//수정버튼
        ps.add(remove);//삭제버튼
        ps.add(reset);//취소버튼
   
        add(pw,"West");
        add(pc,"Center");
        add(ps,"South");
       
        setSize(500,350);
        setVisible(true);
 
        //JFrame으로 창을 띄웠다가 우측 상단에 X표를
        //누르면 창은 닫히지만 실제로 JVM에는 낭아 있다.
        //작업관리자에서 동작중인 프로세스를 보면 아직
        //가동중인 프로세스를 발견할 수 있다.
        
        //등록되어 있는 임의의 윈도우 리스너 오브젝트를 호출한 후에
        //자동적으로 프레임을 숨겨 파기한다.
        //setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        confirm.addActionListener(this); //가입/수정 이벤트등록
        remove.addActionListener(this); //삭제
        reset.addActionListener(this); //취소 이벤트등록
        idCkBtn.addActionListener(this);// ID중복체크 이벤트 등록
       
    }
   
    /**
     * 가입/수정/삭제 기능에 대한 부분
     * */
    @Override
    public void actionPerformed(ActionEvent e) {
       
    	String btnLabel = e.getActionCommand();//이벤트주체 대한 Label 가져오기
       
       if(btnLabel.equals("가입")){
           if(dao.userListInsert(this) > 0 ){
               messageBox(this , name.getText()+"님 가입축드립니다.");
               //원하는 하나의 Frame만 종료 시키기 위해서는 dispose() 메소드를 사용
               dispose();//JDialog 창닫기
               //모든레코드가져와서 DefaultTableModel에 올리기
               dao.userSelectAll(me.dt);
               
               if(me.dt.getRowCount() > 0)
                   me.jt.setRowSelectionInterval(0, 0);//첫번째 행 선택
           }else{//가입실패
               messageBox(this,"가입되지 않았습니다.");
           }
           
       }else if(btnLabel.equals("수정")){
           
            if( dao.userUpdate(this) > 0){
                messageBox(this, "수정완료되었습니다.");
                //dispose() 메소드는 프로그램을 종료하는 것이 아니라, 현재의 frame만 종료시킵니다.
                dispose();
                dao.userSelectAll(me.dt);
                if(me.dt.getRowCount() > 0 ) me.jt.setRowSelectionInterval(0, 0);
               
            }else{
                messageBox(this, "수정되지 않았습니다.");
            }

       }else if(btnLabel.equals("삭제")){
           
    	   int row = me.jt.getSelectedRow();
           Object obj = me.jt.getValueAt(row, 0);// 행 열에 해당하는 value
           
           if( dao.userDelete(obj.toString()) > 0){
               messageBox(this, "삭제완료되었습니다.");
               dispose();
               dao.userSelectAll(me.dt);
               if(me.dt.getRowCount() > 0 ) {
            	   //Selects the rows from index0 to index1,inclusive
            	   //첫행지정
            	   me.jt.setRowSelectionInterval(0, 0);
               }
            	   
              
           }else{
               messageBox(this, "수정되지 않았습니다.");
           }

      }
       else if(btnLabel.equals("취소")){
           dispose();
           
       }else if(btnLabel.equals("IDCheck")){
           //id텍스트박스에 값 없으면 메세지 출력 있으면 DB연동한다.
           if(id.getText().trim().equals("")){
               messageBox(this,"ID를 입력해주세요.");
               id.requestFocus();//포커스이동
           }else{
               
              if(dao.getIdByCheck(id.getText())){
                  messageBox(this, id.getText()+"는 사용가능합니다.");  
              }else{ //중복이다.
                  messageBox(this,id.getText()+"는 중복입니다.");
                 
                  id.setText("");//text박스지우기
                  id.requestFocus();//커서놓기
              }
               
           }
           
       }

    }
   
    //메시지 박스 구현
    public static void messageBox(Object obj , String message){
        JOptionPane.showMessageDialog( (Component)obj , message);
    }
 
}