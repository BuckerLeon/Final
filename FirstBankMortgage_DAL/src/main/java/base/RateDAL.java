package base;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import domain.RateDomainModel;
import domain.StudentDomainModel;
import util.HibernateUtil;

public class RateDAL {
	
	public static RateDomainModel addRate(RateDomainModel rate) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		int employeeID = 0;
		try {
			tx = session.beginTransaction();
			session.save(rate);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return rate;
	}
	
	public static RateDomainModel getRateID(UUID rateID) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		RateDomainModel rateGet = null;		
		
		try {
			tx = session.beginTransaction();	
									
			Query query = session.createQuery("from RateDomainModel where studentId = :id ");
			query.setParameter("id", rateID.toString());
			
			List<?> list = query.list();
			rateGet = (RateDomainModel)list.get(0);
			
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return rateGet;
	}	
	
	public static RateDomainModel updateRate(RateDomainModel rate) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		RateDomainModel rateGet = null;		
		
		try {
			tx = session.beginTransaction();	
									
			session.update(rate);
	
			
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}

		return rate;
	}		


	public static double getRate(int GivenCreditScore) {
		//FinalExam - please implement		
		// Figure out which row makes sense- return back the 
		// right interest rate from the table based on the given credit score
		//FinalExam - obviously change the return value
		double IR = 0;
		
		if (GivenCreditScore >= 620 && GivenCreditScore <= 639){
			IR = 0.05312;
		}else if (GivenCreditScore >= 640 && GivenCreditScore <= 659){
			IR = 0.04766;
		}else if (GivenCreditScore >= 660 && GivenCreditScore <= 679){
			IR = 0.04336;
		}else if (GivenCreditScore >= 680 && GivenCreditScore <= 699){
			IR = 0.04122;
		}else if (GivenCreditScore >= 700 && GivenCreditScore <= 759){
			IR = 0.03945;
		}else if (GivenCreditScore >= 760 && GivenCreditScore <= 850){
			IR = 0.03732;
		}
		return IR;
	}

}