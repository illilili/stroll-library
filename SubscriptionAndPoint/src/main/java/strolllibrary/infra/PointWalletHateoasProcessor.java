package strolllibrary.infra;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;
import strolllibrary.domain.*;

@Component
public class PointWalletHateoasProcessor
    implements RepresentationModelProcessor<EntityModel<PointWallet>> {

    @Override
    public EntityModel<PointWallet> process(EntityModel<PointWallet> model) {
        model.add(
            Link
                .of(
                    model.getRequiredLink("self").getHref() +
                    "/grantpointstowallet"
                )
                .withRel("grantpointstowallet")
        );
        model.add(
            Link
                .of(
                    model.getRequiredLink("self").getHref() +
                    "/recordpointhistoryentry"
                )
                .withRel("recordpointhistoryentry")
        );

        return model;
    }
}
