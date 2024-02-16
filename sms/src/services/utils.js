import { server } from "../config";

export const createUrl = (path) => {
  return `${server}${path}`;
};
