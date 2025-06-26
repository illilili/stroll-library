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
// @RequestMapping(value="/publicationRequests")
@Transactional
public class PublicationRequestController {

    @Autowired
    PublicationRequestRepository publicationRequestRepository;

    @RequestMapping(
        value = "/publicationRequestsupdatepublicationrequestmetadata",
        method = RequestMethod.PATCH,
        produces = "application/json;charset=UTF-8"
    )
    public PublicationRequest updatePublicationRequestMetadata(
        HttpServletRequest request,
        HttpServletResponse response,
        @RequestBody UpdatePublicationRequestMetadataCommand updatePublicationRequestMetadataCommand
    ) throws Exception {
        System.out.println(
            "##### /publicationRequest/updatePublicationRequestMetadata  called #####"
        );
        PublicationRequest publicationRequest = new PublicationRequest();
        publicationRequest.updatePublicationRequestMetadata(
            updatePublicationRequestMetadataCommand
        );
        publicationRequestRepository.save(publicationRequest);
        return publicationRequest;
    }
}
//>>> Clean Arch / Inbound Adaptor
