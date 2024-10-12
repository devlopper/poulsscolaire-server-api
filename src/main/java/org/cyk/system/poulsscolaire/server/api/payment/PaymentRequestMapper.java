package org.cyk.system.poulsscolaire.server.api.payment;

import ci.gouv.dgbf.extension.server.service.api.request.RequestMapper;
import org.cyk.system.poulsscolaire.server.api.payment.PaymentService.PaymentCreateRequestDto;
import org.cyk.system.poulsscolaire.server.api.payment.PaymentService.PaymentUpdateRequestDto;
import org.mapstruct.Mapper;

/**
 * Cette interface représente le mapping de requête et {@link PaymentDto}.
 *
 * @author Christian
 *
 */
@Mapper
public interface PaymentRequestMapper
    extends RequestMapper<PaymentDto, PaymentCreateRequestDto, PaymentUpdateRequestDto> {

}
