package org.cyk.system.poulsscolaire.server.api.configuration;

import ci.gouv.dgbf.extension.server.service.api.request.RequestMapper;
import org.cyk.system.poulsscolaire.server.api.configuration.SchoolConfigurationService.SchoolConfigurationCreateRequestDto;
import org.cyk.system.poulsscolaire.server.api.configuration.SchoolConfigurationService.SchoolConfigurationUpdateRequestDto;
import org.mapstruct.Mapper;

/**
 * Cette interface représente le mapping de requête et {@link SchoolConfigurationDto}.
 *
 * @author Christian
 *
 */
@Mapper
public interface SchoolConfigurationRequestMapper extends RequestMapper<SchoolConfigurationDto,
    SchoolConfigurationCreateRequestDto, SchoolConfigurationUpdateRequestDto> {
  
}
