package com.wns.service;

import com.wns.model.CurrencyNotes;


public interface AtmTranscationService {

	void addCash(CurrencyNotes currencyNotes);

	CurrencyNotes getCashDetails();

	

}
