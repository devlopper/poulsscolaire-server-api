package org.cyk.system.poulsscolaire.server.api.accounting;

import ci.gouv.dgbf.extension.server.service.api.request.RequestMapper;
import org.cyk.system.poulsscolaire.server.api.accounting.StockMovementService.StockMovementCreateRequestDto;
import org.cyk.system.poulsscolaire.server.api.accounting.StockMovementService.StockMovementUpdateRequestDto;
import org.mapstruct.Mapper;

/**
 * Cette interface représente le mapping de requête et {@link StockMovementDto}.
 *
 * @author Christian
 *
 */
@Mapper
public interface StockMovementRequestMapper extends RequestMapper<StockMovementDto,
    StockMovementCreateRequestDto, StockMovementUpdateRequestDto> {

}
