/*
 *************************************************************************
 * The contents of this file are subject to the Openbravo  Public  License
 * Version  1.1  (the  "License"),  being   the  Mozilla   Public  License
 * Version 1.1  with a permitted attribution clause; you may not  use this
 * file except in compliance with the License. You  may  obtain  a copy of
 * the License at http://www.openbravo.com/legal/license.html
 * Software distributed under the License  is  distributed  on  an "AS IS"
 * basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
 * License for the specific  language  governing  rights  and  limitations
 * under the License.
 * The Original Code is Openbravo ERP.
 * The Initial Developer of the Original Code is Openbravo SLU 
 * All portions are Copyright (C) 2019 Openbravo SLU
 * All Rights Reserved.
 * Contributor(s):  ______________________________________.
 ************************************************************************
 */
package org.openbravo.scheduling.trigger;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.openbravo.erpCommon.utility.StringCollectionUtils;
import org.quartz.CronTrigger;
import org.quartz.TriggerBuilder;

/**
 * A generator of Quartz's Triggers with weekly frequency.
 */
class WeeklyTriggerGenerator extends ScheduledTriggerGenerator {

  @Override
  TriggerBuilder<CronTrigger> getScheduledBuilder(TriggerData data) throws ParseException {
    List<String> days = getScheduledDays(data);

    if (days.isEmpty()) {
      throw new ParseException("At least one day must be selected.", -1);
    }

    String cronExpression = getCronTime(data) + " ? * "
        + StringCollectionUtils.commaSeparated(days, false);
    return cronScheduledTriggerBuilder(cronExpression);
  }

  private List<String> getScheduledDays(TriggerData data) {
    List<String> days = new ArrayList<>();
    if (data.daySun.equals("Y")) {
      days.add("SUN");
    }
    if (data.dayMon.equals("Y")) {
      days.add("MON");
    }
    if (data.dayTue.equals("Y")) {
      days.add("TUE");
    }
    if (data.dayWed.equals("Y")) {
      days.add("WED");
    }
    if (data.dayThu.equals("Y")) {
      days.add("THU");
    }
    if (data.dayFri.equals("Y")) {
      days.add("FRI");
    }
    if (data.daySat.equals("Y")) {
      days.add("SAT");
    }
    return days;
  }

}
