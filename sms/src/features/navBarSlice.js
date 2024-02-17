/**
 * Navigation bar slice to store title, any other states
 */

import { createSlice } from "@reduxjs/toolkit";

export const navBarSlice = createSlice({
  name: "navBar",
  initialState: {
    title: "N/A",
  },
  reducers: {
    changeTitle: (state, action) => {
      state.title = action.payload.title;
    },
  },
});

export const { changeTitle } = navBarSlice.actions;

export default navBarSlice.reducer;
