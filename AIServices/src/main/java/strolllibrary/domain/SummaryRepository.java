package strolllibrary.domain;

import java.util.Date;
import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import strolllibrary.domain.*;

//<<< PoEAA / Repository
@RepositoryRestResource(collectionResourceRel = "summaries", path = "summaries")
public interface SummaryRepository
    extends PagingAndSortingRepository<Summary, String> {
    @Query(
        value = "select summary " +
        "from Summary summary " +
        "where(:summaryId is null or summary.summaryId like %:summaryId%) and (:manuscriptId is null or summary.manuscriptId like %:manuscriptId%) and (:status is null or summary.status = :status)"
    )
    Summary summaryDetails(
        String summaryId,
        String manuscriptId,
        SummaryStatus status
    );
}
