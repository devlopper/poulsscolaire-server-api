package org.cyk.system.poulsscolaire.server.api.fee;

import org.cyk.system.poulsscolaire.server.api.fee.FeeService.FeeCreateRequestDto;
import org.cyk.system.poulsscolaire.server.api.fee.FeeService.FeeUpdateRequestDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * Cette interface représente le mapping de requête et {@link FeeDto}.
 *
 * @author Christian
 *
 */
@Mapper
public interface FeeRequestMapper {
  
  FeeRequestMapper INSTANCE = Mappers.getMapper(FeeRequestMapper.class);

  FeeCreateRequestDto mapCreate(FeeDto entity);

  FeeUpdateRequestDto mapUpdate(FeeDto entity);
}
