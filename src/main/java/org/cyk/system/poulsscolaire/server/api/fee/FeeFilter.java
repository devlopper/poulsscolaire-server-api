package org.cyk.system.poulsscolaire.server.api.fee;

import ci.gouv.dgbf.extension.server.service.api.AbstractIdentifiableFilter;
import ci.gouv.dgbf.extension.server.service.api.request.FilterDto;
import lombok.Getter;
import lombok.Setter;

/**
 * Cette classe représente le filtre de {@link FeeDto}.
 *
 * @author Christian
 *
 */
@Getter
@Setter
public class FeeFilter extends AbstractIdentifiableFilter {

  String schoolingIdentifier;

  public FeeFilter(FilterDto dto) {
    super(dto);
  }

  public FeeFilter() {}

  @Override
  protected void doInitialize(FilterDto filter) {
    super.doInitialize(filter);
    schoolingIdentifier = getSchoolingIdentifier(filter);
  }

  @Override
  protected void toDto(FilterDto filter) {
    super.toDto(filter);
    setSchoolingIdentifier(filter, schoolingIdentifier);
  }

  public static void setSchoolingIdentifier(FilterDto filter, String identifier) {
    set(filter, JSON_SCHOOLING_IDENTIFIER, f -> f.getValueAsString(),
        f -> f.setValueAsString(identifier));
  }

  public static String getSchoolingIdentifier(FilterDto filter) {
    return get(filter, d -> d.getFieldValueAsStringByName(JSON_SCHOOLING_IDENTIFIER));
  }

  public static final String JSON_SCHOOLING_IDENTIFIER = FeeDto.JSON_SCHOOLING_IDENTIFIER;

}
