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
// @RequestMapping(value="/categoryAndFees")
@Transactional
public class CategoryAndFeeController {

    @Autowired
    CategoryAndFeeRepository categoryAndFeeRepository;

    @RequestMapping(
        value = "/categoryAndFeesgeneratecategoryandfee",
        method = RequestMethod.POST,
        produces = "application/json;charset=UTF-8"
    )
    public CategoryAndFee generateCategoryAndFee(
        HttpServletRequest request,
        HttpServletResponse response,
        @RequestBody GenerateCategoryAndFeeCommand generateCategoryAndFeeCommand
    ) throws Exception {
        System.out.println(
            "##### /categoryAndFee/generateCategoryAndFee  called #####"
        );
        CategoryAndFee categoryAndFee = new CategoryAndFee();
        categoryAndFee.generateCategoryAndFee(generateCategoryAndFeeCommand);
        categoryAndFeeRepository.save(categoryAndFee);
        return categoryAndFee;
    }
}
//>>> Clean Arch / Inbound Adaptor
