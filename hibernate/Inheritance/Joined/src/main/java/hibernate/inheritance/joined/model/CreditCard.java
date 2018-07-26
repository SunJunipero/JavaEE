package hibernate.inheritance.joined.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "credit_payment")
@PrimaryKeyJoinColumn(name = "payment_id")
public class CreditCard extends Payment {
    @Column(name = "card_id")
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
