import React from "react";
import ReactDOM from "react-dom/client";
import Dashboard from "./pages/Dashboard";
import { Provider } from "react-redux";
import { store } from "./store";
import App from "./App";
import { BrowserRouter } from "react-router-dom";

const root = ReactDOM.createRoot(document.getElementById("root"));

root.render(
  <BrowserRouter>
    <Provider store={store}>
      {/* <Dashboard /> */}
      <App />
    </Provider>
  </BrowserRouter>
);
