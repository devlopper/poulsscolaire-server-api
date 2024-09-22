package org.cyk.system.poulsscolaire.server.api.accounting;

import ci.gouv.dgbf.extension.server.service.api.request.RequestMapper;
import org.cyk.system.poulsscolaire.server.api.accounting.AccountingAccountService.AccountingAccountCreateRequestDto;
import org.cyk.system.poulsscolaire.server.api.accounting.AccountingAccountService.AccountingAccountUpdateRequestDto;
import org.mapstruct.Mapper;

/**
 * Cette interface représente le mapping de requête et {@link AccountingAccountDto}.
 *
 * @author Christian
 *
 */
@Mapper
public interface AccountingAccountRequestMapper extends RequestMapper<AccountingAccountDto,
    AccountingAccountCreateRequestDto, AccountingAccountUpdateRequestDto> {

}
