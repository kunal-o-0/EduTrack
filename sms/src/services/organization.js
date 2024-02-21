import axios from "axios";
import { createUrl } from "./utils";
import { createAddress } from "./address";

export const createOrganizObj = (
  org_id = -1,
  org_name = "",
  org_type = "",
  org_address = createAddress(),
  head_id = -1
) => {
  return { org_id, org_name, org_type, org_address, head_id };
};

export const getOrganization = async () => {
  const result = await axios.get(createUrl("organization"));
  return result.data.payload.map((item) => {
    return createOrganizObj(
      item.orgId,
      item.orgName,
      item.orgType,
      createAddress(
        item.orgAddress.addressLine,
        item.orgAddress.city,
        item.orgAddress.state,
        item.orgAddress.country,
        item.orgAddress.pincode
      ),
      item.headId
    );
  });
};
