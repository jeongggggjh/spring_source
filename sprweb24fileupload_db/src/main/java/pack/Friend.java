package pack;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Friend {
	@Id
	// @GeneratedValue(strategy = GenerationType.IDENTITY); // 번호 칼럼이 자동증가 일때
	private int bunho;
	private String irum;
	private String junhwa;
	private String jikup;
	
	@Lob // BLOB, CLOB 타입으로 처리됨
	private byte[] sajin;
	private String imagetype;
	
	@Transient // DB와 관련 없는 임시 데이터 저장용
	private String base64Image; // base64로 인코딩된 이미지 타입
	
}
