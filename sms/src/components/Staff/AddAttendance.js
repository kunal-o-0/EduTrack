import { Box, Typography } from "@mui/material";
import styles from "../../assets/Style";

function AddAttendance() {
  return (
    <Box>
      <Typography
        variant="body1"
        sx={{
          textAlign: "center",
          width: "100%",
          fontSize: "2rem",
          fontWeight: "600",
          color: styles.colors.secondary_dark,
        }}
      >
        Add attendance
      </Typography>
    </Box>
  );
}

export default AddAttendance;
