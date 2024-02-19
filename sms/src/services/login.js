import axios from "axios";
import { createUrl } from "./utils";

export const authenticateStud = async ({ email, password }) => {
  const res = await axios.post(createUrl("student/login"), {
    email: `${email}`,
    password: `${password}`,
  });

  return res.data;
};
