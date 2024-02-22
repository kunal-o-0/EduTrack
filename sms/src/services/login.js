import axios from "axios";
import { createUrl } from "./utils";
import { LOGIN_ROLES } from "../constants/loginRole";

export const authenticateUser = async ({ role, email, password }) => {
  if (role === LOGIN_ROLES.STUDENT) {
    console.log(role + "  " + email + "  " + password);
    const res = await axios.post(createUrl("student/login"), {
      email: `${email}`,
      password: `${password}`,
    });
    return res.data;
  } else {
    console.log(role + "  " + email + "  " + password);
    const res = await axios.post(createUrl("staff/login"), {
      email: `${email}`,
      password: `${password}`,
    });
    return res.data;
  }
};
