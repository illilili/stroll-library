package strolllibrary.domain;

import java.util.Date;
import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import strolllibrary.domain.*;

//<<< PoEAA / Repository
@RepositoryRestResource(collectionResourceRel = "books", path = "books")
public interface BookRepository
    extends PagingAndSortingRepository<Book, String> {
    @Query(
        value = "select book " +
        "from Book book " +
        "where(:title is null or book.title like %:title%) and (:authorName is null or book.authorName = :authorName) and (:viewCount is null or book.viewCount = :viewCount) and (book.bestsellerBadge = :bestsellerBadge) and (:status is null or book.status = :status)"
    )
    List<Book> bookList(
        String title,
        AuthorName authorName,
        Integer viewCount,
        Boolean bestsellerBadge,
        BookStatus status,
        Pageable pageable
    );
}
