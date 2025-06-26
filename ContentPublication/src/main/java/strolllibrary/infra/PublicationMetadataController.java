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
// @RequestMapping(value="/publicationMetadata")
@Transactional
public class PublicationMetadataController {

    @Autowired
    PublicationMetadataRepository publicationMetadataRepository;

    @RequestMapping(
        value = "/publicationMetadataupdatepublicationmetadatafromconversion",
        method = RequestMethod.PATCH,
        produces = "application/json;charset=UTF-8"
    )
    public PublicationMetadata updatePublicationMetadataFromConversion(
        HttpServletRequest request,
        HttpServletResponse response,
        @RequestBody UpdatePublicationMetadataFromConversionCommand updatePublicationMetadataFromConversionCommand
    ) throws Exception {
        System.out.println(
            "##### /publicationMetadata/updatePublicationMetadataFromConversion  called #####"
        );
        PublicationMetadata publicationMetadata = new PublicationMetadata();
        publicationMetadata.updatePublicationMetadataFromConversion(
            updatePublicationMetadataFromConversionCommand
        );
        publicationMetadataRepository.save(publicationMetadata);
        return publicationMetadata;
    }

    @RequestMapping(
        value = "/publicationMetadataupdatepublicationmetadatafromsummary",
        method = RequestMethod.PATCH,
        produces = "application/json;charset=UTF-8"
    )
    public PublicationMetadata updatePublicationMetadataFromSummary(
        HttpServletRequest request,
        HttpServletResponse response,
        @RequestBody UpdatePublicationMetadataFromSummaryCommand updatePublicationMetadataFromSummaryCommand
    ) throws Exception {
        System.out.println(
            "##### /publicationMetadata/updatePublicationMetadataFromSummary  called #####"
        );
        PublicationMetadata publicationMetadata = new PublicationMetadata();
        publicationMetadata.updatePublicationMetadataFromSummary(
            updatePublicationMetadataFromSummaryCommand
        );
        publicationMetadataRepository.save(publicationMetadata);
        return publicationMetadata;
    }

    @RequestMapping(
        value = "/publicationMetadataupdatepublicationmetadatafromcategoryandpricing",
        method = RequestMethod.PATCH,
        produces = "application/json;charset=UTF-8"
    )
    public PublicationMetadata updatePublicationMetadataFromCategoryAndPricing(
        HttpServletRequest request,
        HttpServletResponse response,
        @RequestBody UpdatePublicationMetadataFromCategoryAndPricingCommand updatePublicationMetadataFromCategoryAndPricingCommand
    ) throws Exception {
        System.out.println(
            "##### /publicationMetadata/updatePublicationMetadataFromCategoryAndPricing  called #####"
        );
        PublicationMetadata publicationMetadata = new PublicationMetadata();
        publicationMetadata.updatePublicationMetadataFromCategoryAndPricing(
            updatePublicationMetadataFromCategoryAndPricingCommand
        );
        publicationMetadataRepository.save(publicationMetadata);
        return publicationMetadata;
    }

    @RequestMapping(
        value = "/publicationMetadataupdatepublicationmetadatafromcover",
        method = RequestMethod.PATCH,
        produces = "application/json;charset=UTF-8"
    )
    public PublicationMetadata updatePublicationMetadataFromCover(
        HttpServletRequest request,
        HttpServletResponse response,
        @RequestBody UpdatePublicationMetadataFromCoverCommand updatePublicationMetadataFromCoverCommand
    ) throws Exception {
        System.out.println(
            "##### /publicationMetadata/updatePublicationMetadataFromCover  called #####"
        );
        PublicationMetadata publicationMetadata = new PublicationMetadata();
        publicationMetadata.updatePublicationMetadataFromCover(
            updatePublicationMetadataFromCoverCommand
        );
        publicationMetadataRepository.save(publicationMetadata);
        return publicationMetadata;
    }
}
//>>> Clean Arch / Inbound Adaptor
