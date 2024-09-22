package org.cyk.system.poulsscolaire.server.api.accounting;

import ci.gouv.dgbf.extension.server.service.api.request.RequestMapper;
import org.cyk.system.poulsscolaire.server.api.accounting.AccountingAccountOperationService.AccountingAccountOperationCreateRequestDto;
import org.cyk.system.poulsscolaire.server.api.accounting.AccountingAccountOperationService.AccountingAccountOperationUpdateRequestDto;
import org.mapstruct.Mapper;

/**
 * Cette interface représente le mapping de requête et {@link AccountingAccountOperationDto}.
 *
 * @author Christian
 *
 */
@Mapper
public interface AccountingAccountOperationRequestMapper
    extends RequestMapper<AccountingAccountOperationDto, AccountingAccountOperationCreateRequestDto,
        AccountingAccountOperationUpdateRequestDto> {

}
