import axios from "axios";
import { createUrl } from "./utils";

export const getStudent = async ({ email, password }) => {
  const res = await axios.get(createUrl("student/login"), {
    params: { email: email, password: password },
  });

  console.log(res.data);
};
