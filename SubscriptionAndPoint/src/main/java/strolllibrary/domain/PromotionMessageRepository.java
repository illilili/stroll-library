package strolllibrary.domain;

import java.util.Date;
import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import strolllibrary.domain.*;

//<<< PoEAA / Repository
@RepositoryRestResource(
    collectionResourceRel = "promotionMessages",
    path = "promotionMessages"
)
public interface PromotionMessageRepository
    extends PagingAndSortingRepository<PromotionMessage, Long> {
    @Query(
        value = "select promotionMessage " +
        "from PromotionMessage promotionMessage " +
        "where(:userId is null or promotionMessage.userId = :userId) and (:promotionType is null or promotionMessage.promotionType = :promotionType) and (:displayedAt is null or promotionMessage.displayedAt = :displayedAt)"
    )
    List<PromotionMessage> promotionMessageHistory(
        UserId userId,
        PromotionType promotionType,
        Date displayedAt,
        Pageable pageable
    );

    @Query(
        value = "select promotionMessage " +
        "from PromotionMessage promotionMessage " +
        "where(:userId is null or promotionMessage.userId = :userId)"
    )
    PromotionMessage promotionMessageCurrent(UserId userId);
}
