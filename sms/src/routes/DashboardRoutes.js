import { BrowserRouter, Route, Routes } from "react-router-dom";
import Announcements from "../components/Announcements";
import Attendance from "../components/Attendance";
import Schedule from "../components/Schedule";
import Grades from "../components/Grades";
import Fees from "../components/Fees/Fees";
import PaymentDetails from "../components/Fees/PaymentDetails";
import PayFees from "../components/Fees/PayFees";

function DashboardRoutes() {
  return (
    <Routes>
      <Route path="/announcements" element={<Announcements />} exact />
      <Route path="/attendance" element={<Attendance />} exact />
      <Route path="/schedule" element={<Schedule />} exact />
      <Route path="/grades" element={<Grades />} exact />
      <Route path="/fees" element={<Fees />} exact>
        <Route path="show-receipts" element={<PaymentDetails />} exact />
        <Route path="pay-fees" element={<PayFees />} exact />
      </Route>
    </Routes>
  );
}

export default DashboardRoutes;
