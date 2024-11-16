package org.cyk.system.poulsscolaire.server.api.accounting;

import ci.gouv.dgbf.extension.server.service.api.request.RequestMapper;
import org.cyk.system.poulsscolaire.server.api.accounting.BudgetService.BudgetCreateRequestDto;
import org.cyk.system.poulsscolaire.server.api.accounting.BudgetService.BudgetUpdateRequestDto;
import org.mapstruct.Mapper;

/**
 * Cette interface représente le mapping de requête et {@link BudgetDto}.
 *
 * @author Christian
 *
 */
@Mapper
public interface BudgetRequestMapper extends RequestMapper<BudgetDto,
    BudgetCreateRequestDto, BudgetUpdateRequestDto> {

}
