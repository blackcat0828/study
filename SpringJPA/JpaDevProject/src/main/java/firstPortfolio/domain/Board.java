package firstPortfolio.domain;

import java.util.Date;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@NoArgsConstructor
@RequiredArgsConstructor
@Data
public class Board {
	private int boardNo;
	@NonNull
	private String title;
	private String content;
	private String writer;
	private Date regDate;
}
