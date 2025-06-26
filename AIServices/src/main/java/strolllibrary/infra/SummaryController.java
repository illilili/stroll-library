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
// @RequestMapping(value="/summaries")
@Transactional
public class SummaryController {

    @Autowired
    SummaryRepository summaryRepository;

    @RequestMapping(
        value = "/summariesupdatesummarystatus",
        method = RequestMethod.PATCH,
        produces = "application/json;charset=UTF-8"
    )
    public Summary updateSummaryStatus(
        HttpServletRequest request,
        HttpServletResponse response,
        @RequestBody UpdateSummaryStatusCommand updateSummaryStatusCommand
    ) throws Exception {
        System.out.println("##### /summary/updateSummaryStatus  called #####");
        Summary summary = new Summary();
        summary.updateSummaryStatus(updateSummaryStatusCommand);
        summaryRepository.save(summary);
        return summary;
    }

    @RequestMapping(
        value = "/summariesgeneratesummary",
        method = RequestMethod.POST,
        produces = "application/json;charset=UTF-8"
    )
    public Summary generateSummary(
        HttpServletRequest request,
        HttpServletResponse response,
        @RequestBody GenerateSummaryCommand generateSummaryCommand
    ) throws Exception {
        System.out.println("##### /summary/generateSummary  called #####");
        Summary summary = new Summary();
        summary.generateSummary(generateSummaryCommand);
        summaryRepository.save(summary);
        return summary;
    }
}
//>>> Clean Arch / Inbound Adaptor
