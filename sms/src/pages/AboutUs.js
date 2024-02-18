import { Box, Typography } from "@mui/material";

function AboutUs() {
  return (
    <Box sx={{ marginTop: "10rem" }}>
      <Typography
        variant="body1"
        sx={{
          display: "flex",
          justifyContent: "center",
          fontSize: "1.3rem",
        }}
      >
        This is our CDAC project
        <br />
        Title: STUDENT MANAGEMENT SYSTEM
        <br />
        Group members: Tejas Shikare, Kunal Shirode, Abhishek Saptale, Kunal
        Pawar
        <br />
        Hope this is enough ;)
      </Typography>
    </Box>
  );
}

export default AboutUs;
