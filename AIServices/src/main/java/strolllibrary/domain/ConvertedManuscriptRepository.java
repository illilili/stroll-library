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
    collectionResourceRel = "convertedManuscripts",
    path = "convertedManuscripts"
)
public interface ConvertedManuscriptRepository
    extends PagingAndSortingRepository<ConvertedManuscript, String> {
    @Query(
        value = "select convertedManuscript " +
        "from ConvertedManuscript convertedManuscript " +
        "where(:convertedManuscriptId is null or convertedManuscript.convertedManuscriptId like %:convertedManuscriptId%) and (:manuscriptId is null or convertedManuscript.manuscriptId like %:manuscriptId%) and (:status is null or convertedManuscript.status = :status)"
    )
    ConvertedManuscript convertedManuscriptDetails(
        String convertedManuscriptId,
        String manuscriptId,
        ManuscriptConvertStatus status
    );

    @Query(
        value = "select convertedManuscript " +
        "from ConvertedManuscript convertedManuscript " +
        "where(:manuscriptId is null or convertedManuscript.manuscriptId like %:manuscriptId%) and (:status is null or convertedManuscript.status = :status) and (:convertedAt is null or convertedManuscript.convertedAt = :convertedAt)"
    )
    List<ConvertedManuscript> convertedManuscriptList(
        String manuscriptId,
        ManuscriptConvertStatus status,
        Date convertedAt,
        Pageable pageable
    );
}
