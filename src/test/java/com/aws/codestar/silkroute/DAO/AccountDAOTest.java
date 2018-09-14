package com.aws.codestar.silkroute.DAO;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.aws.codestar.silkroute.models.Account;
import com.aws.codestar.silkroute.models.User;
import com.aws.codestar.silkroute.repositories.AccountRepository;

@ActiveProfiles("test")
@RunWith(SpringRunner.class)
@DataJpaTest
public class AccountDAOTest {

	@Autowired
	private TestEntityManager entityManager;
	
	@Autowired
	private AccountRepository accRepo;
	
	@Test
	public void should_find_no_accounts_if_repo_is_empty() {
		Iterable<Account> accounts = accRepo.findAll();
		assertThat(accounts).isEmpty();
	}
	
	@Test 
	public void should_create_account() {
		Account testAccount = new Account(0, new User("test@gmail.com", "sam", "smith", "password"));
		Account actual = accRepo.save(testAccount);
		assertThat(actual).isEqualTo(testAccount);
	}
	@Test
	public void should_return_account_by_id() {
		Account testAccount = new Account(0, new User("test@gmail.com", "sam", "smith", "password"));
		entityManager.persist(testAccount);
		
		Account actual = accRepo.findOne(testAccount.getAccountId());
		assertThat(actual).isEqualTo(testAccount);
		
	}
	
	@Test
	public void should_deposit_to_account_balance() {
		Account testAccount = new Account(0, new User("test@gmail.com", "sam", "smith", "password"));
		entityManager.persist(testAccount);
		Account account = accRepo.findOne(testAccount.getAccountId());
		account.deposit(50);
		account = accRepo.save(account);
		assertThat(account.getBalance()).isEqualTo( 50);
	
	
	}
	
	@Test
	public void should_withdraw_from_account_balance() {
		Account testAccount = new Account(100 , new User("test@gmail.com", "sam", "smith", "password"));
		entityManager.persist(testAccount);
		Account account = accRepo.findOne(testAccount.getAccountId());
		account.withdraw(100);
		account = accRepo.save(account);
		assertThat(account.getBalance()).isEqualTo(0);
	}
}
