package study;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class StraemTest {

	public static void main(String[] args) throws Exception {
					writeList(); //List를 파일에 저장
					List<Board> list = readList(); //파일에 저장된 LIST 읽기
					
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
					for(Board board : list) {
						System.out.println(
									board.getBno() + "\t" + board.getTitle() + "\t" +
									board.getContent() + "\t" + board.getWriter() + "\t" + sdf.format(board.getDate())
								);
					}
	}

	public static void writeList() throws Exception {
		List<Board> list = new ArrayList<>();
		
		list.add(new Board(1, "제목1", "내용1", "글쓴이1", new Date()));
		list.add(new Board(2, "제목2", "내용2", "글쓴이2", new Date()));
		list.add(new Board(3, "제목3", "내용3", "글쓴이3", new Date()));
		
		FileOutputStream fos = new FileOutputStream("c:/Temp/board.txt");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(list);
		oos.flush();
		oos.close();
		
	}
	
	public static List<Board> readList() throws Exception {
			FileInputStream fis = new FileInputStream("c:/temp/board.txt");
			ObjectInputStream ois = new ObjectInputStream(fis);
			List<Board> list = (List<Board>) ois.readObject();
			return list;
	}
	
}
