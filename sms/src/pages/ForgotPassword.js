import { Box, Button, TextField, Typography } from "@mui/material";
import Styles from "../assets/Style";
import { Link } from "react-router-dom";
import { useState } from "react";

function ForgotPassword() {
  const [email, setEmail] = useState("");
  const [newPasswd, setNewPasswd] = useState("");
  const [retypedNewPasswd, setRetypedNewPasswd] = useState("");

  const handleLogin = () => {
    if (newPasswd === retypedNewPasswd)
      console.log(email + "  " + newPasswd + "   " + retypedNewPasswd);
    else console.log("Password doesn't match");
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
          Reset Password
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
          label="New password"
          sx={{ width: "100%", marginTop: "1rem" }}
          value={newPasswd}
          onChange={(event) => {
            setNewPasswd(event.target.value);
          }}
          required
        />
        <TextField
          label="Re-enter new password"
          sx={{ width: "100%", marginTop: "1rem" }}
          value={retypedNewPasswd}
          onChange={(event) => {
            setRetypedNewPasswd(event.target.value);
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
          Reset
        </Button>
        <div
          style={{
            textAlign: "center",
            width: "100%",
            fontSize: "1.2rem",
            marginTop: "1rem",
            color: Styles.colors.secondary_dark,
          }}
        >
          <Link
            to="/login-register"
            style={{
              textDecoration: "none",
              color: Styles.colors.secondary,
              fontWeight: "900",
              padding: "0.5rem",
            }}
          >
            Go back
          </Link>
        </div>
      </Box>
    </Box>
  );
}

export default ForgotPassword;
