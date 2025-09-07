package org.cyk.system.poulsscolaire.server.api.fee;

import ci.gouv.dgbf.extension.server.service.api.request.RequestMapper;
import org.cyk.system.poulsscolaire.server.api.fee.StockFeeCategoryService.StockFeeCategoryCreateRequestDto;
import org.cyk.system.poulsscolaire.server.api.fee.StockFeeCategoryService.StockFeeCategoryUpdateRequestDto;
import org.mapstruct.Mapper;

/**
 * Cette interface représente le mapping de requête et {@link StockFeeCategoryDto}.
 *
 * @author Christian
 *
 */
@Mapper
public interface StockFeeCategoryRequestMapper extends RequestMapper<StockFeeCategoryDto,
    StockFeeCategoryCreateRequestDto, StockFeeCategoryUpdateRequestDto> {

}
