package strolllibrary.infra;

import java.util.Optional;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import strolllibrary.domain.*;

//<<< Clean Arch / Inbound Adaptor

@RestController
// @RequestMapping(value="/convertedManuscripts")
@Transactional
public class ConvertedManuscriptController {

    @Autowired
    ConvertedManuscriptRepository convertedManuscriptRepository;

    @RequestMapping(
        value = "/convertedManuscriptsconvertmanuscript",
        method = RequestMethod.POST,
        produces = "application/json;charset=UTF-8"
    )
    public ConvertedManuscript convertManuscript(
        HttpServletRequest request,
        HttpServletResponse response,
        @RequestBody ConvertManuscriptCommand convertManuscriptCommand
    ) throws Exception {
        System.out.println(
            "##### /convertedManuscript/convertManuscript  called #####"
        );
        ConvertedManuscript convertedManuscript = new ConvertedManuscript();
        convertedManuscript.convertManuscript(convertManuscriptCommand);
        convertedManuscriptRepository.save(convertedManuscript);
        return convertedManuscript;
    }
}
//>>> Clean Arch / Inbound Adaptor
