package com.aws.codestar.silkroute.DAO;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.aws.codestar.silkroute.models.*;
import com.aws.codestar.silkroute.repositories.BillingInfoRepository;


@ActiveProfiles("test")
@RunWith(SpringRunner.class)
@DataJpaTest
public class BIllingInfoDAOTest {

	@Autowired
	private TestEntityManager entityManager;
	
	@Autowired
	private BillingInfoRepository billingRepo;
	
	
	@Test
	public void should_find_no_billing_info_if_repo_is_empty() {
		Iterable<BillingInfo> customers = billingRepo.findAll();

		assertThat(customers).isEmpty();
		
	}
	
	@Test
	public void should_create_billing_info() {
		BillingInfo homeBilling = new BillingInfo("100 Washington Lane", "DC",  77777);
		BillingInfo savedBilling = billingRepo.save(homeBilling);
		assertThat(homeBilling).isEqualTo(savedBilling);
	}
	
	@Test
	public void should_delete_billing_info() {
		BillingInfo homeBilling = new BillingInfo("100 Washington Lane", "DC",  77777);
		entityManager.persist(homeBilling);
		billingRepo.delete(homeBilling);
		assertThat(billingRepo.findOne(homeBilling.getBillingId())).isNull();
	}
	
	@Test
	public void should_find_billing_by_account_id() {
		BillingInfo homeBilling = new BillingInfo("100 Washington Lane", "DC",  77777);
		BillingInfo workBilling = new BillingInfo("200 Washington Lane", "DC",  77777);
		BillingInfo travelBilling = new BillingInfo("300 Washington Lane", "DC",  77777);
		
		Account account = new Account(200, new User("test@gmail.com", "test1", "test1", "password")); 
		homeBilling.setAccount(account);
		travelBilling.setAccount(account);
		workBilling.setAccount(account);
		entityManager.persist(homeBilling);
		entityManager.persist(travelBilling);
		entityManager.persist(workBilling);
		Iterable <BillingInfo> billings = billingRepo.findByAccount(account);
		
		assertThat(billings).hasSize(3);
	}
	
	
	
	
	@Test 
	public void should_find_billing_by_id() {
		BillingInfo homeBilling = new BillingInfo("100 Washington Lane", "DC",  77777);
		entityManager.persist(homeBilling);
		BillingInfo foundBilling = billingRepo.findOne(homeBilling.getBillingId());
		assertThat(homeBilling).isEqualTo(foundBilling);

	}
	
	@Test 
	public void should_update_billing_info() {
		BillingInfo homeBilling = new BillingInfo("100 Washington Lane", "DC",  77777);
		entityManager.persist(homeBilling);
		BillingInfo temp = billingRepo.findOne(homeBilling.getBillingId());
		temp.setBillingAddress("200 Stuard Drive");
		temp.setBillingState("NY");
		temp.setBillingZip(11804);
		temp.setStripeId(20000000);	
		BillingInfo updatedBilling = billingRepo.save(temp);
		assertThat(temp).isEqualTo(updatedBilling);
	}
}
