package org.cyk.system.poulsscolaire.server.api.fee;

import ci.gouv.dgbf.extension.server.service.api.request.RequestMapper;
import org.cyk.system.poulsscolaire.server.api.fee.StockService.StockCreateRequestDto;
import org.cyk.system.poulsscolaire.server.api.fee.StockService.StockUpdateRequestDto;
import org.mapstruct.Mapper;

/**
 * Cette interface représente le mapping de requête et {@link StockDto}.
 *
 * @author Christian
 *
 */
@Mapper
public interface StockRequestMapper extends RequestMapper<StockDto,
    StockCreateRequestDto, StockUpdateRequestDto> {

}
