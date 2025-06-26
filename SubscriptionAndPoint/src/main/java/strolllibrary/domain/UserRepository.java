package strolllibrary.domain;

import java.util.Date;
import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import strolllibrary.domain.*;

//<<< PoEAA / Repository
@RepositoryRestResource(collectionResourceRel = "users", path = "users")
public interface UserRepository
    extends PagingAndSortingRepository<User, String> {
    @Query(
        value = "select user " +
        "from User user " +
        "where(:userId is null or user.userId like %:userId%) and (:fromDate is null or user.fromDate = :fromDate) and (:toDate is null or user.toDate = :toDate)"
    )
    List<User> userPointHistory(
        String userId,
        Date fromDate,
        Date toDate,
        Pageable pageable
    );

    @Query(
        value = "select user " +
        "from User user " +
        "where(:userId is null or user.userId like %:userId%)"
    )
    User userProfile(String userId);
}
