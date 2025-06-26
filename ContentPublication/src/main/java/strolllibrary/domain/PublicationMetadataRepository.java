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
    collectionResourceRel = "publicationMetadata",
    path = "publicationMetadata"
)
public interface PublicationMetadataRepository
    extends PagingAndSortingRepository<PublicationMetadata, Long> {
    @Query(
        value = "select publicationMetadata " +
        "from PublicationMetadata publicationMetadata " +
        "where(:publicationMetadataId is null or publicationMetadata.publicationMetadataId = :publicationMetadataId)"
    )
    PublicationMetadata publicationMetadataDetails(Long publicationMetadataId);

    @Query(
        value = "select publicationMetadata " +
        "from PublicationMetadata publicationMetadata " +
        "where(:contentId is null or publicationMetadata.contentId = :contentId) and (:category is null or publicationMetadata.category like %:category%) and (:subscriptionPrice is null or publicationMetadata.subscriptionPrice = :subscriptionPrice) and (:createdAt is null or publicationMetadata.createdAt = :createdAt)"
    )
    List<PublicationMetadata> publicationMetadataList(
        Long contentId,
        String category,
        Double subscriptionPrice,
        Date createdAt,
        Pageable pageable
    );
}
