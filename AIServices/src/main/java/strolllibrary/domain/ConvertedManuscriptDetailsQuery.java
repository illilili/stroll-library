package strolllibrary.domain;

import java.util.Date;
import lombok.Data;

@Data
public class ConvertedManuscriptDetailsQuery {

    private String convertedManuscriptId;
    private String manuscriptId;
    private ManuscriptConvertStatus status;
}
