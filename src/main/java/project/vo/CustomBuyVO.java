package project.vo;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@AllArgsConstructor
@EqualsAndHashCode
public class CustomBuyVO {

  public int buy_idx;
  public String pcode;
  public String pname;
  public int price;
  public int quantity;
  public Timestamp buy_date;
  
  @Override
  public String toString() {
      return String.format("%8d %-15s %40s \t %,6d %4d %30s",
                  buy_idx,pcode,pname,price,quantity,buy_date);
  }

  
   
    
     
}
