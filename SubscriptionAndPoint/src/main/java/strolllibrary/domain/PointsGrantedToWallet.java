package strolllibrary.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import strolllibrary.domain.*;
import strolllibrary.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class PointsGrantedToWallet extends AbstractEvent {

    private String pointWalletId;
    private Integer amount;
    private String reason;
    private Date grantedAt;
    private Integer totalPoints;

    public PointsGrantedToWallet(PointWallet aggregate) {
        super(aggregate);
    }

    public PointsGrantedToWallet() {
        super();
    }
}
//>>> DDD / Domain Event
