import {
  AppBar,
  Box,
  Button,
  Container,
  Toolbar,
  Typography,
} from "@mui/material";
import Styles from "../assets/Style";
import BackgroundImg from "../assets/Images/blurred_background.jpg";
import { Link, Outlet, useNavigate } from "react-router-dom";

const appBarMenu = [
  { route: "/home", title: "Home" },
  { route: "/about-us", title: "About Us" },
  { route: "/contact-us", title: "Contact Us" },
];

function Main() {
  const navigate = useNavigate();

  const handleLogin = () => {
    navigate("/login-register");
  };

  return (
    <Box
      sx={{
        position: "fixed",
        width: "100%",
        overflowY: "auto",
      }}
    >
      {/* background image */}
      <img
        src={BackgroundImg}
        style={{
          position: "absolute",
          zIndex: "-10",
          width: "100%",
          maxHeight: "20rem",
        }}
      />
      <Typography
        variant="h1"
        sx={{
          fontSize: "3rem",
          position: "absolute",
          top: "5rem",
          textShadow: `0.5rem 0.5rem 0.9rem ${Styles.colors.primary_medium}`,
          color: Styles.colors.primary_dark,
          fontWeight: "900",
        }}
      >
        Student Management System
      </Typography>
      <Container
        sx={{
          position: "static",
          top: "20rem",
          marginTop: "20rem",
          minWidth: "100%",
          backgroundColor: Styles.colors.primary,
        }}
        disableGutters
      >
        <AppBar
          position="sticky"
          sx={{ backgroundColor: Styles.colors.secondary }}
        >
          <Container
            sx={{
              minWidth: "100%",
              padding: { sm: "0px" },
            }}
          >
            <Toolbar>
              <Box sx={{ width: "80%" }}>
                {/* generating appbar menu */}
                {appBarMenu.map((item) => {
                  return (
                    <Link to={item.route}>
                      <Button
                        variant="text"
                        size="large"
                        sx={{
                          height: "100%",
                          color: Styles.colors.primary,
                          ":hover": {
                            color: Styles.colors.primary_dark,
                            backgroundColor: Styles.colors.primary_medium,
                          },
                        }}
                        disableRipple
                      >
                        <Typography
                          variant="h5"
                          component="span"
                          sx={{
                            height: "100%",
                            textTransform: "initial",
                            fontSize: "1.5rem",
                          }}
                        >
                          {item.title}
                        </Typography>
                      </Button>
                    </Link>
                  );
                })}
              </Box>
              <Box
                sx={{
                  width: "20%",
                  display: { sm: "flex" },
                  flexDirection: "row",
                  justifyContent: "flex-end",
                }}
              >
                <Button
                  variant="text"
                  size="large"
                  onClick={handleLogin}
                  sx={{
                    height: "100%",
                    color: Styles.colors.primary,
                    ":hover": {
                      color: Styles.colors.primary,
                      backgroundColor: Styles.colors.primary_dark,
                    },
                  }}
                  disableRipple
                >
                  <Typography
                    variant="h5"
                    component="span"
                    sx={{
                      height: "100%",
                      textTransform: "initial",
                      fontSize: "1.4rem",
                      right: "0rem",
                    }}
                  >
                    Login/Register
                  </Typography>
                </Button>
              </Box>
            </Toolbar>
          </Container>
        </AppBar>
        <Outlet />
        {/* Footer starts here */}
        <Box
          sx={{
            height: "20rem",
            backgroundColor: Styles.colors.primary_dark,
            color: Styles.colors.primary,
            padding: "1rem",
            marginTop: "10rem",
          }}
          component="footer"
        >
          <Box
            sx={{
              display: "flex",
              flexDirection: "column",
            }}
          >
            <a
              href="#"
              style={{ textDecoration: "none", color: Styles.colors.primary }}
            >
              Contact Us
            </a>
            <a
              href="#"
              style={{
                textDecoration: "none",
                color: Styles.colors.primary,
                marginTop: "0.5rem",
              }}
            >
              About Us
            </a>
          </Box>
          <Typography variant="body1" component="p" sx={{ marginTop: "3rem" }}>
            © SMS 2024. All rights reserved.
          </Typography>
        </Box>
      </Container>
    </Box>
  );
}

export default Main;
