package strolllibrary.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import strolllibrary.domain.*;
import strolllibrary.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class BookDeleted extends AbstractEvent {

    private String bookId;
    private String title;
    private AuthorName authorName;
    private String deleteReason;
    private Date deletedAt;
    private BookStatus status;

    public BookDeleted(Book aggregate) {
        super(aggregate);
    }

    public BookDeleted() {
        super();
    }
}
//>>> DDD / Domain Event
