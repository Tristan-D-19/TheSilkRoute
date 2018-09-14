package com.aws.codestar.silkroute.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.aws.codestar.silkroute.models.Account;
import com.aws.codestar.silkroute.models.BillingInfo;

public interface BillingInfoRepository extends CrudRepository<BillingInfo, Long> {

	public List<BillingInfo> findByAccount(Account account);
}
