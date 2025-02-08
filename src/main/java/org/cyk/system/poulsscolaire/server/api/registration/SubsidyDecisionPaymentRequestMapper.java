package org.cyk.system.poulsscolaire.server.api.registration;

import ci.gouv.dgbf.extension.server.service.api.request.RequestMapper;
import org.cyk.system.poulsscolaire.server.api.registration.SubsidyDecisionPaymentService.SubsidyDecisionPaymentCreateRequestDto;
import org.cyk.system.poulsscolaire.server.api.registration.SubsidyDecisionPaymentService.SubsidyDecisionPaymentUpdateRequestDto;
import org.mapstruct.Mapper;

/**
 * Cette interface représente le mapping de requête et {@link SubsidyDecisionPaymentDto}.
 *
 * @author Christian
 *
 */
@Mapper
public interface SubsidyDecisionPaymentRequestMapper
    extends RequestMapper<SubsidyDecisionPaymentDto, SubsidyDecisionPaymentCreateRequestDto,
        SubsidyDecisionPaymentUpdateRequestDto> {

}
