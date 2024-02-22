import { Box, Typography } from "@mui/material";
import styles from "../../assets/Style";
import { useLocation } from "react-router-dom";

function EditStudent() {
  const location = useLocation();

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
        Edit student {location.state.id}
      </Typography>
    </Box>
  );
}

export default EditStudent;
