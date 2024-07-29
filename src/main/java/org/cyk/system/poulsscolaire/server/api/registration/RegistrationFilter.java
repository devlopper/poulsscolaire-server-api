package org.cyk.system.poulsscolaire.server.api.registration;

import ci.gouv.dgbf.extension.server.service.api.AbstractIdentifiableFilter;
import ci.gouv.dgbf.extension.server.service.api.request.FilterDto;
import lombok.Getter;
import lombok.Setter;
import org.cyk.system.poulsscolaire.server.api.configuration.SchoolingDto;

/**
 * Cette classe représente le filtre de {@link RegistrationDto}.
 *
 * @author Christian
 *
 */
@Getter
@Setter
public class RegistrationFilter extends AbstractIdentifiableFilter {

  String schoolIdentifier;
  String periodIdentifier;

  public RegistrationFilter(FilterDto dto) {
    super(dto);
  }

  public RegistrationFilter() {}

  @Override
  protected void doInitialize(FilterDto filter) {
    super.doInitialize(filter);
    schoolIdentifier = getSchoolIdentifier(filter);
    periodIdentifier = getPeriodIdentifier(filter);
  }

  @Override
  protected void toDto(FilterDto filter) {
    super.toDto(filter);
    setSchoolIdentifier(filter, schoolIdentifier);
    setPeriodIdentifier(filter, periodIdentifier);
  }

  public static void setSchoolIdentifier(FilterDto filter, String identifier) {
    set(filter, JSON_SCHOOL_IDENTIFIER, f -> f.getValueAsString(),
        f -> f.setValueAsString(identifier));
  }

  public static String getSchoolIdentifier(FilterDto filter) {
    return get(filter, d -> d.getFieldValueAsStringByName(JSON_SCHOOL_IDENTIFIER));
  }

  public static void setPeriodIdentifier(FilterDto filter, String identifier) {
    set(filter, JSON_PERIOD_IDENTIFIER, f -> f.getValueAsString(),
        f -> f.setValueAsString(identifier));
  }

  public static String getPeriodIdentifier(FilterDto filter) {
    return get(filter, d -> d.getFieldValueAsStringByName(JSON_PERIOD_IDENTIFIER));
  }

  public static final String JSON_SCHOOL_IDENTIFIER = SchoolingDto.JSON_SCHOOL_IDENTIFIER;
  public static final String JSON_PERIOD_IDENTIFIER = SchoolingDto.JSON_PERIOD_IDENTIFIER;
}
