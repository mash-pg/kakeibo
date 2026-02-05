package com.example.kakeibo.domain.strategy;

import java.util.List;


import com.example.kakeibo.domain.entity.Transaction;


public interface SummaryStrategy {
	Object calculate(List<Transaction> transactions,int year,int month);
}
