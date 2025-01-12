package org.cyk.system.poulsscolaire.server.api.accounting;

import ci.gouv.dgbf.extension.server.service.api.request.RequestMapper;
import org.cyk.system.poulsscolaire.server.api.accounting.FundingExecutionService.FundingExecutionCreateRequestDto;
import org.cyk.system.poulsscolaire.server.api.accounting.FundingExecutionService.FundingExecutionUpdateRequestDto;
import org.mapstruct.Mapper;

/**
 * Cette interface représente le mapping de requête et {@link FundingExecutionDto}.
 *
 * @author Christian
 *
 */
@Mapper
public interface FundingExecutionRequestMapper extends RequestMapper<FundingExecutionDto,
    FundingExecutionCreateRequestDto, FundingExecutionUpdateRequestDto> {

}
