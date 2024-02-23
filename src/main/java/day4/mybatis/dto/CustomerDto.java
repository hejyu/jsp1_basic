package day4.mybatis.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString						
@AllArgsConstructor				// 커스텀생성자 : 컬럼명과 변수명 일치 안해도 된다.
								// 변수 선언 순서와 컬럼순서는 일치해야 합니다.
//@NoArgsConstructor				// 기본생성자 : 객체 생성 후 setter로 동작하므로 컬럼명과 변수명 일치해야함
@EqualsAndHashCode
public class CustomerDto {

	public String custom_id;
    public String name;
    public String email;
    public int age;
    public Date reg_date;
    
}
