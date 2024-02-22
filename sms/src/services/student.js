/**
 *
 *  THIS IS STUDENT SERVICE
 *
 *  Here date-and-time library is used for extracting information from date object as per our need
 *  LINK- https://www.npmjs.com/package/date-and-time#formatdateobj-arg-utc
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

//   Function for creating grade object
export const createGrade = (
  id = 0,
  subject = "",
  obtainedMarks = 0,
  totalMarks = 0,
  grades = ""
) => {
  return { id, subject, obtainedMarks, totalMarks, grades };
};

//  function for creating receipt
export const createReceipt = (
  id = "",
  details = "",
  amount = 0.0,
  timestamp = "",
  feesType = ""
) => {
  return { id, details, amount, timestamp, feesType };
};

//  function for creating pending fee object
export const createPendingFeeObj = (id = "", amount = 0.0, feesType = "") => {
  return { id, amount, feesType };
};

//  function for creating student
export const createStudObj = (
  id = -1,
  first_name = "",
  middle_name = "",
  last_name = "",
  mother_name = "",
  roll_no = -1,
  mob_no = "",
  blood_group = "",
  address = createAttendObj(),
  aadhaar_no = "",
  email = "",
  password = "",
  org_id = -1,
  course_id = -1
) => {
  return {
    id,
    first_name,
    middle_name,
    last_name,
    mother_name,
    roll_no,
    mob_no,
    blood_group,
    address,
    aadhaar_no,
    email,
    password,
    org_id,
    course_id,
  };
};

/**
 *  Attendance service starts here
 *  student id is required to fetch attendance
 */

export const getAttend = async (studId) => {
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
/**
 *  END
 */

/**
 *  Grades/Performance service
 *  Fetching grades of student with id passed as parameter
 */

export const getGrades = async (studId) => {
  const res = await axios.get(createUrl(`student/performance/${studId}`));

  return res.data.payload.map((item) => {
    return createGrade(
      item.perfId,
      item.subName,
      parseInt(item.marksObtained),
      parseInt(item.subTotalMarks),
      item.grades
    );
  });
};
/**
 *  END
 */

/**
 *  Transactions service
 *  used for fetching all the transactions made by student
 */

export const getReceipts = async (studId) => {
  const res = await axios.get(createUrl(`student/fees/get-trans/${studId}`));
  return res.data.payload.map((item) => {
    let timeStamp = new Date(item.transTimestamp);
    return createReceipt(
      item.transId,
      item.transDetails,
      parseFloat(item.transAmount),
      dateUtil.format(timeStamp, "ddd, DD-MM,YYYY hh:mm:ss A"),
      item.feesType
    );
  });
};
/**
 *  END
 */

/**
 *  Pending fees service
 *  used for fetching all the pending fees for student
 */

export const getPendingFees = async (studId) => {
  const res = await axios.get(createUrl(`student/fees/get-pending/${studId}`));
  return res.data.payload.map((item) => {
    return createPendingFeeObj(
      item.feesId,
      parseFloat(item.feesPending),
      item.feesType
    );
  });
};
/**
 *  END
 */

/**
 *  Get student list
 */
export const getStudents = async () => {
  const result = await axios.get(createUrl("student"));

  return result.data.payload.map((stud) => {
    return createStudObj(
      stud.studId,
      stud.studFName,
      stud.studMName,
      stud.studLName,
      stud.studMotherName,
      stud.studRollNo,
      stud.studMobNo,
      stud.studBloodGrp,
      createAttendObj(
        stud.addressLine,
        stud.city,
        stud.state,
        stud.country,
        stud.pincode
      ),
      stud.studAadhaarNo,
      stud.email,
      stud.password,
      stud.orgId,
      stud.courseId
    );
  });
};
/**
 *  END
 */
