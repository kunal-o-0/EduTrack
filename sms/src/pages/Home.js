import { Card, CardContent, CardMedia, Typography } from "@mui/material";
import StudentImg from "../assets/Images/student_image.avif";
import AttendanceImg from "../assets/Images/attendance_image.webp";
import FeesPayImg from "../assets/Images/fee_payment.jpg";

const cards = [
  {
    img: StudentImg,
    title: "Easy to Use",
    content:
      "By prioritizing simplicity and accessibility, our system empowers educational institutions to enhance productivity, allowing them to focus on delivering quality education and support to students, all while experiencing the ease and efficiency of our user-friendly solution.",
  },
  {
    img: AttendanceImg,
    title: "Track student attendane",
    content:
      "Our Student Management System provides seamless attendance tracking functionality, allowing educators to effortlessly monitor and record student attendance. By offering a hassle-free attendance tracking solution, we empower educators to spend less time on administrative tasks and more time on engaging with their students, ultimately enhancing overall classroom efficiency and productivity.",
  },
  {
    img: FeesPayImg,
    title: "Hasle-free fee payment",
    content:
      "Our Student Management System facilitates hassle-free fee payment processes, providing a seamless experience for both students and administrators. With intuitive payment portals and secure transaction options, our platform simplifies fee payment management, allowing students and their families to conveniently make payments online. ",
  },
];

function Home() {
  return (
    <>
      {cards.map((card) => {
        return (
          <Card
            elevation={9}
            sx={{
              display: { md: "flex", sm: "block" },
              marginTop: "5rem",
              marginLeft: "5rem",
              marginRight: "5rem",
              marginBottom: "9rem",
            }}
          >
            <CardMedia
              component="img"
              image={card.img}
              sx={{
                height: "20rem",
                maxWidth: "30rem",
                objectFit: "fill",
              }}
            />
            <CardContent>
              <Typography
                variant="body1"
                component="p"
                sx={{
                  fontWeight: "600",
                  fontSize: "2rem",
                  marginBottom: "1rem",
                }}
              >
                {card.title}
              </Typography>
              {card.content}
            </CardContent>
          </Card>
        );
      })}
    </>
  );
}

export default Home;
