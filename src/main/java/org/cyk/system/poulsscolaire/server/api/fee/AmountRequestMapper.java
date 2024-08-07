package org.cyk.system.poulsscolaire.server.api.fee;

import org.cyk.system.poulsscolaire.server.api.fee.AmountService.AmountCreateRequestDto;
import org.cyk.system.poulsscolaire.server.api.fee.AmountService.AmountUpdateRequestDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * Cette interface représente le mapping de requête et {@link AmountDto}.
 *
 * @author Christian
 *
 */
@Mapper
public interface AmountRequestMapper {
  
  AmountRequestMapper INSTANCE = Mappers.getMapper(AmountRequestMapper.class);

  AmountCreateRequestDto mapCreate(AmountDto entity);

  AmountUpdateRequestDto mapUpdate(AmountDto entity);
}
