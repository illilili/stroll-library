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
    collectionResourceRel = "subscriptions",
    path = "subscriptions"
)
public interface SubscriptionRepository
    extends PagingAndSortingRepository<Subscription, String> {
    @Query(
        value = "select subscription " +
        "from Subscription subscription " +
        "where(:subscriptionId is null or subscription.subscriptionId = :subscriptionId)"
    )
    Subscription subscriptionStatus(Long subscriptionId);

    @Query(
        value = "select subscription " +
        "from Subscription subscription " +
        "where(:userId is null or subscription.userId = :userId) and (:status is null or subscription.status = :status) and (:startDate is null or subscription.startDate = :startDate) and (:endDate is null or subscription.endDate = :endDate)"
    )
    List<Subscription> subscriptionHistory(
        Long userId,
        SubscriptionStatus status,
        Date startDate,
        Date endDate,
        Pageable pageable
    );
}
