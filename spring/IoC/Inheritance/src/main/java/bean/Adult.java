package bean;

public class Adult extends Person {
    private Long number;
    private Long sirial;
    private Long snils;

    Adult(){}

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

    public Long getSirial() {
        return sirial;
    }

    public void setSirial(Long sirial) {
        this.sirial = sirial;
    }

    public Long getSnils() {
        return snils;
    }

    public void setSnils(Long snils) {
        this.snils = snils;
    }

    @Override
    public String toString() {
        System.out.println(super.toString());
        return "Adult{" +
                "number=" + number +
                ", sirial=" + sirial +
                ", snils=" + snils +
                '}';
    }
}
