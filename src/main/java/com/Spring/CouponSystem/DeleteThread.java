//package com.Spring.CouponSystem;
//
//import java.sql.Timestamp;
//import java.util.List;
//
//import org.hibernate.Session;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.scheduling.annotation.Scheduled;
//
//public class DeleteThread {
//
//	   @Scheduled(cron = "0 4 4 * * ?")
//	    public void deleteCouponAutomatically() {
//	        if(schedulerActive.equals("true")) {
//	            Session session = this.sessionFactory.getCurrentSession();
//	            long now = System.currentTimeMillis();
//	            long nowMinus1Week = now - (1000 * 60 * 60 * 24 * 7);
//	            Timestamp nowMinus1WeekAsTimeStamp = new Timestamp(nowMinus1Week);
//	            Query query = (Query) session.createQuery("from Coupon as c where c.startDate <:endDate");
//	            query.setParameter("endDate", nowMinus1WeekAsTimeStamp);
//	            List<ChatMessages> chatMessagesList = query.list();
//	            chatMessagesList.forEach(session::delete);
//	            session.flush();
//	        }
//	    }
//	
//}
