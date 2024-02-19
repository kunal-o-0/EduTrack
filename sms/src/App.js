import { Route, Routes } from "react-router-dom";
import Main from "./pages/Main";
import NotFound from "./pages/NotFound";
import Home from "./pages/Home";
import AboutUs from "./pages/AboutUs";
import ContactUs from "./pages/ContactUs";
import LoginRegister from "./pages/LoginRegister";
import Login from "./pages/Login";
import Register from "./pages/Register";

function App() {
  return (
    <>
      <Routes>
        <Route path="/" element={<Main />} exact>
          <Route index element={<Home />} />
          <Route path="home" element={<Home />} exact />
          <Route path="about-us" element={<AboutUs />} exaxt />
          <Route path="contact-us" element={<ContactUs />} exact />
        </Route>
        <Route path="/login-register" element={<LoginRegister />} exact>
          <Route index element={<Login />} />
          <Route path="register" element={<Register />} />
        </Route>
        <Route path="*" element={<NotFound />} />
      </Routes>
    </>
  );
}

export default App;
