package strolllibrary.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import strolllibrary.domain.*;
import strolllibrary.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class PortfolioDeleted extends AbstractEvent {

    private Long portfolioId;

    public PortfolioDeleted(Portfolio aggregate) {
        super(aggregate);
    }

    public PortfolioDeleted() {
        super();
    }
}
//>>> DDD / Domain Event
