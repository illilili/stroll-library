package strolllibrary.domain;

import java.util.Date;
import lombok.Data;

@Data
public class ConvertedManuscriptListQuery {

    private String manuscriptId;
    private ManuscriptConvertStatus status;
    private Date convertedAt;
}
