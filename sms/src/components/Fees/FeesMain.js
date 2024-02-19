import { Button, Stack, Typography } from "@mui/material";
import Styles from "../../assets/Style";
import { Link } from "react-router-dom";

const FeesMain = () => {
  return (
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
  );
};

export default FeesMain;
