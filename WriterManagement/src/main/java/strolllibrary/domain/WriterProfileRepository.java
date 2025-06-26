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
    collectionResourceRel = "writerProfiles",
    path = "writerProfiles"
)
public interface WriterProfileRepository
    extends PagingAndSortingRepository<WriterProfile, Long> {
    @Query(
        value = "select writerProfile " +
        "from WriterProfile writerProfile " +
        "where(:status is null or writerProfile.status = :status) and (:submittedAt is null or writerProfile.submittedAt = :submittedAt)"
    )
    List<WriterProfile> writerRegistrationList(
        WriterRegistrationStatus status,
        Date submittedAt,
        Pageable pageable
    );

    @Query(
        value = "select writerProfile " +
        "from WriterProfile writerProfile " +
        "where(:requestId is null or writerProfile.requestId = :requestId)"
    )
    WriterProfile writerRegistrationDetails(Long requestId);
}
