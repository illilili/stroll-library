package strolllibrary.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import strolllibrary.domain.*;
import strolllibrary.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class BestsellerBadgeGranted extends AbstractEvent {

    private String bookId;
    private String title;
    private AuthorName authorName;
    private Integer viewCount;
    private Boolean bestsellerBadge;
    private Date grantedAt;

    public BestsellerBadgeGranted(Book aggregate) {
        super(aggregate);
    }

    public BestsellerBadgeGranted() {
        super();
    }
}
//>>> DDD / Domain Event
