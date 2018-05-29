package com.wns.test.util;

import java.util.HashMap;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import com.wns.model.CurrencyNotes;
import com.wns.model.ResponsePayLoad;
import com.wns.service.AtmTranscationService;
import com.wns.serviceimpl.AtmTransactionServiceImpl;
import com.wns.util.AtmTransactionUtil;

@RunWith(PowerMockRunner.class)
@PrepareForTest
public class AtmTransactionUtilTest {

	AtmTransactionUtil atmTransactionUtil = new AtmTransactionUtil();
	CurrencyNotes  currencyNotes = new CurrencyNotes();
	
	
	@Before
	public void setUp() {
		 MockitoAnnotations.initMocks(this);
		currencyNotes.setFiftys(50);
		currencyNotes.setTwentys(20);
		currencyNotes.setTotalAmount(2900);
		
	}
	
	@After
	public void cleanUp(){
		atmTransactionUtil = null;
	}
	
	@Test
	public void addCashTest() {
		atmTransactionUtil.addCash(currencyNotes);
	}
	
	@Test
	public void getCashDetailsTest() {
		atmTransactionUtil.getCashDetails();
	}
	
	@Test
	public void ResponsePayloadTest() {
		ResponsePayLoad responsePayLoad = new ResponsePayLoad();
		responsePayLoad.setData(null);
		responsePayLoad.setErrorMessage("error");
		responsePayLoad.setStatus(false);
		responsePayLoad.prepareResponsePayLoad(null);
		responsePayLoad.getData();
		responsePayLoad.getStatus();
		responsePayLoad.getErrorMessage();
	}
}
