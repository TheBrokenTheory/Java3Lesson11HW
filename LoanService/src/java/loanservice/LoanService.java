package loanservice;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author Jonathan Anders
 */
@WebService(serviceName = "LoanService")
public class LoanService {

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt)
    {
        return "Hello " + txt + " !";
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "monthlyPayment")
    public double monthlyPayment(@WebParam(name = "annualInterestRate") double annualInterestRate, @WebParam(name = "loanAmount") double loanAmount, @WebParam(name = "numberOfYears") int numberOfYears)
    {
        double monthlyInterestRate = annualInterestRate / 1200;
        double monthlyPayment = loanAmount * monthlyInterestRate / (1 -
        (1 / Math.pow(1 + monthlyInterestRate, numberOfYears * 12)));
        return monthlyPayment;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "totalPayment")
    public double totalPayment(@WebParam(name = "monthlyPayment") double monthlyPayment, @WebParam(name = "numberOfYears") int numberOfYears)
    {
        double totalPayment = monthlyPayment * numberOfYears * 12;
        return totalPayment;
    }
}
