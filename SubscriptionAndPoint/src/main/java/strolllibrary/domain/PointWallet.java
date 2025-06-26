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
@Table(name = "PointWallet_table")
@Data
//<<< DDD / Aggregate Root
public class PointWallet {

    @Id
    private String pointWalletId;

    private String userId;

    private Boolean ktCustomer;

    private Integer points;

    @ElementCollection
    private List<PointHistoryEntry> pointHistory;

    public static PointWalletRepository repository() {
        PointWalletRepository pointWalletRepository = SubscriptionAndPointApplication.applicationContext.getBean(
            PointWalletRepository.class
        );
        return pointWalletRepository;
    }

    //<<< Clean Arch / Port Method
    public void grantPointsToWallet(
        GrantPointsToWalletCommand grantPointsToWalletCommand
    ) {
        //implement business logic here:

        PointsGrantedToWallet pointsGrantedToWallet = new PointsGrantedToWallet(
            this
        );
        pointsGrantedToWallet.publishAfterCommit();
    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public void recordPointHistoryEntry(
        RecordPointHistoryEntryCommand recordPointHistoryEntryCommand
    ) {
        //implement business logic here:

        PointHistoryEntryRecorded pointHistoryEntryRecorded = new PointHistoryEntryRecorded(
            this
        );
        pointHistoryEntryRecorded.publishAfterCommit();
    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
