import axios from "axios";
import { createUrl } from "./utils";

function createAttend(attendId, attendStatus, attdenTimestamp) {
  return { attendId, attendStatus, attdenTimestamp };
}

const getAttend = async (studId) => {
  const res = await axios.get(createUrl(`student/${studId}`));

  return res.data.payload.map((item) => {
    return createAttend(item.attendId, item.attendStatus, item.attdenTimestamp);
  });
};

export default getAttend;
