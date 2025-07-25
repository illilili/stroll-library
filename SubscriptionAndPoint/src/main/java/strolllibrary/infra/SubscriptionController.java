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
// @RequestMapping(value="/subscriptions")
@Transactional
public class SubscriptionController {

    @Autowired
    SubscriptionRepository subscriptionRepository;

    @RequestMapping(
        value = "/subscriptionspurchasesubscription",
        method = RequestMethod.POST,
        produces = "application/json;charset=UTF-8"
    )
    public Subscription purchaseSubscription(
        HttpServletRequest request,
        HttpServletResponse response,
        @RequestBody PurchaseSubscriptionCommand purchaseSubscriptionCommand
    ) throws Exception {
        System.out.println(
            "##### /subscription/purchaseSubscription  called #####"
        );
        Subscription subscription = new Subscription();
        subscription.purchaseSubscription(purchaseSubscriptionCommand);
        subscriptionRepository.save(subscription);
        return subscription;
    }

    @RequestMapping(
        value = "/subscriptionscancelsubscription",
        method = RequestMethod.PATCH,
        produces = "application/json;charset=UTF-8"
    )
    public Subscription cancelSubscription(
        HttpServletRequest request,
        HttpServletResponse response,
        @RequestBody CancelSubscriptionCommand cancelSubscriptionCommand
    ) throws Exception {
        System.out.println(
            "##### /subscription/cancelSubscription  called #####"
        );
        Subscription subscription = new Subscription();
        subscription.cancelSubscription(cancelSubscriptionCommand);
        subscriptionRepository.save(subscription);
        return subscription;
    }

    @RequestMapping(
        value = "/subscriptionsexpiresubscription",
        method = RequestMethod.PATCH,
        produces = "application/json;charset=UTF-8"
    )
    public Subscription expireSubscription(
        HttpServletRequest request,
        HttpServletResponse response,
        @RequestBody ExpireSubscriptionCommand expireSubscriptionCommand
    ) throws Exception {
        System.out.println(
            "##### /subscription/expireSubscription  called #####"
        );
        Subscription subscription = new Subscription();
        subscription.expireSubscription(expireSubscriptionCommand);
        subscriptionRepository.save(subscription);
        return subscription;
    }
}
//>>> Clean Arch / Inbound Adaptor
