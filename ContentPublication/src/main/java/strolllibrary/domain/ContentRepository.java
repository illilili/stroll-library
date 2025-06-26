package strolllibrary.domain;

import java.util.Date;
import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import strolllibrary.domain.*;

//<<< PoEAA / Repository
@RepositoryRestResource(collectionResourceRel = "contents", path = "contents")
public interface ContentRepository
    extends PagingAndSortingRepository<Content, Long> {
    @Query(
        value = "select content " +
        "from Content content " +
        "where(:writerId is null or content.writerId = :writerId) and (:saveStatus is null or content.saveStatus = :saveStatus) and (:createdAt is null or content.createdAt = :createdAt)"
    )
    List<Content> contentDraftList(
        Long writerId,
        ContentSaveStatus saveStatus,
        Date createdAt,
        Pageable pageable
    );

    @Query(
        value = "select content " +
        "from Content content " +
        "where(:contentId is null or content.contentId = :contentId)"
    )
    Content contentDetails(Long contentId);

    @Query(
        value = "select content " +
        "from Content content " +
        "where(:contentId is null or content.contentId = :contentId) and (:requestedAt is null or content.requestedAt = :requestedAt)"
    )
    List<Content> publicationRequestHistory(
        Long contentId,
        Date requestedAt,
        Pageable pageable
    );

    @Query(
        value = "select content " +
        "from Content content " +
        "where(:writerId is null or content.writerId = :writerId) and (:saveStatus is null or content.saveStatus = :saveStatus) and (:createdAt is null or content.createdAt = :createdAt)"
    )
    List<Content> contentFinalList(
        Long writerId,
        ContentSaveStatus saveStatus,
        Date createdAt,
        Pageable pageable
    );
}
