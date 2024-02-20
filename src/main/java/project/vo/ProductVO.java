package project.vo;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;


// 롬복으로 VO 클래스 작성
@Getter
@AllArgsConstructor
@EqualsAndHashCode
public class ProductVO {
   
    private String pcode;
    private String category;
    private String pname;
    private int price;


    @Override
    public String toString() {
        return String.format("%15s %10s %20s \t %, 8d", category
                                                            ,pcode
                                                            ,pname
                                                            ,price);
    }


    

    

    
    
}
