package strolllibrary.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.Data;

@Data
public class GrantBestsellerBadgeCommand {

    private String bookId;
    private Integer viewCount;
}
