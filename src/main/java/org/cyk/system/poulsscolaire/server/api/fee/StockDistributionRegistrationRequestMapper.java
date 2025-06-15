package org.cyk.system.poulsscolaire.server.api.fee;

import ci.gouv.dgbf.extension.server.service.api.request.RequestMapper;
import org.cyk.system.poulsscolaire.server.api.fee.StockDistributionRegistrationService.StockDistributionRegistrationCreateRequestDto;
import org.cyk.system.poulsscolaire.server.api.fee.StockDistributionRegistrationService.StockDistributionRegistrationUpdateRequestDto;
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
