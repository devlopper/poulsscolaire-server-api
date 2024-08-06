package org.cyk.system.poulsscolaire.server.api.fee;

import org.cyk.system.poulsscolaire.server.api.fee.FeeCategoryService.FeeCategoryCreateRequestDto;
import org.cyk.system.poulsscolaire.server.api.fee.FeeCategoryService.FeeCategoryUpdateRequestDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * Cette interface représente le mapping de requête et {@link FeeCategoryDto}.
 *
 * @author Christian
 *
 */
@Mapper
public interface FeeCategoryRequestMapper {
  
  FeeCategoryRequestMapper INSTANCE = Mappers.getMapper(FeeCategoryRequestMapper.class);

  FeeCategoryCreateRequestDto mapCreate(FeeCategoryDto identity);

  FeeCategoryUpdateRequestDto mapUpdate(FeeCategoryDto identity);
}
