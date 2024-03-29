package org.cyk.system.poulsscolaire.server.api;

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
import org.cyk.system.poulsscolaire.server.api.DueGroupService.DueGroupCreateRequestDto;
import org.cyk.system.poulsscolaire.server.api.DueGroupService.DueGroupUpdateRequestDto;
import org.cyk.system.poulsscolaire.server.api.DueGroupService.GetManyResponseDto;

/**
 * Cette classe représente un client de {@link DueGroupService}.
 *
 * @author Christian
 *
 */
@ApplicationScoped
@Setter
@Accessors(chain = true, fluent = true)
public class DueGroupClient extends AbstractClient<DueGroupService>
    implements GetByIdentifier<DueGroupDto>, GetMany<GetManyResponseDto>,
    DeleteByIdentifier<IdentifiableResponseDto> {

  @Override
  public DueGroupClient service(DueGroupService service) {
    return (DueGroupClient) super.service(service);
  }

  /**
   * Cette méthode permet de créer un groupe d'échéance.
   *
   * @param request requête
   * @return réponse
   */
  public CreateResponseDto create(DueGroupCreateRequestDto request) {
    return new CreateExecutor(DueGroupService.CREATE_IDENTIFIER)
        .execute(() -> service().create(request));
  }

  /**
   * Cette méthode permet de créer un groupe d'échéance.
   *
   * @param code code
   * @param name nom
   * @param auditWho audit acteur
   * @param auditSession audit session
   * @return réponse
   */
  public CreateResponseDto create(String code, String name, String auditWho, String auditSession) {
    DueGroupCreateRequestDto request = new DueGroupCreateRequestDto();
    request.setCode(code);
    request.setName(name);
    request.setAuditWho(auditWho);
    request.setAuditSession(auditSession);
    return create(request);
  }

  public GetManyResponseDto getMany(GetManyRequestDto request) {
    return new GetOneExecutor<GetManyResponseDto>(GetManyResponseDto.class,
        DueGroupService.GET_MANY_IDENTIFIER).execute(() -> service().getMany(request));
  }

  /**
   * Cette méthode permet d'obtenir des groupes d'échéance.
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

  public DueGroupDto getOne(GetOneRequestDto request) {
    return new GetOneExecutor<DueGroupDto>(DueGroupDto.class, DueGroupService.GET_ONE_IDENTIFIER)
        .execute(() -> service().getOne(request));
  }

  /**
   * Cette méthode permet d'obtenir un groupe d'échéance.
   *
   * @param projection projection
   * @param filter filtre
   * @param auditWho audit acteur
   * @param auditSession audit session
   * @return réponse
   */
  public DueGroupDto getOne(ProjectionDto projection, FilterDto filter, String auditWho,
      String auditSession) {
    GetOneRequestDto request = new GetOneRequestDto();
    request.setProjection(projection);
    request.setFilter(filter);
    request.setAuditWho(auditWho);
    request.setAuditSession(auditSession);
    return getOne(request);
  }

  /**
   * Cette méthode permet d'obtenir par identifiant un groupe d'échéance.
   *
   * @param request requête
   * @return groupe d'échéance
   */
  public DueGroupDto getByIdentifier(GetByIdentifierRequestDto request) {
    return new GetOneExecutor<DueGroupDto>(DueGroupDto.class,
        DueGroupService.GET_BY_IDENTIFIER_IDENTIFIER)
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
  public DueGroupDto getByIdentifier(String identifier, ProjectionDto projection, String auditWho,
      String auditSession) {
    GetByIdentifierRequestDto request = new GetByIdentifierRequestDto();
    request.setIdentifier(identifier);
    request.setProjection(projection);
    request.setAuditWho(auditWho);
    request.setAuditSession(auditSession);
    return getByIdentifier(request);
  }

  public IdentifiableResponseDto update(DueGroupUpdateRequestDto request) {
    return new IdentifiableExecutor(DueGroupService.UPDATE_IDENTIFIER)
        .execute(() -> service().update(request));
  }

  /**
   * Cette méthode permet de mettre à jour un groupe d'échéance.
   *
   * @param identifier identifiant
   * @param code code
   * @param name nom
   * @param auditWho audit acteur
   * @param auditSession audit session
   * @return réponse
   */
  public IdentifiableResponseDto update(String identifier, String code, String name,
      String auditWho, String auditSession) {
    DueGroupUpdateRequestDto request = new DueGroupUpdateRequestDto();
    request.setIdentifier(identifier);
    request.setCode(code);
    request.setName(name);
    request.setAuditWho(auditWho);
    request.setAuditSession(auditSession);
    return update(request);
  }

  public IdentifiableResponseDto delete(DeleteOneRequestDto request) {
    return new IdentifiableExecutor(DueGroupService.DELETE_IDENTIFIER)
        .execute(() -> service().delete(request));
  }

  /**
   * Cette méthode permet de supprimer un groupe d'échéance.
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
