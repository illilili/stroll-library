package strolllibrary.domain;

import java.util.Date;
import lombok.Data;

@Data
public class CoverImageDetailsQuery {

    private String coverImageId;
    private String manuscriptId;
    private String imageUrl;
    private CoverImageStatus status;
}
