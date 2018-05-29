package com.wns.test.serviceimpl;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import com.wns.controller.AtmTransactionController;
import com.wns.exception.AtmTransactionException;
import com.wns.model.CurrencyNotes;
import com.wns.service.AtmTranscationService;
import com.wns.serviceimpl.AtmTransactionServiceImpl;
import com.wns.util.AtmTransactionUtil;

@RunWith(PowerMockRunner.class)
@PrepareForTest
public class AtmTransactionServiceImplTest {

	AtmTransactionUtil atmTransactionUtil = new AtmTransactionUtil();
	CurrencyNotes  currencyNotes = new CurrencyNotes();
	private AtmTranscationService service;
	
	@Before
	public void setUp() {
		 MockitoAnnotations.initMocks(this);
		 service=new AtmTransactionServiceImpl();
		service=Mockito.mock(AtmTranscationService.class);
		currencyNotes.setFiftys(50);
		currencyNotes.setTwentys(20);
		currencyNotes.setTotalAmount(2900);
	}
	
	@After
	public void cleanUp(){
		atmTransactionUtil = null;
		service = null;
	}
	
	@PrepareForTest
	@Test
	public void addCash() {
		
		service.addCash(currencyNotes);
	}
	
	@PrepareForTest
	@Test
	public void getCashDetails() {
		
		service.getCashDetails();
	}
	
	
	@PrepareForTest
	@Test
	public void ExceptionCoverage() {
		Exception e = null;
		AtmTransactionException ex = new AtmTransactionException();
		AtmTransactionException ex1 = new AtmTransactionException("error");
		AtmTransactionException ex2 = new AtmTransactionException("error",e);
	}
}
