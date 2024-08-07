package org.cyk.system.poulsscolaire.server.api.registration;

import org.cyk.system.poulsscolaire.server.api.registration.StudentService.StudentCreateRequestDto;
import org.cyk.system.poulsscolaire.server.api.registration.StudentService.StudentUpdateRequestDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * Cette interface représente le mapping de requête et {@link StudentDto}.
 *
 * @author Christian
 *
 */
@Mapper
public interface StudentRequestMapper {

  StudentRequestMapper INSTANCE = Mappers.getMapper(StudentRequestMapper.class);

  StudentCreateRequestDto mapCreate(StudentDto entity);

  StudentUpdateRequestDto mapUpdate(StudentDto entity);
}
