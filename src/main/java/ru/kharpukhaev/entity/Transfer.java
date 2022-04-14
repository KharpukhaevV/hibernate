package ru.kharpukhaev.entity;

import javax.persistence.*;

@Entity
@Table(name = "transfers")
public class Transfer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "transfer_id",unique=true, nullable = false)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(nullable = false)
    private Client sender;

    @Column(name = "account_number")
    private String accountNumber;

    @Column(name = "transfer_sum")
    private long transferSum;

    public Transfer() {
    }

    public Transfer(Client sender, String accountNumber, long transferSum) {
        this.sender = sender;
        this.accountNumber = accountNumber;
        this.transferSum = transferSum;
    }

    public Client getSender() {
        return sender;
    }

    public void setSender(Client sender) {
        this.sender = sender;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setRecipient(String recipient) {
        this.accountNumber = recipient;
    }

    public long getTransferSum() {
        return transferSum;
    }

    public void setTransferSum(long transferSum) {
        this.transferSum = transferSum;
    }

    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "sender-" + sender +
                ", accountNumber-" + accountNumber +
                ", transferSum=" + transferSum;
    }
}
