package Mlem.com.Common.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Mlem.com.Common.Entity.PayMent;
import Mlem.com.Common.Repository.PayMentRepository;



@Service
public class PaymentService {
	@Autowired
	private  PayMentRepository repo;
	  public void save(PayMent Payment) {
	       repo.save(Payment);
	   }

}