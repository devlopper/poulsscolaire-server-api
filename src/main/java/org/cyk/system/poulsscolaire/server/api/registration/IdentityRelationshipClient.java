package org.cyk.system.poulsscolaire.server.api.registration;

import ci.gouv.dgbf.extension.server.service.api.client.AbstractClient;
import ci.gouv.dgbf.extension.server.service.api.client.executor.CreateExecutor;
import ci.gouv.dgbf.extension.server.service.api.client.executor.GetOneExecutor;
import ci.gouv.dgbf.extension.server.service.api.client.executor.IdentifiableExecutor;
import ci.gouv.dgbf.extension.server.service.api.request.DeleteOneRequestDto;
import ci.gouv.dgbf.extension.server.service.api.request.FilterDto;
import ci.gouv.dgbf.extension.server.service.api.request.GetByIdentifierRequestDto;
import ci.gouv.dgbf.extension.server.service.api.request.GetManyRequestDto;
import ci.gouv.dgbf.extension.server.service.api.request.GetOneRequestDto;
import ci.gouv.dgbf.extension.server.service.api.request.PageDto;
import ci.gouv.dgbf.extension.server.service.api.request.ProjectionDto;
import ci.gouv.dgbf.extension.server.service.api.response.CreateResponseDto;
import ci.gouv.dgbf.extension.server.service.api.response.IdentifiableResponseDto;
import ci.gouv.dgbf.extension.server.service.api.segregation.DeleteByIdentifier;
import ci.gouv.dgbf.extension.server.service.api.segregation.GetByIdentifier;
import ci.gouv.dgbf.extension.server.service.api.segregation.GetMany;
import jakarta.enterprise.context.ApplicationScoped;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.cyk.system.poulsscolaire.server.api.registration.IdentityRelationshipService.IdentityRelationshipCreateRequestDto;
import org.cyk.system.poulsscolaire.server.api.registration.IdentityRelationshipService.IdentityRelationshipGetManyResponseDto;
import org.cyk.system.poulsscolaire.server.api.registration.IdentityRelationshipService.IdentityRelationshipUpdateRequestDto;

/**
 * Cette classe représente un client de {@link IdentityRelationshipService}.
 *
 * @author Christian
 *
 */
@ApplicationScoped
@Setter
@Accessors(chain = true, fluent = true)
public class IdentityRelationshipClient extends AbstractClient<IdentityRelationshipService>
    implements GetByIdentifier<IdentityRelationshipDto>,
    GetMany<IdentityRelationshipGetManyResponseDto>, DeleteByIdentifier<IdentifiableResponseDto> {

  @Override
  public IdentityRelationshipClient service(IdentityRelationshipService service) {
    return (IdentityRelationshipClient) super.service(service);
  }

  /**
   * {@link IdentityRelationshipService#create}.
   *
   * @param request requête
   * @return réponse
   */
  public CreateResponseDto create(IdentityRelationshipCreateRequestDto request) {
    return new CreateExecutor(IdentityRelationshipService.CREATE_IDENTIFIER)
        .execute(() -> service().create(request));
  }

  /**
   * {@link IdentityRelationshipService#getMany}.
   *
   * @param request requête
   * @return réponse
   */
  public IdentityRelationshipGetManyResponseDto getMany(GetManyRequestDto request) {
    return new GetOneExecutor<IdentityRelationshipGetManyResponseDto>(
        IdentityRelationshipGetManyResponseDto.class,
        IdentityRelationshipService.GET_MANY_IDENTIFIER).execute(() -> service().getMany(request));
  }

  /**
   * {@link IdentityRelationshipService#getMany}.
   *
   * @param projection projection
   * @param filter filtre
   * @param page page
   * @param auditWho audit acteur
   * @param auditSession audit session
   * @return réponse
   */
  public IdentityRelationshipGetManyResponseDto getMany(ProjectionDto projection, FilterDto filter,
      PageDto page, String auditWho, String auditSession) {
    GetManyRequestDto request = new GetManyRequestDto();
    request.setProjection(projection);
    request.setFilter(filter);
    request.setPage(page);
    request.setAuditWho(auditWho);
    request.setAuditSession(auditSession);
    return getMany(request);
  }

  public IdentityDto getOne(GetOneRequestDto request) {
    return new GetOneExecutor<IdentityDto>(IdentityDto.class,
        IdentityRelationshipService.GET_ONE_IDENTIFIER).execute(() -> service().getOne(request));
  }

  /**
   * {@link IdentityRelationshipService#getOne}.
   *
   * @param projection projection
   * @param filter filtre
   * @param auditWho audit acteur
   * @param auditSession audit session
   * @return réponse
   */
  public IdentityDto getOne(ProjectionDto projection, FilterDto filter, String auditWho,
      String auditSession) {
    GetOneRequestDto request = new GetOneRequestDto();
    request.setProjection(projection);
    request.setFilter(filter);
    request.setAuditWho(auditWho);
    request.setAuditSession(auditSession);
    return getOne(request);
  }

  /**
   * {@link IdentityRelationshipService#getByIdentifier}.
   *
   * @param request requête
   * @return groupe d'échéance
   */
  public IdentityRelationshipDto getByIdentifier(GetByIdentifierRequestDto request) {
    return new GetOneExecutor<IdentityRelationshipDto>(IdentityRelationshipDto.class,
        IdentityRelationshipService.GET_BY_IDENTIFIER_IDENTIFIER)
            .execute(() -> service().getByIdentifier(request));
  }

  /**
   * Cette méthode permet d'obtenir par identifiant un groupe d'échéance.
   *
   * @param identifier identifiant
   * @param projection projection
   * @param auditWho audit acteur
   * @param auditSession audit session
   * @return réponse
   */
  @Override
  public IdentityRelationshipDto getByIdentifier(String identifier, ProjectionDto projection,
      String auditWho, String auditSession) {
    GetByIdentifierRequestDto request = new GetByIdentifierRequestDto();
    request.setIdentifier(identifier);
    request.setProjection(projection);
    request.setAuditWho(auditWho);
    request.setAuditSession(auditSession);
    return getByIdentifier(request);
  }

  public IdentifiableResponseDto update(IdentityRelationshipUpdateRequestDto request) {
    return new IdentifiableExecutor(IdentityRelationshipService.UPDATE_IDENTIFIER)
        .execute(() -> service().update(request));
  }

  public IdentifiableResponseDto delete(DeleteOneRequestDto request) {
    return new IdentifiableExecutor(IdentityRelationshipService.DELETE_IDENTIFIER)
        .execute(() -> service().delete(request));
  }

  /**
   * {@link IdentityRelationshipService#delete}.
   *
   * @param identifier identifiant
   * @param auditWho audit acteur
   * @param auditSession audit session
   * @return réponse
   */
  public IdentifiableResponseDto deleteByIdentifier(String identifier, String auditWho,
      String auditSession) {
    DeleteOneRequestDto request = new DeleteOneRequestDto();
    request.setIdentifier(identifier);
    request.setAuditWho(auditWho);
    request.setAuditSession(auditSession);
    return delete(request);
  }
}
