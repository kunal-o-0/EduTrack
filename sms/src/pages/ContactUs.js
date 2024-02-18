import { Box, Button, Container, TextField, Typography } from "@mui/material";
import SendIcon from "@mui/icons-material/Send";
import styles from "../assets/Style";

function ContactUs() {
  return (
    <Box sx={{ display: "flex", justifyContent: "center" }}>
      <Container
        sx={{
          display: "flex",
          flexDirection: "column",
          width: "60%",
          marginTop: "6rem",
          padding: "1.5rem",
          backgroundColor: styles.colors.primary,
          boxShadow: "0.6rem 0.6rem 0.9rem grey",
        }}
      >
        <Typography
          variant="h5"
          sx={{
            display: "flex",
            justifyContent: "center",
            color: styles.colors.secondary_dark,
          }}
        >
          Send Message to Us
        </Typography>
        <TextField label="Your Name" sx={{ marginTop: "1rem" }} />
        <TextField label="Your Email" sx={{ marginTop: "1rem" }} />
        <TextField label="Message" sx={{ marginTop: "1rem" }} />
        <Button
          variant="contained"
          size="large"
          startIcon={<SendIcon />}
          sx={{
            marginTop: "1rem",
            width: "10rem",
            left: "50%",
            transform: "translateX(-50%)",
          }}
        >
          Send
        </Button>
      </Container>
    </Box>
  );
}

export default ContactUs;
