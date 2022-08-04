package entities;

public class TaxPayer {
    private Double salaryIncome;
    private Double serviceIncome;
    private Double capitalIncome;
    private Double healthSpending;
    private Double educationSpending;

    public TaxPayer() {
    }

    public TaxPayer(Double salaryIncome, Double serviceIncome,
                    Double capitalIncome, Double healthSpending,
                    Double educationSpending)
    {
        this.salaryIncome = salaryIncome;
        this.serviceIncome = serviceIncome;
        this.capitalIncome = capitalIncome;
        this.healthSpending = healthSpending;
        this.educationSpending = educationSpending;
    }

    public Double getSalaryIncome() {
        return salaryIncome;
    }

    public void setSalaryIncome(Double salaryIncome) {
        this.salaryIncome = salaryIncome;
    }

    public Double getServiceIncome() {
        return serviceIncome;
    }

    public void setServiceIncome(Double serviceIncome) {
        this.serviceIncome = serviceIncome;
    }

    public Double getCapitalIncome() {
        return capitalIncome;
    }

    public void setCapitalIncome(Double capitalIncome) {
        this.capitalIncome = capitalIncome;
    }

    public Double getHealthSpending() {
        return healthSpending;
    }

    public void setHealthSpending(Double healthSpending) {
        this.healthSpending = healthSpending;
    }

    public Double getEducationSpending() {
        return educationSpending;
    }

    public void setEducationSpending(Double educationSpending) {
        this.educationSpending = educationSpending;
    }

    public Double salaryTax() {
       double monthlyIncome = salaryIncome/12;
       if(monthlyIncome < 3000.0) {
           return 0.0;
       }
       else if(monthlyIncome < 5000.0) {
           return salaryIncome * 0.1;
       }
       else {
           return salaryIncome * 0.2;
       }
    }

    public Double serviceTax() {
        return serviceIncome * 0.15;
    }

    public Double capitalTax() {
        return capitalIncome * 0.2;
    }

    public Double grossTax() {
        return salaryTax() + serviceTax() + capitalTax();
    }

    public Double taxRebate() {
        double maxRebate = grossTax() * 0.3;
        double rebate = healthSpending + educationSpending;

        if(maxRebate > rebate) {
            return rebate;
        }
        else {
            return maxRebate;
        }
    }

    public Double netTax() {
        return grossTax() - taxRebate();
    }

    public String toString() {
        return String.format("Gross tax: %.2f%nTax Rebate: %.2f%nNet Tax: %.2f%n",
               grossTax(), taxRebate(), netTax());
    }
}
