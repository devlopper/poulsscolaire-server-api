package org.cyk.system.poulsscolaire.server.api.accounting;

import ci.gouv.dgbf.extension.server.service.api.request.RequestMapper;
import org.cyk.system.poulsscolaire.server.api.accounting.AccountingPlanService.AccountingPlanCreateRequestDto;
import org.cyk.system.poulsscolaire.server.api.accounting.AccountingPlanService.AccountingPlanUpdateRequestDto;
import org.mapstruct.Mapper;

/**
 * Cette interface représente le mapping de requête et {@link AccountingPlanDto}.
 *
 * @author Christian
 *
 */
@Mapper
public interface AccountingPlanRequestMapper extends RequestMapper<AccountingPlanDto,
    AccountingPlanCreateRequestDto, AccountingPlanUpdateRequestDto> {

}
