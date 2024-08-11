package org.cyk.system.poulsscolaire.server.api.payment;

import org.cyk.system.poulsscolaire.server.api.payment.PaymentService.PaymentCreateRequestDto;
import org.cyk.system.poulsscolaire.server.api.payment.PaymentService.PaymentUpdateRequestDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * Cette interface représente le mapping de requête et {@link PaymentDto}.
 *
 * @author Christian
 *
 */
@Mapper
public interface PaymentRequestMapper {
  
  PaymentRequestMapper INSTANCE = Mappers.getMapper(PaymentRequestMapper.class);

  PaymentCreateRequestDto mapCreate(PaymentDto entity);

  PaymentUpdateRequestDto mapUpdate(PaymentDto entity);
}
