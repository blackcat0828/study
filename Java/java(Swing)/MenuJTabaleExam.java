package swing;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
 
 public class MenuJTabaleExam extends JFrame implements ActionListener,MouseListener {
	private static final long serialVersionUID = 1L;

	//대메뉴
	JMenu m = new JMenu("회원관리");
    
    JMenuItem insert = new JMenuItem("가입");
    JMenuItem update = new JMenuItem("수정");
    JMenuItem delete = new JMenuItem("삭제");
    JMenuItem quit   = new JMenuItem("종료");
    
    //여러 개의 메뉴를 붙이는 Bar, 프레임에 부착
    JMenuBar mb = new JMenuBar();
    
    JMenu m1 = new JMenu("종료");
    
    //타이틀을 스트링 배열에 대입
    String[] name = { "회원번호", "이름", "나이", "주소" };
 
    DefaultTableModel dt = new DefaultTableModel(name, 0);
    //테이블 생성
    JTable jt = new JTable(dt);

    //컴포넌트에 스크롤 기능을 제공한다. 화면보다 더 큰 컴포넌트를 표시하기 위해서는 스크롤 기능이 필요하다.
    JScrollPane jsp = new JScrollPane(jt);
    JPanel p = new JPanel();
    //검색기능 배열
    String[] comboName = { "  ALL  ", "  ID  ", " name ", " addr " };
 
    //리스트처럼 여러 항목 중에서 하나를 선택하는데 사용할 수 있다.
    //텍스트필드와 버튼, 드롭다운 리스트로 구성되는 콤보박스
    //드롭다운 리스트에서 선택한 것이 텍스트필드에 나타남
    JComboBox combo = new JComboBox(comboName);
    
    //입력창
    JTextField jtf = new JTextField(20);
    JButton search = new JButton("검색");
 
    UserDefaultJTableDAO dao = new UserDefaultJTableDAO();
 
    //화면구성 및 이벤트등록
    public MenuJTabaleExam() {
       
        super("회원관리프로그램 - DB연동");
 
        //리스트 선택을 한개만 하겠다
        //컬럼들 이동을 방지하기 위한 선언
        jt.getTableHeader().setReorderingAllowed(false);
        //컬럼들 가로 사이즈 늘리기 못하게 선언
        jt.getTableHeader().setResizingAllowed(false);
        jt.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        jt.addMouseListener(this);
        jt.setRowHeight(24);//행높이
        jt.setFont(new Font("맑은고딕", Font.BOLD, 16));//폰트
        
        //메뉴아이템을 메뉴에 추가
        m.add(insert);
        m.add(update);
        m.add(delete);
        m.add(quit);
        m.setForeground(Color.blue);
        m.setFont(new Font("맑은고딕", Font.BOLD, 16));
        m1.setFont(new Font("맑은고딕", Font.BOLD, 16));
        
        //메뉴를 메뉴바에 추가
        mb.add(m);
        mb.add(m1);

        //메뉴바의 글자세팅
        mb.setBackground(Color.YELLOW);
        mb.setFont(new Font("맑은고딕", Font.BOLD, 30));
        //윈도우에 메뉴바 세팅
        setJMenuBar(mb);
        //하단영역
        p.setBackground(Color.cyan);
        p.add(combo);
        p.add(jtf);
        p.add(search);
 
        add(jsp, "Center");
        add(p, "South");
 
        setSize(800,600);
        setVisible(true);
        
        //윈도우창을 닫으면 프로세스까지 완전종료
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
        // 이벤트등록
        insert.addActionListener(this);
        update.addActionListener(this);
        delete.addActionListener(this);
        quit.addActionListener(this);
        search.addActionListener(this);
        m1.addActionListener(this);
 
        // 모든레코드를 검색하여 DefaultTableModle에 올리기
        dao.userSelectAll(dt);
       
        //첫번행 선택.
        if (dt.getRowCount() > 0)
            jt.setRowSelectionInterval(0, 0);
    } //MenuJTabaleExam 종료
    
    public void mouseClicked(MouseEvent me) {
    	//int row = jt.getSelectedRow();
    	//System.out.println(row + "행 클릭!!!");
    	new UserJDailogGUI(this, "수정");
    }
 
    public static void main(String[] args) {
        new MenuJTabaleExam();
    }

     //가입,수정,삭제,검색기능을 담당하는 메소드
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == insert) {// 가입 메뉴아이템 클릭
            new UserJDailogGUI(this, "가입");
        }else if (e.getSource() == update) {// 수정 메뉴아이템 클릭
            new UserJDailogGUI(this, "수정");
        }else if (e.getSource() == delete) {// 삭제 메뉴아이템 클릭
            int row = jt.getSelectedRow();
            Object obj = jt.getValueAt(row, 0);// 행 열에 해당하는 value
 
            if (dao.userDelete(obj.toString()) > 0) {
                UserJDailogGUI.messageBox(this, "레코드 삭제되었습니다.");
                //리스트 갱신
                dao.userSelectAll(dt);
                if (dt.getRowCount() > 0)
                    jt.setRowSelectionInterval(0, 0);
            } else {
                UserJDailogGUI.messageBox(this, "데이터가 삭제되지 않았습니다.");
            }
 
        } else if (e.getSource() == quit) {// 종료 메뉴아이템 클릭
            System.exit(0);
        } else if (e.getSource() == m1) {// 종료 메뉴아이템 클릭
            System.exit(0);
        } else if (e.getSource() == search) {// 검색 버튼 클릭
            String fieldName = combo.getSelectedItem().toString();
 
            if (fieldName.trim().equals("ALL")) {// 전체검색
                dao.userSelectAll(dt);
                if (dt.getRowCount() > 0)
                    jt.setRowSelectionInterval(0, 0);
            } else {
                if (jtf.getText().trim().equals("")) {
                    UserJDailogGUI.messageBox(this, "검색단어를 입력해주세요!");
                    jtf.requestFocus();
                } else {// 검색어를 입력했을경우
                    dao.getUserSearch(dt, fieldName, jtf.getText());
                    if (dt.getRowCount() > 0)
                        jt.setRowSelectionInterval(0, 0);
                }
            }
        }
 
    }

//mouseClicked(MouseEvent e) : 마우스를 클릭했을 때 호출
//mouseEntered(MouseEvent e) : 마우스 커서가 컴포넌트 영역에 들어오면 호출
//mouseExited(MouseEvent e) : 마우스 커서가 컴포넌트 영역에서 벗어나면 호출
//mousePressed(MouseEvent e) : 마우스 버튼이 눌러지면 호출
//mouseReleased(MouseEvent e) : 마우스 버튼이 눌러졌다 띄어지면 호출    
    
	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}


 
}