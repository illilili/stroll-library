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
    collectionResourceRel = "portfolios",
    path = "portfolios"
)
public interface PortfolioRepository
    extends PagingAndSortingRepository<Portfolio, Long> {
    @Query(
        value = "select portfolio " +
        "from Portfolio portfolio " +
        "where(:portfolioId is null or portfolio.portfolioId = :portfolioId)"
    )
    Portfolio portfolioDetails(Long portfolioId);

    @Query(
        value = "select portfolio " +
        "from Portfolio portfolio " +
        "where(:writerId is null or portfolio.writerId = :writerId) and (:createdAt is null or portfolio.createdAt = :createdAt)"
    )
    List<Portfolio> portfolioList(
        Long writerId,
        Date createdAt,
        Pageable pageable
    );
}
