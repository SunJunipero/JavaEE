package hibernate.inheritance.single_table.model;

import javax.persistence.*;

@Entity
@Table(name = "cash_payment_full")
//@AttributeOverrides({
//        @AttributeOverride(name = "amount", column = @Column(name = "amount"))
//})
public class CashPayment extends Payment {

    @Column(name = "cash_desk")
    private String cashDesk;

    public String getCashDesk() {
        return cashDesk;
    }

    public void setCashDesk(String cashDesk) {
        this.cashDesk = cashDesk;
    }

    @Override
    public String toString() {
        return "CashPayment{" +
                "cashDesk='" + cashDesk + '\'' +
                "} " + super.toString();
    }
}
