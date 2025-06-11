package org.cyk.system.poulsscolaire.server.api.registration;

import ci.gouv.dgbf.extension.server.service.api.request.RequestMapper;
import org.cyk.system.poulsscolaire.server.api.registration.StockDistributionRegistrationService.StockDistributionRegistrationCreateRequestDto;
import org.cyk.system.poulsscolaire.server.api.registration.StockDistributionRegistrationService.StockDistributionRegistrationUpdateRequestDto;
import org.mapstruct.Mapper;

/**
 * Cette interface représente le mapping de requête et {@link StockDistributionRegistrationDto}.
 *
 * @author Christian
 *
 */
@Mapper
public interface StockDistributionRegistrationRequestMapper extends
    RequestMapper<StockDistributionRegistrationDto, StockDistributionRegistrationCreateRequestDto,
        StockDistributionRegistrationUpdateRequestDto> {

}
