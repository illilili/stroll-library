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
@Table(name = "PromotionMessage_table")
@Data
//<<< DDD / Aggregate Root
public class PromotionMessage {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long promotionMessageId;

    private String message;

    private PromotionType promotionType;

    private Date displayedAt;

    private Date createdAt;

    @Embedded
    private UserId userId;

    public static PromotionMessageRepository repository() {
        PromotionMessageRepository promotionMessageRepository = SubscriptionAndPointApplication.applicationContext.getBean(
            PromotionMessageRepository.class
        );
        return promotionMessageRepository;
    }

    //<<< Clean Arch / Port Method
    public void displayPromotionMessage(
        DisplayPromotionMessageCommand displayPromotionMessageCommand
    ) {
        //implement business logic here:

        PromotionMessageDisplayed promotionMessageDisplayed = new PromotionMessageDisplayed(
            this
        );
        promotionMessageDisplayed.publishAfterCommit();
    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
