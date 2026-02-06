package com.example.kakeibo.domain.valueobject;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.example.kakeibo.domain.exception.InvalidAmountException;

public class AmountTest {
	
	/*
	 * 
	  - 金額がnull null　InvalidAmountException
      - 金額が0 0　InvalidAmountException
      - 金額が1（境界地） 1　正常生成
      - 金額が-1（負の数） -1 InvalidAmountException
      - 金額が正の大きな数 Integer.MAX_VALUE 正常生成 
	 * */
	@Test
	@DisplayName("金額がnullの場合")
    void 金額がnullの場合() {
		Integer input = null;
		
        assertThrows(InvalidAmountException.class,
            () -> new Amount(input));
    }
	
	
	@Test
	@DisplayName("金額が0の場合")
    void 金額が0の場合() {
		int input = 0;
		
        assertThrows(InvalidAmountException.class,
            () -> new Amount(input));
    }
	
	@Test
	@DisplayName("金額が1の場合")
	void 金額が1の場合() {
		int input = 1;
		Amount amount = new Amount(input);
		assertEquals(1, amount.getValue());
	}
	
	@Test
	@DisplayName("金額が-1の場合")
    void 金額が負の場合() {
		int input = -1;
		
        assertThrows(InvalidAmountException.class,
            () -> new Amount(input));
    }
	
	@Test
	@DisplayName("金額が正の大きな数")
	void 金額が正の大きな数() {
		int input = Integer.MAX_VALUE;
		Amount amount = new Amount(input);
		assertEquals(Integer.MAX_VALUE, amount.getValue());
	}
	

}
