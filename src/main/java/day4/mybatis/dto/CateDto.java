package day4.mybatis.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
public class CateDto {

	private String code;
	private String name;
	
	@Override
    public String toString() {
        return String.format("%6s %15s", 
        		code,name);
    }
}
