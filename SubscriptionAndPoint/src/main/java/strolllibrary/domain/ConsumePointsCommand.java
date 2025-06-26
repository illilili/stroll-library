package strolllibrary.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.Data;

@Data
public class ConsumePointsCommand {

    private String userId;
    private Integer amount;
    private String contentId;
    private Date consumedAt;
}
