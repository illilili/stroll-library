package strolllibrary.domain;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.time.LocalDate;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.persistence.*;
import lombok.Data;
import strolllibrary.SubscriptionAndPointApplication;

@Entity
@Table(name = "Subscription_table")
@Data
//<<< DDD / Aggregate Root
public class Subscription {

    @Id
    private String subscriptionId;

    private String userId;

    private SubscriptionStatus status;

    private Date startDate;

    private Date endDate;

    public static SubscriptionRepository repository() {
        SubscriptionRepository subscriptionRepository = SubscriptionAndPointApplication.applicationContext.getBean(
            SubscriptionRepository.class
        );
        return subscriptionRepository;
    }

    //<<< Clean Arch / Port Method
    public void purchaseSubscription(
        PurchaseSubscriptionCommand purchaseSubscriptionCommand
    ) {
        //implement business logic here:

        SubscriptionPurchased subscriptionPurchased = new SubscriptionPurchased(
            this
        );
        subscriptionPurchased.publishAfterCommit();
    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public void cancelSubscription(
        CancelSubscriptionCommand cancelSubscriptionCommand
    ) {
        //implement business logic here:

        SubscriptionCancelled subscriptionCancelled = new SubscriptionCancelled(
            this
        );
        subscriptionCancelled.publishAfterCommit();
    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public void expireSubscription(
        ExpireSubscriptionCommand expireSubscriptionCommand
    ) {
        //implement business logic here:

        SubscriptionExpired subscriptionExpired = new SubscriptionExpired(this);
        subscriptionExpired.publishAfterCommit();
    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
