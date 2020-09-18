package com.pelikantravel.discountTemplates.resource;

import com.pelikantravel.common.resource.EntityMongoResource;
import org.jongo.MongoCursor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.shared.discountTemplate.TemplateDefinition;

import javax.ejb.Stateless;
import javax.validation.Valid;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Marek Tomas on 21.1.2020
 */
@Stateless
@Produces("application/json")
@Path("template-definitions")
public class TemplateDefinitionsResource extends EntityMongoResource<TemplateDefinition> {

	private static final Logger log = LoggerFactory.getLogger(TemplateDefinitionsResource.class);

	public TemplateDefinitionsResource() {
		super(TemplateDefinition.class);
	}

	@Override
	public TemplateDefinition create(@Valid TemplateDefinition entity) {
		return super.create(entity);
	}

	@GET
	@Path("/findByName/{name}")
	public TemplateDefinition find(@PathParam("name") String market) {
		return getRepository().getCollection().findOne("{name: #}", market.toUpperCase()).as(TemplateDefinition.class);
	}

	@GET
	@Path("/findAll")
	public List<TemplateDefinition> findAll() {
		MongoCursor<TemplateDefinition> as = getRepository().getCollection().find().as(TemplateDefinition.class);
		List<TemplateDefinition> result = new ArrayList<>();
		while (as.hasNext()){
			result.add(as.next());
		}
		return result;
	}
}
