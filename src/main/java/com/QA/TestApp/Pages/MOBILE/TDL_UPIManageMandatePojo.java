package com.QA.TestApp.Pages.MOBILE;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties
public class TDL_UPIManageMandatePojo {
	 private String subMerchantId;

	    private String merchantId;

	    private String response;

	    private String success;

	    private String terminalId;

	    private String message;

	    private String merchantTranId;
	    
	    private String BankRRN;

	    public String getSubMerchantId ()
	    {
	        return subMerchantId;
	    }

	    public void setSubMerchantId (String subMerchantId)
	    {
	        this.subMerchantId = subMerchantId;
	    }

	    public String getMerchantId ()
	    {
	        return merchantId;
	    }

	    public void setMerchantId (String merchantId)
	    {
	        this.merchantId = merchantId;
	    }

	    public String getResponse ()
	    {
	        return response;
	    }

	    public void setResponse (String response)
	    {
	        this.response = response;
	    }

	    public String getSuccess ()
	    {
	        return success;
	    }

	    public void setSuccess (String success)
	    {
	        this.success = success;
	    }

	    public String getTerminalId ()
	    {
	        return terminalId;
	    }

	    public void setTerminalId (String terminalId)
	    {
	        this.terminalId = terminalId;
	    }

	    public String getMessage ()
	    {
	        return message;
	    }

	    public void setMessage (String message)
	    {
	        this.message = message;
	    }

	    public String getMerchantTranId ()
	    {
	        return merchantTranId;
	    }

	    public void setMerchantTranId (String merchantTranId)
	    {
	        this.merchantTranId = merchantTranId;
	    }

	    @Override
	    public String toString()
	    {
	        return "ClassPojo [subMerchantId = "+subMerchantId+", merchantId = "+merchantId+", response = "+response+", success = "+success+", terminalId = "+terminalId+", message = "+message+", merchantTranId = "+merchantTranId+"]";
	    }

		public String getBankRRN() {
			return BankRRN;
		}

		public void setBankRRN(String bankRRN) {
			BankRRN = bankRRN;
		}


}
