public class Account {
    private int agency;
    private String owner;
    private Double funds;
    private int id;
    private static int idCounter = 1;

    public Account(int agency, String owner)
    {
        this.agency = agency;
        this.owner = owner;
        this.funds = 0.0;
        this.id = idCounter++;
    }

    public int getAgency()
    {
        return agency;
    }

    public void setAgency(int agency)
    {
        this.agency = agency;
    }

    public String getOwner()
    {
        return owner;
    }

    public void setOwner(String owner)
    {
        this.owner = owner;
    }

    public Double getFunds()
    {
        return funds;
    }

    public void setFunds(Double funds)
    {
        this.funds = funds;
    }

    public void deposit(Double value)
    {
        this.funds += value;
    }

    public void withdraw(Double value)
    {
        this.funds -= value;
    }

    @Override
    public String toString()
    {
        return "Account{" +
                "agency=" + agency +
                ", owner='" + owner + '\'' +
                ", funds=" + funds +
                ", id=" + id +
                '}';
    }
}
