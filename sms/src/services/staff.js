import axios from "axios";
import { createUrl } from "./utils";
import { createAddress } from "./address";

export const createStaff = (
  first_name = "",
  middle_name = "",
  last_name = "",
  mob_no = "",
  address = createAddress(),
  qualification = "",
  category = "",
  email = "",
  password = "",
  org_id = -1
) => {
  return {
    first_name,
    middle_name,
    last_name,
    mob_no,
    address,
    qualification,
    category,
    email,
    password,
    org_id,
  };
};

export const addStaff = async (staff = createStaff()) => {
  const result = await axios.post(createUrl("staff"), {
    staffFName: staff.first_name,
    staffMName: staff.middle_name,
    staffLName: staff.last_name,
    staffMobNo: staff.mob_no,
    staffAddress: {
      addressLine: staff.address.address_line,
      city: staff.address.city,
      state: staff.address.state,
      country: staff.address.country,
      pincode: staff.address.pincode,
    },
    staffQualif: staff.qualification,
    staffCategory: staff.category,
    email: staff.email,
    password: staff.password,
    orgId: staff.org_id,
  });

  return result.data;
};
