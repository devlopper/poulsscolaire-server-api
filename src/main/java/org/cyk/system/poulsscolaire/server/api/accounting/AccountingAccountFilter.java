package org.cyk.system.poulsscolaire.server.api.accounting;

import ci.gouv.dgbf.extension.server.service.api.AbstractIdentifiableFilter;
import ci.gouv.dgbf.extension.server.service.api.request.FilterDto;
import lombok.Getter;
import lombok.Setter;

/**
 * Cette classe représente le filtre de {@link AccountingAccountDto}.
 *
 * @author Christian
 *
 */
@Getter
@Setter
public class AccountingAccountFilter extends AbstractIdentifiableFilter {
  public AccountingAccountFilter(FilterDto dto) {
    super(dto);
  }

  public AccountingAccountFilter() {}

  @Override
  protected void doInitialize(FilterDto filter) {
    super.doInitialize(filter);
  }
}
