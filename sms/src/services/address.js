export const createAddress = (
  address_line = "",
  city = "",
  state = "",
  country = "",
  pincode = 0
) => {
  return { address_line, city, state, country, pincode };
};
