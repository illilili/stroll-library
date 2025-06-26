package strolllibrary.domain;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.time.LocalDate;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.persistence.*;
import lombok.Data;
import strolllibrary.PlatformOrchestrationApplication;
import strolllibrary.domain.BestsellerBadgeGranted;
import strolllibrary.domain.BookDeleted;

@Entity
@Table(name = "Book_table")
@Data
//<<< DDD / Aggregate Root
public class Book {

    @Id
    private String bookId;

    private String title;

    private AuthorName authorName;

    private Integer viewCount;

    private BookStatus status;

    private Boolean bestsellerBadge;

    @PostPersist
    public void onPostPersist() {
        BookDeleted bookDeleted = new BookDeleted(this);
        bookDeleted.publishAfterCommit();

        BestsellerBadgeGranted bestsellerBadgeGranted = new BestsellerBadgeGranted(
            this
        );
        bestsellerBadgeGranted.publishAfterCommit();
    }

    public static BookRepository repository() {
        BookRepository bookRepository = PlatformOrchestrationApplication.applicationContext.getBean(
            BookRepository.class
        );
        return bookRepository;
    }

    //<<< Clean Arch / Port Method
    public void grantBestsellerBadge(
        GrantBestsellerBadgeCommand grantBestsellerBadgeCommand
    ) {
        //implement business logic here:

    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public void deleteBook(DeleteBookCommand deleteBookCommand) {
        //implement business logic here:

    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
