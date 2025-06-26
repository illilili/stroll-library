package strolllibrary.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import strolllibrary.domain.*;
import strolllibrary.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class UserRegistered extends AbstractEvent {

    private String userId;
    private String name;
    private Boolean ktCustomer;
    private Date registeredAt;

    public UserRegistered(User aggregate) {
        super(aggregate);
    }

    public UserRegistered() {
        super();
    }
}
//>>> DDD / Domain Event
