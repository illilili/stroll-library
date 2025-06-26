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
// @RequestMapping(value="/coverImages")
@Transactional
public class CoverImageController {

    @Autowired
    CoverImageRepository coverImageRepository;

    @RequestMapping(
        value = "/coverImagesupdatecoverimagestatus",
        method = RequestMethod.PATCH,
        produces = "application/json;charset=UTF-8"
    )
    public CoverImage updateCoverImageStatus(
        HttpServletRequest request,
        HttpServletResponse response,
        @RequestBody UpdateCoverImageStatusCommand updateCoverImageStatusCommand
    ) throws Exception {
        System.out.println(
            "##### /coverImage/updateCoverImageStatus  called #####"
        );
        CoverImage coverImage = new CoverImage();
        coverImage.updateCoverImageStatus(updateCoverImageStatusCommand);
        coverImageRepository.save(coverImage);
        return coverImage;
    }

    @RequestMapping(
        value = "/coverImages/generatecoverimage",
        method = RequestMethod.POST,
        produces = "application/json;charset=UTF-8"
    )
    public CoverImage generateCoverImage(
        HttpServletRequest request,
        HttpServletResponse response,
        @RequestBody GenerateCoverImageCommand generateCoverImageCommand
    ) throws Exception {
        System.out.println(
            "##### /coverImage/generateCoverImage  called #####"
        );
        CoverImage coverImage = new CoverImage();
        coverImage.generateCoverImage(generateCoverImageCommand);
        coverImageRepository.save(coverImage);
        return coverImage;
    }
}
//>>> Clean Arch / Inbound Adaptor
