package com.aws.codestar.silkroute.DAO;
import com.aws.codestar.silkroute.models.*;
import java.util.List;




/**
 * BillingInfoDAOI is a interface with SQL for accessing the TSR_Billing_Info table. 
 */
public interface BillingInfoDAOI {

    enum SQL {
		GETBILLINGIINFOBYACCOUNTID("SELECT * FROM TSR_ADMIN.TSR_BILLING_INFO WHERE ACC_ID=?"),
    CREATEBILLINGINFO("INSERT INTO TSR_ADMIN.TSR_BILLING_INFO (ACC_ID, BILLING_STATE, BILLING_ZIP) VALUES (?,?,?)"), 
    DELETEBILLINGINFOBYID("DELETE FROM TSR_ADMIN.TSR_BILLING_INFO WHERE BILLING_ID=?");
		
		String query;
		
		SQL(String givenQuery){
			query = givenQuery;
		}
		
		String getQuery() {
			return query;
		}
    }
    

    /**
     * getBillingInfoByAccountId gets a  user's billing info by the account ID
     * @param accountId the user's account id 
     * @return a list of the user's BillingInfo from the table BillingInfo 
     */
    public List<BillingInfo> getBillingInfoByAccountId(long accountId);


    /**
     * createBillingInfo creates a BillingInfo object for transactions 
     * @param accId the user's account id 
     * @param billingState the user's billing state 
     * @param billingZip the user's billing zipcode
     * @return a boolean if the insertion was successfull
     */
    public boolean createBillingInfo(long accId, String billingState, int billingZip);


    /**
     * deleteBillingInfoByID deletes a user's billing info by ID 
     * @param billingId the billing id 
     * @return boolean indicating the removal was successful 
     */

     public boolean deleteBillingInfoById(long billingId);
}