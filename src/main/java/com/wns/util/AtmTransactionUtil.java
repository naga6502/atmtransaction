package com.wns.util;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import com.wns.model.CurrencyNotes;

public class AtmTransactionUtil {

	Map<Integer,Integer> cashMap = new HashMap<>();
	public void addCash(CurrencyNotes currencyNotes) {
		cashMap.put(20, currencyNotes.getTwentys());
		cashMap.put(50, currencyNotes.getFiftys());
	}
	public CurrencyNotes getCashDetails() {
		CurrencyNotes currencyNotes = new CurrencyNotes();
		if(cashMap!=null && !cashMap.isEmpty()) {
			currencyNotes.setFiftys(cashMap.get(50)==null?0:cashMap.get(50));
			currencyNotes.setTwentys(cashMap.get(20)==null?0:cashMap.get(20));
			int totalAmount = 50*cashMap.get(50)+20*cashMap.get(20);
			currencyNotes.setTotalAmount(totalAmount);
		}
		return currencyNotes;
	}
	
}
