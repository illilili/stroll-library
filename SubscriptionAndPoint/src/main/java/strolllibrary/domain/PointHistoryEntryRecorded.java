package strolllibrary.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import strolllibrary.domain.*;
import strolllibrary.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class PointHistoryEntryRecorded extends AbstractEvent {

    private String pointWalletId;
    private Date changeDate;
    private Integer changeAmount;
    private String description;
    private Integer balanceAfterChange;

    public PointHistoryEntryRecorded(PointWallet aggregate) {
        super(aggregate);
    }

    public PointHistoryEntryRecorded() {
        super();
    }
}
//>>> DDD / Domain Event
