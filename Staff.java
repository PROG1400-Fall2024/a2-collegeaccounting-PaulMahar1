public class Staff extends Person{
    private int yearsOfService;
    private double payBase;
    private double payBiweekly;

    public Staff(String name, String address, int yearsOfService){
        super(name, address);
        this.yearsOfService = yearsOfService;
        this.payBase = 50000 + (500 * yearsOfService);
        this.payBiweekly = payBase / 26;
    }

    public int getYearsOfService() {
        return yearsOfService;
    }

    public double getPayBase() {
        return payBase;
    }

    public double getPayBiweekly() {
        return payBiweekly;
    }

    public String toString() {
        return String.format("name = %s, address = %s, year = %s, fee = %.2f", getName(), getAddress(), getYearsOfService(), getPayBase());
    }


}

