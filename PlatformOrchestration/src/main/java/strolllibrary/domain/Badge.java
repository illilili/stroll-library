package strolllibrary.domain;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.time.LocalDate;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.persistence.*;
import lombok.Data;
import strolllibrary.PlatformOrchestrationApplication;

@Entity
@Table(name = "Badge_table")
@Data
//<<< DDD / Aggregate Root
public class Badge {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long badgeId;

    private BadgeType type;

    private Date grantedAt;

    @Embedded
    private BookId bookId;

    public static BadgeRepository repository() {
        BadgeRepository badgeRepository = PlatformOrchestrationApplication.applicationContext.getBean(
            BadgeRepository.class
        );
        return badgeRepository;
    }
}
//>>> DDD / Aggregate Root
