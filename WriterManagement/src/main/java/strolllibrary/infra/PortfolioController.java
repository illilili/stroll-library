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
// @RequestMapping(value="/portfolios")
@Transactional
public class PortfolioController {

    @Autowired
    PortfolioRepository portfolioRepository;

    @RequestMapping(
        value = "/portfolioscreateportfolio",
        method = RequestMethod.POST,
        produces = "application/json;charset=UTF-8"
    )
    public Portfolio createPortfolio(
        HttpServletRequest request,
        HttpServletResponse response,
        @RequestBody CreatePortfolioCommand createPortfolioCommand
    ) throws Exception {
        System.out.println("##### /portfolio/createPortfolio  called #####");
        Portfolio portfolio = new Portfolio();
        portfolio.createPortfolio(createPortfolioCommand);
        portfolioRepository.save(portfolio);
        return portfolio;
    }

    @RequestMapping(
        value = "/portfolios/{id}/deleteportfolio",
        method = RequestMethod.DELETE,
        produces = "application/json;charset=UTF-8"
    )
    public Portfolio deletePortfolio(
        @PathVariable(value = "id") Long id,
        @RequestBody DeletePortfolioCommand deletePortfolioCommand,
        HttpServletRequest request,
        HttpServletResponse response
    ) throws Exception {
        System.out.println("##### /portfolio/deletePortfolio  called #####");
        Optional<Portfolio> optionalPortfolio = portfolioRepository.findById(
            id
        );

        optionalPortfolio.orElseThrow(() -> new Exception("No Entity Found"));
        Portfolio portfolio = optionalPortfolio.get();
        portfolio.deletePortfolio(deletePortfolioCommand);

        portfolioRepository.delete(portfolio);
        return portfolio;
    }

    @RequestMapping(
        value = "/portfoliosupdateportfolio",
        method = RequestMethod.PATCH,
        produces = "application/json;charset=UTF-8"
    )
    public Portfolio updatePortfolio(
        HttpServletRequest request,
        HttpServletResponse response,
        @RequestBody UpdatePortfolioCommand updatePortfolioCommand
    ) throws Exception {
        System.out.println("##### /portfolio/updatePortfolio  called #####");
        Portfolio portfolio = new Portfolio();
        portfolio.updatePortfolio(updatePortfolioCommand);
        portfolioRepository.save(portfolio);
        return portfolio;
    }
}
//>>> Clean Arch / Inbound Adaptor
