import { Box, Button, TextField, Typography } from "@mui/material";
import Styles from "../assets/Style";
import { Link } from "react-router-dom";
import { useState } from "react";

function Register() {
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");

  const handleLogin = () => {
    console.log(email + "  " + password);
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
        <Typography
          sx={{
            fontSize: "2rem",
            fontWeight: "600",
            color: Styles.colors.secondary_dark,
          }}
        >
          Registration
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
          Register
        </Button>
        <div
          style={{
            textAlign: "center",
            width: "100%",
            fontSize: "1.1rem",
            marginTop: "0.5rem",
            color: Styles.colors.secondary_dark,
          }}
        >
          Already have account? Login{" "}
          <Link
            to="/login-register"
            style={{
              textDecoration: "none",
              color: Styles.colors.secondary,
              fontWeight: "900",
            }}
          >
            here
          </Link>
        </div>
      </Box>
    </Box>
  );
}

export default Register;
