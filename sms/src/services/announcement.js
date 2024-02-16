import axios from "axios";
import { createUrl } from "./utils";

function createAnnoun(
  announId,
  announType,
  announContent,
  announTimestamp,
  orgId
) {
  return { announId, announType, announContent, announTimestamp, orgId };
}

const getAnnouns = async () => {
  const response = await axios.get(createUrl("announcement"));

  return response.data.payload.map((item) => {
    return createAnnoun(
      item.announId,
      item.announType,
      item.announContent,
      item.announTimestamp,
      item.orgId
    );
  });
};

export default getAnnouns;
