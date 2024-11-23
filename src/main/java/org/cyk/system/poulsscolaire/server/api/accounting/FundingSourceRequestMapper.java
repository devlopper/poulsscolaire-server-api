package org.cyk.system.poulsscolaire.server.api.accounting;

import ci.gouv.dgbf.extension.server.service.api.request.RequestMapper;
import org.cyk.system.poulsscolaire.server.api.accounting.FundingSourceService.FundingSourceCreateRequestDto;
import org.cyk.system.poulsscolaire.server.api.accounting.FundingSourceService.FundingSourceUpdateRequestDto;
import org.mapstruct.Mapper;

/**
 * Cette interface représente le mapping de requête et {@link FundingSourceDto}.
 *
 * @author Christian
 *
 */
@Mapper
public interface FundingSourceRequestMapper extends RequestMapper<FundingSourceDto,
    FundingSourceCreateRequestDto, FundingSourceUpdateRequestDto> {

}
