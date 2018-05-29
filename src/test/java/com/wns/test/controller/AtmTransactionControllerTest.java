package com.wns.test.controller;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mockitoSession;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.springframework.http.ResponseEntity;

import com.wns.controller.AtmTransactionController;
import com.wns.model.CurrencyNotes;
import com.wns.service.AtmTranscationService;
import com.wns.serviceimpl.AtmTransactionServiceImpl;



@RunWith(PowerMockRunner.class)
@PrepareForTest
public class AtmTransactionControllerTest {
	
	@Mock
	private AtmTranscationService service;
	private AtmTransactionController controller;
	CurrencyNotes  currencyNotes = new CurrencyNotes();
	
	@Before
	public void setUp() {
		 MockitoAnnotations.initMocks(this);
		controller=new AtmTransactionController();
		service=Mockito.mock(AtmTranscationService.class);
		controller.setAtmTranscationService(service);
		currencyNotes.setFiftys(50);
		currencyNotes.setTwentys(20);
		currencyNotes.setTotalAmount(2900);
		
	}
	
	@After
	public void cleanUp(){
		controller = null;
		service = null;
	}
	
	@PrepareForTest
	@Test
	public void addCashIfTest(){
		CurrencyNotes currencyNotes = new CurrencyNotes();
		currencyNotes.setFiftys(50);
		currencyNotes.setTwentys(20);
		doNothing().when(service).addCash(currencyNotes);
		assertNotNull(controller.addCash("50", "20"));
	}
	

	@PrepareForTest
	@Test
	public void addCashElseTest(){
		CurrencyNotes currencyNotes = new CurrencyNotes();
		currencyNotes.setFiftys(50);
		currencyNotes.setTwentys(20);
		doNothing().when(service).addCash(currencyNotes);
		assertNotNull(controller.addCash(null, null));
	}
	

	@PrepareForTest
	@Test
	public void getCashDetailsTest(){
		assertNotNull(controller.getCashDetails());
	}
	
	@PrepareForTest
	@Test
	public void withDrawAmount(){
		PowerMockito.when(service.getCashDetails()).thenReturn(currencyNotes);
		assertNotNull(controller.withDrawAmount("1000"));
	}
	@PrepareForTest
	@Test
	public void withDrawAmountLessThan50(){
		PowerMockito.when(service.getCashDetails()).thenReturn(currencyNotes);
		assertNotNull(controller.withDrawAmount("40"));
		
		PowerMockito.when(service.getCashDetails()).thenReturn(currencyNotes);
		assertNotNull(controller.withDrawAmount("10"));
		
		
	}
	
	@PrepareForTest
	@Test
	public void withDrawAmountForNullAndElseCoverage() {
		controller.withDrawAmount(null);
		
		PowerMockito.when(service.getCashDetails()).thenReturn(currencyNotes);
		controller.withDrawAmount("80");
		
		PowerMockito.when(service.getCashDetails()).thenReturn(currencyNotes);
		controller.withDrawAmount("3000");
		
	}
}
