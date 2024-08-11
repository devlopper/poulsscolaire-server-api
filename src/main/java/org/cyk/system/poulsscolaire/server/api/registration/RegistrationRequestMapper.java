package org.cyk.system.poulsscolaire.server.api.registration;

import org.cyk.system.poulsscolaire.server.api.registration.RegistrationService.RegistrationCreateRequestDto;
import org.cyk.system.poulsscolaire.server.api.registration.RegistrationService.RegistrationUpdateRequestDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * Cette interface représente le mapping de requête et {@link RegistrationDto}.
 *
 * @author Christian
 *
 */
@Mapper
public interface RegistrationRequestMapper {
  
  RegistrationRequestMapper INSTANCE = Mappers.getMapper(RegistrationRequestMapper.class);

  RegistrationCreateRequestDto mapCreate(RegistrationDto entity);

  RegistrationUpdateRequestDto mapUpdate(RegistrationDto entity);
}
