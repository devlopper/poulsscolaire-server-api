package org.cyk.system.poulsscolaire.server.api.registration;

import ci.gouv.dgbf.extension.server.service.api.request.RequestMapper;
import org.cyk.system.poulsscolaire.server.api.registration.SubsidyDecisionService.SubsidyDecisionCreateRequestDto;
import org.cyk.system.poulsscolaire.server.api.registration.SubsidyDecisionService.SubsidyDecisionUpdateRequestDto;
import org.mapstruct.Mapper;

/**
 * Cette interface représente le mapping de requête et {@link SubsidyDecisionDto}.
 *
 * @author Christian
 *
 */
@Mapper
public interface SubsidyDecisionRequestMapper extends RequestMapper<SubsidyDecisionDto,
    SubsidyDecisionCreateRequestDto, SubsidyDecisionUpdateRequestDto> {

}
