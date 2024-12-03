package org.cyk.system.poulsscolaire.server.api.accounting;

import ci.gouv.dgbf.extension.server.service.api.request.RequestMapper;
import org.cyk.system.poulsscolaire.server.api.accounting.FundingService.FundingCreateRequestDto;
import org.cyk.system.poulsscolaire.server.api.accounting.FundingService.FundingUpdateRequestDto;
import org.mapstruct.Mapper;

/**
 * Cette interface représente le mapping de requête et {@link FundingDto}.
 *
 * @author Christian
 *
 */
@Mapper
public interface FundingRequestMapper extends RequestMapper<FundingDto,
    FundingCreateRequestDto, FundingUpdateRequestDto> {

}
