package org.cyk.system.poulsscolaire.server.api.registration;

import org.cyk.system.poulsscolaire.server.api.registration.IdentityService.IdentityCreateRequestDto;
import org.cyk.system.poulsscolaire.server.api.registration.IdentityService.IdentityUpdateRequestDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * Cette interface représente le mapping de requête et {@link IdentityDto}.
 *
 * @author Christian
 *
 */
@Mapper
public interface IdentityRequestMapper {
  
  IdentityRequestMapper INSTANCE = Mappers.getMapper(IdentityRequestMapper.class);

  IdentityCreateRequestDto mapCreate(IdentityDto entity);

  IdentityUpdateRequestDto mapUpdate(IdentityDto entity);
}
