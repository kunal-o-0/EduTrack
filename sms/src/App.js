import { Route, Routes } from "react-router-dom";
import Main from "./pages/Main";
import NotFound from "./pages/NotFound";
import Home from "./pages/Home";
import AboutUs from "./pages/AboutUs";
import ContactUs from "./pages/ContactUs";
import LoginRegister from "./pages/LoginRegister";
import Login from "./pages/Login";
import Register from "./pages/Register";
import ForgotPassword from "./pages/ForgotPassword";
import Dashboard from "./pages/Dashboard";
import Announcements from "./components/Announcements";
import Attendance from "./components/Attendance";
import Schedule from "./components/Schedule";
import Grades from "./components/Grades";
import Fees from "./components/Fees/Fees";
import PaymentDetails from "./components/Fees/PaymentDetails";
import PayFees from "./components/Fees/PayFees";
import FeesMain from "./components/Fees/FeesMain";

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
          <Route path="register" element={<Register />} exact />
          <Route path="forgot-password" element={<ForgotPassword />} exact />
        </Route>
        <Route path="*" element={<NotFound />} />
        <Route path="/dashboard" element={<Dashboard />} exact>
          <Route index element={<Announcements />} />
          <Route path="announcements" element={<Announcements />} exact />
          <Route path="attendance" element={<Attendance />} exact />
          <Route path="schedule" element={<Schedule />} exact />
          <Route path="grades" element={<Grades />} exact />
          <Route path="fees" element={<Fees />} exact>
            <Route index element={<FeesMain />} />
            <Route path="show-receipts" element={<PaymentDetails />} exact />
            <Route path="pay-fees" element={<PayFees />} exact />
          </Route>
        </Route>
      </Routes>
    </>
  );
}

export default App;
