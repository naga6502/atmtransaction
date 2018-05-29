package com.wns.serviceimpl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import com.wns.model.CurrencyNotes;
import com.wns.service.AtmTranscationService;
import com.wns.util.AtmTransactionUtil;


@Service
public class AtmTransactionServiceImpl implements AtmTranscationService{

	private static final Logger logger = LogManager.getLogger(AtmTransactionServiceImpl.class.getName());
	AtmTransactionUtil atmTransactionUtil =  new AtmTransactionUtil();
	
	/**
	 * add cash in service
	 */
	@Override
	public void addCash(CurrencyNotes currencyNotes) {
		logger.info("addCash() method");
		atmTransactionUtil.addCash(currencyNotes);
	}
	
	/**
	 * get cash details in service
	 */
	@Override
	public CurrencyNotes getCashDetails() {
		logger.info("getCashDetails() method");
		return atmTransactionUtil.getCashDetails();
	}
	

}
