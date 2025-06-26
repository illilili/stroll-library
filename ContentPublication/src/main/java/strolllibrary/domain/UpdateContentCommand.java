package strolllibrary.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.Data;

@Data
public class UpdateContentCommand {

    private Long contentId;
    private String title;
    private String body;
    private String keywords;
}
