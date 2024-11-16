package org.cyk.system.poulsscolaire.server.api.accounting;

import ci.gouv.dgbf.extension.server.service.api.request.RequestMapper;
import org.cyk.system.poulsscolaire.server.api.accounting.BudgetLineService.BudgetLineCreateRequestDto;
import org.cyk.system.poulsscolaire.server.api.accounting.BudgetLineService.BudgetLineUpdateRequestDto;
import org.mapstruct.Mapper;

/**
 * Cette interface représente le mapping de requête et {@link BudgetLineDto}.
 *
 * @author Christian
 *
 */
@Mapper
public interface BudgetLineRequestMapper extends RequestMapper<BudgetLineDto,
    BudgetLineCreateRequestDto, BudgetLineUpdateRequestDto> {

}
