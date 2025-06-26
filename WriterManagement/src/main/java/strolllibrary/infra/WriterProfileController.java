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
// @RequestMapping(value="/writerProfiles")
@Transactional
public class WriterProfileController {

    @Autowired
    WriterProfileRepository writerProfileRepository;

    @RequestMapping(
        value = "/writerProfilesrequestwriterregistration",
        method = RequestMethod.POST,
        produces = "application/json;charset=UTF-8"
    )
    public WriterProfile requestWriterRegistration(
        HttpServletRequest request,
        HttpServletResponse response,
        @RequestBody RequestWriterRegistrationCommand requestWriterRegistrationCommand
    ) throws Exception {
        System.out.println(
            "##### /writerProfile/requestWriterRegistration  called #####"
        );
        WriterProfile writerProfile = new WriterProfile();
        writerProfile.requestWriterRegistration(
            requestWriterRegistrationCommand
        );
        writerProfileRepository.save(writerProfile);
        return writerProfile;
    }

    @RequestMapping(
        value = "/writerProfilesapprovewriterregistration",
        method = RequestMethod.PATCH,
        produces = "application/json;charset=UTF-8"
    )
    public WriterProfile approveWriterRegistration(
        HttpServletRequest request,
        HttpServletResponse response,
        @RequestBody ApproveWriterRegistrationCommand approveWriterRegistrationCommand
    ) throws Exception {
        System.out.println(
            "##### /writerProfile/approveWriterRegistration  called #####"
        );
        WriterProfile writerProfile = new WriterProfile();
        writerProfile.approveWriterRegistration(
            approveWriterRegistrationCommand
        );
        writerProfileRepository.save(writerProfile);
        return writerProfile;
    }

    @RequestMapping(
        value = "/writerProfilesrejectwriterregistration",
        method = RequestMethod.PATCH,
        produces = "application/json;charset=UTF-8"
    )
    public WriterProfile rejectWriterRegistration(
        HttpServletRequest request,
        HttpServletResponse response,
        @RequestBody RejectWriterRegistrationCommand rejectWriterRegistrationCommand
    ) throws Exception {
        System.out.println(
            "##### /writerProfile/rejectWriterRegistration  called #####"
        );
        WriterProfile writerProfile = new WriterProfile();
        writerProfile.rejectWriterRegistration(rejectWriterRegistrationCommand);
        writerProfileRepository.save(writerProfile);
        return writerProfile;
    }
}
//>>> Clean Arch / Inbound Adaptor
