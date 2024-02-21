import {
  Alert,
  Box,
  Button,
  FormControl,
  InputLabel,
  MenuItem,
  MenuList,
  Select,
  TextField,
  Typography,
} from "@mui/material";
import Styles from "../assets/Style";
import { Link, useNavigate } from "react-router-dom";
import { useEffect, useState } from "react";
import { authenticateStud } from "../services/login";
import { LOGIN_ROLES } from "../constants/loginRole";

function Login() {
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
  //  this state for toggling visibility of alert component
  const [isInvalid, setIsInvalid] = useState(false);
  //  state to track whether role selected from menu
  const [isRoleSelected, setIsRoleSelected] = useState(false);
  //  state to store role for login
  const [role, setRole] = useState("");
  const navigate = useNavigate();

  const handleLogin = () => {
    authenticateStud({ email, password })
      .then((result) => {
        //  successful login
        document.cookie = `user=${JSON.stringify(result)}`;

        navigate("/dashboard");
      })
      .catch((error) => {
        //  alert component set visible for 3sec
        // console.log(jwt);
        setIsInvalid(true);
        setTimeout(() => {
          setIsInvalid(false);
        }, 3000);
      });
  };

  const roleSelectionHandler = (event) => {
    setRole(event.target.value);
    setIsRoleSelected(true);
  };

  return (
    <Box
      sx={{
        width: { xs: "100%", sm: "50%" },
        padding: "3rem",
        backgroundColor: Styles.colors.primary,
      }}
    >
      <Box
        sx={{
          display: "flex",
          flexDirection: "column",
          alignItems: "center",
          padding: "1rem",
        }}
      >
        {!isRoleSelected ? (
          <>
            <Typography sx={{ fontSize: "2rem" }}>What's your role?</Typography>
            <FormControl fullWidth sx={{ marginTop: "1.5rem" }}>
              <InputLabel id="input-role-label">Select role</InputLabel>
              <Select
                labelId="input-role-label"
                label="Select role"
                value={role}
                sx={{
                  color: Styles.colors.primary_dark,
                }}
                onChange={roleSelectionHandler}
              >
                <MenuItem value={LOGIN_ROLES.ADMIN}>Admin</MenuItem>
                <MenuItem value={LOGIN_ROLES.STUDENT}>Student</MenuItem>
              </Select>
            </FormControl>
          </>
        ) : (
          <>
            <Alert
              variant="filled"
              severity="error"
              sx={{ width: "100%", display: isInvalid ? "flex" : "none" }}
            >
              Invalid credentials
            </Alert>
            <Typography
              sx={{
                fontSize: "2rem",
                fontWeight: "600",
                color: Styles.colors.secondary_dark,
              }}
            >
              {role}
            </Typography>
            <TextField
              label="Email address"
              sx={{ width: "100%", marginTop: "1rem" }}
              value={email}
              onChange={(event) => {
                setEmail(event.target.value);
              }}
              required
            />
            <TextField
              label="Password"
              sx={{ width: "100%", marginTop: "1rem" }}
              value={password}
              onChange={(event) => {
                setPassword(event.target.value);
              }}
              required
            />
            <div
              style={{
                textAlign: "right",
                width: "100%",
                marginTop: "0.5rem",
              }}
            >
              <Link
                to="forgot-password"
                style={{
                  textDecoration: "underline",
                  fontSize: "1rem",
                  fontWeight: "300",
                  color: Styles.colors.secondary_dark,
                }}
              >
                Forgot password?
              </Link>
            </div>
            <Button
              size="large"
              sx={{
                backgroundColor: Styles.colors.secondary,
                color: Styles.colors.primary,
                fontWeight: "900",
                fontSize: "1.1rem",
                width: "100%",
                marginTop: "1rem",
                ":hover": { backgroundColor: Styles.colors.secondary_dark },
              }}
              onClick={handleLogin}
            >
              Login
            </Button>
            <div
              style={{
                display: role === LOGIN_ROLES.ADMIN ? "block" : "none",
                textAlign: "center",
                width: "100%",
                fontSize: "1.1rem",
                marginTop: "0.5rem",
                color: Styles.colors.secondary_dark,
              }}
            >
              Don't have account? Resgister{" "}
              <Link
                to="register"
                style={{
                  textDecoration: "none",
                  color: Styles.colors.secondary,
                  fontWeight: "900",
                }}
              >
                here
              </Link>
            </div>
          </>
        )}
      </Box>
    </Box>
  );
}

export default Login;
