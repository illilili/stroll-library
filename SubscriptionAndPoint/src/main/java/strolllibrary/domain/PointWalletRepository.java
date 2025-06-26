package strolllibrary.domain;

import java.util.Date;
import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import strolllibrary.domain.*;

//<<< PoEAA / Repository
@RepositoryRestResource(
    collectionResourceRel = "pointWallets",
    path = "pointWallets"
)
public interface PointWalletRepository
    extends PagingAndSortingRepository<PointWallet, String> {
    @Query(
        value = "select pointWallet " +
        "from PointWallet pointWallet " +
        "where(:pointWalletId is null or pointWallet.pointWalletId like %:pointWalletId%)"
    )
    PointWallet pointWalletBalance(String pointWalletId);

    @Query(
        value = "select pointWallet " +
        "from PointWallet pointWallet " +
        "where(:pointWalletId is null or pointWallet.pointWalletId like %:pointWalletId%) and (:fromDate is null or pointWallet.fromDate = :fromDate) and (:toDate is null or pointWallet.toDate = :toDate)"
    )
    List<PointWallet> pointWalletHistory(
        String pointWalletId,
        Date fromDate,
        Date toDate,
        Pageable pageable
    );
}
