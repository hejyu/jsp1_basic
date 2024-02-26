package day4.mybatis.dto;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter					
@AllArgsConstructor				// 커스텀생성자 : 컬럼명과 변수명 일치 안해도 된다.
								// 변수 선언 순서와 컬럼순서는 일치해야 합니다.
//@NoArgsConstructor				// 기본생성자 : 객체 생성 후 setter로 동작하므로 컬럼명과 변수명 일치해야함
@EqualsAndHashCode
public class ProductDto {

	public String pcode;
    public String category;
    public String pname;
    public int price;
    
    @Override
    public String toString() {
        return String.format("\n%6s %15s %40s\t %,8d", 
                            category,pcode,pname,price);
    }
}
