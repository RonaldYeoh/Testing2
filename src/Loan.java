public class Loan{
    private double annualInterestRate;
    private int numberOfYears;
    private double loanAmount;
    private java.util.Date loanDate;
    
    public Loan(){
        
    }
    
    public Loan(double annualInterestRate, int numberOfYears, double loanAmount){
        setAnnualInterestRate(annualInterestRate);
        setNumberOfYears(numberOfYears);
        setLoanAmount(loanAmount);
        loanDate = new java.util.Date();
    }
    
    public double getAnnualInterestRate(){
        return annualInterestRate;
    }
    
    public void setAnnualInterestRate(double annualInterestRate){
        if (annualInterestRate <= 0)
            throw new IllegalArgumentException("Interest rate cannot be 0 or negative");
        this.annualInterestRate = annualInterestRate;
    }
    
    public int getNumberOfYears(){
        return numberOfYears;
    }
    
    public void setNumberOfYears(int numberOfYears){
        if (numberOfYears <= 0)
            throw new IllegalArgumentException("Number of years cannot be 0 or negative");
        this.numberOfYears = numberOfYears;
    }
    
    public double getLoanAmount(){
        return loanAmount;
    }
    
    public void setLoanAmount(double loanAmount){
        if (loanAmount <= 0)
            throw new IllegalArgumentException("Loan amount cannot be 0 or negative");
        this.loanAmount = loanAmount;
    }
    
    public double getMonthlyPayment(){
        double monthlyInterestRate = annualInterestRate / 1200;
        return loanAmount * monthlyInterestRate / (1 - (Math.pow(1 / (1 + monthlyInterestRate), numberOfYears * 12)));
    }
    
    public double getTotalPayment(){
        return getMonthlyPayment() * numberOfYears * 12;
    }
    
    public java.util.Date getLoanDate(){
        return loanDate;
    }
}