package org.cyk.system.poulsscolaire.server.api.registration;

import ci.gouv.dgbf.extension.server.service.api.request.RequestMapper;
import org.cyk.system.poulsscolaire.server.api.registration.StockDistributionService.StockDistributionCreateRequestDto;
import org.cyk.system.poulsscolaire.server.api.registration.StockDistributionService.StockDistributionUpdateRequestDto;
import org.mapstruct.Mapper;

/**
 * Cette interface représente le mapping de requête et {@link StockDistributionDto}.
 *
 * @author Christian
 *
 */
@Mapper
public interface StockDistributionRequestMapper extends RequestMapper<StockDistributionDto,
    StockDistributionCreateRequestDto, StockDistributionUpdateRequestDto> {

}