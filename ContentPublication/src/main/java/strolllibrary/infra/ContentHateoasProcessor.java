package strolllibrary.infra;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;
import strolllibrary.domain.*;

@Component
public class ContentHateoasProcessor
    implements RepresentationModelProcessor<EntityModel<Content>> {

    @Override
    public EntityModel<Content> process(EntityModel<Content> model) {
        model.add(
            Link
                .of(model.getRequiredLink("self").getHref() + "draftcontent")
                .withRel("raftcontent")
        );
        model.add(
            Link
                .of(model.getRequiredLink("self").getHref() + "/updatecontent")
                .withRel("updatecontent")
        );
        model.add(
            Link
                .of(model.getRequiredLink("self").getHref() + "savecontent")
                .withRel("avecontent")
        );

        return model;
    }
}
