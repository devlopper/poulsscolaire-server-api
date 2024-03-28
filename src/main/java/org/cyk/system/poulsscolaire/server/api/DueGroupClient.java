package org.cyk.system.poulsscolaire.server.api;

import ci.gouv.dgbf.extension.server.service.api.client.AbstractClient;
import ci.gouv.dgbf.extension.server.service.api.client.executor.CreateExecutor;
import ci.gouv.dgbf.extension.server.service.api.client.executor.GetOneExecutor;
import ci.gouv.dgbf.extension.server.service.api.client.executor.IdentifiableExecutor;
import ci.gouv.dgbf.extension.server.service.api.entity.AbstractIdentifiableDto;
import ci.gouv.dgbf.extension.server.service.api.request.DeleteOneRequestDto;
import ci.gouv.dgbf.extension.server.service.api.request.FieldDto;
import ci.gouv.dgbf.extension.server.service.api.request.FilterDto;
import ci.gouv.dgbf.extension.server.service.api.request.FilterDto.CriteriaDto;
import ci.gouv.dgbf.extension.server.service.api.request.GetManyRequestDto;
import ci.gouv.dgbf.extension.server.service.api.request.GetOneRequestDto;
import ci.gouv.dgbf.extension.server.service.api.request.PageDto;
import ci.gouv.dgbf.extension.server.service.api.request.ProjectionDto;
import ci.gouv.dgbf.extension.server.service.api.response.CreateResponseDto;
import ci.gouv.dgbf.extension.server.service.api.response.IdentifiableResponseDto;
import jakarta.enterprise.context.ApplicationScoped;
import java.util.Set;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.cyk.system.poulsscolaire.server.api.DueGroupService.DueGroupCreateRequestDto;
import org.cyk.system.poulsscolaire.server.api.DueGroupService.DueGroupUpdateRequestDto;
import org.cyk.system.poulsscolaire.server.api.DueGroupService.GetManyResponseDto;

/**
 * Cette classe représente un client du service DueGroupService.
 *
 * @author Christian
 *
 */
@ApplicationScoped
@Setter
@Accessors(chain = true, fluent = true)
public class DueGroupClient extends AbstractClient<DueGroupService> {
  
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
   * Cette méthode permet d'obtenir un groupe d'échéance.
   *
   * @param identifier identifiant
   * @param projection projection
   * @param auditWho audit acteur
   * @param auditSession audit session
   * @return réponse
   */
  public DueGroupDto getByIdentifier(String identifier, ProjectionDto projection, String auditWho,
      String auditSession) {
    GetOneRequestDto request = new GetOneRequestDto();
    request.setProjection(projection);
    request.setFilter(new FilterDto());
    CriteriaDto criteria = new CriteriaDto();
    criteria.setField(new FieldDto());
    criteria.getField().setName(AbstractIdentifiableDto.JSON_IDENTIFIER);
    criteria.getField().setValueAsString(identifier);
    request.getFilter().setCriterias(Set.of(criteria));
    request.setAuditWho(auditWho);
    request.setAuditSession(auditSession);
    return getOne(request);
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
