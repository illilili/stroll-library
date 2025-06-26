package strolllibrary.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import strolllibrary.domain.*;
import strolllibrary.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class PortfolioCreated extends AbstractEvent {

    private Long portfolioId;
    private Long writerId;
    private String portfolioUrl;
    private Date createdAt;

    public PortfolioCreated(Portfolio aggregate) {
        super(aggregate);
    }

    public PortfolioCreated() {
        super();
    }
}
//>>> DDD / Domain Event
