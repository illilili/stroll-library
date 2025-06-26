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
    collectionResourceRel = "categoryAndFees",
    path = "categoryAndFees"
)
public interface CategoryAndFeeRepository
    extends PagingAndSortingRepository<CategoryAndFee, String> {
    @Query(
        value = "select categoryAndFee " +
        "from CategoryAndFee categoryAndFee " +
        "where(:categoryAndFeeId is null or categoryAndFee.categoryAndFeeId like %:categoryAndFeeId%) and (:manuscriptId is null or categoryAndFee.manuscriptId like %:manuscriptId%) and (:bookId is null or categoryAndFee.bookId like %:bookId%) and (:status is null or categoryAndFee.status = :status)"
    )
    CategoryAndFee categoryAndFeeDetails(
        String categoryAndFeeId,
        String manuscriptId,
        String bookId,
        CategoryFeeStatus status
    );

    @Query(
        value = "select categoryAndFee " +
        "from CategoryAndFee categoryAndFee " +
        "where(:manuscriptId is null or categoryAndFee.manuscriptId like %:manuscriptId%) and (:bookId is null or categoryAndFee.bookId like %:bookId%) and (:category is null or categoryAndFee.category like %:category%) and (:status is null or categoryAndFee.status = :status) and (:generatedAt is null or categoryAndFee.generatedAt = :generatedAt)"
    )
    List<CategoryAndFee> categoryAndFeeList(
        String manuscriptId,
        String bookId,
        String category,
        CategoryFeeStatus status,
        Date generatedAt,
        Pageable pageable
    );
}
