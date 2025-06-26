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
@Table(name = "User_table")
@Data
//<<< DDD / Aggregate Root
public class User {

    @Id
    private String userId;

    private String name;

    private Boolean ktCustomer;

    private Integer points;

    @Embedded
    private PointWalletId pointWalletId;

    @Embedded
    private SubscriptionId subscriptionId;

    public static UserRepository repository() {
        UserRepository userRepository = SubscriptionAndPointApplication.applicationContext.getBean(
            UserRepository.class
        );
        return userRepository;
    }

    //<<< Clean Arch / Port Method
    public void consumePoints(ConsumePointsCommand consumePointsCommand) {
        //implement business logic here:

        PremiumContentPurchased premiumContentPurchased = new PremiumContentPurchased(
            this
        );
        premiumContentPurchased.publishAfterCommit();
        PointsConsumed pointsConsumed = new PointsConsumed(this);
        pointsConsumed.publishAfterCommit();
        PointExhausted pointExhausted = new PointExhausted(this);
        pointExhausted.publishAfterCommit();
    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public void grantPoints(GrantPointsCommand grantPointsCommand) {
        //implement business logic here:

        PointsGranted pointsGranted = new PointsGranted(this);
        pointsGranted.publishAfterCommit();
    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public void registerUser(RegisterUserCommand registerUserCommand) {
        //implement business logic here:

        UserRegistered userRegistered = new UserRegistered(this);
        userRegistered.publishAfterCommit();
        PointsGranted pointsGranted = new PointsGranted(this);
        pointsGranted.publishAfterCommit();
    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
