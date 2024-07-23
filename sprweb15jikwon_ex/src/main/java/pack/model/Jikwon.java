package pack.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "jikwon")
public class Jikwon {
    @Id
    @Column(name = "jikwon_no")
    private int jikwonNo;
    
    @Column(name = "jikwon_name", nullable = false)
    private String jikwonName;

    @Column(name = "jikwon_gen", nullable = false)
    private String jikwonGen;
    
    @Column(name = "jikwon_jik")
    private String jikwonJik;

    @Column(name = "jikwon_pay")
    private int jikwonPay;
}