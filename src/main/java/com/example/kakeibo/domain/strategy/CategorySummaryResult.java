package com.example.kakeibo.domain.strategy;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CategorySummaryResult  implements SummaryResult{
	private List<CategoryTotal> categoryTotals;
	
    @Getter
    @AllArgsConstructor
    public static class CategoryTotal {
        private Long categoryId;
        private int totalAmount;
    }
}
