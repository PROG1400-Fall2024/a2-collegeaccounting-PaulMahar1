public class Student extends Person{
    private int year;
    private double tuition;
    private double fee;

    public Student(String name, String address, int year){
        super(name, address);
        this.year = year;
        this.tuition = 2900 + (year * 100);
        this.fee = this.tuition / 2;
    }

    public int getYear() {
        return year;
    }

    public double getTuition() {
        return tuition;
    }

    public double getFee() {
        return fee;
    }

    public String toString() {
        return String.format("name = %s, address = %s, year = %s, fee = %.2f", getName(), getAddress(), getYear(), getTuition());
    }

}
