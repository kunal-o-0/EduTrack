import { Route, Routes } from "react-router-dom";
import Home from "../pages/Home";
import ContactUs from "../pages/ContactUs";
import AboutUs from "../pages/AboutUs";

function IndexRoutes() {
  return (
    <Routes>
      <Route path="/" element={<Home />} exact />
      <Route path="/home" element={<Home />} exact />
      <Route path="/about-us" element={<AboutUs />} exaxt />
      <Route path="/contact-us" element={<ContactUs />} exact />
    </Routes>
  );
}

export default IndexRoutes;
