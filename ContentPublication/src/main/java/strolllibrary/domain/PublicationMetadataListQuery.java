package strolllibrary.domain;

import java.util.Date;
import lombok.Data;

@Data
public class PublicationMetadataListQuery {

    private Long contentId;
    private String category;
    private Double subscriptionPrice;
    private Date createdAt;
}
