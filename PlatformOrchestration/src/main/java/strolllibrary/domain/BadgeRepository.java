package strolllibrary.domain;

import java.util.Date;
import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import strolllibrary.domain.*;

//<<< PoEAA / Repository
@RepositoryRestResource(collectionResourceRel = "badges", path = "badges")
public interface BadgeRepository
    extends PagingAndSortingRepository<Badge, Long> {
    @Query(
        value = "select badge " +
        "from Badge badge " +
        "where(:bookId is null or badge.bookId = :bookId) and (:type is null or badge.type = :type) and (:grantedAt is null or badge.grantedAt = :grantedAt)"
    )
    List<Badge> badgeHistory(
        BookId bookId,
        BadgeType type,
        Date grantedAt,
        Pageable pageable
    );
}
