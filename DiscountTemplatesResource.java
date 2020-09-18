package com.pelikantravel.discountTemplates.resource;

import com.pelikantravel.common.resource.EntityMongoResource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.threeten.bp.Instant;
import utils.shared.discountTemplate.DiscountTemplate;

import javax.ejb.Stateless;
import javax.validation.Valid;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

/**
 * @author Marek Tomas on 26.11.2019
 */
@Stateless
@Produces("application/json")
@Path("discount-templates")
public class DiscountTemplatesResource extends EntityMongoResource<DiscountTemplate> {

	private static final Logger log = LoggerFactory.getLogger(DiscountTemplatesResource.class);

	public DiscountTemplatesResource() {
		super(DiscountTemplate.class);
	}

	@Override
	public DiscountTemplate create(@Valid DiscountTemplate entity) {
		entity.setCreated(Instant.now());

		return super.create(entity);
	}

}
