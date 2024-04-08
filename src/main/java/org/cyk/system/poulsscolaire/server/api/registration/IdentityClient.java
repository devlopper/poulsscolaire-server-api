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
import org.cyk.system.poulsscolaire.server.api.registration.IdentityService.GetManyResponseDto;
import org.cyk.system.poulsscolaire.server.api.registration.IdentityService.IdentityCreateRequestDto;
import org.cyk.system.poulsscolaire.server.api.registration.IdentityService.IdentityUpdateRequestDto;

/**
 * Cette classe représente un client de {@link IdentityService}.
 *
 * @author Christian
 *
 */
@ApplicationScoped
@Setter
@Accessors(chain = true, fluent = true)
public class IdentityClient extends AbstractClient<IdentityService>
    implements GetByIdentifier<IdentityDto>, GetMany<GetManyResponseDto>,
    DeleteByIdentifier<IdentifiableResponseDto> {

  @Override
  public IdentityClient service(IdentityService service) {
    return (IdentityClient) super.service(service);
  }

  /**
   * {@link IdentityService#create}.
   *
   * @param request requête
   * @return réponse
   */
  public CreateResponseDto create(IdentityCreateRequestDto request) {
    return new CreateExecutor(IdentityService.CREATE_IDENTIFIER)
        .execute(() -> service().create(request));
  }

  /**
   * {@link IdentityService#create}.
   *
   * @param firstName nom
   * @param lastNames prénoms
   * @param auditWho audit acteur
   * @param auditSession audit session
   * @return réponse
   */
  public CreateResponseDto create(String firstName, String lastNames, String genderIdentifier,
      String auditWho, String auditSession) {
    IdentityCreateRequestDto request = new IdentityCreateRequestDto();
    request.setFirstName(firstName);
    request.setLastNames(lastNames);
    request.setGenderIdentifier(genderIdentifier);
    request.setAuditWho(auditWho);
    request.setAuditSession(auditSession);
    return create(request);
  }

  public GetManyResponseDto getMany(GetManyRequestDto request) {
    return new GetOneExecutor<GetManyResponseDto>(GetManyResponseDto.class,
        IdentityService.GET_MANY_IDENTIFIER).execute(() -> service().getMany(request));
  }

  /**
   * {@link IdentityService#getMany}.
   *
   * @param projection projection
   * @param filter filtre
   * @param page page
   * @param auditWho audit acteur
   * @param auditSession audit session
   * @return réponse
   */
  public GetManyResponseDto getMany(ProjectionDto projection, FilterDto filter, PageDto page,
      String auditWho, String auditSession) {
    GetManyRequestDto request = new GetManyRequestDto();
    request.setProjection(projection);
    request.setFilter(filter);
    request.setPage(page);
    request.setAuditWho(auditWho);
    request.setAuditSession(auditSession);
    return getMany(request);
  }

  public IdentityDto getOne(GetOneRequestDto request) {
    return new GetOneExecutor<IdentityDto>(IdentityDto.class, IdentityService.GET_ONE_IDENTIFIER)
        .execute(() -> service().getOne(request));
  }

  /**
   * {@link IdentityService#getOne}.
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
   * {@link IdentityService#getByIdentifier}.
   *
   * @param request requête
   * @return groupe d'échéance
   */
  public IdentityDto getByIdentifier(GetByIdentifierRequestDto request) {
    return new GetOneExecutor<IdentityDto>(IdentityDto.class,
        IdentityService.GET_BY_IDENTIFIER_IDENTIFIER)
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
  public IdentityDto getByIdentifier(String identifier, ProjectionDto projection, String auditWho,
      String auditSession) {
    GetByIdentifierRequestDto request = new GetByIdentifierRequestDto();
    request.setIdentifier(identifier);
    request.setProjection(projection);
    request.setAuditWho(auditWho);
    request.setAuditSession(auditSession);
    return getByIdentifier(request);
  }

  public IdentifiableResponseDto update(IdentityUpdateRequestDto request) {
    return new IdentifiableExecutor(IdentityService.UPDATE_IDENTIFIER)
        .execute(() -> service().update(request));
  }

  /**
   * {@link IdentityService#update}.
   *
   * @param identifier identifiant
   * @param firstName nom
   * @param lastNames prénoms
   * @param auditWho audit acteur
   * @param auditSession audit session
   * @return réponse
   */
  public IdentifiableResponseDto update(String identifier, String firstName, String lastNames,
      String genderIdentifier, String auditWho, String auditSession) {
    IdentityUpdateRequestDto request = new IdentityUpdateRequestDto();
    request.setIdentifier(identifier);
    request.setFirstName(firstName);
    request.setLastNames(lastNames);
    request.setGenderIdentifier(genderIdentifier);
    request.setAuditWho(auditWho);
    request.setAuditSession(auditSession);
    return update(request);
  }

  public IdentifiableResponseDto delete(DeleteOneRequestDto request) {
    return new IdentifiableExecutor(IdentityService.DELETE_IDENTIFIER)
        .execute(() -> service().delete(request));
  }

  /**
   * {@link IdentityService#delete}.
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
