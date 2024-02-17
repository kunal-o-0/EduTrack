/**
 * Creating redux-Store for storing global states inside it
 */

import { configureStore } from "@reduxjs/toolkit";
import navBarReducer from "./features/navBarSlice";

export const store = configureStore({
  reducer: { navBar: navBarReducer },
});
