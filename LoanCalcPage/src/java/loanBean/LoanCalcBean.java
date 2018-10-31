package loanBean;

import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import loancalcpage.LoanService;
import loancalcpage.LoanService_Service;

/**
 *
 * @author Jonathan Anders
 */
@Named(value = "loanCalcBean")
@RequestScoped
public class LoanCalcBean {
    
    private double loanAmount;
    private double annualInterestRate;
    private int numberOfYears;
    private String result;
    
    private LoanService loanServiceProxy;
    
    /**
     * Creates a new instance of LoanCalcBean
     */
    public LoanCalcBean()
    {
        LoanService_Service service = new LoanService_Service();
        loanServiceProxy = service.getLoanServicePort();
    }
    
    public double getLoanAmount() {return loanAmount;}
    public void setLoanAmount(double loan) {this.loanAmount = loan;}
    public double getAnnualInterestRate(){return annualInterestRate;}
    public void setAnnualInterestRate(double rate) {this.annualInterestRate = rate;}
    public int getNumberOfYears() {return numberOfYears;}
    public void setNumberOfYears(int years) {this.numberOfYears = years;}
    public String getResult(){return result;}
    
    
    
    
}
