package com.wns.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wns.exception.AtmTransactionException;
import com.wns.model.CurrencyNotes;
import com.wns.model.ResponsePayLoad;
import com.wns.service.AtmTranscationService;
import com.wns.util.AtmTransactionUtil;
import com.wns.util.ResponseCode;

/**
 * @author naga.yenugu
 *
 */
@RestController
@RequestMapping("/")
public class AtmTransactionController {
	
	/*
	 * Logger is used to log all the information for future use. It would be
	 * logged based on the Log4j.properties is configured.
	 */
	private static final Logger logger = LogManager.getLogger(AtmTransactionController.class.getName());
	
	@Autowired
	AtmTranscationService atmTranscationService;
	AtmTransactionUtil atmTransactionUtil = new AtmTransactionUtil();
	CurrencyNotes  currencyNotes = new CurrencyNotes();
	
	/**
	 * 
	 * @param fifty
	 * @param twenty
	 * @return
	 * add cash method
	 * 
	 */
	@RequestMapping(value="/addcash",method=RequestMethod.POST)
	public ResponseEntity<ResponsePayLoad> addCash(@RequestParam("fifty") String fifty,@RequestParam("twenty") String twenty){
		logger.info("addcash method");
		if(fifty!=null && twenty!=null){
			int fiftys = Integer.parseInt(fifty);
			int twentys = Integer.parseInt(twenty);
			currencyNotes.setFiftys(fiftys);
			currencyNotes.setTwentys(twentys);
			atmTranscationService.addCash(currencyNotes);
		    return new ResponseEntity<>(ResponsePayLoad.prepareResponsePayLoad(ResponseCode.SUCCESS_IN_ADDING_CASH), HttpStatus.OK);
		
		}else{
		    return new ResponseEntity<>(
		            ResponsePayLoad.prepareErrorPayLoad(ResponseCode.FAILED_TO_Add_Cash),
		            HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		
	}
	
	/**
	 * 
	 * getting cash details from this method
	 */
	@RequestMapping("/getcashdetails")
	public ResponseEntity<ResponsePayLoad> getCashDetails() {
		logger.info("getCashDetails method");
		currencyNotes=atmTranscationService.getCashDetails();
		 return new ResponseEntity<>(ResponsePayLoad.prepareResponsePayLoad(currencyNotes), HttpStatus.OK);		
	}
	
	/**
	 * 
	 * @param amount
	 * @return
	 * withdrawmoney method
	 */
	
	@RequestMapping("/withdrawamount")
	public ResponseEntity<ResponsePayLoad>  withDrawAmount(@RequestParam("amount") String amount) {
		logger.info("withdrawamount mehtod");
		int noOfTwentys=0;
		int noOfFiftys=0;
		if(amount !=null){
			int withdrawMoney = Integer.parseInt(amount);
			currencyNotes=atmTranscationService.getCashDetails();
			
			if(withdrawMoney < currencyNotes.getTotalAmount()) {
				if(withdrawMoney <  50)
			      {
			    	  if(withdrawMoney % 20 == 0) {
			    		  noOfTwentys = withdrawMoney / 20;
			    		  logger.info(withdrawMoney/20+" $20");
			    		  updateNotesCount(noOfFiftys,noOfTwentys);
			    		  return new ResponseEntity<>(ResponsePayLoad.prepareResponsePayLoad("twentys = "+noOfTwentys+"fiftys = "+noOfFiftys), HttpStatus.OK);		
			    	  }else {
			    		  return new ResponseEntity<>(ResponsePayLoad.prepareResponsePayLoad(ResponseCode.WRONG_AOMOUT_ENTER), HttpStatus.NOT_FOUND);		
			    	  }
			      }
			      else
			      {
			    	noOfFiftys = withdrawMoney / 50;
			    	withdrawMoney = withdrawMoney % 50;
			        if(withdrawMoney % 20 == 0) {
			        	noOfTwentys = withdrawMoney /20;
			        	updateNotesCount(noOfFiftys,noOfTwentys);
			        	return new ResponseEntity<>(ResponsePayLoad.prepareResponsePayLoad("twentys = "+noOfTwentys+"fiftys = "+noOfFiftys), HttpStatus.OK);
			        }else {
			        	return new ResponseEntity<>(ResponsePayLoad.prepareResponsePayLoad(ResponseCode.WRONG_AOMOUT_ENTER), HttpStatus.NOT_FOUND);		
			        }
			      }
			}else {
				return new ResponseEntity<>(ResponsePayLoad.prepareResponsePayLoad(ResponseCode.INSUFFICIENT_AMOUNT), HttpStatus.NOT_ACCEPTABLE);	
			}
			}
		return new ResponseEntity<>(ResponsePayLoad.prepareResponsePayLoad("twentys = "+noOfTwentys+"fiftys = "+noOfFiftys), HttpStatus.OK);
		
	}
	
	/**
	 * 
	 * @param noOfFiftys
	 * @param noOfTwentys
	 * updating amount in atm
	 */
	
	private void updateNotesCount(int noOfFiftys, int noOfTwentys) {
		currencyNotes = atmTranscationService.getCashDetails();
		int updateFiftyCount = currencyNotes.getFiftys()-noOfFiftys;
		int updateTwnentyCount = currencyNotes.getTwentys() -  noOfTwentys;
		currencyNotes.setFiftys(updateFiftyCount);
		currencyNotes.setTwentys(updateTwnentyCount);
		atmTranscationService.addCash(currencyNotes);
		
	}

	public void setAtmTranscationService(AtmTranscationService service) {
		this.atmTranscationService = service;
		
	}
	
}
