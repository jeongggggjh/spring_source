package pack.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="jikwon")
public class JikwonDto {
    @Id
    @Column(name = "jikwon_no")
    private String jikwon_no;
    
    @Column(name = "jikwon_name")
    private String jikwon_name;

    @Column(name = "buser_num")
    private String buser_num;

    @Column(name = "jikwon_ibsail")
    private String jikwon_ibsail;
}
