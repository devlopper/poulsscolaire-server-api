package org.cyk.system.poulsscolaire.server.api.configuration;

import org.cyk.system.poulsscolaire.server.api.configuration.SchoolingService.SchoolingCreateRequestDto;
import org.cyk.system.poulsscolaire.server.api.configuration.SchoolingService.SchoolingUpdateRequestDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * Cette interface représente le mapping de requête et {@link SchoolingDto}.
 *
 * @author Christian
 *
 */
@Mapper
public interface SchoolingRequestMapper {
  
  SchoolingRequestMapper INSTANCE = Mappers.getMapper(SchoolingRequestMapper.class);

  SchoolingCreateRequestDto mapCreate(SchoolingDto entity);

  SchoolingUpdateRequestDto mapUpdate(SchoolingDto entity);
}
