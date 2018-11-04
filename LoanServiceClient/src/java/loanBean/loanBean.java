package loanBean;

import java.text.NumberFormat;
import java.util.Locale;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import loanserviceclient.LoanService;
import loanserviceclient.LoanService_Service;

/**
 *
 * @author Jonathan Anders
 */
@Named(value = "loanBean")
@RequestScoped
public class loanBean {
    
    private double loanAmount;
    private double annualInterestRate;
    private int numberOfYears;
    private String result;
    
    private LoanService loanServiceProxy;
    
    /**
     * Creates a new instance of loanBean
     */
    public loanBean()
    {
        LoanService_Service service = new LoanService_Service();
        loanServiceProxy = service.getLoanServicePort();
    }
    
    //Getters and setters
    public double getLoanAmount() {return loanAmount;}
    public void setLoanAmount(double loan) {this.loanAmount = loan;}
    public double getAnnualInterestRate(){return annualInterestRate;}
    public void setAnnualInterestRate(double rate) {this.annualInterestRate = rate;}
    public int getNumberOfYears() {return numberOfYears;}
    public void setNumberOfYears(int years) {this.numberOfYears = years;}
    public String getResult(){return result;}
    
    
    public void submit()
    {
        double monthlyPayment = loanServiceProxy.monthlyPayment(annualInterestRate, loanAmount, numberOfYears);
        NumberFormat curFor = NumberFormat.getCurrencyInstance(Locale.getDefault());
        
        result = "<p style=\"color:red;"
                + "padding:5px\">Loan Amount: " + curFor.format(loanAmount) + "<br/>"
                + "Annual Interest Rate: " + getAnnualInterestRate() + "<br/>"
                + "Number of Years: " + getNumberOfYears() + "<br/>"
                + "Monthly Payment: " + curFor.format(loanServiceProxy.monthlyPayment(annualInterestRate, loanAmount, numberOfYears)) + "<br/>"
                + "Total Payment: " + curFor.format(loanServiceProxy.totalPayment(monthlyPayment, numberOfYears)) + "<br/>";
    }
    
    
}
