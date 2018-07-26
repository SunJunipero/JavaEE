package hibernate.inheritance.single_table.model;

import javax.persistence.*;

@Entity
@DiscriminatorValue("2")
public class ChequePayment extends Payment {
    @Column(name = "bank_id")
    private String bankId;

    public String getBankId() {
        return bankId;
    }

    public void setBankId(String bankId) {
        this.bankId = bankId;
    }

    @Override
    public String toString() {
        return "ChequePayment{" +
                "bankId='" + bankId + '\'' +
                '}';
    }
}
