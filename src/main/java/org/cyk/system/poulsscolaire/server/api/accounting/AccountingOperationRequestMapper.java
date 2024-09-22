package org.cyk.system.poulsscolaire.server.api.accounting;

import ci.gouv.dgbf.extension.server.service.api.request.RequestMapper;
import org.cyk.system.poulsscolaire.server.api.accounting.AccountingOperationService.AccountingOperationCreateRequestDto;
import org.cyk.system.poulsscolaire.server.api.accounting.AccountingOperationService.AccountingOperationUpdateRequestDto;
import org.mapstruct.Mapper;

/**
 * Cette interface représente le mapping de requête et {@link AccountingOperationDto}.
 *
 * @author Christian
 *
 */
@Mapper
public interface AccountingOperationRequestMapper extends RequestMapper<AccountingOperationDto,
    AccountingOperationCreateRequestDto, AccountingOperationUpdateRequestDto> {

}
