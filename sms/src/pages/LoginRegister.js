import { Box } from "@mui/material";
import BackgroundImg from "../assets/Images/pushing-man-image.png";
import Styles from "../assets/Style";
import { Outlet } from "react-router-dom";

function LoginRegister() {
  return (
    <Box sx={{ display: "flex" }}>
      <Box
        sx={{
          display: { xs: "none", sm: "block" },
          width: "50%",
          backgroundColor: Styles.colors.primary_dark,
          backgroundImage: `url(${BackgroundImg})`,
          backgroundRepeat: "no-repeat",
          backgroundSize: "100%",
          backgroundPosition: "0rem 2rem",
        }}
      ></Box>
      <Outlet />
    </Box>
  );
}

export default LoginRegister;
