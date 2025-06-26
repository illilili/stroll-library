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
// @RequestMapping(value="/pointWallets")
@Transactional
public class PointWalletController {

    @Autowired
    PointWalletRepository pointWalletRepository;

    @RequestMapping(
        value = "/pointWallets/grantpointstowallet",
        method = RequestMethod.POST,
        produces = "application/json;charset=UTF-8"
    )
    public PointWallet grantPointsToWallet(
        HttpServletRequest request,
        HttpServletResponse response,
        @RequestBody GrantPointsToWalletCommand grantPointsToWalletCommand
    ) throws Exception {
        System.out.println(
            "##### /pointWallet/grantPointsToWallet  called #####"
        );
        PointWallet pointWallet = new PointWallet();
        pointWallet.grantPointsToWallet(grantPointsToWalletCommand);
        pointWalletRepository.save(pointWallet);
        return pointWallet;
    }

    @RequestMapping(
        value = "/pointWallets/recordpointhistoryentry",
        method = RequestMethod.POST,
        produces = "application/json;charset=UTF-8"
    )
    public PointWallet recordPointHistoryEntry(
        HttpServletRequest request,
        HttpServletResponse response,
        @RequestBody RecordPointHistoryEntryCommand recordPointHistoryEntryCommand
    ) throws Exception {
        System.out.println(
            "##### /pointWallet/recordPointHistoryEntry  called #####"
        );
        PointWallet pointWallet = new PointWallet();
        pointWallet.recordPointHistoryEntry(recordPointHistoryEntryCommand);
        pointWalletRepository.save(pointWallet);
        return pointWallet;
    }
}
//>>> Clean Arch / Inbound Adaptor
