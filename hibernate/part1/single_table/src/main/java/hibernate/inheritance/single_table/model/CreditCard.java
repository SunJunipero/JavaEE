package hibernate.inheritance.single_table.model;

import javax.persistence.*;

@Entity
@DiscriminatorValue("1")
public class CreditCard extends Payment {
    @Column(name = "credit_number")
    private String cardId;

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    @Override
    public String toString() {
        return "CreditCard{" +
                "cardId='" + cardId + '\'' +
                '}';
    }
}
