package org.cyk.system.poulsscolaire.server.api.registration;

import ci.gouv.dgbf.extension.server.service.api.request.RequestMapper;
import org.cyk.system.poulsscolaire.server.api.registration.SubsidyDecisionRegistrationService.SubsidyDecisionRegistrationCreateRequestDto;
import org.cyk.system.poulsscolaire.server.api.registration.SubsidyDecisionRegistrationService.SubsidyDecisionRegistrationUpdateRequestDto;
import org.mapstruct.Mapper;

/**
 * Cette interface représente le mapping de requête et {@link SubsidyDecisionRegistrationDto}.
 *
 * @author Christian
 *
 */
@Mapper
public interface SubsidyDecisionRegistrationRequestMapper
    extends RequestMapper<SubsidyDecisionRegistrationDto,
        SubsidyDecisionRegistrationCreateRequestDto, SubsidyDecisionRegistrationUpdateRequestDto> {

}
