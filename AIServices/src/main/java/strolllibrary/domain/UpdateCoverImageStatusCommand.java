package strolllibrary.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.Data;

@Data
public class UpdateCoverImageStatusCommand {

    private String coverImageId;
    private CoverImageStatus status;
    private Date updatedAt;
    private String failureReason;
}
