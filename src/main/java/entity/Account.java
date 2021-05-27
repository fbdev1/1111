package entity;

import lombok.Data;
import lombok.ToString;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@ToString(exclude = "cards")
@DynamicInsert
@DynamicUpdate
@Table(name = "cl_accounts")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Long id;
    @Column(name = "AC_NUMBER", nullable = false)
    private String number;
    @Column(name = "BALANCE", nullable = false)
    private String balance;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "CLIENT_ID", nullable = false)
    private Client client;
    @OneToMany(fetch = FetchType.LAZY)
    private Set<Card> cards;

    public Account(String number, String balance) {
        this.number = number;
        this.balance = balance;

    }
    public Account(){}
}
//, mappedBy = "cl_accounts"