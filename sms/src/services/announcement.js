import axios from "axios";

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
  const response = await axios.get("http://localhost:8080/announcement");

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
