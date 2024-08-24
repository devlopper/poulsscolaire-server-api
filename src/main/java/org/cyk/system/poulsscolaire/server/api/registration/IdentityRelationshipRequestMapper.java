package org.cyk.system.poulsscolaire.server.api.registration;

import org.cyk.system.poulsscolaire.server.api.registration.IdentityRelationshipService.IdentityRelationshipCreateRequestDto;
import org.cyk.system.poulsscolaire.server.api.registration.IdentityRelationshipService.IdentityRelationshipUpdateRequestDto;
import org.mapstruct.Mapper;

/**
 * Cette interface représente le mapping de requête et {@link IdentityRelationshipDto}.
 *
 * @author Christian
 *
 */
@Mapper
public interface IdentityRelationshipRequestMapper {

  IdentityRelationshipCreateRequestDto mapCreate(IdentityRelationshipDto entity);

  IdentityRelationshipUpdateRequestDto mapUpdate(IdentityRelationshipDto entity);
}
