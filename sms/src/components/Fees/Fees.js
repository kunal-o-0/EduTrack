import { Button, ButtonGroup, Paper, Stack, Typography } from "@mui/material";
import Styles from "../../assets/Style";
import { Link, Outlet } from "react-router-dom";
import { useState } from "react";

function Fees() {
  const [status, setStatus] = useState("");

  const handleCLick = (data) => {
    setStatus(data);
  };

  return (
    <Paper
      sx={{
        position: "absolute",
        display: "flex",
        justifyContent: "center",
        alignItems: "center",
        left: "9rem",
        top: "8rem",
        width: "85%",
        height: "80%",
        bgcolor: Styles.colors.primary,
        overflowY: "auto",
      }}
      elevation={0}
    >
      {status === "" && (
        <Stack sx={{ width: "30%" }} spacing={3}>
          <Link to="show-receipts">
            <Button
              sx={{
                bgcolor: Styles.colors.secondary,
                padding: "0.8rem",
                minHeight: "2rem",
                width: "20rem",
                ":hover": { bgcolor: Styles.colors.secondary_dark },
              }}
              disableRipple
              onClick={(e) => handleCLick("show")}
            >
              <Typography
                variant="h5"
                component="p"
                sx={{
                  color: Styles.colors.primary,
                  fontSize: "1.2rem",
                  fontWeight: "600",
                }}
              >
                Show Payment Receipts
              </Typography>
            </Button>
          </Link>
          <Link to="pay-fees">
            <Button
              sx={{
                bgcolor: Styles.colors.secondary,
                padding: "0.8rem",
                minHeight: "2rem",
                width: "20rem",
                ":hover": { bgcolor: Styles.colors.secondary_dark },
              }}
              disableRipple
              onClick={(e) => handleCLick("pay")}
            >
              <Typography
                variant="h5"
                component="p"
                sx={{
                  color: Styles.colors.primary,
                  fontSize: "1.2rem",
                  fontWeight: "600",
                }}
              >
                Pay Pending Fees
              </Typography>
            </Button>
          </Link>
        </Stack>
      )}

      <Outlet />
    </Paper>
  );
}

export default Fees;
