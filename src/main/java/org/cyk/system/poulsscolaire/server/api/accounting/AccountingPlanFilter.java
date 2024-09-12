package org.cyk.system.poulsscolaire.server.api.accounting;

import ci.gouv.dgbf.extension.server.service.api.AbstractIdentifiableFilter;
import ci.gouv.dgbf.extension.server.service.api.request.FilterDto;
import lombok.Getter;
import lombok.Setter;

/**
 * Cette classe représente le filtre de {@link AccountingPlanDto}.
 *
 * @author Christian
 *
 */
@Getter
@Setter
public class AccountingPlanFilter extends AbstractIdentifiableFilter {

  public AccountingPlanFilter(FilterDto dto) {
    super(dto);
  }

  public AccountingPlanFilter() {}

  @Override
  protected void doInitialize(FilterDto filter) {
    super.doInitialize(filter);
  }
}
