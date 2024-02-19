import { Box, Typography } from "@mui/material";
import styles from "../assets/Style";

function NotFound() {
  return (
    <Box sx={{ backgroundColor: styles.colors.primary_dark, padding: "1rem" }}>
      <Typography
        variant="h1"
        sx={{
          color: styles.colors.primary,
          fontSize: "3rem",
          fontWeight: "900",
        }}
      >
        Sorry, page not found :(
      </Typography>
      <Typography
        variant="h6"
        sx={{
          color: styles.colors.primary,
          fontSize: "1.5rem",
          marginTop: "1rem",
        }}
      >
        Please try again!
      </Typography>
    </Box>
  );
}

export default NotFound;
