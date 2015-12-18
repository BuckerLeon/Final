package ch.makery.address.model;

import base.RateDAL;
import domain.RateDomainModel;

import java.time.LocalDate;

import org.apache.poi.ss.formula.functions.FinanceLib;

public class Rate extends RateDomainModel {
	
	public Rate() {
        this((Integer)null, (Integer)null, (Integer)null, (Integer) null,);
    }

    public Rate(int Income, int Expenses, int CreditScore, int HouseCost) {
        this.setIncome(Income);
        this.setExpenses(Expenses);

        // Some initial dummy data, just for convenient testing.
        this.setCreditScore(CreditScore);
        this.setHouseCost(HouseCost);
    }
	
	
	public double getPayment(int NumberOfPayments)
	{
		//FinalExam
		//	Normally this kind of method would be in a BLL, but alas...
		
		//	Figure out payment based on:
		//	Interest rate
		//	PV
		//	FV (make FV = 0, unless you want a balloon payment
		//	Compounding = True
		//	Number of Payments (passed in)
		
		double r;
		double n;
		double p;
		double f;
		double y;
		boolean t;
		
		double pv;
		r = RateDAL.getRate(getMinCreditScore());
		n = NumberOfPayments;
		y = 0;
		f = 0;
		t = false;
		
		pv = FinanceLib.pv(r, y, f, n, t);
		
		double PMT;
		n = NumberOfPayments;
		f = pv;
		p = 0;
		t = false;
		r = RateDAL.getRate(getMinCreditScore());
		
		PMT = FinanceLib.pmt(r,n,p,f,t);
		
		
		
		return PMT;
	}
}
