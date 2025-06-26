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
// @RequestMapping(value="/contents")
@Transactional
public class ContentController {

    @Autowired
    ContentRepository contentRepository;

    @RequestMapping(
        value = "/contentsdraftcontent",
        method = RequestMethod.POST,
        produces = "application/json;charset=UTF-8"
    )
    public Content draftContent(
        HttpServletRequest request,
        HttpServletResponse response,
        @RequestBody DraftContentCommand draftContentCommand
    ) throws Exception {
        System.out.println("##### /content/draftContent  called #####");
        Content content = new Content();
        content.draftContent(draftContentCommand);
        contentRepository.save(content);
        return content;
    }

    @RequestMapping(
        value = "/contentsupdatecontent",
        method = RequestMethod.PATCH,
        produces = "application/json;charset=UTF-8"
    )
    public Content updateContent(
        HttpServletRequest request,
        HttpServletResponse response,
        @RequestBody UpdateContentCommand updateContentCommand
    ) throws Exception {
        System.out.println("##### /content/updateContent  called #####");
        Content content = new Content();
        content.updateContent(updateContentCommand);
        contentRepository.save(content);
        return content;
    }

    @RequestMapping(
        value = "/contentssavecontent",
        method = RequestMethod.POST,
        produces = "application/json;charset=UTF-8"
    )
    public Content saveContent(
        HttpServletRequest request,
        HttpServletResponse response,
        @RequestBody SaveContentCommand saveContentCommand
    ) throws Exception {
        System.out.println("##### /content/saveContent  called #####");
        Content content = new Content();
        content.saveContent(saveContentCommand);
        contentRepository.save(content);
        return content;
    }
}
//>>> Clean Arch / Inbound Adaptor
