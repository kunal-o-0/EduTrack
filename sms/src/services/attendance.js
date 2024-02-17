/**
 * Here date-and-time library is used for extracting information from date object as per our need
 * LINK- https://www.npmjs.com/package/date-and-time#formatdateobj-arg-utc
 */

import axios from "axios";
import { createUrl } from "./utils";
import dateUtil from "date-and-time";

//  function for creating attendance object based on fields in DB
export const createAttendObj = (
  attendId = "",
  attendStatus = "",
  attdenTimestamp = ""
) => {
  return { attendId, attendStatus, attdenTimestamp };
};

//  function for creating formatted data so that it can be directly placed in table
export const createAttendData = (date = "", day = "", status = "") => {
  return { date, day, status };
};

const getAttend = async (studId) => {
  const res = await axios.get(createUrl(`student/attendance/${studId}`));

  return res.data.payload.map((item) => {
    const timestamp = item.attdenTimestamp;

    //  creating date object by passing timestamp as parameter to constructor
    let dateTime = new Date(timestamp);

    //  D-> Date(Single digit) MM-> Month(Double digit) YYYYY-> Year
    let date = dateUtil.format(dateTime, "D-MM-YYYY");
    //  dddd-> Weekday name in full string
    let weekDay = dateUtil.format(dateTime, "dddd");
    return createAttendData(date, weekDay, item.attendStatus);
  });
};

export default getAttend;
