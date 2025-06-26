package strolllibrary.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.Data;

@Data
public class DeleteBookCommand {

    private String bookId;
    private String deleteReason;
}
