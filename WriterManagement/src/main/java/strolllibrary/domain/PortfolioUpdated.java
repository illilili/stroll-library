package strolllibrary.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import strolllibrary.domain.*;
import strolllibrary.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class PortfolioUpdated extends AbstractEvent {

    private Long portfolioId;
    private String portfolioUrl;
    private Date updatedAt;

    public PortfolioUpdated(Portfolio aggregate) {
        super(aggregate);
    }

    public PortfolioUpdated() {
        super();
    }
}
//>>> DDD / Domain Event
