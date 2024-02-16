import { configureStore } from "@reduxjs/toolkit";
import navBarReducer from "./features/navBarSlice";

export const store = configureStore({
  reducer: { navBar: navBarReducer },
});
