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
import org.cyk.system.poulsscolaire.server.api.payment.PaymentService;
import org.cyk.system.poulsscolaire.server.api.registration.SubsidyDecisionPaymentService.SubsidyDecisionPaymentCreateRequestDto;
import org.cyk.system.poulsscolaire.server.api.registration.SubsidyDecisionPaymentService.SubsidyDecisionPaymentGetManyResponseDto;
import org.cyk.system.poulsscolaire.server.api.registration.SubsidyDecisionPaymentService.SubsidyDecisionPaymentUpdateRequestDto;

/**
 * Cette classe représente un client de {@link SubsidyDecisionPaymentService}.
 *
 * @author Christian
 *
 */
@ApplicationScoped
@Setter
@Accessors(chain = true, fluent = true)
public class SubsidyDecisionPaymentClient extends AbstractClient<SubsidyDecisionPaymentService>
    implements GetByIdentifier<SubsidyDecisionPaymentDto>,
    GetMany<SubsidyDecisionPaymentGetManyResponseDto>, DeleteByIdentifier<IdentifiableResponseDto> {

  @Override
  public SubsidyDecisionPaymentClient service(SubsidyDecisionPaymentService service) {
    return (SubsidyDecisionPaymentClient) super.service(service);
  }

  /**
   * {@link SubsidyDecisionPaymentService#create}.
   *
   * @param request requête
   * @return réponse
   */
  public CreateResponseDto create(SubsidyDecisionPaymentCreateRequestDto request) {
    return new CreateExecutor(SubsidyDecisionPaymentService.CREATE_IDENTIFIER)
        .execute(() -> service().create(request));
  }

  /**
   * {@link PaymentService#create}.
   *
   * @param request requête
   * @return réponse
   */
  public SubsidyDecisionPaymentGetManyResponseDto getMany(GetManyRequestDto request) {
    return new GetOneExecutor<SubsidyDecisionPaymentGetManyResponseDto>(
        SubsidyDecisionPaymentGetManyResponseDto.class,
        SubsidyDecisionPaymentService.GET_MANY_IDENTIFIER)
            .execute(() -> service().getMany(request));
  }

  /**
   * {@link SubsidyDecisionPaymentService#getMany}.
   *
   * @param projection projection
   * @param filter filtre
   * @param page page
   * @param auditWho audit acteur
   * @param auditSession audit session
   * @return réponse
   */
  public SubsidyDecisionPaymentGetManyResponseDto getMany(ProjectionDto projection,
      FilterDto filter, PageDto page, String auditWho, String auditSession) {
    GetManyRequestDto request = new GetManyRequestDto();
    request.setProjection(projection);
    request.setFilter(filter);
    request.setPage(page);
    request.setAuditWho(auditWho);
    request.setAuditSession(auditSession);
    return getMany(request);
  }

  public SubsidyDecisionPaymentDto getOne(GetOneRequestDto request) {
    return new GetOneExecutor<SubsidyDecisionPaymentDto>(SubsidyDecisionPaymentDto.class,
        SubsidyDecisionPaymentService.GET_ONE_IDENTIFIER).execute(() -> service().getOne(request));
  }

  /**
   * {@link SubsidyDecisionPaymentService#getOne}.
   *
   * @param projection projection
   * @param filter filtre
   * @param auditWho audit acteur
   * @param auditSession audit session
   * @return réponse
   */
  public SubsidyDecisionPaymentDto getOne(ProjectionDto projection, FilterDto filter,
      String auditWho, String auditSession) {
    GetOneRequestDto request = new GetOneRequestDto();
    request.setProjection(projection);
    request.setFilter(filter);
    request.setAuditWho(auditWho);
    request.setAuditSession(auditSession);
    return getOne(request);
  }

  /**
   * {@link SubsidyDecisionPaymentService#getByIdentifier}.
   *
   * @param request requête
   * @return groupe d'échéance
   */
  public SubsidyDecisionPaymentDto getByIdentifier(GetByIdentifierRequestDto request) {
    return new GetOneExecutor<SubsidyDecisionPaymentDto>(SubsidyDecisionPaymentDto.class,
        SubsidyDecisionPaymentService.GET_BY_IDENTIFIER_IDENTIFIER)
            .execute(() -> service().getByIdentifier(request));
  }

  /**
   * {@link SubsidyDecisionPaymentService#getByIdentifier}.
   *
   * @param identifier identifiant
   * @param projection projection
   * @param auditWho audit acteur
   * @param auditSession audit session
   * @return réponse
   */
  @Override
  public SubsidyDecisionPaymentDto getByIdentifier(String identifier, ProjectionDto projection,
      String auditWho, String auditSession) {
    GetByIdentifierRequestDto request = new GetByIdentifierRequestDto();
    request.setIdentifier(identifier);
    request.setProjection(projection);
    request.setAuditWho(auditWho);
    request.setAuditSession(auditSession);
    return getByIdentifier(request);
  }

  public IdentifiableResponseDto update(SubsidyDecisionPaymentUpdateRequestDto request) {
    return new IdentifiableExecutor(SubsidyDecisionPaymentService.UPDATE_IDENTIFIER)
        .execute(() -> service().update(request));
  }

  public IdentifiableResponseDto delete(DeleteOneRequestDto request) {
    return new IdentifiableExecutor(SubsidyDecisionPaymentService.DELETE_IDENTIFIER)
        .execute(() -> service().delete(request));
  }

  /**
   * {@link SubsidyDecisionPaymentService#delete}.
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
