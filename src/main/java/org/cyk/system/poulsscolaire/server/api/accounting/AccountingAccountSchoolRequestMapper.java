package org.cyk.system.poulsscolaire.server.api.accounting;

import ci.gouv.dgbf.extension.server.service.api.request.RequestMapper;
import org.cyk.system.poulsscolaire.server.api.accounting.AccountingAccountSchoolService.AccountingAccountSchoolCreateRequestDto;
import org.cyk.system.poulsscolaire.server.api.accounting.AccountingAccountSchoolService.AccountingAccountSchoolUpdateRequestDto;
import org.mapstruct.Mapper;

/**
 * Cette interface représente le mapping de requête et {@link AccountingAccountSchoolDto}.
 *
 * @author Christian
 *
 */
@Mapper
public interface AccountingAccountSchoolRequestMapper
    extends RequestMapper<AccountingAccountSchoolDto, AccountingAccountSchoolCreateRequestDto,
        AccountingAccountSchoolUpdateRequestDto> {

}
