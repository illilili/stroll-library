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
    collectionResourceRel = "coverImages",
    path = "coverImages"
)
public interface CoverImageRepository
    extends PagingAndSortingRepository<CoverImage, String> {
    @Query(
        value = "select coverImage " +
        "from CoverImage coverImage " +
        "where(:coverImageId is null or coverImage.coverImageId like %:coverImageId%) and (:manuscriptId is null or coverImage.manuscriptId like %:manuscriptId%) and (:imageUrl is null or coverImage.imageUrl like %:imageUrl%) and (:status is null or coverImage.status = :status)"
    )
    CoverImage coverImageDetails(
        String coverImageId,
        String manuscriptId,
        String imageUrl,
        CoverImageStatus status
    );
}
