package org.cyk.system.poulsscolaire.server.api.accounting;

import ci.gouv.dgbf.extension.server.service.api.request.RequestMapper;
import org.cyk.system.poulsscolaire.server.api.accounting.AccountingOperationAccountService.AccountingOperationAccountCreateRequestDto;
import org.cyk.system.poulsscolaire.server.api.accounting.AccountingOperationAccountService.AccountingOperationAccountUpdateRequestDto;
import org.mapstruct.Mapper;

/**
 * Cette interface représente le mapping de requête et {@link AccountingOperationAccountDto}.
 *
 * @author Christian
 *
 */
@Mapper
public interface AccountingOperationAccountRequestMapper
    extends RequestMapper<AccountingOperationAccountDto, AccountingOperationAccountCreateRequestDto,
        AccountingOperationAccountUpdateRequestDto> {

}
